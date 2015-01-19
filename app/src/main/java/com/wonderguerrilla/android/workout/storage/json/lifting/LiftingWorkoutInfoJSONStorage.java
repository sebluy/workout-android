package com.wonderguerrilla.android.workout.storage.json.lifting;

import com.wonderguerrilla.android.workout.JSONSerializer;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;
import com.wonderguerrilla.android.workout.R;

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

    public LiftingWorkoutInfoJSONStorage(String filename, int rawId) {
        mSerializer = new JSONSerializer(filename, rawId) ;
    }

    public HashMap<String, LiftingExerciseInfo> getExercises() {
        HashMap<String, LiftingExerciseInfo> exercises = new HashMap<>() ;
        JSONObject object = mSerializer.get() ;
        try {
            Iterator<String> nameIterator = object.keys() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                JSONObject exerciseInfo = object.getJSONObject(name) ;
                exercises.put(name, convertFromJSON(name, exerciseInfo)) ;
            }
        } catch (Exception e) {}
        return exercises ;
    }

    public void putExercises(HashMap<String, LiftingExerciseInfo> exercises) {
         try {
            JSONObject object = new JSONObject() ;
            Iterator<String> nameIterator = exercises.keySet().iterator() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                LiftingExerciseInfo exercise = exercises.get(name) ;
                object.put(name, convertToJSON(name, exercise)) ;
            }
            mSerializer.put(object) ;
        } catch (Exception e) {}
    }

    private JSONObject convertToJSON(String name, LiftingExerciseInfo exercise) {
        try {

            JSONObject object = new JSONObject() ;
            object.put("Repetitions", exercise.getRepetitions()) ;
            object.put("Unit", exercise.getUnit()) ;
            object.put("Weight", exercise.getWeight()) ;
            return object ;

        } catch (Exception e) {
            return null ;
        }
    }

    private LiftingExerciseInfo convertFromJSON(String name, JSONObject object) {
        try {

            int repetitions = object.getInt("Repetitions") ;
            String unit = object.getString("Unit") ;
            double weight = object.getDouble("Weight") ;
            return new LiftingExerciseInfo(name, weight, unit, repetitions) ;

        } catch (Exception e) {
            return null ;
        }
    }
}
