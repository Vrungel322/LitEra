package com.example.vrungel.litera;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.widget.TextView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.litera.base.BaseActivity;

public class MainActivity extends BaseActivity implements IMainActivityView {

  @InjectPresenter MainActivityPresenter mainActivityPresenter;
  @BindView(R.id.message)  TextView mTextMessage;
  @BindView(R.id.navigation)  BottomNavigationView mBottomNavigationView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
    mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
      switch (item.getItemId()) {
        case R.id.navigation_read:
          mTextMessage.setText(R.string.title_read);
          return true;
        case R.id.navigation_archive:
          mTextMessage.setText(R.string.title_archive);
          return true;
        case R.id.navigation_choosen:
          mTextMessage.setText(R.string.title_choosen);
          return true;
      }
      return false;
    });
  }
}
