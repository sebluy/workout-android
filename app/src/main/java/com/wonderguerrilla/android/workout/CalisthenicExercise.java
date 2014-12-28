package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExercise implements Exercise {

    private String mName ;
    int mReps ;
    String mSpeed ; /* perhaps use enum for speed */

    public CalisthenicExercise(String name, int reps, String speed) {
        mName = name ;
        mReps = reps ;
        mSpeed = speed ;
    }

    public String toString() {
        return mName + '\n' + mReps + '\n' + mSpeed ;
    }
}
