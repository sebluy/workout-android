package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/20/14.
 */
public class Exercise {

    private String mName ;
    int mWeight ;
    String mUnit ;
    int mReps ;

    public Exercise(String name, int weight, String unit, int reps) {
        mName = name ;
        mWeight = weight ;
        mUnit = unit ;
        mReps = reps ;
    }

    public String to_string() {
        return mName + '\n' + mWeight + ' ' + mUnit + '\n' + mReps + " Reps" ;
    }
}
