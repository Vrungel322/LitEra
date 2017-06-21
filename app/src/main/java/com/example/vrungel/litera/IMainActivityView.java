package com.example.vrungel.litera;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.vrungel.litera.entity.BookEntity;
import java.util.ArrayList;

/**
 * Created by Vrungel on 21.06.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IMainActivityView
    extends MvpView {

  void fillInRV(ArrayList<BookEntity> bookEntitiesReadNow);

  void startRefreshingView();

  void stopRefreshingView();
}