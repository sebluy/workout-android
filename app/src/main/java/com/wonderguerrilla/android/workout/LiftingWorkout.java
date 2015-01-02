package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout implements Workout {

    private static final LiftingExercise[] UPPER_BODY_EXERCISES = {
        new LiftingExercise("Bench Press", 45, "lbs", 10),
        new LiftingExercise("Seated Row Pull", 7, "Plates", 10),
        new LiftingExercise("Shoulder Press", 30, "lbs", 10),
        new LiftingExercise("Lat Pull Down", 100, "lbs", 10),
        new LiftingExercise("Tricep Extension", 40, "lbs", 10),
        new LiftingExercise("Bicep Curl", 25, "lbs", 10),
        new LiftingExercise("Deltoid Lateral Raise", 10, "lbs", 10),
        new LiftingExercise("Upright Row", 25, "lbs", 10),
        new LiftingExercise("Thumbs Down", 5, "lbs", 10),
        new LiftingExercise("External Rotation", 2, "Plates", 10),
        new LiftingExercise("Internal Rotation", 2, "Plates", 10),
        new LiftingExercise("Y", 5, "lbs", 10),
        new LiftingExercise("T", 5, "lbs", 10),
        new LiftingExercise("W", 5, "lbs", 10)
    } ;

    private static final LiftingExercise[] LOWER_BODY_EXERCISES = {
        new LiftingExercise("Front Squat", 25, "lbs", 10),
        new LiftingExercise("Deadlift", 45, "lbs", 10),
        new LiftingExercise("Leg Extension", 70, "lbs", 10),
        new LiftingExercise("Leg Curl", 70, "lbs", 10),
        new LiftingExercise("Lunge", 35, "lbs", 10),
        new LiftingExercise("Calf Raise", 100, "lbs", 10),
        new LiftingExercise("Hip Abduction", 170, "lbs", 10),
        new LiftingExercise("Hip Adduction", 170, "lbs", 10),
        new LiftingExercise("Terminal Knee Extension", 4, "Plates", 10)
    } ;

    private LiftingExercise[] mExercises ;
    private String mName ;

    public String getName() {
        return mName ;
    }

    public LiftingWorkout(int workout_id) {
        if (workout_id == WorkoutGenerator.UPPER_LIFTING_WORKOUT_ID) {
            mExercises = UPPER_BODY_EXERCISES ;
            mName = "Upper Lifting Workout" ;
        } else {
            mExercises = LOWER_BODY_EXERCISES ;
            mName = "Lower Lifting Workout" ;
        }
    }

    public Exercise getExercise(int index) {
        return mExercises[index] ;
    }

    public int size() {
        return mExercises.length ;
    }

}