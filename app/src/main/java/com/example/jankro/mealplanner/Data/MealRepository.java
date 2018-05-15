package com.example.jankro.mealplanner.Data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.jankro.mealplanner.Objects.Meal;

import java.util.List;

public class MealRepository {

    private MealDao mMealDoa;
    private LiveData<List<Meal>> mAllMeals;

    MealRepository(Application application) {
        MealDatabase db = MealDatabase.getDatabase(application);
        mMealDoa = db.mealDao();
        mAllMeals = mMealDoa.getAllMeals();
    }

    LiveData<List<Meal>> getAllMeals() {
        return mAllMeals;
    }


    public void insert (Meal meal) {
        new insertAsyncTask(mMealDoa).execute(meal);
    }

    private static class insertAsyncTask extends AsyncTask<Meal, Void, Void> {

        private MealDao mAsyncTaskDao;

        insertAsyncTask(MealDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Meal... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}