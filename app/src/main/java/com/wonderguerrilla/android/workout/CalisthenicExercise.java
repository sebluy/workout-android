package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExercise implements Exercise {

    private String mName ;
    int mRepetitions ;
    String mSpeed ; /* perhaps use enum for speed */

    public CalisthenicExercise(String name, int repetitions, String speed) {
        mName = name ;
        mRepetitions = repetitions ;
        mSpeed = speed ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_calisthenic_exercise ;
    }

    @Override
    public void fillLayout(View v) {

        TextView name = (TextView)v.findViewById(R.id.calisthenic_exercise_name) ;
        TextView reps = (TextView)v.findViewById(R.id.calisthenic_exercise_repetitions) ;
        TextView speed = (TextView)v.findViewById(R.id.calisthenic_exercise_speed) ;

        name.setText(mName) ;
        reps.setText(mRepetitions + " Repetitions") ;
        speed.setText(mSpeed) ;

    }
}
