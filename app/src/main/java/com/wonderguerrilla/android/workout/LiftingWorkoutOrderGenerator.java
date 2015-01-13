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

    private HashMap<String, LiftingExercise> mExercises ;
    private Context mContext ;
    private int mResourceId ;
    private ArrayList<String> mOrder ;

    public LiftingWorkoutOrderGenerator(Context context, int resourceId) {
        mContext = context ;
        mResourceId = resourceId ;
    }

    private void loadExercises() {
        mExercises = new HashMap<>() ;
        try {
            JSONObject object = new JSONSerializer(mContext, mResourceId).get() ;
            addExercises(object.getJSONArray("Primary")) ;
            addExercises(object.getJSONArray("Secondary")) ;
        } catch (Exception e) {}
    }

    /* use arraylists to avoid compatibility errors */
    private void addExercises(JSONArray exerciseGroups) {
        try {
            Random random = new Random();
            while (exerciseGroups.length() > 0) {
                int groupIndex = random.nextInt(exerciseGroups.length());
                JSONArray currentGroup = exerciseGroups.getJSONArray(groupIndex);
                while (currentGroup.length() > 0) {
                    int exerciseIndex = random.nextInt(currentGroup.length()) ;
                    mOrder.add(currentGroup.getString(exerciseIndex)) ;
                    currentGroup.remove(exerciseIndex) ;
                }
                exerciseGroups.remove(groupIndex) ;
            }
        } catch (Exception e) {}
    }

}
