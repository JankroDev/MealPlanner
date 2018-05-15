package com.example.jankro.mealplanner.Data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.jankro.mealplanner.Objects.Meal;

@Database(entities = {Meal.class}, version = 3)
public abstract class MealDatabase extends RoomDatabase {

    public abstract MealDao mealDao();

    private static MealDatabase INSTANCE;


    static MealDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MealDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MealDatabase.class, "meal_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final MealDao mDao;

        PopulateDbAsync(MealDatabase db) {
            mDao = db.mealDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Meal meal = new Meal(1,"Alfredo", 5, "Normal", "Noodles, Sauce");
            mDao.insert(meal);
            meal = new Meal(2,"Pizza", 4, "Unhealthy", "Dough, Pepperoni, Sauce, Cheese");
            mDao.insert(meal);
            return null;
        }
    }

}
