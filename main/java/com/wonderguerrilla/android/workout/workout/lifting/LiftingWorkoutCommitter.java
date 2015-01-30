package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.storage.json.lifting.LiftingWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.ExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutController;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutCommitter {


    private LiftingWorkoutStorage mStorage ;

    public LiftingWorkoutCommitter(LiftingWorkoutController controller) {
        mStorage = controller.getStorage() ;
    }

    public void commit(Workout workout) {
        for (Exercise exercise : ((LiftingWorkout)workout).getExercises()) {
            LiftingExerciseInfo changedExercise = mStorage.getExercise(exercise.getName()) ;
            changedExercise.update((LiftingExercise)exercise) ;
        }
        mStorage.commit() ;
    }

}