package com.example.vrungel.litera.books_list;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.litera.App;
import com.example.vrungel.litera.base.BasePresenter;
import com.example.vrungel.litera.entity.book_general_info.BookEntity;
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

  private ArrayList<BookEntity> mBookEntitiesAll = new ArrayList<>();
  private ArrayList<BookEntity> mBookEntitiesReadNow = new ArrayList<>();
  private ArrayList<BookEntity> mBookEntitiesArchive = new ArrayList<>();
  private ArrayList<BookEntity> mBookEntitiesChoosen = new ArrayList<>();

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    fetchAllBooks(0);
  }

  public void fetchAllBooks(int selectedItemId) {
    getViewState().startRefreshingView();
    mBookEntitiesReadNow.clear();
    mBookEntitiesArchive.clear();
    mBookEntitiesChoosen.clear();
    Subscription subscription =
        mDataManager.fetchAllbooks(Constants.APP_ANDROID, Constants.DEVICE_ID, Constants.TOKEN,
            Converters.md5("55afee2145b9c467" + Constants.SECRET + Constants.TOKEN), 11)
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
              getViewState().fillInRV(mBookEntitiesReadNow, mBookEntitiesArchive,
                  mBookEntitiesChoosen, selectedItemId);
              getViewState().stopRefreshingView();
            }, Throwable::printStackTrace);
    addToUnsubscription(subscription);
  }

  public void getReadNowBooks() {
    getViewState().fillInCurrentRV(mBookEntitiesReadNow);
  }

  public void getArchiveBooks() {
    getViewState().fillInCurrentRV(mBookEntitiesArchive);
  }

  public void getChoosenBooks() {
    getViewState().fillInCurrentRV(mBookEntitiesChoosen);
  }
}
