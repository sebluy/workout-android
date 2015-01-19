package com.wonderguerrilla.android.workout.workout;

import android.support.v4.app.Fragment;

import com.wonderguerrilla.android.workout.ExerciseListFragment;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class MultipleExerciseWorkout extends Workout {

    private ArrayList<Exercise> mExercises ;
    private WorkoutGenerator mGenerator ;

    public MultipleExerciseWorkout(String name, WorkoutGenerator generator) {
        super(name) ;
        mGenerator = generator ;
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

    public void commit() {
        mGenerator.commit(mExercises) ;
    }

}
