package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExercise implements Exercise {

    private String mName ;
    int mWeight ;
    String mUnit ;
    int mRepetitions ;

    public LiftingExercise(String name, int weight, String unit, int repetitions) {
        mName = name ;
        mWeight = weight ;
        mUnit = unit ;
        mRepetitions = repetitions ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_lifting_exercise ;
    }

    @Override
    public void fillLayout(View v) {

        TextView name = (TextView)v.findViewById(R.id.lifting_exercise_name) ;
        TextView weight = (TextView)v.findViewById(R.id.lifting_exercise_weight) ;
        TextView repetitions = (TextView)v.findViewById(R.id.lifting_exercise_repetitions) ;

        name.setText(mName) ;
        weight.setText(mWeight + " " + mUnit) ;
        repetitions.setText(mRepetitions + " Repetitions") ;

    }
}
