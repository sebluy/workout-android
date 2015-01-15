package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExerciseType {

    private String[] mVariations;
    private int mRepetitions;

    public CalisthenicExerciseType(JSONObject object) {
        try {
            mRepetitions = object.getInt("Repetitions") ;

            JSONArray variations = object.getJSONArray("Variations"); int length = variations.length() ;
            mVariations = new String[length] ;
            for (int i = 0 ; i < length ; i++) {
                mVariations[i] = variations.getString(i);
            }
        } catch (JSONException e) {
            mVariations = new String[0] ;
            mRepetitions = 0 ;
        }
    }

    public CalisthenicExerciseType(String[] variations, int repetitions) {
        mVariations = variations;
        mRepetitions = repetitions;
    }

    public void toJSON() throws JSONException {
        JSONObject object = new JSONObject() ;
        object.put("Repetitions", mRepetitions) ;
        JSONArray variations = new JSONArray() ;
        for (int i = 0 ; i < mVariations.length ; i++) {
            variations.put(mVariations[i]);
        }
        object.put("Variations", mVariations) ;
    }

    /* perhaps refactor into generic method that takes an array and dumps a new one
        without repeating elements before exhausting and also no matching neighbors
     */
    public ArrayList<Exercise> generateUniqueSets(int numberOfSets) {

        ArrayList<String> variations = new ArrayList<>(Arrays.asList(mVariations)) ;
        ArrayList<Exercise> exercises = new ArrayList<>(numberOfSets) ;

        Random rand = new Random() ;

        int variationIndex = 0 ;
        String lastVariation = null ;

        while (exercises.size() < numberOfSets) {

            if (variations.isEmpty()) {

                variations.addAll(Arrays.asList(mVariations)) ;

                /* add a variation that is not the last added */
                variations.remove(lastVariation) ;
                variationIndex = rand.nextInt(variations.size());
                String variation = variations.get(variationIndex);
                CalisthenicExercise newExercise = new CalisthenicExercise(variation, mRepetitions);
                exercises.add(newExercise);
                variations.remove(variationIndex);
                variations.add(lastVariation) ;
            }

            variationIndex = rand.nextInt(variations.size());
            String variation = variations.get(variationIndex);
            CalisthenicExercise newExercise = new CalisthenicExercise(variation, mRepetitions);
            exercises.add(newExercise);
            lastVariation = variations.remove(variationIndex) ;
        }

        return exercises ;
    }
}
