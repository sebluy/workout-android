package com.wonderguerrilla.android.workout.storage.json.calisthenic;

import com.wonderguerrilla.android.workout.JSONReader;
import com.wonderguerrilla.android.workout.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/18/15.
 */
public class CalisthenicWorkoutOrderJSONStorage {

    private static final int RAW_ID = R.raw.calisthenic_exercise_order ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<String> getOrder() {
        JSONObject object = new JSONReader(RAW_ID).get() ;
        ArrayList<String> order = new ArrayList<>() ;

        try {
            JSONArray array = object.getJSONArray("Order") ;
            for (int i = 0 ; i < array.length() ; i++) {
                order.add(array.getString(i)) ;
            }
        } catch (Exception e) {}

        return order ;
    }

}
