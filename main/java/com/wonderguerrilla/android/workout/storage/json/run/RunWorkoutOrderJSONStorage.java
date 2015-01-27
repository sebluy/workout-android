package com.wonderguerrilla.android.workout.storage.json.run;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.storage.json.JSONSerializer;
import com.wonderguerrilla.android.workout.workout.run.LSDRunWorkoutInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/18/15.
 */
public class RunWorkoutOrderJSONStorage {

    private static final String FILENAME = "run_workout_order.json" ;

    private static final int RAW_ID = R.raw.run_workout_order ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private JSONSerializer mSerializer ;

    public RunWorkoutOrderJSONStorage() {
        mSerializer = new JSONSerializer(FILENAME, RAW_ID) ;
    }

    public ArrayList<String> getOrder() {
        JSONObject object = mSerializer.get() ;
        ArrayList<String> order = new ArrayList<>() ;
        try {
            JSONArray jsonArray = object.getJSONArray("Order") ;
            for (int i = 0 ; i < jsonArray.length() ; i++) {
                order.add(jsonArray.getString(i)) ;
            }
        } catch (Exception e) {
        }
        return order ;
    }
}
