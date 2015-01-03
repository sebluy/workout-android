package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by sebluy on 12/22/14.
 */
public class PushUpExercise extends CalisthenicExercise {

    public static final String[] VARIATIONS = {
            "Normal Push-Up",
            "Knuckle Push-Up",
            "Fingertip Push-Up",
            "Wide Push-Up",
            "Diamond Push-Up",
            "T Push-Up",
            "Pike Push-Up",
            "Dive Bomber Push-Up",
    } ;

    private static final int REPETITIONS = 5 ;

    public PushUpExercise(String name) {
        super(name, REPETITIONS) ;
    }

}
