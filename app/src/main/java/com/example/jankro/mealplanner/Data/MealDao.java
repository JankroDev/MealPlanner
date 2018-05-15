package com.example.jankro.mealplanner.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.jankro.mealplanner.Objects.Meal;

import java.util.List;

@Dao
public interface MealDao {

    @Insert
    void insert(Meal meal);

    @Query("DELETE from meal_table")
    void deleteAll();

    @Query("DELETE from meal_table WHERE id=(:mealId)")
    void deleteFromTable(int mealId);

    @Query("SELECT * from meal_table ORDER BY meal_name ASC")
    LiveData<List<Meal>> getAllMeals();

}
