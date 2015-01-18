package com.wonderguerrilla.android.workout.CalisthenicWorkout;

import com.wonderguerrilla.android.workout.Exercise;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExerciseInfo {

    private ArrayList<String> mVariations;
    private int mRepetitions ;
    private int mSets ;

    public CalisthenicExerciseInfo(JSONObject object) {
        try {
            mRepetitions = object.getInt("Repetitions") ;
            mSets = object.getInt("Sets") ;
            JSONArray variations = object.getJSONArray("Variations") ;
            mVariations = new ArrayList<>(variations.length()) ;
            for (int i = 0 ; i < variations.length() ; i++) {
                mVariations.add(variations.getString(i)) ;
            }
        } catch (JSONException e) {
        }
    }

    public Stack<Exercise> generateUniqueSets() {
        Stack<Exercise> exercises = new Stack<>() ;
        Stack<String> pool = new Stack<>() ;
        while (exercises.size() < mSets) {
            if (pool.isEmpty()) {
                pool.addAll(mVariations) ;
                Collections.shuffle(pool);
            }
            exercises.push(new CalisthenicExercise(pool.pop(), mRepetitions)) ;
        }
        return exercises ;
    }
}
