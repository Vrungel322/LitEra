package com.example.vrungel.litera.di;

import com.example.vrungel.litera.MainActivityPresenter;
import com.example.vrungel.litera.base.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Vrungel on 21.06.2017.
 */

@Singleton @Component(modules = AppModule.class) public interface AppComponent {

  void inject(BaseActivity baseActivity);

  void inject(MainActivityPresenter mainActivityPresenter);
}