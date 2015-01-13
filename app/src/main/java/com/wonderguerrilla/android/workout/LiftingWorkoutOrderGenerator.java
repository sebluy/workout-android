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

    private Context mContext;
    private int mResourceId;
    private boolean mLoaded;
    private ArrayList<ArrayList<String>> mPrimaryPairs;
    private ArrayList<ArrayList<String>> mInjuryPrevention;
    private ArrayList<String> mOrder;

    public LiftingWorkoutOrderGenerator(Context context, int resourceId) {
        mContext = context;
        mResourceId = resourceId;
    }

    public String[] getOrder() {
        if (!mLoaded) {
            loadExercises();
        }
        mOrder = new ArrayList<String>();
        addPrimaryPairs() ;
        addInjuryPrevention() ;
        return mOrder.toArray(new String[mOrder.size()]);
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

    private void loadExercises() {
        JSONObject object = new JSONSerializer(mContext, mResourceId).get();
        try {
            mPrimaryPairs = newArrayListArrayList(object.getJSONArray("Primary Pairs"));
            mInjuryPrevention = newArrayListArrayList(object.getJSONArray("Injury Prevention"));
            mLoaded = true;
        } catch (Exception e) {
        }
    }

    private void addPrimaryPairs() {

        Random random = new Random();
        int firstFromPair = random.nextInt(2) ;

        while(mPrimaryPairs.size()> 0) {

            int groupIndex = random.nextInt(mPrimaryPairs.size());

            ArrayList<String> currentGroup = mPrimaryPairs.get(groupIndex);

            mOrder.add(currentGroup.get(firstFromPair)) ;
            currentGroup.remove(firstFromPair) ;
            mOrder.add(currentGroup.get(0)) ;

            mPrimaryPairs.remove(groupIndex);
        }

    }

    private void addInjuryPrevention() {
        Random random = new Random();
        while (mInjuryPrevention.size() > 0) {
            int groupIndex = random.nextInt(mInjuryPrevention.size());
            ArrayList<String> currentGroup = mInjuryPrevention.get(groupIndex);
            while (currentGroup.size() > 0) {
                int exerciseIndex = random.nextInt(currentGroup.size()) ;
                mOrder.add(currentGroup.get(exerciseIndex)) ;
                currentGroup.remove(exerciseIndex) ;
            }
            mInjuryPrevention.remove(groupIndex) ;
        }
    }

}
