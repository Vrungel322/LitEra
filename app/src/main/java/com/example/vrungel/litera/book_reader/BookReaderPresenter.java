package com.example.vrungel.litera.book_reader;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.litera.App;
import com.example.vrungel.litera.base.BasePresenter;
import com.example.vrungel.litera.utils.Constants;
import com.example.vrungel.litera.utils.Converters;
import com.example.vrungel.litera.utils.ThreadSchedulers;
import rx.Observable;
import rx.Subscription;

/**
 * Created by Vrungel on 22.06.2017.
 */
@InjectViewState public class BookReaderPresenter extends BasePresenter<IBookReaderActivityView> {
  private final String mBookId;
  private StringBuilder stringBuilder;

  public BookReaderPresenter(String bookId) {
    this.mBookId = bookId;
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    stringBuilder = new StringBuilder();
    fetchBook(mBookId);
  }

  public void fetchBook(String bookId) {
    getViewState().showPB();
    Subscription subscription =
        mDataManager.fetchBookByID(bookId, Constants.APP_ANDROID, Constants.DEVICE_ID,
            Constants.TOKEN,
            Converters.md5("55afee2145b9c467" + Constants.SECRET + Constants.TOKEN), 11)
            .compose(ThreadSchedulers.applySchedulers())
            .concatMap(chapter -> {
              for (int i = 0; i < chapter.get(0).getText().size(); i++) {
                stringBuilder.append(chapter.get(0).getText().get(i));
              }
              return Observable.just(stringBuilder.toString()
                  //.replace("<p>", "")
                  //.replace("</p>", "")
                  //.replace("<em>", "")
                  //.replace("</em>", "")
                  //.replace("&ndash", "")
                  //.replace("&hellip", "")
                  //.replace(";", "")
              );
            })
            .subscribe(s -> {
              getViewState().showChapter(s);
              getViewState().hidePB();
            }, throwable -> {
              getViewState().hidePB();
            });
    addToUnsubscription(subscription);
  }
}
