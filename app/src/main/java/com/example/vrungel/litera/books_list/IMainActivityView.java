package com.example.vrungel.litera.books_list;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.vrungel.litera.entity.book_general_info.BookEntity;
import java.util.ArrayList;

/**
 * Created by Vrungel on 21.06.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IMainActivityView
    extends MvpView {


  void startRefreshingView();

  void stopRefreshingView();

  void fillInCurrentRV(ArrayList<BookEntity> bookEntitiesChoosen);

  void fillInRV(ArrayList<BookEntity> bookEntitiesReadNow,
      ArrayList<BookEntity> bookEntitiesArchive, ArrayList<BookEntity> bookEntitiesChoosen,
      int selectedItemId);
}