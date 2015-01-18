package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkoutGenerator extends WorkoutGenerator {

    private static final String EXERCISE_FILENAME = "static_core_exercises.json" ;
    private static final int RAW_ID = R.raw.static_core_exercises ;
    private static final int CIRCUITS = 2 ;

    private static ArrayList<StaticCoreExercise> sExercises ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public StaticCoreWorkoutGenerator(Context context) {
        JSONSerializer serializer = new JSONSerializer(EXERCISE_FILENAME, RAW_ID) ;
        JSONObject object = serializer.get() ;
        sExercises = new ArrayList<>() ;
        try {
            Iterator<String> keyIterator = object.keys();
            while (keyIterator.hasNext()) {
                String name = keyIterator.next();
                sExercises.add(new StaticCoreExercise(name, object.getJSONObject(name)));
            }
        } catch (Exception e) {}
    }

    @Override
    public ArrayList<Exercise> generateExercises() {
        for (StaticCoreExercise exercise : sExercises) {
            exercise.levelUp() ;
        }
        Collections.shuffle(sExercises) ;
        ArrayList<Exercise> workout = new ArrayList<>(CIRCUITS * sExercises.size()) ;
        for (int i = 0 ; i < CIRCUITS ; i++) {
            for (StaticCoreExercise exercise : sExercises) {
                workout.add(exercise.clone()) ;
            }
        }

        return workout ;
    }

}
