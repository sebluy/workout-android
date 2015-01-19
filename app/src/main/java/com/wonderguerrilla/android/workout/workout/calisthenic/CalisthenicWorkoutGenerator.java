package com.wonderguerrilla.android.workout.workout.calisthenic;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.WorkoutGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkoutGenerator implements WorkoutGenerator {

    private CalisthenicWorkoutInfo mInfo ;
    private ArrayList<String> mOrder ;
    private HashMap<String, CalisthenicExerciseInfo> mExercises ;

    public CalisthenicWorkoutGenerator(CalisthenicWorkoutInfo info) {
        mInfo = info ;
        mExercises = info.getStorage().getExercises() ;
        mOrder = info.getStorage().getOrder() ;
    }

    public MultipleExerciseWorkout newWorkout() {
        return new MultipleExerciseWorkout(mInfo.getName(), this) ;
    }


    @Override
    public void commit(ArrayList<Exercise> exercises) {}

    @Override
    public ArrayList<Exercise> generateExercises() {

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
