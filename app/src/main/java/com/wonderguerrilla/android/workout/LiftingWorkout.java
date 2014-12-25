package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout {

    public static final int UPPER_LIFTING_WORKOUT_ID = 0 ;
    public static final int LOWER_LIFTING_WORKOUT_ID = 1 ;

    private static final LiftingExercise[] UPPER_BODY_EXERCISES = {
        new LiftingExercise("Bench Press", 45, "Lbs", 10),
        new LiftingExercise("Seated Row Pull", 7, "Plates", 10),
        new LiftingExercise("Shoulder Press", 30, "Lbs", 10),
        new LiftingExercise("Lat Pull Down", 100, "Lbs", 10),
        new LiftingExercise("Tricep Extension", 40, "Lbs", 10),
        new LiftingExercise("Bicep Curl", 25, "Lbs", 10),
        new LiftingExercise("Deltoid Lateral Raise", 10, "Lbs", 10),
        new LiftingExercise("Upright Row", 25, "Lbs", 10),
        new LiftingExercise("Thumbs Down", 5, "Lbs", 10),
        new LiftingExercise("External Rotation", 2, "Plates", 10),
        new LiftingExercise("Internal Rotation", 2, "Plates", 10),
        new LiftingExercise("Y", 5, "Lbs", 10),
        new LiftingExercise("T", 5, "Lbs", 10),
        new LiftingExercise("W", 5, "Lbs", 10)
    } ;

    private static final LiftingExercise[] LOWER_BODY_EXERCISES = {
        new LiftingExercise("Front Squat", 25, "Lbs", 10),
        new LiftingExercise("Deadlift", 45, "Lbs", 10),
        new LiftingExercise("Leg Extension", 70, "Lbs", 10),
        new LiftingExercise("Leg Curl", 70, "Lbs", 10),
        new LiftingExercise("Lunge", 35, "Lbs", 10),
        new LiftingExercise("Calf Raise", 100, "Lbs", 10),
        new LiftingExercise("Hip Abduction", 170, "Lbs", 10),
        new LiftingExercise("Hip Adduction", 170, "Lbs", 10),
        new LiftingExercise("Terminal Knee Extension", 4, "Plates", 10)
    } ;

    private LiftingExercise[] mExercises ;

    private static int index = 0 ;

    public static LiftingWorkout fromID(int workout_id) {
        if (workout_id == UPPER_LIFTING_WORKOUT_ID) {
            return new LiftingWorkout(UPPER_BODY_EXERCISES) ;
        } else if (workout_id == LOWER_LIFTING_WORKOUT_ID) {
            return new LiftingWorkout(LOWER_BODY_EXERCISES) ;
        } else {
            return null ;
        }
    }

    public LiftingWorkout(LiftingExercise[] exercises) {
        mExercises = exercises ;
    }

    public LiftingExercise getCurrentExercise() {
        return mExercises[index] ;
    }

    public void increment() {
        index = index >= mExercises.length - 1 ? index : index + 1 ;
    }

    public void decrement() {
        index = index <= 0 ? index : index - 1 ;
    }

}
