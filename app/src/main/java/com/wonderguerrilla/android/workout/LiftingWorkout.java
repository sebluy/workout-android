package com.wonderguerrilla.android.workout;

import android.content.Context;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout extends Workout {

    public static final String LOWER_NAME = "Lower Lifting Workout" ;
    public static final String UPPER_NAME = "Upper Lifting Workout" ;

    private LiftingWorkoutGenerator mGenerator ;

    public static LiftingWorkout newUpperLiftingWorkout(Context context) {
        LiftingWorkoutGenerator generator = new LiftingWorkoutGenerator(
                context,
                "upper_lifting_exercises.json",
                R.raw.upper_lifting_exercises,
                R.raw.upper_lifting_exercise_order) ;

        return new LiftingWorkout(UPPER_NAME, generator.exerciseArray(), generator) ;
    }

    public static LiftingWorkout newLowerLiftingWorkout(Context context) {
        LiftingWorkoutGenerator generator = new LiftingWorkoutGenerator(
                context,
                "lower_lifting_exercises.json",
                R.raw.lower_lifting_exercises,
                R.raw.lower_lifting_exercise_order) ;

        return new LiftingWorkout(LOWER_NAME, generator.exerciseArray(), generator) ;
    }

    @Override
    public void save() {
        mGenerator.saveExercises();
    }

    public LiftingWorkout(String name, Exercise[] exercises, LiftingWorkoutGenerator generator) {
        super(name, exercises) ;
        mGenerator = generator ;
    }

}
