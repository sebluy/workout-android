package com.wonderguerrilla.android.workout;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkout {

    public static final String NAME = "Static Core Workout" ;

    private static final int CIRCUITS = 2 ;

    private static Workout sWorkout ;

    private static final StaticCoreExercise[] CORE_EXERCISES = {
            new StaticCoreExercise("Bridge", 30),
            new StaticCoreExercise("Plank", 30),
            new StaticCoreExercise("Side Plank", 30),
            new StaticCoreExercise("Bird Dog", 30),
            new StaticCoreExercise("Superman", 30),
            new StaticCoreExercise("Leg Lever", 30)
    } ;

    public static Workout get() {
        if (sWorkout == null) {
            sWorkout = generate() ;
        }
        return sWorkout ;
    }

    private static Workout generate() {
        ArrayList<Exercise> exercises = new ArrayList<>(CORE_EXERCISES.length * CIRCUITS) ;
        for (int i = 0 ; i < CIRCUITS ; i++) {
            exercises.addAll(Arrays.asList(CORE_EXERCISES)) ;
        }
        return new Workout(NAME, exercises) ;
    }
}
