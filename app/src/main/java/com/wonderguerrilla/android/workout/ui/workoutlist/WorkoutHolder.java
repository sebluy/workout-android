package com.wonderguerrilla.android.workout.ui.workoutlist;

import com.wonderguerrilla.android.workout.workout.BasketballWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.calisthenic.CalisthenicWorkoutInfo;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingWorkoutInfo;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutInfo;

import java.util.HashMap;

public class WorkoutHolder {

    private static final String RUN = "Run" ;
    private static final String SWIM = "Swim" ;

    private static final String[] sWorkoutNames = {
        LiftingWorkoutInfo.UPPER_NAME,
        RUN,
        CalisthenicWorkoutInfo.NAME,
        SWIM,
        LiftingWorkoutInfo.LOWER_NAME,
        BasketballWorkout.NAME,
        StaticCoreWorkoutInfo.NAME
    } ;

    private static HashMap<String, Workout> sWorkouts = new HashMap<>() ;
    private static Workout sCurrent;

    public static String[] getNames() {
        return sWorkoutNames ;
    }

    public static Workout create(String workoutName) {
        switch (workoutName) {
            case LiftingWorkoutInfo.UPPER_NAME:
                return LiftingWorkoutInfo.newUpper().generate() ;
            case CalisthenicWorkoutInfo.NAME:
                return new CalisthenicWorkoutInfo().generate() ;
            case LiftingWorkoutInfo.LOWER_NAME:
                return LiftingWorkoutInfo.newLower().generate() ;
            case BasketballWorkout.NAME:
                return new BasketballWorkout(30) ;
            case StaticCoreWorkoutInfo.NAME:
                return new StaticCoreWorkoutInfo().generate() ;
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
