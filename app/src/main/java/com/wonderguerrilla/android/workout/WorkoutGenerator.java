package com.wonderguerrilla.android.workout;

import android.content.Context;

public class WorkoutGenerator {

    private static String[] sWorkoutNames = {
        LiftingWorkout.UPPER_NAME,
        "Run Workout",
        CalisthenicWorkout.NAME,
        "Swim Workout",
        LiftingWorkout.LOWER_NAME,
        "Basketball",
        StaticCoreWorkout.STATIC_CORE_NAME
    } ;

    public static String[] getWorkoutNames() {
        return sWorkoutNames ;
    }

    public static Workout create(String workoutName, Context context) {
        switch (workoutName) {
            case CalisthenicWorkout.NAME:
                return CalisthenicWorkout.generate(context) ;
            case LiftingWorkout.UPPER_NAME:
                return LiftingWorkout.newUpperLiftingWorkout(context) ;
            case LiftingWorkout.LOWER_NAME:
                return LiftingWorkout.newLowerLiftingWorkout(context) ;
            case StaticCoreWorkout.STATIC_CORE_NAME :
                return StaticCoreWorkout.newStaticCoreWorkout() ;
            default:
                return null ;
        }
    }

    public static Workout createFromPosition(int position, Context context) {
        return create(sWorkoutNames[position], context) ;
    }
}
