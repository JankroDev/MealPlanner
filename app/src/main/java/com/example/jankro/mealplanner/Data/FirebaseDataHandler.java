package com.example.jankro.mealplanner.Data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.jankro.mealplanner.Objects.Meal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirebaseDataHandler {

    public Meal mMeal;

    public FirebaseDataHandler() {

    }

    public void writeMealToDB(Meal meal) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Meals");

        myRef.setValue(meal);
    }


    public List<Meal> getAllMeals() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Meals");

        final List<Meal> mealList = new ArrayList<>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Meal meal = dataSnapshot.getValue(Meal.class);
                mealList.add(meal);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return mealList;
    }
}


