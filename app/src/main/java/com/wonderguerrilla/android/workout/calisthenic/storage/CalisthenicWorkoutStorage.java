package com.wonderguerrilla.android.workout.calisthenic.storage;

import com.wonderguerrilla.android.workout.calisthenic.CalisthenicExerciseInfo;
import com.wonderguerrilla.android.workout.lifting.LiftingExerciseInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public interface CalisthenicWorkoutStorage {

    public HashMap<String, CalisthenicExerciseInfo> getExercises();

    public ArrayList<String> getOrder() ;

}

