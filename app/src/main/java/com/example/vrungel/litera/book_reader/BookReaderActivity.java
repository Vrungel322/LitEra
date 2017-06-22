package com.example.vrungel.litera.book_reader;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.vrungel.litera.R;
import com.example.vrungel.litera.base.BaseActivity;
import com.example.vrungel.litera.utils.Constants;

public class BookReaderActivity extends BaseActivity implements IBookReaderActivityView {

  @InjectPresenter BookReaderPresenter mBookReaderPresenter;
  @BindView(R.id.tvChater) WebView mTextViewChapter;
  @BindView(R.id.progressBar) ProgressBar mProgressBar;

  @ProvidePresenter public BookReaderPresenter providePresenter() {
    return new BookReaderPresenter(getIntent().getExtras().getString(Constants.BOOK_ID, ""));
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_book_reader);
    super.onCreate(savedInstanceState);
  }

  @Override public void showPB() {
    mProgressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hidePB() {
    mProgressBar.setVisibility(View.GONE);
  }

  @Override public void showChapter(String fullChapter) {
    //mTextViewChapter.setText(fullChapter);
    mTextViewChapter.getSettings().setJavaScriptEnabled(true);
    mTextViewChapter.loadDataWithBaseURL("", fullChapter, "text/html", "UTF-8", "");
  }
}
