
package com.example.vrungel.litera.entity.book_general_info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookEntity {

    @SerializedName("lib_info")
    @Expose
    private LibInfo libInfo;
    @SerializedName("book")
    @Expose
    private Book book;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BookEntity() {
    }

    /**
     * 
     * @param book
     * @param libInfo
     */
    public BookEntity(LibInfo libInfo, Book book) {
        super();
        this.libInfo = libInfo;
        this.book = book;
    }

    public LibInfo getLibInfo() {
        return libInfo;
    }

    public void setLibInfo(LibInfo libInfo) {
        this.libInfo = libInfo;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
