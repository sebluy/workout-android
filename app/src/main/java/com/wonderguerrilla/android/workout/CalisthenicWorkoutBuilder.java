package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */
public abstract class CalisthenicWorkoutBuilder {

    protected abstract String[] getVariations() ;
    protected abstract CalisthenicExercise newInstance(String name) ;

    public CalisthenicExercise[] generateUniqueSets(int numberOfSets) {

        CalisthenicExercise[] exercises = new CalisthenicExercise[numberOfSets] ;

        for (int i = 0 ; i < numberOfSets ; i++) {

            String[] variations = getVariations() ;
            String name = variations[i % variations.length] ;
            exercises[i] = newInstance(name) ;
        }

        return exercises ;
    }

}
