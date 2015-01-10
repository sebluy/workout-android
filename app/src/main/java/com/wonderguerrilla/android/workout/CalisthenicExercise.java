package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExercise extends Exercise {

    private int mRepetitions ;

    public CalisthenicExercise(String name, int repetitions) {
        super(name) ;
        mRepetitions = repetitions ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_calisthenic_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;

        TextView repetitions = (TextView)view.findViewById(R.id.calisthenic_exercise_repetitions) ;
        repetitions.setText(mRepetitions + " Repetitions") ;
    }
}
