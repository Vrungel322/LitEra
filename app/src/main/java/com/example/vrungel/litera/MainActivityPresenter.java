package com.example.vrungel.litera;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.litera.base.BasePresenter;
import com.example.vrungel.litera.utils.Constants;
import com.example.vrungel.litera.utils.Converters;
import com.example.vrungel.litera.utils.ThreadSchedulers;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Vrungel on 21.06.2017.
 */

@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

  private String token = "-eCJYBDvXRSPWsnyfhpZWfxsqvUgyBCF";
  private String deviceId = "55afee2145b9c467";
  private String appAndroid = "android";

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    fetchAllBooks();
  }

  private void fetchAllBooks() {
    Subscription subscription = mDataManager.fetchAllbooks(appAndroid, deviceId, token,
        Converters.md5("55afee2145b9c467" + Constants.SECRET + token), 11)
        .compose(ThreadSchedulers.applySchedulers())
        .subscribe(bookEntities -> {
          Timber.e(String.valueOf(bookEntities.size()));
        }, Throwable::printStackTrace);
    addToUnsubscription(subscription);
  }
}
