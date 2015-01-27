package com.wonderguerrilla.android.workout.storage.json.run;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.storage.json.JSONSerializer;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;
import com.wonderguerrilla.android.workout.workout.run.LSDRunWorkoutInfo;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 1/18/15.
 */
public class LSDRunWorkoutInfoJSONStorage {

    private static final String FILENAME = "lsd_run_workout.json" ;

    private static final int RAW_ID = R.raw.lsd_run_workout ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JSONSerializer mSerializer ;

    public LSDRunWorkoutInfoJSONStorage() {
        mSerializer = new JSONSerializer(FILENAME, RAW_ID) ;
    }

    public LSDRunWorkoutInfo getLSDInfo() {
        JSONObject object = mSerializer.get() ;
        try {

            double distance = object.getDouble("Distance");
            String unit = object.getString("Unit") ;
            double pace = object.getDouble("Pace") ;
            double time = distance * pace ;
            return new LSDRunWorkoutInfo(distance, unit, time, pace) ;

        } catch (Exception e) {
            return null ;
        }
    }
}
