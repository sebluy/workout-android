package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/22/14.
 */
public class PullUpExercise extends CalisthenicExercise {

    public static final String[] VARIATIONS = {
            "Normal Pull-Up",
            "Narrow Pull-Up",
            "Wide Pull-Up",
            "Parallel Pull-Up",
            "Normal Chin-Up",
            "Narrow Chin-Up"
    } ;

    private static final int REPETITIONS = 3 ;

    public PullUpExercise(String name) {
        super(name, REPETITIONS) ;
    }

}
