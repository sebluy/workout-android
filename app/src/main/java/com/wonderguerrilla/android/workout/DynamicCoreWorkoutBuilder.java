package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */
public class DynamicCoreWorkoutBuilder extends CalisthenicWorkoutBuilder{

    protected String[] getVariations() {
        return DynamicCoreExercise.VARIATIONS ;
    }

    protected CalisthenicExercise newInstance(String name) {
        return new DynamicCoreExercise(name) ;
    }

}
