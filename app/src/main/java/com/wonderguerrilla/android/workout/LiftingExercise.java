package com.wonderguerrilla.android.workout;

import android.view.View;
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

    @Override
    public int getLayout() {
        return R.layout.fragment_lifting_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view);

        TextView weight = (TextView)view.findViewById(R.id.lifting_exercise_weight) ;
        TextView repetitions = (TextView)view.findViewById(R.id.lifting_exercise_repetitions) ;

        weight.setText(mWeight + " " + mUnit) ;
        repetitions.setText(mRepetitions + " Repetitions") ;

    }
}
