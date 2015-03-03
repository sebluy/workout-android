package com.wonderguerrilla.android.workout.storage.json.lifting;

import org.json.JSONObject;
import workout.lifting.weight.Weight;
import workout.lifting.weight.Weights;

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
            return pickFromWeights(name, force) ;
        } catch (Exception e) {
            return null ;
        }
    }

    private static Weight pickFromWeights(String name, double force) {
        switch (name) {
            case "Plate": return Weights.newInstance(Weights.PLATE, force) ;
            case "Machine Lbs": return Weights.newInstance(Weights.MACHINE_LBS, force) ;
            case "Barbell": return Weights.newInstance(Weights.BARBELL, force) ;
            case "Calf Machine": return Weights.newInstance(Weights.CALF_MACHINE, force) ;
            case "Dumbbell": return Weights.newInstance(Weights.DUMBBELL, force) ;
            default: return null ;
        }
    }
}
