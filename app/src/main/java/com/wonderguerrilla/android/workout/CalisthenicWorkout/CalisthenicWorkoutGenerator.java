package com.wonderguerrilla.android.workout.CalisthenicWorkout;

import com.wonderguerrilla.android.workout.Exercise;
import com.wonderguerrilla.android.workout.JSONReader;
import com.wonderguerrilla.android.workout.JSONSerializer;
import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.WorkoutGenerator;

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
public class CalisthenicWorkoutGenerator extends WorkoutGenerator {

    private static final String TYPES_FILENAME = "calisthenic_exercises.json" ;
    private static final int TYPES_RAW_ID = R.raw.calisthenic_exercises ;

    private static final int ORDER_RAW_ID = R.raw.calisthenic_exercise_order ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<String> mOrder ;
    private HashMap<String, CalisthenicExerciseInfo> mTypes ;

    public CalisthenicWorkoutGenerator() {
        loadTypes() ;
        loadOrder() ;
    }

    private void loadOrder() {
        JSONObject object = new JSONReader(ORDER_RAW_ID).get() ;
        mOrder = new ArrayList<>() ;
        try {
            JSONArray array = object.getJSONArray("Order") ;
            for (int i = 0 ; i < array.length() ; i++) {
                mOrder.add(array.getString(i)) ;
            }
        } catch (Exception e) {}
    }

    private void loadTypes() {
        JSONObject object = new JSONSerializer(TYPES_FILENAME, TYPES_RAW_ID).get();
        mTypes = new HashMap<>() ;
        try {
            Iterator<String> keyIterator = object.keys();
            while (keyIterator.hasNext()) {
                String key = keyIterator.next();
                mTypes.put(key, new CalisthenicExerciseInfo(object.getJSONObject(key)));
            }
        } catch (Exception e) {}
    }

    @Override
    public ArrayList<Exercise> generateExercises() {

        ArrayList<Exercise> exercises = new ArrayList<>() ;
        ArrayList<Stack<Exercise>> sets = new ArrayList<>();

        for (String type : mOrder) {
            sets.add(mTypes.get(type).generateUniqueSets());
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
