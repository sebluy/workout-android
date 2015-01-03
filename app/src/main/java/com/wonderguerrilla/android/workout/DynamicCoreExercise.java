package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/22/14.
 */
public class DynamicCoreExercise extends CalisthenicExercise {

    protected static final String[] VARIATIONS = {
            "Normal Crunch",
            "Reverse Crunch",
            "Double Crunch",
            "Bicycle Crunch",
            "Wiper",
            "Flutter Kick"
    } ;

    private static final int REPETITIONS = 10 ;

    public DynamicCoreExercise(String name) {
        super(name, REPETITIONS) ;
    }

}
