package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/22/14.
 */
public class SquatExercise extends CalisthenicExercise {

    public static final String[] VARIATIONS = {
            "Squat",
            "Vertical Jump",
            "Forward Jump",
            "Lateral Jump"
    } ;

    private static final int REPETITIONS = 10 ;

    public SquatExercise(String name) {
        super(name, REPETITIONS) ;
    }

}
