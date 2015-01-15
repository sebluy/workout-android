package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkout {

    public static final String NAME = "Calisthenic Workout" ;

    private static final int NUMBER_OF_SETS = 6 ;
    private static final int NUMBER_OF_EXERCISE_TYPES = 5 ;
    private static final int NUMBER_OF_EXERCISES = NUMBER_OF_EXERCISE_TYPES * NUMBER_OF_SETS ;

    private static HashMap<String, CalisthenicExerciseType> types ;
    private static Workout sWorkout ;

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

    public static Workout get(Context context) {
        if (sWorkout == null) {
            sWorkout = generate(context) ;
        }
        return sWorkout ;
    }

    private static Workout generate(Context context) {
        if (types == null) {
            loadTypes(context);
        }
        ArrayList<Exercise> exercises = new ArrayList<>(NUMBER_OF_EXERCISES) ;

        ArrayList<Exercise> pushUpExercises = types.get("Push-Up").generateUniqueSets(NUMBER_OF_SETS) ;
        ArrayList<Exercise> pullUpExercises = types.get("Pull-Up").generateUniqueSets(NUMBER_OF_SETS) ;
        ArrayList<Exercise> coreExercises = types.get("Dynamic Core").generateUniqueSets(NUMBER_OF_SETS) ;
        ArrayList<Exercise> squatExercises = types.get("Squat").generateUniqueSets(NUMBER_OF_SETS) ;
        ArrayList<Exercise> lungeExercises = types.get("Lunge").generateUniqueSets(NUMBER_OF_SETS) ;

        for (int i = 0 ; i < NUMBER_OF_SETS ; i++) {
            exercises.add(pushUpExercises.get(i)) ;
            exercises.add(squatExercises.get(i)) ;
            exercises.add(coreExercises.get(i)) ;
            exercises.add(pullUpExercises.get(i)) ;
            exercises.add(lungeExercises.get(i)) ;
        }

        return new Workout(NAME, exercises) ;
    }

}
