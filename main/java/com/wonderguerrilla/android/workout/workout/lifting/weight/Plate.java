package com.wonderguerrilla.android.workout.workout.lifting.weight;

/**
 * Created by sebluy on 1/29/15.
 */
public class Plate extends Weight {

    public static final String NAME = "Plate" ;
    private static final String UNIT = "Plates" ;

    public Plate(double force) {
        super(NAME, force, UNIT) ;
    }

    @Override
    protected void next() {
        mForce += 0.5 ;
    }

    @Override
    protected void previous() {
        if (mForce > 1) {
            mForce -= 0.5 ;
        }
    }

}