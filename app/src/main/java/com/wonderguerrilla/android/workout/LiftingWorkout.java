package com.wonderguerrilla.android.workout;

import android.content.Context;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout extends MultipleExerciseWorkout {

    public static final String LOWER_NAME = "Lower Lifting" ;
    public static final String UPPER_NAME = "Upper Lifting" ;

    private static LiftingWorkout sUpper ;
    private static LiftingWorkout sLower ;

    public static LiftingWorkout getUpper(Context context) {
        if (sUpper == null) {
            sUpper = newUpper(context) ;
        }
        return sUpper ;
    }

    public static LiftingWorkout getLower(Context context) {
        if (sLower == null) {
            sLower = newLower(context) ;
        }
        return sLower ;
    }

    private static LiftingWorkout newUpper(Context context) {
        LiftingWorkoutGenerator generator = new LiftingWorkoutGenerator(
                context,
                "upper_lifting_exercises.json",
                R.raw.upper_lifting_exercise_order) ;

        return new LiftingWorkout(UPPER_NAME, generator) ;
    }

    private static LiftingWorkout newLower(Context context) {
        LiftingWorkoutGenerator generator = new LiftingWorkoutGenerator(
                context,
                "lower_lifting_exercises.json",
                R.raw.lower_lifting_exercise_order) ;

        return new LiftingWorkout(LOWER_NAME, generator) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private LiftingWorkoutGenerator mGenerator ;

    @Override
    public void save() {
        mGenerator.saveExercises();
    }

    public LiftingWorkout(String name, LiftingWorkoutGenerator generator) {
        super(name, generator.generateExercises()) ;
        mGenerator = generator ;
    }

    @Override
    public void recreate() {
        mExercises = mGenerator.generateExercises() ;
    }

}
