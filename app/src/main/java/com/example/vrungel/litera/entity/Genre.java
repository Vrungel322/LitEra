
package com.example.vrungel.litera.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rating_place")
    @Expose
    private Integer ratingPlace;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Genre() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param ratingPlace
     */
    public Genre(Integer id, String name, Integer ratingPlace) {
        super();
        this.id = id;
        this.name = name;
        this.ratingPlace = ratingPlace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRatingPlace() {
        return ratingPlace;
    }

    public void setRatingPlace(Integer ratingPlace) {
        this.ratingPlace = ratingPlace;
    }

}
