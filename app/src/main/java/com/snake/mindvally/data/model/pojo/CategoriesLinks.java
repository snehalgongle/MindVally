package com.snake.mindvally.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesLinks {
    @SerializedName("self")
    @Expose
    private String self;

    @SerializedName("photos")
    @Expose
    private String photos;
}
