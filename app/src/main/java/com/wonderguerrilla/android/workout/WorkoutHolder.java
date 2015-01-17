package com.wonderguerrilla.android.workout;

import android.content.Context;

import java.util.HashMap;

public class WorkoutHolder {

    private static final String RUN = "Run" ;
    private static final String SWIM = "Swim" ;

    private static final String[] sWorkoutNames = {
        LiftingWorkout.UPPER_NAME,
        RUN,
        CalisthenicWorkout.NAME,
        SWIM,
        LiftingWorkout.LOWER_NAME,
        BasketballWorkout.NAME,
        StaticCoreWorkout.NAME
    } ;

    private static HashMap<String, Workout> sWorkouts = new HashMap<>() ;
    private static Workout sCurrent;

    public static String[] getNames() {
        return sWorkoutNames ;
    }

    public static Workout create(String workoutName, Context context) {
        switch (workoutName) {
            case LiftingWorkout.UPPER_NAME:
                return new MultipleExerciseWorkout(workoutName, LiftingWorkoutGenerator.getUpper(context)) ;
            case CalisthenicWorkout.NAME:
                return new MultipleExerciseWorkout(workoutName, new CalisthenicWorkoutGenerator(context)) ;
            case LiftingWorkout.LOWER_NAME:
                return new MultipleExerciseWorkout(workoutName, LiftingWorkoutGenerator.getLower(context)) ;
            case BasketballWorkout.NAME:
                return new BasketballWorkout(30) ;
            case StaticCoreWorkout.NAME:
                return new MultipleExerciseWorkout(workoutName, new StaticCoreWorkoutGenerator(context)) ;
            default:
                return new Workout(workoutName) ;
        }
    }

    public static Workout get(String name, Context context) {
        if (sWorkouts.containsKey(name)) {
            return sWorkouts.get(name) ;
        } else {
            Workout newWorkout = create(name, context) ;
            sWorkouts.put(name, newWorkout) ;
            return newWorkout ;
        }
    }

    public static Workout getFromPosition(int position, Context context) {
        return get(sWorkoutNames[position], context) ;
    }

    public static Workout getCurrent() {
        return sCurrent ;
    }

    public static void setCurrent(Workout workout) {
        sCurrent = workout ;
    }

}
