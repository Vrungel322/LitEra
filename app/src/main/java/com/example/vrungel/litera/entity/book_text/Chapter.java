package com.example.vrungel.litera.entity.book_text;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Chapter {

  @SerializedName("id") @Expose private Integer id;
  @SerializedName("text") @Expose private List<String> text = null;

  /**
   * No args constructor for use in serialization
   */
  public Chapter() {
  }

  /**
   *
   * @param id
   * @param text
   */
  public Chapter(Integer id, List<String> text) {
    super();
    this.id = id;
    this.text = text;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<String> getText() {
    return text;
  }

  public void setText(List<String> text) {
    this.text = text;
  }
}
