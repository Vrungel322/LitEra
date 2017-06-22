package com.example.vrungel.litera;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.vrungel.litera.entity.BookEntity;
import com.example.vrungel.litera.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Credentials;

/**
 * Created by Vrungel on 22.06.2017.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

  private ArrayList<BookEntity> mBooksEntities = new ArrayList<>();

  public void addListBookEntity(List<BookEntity> bookEntities) {
    mBooksEntities.clear();
    mBooksEntities.addAll(bookEntities);
    notifyDataSetChanged();
  }

  @Override public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new BooksViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false));
  }

  @Override public void onBindViewHolder(BooksViewHolder holder, int position) {
    GlideUrl glideUrl = new GlideUrl(mBooksEntities.get(position).getBook().getCover(),
        new LazyHeaders.Builder().addHeader("Authorization", Credentials.basic("litdev", "R0zr@B"))
            .build());
    Glide.with(holder.mImageViewBookPhoto.getContext())
        .load(glideUrl)
        .into(holder.mImageViewBookPhoto);
    holder.mImageViewBookName.setText(mBooksEntities.get(position).getBook().getTitle());
    holder.mImageViewAuthor.setText(mBooksEntities.get(position).getBook().getAuthorName());
    StringBuilder stringBuilder = new StringBuilder();
    for (Genre genre : mBooksEntities.get(position).getBook().getGenres()) {
      stringBuilder.append(genre.getName());
      stringBuilder.append(" ");
    }
    holder.mImageViewGenre.setText(stringBuilder.toString());
  }

  @Override public int getItemCount() {
    return mBooksEntities.size();
  }

  static class BooksViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ivBookPhoto) ImageView mImageViewBookPhoto;
    @BindView(R.id.tvBookName) TextView mImageViewBookName;
    @BindView(R.id.tvAuthor) TextView mImageViewAuthor;
    @BindView(R.id.tvGenre) TextView mImageViewGenre;

    BooksViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
