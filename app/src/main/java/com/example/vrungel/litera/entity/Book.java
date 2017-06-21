
package com.example.vrungel.litera.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author_id")
    @Expose
    private Integer authorId;
    @SerializedName("author_name")
    @Expose
    private String authorName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;
    @SerializedName("annotation")
    @Expose
    private String annotation;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("finished_at")
    @Expose
    private Integer finishedAt;
    @SerializedName("last_update")
    @Expose
    private Integer lastUpdate;
    @SerializedName("adult_only")
    @Expose
    private Boolean adultOnly;
    @SerializedName("book_active")
    @Expose
    private Boolean bookActive;
    @SerializedName("intro")
    @Expose
    private Boolean intro;
    @SerializedName("free_chapters")
    @Expose
    private Integer freeChapters;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("rewards")
    @Expose
    private Integer rewards;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("in_libraries")
    @Expose
    private Integer inLibraries;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("allow_comments")
    @Expose
    private Boolean allowComments;
    @SerializedName("total_chr_length")
    @Expose
    private Integer totalChrLength;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("blocked")
    @Expose
    private Boolean blocked;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("liked")
    @Expose
    private Boolean liked;
    @SerializedName("rewarded")
    @Expose
    private Boolean rewarded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Book() {
    }

    /**
     * 
     * @param genres
     * @param lastUpdate
     * @param bookActive
     * @param type
     * @param totalChrLength
     * @param authorId
     * @param annotation
     * @param id
     * @param cover
     * @param title
     * @param createdAt
     * @param blocked
     * @param tags
     * @param liked
     * @param pages
     * @param rewards
     * @param rewarded
     * @param url
     * @param intro
     * @param inLibraries
     * @param adultOnly
     * @param price
     * @param views
     * @param finishedAt
     * @param authorName
     * @param likes
     * @param freeChapters
     * @param allowComments
     * @param rating
     * @param comments
     */
    public Book(Integer id, String title, Integer authorId, String authorName, String type, List<Genre> genres, List<Tag> tags, String annotation, String cover, Integer createdAt, Integer finishedAt, Integer lastUpdate, Boolean adultOnly, Boolean bookActive, Boolean intro, Integer freeChapters, Integer rating, Integer likes, Integer rewards, Integer views, Integer inLibraries, Integer comments, Boolean allowComments, Integer totalChrLength, Integer pages, Integer price, Boolean blocked, String url, Boolean liked, Boolean rewarded) {
        super();
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.authorName = authorName;
        this.type = type;
        this.genres = genres;
        this.tags = tags;
        this.annotation = annotation;
        this.cover = cover;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.lastUpdate = lastUpdate;
        this.adultOnly = adultOnly;
        this.bookActive = bookActive;
        this.intro = intro;
        this.freeChapters = freeChapters;
        this.rating = rating;
        this.likes = likes;
        this.rewards = rewards;
        this.views = views;
        this.inLibraries = inLibraries;
        this.comments = comments;
        this.allowComments = allowComments;
        this.totalChrLength = totalChrLength;
        this.pages = pages;
        this.price = price;
        this.blocked = blocked;
        this.url = url;
        this.liked = liked;
        this.rewarded = rewarded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Integer finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getAdultOnly() {
        return adultOnly;
    }

    public void setAdultOnly(Boolean adultOnly) {
        this.adultOnly = adultOnly;
    }

    public Boolean getBookActive() {
        return bookActive;
    }

    public void setBookActive(Boolean bookActive) {
        this.bookActive = bookActive;
    }

    public Boolean getIntro() {
        return intro;
    }

    public void setIntro(Boolean intro) {
        this.intro = intro;
    }

    public Integer getFreeChapters() {
        return freeChapters;
    }

    public void setFreeChapters(Integer freeChapters) {
        this.freeChapters = freeChapters;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getInLibraries() {
        return inLibraries;
    }

    public void setInLibraries(Integer inLibraries) {
        this.inLibraries = inLibraries;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Boolean getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(Boolean allowComments) {
        this.allowComments = allowComments;
    }

    public Integer getTotalChrLength() {
        return totalChrLength;
    }

    public void setTotalChrLength(Integer totalChrLength) {
        this.totalChrLength = totalChrLength;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Boolean getRewarded() {
        return rewarded;
    }

    public void setRewarded(Boolean rewarded) {
        this.rewarded = rewarded;
    }

}
