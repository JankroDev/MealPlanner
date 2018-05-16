package com.example.jankro.mealplanner.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.jankro.mealplanner.R;


public class LikeRatingFragment extends Fragment {

    private RatingBar mLikeRatingBar;
    private Button mLikeRatingButton;
    private OnFragmentInteractionListener mListener;

    public LikeRatingFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static LikeRatingFragment newInstance() {
        LikeRatingFragment fragment = new LikeRatingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container!=null){
            container.removeAllViews();
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_like_rating, container, false);
        mLikeRatingBar = view.findViewById(R.id.likeRatingBar);
        mLikeRatingButton = view.findViewById(R.id.likeRatingNextButton);
        mLikeRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int likeRating = mLikeRatingBar.getNumStars();
                onLikeRating(likeRating);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onLikeRating(int likeRating) {
        if (mListener != null) {
            mListener.onLikeRatingInteraction(likeRating);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onLikeRatingInteraction(int likeRating);
    }
}
