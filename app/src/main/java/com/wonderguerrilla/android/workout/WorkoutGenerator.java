package com.wonderguerrilla.android.workout;

import android.content.Context;

public class WorkoutGenerator {

    private static final String RUN = "Run Workout" ;
    private static final String SWIM = "Swim Workout" ;
    private static final String BASKETBALL = "Basketball" ;

    private static String[] sWorkoutNames = {
        LiftingWorkout.UPPER_NAME,
        RUN,
        CalisthenicWorkout.NAME,
        SWIM,
        LiftingWorkout.LOWER_NAME,
        BASKETBALL,
        StaticCoreWorkout.STATIC_CORE_NAME
    } ;

    public static String[] getWorkoutNames() {
        return sWorkoutNames ;
    }

    public static Workout create(String workoutName, Context context) {
        switch (workoutName) {
            case LiftingWorkout.UPPER_NAME:
                return LiftingWorkout.newUpperLiftingWorkout(context) ;
            case CalisthenicWorkout.NAME:
                return CalisthenicWorkout.generate(context) ;
            case LiftingWorkout.LOWER_NAME:
                return LiftingWorkout.newLowerLiftingWorkout(context) ;
            case StaticCoreWorkout.STATIC_CORE_NAME :
                return StaticCoreWorkout.newStaticCoreWorkout() ;
            default:
                return new Workout(workoutName, null) ;
        }
    }

    public static Workout createFromPosition(int position, Context context) {
        return create(sWorkoutNames[position], context) ;
    }
}
