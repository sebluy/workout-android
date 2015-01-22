package com.wonderguerrilla.android.workout.workout;

/**
 * Created by sebluy on 12/25/14.
 */

public class Workout {

    private String mName ;
    private WorkoutController mInfo ;

    public Workout(String name, WorkoutController info) {
        mName = name ;
        mInfo = info ;
    }

    public String getName() {
        return mName ;
    }

    public void commit() {
        mInfo.commit(this) ;
    }

    public Workout generate() {
        return mInfo.generate() ;
    }

}
