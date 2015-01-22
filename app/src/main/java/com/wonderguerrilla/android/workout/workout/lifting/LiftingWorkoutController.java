package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.storage.json.lifting.LiftingWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutController;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutController implements WorkoutController {

    public static final String UPPER_NAME = "Upper Lifting" ;
    public static final String LOWER_NAME = "Lower Lifting" ;

    public static LiftingWorkoutController newUpper() {
        return new LiftingWorkoutController(UPPER_NAME, LiftingWorkoutJSONStorage.newUpper()) ;
    }

    public static LiftingWorkoutController newLower() {
        return new LiftingWorkoutController(LOWER_NAME , LiftingWorkoutJSONStorage.newLower()) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String mName;

    private LiftingWorkoutOrderGenerator mOrderGenerator ;
    private LiftingWorkoutGenerator mGenerator ;
    private LiftingWorkoutStorage mStorage ;

    public LiftingWorkoutController(String name, LiftingWorkoutJSONStorage storage) {
        mName = name ;
        mStorage = storage ;
        mOrderGenerator = new LiftingWorkoutOrderGenerator(storage) ;
        mGenerator = new LiftingWorkoutGenerator(this) ;
    }

    @Override
    public Workout generate() {
        return mGenerator.generate() ;
    }

    @Override
    public void commit(Workout workout) {
        MultipleExerciseWorkout exerciseWorkout = (MultipleExerciseWorkout)workout ;
        for (Exercise exercise : exerciseWorkout.getExercises()) {
            LiftingExerciseInfo changedExercise = mStorage.getExercise(exercise.getName()) ;
            changedExercise.setRepetitions(((LiftingExercise)exercise).getRepetitions()) ;
            changedExercise.setWeight(((LiftingExercise)exercise).getWeight()) ;
        }
        mStorage.commit() ;
    }

    public LiftingExerciseInfo getExercise(String name) {
        return mStorage.getExercise(name) ;
    }

    public LiftingWorkoutStorage getStorage() {
        return mStorage ;
    }

    public LiftingWorkoutGenerator getGenerator() {
        return mGenerator ;
    }

    public String getName() {
        return mName;
    }

    public LiftingWorkoutOrderGenerator getOrderGenerator() {
        return mOrderGenerator;
    }
}
