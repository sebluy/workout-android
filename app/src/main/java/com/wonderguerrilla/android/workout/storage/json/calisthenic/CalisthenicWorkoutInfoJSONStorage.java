package com.wonderguerrilla.android.workout.storage.json.calisthenic;

import com.wonderguerrilla.android.workout.JSONSerializer;
import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.calisthenic.CalisthenicExerciseInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 1/18/15.
 */
public class CalisthenicWorkoutInfoJSONStorage {

    private static final String FILENAME = "calisthenic_exercises.json" ;

    private static final int RAW_ID = R.raw.calisthenic_exercises ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public HashMap<String, CalisthenicExerciseInfo> getExercises() {
        HashMap<String, CalisthenicExerciseInfo> exercises = new HashMap<>() ;
        JSONObject object = new JSONSerializer(FILENAME, RAW_ID).get() ;
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

    private CalisthenicExerciseInfo convert(String name, JSONObject object) {
        try {
            int repetitions = object.getInt("Repetitions") ;
            int sets = object.getInt("Sets") ;
            JSONArray JSONVariations = object.getJSONArray("Variations") ;
            ArrayList<String> variations = new ArrayList<>(JSONVariations.length()) ;
            for (int i = 0 ; i < JSONVariations.length() ; i++) {
                variations.add(JSONVariations.getString(i)) ;
            }
            return new CalisthenicExerciseInfo(name, variations, repetitions, sets) ;
        } catch (Exception e) {
            return null ;
        }
    }
}
