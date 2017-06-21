package com.example.vrungel.litera;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.litera.base.BasePresenter;
import com.example.vrungel.litera.entity.BookEntity;
import com.example.vrungel.litera.utils.Constants;
import com.example.vrungel.litera.utils.Converters;
import com.example.vrungel.litera.utils.ThreadSchedulers;
import java.util.ArrayList;
import rx.Observable;
import rx.Subscription;

/**
 * Created by Vrungel on 21.06.2017.
 */

@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

  private String token = "-eCJYBDvXRSPWsnyfhpZWfxsqvUgyBCF";
  private String deviceId = "55afee2145b9c467";
  private String appAndroid = "android";
  private ArrayList<BookEntity> mBookEntitiesAll = new ArrayList<>();
  private ArrayList<BookEntity> mBookEntitiesReadNow = new ArrayList<>();
  private ArrayList<BookEntity> mBookEntitiesArchive = new ArrayList<>();
  private ArrayList<BookEntity> mBookEntitiesChoosen = new ArrayList<>();

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    fetchAllBooks();
  }

  public void fetchAllBooks() {
getViewState().startRefreshingView();
    mBookEntitiesReadNow.clear();
    mBookEntitiesArchive.clear();
    mBookEntitiesChoosen.clear();
    Subscription subscription = mDataManager.fetchAllbooks(appAndroid, deviceId, token,
        Converters.md5("55afee2145b9c467" + Constants.SECRET + token), 11)
        .compose(ThreadSchedulers.applySchedulers())
        .concatMap(Observable::from)
        .concatMap(bookEntity -> {
          if (bookEntity.getLibInfo().getType() == 0) {
            mBookEntitiesReadNow.add(bookEntity);
          }
          if (bookEntity.getLibInfo().getType() == 1) {
            mBookEntitiesArchive.add(bookEntity);
          }
          if (bookEntity.getLibInfo().getType() == 2) {
            mBookEntitiesChoosen.add(bookEntity);
          }
          return Observable.just("");
        })
        .subscribe(bookEntities -> {
          getViewState().fillInRV(mBookEntitiesReadNow);
          getViewState().stopRefreshingView();
        }, Throwable::printStackTrace);
    addToUnsubscription(subscription);
  }

  public void getReadNowBooks() {
    getViewState().fillInRV(mBookEntitiesReadNow);
  }

  public void getArchiveBooks() {
    getViewState().fillInRV(mBookEntitiesArchive);
  }

  public void getChoosenBooks() {
    getViewState().fillInRV(mBookEntitiesChoosen);
  }
}
