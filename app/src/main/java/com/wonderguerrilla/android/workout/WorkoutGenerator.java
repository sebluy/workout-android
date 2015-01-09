package com.wonderguerrilla.android.workout;

import android.content.Context;

public class WorkoutGenerator {

    public static final int UPPER_LIFTING_WORKOUT_ID = 0 ;
    public static final int LOWER_LIFTING_WORKOUT_ID = 1 ;
    public static final int CALISTHENIC_WORKOUT_ID = 2 ;
    public static final int CORE_WORKOUT_ID = 3 ;

    /* change to generate everytime new workout starts */
    private static CalisthenicWorkout sCalisthenicWorkout = null ;

    private static String[] initializeWorkoutNames() {
        String[] names = new String[4] ;
        names[UPPER_LIFTING_WORKOUT_ID] = "Upper Lifting Workout" ;
        names[LOWER_LIFTING_WORKOUT_ID] = "Lower Lifting Workout" ;
        names[CALISTHENIC_WORKOUT_ID] = "Calisthenic Workout" ;
        names[CORE_WORKOUT_ID] = "Core Workout" ;
        return names ;
    }

    private static String[] workoutNames = initializeWorkoutNames() ;

    public static String[] getWorkoutNames() {
        return workoutNames ;
    }

    public static Workout newFromID(int id, Context c) {
        switch (id) {
            case CALISTHENIC_WORKOUT_ID:
                sCalisthenicWorkout = CalisthenicWorkout.generate(c);
                return sCalisthenicWorkout ;
            default:
                return fromID(id) ;
        }
    }

    public static Workout fromID(int id) {
        switch (id) {
            case CALISTHENIC_WORKOUT_ID:
                return sCalisthenicWorkout ;
            case UPPER_LIFTING_WORKOUT_ID:
                return LiftingWorkout.fromId(UPPER_LIFTING_WORKOUT_ID) ;
            case LOWER_LIFTING_WORKOUT_ID:
                return LiftingWorkout.fromId(LOWER_LIFTING_WORKOUT_ID) ;
            case CORE_WORKOUT_ID:
                return MultiSetWorkout.newCoreWorkout() ;
            default:
                return null ;
        }
    }
}
