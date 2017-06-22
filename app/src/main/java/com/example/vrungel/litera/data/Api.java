package com.example.vrungel.litera.data;

import com.example.vrungel.litera.entity.book_general_info.BookEntity;
import com.example.vrungel.litera.entity.book_text.Chapter;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Vrungel on 21.06.2017.
 */

public interface Api {
  @GET("v1/library/get") Observable<List<BookEntity>> fetchAllBooks(@Query("app") String app,
      @Query("device_id") String device_id, @Query("user_token") String user_token,
      @Query("sign") String sign, @Query("version") int version);

  @GET("/v1/book/get-text/{bookId}") Observable<List<Chapter>> fetchBookByID(
      @Path("bookId") String bookId, @Query("app") String app, @Query("device_id") String device_id,
      @Query("user_token") String user_token, @Query("sign") String sign,
      @Query("version") int version,@Query("debug") int needToBe_1);

  //@GET("api/v1/categories/") Observable<List<CategoryEntity>> fetchCategory(
  //    @Header("lng") String language);
}
