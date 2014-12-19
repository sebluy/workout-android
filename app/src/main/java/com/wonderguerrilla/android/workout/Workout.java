package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/19/14.
 */
public class Workout {

    private static int[] upper_body_exercises = {
        R.string.bench_press,
        R.string.seated_row_pull,
        R.string.shoulder_press,
        R.string.lat_pull_down,
        R.string.tricep_extension,
        R.string.bicep_curl,
        R.string.deltoid_lateral_raise,
        R.string.upright_row,
        R.string.thumbs_down,
        R.string.external_rotation,
        R.string.internal_rotation,
        R.string.Y,
        R.string.T,
        R.string.W
    } ;

    private static int[] exercises = {
        R.string.front_squat,
        R.string.deadlift,
        R.string.leg_extension,
        R.string.leg_curl,
        R.string.lunge,
        R.string.calf_raise,
        R.string.hip_abduction,
        R.string.hip_adduction,
        R.string.terminal_knee_extension
    } ;

    private static int index = 0 ;

    private static void incrementIndex() {
        index = (index + 1) % exercises.length ;
    }

    private static void decrementIndex() {
        index = index == 0 ? exercises.length - 1 : index - 1 ;
    }

    public static int getCurrentExercise() {
        return exercises[index] ;
    }

    public static int getNextExercise() {
        incrementIndex() ;
        return getCurrentExercise() ;
    }

    public static int getPreviousExercise() {
        decrementIndex() ;
        return getCurrentExercise() ;
    }

}
