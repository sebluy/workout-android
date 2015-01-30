package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.workout.lifting.weight.Weight;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExerciseInfo {

    private String mName ;
    private Weight mWeight ;
    private int mRepetitions ;

    public LiftingExerciseInfo(String name, Weight weight, int repetitions) {
        mName = name ;
        mWeight = weight ;
        mRepetitions = repetitions ;
    }

    public LiftingExercise newExercise() {
        return new LiftingExercise(mName, mWeight.toString(), mRepetitions) ;
    }

    public void update(LiftingExercise exercise) {
        int performedRepetitions = exercise.getPerformedRepetitions() ;
        if (performedRepetitions > 2) {
            mRepetitions = performedRepetitions - 2 ;
        } else if (performedRepetitions > 0) {
            mRepetitions = 1 ;
        } else {
            mRepetitions = 20 ;
        }
        mWeight.update(performedRepetitions, mRepetitions) ;
    }

    public int getRepetitions() {
        return mRepetitions;
    }

    public Weight getWeight() {
        return mWeight;
    }
}
