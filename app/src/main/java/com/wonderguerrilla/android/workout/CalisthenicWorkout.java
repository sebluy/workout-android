package com.wonderguerrilla.android.workout;

import android.content.Context;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkout extends Workout {

    public static final String NAME = "Calisthenic Workout" ;

    private static final int NUMBER_OF_SETS = 6 ;
    private static final int NUMBER_OF_EXERCISE_TYPES = 5 ;
    private static final int NUMBER_OF_EXERCISES = NUMBER_OF_EXERCISE_TYPES * NUMBER_OF_SETS ;

    private static HashMap<String, CalisthenicExerciseType> types ;

    private static void loadTypes(Context c) {
        try {
            types = new CalisthenicExerciseTypeJSONSerializer(c).getTypes();
        } catch (Exception e) {
        }
    }

    public static CalisthenicWorkout generate(Context c) {
        if (types == null) {
            loadTypes(c);
        }
        Exercise[] exercises = new Exercise[NUMBER_OF_EXERCISES] ;

        Exercise[] pushUpExercises = types.get("Push-Up").generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] pullUpExercises = types.get("Pull-Up").generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] coreExercises = types.get("Dynamic Core").generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] squatExercises = types.get("Squat").generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] lungeExercises = types.get("Lunge").generateUniqueSets(NUMBER_OF_SETS) ;

        for (int i = 0 ; i < NUMBER_OF_SETS ; i++) {
            int exerciseIndex = NUMBER_OF_EXERCISE_TYPES * i ;
            exercises[exerciseIndex++] = pushUpExercises[i] ;
            exercises[exerciseIndex++] = squatExercises[i] ;
            exercises[exerciseIndex++] = coreExercises[i] ;
            exercises[exerciseIndex++] = pullUpExercises[i] ;
            exercises[exerciseIndex] = lungeExercises[i] ;
        }

        return new CalisthenicWorkout(exercises) ;
    }

    public CalisthenicWorkout(Exercise[] exercises) {
        super("Calisthenic Workout", exercises) ;
    }

}
