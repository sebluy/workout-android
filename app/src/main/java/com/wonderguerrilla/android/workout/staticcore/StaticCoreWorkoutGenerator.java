package com.wonderguerrilla.android.workout.staticcore;

import android.content.Context;

import com.wonderguerrilla.android.workout.Exercise;
import com.wonderguerrilla.android.workout.JSONSerializer;
import com.wonderguerrilla.android.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.WorkoutGenerator;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkoutGenerator implements WorkoutGenerator {

    private static final int CIRCUITS = 2 ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private StaticCoreWorkoutInfo mInfo ;
    private ArrayList<StaticCoreExerciseInfo> mExercises ;

    public StaticCoreWorkoutGenerator(StaticCoreWorkoutInfo info) {
        mInfo = info ;
        mExercises = info.getStorage().getExercises() ;
    }

    public MultipleExerciseWorkout newWorkout() {
        return new MultipleExerciseWorkout(mInfo.getName(), this) ;
    }

    @Override
    public void commit(ArrayList<Exercise> exercises) {
    }

    @Override
    public ArrayList<Exercise> generateExercises() {
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
