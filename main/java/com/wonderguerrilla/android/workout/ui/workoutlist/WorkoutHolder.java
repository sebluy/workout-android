package com.wonderguerrilla.android.workout.ui.workoutlist;

import com.wonderguerrilla.android.workout.workout.BasketballWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.calisthenic.CalisthenicWorkoutController;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingWorkoutController;
import com.wonderguerrilla.android.workout.workout.run.RunWorkoutController;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutController;

import java.util.HashMap;

public class WorkoutHolder {

    private static final String RUN = "Run" ;
    private static final String SWIM = "Swim" ;

    private static final String[] sWorkoutNames = {
        LiftingWorkoutController.UPPER_NAME,
        RUN,
        CalisthenicWorkoutController.NAME,
        SWIM,
        LiftingWorkoutController.LOWER_NAME,
        BasketballWorkout.NAME,
        StaticCoreWorkoutController.NAME
    } ;

    private static HashMap<String, Workout> sWorkouts = new HashMap<>() ;
    private static Workout sCurrent;

    public static String[] getNames() {
        return sWorkoutNames ;
    }

    public static Workout create(String workoutName) {
        switch (workoutName) {
            case LiftingWorkoutController.UPPER_NAME:
                return LiftingWorkoutController.newUpper().generate() ;
            case CalisthenicWorkoutController.NAME:
                return new CalisthenicWorkoutController().generate() ;
            case LiftingWorkoutController.LOWER_NAME:
                return LiftingWorkoutController.newLower().generate() ;
            case BasketballWorkout.NAME:
                return new BasketballWorkout(30) ;
            case StaticCoreWorkoutController.NAME:
                return new StaticCoreWorkoutController().generate() ;
            case RunWorkoutController.NAME:
                return new RunWorkoutController().generate() ;
            default:
                return new Workout(workoutName, null) ;
        }
    }

    public static Workout get(String name) {
        if (sWorkouts.containsKey(name)) {
            return sWorkouts.get(name) ;
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
