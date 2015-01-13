package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutGenerator {

    private HashMap<String, LiftingExercise> mExercises ;
    private String[] mOrder ;
    private Context mContext ;
    private int mResourceId ;

    public LiftingWorkoutGenerator(Context context, int exercisesId, int orderId) {
        mContext = context ;
        mResourceId = exercisesId ;
        mOrder = new LiftingWorkoutOrderGenerator(context, orderId).getOrder() ;
        loadExercises() ;
    }

    private void loadExercises() {
        mExercises = new HashMap<>() ;
        try {
            JSONObject object = new JSONSerializer(mContext, mResourceId).get() ;
            Iterator<String> keyIterator = object.keys() ;
            while (keyIterator.hasNext()) {
                String key = keyIterator.next() ;
                mExercises.put(key, new LiftingExercise(key, object.getJSONObject(key))) ;
            }
        } catch (Exception e) {}
    }

    public LiftingExercise[] exerciseArray() {
        int size = mExercises.size() ;
        LiftingExercise[] exerciseArray = new LiftingExercise[size] ;
        for (int i = 0 ; i < size ; i++) {
            exerciseArray[i] = mExercises.get(mOrder[i]) ;
        }
        return exerciseArray ;
    }

}
