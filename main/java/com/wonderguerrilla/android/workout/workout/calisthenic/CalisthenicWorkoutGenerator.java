package com.wonderguerrilla.android.workout.workout.calisthenic;

import com.wonderguerrilla.android.workout.workout.BaseExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.BaseWorkout;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.ExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkoutGenerator {

    private CalisthenicWorkoutController mInfo;
    private ArrayList<String> mOrder;
    private HashMap<String, CalisthenicExerciseInfo> mExercises;

    public CalisthenicWorkoutGenerator(CalisthenicWorkoutController info) {
        mInfo = info;
        mExercises = info.getStorage().getExercises();
        mOrder = info.getStorage().getOrder();
    }

    public Workout generate() {
        BaseWorkout base = new BaseWorkout(mInfo.getName(), mInfo) ;
        return new BaseExerciseWorkout(base, generateExercises()) ;
    }

    private ArrayList<Exercise> generateExercises() {

        ArrayList<Exercise> exercises = new ArrayList<>() ;
        ArrayList<Stack<Exercise>> sets = new ArrayList<>();

        for (String type : mOrder) {
            sets.add(mExercises.get(type).generateUniqueSets());
        }

        while (!sets.isEmpty()) {

            ArrayList<Integer> empty = new ArrayList<>() ;

            /* add exercise from each set */
            for (int i = 0 ; i < sets.size() ; i++) {
                Stack<Exercise> set = sets.get(i) ;
                if (!set.isEmpty()) {
                    exercises.add(set.pop());
                } else {
                    empty.add(i) ;
                }
            }

            Collections.reverse(empty) ;
            /* remove empty sets */
            for (int i = 0 ; i < empty.size() ; i++) {
                sets.remove(empty.get(i).intValue()) ;
            }
        }

        return exercises ;
    }

}
