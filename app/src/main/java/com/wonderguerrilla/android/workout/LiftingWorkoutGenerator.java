package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutGenerator {

    private HashMap<String, LiftingExercise> mExercises ;
    private LiftingWorkoutOrderGenerator mOrderGenerator ;
    private JSONSerializer mSerializer ;

    public LiftingWorkoutGenerator(Context context, String filename, int orderId) {
        mSerializer = new JSONSerializer(context, filename) ;
        mOrderGenerator = new LiftingWorkoutOrderGenerator(context, orderId) ;
        loadExercises() ;
    }

    public void loadExercises() {
        mExercises = new HashMap<>() ;
        try {
            JSONObject object = mSerializer.get() ;
            Iterator<String> keyIterator = object.keys() ;
            while (keyIterator.hasNext()) {
                String key = keyIterator.next() ;
                mExercises.put(key, new LiftingExercise(key, object.getJSONObject(key))) ;
            }
        } catch (Exception e) {}
    }

    public void saveExercises() {
        JSONObject object = new JSONObject() ;
        Iterator<String> iterator = mExercises.keySet().iterator() ;
        while (iterator.hasNext()) {
            String key = iterator.next() ;
            LiftingExercise exercise = mExercises.get(key) ;
            JSONObject exerciseAsJSON = exercise.toJSON() ;
            try {
                object.put(key, exerciseAsJSON);
            } catch (Exception e) {}
        }
        mSerializer.put(object) ;
    }

    public ArrayList<Exercise> generateExercises() {
        String[] order = mOrderGenerator.generateOrder() ;
        int size = order.length ;
        ArrayList<Exercise> exerciseList = new ArrayList<>(size) ;
        for (int i = 0 ; i < size ; i++) {
            exerciseList.add(mExercises.get(order[i])) ;
        }
        return exerciseList ;
    }

}
