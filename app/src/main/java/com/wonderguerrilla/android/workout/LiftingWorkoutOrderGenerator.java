package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutOrderGenerator {

    private Context mContext ;
    private int mResourceId ;
    private boolean mLoaded ;
    private ArrayList<ArrayList<String>> mPrimaryPairs ;
    private ArrayList<ArrayList<String>> mInjuryPrevention ;
    private ArrayList<String> mOrder ;

    public LiftingWorkoutOrderGenerator(Context context, int resourceId) {
        mContext = context ;
        mResourceId = resourceId ;
    }

    public String[] getOrder() {
        if (!mLoaded) {
            loadExercises() ;
        }
        mOrder = new ArrayList<String>() ;
        addExercises(mPrimaryPairs);
        addExercises(mInjuryPrevention) ;
        return mOrder.toArray(new String[mOrder.size()]) ;
    }

    private ArrayList<ArrayList<String>> newArrayListArrayList(JSONArray json) {
        ArrayList<ArrayList<String>> outer = new ArrayList<>() ;
        try {
            for (int i = 0; i < json.length(); i++) {
                JSONArray innerJson = json.getJSONArray(i) ;
                ArrayList<String> innerArrayList = new ArrayList<>() ;
                for (int j = 0 ; j < innerJson.length() ; j++) {
                    innerArrayList.add(innerJson.getString(j)) ;
                }
                outer.add(innerArrayList) ;
            }
        } catch (Exception e) {}
        return outer ;
    }

    private void loadExercises() {
        JSONObject object = new JSONSerializer(mContext, mResourceId).get() ;
        try {
            mPrimaryPairs = newArrayListArrayList(object.getJSONArray("Primary Pairs"));
            mInjuryPrevention = newArrayListArrayList(object.getJSONArray("Injury Prevention"));
            mLoaded = true ;
        } catch (Exception e) {}
    }

    /* fix to order pairs in primary pairs */
    private void addExercises(ArrayList<ArrayList<String>> exerciseGroups) {
        Random random = new Random();
        while (exerciseGroups.size() > 0) {
            int groupIndex = random.nextInt(exerciseGroups.size());
            ArrayList<String> currentGroup = exerciseGroups.get(groupIndex);
            while (currentGroup.size() > 0) {
                int exerciseIndex = random.nextInt(currentGroup.size()) ;
                mOrder.add(currentGroup.get(exerciseIndex)) ;
                currentGroup.remove(exerciseIndex) ;
            }
            exerciseGroups.remove(groupIndex) ;
        }
    }

}
