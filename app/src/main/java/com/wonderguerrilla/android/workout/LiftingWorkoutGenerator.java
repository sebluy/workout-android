package com.wonderguerrilla.android.workout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutGenerator extends WorkoutGenerator {

    private HashMap<String, LiftingExercise> mExercises ;
    private LiftingWorkoutOrderGenerator mOrderGenerator ;

    public LiftingWorkoutGenerator(JSONObject object, LiftingWorkoutOrderGenerator orderGenerator) {
        mOrderGenerator = orderGenerator ;
        mExercises = new HashMap<>() ;
        try {
            Iterator<String> keyIterator = object.keys() ;
            while (keyIterator.hasNext()) {
                String key = keyIterator.next() ;
                mExercises.put(key, new LiftingExercise(key, object.getJSONObject(key))) ;
            }
        } catch (Exception e) {}
    }

    public ArrayList<Exercise> generateExercises() {
        ArrayList<String> order = mOrderGenerator.generate() ;
        int size = order.size() ;
        ArrayList<Exercise> exerciseList = new ArrayList<>(size) ;
        for (int i = 0 ; i < size ; i++) {
            exerciseList.add(mExercises.get(order.get(i))) ;
        }
        return exerciseList ;
    }

}
