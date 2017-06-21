package com.example.vrungel.litera;

import android.app.Application;
import com.example.vrungel.litera.di.AppComponent;
import com.example.vrungel.litera.di.AppModule;
import com.example.vrungel.litera.di.DaggerAppComponent;
import shortbread.Shortbread;
import timber.log.Timber;

/**
 * Created by Vrungel on 21.06.2017.
 */

public class App extends Application {
  private static AppComponent sAppComponent;

  public static AppComponent getAppComponent() {
    return sAppComponent;
  }

  @Override public void onCreate() {
    super.onCreate();
    Shortbread.create(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }
}