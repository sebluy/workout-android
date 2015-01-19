package com.wonderguerrilla.android.workout.lifting;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExerciseInfo {

    private String mName ;
    private double mWeight ;
    private String mUnit ;
    private int mRepetitions ;

    public LiftingExerciseInfo(String name, double weight, String unit, int repetitions) {
        mName = name ;
        mWeight = weight ;
        mUnit = unit ;
        mRepetitions = repetitions ;
    }

    public int getRepetitions() {
        return mRepetitions;
    }

    public void setRepetitions(int repetitions) {
        mRepetitions = repetitions;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double weight) {
        mWeight = weight;
    }

    public String getUnit() {
        return mUnit;
    }

    public LiftingExercise newExercise() {
        return new LiftingExercise(mName, mWeight, mUnit, mRepetitions) ;
    }

}
