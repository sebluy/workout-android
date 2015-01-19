package com.wonderguerrilla.android.workout.workout.run;

/**
 * Created by sebluy on 12/25/14.
 */
public class CHIRunWorkoutInfo {

    public static final String NAME = "CHI Run" ;

    private double mDistance ;
    private String mUnit ;
    private double mTime ;
    private double mPace ;

    public CHIRunWorkoutInfo(double distance, String unit, double time, double pace) {
        mDistance = distance ;
        mUnit = unit ;
        mTime = time ;
        mPace = pace ;
    }

    public String getName() {
        return NAME ;
    }

}
