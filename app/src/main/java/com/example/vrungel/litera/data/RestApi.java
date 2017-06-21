package com.example.vrungel.litera.data;

import com.example.vrungel.litera.entity.BookEntity;
import java.util.List;
import rx.Observable;

/**
 * Created by Vrungel on 21.06.2017.
 */

public class RestApi {
  private final Api api;

  public RestApi(Api api) {
    this.api = api;
  }

  public Observable<List<BookEntity>> fetchAllBooks(String android, String deviceId, String token,
      String sign, int version) {
    return api.fetchAllBooks(android,deviceId,token,sign,version);
  }

  //public Observable<List<CategoryEntity>> fetchCategory(String language) {
  //  return api.fetchCategory(language);
  //}

}

