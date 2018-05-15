package com.example.jankro.mealplanner.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jankro.mealplanner.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HealthRatingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HealthRatingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HealthRatingFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    RadioGroup mHealthButtonGroup;
    RadioButton mHealthyButton;
    RadioButton mNormalButton;
    RadioButton mUnhealthyButton;
    Button mNextButton;

    public HealthRatingFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HealthRatingFragment newInstance() {
        HealthRatingFragment fragment = new HealthRatingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(container != null){
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.fragment_health_rating, container, false);
        mHealthButtonGroup = view.findViewById(R.id.healthRatingGroup);
        mHealthyButton = view.findViewById(R.id.healthyRadioButton);
        mNormalButton = view.findViewById(R.id.normalRadioButton);
        mUnhealthyButton = view.findViewById(R.id.unhealthyRadioButton);
        mNextButton = view.findViewById(R.id.healthRatingNextButton);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int selectedId =  mHealthButtonGroup.getCheckedRadioButtonId();
            RadioButton chosenRating = view.findViewById(selectedId);
            onButtonPressed(chosenRating.getText().toString());



            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String healthRating) {
        if (mListener != null) {
            mListener.onHealthRatingInteraction(healthRating);
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
        void onHealthRatingInteraction(String healthRating);
    }
}
