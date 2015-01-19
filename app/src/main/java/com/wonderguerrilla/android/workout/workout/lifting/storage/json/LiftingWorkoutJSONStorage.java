package com.wonderguerrilla.android.workout.workout.lifting.storage.json;

import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;
import com.wonderguerrilla.android.workout.workout.lifting.storage.LiftingWorkoutStorage;

import java.util.ArrayList;
import java.util.HashMap;

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
    public HashMap<String, LiftingExerciseInfo> getExercises() {
        return mInfoStorage.getExercises() ;
    }

    @Override
    public void putExercises(HashMap<String, LiftingExerciseInfo> exercises) {
        mInfoStorage.putExercises(exercises) ;
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

