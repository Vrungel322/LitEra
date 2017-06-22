package com.example.vrungel.litera;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.litera.base.BaseActivity;
import com.example.vrungel.litera.entity.BookEntity;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements IMainActivityView {

  @InjectPresenter MainActivityPresenter mainActivityPresenter;
  @BindView(R.id.message) TextView mTextMessage;
  @BindView(R.id.navigation) BottomNavigationView mBottomNavigationView;
  @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout mSwipeRefreshLayout;
  @BindView(R.id.rvBooks) RecyclerView mRecyclerView;
  private BooksAdapter mBooksAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
    mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    mBooksAdapter = new BooksAdapter();
    mRecyclerView.setAdapter(mBooksAdapter);

    mSwipeRefreshLayout.setOnRefreshListener(() -> {
      mainActivityPresenter.fetchAllBooks(mBottomNavigationView.getSelectedItemId());
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

  @Override public void fillInRV(ArrayList<BookEntity> entitiesReadNow,
      ArrayList<BookEntity> bookEntitiesArchive, ArrayList<BookEntity> bookEntitiesChoosen,
      int selectedItemId) {

    switch (selectedItemId) {
      case 0:
        mTextMessage.setText(entitiesReadNow.size() + "");
        mBooksAdapter.addListBookEntity(entitiesReadNow);
        break;
      case R.id.navigation_read:
        mTextMessage.setText(entitiesReadNow.size() + "");
        mBooksAdapter.addListBookEntity(entitiesReadNow);
        break;
      case R.id.navigation_archive:
        mTextMessage.setText(bookEntitiesArchive.size() + "");
        mBooksAdapter.addListBookEntity(bookEntitiesArchive);
        break;
      case R.id.navigation_choosen:
        mTextMessage.setText(bookEntitiesChoosen.size() + "");
        mBooksAdapter.addListBookEntity(bookEntitiesChoosen);
        break;
    }
  }

  @Override public void startRefreshingView() {
    if (!mSwipeRefreshLayout.isRefreshing()) mSwipeRefreshLayout.setRefreshing(true);
  }

  @Override public void stopRefreshingView() {
    if (mSwipeRefreshLayout.isRefreshing()) mSwipeRefreshLayout.setRefreshing(false);
  }

  @Override public void fillInCurrentRV(ArrayList<BookEntity> bookEntities) {
    mBooksAdapter.addListBookEntity(bookEntities);
  }
}
