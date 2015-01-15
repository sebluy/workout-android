package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.Button;

/**
 * Created by sebluy on 12/25/14.
 */

public class Workout {

    private String mName ;
    protected Exercise[] mExercises ;

    public Workout(String name, Exercise[] exercises) {
        mName = name ;
        mExercises = exercises ;
    }

    public void save() {}

    public String getName() {
        return mName ;
    }

    public Exercise getExercise(int index) {
        return mExercises[index] ;
    }

    public int size() {
        return mExercises.length ;
    }

    public String[] getExerciseNames() {
        String[] names = new String[mExercises.length] ;
        for (int i = 0 ; i < names.length ; i++) {
            names[i] = mExercises[i].getName() ;
        }
        return names ;
    }
}
