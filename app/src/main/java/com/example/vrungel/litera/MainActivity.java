package com.example.vrungel.litera;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.litera.base.BaseActivity;
import com.example.vrungel.litera.entity.BookEntity;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements IMainActivityView {

  @InjectPresenter MainActivityPresenter mainActivityPresenter;
  @BindView(R.id.message)  TextView mTextMessage;
  @BindView(R.id.navigation)  BottomNavigationView mBottomNavigationView;
  @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout mSwipeRefreshLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
    mSwipeRefreshLayout.setOnRefreshListener(() -> {
      mainActivityPresenter.fetchAllBooks();
    });

    mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
      switch (item.getItemId()) {
        case R.id.navigation_read:
          mainActivityPresenter.getReadNowBooks();
          return true;
        case R.id.navigation_archive:
          mainActivityPresenter.getArchiveBooks();
          return true;
        case R.id.navigation_choosen:
          mainActivityPresenter.getChoosenBooks();
          return true;
      }
      return false;
    });
  }

  @Override public void fillInRV(ArrayList<BookEntity> bookEntitiesReadNow) {

    mTextMessage.setText(bookEntitiesReadNow.size()+"");
  }

  @Override public void startRefreshingView() {
    if (!mSwipeRefreshLayout.isRefreshing()) mSwipeRefreshLayout.setRefreshing(true);
  }

  @Override public void stopRefreshingView() {
    if (mSwipeRefreshLayout.isRefreshing()) mSwipeRefreshLayout.setRefreshing(false);
  }
}
