package com.wonderguerrilla.android.workout;

import android.content.Context;

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

    private static final String[] lowerOrder = {
        "Front Squat",
        "Deadlift",
        "Leg Extension",
        "Leg Curl",
        "Lunge",
        "Calf Raise",
        "Hip Abduction",
        "Hip Adduction",
        "Terminal Knee Extension"
    } ;

    public static LiftingWorkout newUpperLiftingWorkout(Context context) {
        return new LiftingWorkout(
                UPPER_NAME,
                new LiftingWorkoutGenerator(context, R.raw.upper_lifting_exercises, R.raw.upper_lifting_exercise_order)
                        .exerciseArray()) ;
    }

    public static LiftingWorkout newLowerLiftingWorkout(Context context) {
        return new LiftingWorkout(
                LOWER_NAME,
                new LiftingWorkoutGenerator(context, R.raw.lower_lifting_exercises, R.raw.lower_lifting_exercise_order)
                        .exerciseArray()) ;
    }

    public LiftingWorkout(String name, Exercise[] exercises) {
        super(name, exercises) ;
    }

}
