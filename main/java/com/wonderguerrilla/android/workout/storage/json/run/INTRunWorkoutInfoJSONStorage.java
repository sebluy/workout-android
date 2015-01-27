package com.wonderguerrilla.android.workout.storage.json.run;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.storage.json.JSONSerializer;
import com.wonderguerrilla.android.workout.workout.run.INTRunWorkoutInfo;
import com.wonderguerrilla.android.workout.workout.run.LSDRunWorkoutInfo;

import org.json.JSONObject;

/**
 * Created by sebluy on 1/18/15.
 */
public class INTRunWorkoutInfoJSONStorage {

    private static final String FILENAME = "int_run_workout.json" ;

    private static final int RAW_ID = R.raw.int_run_workout ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JSONSerializer mSerializer ;

    public INTRunWorkoutInfoJSONStorage() {
        mSerializer = new JSONSerializer(FILENAME, RAW_ID) ;
    }

    public INTRunWorkoutInfo getINTInfo() {
        JSONObject object = mSerializer.get() ;
        try {

            int intervals = object.getInt("Intervals") ;
            double distance = object.getDouble("Distance");
            String unit = object.getString("Unit") ;
            double pace = object.getDouble("Pace") ;
            double time = distance * pace ;
            return new INTRunWorkoutInfo(intervals, distance, unit, time, pace) ;

        } catch (Exception e) {
            return null ;
        }
    }
}
