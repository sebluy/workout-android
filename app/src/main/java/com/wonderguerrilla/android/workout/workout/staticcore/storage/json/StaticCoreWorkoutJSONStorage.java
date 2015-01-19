package com.wonderguerrilla.android.workout.workout.staticcore.storage.json;

import com.wonderguerrilla.android.workout.JSONSerializer;
import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseInfo;
import com.wonderguerrilla.android.workout.workout.staticcore.storage.StaticCoreWorkoutStorage;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sebluy on 1/18/15.
 */
public class StaticCoreWorkoutJSONStorage implements StaticCoreWorkoutStorage {

    private static final String FILENAME = "static_core_exercises.json" ;

    private static final int RAW_ID = R.raw.static_core_exercises ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public ArrayList<StaticCoreExerciseInfo> getExercises() {
        ArrayList<StaticCoreExerciseInfo> exercises = new ArrayList<>() ;
        JSONObject object = new JSONSerializer(FILENAME, RAW_ID).get() ;
        try {
            Iterator<String> nameIterator = object.keys() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                JSONObject exerciseInfo = object.getJSONObject(name) ;
                exercises.add(convert(name, exerciseInfo)) ;
            }
        } catch (Exception e) {}
        return exercises ;
    }

    private StaticCoreExerciseInfo convert(String name, JSONObject object) {
        try {
            double duration = object.getDouble("Duration") ;
            return new StaticCoreExerciseInfo(name, duration) ;
        } catch (Exception e) {
            return null ;
        }
    }

}

