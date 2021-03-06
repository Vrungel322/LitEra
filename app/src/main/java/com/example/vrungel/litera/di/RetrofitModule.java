package com.example.vrungel.litera.di;

import com.example.vrungel.litera.BuildConfig;
import com.example.vrungel.litera.utils.Constants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Vrungel on 21.06.2017.
 */

@Module public class RetrofitModule {

  @Provides @Singleton Retrofit provideRetrofit(Converter.Factory converterFactory,
      OkHttpClient okClient) {
    return new Retrofit.Builder().baseUrl(Constants.Remote.BASE_URL)
        .client(okClient)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(converterFactory)
        .build();
  }

  @Provides @Singleton Converter.Factory provideConverterFactory(Gson gson) {
    return GsonConverterFactory.create(gson);
  }

  @Provides @Singleton Gson provideGson() {
    return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .serializeNulls()
        .create();
  }

  @Provides @Singleton OkHttpClient provideOkClient(HttpLoggingInterceptor httpLoggingInterceptor/*,
      Cache cache, @Named("CacheInterceptor") Interceptor cacheInterceptor,
      @Named("OfflineCacheInterceptor") Interceptor offlineCacheInterceptor*/) {
    return new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        //.addInterceptor(offlineCacheInterceptor)
        //.addNetworkInterceptor(cacheInterceptor)
        //.cache(cache)
        .build();
  }

  @Provides @Singleton HttpLoggingInterceptor provideHttpLoggingInterceptor() {
    HttpLoggingInterceptor interceptor =
        new HttpLoggingInterceptor(message -> Timber.tag("response").d(message));
    interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.HEADERS
        : HttpLoggingInterceptor.Level.NONE);
    return interceptor;
  }

  /**
   * For Cache
   */
  /*@Provides @Singleton Cache provideCache(Context context) {
    Cache cache = null;
    try {
      cache = new Cache(new File(context.getCacheDir(), "http-cache"), 10 * 1024 * 1024); // 10 MB
    } catch (Exception e) {
      Timber.e(e, "Could not create Cache!");
    }
    return cache;
  }

  @Provides @Singleton @Named("CacheInterceptor") Interceptor provideCacheInterceptor() {
    return chain -> {
      Request request = chain.request();
      Response response = chain.proceed(chain.request());
      if (request.method().equals("GET")) {
        CacheControl cacheControl = new CacheControl.Builder().maxAge(1, TimeUnit.MINUTES).build();
        response = response.newBuilder()
            .removeHeader("Pragma")
            .header("Cache-Control", cacheControl.toString())
            .build();
      }
      return response;
    };
  }

  @Provides @Singleton @Named("OfflineCacheInterceptor") Interceptor provideOfflineCacheInterceptor(
      Context context) {
    return chain -> {
      Request request = chain.request();
      if (!NetworkUtil.isNetworkConnected(context)) {
        CacheControl cacheControl = new CacheControl.Builder().maxStale(7, TimeUnit.DAYS).build();
        request = request.newBuilder().cacheControl(cacheControl).build();
      }
      return chain.proceed(request);
    };
  }*/
}
