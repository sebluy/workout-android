package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutGenerator extends WorkoutGenerator {

    private static final String UPPER_FILENAME = "upper_lifting_exercises.json" ;
    private static final String LOWER_FILENAME = "lower_lifting_exercises.json" ;

    private static final int UPPER_RAW_ID = R.raw.upper_lifting_exercises ;
    private static final int LOWER_RAW_ID = R.raw.lower_lifting_exercises ;

    public static LiftingWorkoutGenerator getUpper(Context context) {
        JSONObject object = new JSONSerializer(context, UPPER_FILENAME, UPPER_RAW_ID).get() ;
        LiftingWorkoutOrderGenerator orderGenerator = LiftingWorkoutOrderGenerator.getUpper(context) ;
        return new LiftingWorkoutGenerator(object, orderGenerator) ;
    }

    public static LiftingWorkoutGenerator getLower(Context context) {
        JSONObject object = new JSONSerializer(context, LOWER_FILENAME, LOWER_RAW_ID).get() ;
        LiftingWorkoutOrderGenerator orderGenerator = LiftingWorkoutOrderGenerator.getLower(context) ;
        return new LiftingWorkoutGenerator(object, orderGenerator) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

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
