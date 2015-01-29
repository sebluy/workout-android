package com.wonderguerrilla.android.workout.workout.lifting.weight;

/**
 * Created by sebluy on 1/29/15.
 */
public class Dumbbell extends Weight {

    public static final String NAME = "Dumbbell" ;
    private static final String UNIT = "lbs" ;

    public Dumbbell(double force) {
        super(NAME, force, UNIT) ;
    }

    @Override
    protected void next() {
        if (mForce >= 30) {
            mForce += 5 ;
        } else {
            mForce -= 2.5 ;
        }
    }

    @Override
    protected void previous() {
        if (mForce >= 30) {
            mForce -= 5 ;
        } else {
            mForce += 2.5 ;
        }
    }

}