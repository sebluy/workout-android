package com.wonderguerrilla.android.workout.workout.lifting.storage.json;

import com.wonderguerrilla.android.workout.JSONReader;
import com.wonderguerrilla.android.workout.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutOrderJSONStorage {

    private static final int UPPER_RAW_ID = R.raw.upper_lifting_exercise_order ;
    private static final int LOWER_RAW_ID = R.raw.lower_lifting_exercise_order ;

    public static LiftingWorkoutOrderJSONStorage newUpper() {
        return new LiftingWorkoutOrderJSONStorage(UPPER_RAW_ID) ;
    }

    public static LiftingWorkoutOrderJSONStorage newLower() {
        return new LiftingWorkoutOrderJSONStorage(LOWER_RAW_ID) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<ArrayList<String>> mPrimaryPairs ;
    private ArrayList<ArrayList<String>> mInjuryPrevention ;

    public LiftingWorkoutOrderJSONStorage(int rawId) {
        try {
            JSONObject object = new JSONReader(rawId).get() ;
            mPrimaryPairs = newArrayListArrayList(object.getJSONArray("Primary Pairs")) ;
            mInjuryPrevention = newArrayListArrayList(object.getJSONArray("Injury Prevention")) ;
        } catch (Exception e) {}
    }

    public ArrayList<ArrayList<String>> getPrimaryPairs() {
        return mPrimaryPairs ;
    }

    public ArrayList<ArrayList<String>> getInjuryPrevention() {
        return mInjuryPrevention ;
    }

    private ArrayList<ArrayList<String>> newArrayListArrayList(JSONArray json) {
        ArrayList<ArrayList<String>> outer = new ArrayList<>();
        try {
            for (int i = 0; i < json.length(); i++) {
                JSONArray innerJson = json.getJSONArray(i);
                ArrayList<String> innerArrayList = new ArrayList<>();
                for (int j = 0; j < innerJson.length(); j++) {
                    innerArrayList.add(innerJson.getString(j));
                }
                outer.add(innerArrayList);
            }
        } catch (Exception e) {
        }
        return outer;
    }


}
