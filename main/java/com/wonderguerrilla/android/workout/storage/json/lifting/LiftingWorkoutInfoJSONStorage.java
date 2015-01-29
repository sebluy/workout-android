package com.wonderguerrilla.android.workout.storage.json.lifting;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.storage.json.JSONReader;
import com.wonderguerrilla.android.workout.storage.json.JSONSerializer;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutInfoJSONStorage {

    private static final String UPPER_FILENAME = "upper_lifting_exercises.json" ;
    private static final String LOWER_FILENAME = "lower_lifting_exercises.json" ;

    private static final int UPPER_RAW_ID = R.raw.upper_lifting_exercises ;
    private static final int LOWER_RAW_ID = R.raw.lower_lifting_exercises ;

    public static LiftingWorkoutInfoJSONStorage newUpper() {
        return new LiftingWorkoutInfoJSONStorage(UPPER_FILENAME, UPPER_RAW_ID) ;
    }

    public static LiftingWorkoutInfoJSONStorage newLower() {
        return new LiftingWorkoutInfoJSONStorage(LOWER_FILENAME, LOWER_RAW_ID) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JSONSerializer mSerializer ;
    private JSONReader mReader ;

    private HashMap<String, LiftingExerciseInfo> mExercises ;

    public LiftingWorkoutInfoJSONStorage(String filename, int rawId) {
        mSerializer = new JSONSerializer(filename, rawId) ;
        mReader = new JSONReader(rawId) ;
        mExercises = getExercises() ;
    }

    public void commit() {
         try {
            JSONObject object = new JSONObject() ;
            Iterator<String> nameIterator = mExercises.keySet().iterator() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                LiftingExerciseInfo exercise = mExercises.get(name) ;
                JSONObject exerciseJSON = LiftingExerciseInfoJSONConverter.toJSON(exercise) ;
                object.put(name, exerciseJSON) ;
            }
            mSerializer.put(object) ;
        } catch (Exception e) {}
    }

    public LiftingExerciseInfo getExercise(String name) {
        return mExercises.get(name) ;
    }

    private HashMap<String, LiftingExerciseInfo> getExercises() {
        HashMap<String, LiftingExerciseInfo> exercises = new HashMap<>() ;
//        JSONObject object = mSerializer.get() ;
        JSONObject object = mReader.get() ;
        mSerializer.put(object) ;
        try {
            Iterator<String> nameIterator = object.keys() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                JSONObject exerciseJSON = object.getJSONObject(name) ;
                LiftingExerciseInfo exercise =
                        LiftingExerciseInfoJSONConverter.fromJSON(name, exerciseJSON) ;
                exercises.put(name, exercise) ;
            }
        } catch (Exception e) {}
        return exercises ;
    }
}
