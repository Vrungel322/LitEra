package com.example.vrungel.litera.data;

import com.example.vrungel.litera.entity.book_general_info.BookEntity;
import com.example.vrungel.litera.entity.book_text.Chapter;
import java.util.List;
import rx.Observable;

/**
 * Created by Vrungel on 21.06.2017.
 */

public class DataManager {
  private RestApi mRestApi;

  public DataManager(RestApi restApi) {
    this.mRestApi = restApi;
  }

  public Observable<List<BookEntity>> fetchAllbooks(String android, String deviceId, String token,
      String sign, int version) {
    return mRestApi.fetchAllBooks(android, deviceId, token, sign, version);
  }

  public Observable<List<Chapter>> fetchBookByID(String bookId, String android, String deviceId,
      String token, String sign, int version) {
    return mRestApi.fetchBookByID(bookId, android, deviceId, token, sign, version);
  }
  //
  ////checkin service.
  //
  //public Observable<List<CategoryEntity>> fetchCategory() {
  //  return mRestApi.fetchCategory(Locale.getDefault().getLanguage());
  //}
}
