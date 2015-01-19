package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;

import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;

/**
 * Created by sebluy on 1/19/15.
 */
public class WorkoutUI {

    public static WorkoutUI get(Workout workout) {
        //if (workout.getClass() == MultipleExerciseWorkout.class) {
        //    return new MultipleExerciseWorkoutUI(workout) ;
        //} else {
            return new WorkoutUI(workout) ;
        //}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Workout mWorkout;

    public WorkoutUI(Workout workout) {
        mWorkout = workout ;
    }

    public Fragment newFragment() {
        return new WorkoutFragment() ;
    }

    public String getTitle() {
        return mWorkout.getName() ;
    }

}
