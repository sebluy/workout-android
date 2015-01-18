package com.wonderguerrilla.android.workout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutInfoStorage {

    private static final String UPPER_FILENAME = "upper_lifting_exercises.json" ;
    private static final String LOWER_FILENAME = "lower_lifting_exercises.json" ;

    private static final int UPPER_RAW_ID = R.raw.upper_lifting_exercises ;
    private static final int LOWER_RAW_ID = R.raw.lower_lifting_exercises ;

    public static LiftingWorkoutInfoStorage newUpper() {
        return new LiftingWorkoutInfoStorage(UPPER_FILENAME, UPPER_RAW_ID) ;
    }

    public static LiftingWorkoutInfoStorage newLower() {
        return new LiftingWorkoutInfoStorage(LOWER_FILENAME, LOWER_RAW_ID) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String mFilename ;
    private int mRawId ;

    public LiftingWorkoutInfoStorage(String filename, int rawId) {
        mFilename = filename ;
        mRawId = rawId ;
    }

    public HashMap<String, LiftingExerciseInfo> getExercises() {
        HashMap<String, LiftingExerciseInfo> exercises = new HashMap<>() ;
        JSONObject object = new JSONSerializer(mFilename, mRawId).get() ;
        try {
            Iterator<String> nameIterator = object.keys() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                JSONObject exerciseInfo = object.getJSONObject(name) ;
                exercises.put(name, convert(name, exerciseInfo)) ;
            }
        } catch (Exception e) {}
        return exercises ;
    }

    private LiftingExerciseInfo convert(String name, JSONObject object) {
        try {

            int repetitions = object.getInt("Repetitions") ;
            String unit = object.getString("Unit") ;
            int weight = object.getInt("Weight") ;

            return new LiftingExerciseInfo(name, weight, unit, repetitions) ;

        } catch (Exception e) {
            return null ;
        }
    }
}
