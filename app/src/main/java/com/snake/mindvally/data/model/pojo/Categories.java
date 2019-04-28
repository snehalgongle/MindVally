package com.snake.mindvally.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("photo_count")
    @Expose
    private long photoCount;

    @SerializedName("links")
    @Expose
    private CategoriesLinks categoriesLinks;
}
