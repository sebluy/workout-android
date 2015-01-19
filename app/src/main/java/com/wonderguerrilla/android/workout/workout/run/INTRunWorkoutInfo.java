package com.wonderguerrilla.android.workout.workout.run;

/**
 * Created by sebluy on 12/25/14.
 */
public class INTRunWorkoutInfo {

    public static final String NAME = "INT Run" ;

    private int mIntervals ;
    private double mDistance ;
    private String mUnit ;
    private double mTime ;
    private double mPace ;

    public INTRunWorkoutInfo(int intervals, double distance, String unit, double time, double pace) {
        mIntervals = intervals ;
        mDistance = distance ;
        mUnit = unit ;
        mTime = time ;
        mPace = pace ;
    }

    public String getName() {
        return NAME ;
    }

}
