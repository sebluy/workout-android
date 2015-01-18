package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExerciseInfo {

    private String mName ;
    private int mWeight ;
    private String mUnit ;
    private int mRepetitions ;

    public LiftingExerciseInfo(String name, int weight, String unit, int repetitions) {
        mName = name ;
        mWeight = weight ;
        mUnit = unit ;
        mRepetitions = repetitions ;
    }

    public LiftingExercise newExercise() {
        return new LiftingExercise(mName, mWeight, mUnit, mRepetitions) ;
    }

}
