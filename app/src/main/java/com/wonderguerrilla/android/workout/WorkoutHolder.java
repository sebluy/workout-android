package com.wonderguerrilla.android.workout;

import android.content.Context;

import com.wonderguerrilla.android.workout.calisthenic.CalisthenicWorkout;
import com.wonderguerrilla.android.workout.calisthenic.CalisthenicWorkoutGenerator;
import com.wonderguerrilla.android.workout.calisthenic.CalisthenicWorkoutInfo;
import com.wonderguerrilla.android.workout.lifting.LiftingWorkoutInfo;
import com.wonderguerrilla.android.workout.staticcore.StaticCoreWorkoutInfo;

import java.util.HashMap;

public class WorkoutHolder {

    private static final String RUN = "Run" ;
    private static final String SWIM = "Swim" ;

    private static final String[] sWorkoutNames = {
        LiftingWorkoutInfo.UPPER_NAME,
        RUN,
        CalisthenicWorkout.NAME,
        SWIM,
        LiftingWorkoutInfo.LOWER_NAME,
        BasketballWorkout.NAME,
        StaticCoreWorkout.NAME
    } ;

    private static HashMap<String, Workout> sWorkouts = new HashMap<>() ;
    private static Workout sCurrent;

    public static String[] getNames() {
        return sWorkoutNames ;
    }

    public static Workout create(String workoutName) {
        switch (workoutName) {
            case LiftingWorkoutInfo.UPPER_NAME:
                return LiftingWorkoutInfo.newUpper().getGenerator().newWorkout() ;
            case CalisthenicWorkout.NAME:
                return new CalisthenicWorkoutInfo().getGenerator().newWorkout() ;
            case LiftingWorkoutInfo.LOWER_NAME:
                return LiftingWorkoutInfo.newLower().getGenerator().newWorkout() ;
            case BasketballWorkout.NAME:
                return new BasketballWorkout(30) ;
            case StaticCoreWorkout.NAME:
                return new StaticCoreWorkoutInfo().getGenerator().newWorkout() ;
            default:
                return new Workout(workoutName) ;
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
