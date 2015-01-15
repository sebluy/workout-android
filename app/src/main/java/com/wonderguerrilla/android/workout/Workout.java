package com.wonderguerrilla.android.workout;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class Workout {

    private String mName ;
    protected ArrayList<Exercise> mExercises ;

    public Workout(String name, ArrayList<Exercise> exercises) {
        mName = name ;
        mExercises = exercises ;
    }

    public String getName() {
        return mName ;
    }

    public void save() {}

    public void recreate() {}

    public Exercise getExercise(int index) {
        return mExercises.get(index) ;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises ;
    }

    public int size() {
        return mExercises.size() ;
    }

}
