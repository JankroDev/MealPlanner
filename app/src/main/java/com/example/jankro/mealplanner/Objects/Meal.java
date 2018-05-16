package com.example.jankro.mealplanner.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;


public class Meal {

    private int id;

    private String name;

    private int likeRating;

    private String healthRating;

    private ArrayList<String> ingredients;

    public Meal(){

    }

    public Meal(int id, String name, int likeRating, String healthRating, ArrayList<String> ingredients) {
        this.id = id;
        this.name = name;
        this.likeRating = likeRating;
        this.healthRating = healthRating;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public int getLikeRating() {
        return likeRating;
    }

    public String getHealthRating() {
        return healthRating;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public int getId() {
        return id;
    }


}
