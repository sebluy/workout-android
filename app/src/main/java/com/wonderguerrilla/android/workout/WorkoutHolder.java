package com.wonderguerrilla.android.workout;

public class WorkoutHolder {

    public static Workout sHolder ;

    public static Workout get() {
        return sHolder ;
    }

    public static void put(Workout workout) {
        sHolder = workout ;
    }

}
