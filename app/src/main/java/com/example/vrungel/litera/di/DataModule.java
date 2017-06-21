package com.example.vrungel.litera.di;

import com.example.vrungel.litera.data.Api;
import com.example.vrungel.litera.data.RestApi;
import com.example.vrungel.litera.data.DataManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by Vrungel on 21.06.2017.
 */

@Module(includes = { RetrofitModule.class }) public class DataModule {

  @Provides @Singleton Api provideSalonApi(Retrofit retrofit) {
    return retrofit.create(Api.class);
  }

  @Provides @Singleton RestApi provideRestApi(Api api) {
    return new RestApi(api);
  }

  @Provides @Singleton DataManager provideDataManager(RestApi restApi) {
    return new DataManager(restApi);
  }
}
