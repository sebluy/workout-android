package com.wonderguerrilla.android.workout;

import java.lang.reflect.Method;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkout extends Workout {

    private static final int NUMBER_OF_SETS = 6 ;
    private static final int NUMBER_OF_EXERCISE_TYPES = 5 ;
    private static final int NUMBER_OF_EXERCISES = NUMBER_OF_EXERCISE_TYPES * NUMBER_OF_SETS ;

    public static CalisthenicWorkout generate() {
        Exercise[] exercises = new Exercise[NUMBER_OF_EXERCISES] ;

        Exercise[] pushUpExercises = CalisthenicExerciseType.PUSH_UP.generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] pullUpExercises = CalisthenicExerciseType.PULL_UP.generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] coreExercises = CalisthenicExerciseType.DYNAMIC_CORE.generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] squatExercises = CalisthenicExerciseType.SQUAT.generateUniqueSets(NUMBER_OF_SETS) ;
        Exercise[] lungeExercises = CalisthenicExerciseType.LUNGE.generateUniqueSets(NUMBER_OF_SETS) ;

        for (int i = 0 ; i < NUMBER_OF_SETS ; i++) {
            int exerciseIndex = NUMBER_OF_EXERCISE_TYPES * i ;
            exercises[exerciseIndex++] = pushUpExercises[i] ;
            exercises[exerciseIndex++] = squatExercises[i] ;
            exercises[exerciseIndex++] = coreExercises[i] ;
            exercises[exerciseIndex++] = pullUpExercises[i] ;
            exercises[exerciseIndex] = lungeExercises[i] ;
        }

        return new CalisthenicWorkout(exercises) ;
    }

    public CalisthenicWorkout(Exercise[] exercises) {
        super("Calisthenic Workout", exercises) ;
    }

}
