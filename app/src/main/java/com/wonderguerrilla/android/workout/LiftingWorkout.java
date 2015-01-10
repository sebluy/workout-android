package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout extends Workout {

    public static final String LOWER_NAME = "Lower Lifting Workout" ;
    public static final String UPPER_NAME = "Upper Lifting Workout" ;

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

    public static LiftingWorkout newUpperLiftingWorkout() {
        return new LiftingWorkout("Upper Lifting Workout", UPPER_BODY_EXERCISES) ;
    }

    public static LiftingWorkout newLowerLiftingWorkout() {
        return new LiftingWorkout("Lower Lifting Workout", LOWER_BODY_EXERCISES) ;
    }

    public LiftingWorkout(String name, Exercise[] exercises) {
        super(name, exercises) ;
    }

}
