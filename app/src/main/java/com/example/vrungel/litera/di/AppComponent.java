package com.example.vrungel.litera.di;

import com.example.vrungel.litera.book_reader.BookReaderPresenter;
import com.example.vrungel.litera.books_list.MainActivityPresenter;
import com.example.vrungel.litera.base.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Vrungel on 21.06.2017.
 */

@Singleton @Component(modules = AppModule.class) public interface AppComponent {

  void inject(BaseActivity baseActivity);

  void inject(MainActivityPresenter mainActivityPresenter);

  void inject(BookReaderPresenter bookReaderPresenter);
}