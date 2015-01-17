package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class MultipleExerciseWorkout extends Workout {

    private ArrayList<Exercise> mExercises ;
    private WorkoutGenerator mGenerator ;
    private WorkoutStorage mStorage ;

    public MultipleExerciseWorkout(String name, WorkoutGenerator generator, WorkoutStorage storage) {
        super(name) ;
        mGenerator = generator ;
        mStorage = storage ;
        recreate() ;
    }

    public Exercise getExercise(int index) {
        return mExercises.get(index) ;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises ;
    }

    public int size() {
        return mExercises.size() ;
    }

    public void recreate() {
        mExercises = mGenerator.generateExercises() ;
    }

    public void save() {}

    public Fragment newFragment() {
        return new ExerciseListFragment() ;
    }
}
