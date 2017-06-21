package com.example.vrungel.litera;

import android.os.Handler;
import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.litera.base.BasePresenter;

/**
 * Created by Vrungel on 21.06.2017.
 */

@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

}
