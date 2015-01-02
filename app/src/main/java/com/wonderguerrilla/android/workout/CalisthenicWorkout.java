package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkout extends Workout {

    public static CalisthenicWorkout generate() {
        int sets = 6 ;
        int numberOfExercises = 5 ;
        Exercise[] exercises = new Exercise[sets * numberOfExercises] ;
        for (int i = 0 ; i < sets ; i++) {
            for (int j = 0 ; j < numberOfExercises ; j++) {
                String exerciseName = CalisthenicExercise.randomExerciseName(j) ;
                int index = (i * numberOfExercises) + j ;
                exercises[index] = new CalisthenicExercise(exerciseName, 5, "Slow") ;
            }
        }
        return new CalisthenicWorkout(exercises) ;
    }

    public CalisthenicWorkout(Exercise[] exercises) {
        super("Calisthenic Workout", exercises) ;
    }

}
