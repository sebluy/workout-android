package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;

/**
 * Created by sebluy on 1/16/15.
 */

public class LiftingWorkoutStorage extends WorkoutStorage {

    private static LiftingWorkoutStorage sUpper ;
    private static LiftingWorkoutStorage sLower ;

    private static final String UPPER_EXERCISE_FILENAME = "upper_lifting_exercises.json" ;
    private static final String LOWER_EXERCISE_FILENAME = "lower_lifting_exercises.json" ;

    private static final int UPPER_ORDER_ID = R.raw.upper_lifting_exercise_order ;
    private static final int LOWER_ORDER_ID = R.raw.lower_lifting_exercise_order ;

    public static LiftingWorkoutStorage getUpper(Context context) {
        if (sUpper == null) {
            sUpper = new LiftingWorkoutStorage(context, UPPER_EXERCISE_FILENAME, UPPER_ORDER_ID) ;
        }
        return sUpper ;
    }

    public static LiftingWorkoutStorage getLower(Context context) {
        if (sLower == null) {
            sLower =  new LiftingWorkoutStorage(context, LOWER_EXERCISE_FILENAME, LOWER_ORDER_ID) ;
        }
        return sLower ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JSONSerializer mExerciseSerializer ;
    private JSONReader mOrderReader;
    private JSONObject mExercises ;
    private JSONObject mOrder ;

    public LiftingWorkoutStorage(Context context, String filename, int orderId) {
        mExerciseSerializer = new JSONSerializer(context, filename) ;
        mOrderReader = new JSONReader(context, orderId) ;
    }

    public JSONObject getExercises() {
        if (mExercises == null) {
            mExercises = mExerciseSerializer.get();
        }
        return mExercises ;
    }

    public JSONObject getOrder() {
        if (mOrder == null) {
            mOrder = mOrderReader.get() ;
        }
        return mOrder ;
    }
}
