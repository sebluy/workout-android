package com.wonderguerrilla.android.workout.workout.staticcore;

import com.wonderguerrilla.android.workout.workout.BaseExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.ExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkoutGenerator {

    private static final int CIRCUITS = 2 ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private StaticCoreWorkoutController mController;
    private ArrayList<StaticCoreExerciseInfo> mExercises ;

    public StaticCoreWorkoutGenerator(StaticCoreWorkoutController info) {
        mController = info ;
        mExercises = info.getStorage().getExercises() ;
    }

    public Workout generate() {
        return new BaseExerciseWorkout(mController, generateExercises()) ;
    }

    private ArrayList<Exercise> generateExercises() {
        Collections.shuffle(mExercises) ;
        ArrayList<Exercise> workout = new ArrayList<>(CIRCUITS * mExercises.size()) ;
        for (int i = 0 ; i < CIRCUITS ; i++) {
            for (StaticCoreExerciseInfo exercise : mExercises) {
                workout.add(exercise.newExercise()) ;
            }
        }
        return workout ;
    }

}
