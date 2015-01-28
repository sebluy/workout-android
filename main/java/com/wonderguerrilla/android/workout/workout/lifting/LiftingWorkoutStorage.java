package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public interface LiftingWorkoutStorage {

    LiftingExerciseInfo getExercise(String name) ;

    void commit() ;

    ArrayList<ArrayList<String>> getPrimaryPairs() ;

    ArrayList<ArrayList<String>> getInjuryPrevention() ;

}

