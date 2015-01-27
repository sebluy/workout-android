package com.wonderguerrilla.android.workout.workout.run;

/**
 * Created by sebluy on 12/25/14.
 */
public class LSDRunWorkoutInfo {

    public static final String NAME = "LSD Run" ;

    private double mDistance ;
    private String mUnit ;
    private double mTime ;
    private double mPace ;

    public LSDRunWorkoutInfo(double distance, String unit, double time, double pace) {
        mDistance = distance ;
        mUnit = unit ;
        mTime = time ;
        mPace = pace ;
    }

    public String getName() {
        return NAME ;
    }

}
