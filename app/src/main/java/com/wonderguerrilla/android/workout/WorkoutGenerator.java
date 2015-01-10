package com.wonderguerrilla.android.workout;

import android.content.Context;

import java.util.HashMap;
import java.util.Set;

public class WorkoutGenerator {

    private static HashMap<String, Workout> sWorkouts = new HashMap<String, Workout>() ;

    private static String[] sWorkoutNames = {
        CalisthenicWorkout.NAME,
        LiftingWorkout.UPPER_NAME,
        LiftingWorkout.LOWER_NAME,
        MultiSetWorkout.STATIC_CORE_NAME
    } ;

    public static String[] getWorkoutNames() {
        return sWorkoutNames ;
    }

    public static Workout get(String workoutName) {
        return sWorkouts.get(workoutName) ;
    }

    public static Workout create(String workoutName, Context context) {
        Workout workout ;

        switch (workoutName) {
            case CalisthenicWorkout.NAME:
                workout = CalisthenicWorkout.generate(context) ;
                break ;
            case LiftingWorkout.UPPER_NAME:
                workout = LiftingWorkout.newUpperLiftingWorkout() ;
                break ;
            case LiftingWorkout.LOWER_NAME:
                workout =  LiftingWorkout.newLowerLiftingWorkout() ;
                break ;
            case MultiSetWorkout.STATIC_CORE_NAME :
                workout =  MultiSetWorkout.newStaticCoreWorkout() ;
                break ;
            default:
                return null ;
        }

        sWorkouts.put(workoutName, workout) ;

        return workout ;
    }
}
