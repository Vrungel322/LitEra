package com.example.vrungel.litera.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.util.TypedValue;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.vrungel.litera.App;
import com.example.vrungel.litera.R;
import com.tapadoo.alerter.Alerter;
import javax.inject.Inject;

/**
 * Created by Vrungel on 21.06.2017.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

  @Inject protected Context mContext;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    App.getAppComponent().inject(this);
  }

  protected void showAlertMessage(String title, String message) {
    TypedValue value = new TypedValue();
    getTheme().resolveAttribute(R.attr.colorAccent, value, true);
    Alerter.create(this).setTitle(title).setText(message).setBackgroundColor(value.resourceId)
        .setOnClickListener(view -> {
        })
        .show();
  }

  protected void showToastMessage(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }

  protected void showToastMessage(@StringRes int id) {
    Toast.makeText(mContext, id, Toast.LENGTH_SHORT).show();
  }

  public void setTitleAppBar(@StringRes int resId) {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(resId);
    }
  }

  public void setIconAppBar(@DrawableRes int resId) {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeAsUpIndicator(resId);
    }
  }
}