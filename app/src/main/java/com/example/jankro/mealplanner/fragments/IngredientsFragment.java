package com.example.jankro.mealplanner.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jankro.mealplanner.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IngredientsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IngredientsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IngredientsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private OnFragmentInteractionListener mListener;

    private Button mNextButton;
    private ListView ingredientsListView;
    private EditText ingredientEditText;
    private ArrayAdapter<String> adapter;

    private ArrayList<String> ingredientList;


    public IngredientsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static IngredientsFragment newInstance() {
        IngredientsFragment fragment = new IngredientsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ingredientList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(container != null){
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        mNextButton = view.findViewById(R.id.ingredientsNextButton);
        ingredientsListView = view.findViewById(R.id.ingredientListView);
        ingredientEditText = view.findViewById(R.id.ingredientEditText);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, ingredientList);
        ingredientsListView.setAdapter(adapter);
        ingredientEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean handled = false;
                if(i == EditorInfo.IME_ACTION_SEND){
                    addIngredient(ingredientEditText.getText().toString());
                    handled = true;
                }
                return handled;
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(ingredientList);
            }
        });
        return view;
    }

    public void addIngredient(String ingredientToAdd){
        if(isValidIngredient(ingredientToAdd)){
            ingredientList.add(ingredientToAdd);
            ingredientEditText.setText("");
            ingredientEditText.requestFocus();
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(getContext(), "Already Added", Toast.LENGTH_LONG).show();
            ingredientEditText.setText("");
        }

    }

    public boolean isValidIngredient(String ingredient){
        if(ingredientList.contains(ingredient)){
            return false;
        }else{
            return true;
        }
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(ArrayList<String> ingredients) {
        if (mListener != null) {
            mListener.onIngredientsInteraction(ingredients);
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
        void onIngredientsInteraction(ArrayList<String> ingredients);
    }
}
