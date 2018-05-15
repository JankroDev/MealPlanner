package com.example.jankro.mealplanner.Data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.jankro.mealplanner.Objects.Meal;

import java.util.List;

public class MealViewModel extends AndroidViewModel {

    private MealRepository mRepository;

    private LiveData<List<Meal>> mAllMeals;

    public MealViewModel(Application application){
        super(application);
        mRepository = new MealRepository(application);
        mAllMeals = mRepository.getAllMeals();
    }

    public LiveData<List<Meal>> getAllMeals() {return mAllMeals;}

    public void insert(Meal meal) {mRepository.insert(meal);}
}
