package com.wonderguerrilla.android.workout.workout;

/**
 * Created by sebluy on 12/25/14.
 */

public class Workout {

    private String mName ;

    public Workout(String name) {
        mName = name ;
    }

    public String getName() {
        return mName ;
    }

    public void commit() {}

    public void recreate() {}

}
