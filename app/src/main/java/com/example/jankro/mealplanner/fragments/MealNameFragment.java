package com.example.jankro.mealplanner.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jankro.mealplanner.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MealNameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MealNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MealNameFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String MEAL_NAME = "meal_name";

    // TODO: Rename and change types of parameters
    private String mMealName;
    Button nextButton;
    EditText mealNameEditText;


    private OnFragmentInteractionListener mListener;

    public MealNameFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MealNameFragment newInstance(String mealName) {
        MealNameFragment fragment = new MealNameFragment();
        Bundle args = new Bundle();
        args.putString(MEAL_NAME, mealName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMealName = getArguments().getString(MEAL_NAME);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meal_name, container, false);

        nextButton = view.findViewById(R.id.mealNameButton);
        mealNameEditText = view.findViewById(R.id.mealNameEditText);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMealName = mealNameEditText.getText().toString();
                goToIngredientsFragment(mMealName);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void goToIngredientsFragment(String mMealName) {
        if (mListener != null) {
            mListener.onFragmentInteraction(mMealName);
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
        void onFragmentInteraction(String mMealName);
    }
}
