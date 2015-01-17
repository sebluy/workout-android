package com.wonderguerrilla.android.workout;

import android.content.Context;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkout {

    public static final String NAME = "Static Core" ;

    private static MultipleExerciseWorkout sWorkout ;

    public static MultipleExerciseWorkout get(Context context) {
        if (sWorkout == null) {
            sWorkout = newInstance(context) ;
        }
        return sWorkout ;
    }

    private static MultipleExerciseWorkout newInstance(Context context) {
        StaticCoreWorkoutGenerator generator = new StaticCoreWorkoutGenerator(context) ;
        return new MultipleExerciseWorkout(NAME, generator) ;
    }

}
