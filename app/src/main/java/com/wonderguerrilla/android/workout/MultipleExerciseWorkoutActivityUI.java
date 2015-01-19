package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;

import com.wonderguerrilla.android.workout.workout.Workout;

/**
 * Created by sebluy on 1/19/15.
 */
public class MultipleExerciseWorkoutActivityUI extends WorkoutActivityUI {

    public MultipleExerciseWorkoutActivityUI(Workout workout) {
        super(workout) ;
    }

    @Override
    public Fragment newFragment() {
        return new ExerciseListFragment() ;
    }

}
