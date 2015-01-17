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

    private ArrayList<ArrayList<String>> mPrimaryPairs;
    private ArrayList<ArrayList<String>> mInjuryPrevention;
    private ArrayList<String> mOrder;
    private Random mRandom;

    public LiftingWorkoutOrderGenerator(JSONObject object) {
         try {
            mPrimaryPairs = newArrayListArrayList(object.getJSONArray("Primary Pairs"));
            mInjuryPrevention = newArrayListArrayList(object.getJSONArray("Injury Prevention"));
            mRandom = new Random() ;
        } catch (Exception e) {}
    }

    public ArrayList<String> generate() {
        mOrder = new ArrayList<>() ;
        addPrimaryPairs() ;
        addInjuryPrevention() ;
        return mOrder ;
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

    private ArrayList<ArrayList<String>> copyArrayListArrayList(ArrayList<ArrayList<String>> outer) {
        ArrayList<ArrayList<String>> copy = new ArrayList<>();
        for (int i = 0 ; i < outer.size() ; i++) {
            copy.add(new ArrayList<>(outer.get(i))) ;
        }
        return copy ;
    }

    private void addPrimaryPairs() {

        ArrayList<ArrayList<String>> primaryPairsCopy = copyArrayListArrayList(mPrimaryPairs) ;

        int firstFromPair = mRandom.nextInt(2) ;

        while (primaryPairsCopy.size()> 0) {

            int groupIndex = mRandom.nextInt(primaryPairsCopy.size());

            ArrayList<String> currentGroup = primaryPairsCopy.get(groupIndex);

            mOrder.add(currentGroup.get(firstFromPair)) ;
            currentGroup.remove(firstFromPair) ;
            mOrder.add(currentGroup.get(0)) ;

            primaryPairsCopy.remove(groupIndex);
        }

    }

    private void addInjuryPrevention() {

        ArrayList<ArrayList<String>> injuryPreventionCopy = copyArrayListArrayList(mInjuryPrevention) ;

        while (injuryPreventionCopy.size() > 0) {
            int groupIndex = mRandom.nextInt(injuryPreventionCopy.size());
            ArrayList<String> currentGroup = injuryPreventionCopy.get(groupIndex);
            while (currentGroup.size() > 0) {
                int exerciseIndex = mRandom.nextInt(currentGroup.size()) ;
                mOrder.add(currentGroup.get(exerciseIndex)) ;
                currentGroup.remove(exerciseIndex) ;
            }
            injuryPreventionCopy.remove(groupIndex) ;
        }
    }

}
