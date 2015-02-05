package com.wonderguerrilla.android.workout.storage.json.run;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.storage.json.JSONSerializer;

import org.json.JSONObject;
import workout.run.CHIRunWorkoutInfo;

/**
 * Created by sebluy on 1/18/15.
 */
public class CHIRunWorkoutInfoJSONStorage {

    private static final String FILENAME = "chi_run_workout.json" ;

    private static final int RAW_ID = R.raw.chi_run_workout ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JSONSerializer mSerializer ;

    public CHIRunWorkoutInfoJSONStorage() {
        mSerializer = new JSONSerializer(FILENAME, RAW_ID) ;
    }

    public CHIRunWorkoutInfo getCHIInfo() {
        JSONObject object = mSerializer.get() ;
        try {

            double time = object.getDouble("Time");
            String unit = object.getString("Unit") ;
            double pace = object.getDouble("Pace") ;
            double distance = time / pace ;
            return new CHIRunWorkoutInfo(distance, unit, time, pace) ;

        } catch (Exception e) {
            return null ;
        }
    }
}
