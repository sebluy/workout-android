package com.wonderguerrilla.android.workout.workout.lifting.weight;

/**
 * Created by sebluy on 1/29/15.
 */
public class CalfMachine extends Weight {

    public static final String NAME = "Calf Machine" ;
    private static final String UNIT = "lbs" ;

    public CalfMachine(double force) {
        super(NAME, force, UNIT) ;
    }

    @Override
    protected void next() {
        mForce += 10 ;
    }

    @Override
    protected void previous() {
        mForce -= 10 ;
    }

}