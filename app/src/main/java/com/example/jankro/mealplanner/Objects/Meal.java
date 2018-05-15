package com.example.jankro.mealplanner.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "meal_table")
public class Meal {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "meal_name")
    private String name;

    @NonNull
    @ColumnInfo(name = "like_rating")
    private int likeRating;

    @NonNull
    @ColumnInfo(name = "health_rating")
    private String healthRating;

    @NonNull
    @ColumnInfo(name = "ingredients")
    private String ingredients;

    public Meal(int id, @NonNull String name, @NonNull int likeRating, @NonNull String healthRating, @NonNull String ingredients) {
        this.id = id;
        this.name = name;
        this.likeRating = likeRating;
        this.healthRating = healthRating;
        this.ingredients = ingredients;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public int getLikeRating() {
        return likeRating;
    }

    @NonNull
    public String getHealthRating() {
        return healthRating;
    }

    @NonNull
    public String getIngredients() {
        return ingredients;
    }

    public int getId() {
        return id;
    }


}
