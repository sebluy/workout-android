package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkout extends MultipleExerciseWorkout {

    public static final String NAME = "Static Core" ;

    private static final int CIRCUITS = 2 ;

    private static Workout sWorkout ;
    private static ArrayList<Exercise> sExercises ;

    public static Workout get(Context context) {
        if (sWorkout == null) {
            if (sExercises == null) {
                loadExercises(context) ;
            }
            sWorkout = new StaticCoreWorkout() ;
        }
        return sWorkout ;
    }

    private static void loadExercises(Context context) {
        sExercises = new ArrayList<>() ;
        try {
            JSONObject object = new JSONReader(context, R.raw.static_core_exercises).get();
            Iterator<String> keyIterator = object.keys();
            while (keyIterator.hasNext()) {
                String name = keyIterator.next();
                sExercises.add(new StaticCoreExercise(name, object.getJSONObject(name)));
            }
        } catch (Exception e) {}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public StaticCoreWorkout() {
        super(NAME, null, null) ;
    }

    protected ArrayList<Exercise> generateExercises() {
        Collections.shuffle(sExercises) ;
        ArrayList<Exercise> workout = new ArrayList<>(CIRCUITS * sExercises.size()) ;
        for (int i = 0 ; i < CIRCUITS ; i++) {
            workout.addAll(sExercises) ;
        }

        return workout ;
    }

}
