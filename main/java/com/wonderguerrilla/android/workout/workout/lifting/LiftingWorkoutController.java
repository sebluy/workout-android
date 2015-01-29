package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.storage.json.lifting.LiftingWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.ExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutController;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutController implements WorkoutController {

    public static LiftingWorkoutController newUpper() {
        return new LiftingWorkoutController(LiftingWorkout.UPPER_NAME, LiftingWorkoutJSONStorage.newUpper()) ;
    }

    public static LiftingWorkoutController newLower() {
        return new LiftingWorkoutController(LiftingWorkout.LOWER_NAME , LiftingWorkoutJSONStorage.newLower()) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String mName;

    private LiftingWorkoutOrderGenerator mOrderGenerator ;
    private LiftingWorkoutGenerator mGenerator ;
    private LiftingWorkoutStorage mStorage ;
    private LiftingWorkoutCommitter mCommitter ;

    public LiftingWorkoutController(String name, LiftingWorkoutJSONStorage storage) {
        mName = name ;
        mStorage = storage ;
        mOrderGenerator = new LiftingWorkoutOrderGenerator(storage) ;
        mGenerator = new LiftingWorkoutGenerator(this) ;
        mCommitter = new LiftingWorkoutCommitter(this) ;
    }

    @Override
    public Workout generate() {
        return mGenerator.generate() ;
    }

    @Override
    public void commit(Workout workout) {
        mCommitter.commit(workout) ;
    }

    public LiftingExerciseInfo getExercise(String name) {
        return mStorage.getExercise(name) ;
    }

    public LiftingWorkoutStorage getStorage() {
        return mStorage ;
    }

    public String getName() {
        return mName;
    }

    public LiftingWorkoutOrderGenerator getOrderGenerator() {
        return mOrderGenerator;
    }
}
