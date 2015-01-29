package com.wonderguerrilla.android.workout.workout.lifting.weight;

/**
 * Created by sebluy on 1/29/15.
 */
public class Barbell extends Weight {

    public static final String NAME = "Barbell" ;
    private static final String UNIT = "lbs" ;

    public Barbell(double force) {
        super(NAME, force, UNIT) ;
    }

    @Override
    protected void next() {
        mForce += 2.5 ;
    }

    @Override
    protected void previous() {
        if (mForce >= 45) {
            mForce -= 2.5 ;
        }
    }

}