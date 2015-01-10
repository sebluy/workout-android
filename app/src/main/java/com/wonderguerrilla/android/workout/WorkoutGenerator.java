package com.wonderguerrilla.android.workout;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

public class WorkoutGenerator {

    private static String[] sWorkoutNames = {
        CalisthenicWorkout.NAME,
        LiftingWorkout.UPPER_NAME,
        LiftingWorkout.LOWER_NAME,
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
                return LiftingWorkout.newUpperLiftingWorkout() ;
            case LiftingWorkout.LOWER_NAME:
                return LiftingWorkout.newLowerLiftingWorkout() ;
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
