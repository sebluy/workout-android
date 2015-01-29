package com.wonderguerrilla.android.workout.workout.lifting.weight;

/**
 * Created by sebluy on 1/29/15.
 */
public class MachineLBS extends Weight {

    public static final String NAME = "Machine (lbs)" ;
    private static final String UNIT = "lbs" ;

    public MachineLBS(double force) {
        super(NAME, force, UNIT) ;
    }

    @Override
    protected void next() {
        mForce += 5 ;
    }

    @Override
    protected void previous() {
        mForce -= 5 ;
    }

}