package com.wonderguerrilla.android.workout.workout.calisthenic;

import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.R;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExercise extends Exercise {

    private int mRepetitions ;

    public CalisthenicExercise(String name, int repetitions) {
        super(name) ;
        mRepetitions = repetitions ;
    }

    public int getRepetitions() {
        return mRepetitions;
    }
}
