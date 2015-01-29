package com.wonderguerrilla.android.workout.storage.json.lifting;

import com.wonderguerrilla.android.workout.workout.lifting.weight.Weight;
import org.json.JSONObject;

/**
 * Created by sebluy on 1/29/15.
 */
public class WeightJSONConverter {

    public static JSONObject toJSON(Weight weight) {
        try {
            JSONObject object = new JSONObject() ;
            object.put("Force", weight.getForce()) ;
            object.put("Name", weight.getName()) ;
            return object ;
        } catch (Exception e) {
            return null ;
        }
    }

    public static Weight fromJSON(JSONObject object) {
        try {
            double force = object.getDouble("Force") ;
            String name = object.getString("Name") ;
            return Weight.newInstance(name, force) ;
        } catch (Exception e) {
            return null ;
        }
    }
}
