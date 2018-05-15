package com.example.jankro.mealplanner.Data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jankro.mealplanner.Objects.Meal;
import com.example.jankro.mealplanner.R;

import java.util.List;

public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.MealViewHolder> {

    class MealViewHolder extends RecyclerView.ViewHolder {
        private final TextView mealItemView;
        private final TextView healthItemView;
        private final TextView likeRatingItemView;
        private final ImageView likeRatingImageItemView;

        private MealViewHolder(View itemView) {
            super(itemView);
            mealItemView = itemView.findViewById(R.id.meal_name_text);
            healthItemView = itemView.findViewById(R.id.meal_health_rating);
            likeRatingItemView = itemView.findViewById(R.id.likeRatingTextView);
            likeRatingImageItemView = itemView.findViewById(R.id.likeRatingImageView);


        }
    }

    private final LayoutInflater mInflater;
    private List<Meal> mMeals; // Cached copy of words

    public MealListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MealViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        if (mMeals != null) {
            Meal current = mMeals.get(position);
            holder.mealItemView.setText(current.getName());
            String healthRatingText = current.getHealthRating().toString();

            /*if(current.getHealthRating() == 1){
                healthRatingText = "Not good";
                holder.healthItemView.setTextColor(Color.RED);
            }
            if(current.getHealthRating() == 2){
                healthRatingText = "Okay";
                holder.healthItemView.setTextColor(Color.YELLOW);
            }
            if(current.getHealthRating() == 3){
                healthRatingText = "Healthy";
                holder.healthItemView.setTextColor(Color.GREEN);
            }
            */
            holder.healthItemView.setText(healthRatingText);
            holder.likeRatingItemView.setText(getTextBasedOnLikeRating(current.getLikeRating()));
            holder.likeRatingImageItemView.setImageResource(getDrawableBasedOnRating(current.getLikeRating()));
        } else {
            // Covers the case of data not being ready yet.
            holder.mealItemView.setText("No Meal");
        }
    }

    public void setMeals(List<Meal> meal){
        mMeals = meal;
        notifyDataSetChanged();
    }

    public int getTextBasedOnLikeRating(int rating){
        switch (rating){
            case(1):
                return R.string.one_star_rating;
            case(2):
                return R.string.two_star_rating;
            case(3):
                return R.string.three_star_rating;
            case(4):
                return R.string.four_star_rating;
            case(5):
                return R.string.five_star_rating;
            default:
                return 1;

        }
    }


    public int getDrawableBasedOnRating(int rating){
        switch (rating){
            case(1):
                return R.drawable.one_star;

            case(2):
                return R.drawable.two_star;

            case(3):
                return R.drawable.three_star;

            case(4):
                return R.drawable.four_star;

            case(5):
                return R.drawable.five_star;

            default:
                return 1;
        }
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mMeals != null)
            return mMeals.size();
        else return 0;
    }
}
