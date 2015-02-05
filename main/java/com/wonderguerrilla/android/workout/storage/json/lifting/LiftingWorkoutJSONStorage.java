package com.wonderguerrilla.android.workout.storage.json.lifting;


import workout.lifting.LiftingExerciseInfo;
import workout.lifting.LiftingWorkoutStorage;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutJSONStorage implements LiftingWorkoutStorage {

    public static LiftingWorkoutJSONStorage newUpper() {
        return new LiftingWorkoutJSONStorage(LiftingWorkoutInfoJSONStorage.newUpper(),
                LiftingWorkoutOrderJSONStorage.newUpper()) ;
    }

    public static LiftingWorkoutJSONStorage newLower() {
        return new LiftingWorkoutJSONStorage(LiftingWorkoutInfoJSONStorage.newLower(),
                LiftingWorkoutOrderJSONStorage.newLower()) ;
    }

    private LiftingWorkoutInfoJSONStorage mInfoStorage ;
    private LiftingWorkoutOrderJSONStorage mOrderStorage ;

    public LiftingWorkoutJSONStorage(LiftingWorkoutInfoJSONStorage infoStorage,
                                     LiftingWorkoutOrderJSONStorage orderStorage) {
        mInfoStorage = infoStorage ;
        mOrderStorage = orderStorage ;
    }

    @Override
    public LiftingExerciseInfo getExercise(String name) {
        return mInfoStorage.getExercise(name) ;
    }

    @Override
    public void commit() {
        mInfoStorage.commit() ;
    }

    @Override
    public ArrayList<ArrayList<String>> getPrimaryPairs() {
        return mOrderStorage.getPrimaryPairs() ;
    }

    @Override
    public ArrayList<ArrayList<String>> getInjuryPrevention() {
        return mOrderStorage.getInjuryPrevention() ;
    }
}

