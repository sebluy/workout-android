package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */

public class Workout {

    private String mName ;
    protected Exercise[] mExercises ;

    public Workout(String name, Exercise[] exercises) {
        mName = name ;
        mExercises = exercises ;
    }

    public void save() {}

    public String getName() {
        return mName ;
    }

    public void recreate() {}

    public Exercise getExercise(int index) {
        return mExercises[index] ;
    }

    public int size() {
        return mExercises.length ;
    }

    public String[] getExerciseNames() {
        String[] names = new String[size()] ;
        for (int i = 0 ; i < size() ; i++) {
            names[i] = getExercise(i).getName() ;
        }
        return names ;
    }
}
