package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/22/14.
 */
public class LungeExercise extends CalisthenicExercise {

    public static final String[] VARIATIONS = {
            "Forward Lunge",
            "Backward Lunge"
    } ;

    private static final int REPETITIONS = 10 ;

    public LungeExercise(String name) {
        super(name, REPETITIONS) ;
    }

}
