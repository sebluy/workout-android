package com.wonderguerrilla.android.workout;

import android.content.Context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout extends Workout {

    public static final String LOWER_NAME = "Lower Lifting Workout" ;
    public static final String UPPER_NAME = "Upper Lifting Workout" ;

    private static final String[] upperOrder = {
        "Bicep Curl",
        "Tricep Extension",
        "Seated Row Pull",
        "Bench Press",
        "Upright Row",
        "Deltoid Lateral Raise",
        "Lat Pull Down",
        "Shoulder Press",
        "Internal Rotation",
        "Thumbs Down",
        "External Rotation",
        "Y",
        "W",
        "T"
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

    private static HashMap<String, LiftingExercise> sUpperExercises ;

    private static void loadUpperExercises(Context context) {
        try {
            sUpperExercises = new LiftingExerciseJSONSerializer(context).getTypes();
        } catch (Exception e) {
        }
    }
    public static LiftingWorkout newUpperLiftingWorkout(Context context) {
        if (sUpperExercises == null) {
            loadUpperExercises(context);
        }
        LiftingExercise[] exercises = new LiftingExercise[sUpperExercises.size()] ;

        for (int i = 0 ; i < sUpperExercises.size() ; i++) {
            exercises[i] = sUpperExercises.get(upperOrder[i]) ;
        }

        return new LiftingWorkout(UPPER_NAME, exercises) ;
    }

    public static LiftingWorkout newLowerLiftingWorkout() {
        return new LiftingWorkout(LOWER_NAME, LOWER_BODY_EXERCISES) ;
    }

    public LiftingWorkout(String name, Exercise[] exercises) {
        super(name, exercises) ;
    }

}
