package com.wonderguerrilla.android.workout;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExercise extends Exercise {

    int mWeight ;
    String mUnit ;
    int mRepetitions ;

    public LiftingExercise(String name, int weight, String unit, int repetitions) {
        super(name) ;
        mWeight = weight ;
        mUnit = unit ;
        mRepetitions = repetitions ;
    }

    public LiftingExercise(String name, JSONObject object) {
        super(name) ;

        try {

            mRepetitions = object.getInt("Repetitions") ;
            mUnit = object.getString("Unit") ;
            mWeight = object.getInt("Weight") ;

        } catch (JSONException e) {
        }
    }

    public JSONObject toJSON() {
        JSONObject object = super.toJSON() ;
        try {
            object.put("Repetitions", mRepetitions);
            object.put("Unit", mUnit) ;
            object.put("Weight", mWeight) ;
        } catch (Exception e) {}
        return object ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_lifting_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view);

        TextView weight = (TextView)view.findViewById(R.id.lifting_exercise_weight) ;
        EditText repetitions = (EditText)view.findViewById(R.id.lifting_exercise_repetitions) ;
        repetitions.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRepetitions = Integer.parseInt(s.toString()) ;
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        weight.setText(mWeight + " " + mUnit) ;
        repetitions.setText(String.valueOf(mRepetitions)) ;

    }
}
