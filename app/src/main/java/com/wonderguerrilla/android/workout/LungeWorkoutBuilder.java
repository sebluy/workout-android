package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */
public class LungeWorkoutBuilder extends CalisthenicWorkoutBuilder{

    protected String[] getVariations() {
        return LungeExercise.VARIATIONS ;
    }

    protected CalisthenicExercise newInstance(String name) {
        return new LungeExercise(name) ;
    }

}
