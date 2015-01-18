package com.wonderguerrilla.android.workout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutOrderStorage {

    private static final int UPPER_RAW_ID = R.raw.upper_lifting_exercise_order ;
    private static final int LOWER_RAW_ID = R.raw.lower_lifting_exercise_order ;

    public static LiftingWorkoutOrderStorage newUpper() {
        return new LiftingWorkoutOrderStorage(UPPER_RAW_ID) ;
    }

    public static LiftingWorkoutOrderStorage newLower() {
        return new LiftingWorkoutOrderStorage(LOWER_RAW_ID) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<ArrayList<String>> mPrimaryPairs ;
    private ArrayList<ArrayList<String>> mInjuryPrevention ;

    public LiftingWorkoutOrderStorage(int rawId) {
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
