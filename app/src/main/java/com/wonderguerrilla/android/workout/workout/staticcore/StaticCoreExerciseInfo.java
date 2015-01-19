package com.wonderguerrilla.android.workout.workout.staticcore;

import com.wonderguerrilla.android.workout.workout.Exercise;

/**
 * Created by sebluy on 12/25/14.
 */

public class StaticCoreExerciseInfo {

    private String mName ;
    private double mDuration;

    public StaticCoreExerciseInfo(String name, double duration) {
        mName = name ;
        mDuration = duration ;
    }

    public Exercise newExercise() {
        return new StaticCoreExercise(mName, mDuration) ;
    }
}
