package com.wonderguerrilla.android.workout;

import android.content.Context;
/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout {

    public static final String LOWER_NAME = "Lower Lifting" ;
    public static final String UPPER_NAME = "Upper Lifting" ;

    private static MultipleExerciseWorkout newUpper(Context context) {
        return new MultipleExerciseWorkout(UPPER_NAME, LiftingWorkoutGenerator.getUpper(context)) ;
    }

    private static MultipleExerciseWorkout newLower(Context context) {
        return new MultipleExerciseWorkout(LOWER_NAME, LiftingWorkoutGenerator.getLower(context)) ;
    }

}
