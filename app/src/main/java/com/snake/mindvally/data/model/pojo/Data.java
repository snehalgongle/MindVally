package com.snake.mindvally.data.model.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("width")
    @Expose
    private String width;

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("color")
    @Expose
    private String color;

    @SerializedName("likes")
    @Expose
    private int likes;

    @SerializedName("likes_by_user")
    @Expose
    private boolean likesByUser;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("current_user_collections")
    @Expose
    private List<CurrentUserCollection> currentUserCollection;

    @SerializedName("urls")
    @Expose
    private Urls urls;

    @SerializedName("categories")
    @Expose
    private List<Categories> categories;

    @SerializedName("links")
    @Expose
    private Links links;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLikesByUser() {
        return likesByUser;
    }

    public void setLikesByUser(boolean likesByUser) {
        this.likesByUser = likesByUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CurrentUserCollection> getCurrentUserCollection() {
        return currentUserCollection;
    }

    public void setCurrentUserCollection(List<CurrentUserCollection> currentUserCollection) {
        this.currentUserCollection = currentUserCollection;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
