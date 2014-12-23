package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExercise implements Exercise {

    private String mName ;
    int mWeight ;
    String mUnit ;
    int mReps ;

    public LiftingExercise(String name, int weight, String unit, int reps) {
        mName = name ;
        mWeight = weight ;
        mUnit = unit ;
        mReps = reps ;
    }

    public String toString() {
        return mName + '\n' + mWeight + ' ' + mUnit + '\n' + mReps + " Reps" ;
    }
}
