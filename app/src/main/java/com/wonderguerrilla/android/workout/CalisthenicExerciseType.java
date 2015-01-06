package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExerciseType {

    /* move these static declarations to JSON or XML */

    private static int PUSH_UP_REPETITIONS = 5;
    private static int PULL_UP_REPETITIONS = 3;
    private static int DYNAMIC_CORE_REPETITIONS = 10;
    private static int SQUAT_REPETITIONS = 10;
    private static int LUNGE_REPETITIONS = 10;

    public static final String[] PUSH_UP_VARIATIONS = {
            "Normal Push-Up",
            "Knuckle Push-Up",
            "Fingertip Push-Up",
            "Wide Push-Up",
            "Diamond Push-Up",
            "T Push-Up",
            "Pike Push-Up",
            "Dive Bomber Push-Up",
    };

    public static final String[] PULL_UP_VARIATIONS = {
            "Normal Pull-Up",
            "Narrow Pull-Up",
            "Wide Pull-Up",
            "Parallel Pull-Up",
            "Normal Chin-Up",
            "Narrow Chin-Up"
    };

    protected static final String[] DYNAMIC_CORE_VARIATIONS = {
            "Normal Crunch",
            "Reverse Crunch",
            "Double Crunch",
            "Bicycle Crunch",
            "Wiper",
            "Flutter Kick"
    };

    public static final String[] SQUAT_VARIATIONS = {
            "Squat",
            "Vertical Jump",
            "Forward Jump",
            "Lateral Jump"
    };

    public static final String[] LUNGE_VARIATIONS = {
            "Forward Lunge",
            "Backward Lunge"
    };

    public static final CalisthenicExerciseType PUSH_UP =
            new CalisthenicExerciseType(PUSH_UP_VARIATIONS, PUSH_UP_REPETITIONS);

    public static final CalisthenicExerciseType PULL_UP =
            new CalisthenicExerciseType(PULL_UP_VARIATIONS, PULL_UP_REPETITIONS);

    public static final CalisthenicExerciseType DYNAMIC_CORE =
            new CalisthenicExerciseType(DYNAMIC_CORE_VARIATIONS, DYNAMIC_CORE_REPETITIONS);

    public static final CalisthenicExerciseType SQUAT =
            new CalisthenicExerciseType(SQUAT_VARIATIONS, SQUAT_REPETITIONS);

    public static final CalisthenicExerciseType LUNGE =
            new CalisthenicExerciseType(LUNGE_VARIATIONS, LUNGE_REPETITIONS);

    /* end replace with JSON/XML + add constructor to create from JSON */

    private String[] mVariations;
    private int mRepetitions;

    public CalisthenicExerciseType(String[] variations, int repetitions) {
        mVariations = variations;
        mRepetitions = repetitions;
    }

    /* perhaps refactor into generic method that takes an array and dumps a new one
        without repeating elements before exhausting and also no matching neighbors
     */
    public CalisthenicExercise[] generateUniqueSets(int numberOfSets) {

        ArrayList<String> variations = new ArrayList<String>(Arrays.asList(mVariations)) ;
        ArrayList<CalisthenicExercise> exercises = new ArrayList<CalisthenicExercise>(numberOfSets) ;

        Random rand = new Random() ;

        int variationIndex = 0 ;
        String lastVariation = null ;

        while (exercises.size() < numberOfSets) {

            if (variations.isEmpty()) {

                variations.addAll(Arrays.asList(mVariations)) ;

                /* add a variation that is not the last added */
                variations.remove(lastVariation) ;
                variationIndex = rand.nextInt(variations.size());
                String variation = variations.get(variationIndex);
                CalisthenicExercise newExercise = new CalisthenicExercise(variation, mRepetitions);
                exercises.add(newExercise);
                variations.remove(variationIndex);
                variations.add(lastVariation) ;
            }

            variationIndex = rand.nextInt(variations.size());
            String variation = variations.get(variationIndex);
            CalisthenicExercise newExercise = new CalisthenicExercise(variation, mRepetitions);
            exercises.add(newExercise);
            lastVariation = variations.remove(variationIndex) ;
        }

        return exercises.toArray(new CalisthenicExercise[numberOfSets]) ;
    }
}
