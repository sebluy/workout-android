package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkout extends MultipleExerciseWorkout {

    public static final String NAME = "Calisthenic" ;

    private static ArrayList<String> sOrder ;
    private static HashMap<String, CalisthenicExerciseType> sTypes ;
    private static Workout sWorkout ;

    public static Workout get(Context context) {
        if (sWorkout == null) {
            if (sTypes == null) {
                loadTypes(context) ;
            }
            if (sOrder == null) {
                loadOrder(context) ;
            }
            sWorkout = new CalisthenicWorkout() ;
        }
        return sWorkout ;
    }

    private static void loadOrder(Context context) {
        sOrder = new ArrayList<>() ;
        try {
            JSONObject object = new JSONReader(context, R.raw.calisthenic_exercise_order).get() ;
            JSONArray array = object.getJSONArray("Order") ;
            for (int i = 0 ; i < array.length() ; i++) {
                sOrder.add(array.getString(i)) ;
            }
        } catch (Exception e) {}
    }

    private static void loadTypes(Context context) {
        sTypes = new HashMap<>() ;
        try {
            JSONObject object = new JSONReader(context, R.raw.calisthenic_exercise_types).get();

            Iterator<String> keyIterator = object.keys();
            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                sTypes.put(key, new CalisthenicExerciseType(object.getJSONObject(key)));
            }
        } catch (Exception e) {}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public CalisthenicWorkout() {
        super(NAME, null, null) ;
    }

    protected ArrayList<Exercise> generateExercises() {

        ArrayList<Exercise> exercises = new ArrayList<>() ;
        ArrayList<Stack<Exercise>> sets = new ArrayList<>();

        for (String type : sOrder) {
            sets.add(sTypes.get(type).generateUniqueSets());
        }

        while (!sets.isEmpty()) {

            ArrayList<Integer> empty = new ArrayList<>() ;

            /* add exercise from each set */
            for (int i = 0 ; i < sets.size() ; i++) {
                Stack<Exercise> set = sets.get(i) ;
                if (!set.isEmpty()) {
                    exercises.add(set.pop());
                } else {
                    empty.add(i) ;
                }
            }

            Collections.reverse(empty) ;
            /* remove empty sets */
            for (int i = 0 ; i < empty.size() ; i++) {
                sets.remove(empty.get(i).intValue()) ;
            }
        }

        return exercises ;
    }

}
