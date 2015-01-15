package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkout extends Workout {

    public static final String NAME = "Calisthenic Workout" ;

    private static final int NUMBER_OF_SETS = 6 ;
    private static final int NUMBER_OF_EXERCISE_TYPES = 5 ;
    private static final int NUMBER_OF_EXERCISES = NUMBER_OF_EXERCISE_TYPES * NUMBER_OF_SETS ;

    private static HashMap<String, CalisthenicExerciseType> types ;
    private static CalisthenicWorkout sWorkout ;

    private static void loadTypes(Context context) {
        types = new HashMap<>() ;
        try {
            JSONObject object = new JSONReader(context, R.raw.calisthenic_exercise_types).get();

            Iterator<String> keyIterator = object.keys();
            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                types.put(key, new CalisthenicExerciseType(object.getJSONObject(key)));
            }
        } catch (Exception e) {}
    }

    public static CalisthenicWorkout get(Context context) {
        if (sWorkout == null) {
            sWorkout = generate(context) ;
        }
        return sWorkout ;
    }

    private static CalisthenicWorkout generate(Context context) {
        if (types == null) {
            loadTypes(context);
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

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public CalisthenicWorkout(Exercise[] exercises) {
        super(NAME, exercises) ;
    }

}
