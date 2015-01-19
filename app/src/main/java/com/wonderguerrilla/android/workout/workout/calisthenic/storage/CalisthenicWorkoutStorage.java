package com.wonderguerrilla.android.workout.workout.calisthenic.storage;

import com.wonderguerrilla.android.workout.workout.calisthenic.CalisthenicExerciseInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public interface CalisthenicWorkoutStorage {

    public HashMap<String, CalisthenicExerciseInfo> getExercises();

    public ArrayList<String> getOrder() ;

}

