package com.wonderguerrilla.android.workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutInfo {

    public static final String UPPER_NAME = "Upper Lifting" ;
    public static final String LOWER_NAME = "Lower Lifting" ;

    public static LiftingWorkoutInfo newUpper() {
        return new LiftingWorkoutInfo(UPPER_NAME, LiftingWorkoutInfoStorage.newUpper()) ;
    }

    public static LiftingWorkoutInfo newLower() {
        return new LiftingWorkoutInfo(LOWER_NAME ,LiftingWorkoutInfoStorage.newLower()) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private HashMap<String, LiftingExerciseInfo> mExercises ;

    private String mName;

    private LiftingWorkoutInfoStorage mStorage ;

    public LiftingWorkoutInfo(String name, LiftingWorkoutInfoStorage storage) {
        mName = name ;
        mStorage = storage ;
        mExercises = mStorage.getExercises() ;
    }

    public LiftingExerciseInfo getExerciseInfo(String name) {
        return mExercises.get(name) ;
    }

    public String getName() {
        return mName;
    }
}
