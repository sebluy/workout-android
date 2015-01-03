package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */
public class PullUpWorkoutBuilder extends CalisthenicWorkoutBuilder{

    protected String[] getVariations() {
        return PullUpExercise.VARIATIONS ;
    }

    protected CalisthenicExercise newInstance(String name) {
        return new PullUpExercise(name) ;
    }

}
