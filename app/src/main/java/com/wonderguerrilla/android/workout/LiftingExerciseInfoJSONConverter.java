package com.wonderguerrilla.android.workout;

import org.json.JSONObject;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingExerciseInfoJSONConverter {

    public static LiftingExerciseInfo convert(String name, JSONObject object) {
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
