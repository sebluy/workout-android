package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExercise implements Exercise {

    private String mName ;
    private int mRepetitions ;

    public CalisthenicExercise(String name, int repetitions) {
        mName = name ;
        mRepetitions = repetitions ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_calisthenic_exercise ;
    }

    @Override
    public void fillLayout(View v) {

        TextView name = (TextView)v.findViewById(R.id.calisthenic_exercise_name) ;
        TextView repetitions = (TextView)v.findViewById(R.id.calisthenic_exercise_repetitions) ;

        name.setText(mName) ;
        repetitions.setText(mRepetitions + " Repetitions") ;

    }
}
