package com.example.vrungel.litera.data;

/**
 * Created by Vrungel on 21.06.2017.
 */

public class DataManager {
  private RestApi mRestApi;

  public DataManager(RestApi restApi ) {
    this.mRestApi = restApi;

  }
  //
  ////checkin service.
  //
  //public Observable<List<CategoryEntity>> fetchCategory() {
  //  return mRestApi.fetchCategory(Locale.getDefault().getLanguage());
  //}
}
