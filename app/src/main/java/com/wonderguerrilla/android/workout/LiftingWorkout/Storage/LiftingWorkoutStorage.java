package com.wonderguerrilla.android.workout.LiftingWorkout.Storage;

import com.wonderguerrilla.android.workout.LiftingWorkout.LiftingExerciseInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public interface LiftingWorkoutStorage {

    public HashMap<String, LiftingExerciseInfo> getExercises();

    public ArrayList<ArrayList<String>> getPrimaryPairs() ;

    public ArrayList<ArrayList<String>> getInjuryPrevention() ;

}

