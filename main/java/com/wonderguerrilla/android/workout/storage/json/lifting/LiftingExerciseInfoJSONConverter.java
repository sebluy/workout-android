package com.wonderguerrilla.android.workout.storage.json.lifting;

import org.json.JSONObject;
import workout.lifting.LiftingExerciseInfo;
import workout.lifting.weight.Weight;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingExerciseInfoJSONConverter {

    public static JSONObject toJSON(LiftingExerciseInfo exercise) {
        try {
            JSONObject object = new JSONObject() ;
            object.put("Repetitions", exercise.getRepetitions()) ;
            object.put("Weight", WeightJSONConverter.toJSON(exercise.getWeight())) ;
            return object ;
        } catch (Exception e) {
            return null ;
        }
    }

    public static LiftingExerciseInfo fromJSON(String name, JSONObject object) {
        try {
            int repetitions = object.getInt("Repetitions") ;
            JSONObject weightJSON = object.getJSONObject("Weight") ;
            Weight weight = WeightJSONConverter.fromJSON(weightJSON) ;
            return new LiftingExerciseInfo(name, weight, repetitions) ;
        } catch (Exception e) {
            return null ;
        }
    }

}
