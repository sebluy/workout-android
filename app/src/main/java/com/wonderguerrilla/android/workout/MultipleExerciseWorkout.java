package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class MultipleExerciseWorkout extends Workout {

    protected ArrayList<Exercise> mExercises ;

    public MultipleExerciseWorkout(String name, ArrayList<Exercise> exercises) {
        super(name) ;
        mExercises = exercises ;
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

    public Fragment newFragment() {
        return new ExerciseListFragment() ;
    }
}
