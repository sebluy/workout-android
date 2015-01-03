package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */
public class SquatWorkoutBuilder extends CalisthenicWorkoutBuilder{

    protected String[] getVariations() {
        return SquatExercise.VARIATIONS ;
    }

    protected CalisthenicExercise newInstance(String name) {
        return new SquatExercise(name) ;
    }

}
