package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.support.v4.app.Fragment;

import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.MultipleExerciseWorkoutActivityUI;
import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;

/**
 * Created by sebluy on 1/19/15.
 */
public class WorkoutActivityUI {

    public static WorkoutActivityUI get(Workout workout) {
        if (workout.getClass() == MultipleExerciseWorkout.class) {
            return new MultipleExerciseWorkoutActivityUI(workout) ;
        } else {
            return new WorkoutActivityUI(workout) ;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Workout mWorkout;

    public WorkoutActivityUI(Workout workout) {
        mWorkout = workout ;
    }

    public Fragment newFragment() {
        return new WorkoutFragment() ;
    }

    public String getTitle() {
        return mWorkout.getName() ;
    }

}
