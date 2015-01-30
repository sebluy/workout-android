package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.workout.Exercise;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExercise extends Exercise {

    private String mWeight ;
    private int mRepetitionGoal ;
    private int mPerformedRepetitions ;

    public LiftingExercise(String name, String weight, int repetitionGoal) {
        super(name) ;
        mWeight = weight ;
        mRepetitionGoal = repetitionGoal ;
        mPerformedRepetitions = repetitionGoal ;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public int getRepetitionGoal() {
        return mRepetitionGoal ;
    }

    public int getPerformedRepetitions() {
        return mPerformedRepetitions ;
    }

    public void setPerformedRepetitions(int performedRepetitions) {
        mPerformedRepetitions = performedRepetitions ;
    }
}
