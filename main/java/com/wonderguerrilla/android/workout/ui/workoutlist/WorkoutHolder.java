package com.wonderguerrilla.android.workout.ui.workoutlist;

import com.wonderguerrilla.android.workout.storage.json.calisthenic.CalisthenicWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.storage.json.lifting.LiftingWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.storage.json.run.RunWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.storage.json.staticcore.StaticCoreWorkoutJSONStorage;
import workout.BaseWorkout;
import workout.BasketballWorkout;
import workout.Workout;
import workout.calisthenic.CalisthenicWorkoutController;
import workout.lifting.LiftingWorkout;
import workout.lifting.LiftingWorkoutController;
import workout.run.RunWorkoutController;
import workout.staticcore.StaticCoreWorkoutController;

import java.util.HashMap;

public class WorkoutHolder {

    private static final String RUN = "Run" ;
    private static final String SWIM = "Swim" ;
    private static final String STRETCH = "Stretch" ;

    public static final String[] sWorkoutNames = {
        LiftingWorkout.UPPER_NAME,
        RUN,
        CalisthenicWorkoutController.NAME,
        SWIM,
        LiftingWorkout.LOWER_NAME,
        BasketballWorkout.NAME,
        StaticCoreWorkoutController.NAME,
        STRETCH
    } ;

    private static HashMap<String, Workout> sWorkouts = new HashMap<>() ;
    private static Workout sCurrent;

    public static String[] getNames() {
        return sWorkoutNames ;
    }

    public static Workout create(String workoutName) {
        switch (workoutName) {
            case LiftingWorkout.UPPER_NAME:
                return LiftingWorkoutController.newUpper(LiftingWorkoutJSONStorage.newUpper()).generate() ;
            case CalisthenicWorkoutController.NAME:
                return new CalisthenicWorkoutController(new CalisthenicWorkoutJSONStorage()).generate() ;
            case LiftingWorkout.LOWER_NAME:
                return LiftingWorkoutController.newLower(LiftingWorkoutJSONStorage.newLower()).generate() ;
            case BasketballWorkout.NAME:
                return new BasketballWorkout(30) ;
            case StaticCoreWorkoutController.NAME:
                return new StaticCoreWorkoutController(new StaticCoreWorkoutJSONStorage()).generate() ;
            case RunWorkoutController.NAME:
                return new RunWorkoutController(new RunWorkoutJSONStorage()).generate() ;
            default:
                return new BaseWorkout(null) ;
        }
    }

    public static Workout get(String name) {
        if (sWorkouts.containsKey(name)) {
            return sWorkouts.get(name).generate() ;
        } else {
            Workout newWorkout = create(name) ;
            sWorkouts.put(name, newWorkout) ;
            return newWorkout ;
        }
    }

    public static Workout getFromPosition(int position) {
        return get(sWorkoutNames[position]) ;
    }

    public static Workout getCurrent() {
        return sCurrent ;
    }

    public static void setCurrent(Workout workout) {
        sCurrent = workout ;
    }

}
