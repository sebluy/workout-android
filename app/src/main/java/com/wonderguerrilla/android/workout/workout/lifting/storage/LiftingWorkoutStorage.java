package com.wonderguerrilla.android.workout.workout.lifting.storage;

import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public interface LiftingWorkoutStorage {

    public HashMap<String, LiftingExerciseInfo> getExercises();

    public void putExercises(HashMap<String, LiftingExerciseInfo> exercises) ;

    public ArrayList<ArrayList<String>> getPrimaryPairs() ;

    public ArrayList<ArrayList<String>> getInjuryPrevention() ;

}

