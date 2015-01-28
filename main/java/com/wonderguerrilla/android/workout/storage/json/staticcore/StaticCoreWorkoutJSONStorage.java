package com.wonderguerrilla.android.workout.storage.json.staticcore;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.storage.json.JSONSerializer;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseInfo;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutStorage;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 1/18/15.
 */
public class StaticCoreWorkoutJSONStorage implements StaticCoreWorkoutStorage {

    private static final String FILENAME = "static_core_exercises.json" ;

    private static final int RAW_ID = R.raw.static_core_exercises ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<StaticCoreExerciseInfo> mExerciseList ;
    private HashMap<String, StaticCoreExerciseInfo> mExerciseMap ;
    private JSONSerializer mSerializer ;

    public StaticCoreWorkoutJSONStorage() {
        mSerializer = new JSONSerializer(FILENAME, RAW_ID) ;
        mExerciseList = getExercises() ;
        mExerciseMap = new HashMap<>() ;
        for (StaticCoreExerciseInfo exercise : mExerciseList) {
            mExerciseMap.put(exercise.getName(), exercise) ;
        }
    }

    public StaticCoreExerciseInfo getExercise(String name) {
        return mExerciseMap.get(name) ;
    }

    public ArrayList<StaticCoreExerciseInfo> getExerciseList() {
        return mExerciseList ;
    }

    public void commit() {
        try {
            JSONObject object = new JSONObject() ;
            Iterator<String> nameIterator = mExerciseMap.keySet().iterator() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                StaticCoreExerciseInfo exercise = mExerciseMap.get(name) ;
                object.put(name, convertToJSON(exercise)) ;
            }
            mSerializer.put(object) ;
        } catch (Exception e) {}
    }

    private ArrayList<StaticCoreExerciseInfo> getExercises() {
        ArrayList<StaticCoreExerciseInfo> exercises = new ArrayList<>() ;
        JSONObject object = mSerializer.get() ;
        try {
            Iterator<String> nameIterator = object.keys() ;
            while (nameIterator.hasNext()) {
                String name = nameIterator.next() ;
                JSONObject exerciseInfo = object.getJSONObject(name) ;
                exercises.add(convertFromJSON(name, exerciseInfo)) ;
            }
        } catch (Exception e) {}
        return exercises ;
    }

    private StaticCoreExerciseInfo convertFromJSON(String name, JSONObject object) {
        try {
            double duration = object.getDouble("Duration") ;
            return new StaticCoreExerciseInfo(name, duration) ;
        } catch (Exception e) {
            return null ;
        }
    }

    private JSONObject convertToJSON(StaticCoreExerciseInfo exercise) {
        try {
            JSONObject object = new JSONObject() ;
            object.put("Duration", exercise.getDuration()) ;
            return object ;
        } catch (Exception e) {
            return null ;
        }
    }
}

