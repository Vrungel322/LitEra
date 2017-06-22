package com.example.vrungel.litera.book_reader;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Vrungel on 22.06.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IBookReaderActivityView
    extends MvpView {
  void showPB();

  void hidePB();

  void showChapter(String string);
}
