package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public interface LiftingWorkoutStorage {

    public LiftingExerciseInfo getExercise(String name) ;

    public void commit() ;

    public ArrayList<ArrayList<String>> getPrimaryPairs() ;

    public ArrayList<ArrayList<String>> getInjuryPrevention() ;


}

