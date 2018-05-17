package com.example.jankro.mealplanner.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.jankro.mealplanner.Data.FirebaseDataHandler;
import com.example.jankro.mealplanner.LandingActivity;
import com.example.jankro.mealplanner.Objects.Meal;
import com.example.jankro.mealplanner.R;
import com.example.jankro.mealplanner.fragments.HealthRatingFragment;
import com.example.jankro.mealplanner.fragments.IngredientsFragment;
import com.example.jankro.mealplanner.fragments.LikeRatingFragment;
import com.example.jankro.mealplanner.fragments.MealNameFragment;

import java.util.ArrayList;

public class AddMealActivity extends AppCompatActivity implements MealNameFragment.OnFragmentInteractionListener, IngredientsFragment.OnFragmentInteractionListener, HealthRatingFragment.OnFragmentInteractionListener, LikeRatingFragment.OnFragmentInteractionListener{

    public String mMealName;
    public ArrayList<String> mIngredients;
    public String mHealthRating;
    public int mLikeRating;



    FrameLayout fragmentContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_meal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentContainer = findViewById(R.id.fragment_container);

        openMealNameFragment();


    }

    private void completeMealAddition(){
        FirebaseDataHandler dataHandler = new FirebaseDataHandler();
        // Need to add firebase so this can store the ingredients as a list
        Meal mealToAdd = new Meal(0, mMealName, mLikeRating, mHealthRating, mIngredients );
        dataHandler.writeMealToDB(mealToAdd);
        Intent i = new Intent(this, LandingActivity.class);
        startActivity(i);
    }
    private void openMealNameFragment(){
        String pass = "";
        MealNameFragment mealNameFragment = MealNameFragment.newInstance(pass);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, mealNameFragment, "MEAL_FRAGMENT").commit();
    }

    @Override
    public void onFragmentInteraction(String mealName) {
        mMealName = mealName;
        openIngredientsFragment();
    }

    private void openIngredientsFragment(){
        IngredientsFragment mealNameFragment = IngredientsFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, mealNameFragment, "INGREDIENT_FRAGMENT").commit();
    }

    private void openHealthRatingFragment(){
        HealthRatingFragment mealNameFragment = HealthRatingFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, mealNameFragment, "HEALTH_RATING_FRAGMENT").commit();
    }

    private void openLikeRatingFragment(){
        LikeRatingFragment mealNameFragment = LikeRatingFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, mealNameFragment, "LIKE_RATING_FRAGMENT").commit();
    }
    @Override
    public void onIngredientsInteraction(ArrayList<String> ingredients) {
        mIngredients = ingredients;
        openHealthRatingFragment();
    }

    @Override
    public void onHealthRatingInteraction(String healthRating) {
        mHealthRating = healthRating;
        openLikeRatingFragment();
    }

    @Override
    public void onLikeRatingInteraction(int likeRating) {
        mLikeRating = likeRating;
        completeMealAddition();
    }
}
