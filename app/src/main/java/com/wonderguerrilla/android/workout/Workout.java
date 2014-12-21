package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/19/14.
 */
public class Workout {

    private static Exercise[] upper_body_exercises = {
        new Exercise("Bench Press", 45, "Lbs", 10),
        new Exercise("Seated Row Pull", 7, "Plates", 10),
        new Exercise("Shoulder Press", 30, "Lbs", 10),
        new Exercise("Lat Pull Down", 100, "Lbs", 10),
        new Exercise("Tricep Extension", 40, "Lbs", 10),
        new Exercise("Bicep Curl", 25, "Lbs", 10),
        new Exercise("Deltoid Lateral Raise", 10, "Lbs", 10),
        new Exercise("Upright Row", 25, "Lbs", 10),
        new Exercise("Thumbs Down", 5, "Lbs", 10),
        new Exercise("External Rotation", 2, "Plates", 10),
        new Exercise("Internal Rotation", 2, "Plates", 10),
        new Exercise("Y", 5, "Lbs", 10),
        new Exercise("T", 5, "Lbs", 10),
        new Exercise("W", 5, "Lbs", 10)
    } ;

    private static Exercise[] lower_body_exercises = {
        new Exercise("Front Squat", 25, "Lbs", 10),
        new Exercise("Deadlift", 45, "Lbs", 10),
        new Exercise("Leg Extension", 70, "Lbs", 10),
        new Exercise("Leg Curl", 70, "Lbs", 10),
        new Exercise("Lunge", 35, "Lbs", 10),
        new Exercise("Calf Raise", 100, "Lbs", 10),
        new Exercise("Hip Abduction", 170, "Lbs", 10),
        new Exercise("Hip Adduction", 170, "Lbs", 10),
        new Exercise("Terminal Knee Extension", 4, "Plates", 10)
    } ;

    private static Exercise[] exercises = lower_body_exercises ;

    private static int index = 0 ;

    private static void incrementIndex() {
        index = (index + 1) % exercises.length ;
    }

    private static void decrementIndex() {
        index = index == 0 ? exercises.length - 1 : index - 1 ;
    }

    public static Exercise getCurrentExercise() {
        return exercises[index] ;
    }

    public static Exercise getNextExercise() {
        incrementIndex() ;
        return getCurrentExercise() ;
    }

    public static Exercise getPreviousExercise() {
        decrementIndex() ;
        return getCurrentExercise() ;
    }

}
