package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */
public class PushUpWorkoutBuilder extends CalisthenicWorkoutBuilder{

    protected String[] getVariations() {
        return PushUpExercise.VARIATIONS ;
    }

    protected CalisthenicExercise newInstance(String name) {
        return new PushUpExercise(name) ;
    }

}
