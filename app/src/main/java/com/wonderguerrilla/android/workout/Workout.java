package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/19/14.
 */
public class Workout {

    private static LiftingExercise[] upperBodyExercises = {
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

    private static LiftingExercise[] lowerBodyExercises = {
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

    private static CalisthenicExercise[] calisthenicExercises = {
            new CalisthenicExercise("Pushup", 5, "Slow"),
            new CalisthenicExercise("Squat", 10, "Slow"),
            new CalisthenicExercise("Crunch", 20, "Slow"),
            new CalisthenicExercise("Pullup", 3, "Slow"),
            new CalisthenicExercise("Lunge", 10, "Slow"),
    } ;

    private static Exercise[] exercises = calisthenicExercises ;

    private static int index = -1 ;

    private static boolean finished = false ;

    private static boolean started = false ;

    private static Exercise exercise ;

    public static Exercise getCurrentExercise() {
        if (!started || finished ) {
            return null ;
        }
        return exercises[index] ;
    }

    public static void incrementExercise() {

        if (finished) {
            return ;
        }

        if (!started) {
            started = true;
        }

        index++ ;

        if (index == exercises.length) {
            finished = true ;
        }

    }

    public static void decrementExercise() {

        if (!started) {
            return ;
        }

        if (finished) {
            finished = false;
        }

        index-- ;

        if (index == -1) {
            started = false ;
        }
    }

    public static String currentExerciseString() {
        Exercise current = getCurrentExercise() ;
        if (current == null) {
            if (finished) {
                return "Finished" ;
            } else {
                return "Start" ;
            }
        } else {
            return current.toString() ;
        }
    }

}
