package com.wonderguerrilla.android.workout.storage.json.calisthenic;

import workout.calisthenic.CalisthenicExerciseInfo;
import workout.calisthenic.CalisthenicWorkoutStorage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public class CalisthenicWorkoutJSONStorage implements CalisthenicWorkoutStorage {

    private CalisthenicWorkoutInfoJSONStorage mInfoStorage ;
    private CalisthenicWorkoutOrderJSONStorage mOrderStorage ;

    public CalisthenicWorkoutJSONStorage() {
        mInfoStorage = new CalisthenicWorkoutInfoJSONStorage() ;
        mOrderStorage = new CalisthenicWorkoutOrderJSONStorage() ;
    }

    @Override
    public HashMap<String, CalisthenicExerciseInfo> getExercises() {
        return mInfoStorage.getExercises() ;
    }

    @Override
    public ArrayList<String> getOrder() {
        return mOrderStorage.getOrder() ;
    }

}

