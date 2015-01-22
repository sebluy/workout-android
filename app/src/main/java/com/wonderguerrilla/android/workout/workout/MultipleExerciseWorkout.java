package com.wonderguerrilla.android.workout.workout;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class MultipleExerciseWorkout extends Workout {

    private ArrayList<Exercise> mExercises ;

    public MultipleExerciseWorkout(String name, WorkoutController info, ArrayList<Exercise> exercises) {
        super(name, info) ;
        mExercises = exercises ;
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

}
