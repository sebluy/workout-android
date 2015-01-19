package com.wonderguerrilla.android.workout.lifting.storage;

import com.wonderguerrilla.android.workout.lifting.LiftingExerciseInfo;

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

