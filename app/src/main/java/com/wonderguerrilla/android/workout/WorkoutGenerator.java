package com.wonderguerrilla.android.workout;

public class WorkoutGenerator {

    public static final int CALISTHENIC_WORKOUT_ID = 0 ;
    public static final int UPPER_LIFTING_WORKOUT_ID = 1 ;
    public static final int LOWER_LIFTING_WORKOUT_ID = 2 ;

    public static Workout fromID(int id) {
        switch (id) {
            case CALISTHENIC_WORKOUT_ID:
                return new CalisthenicWorkout() ;
            case UPPER_LIFTING_WORKOUT_ID:
                return new LiftingWorkout(UPPER_LIFTING_WORKOUT_ID) ;
            case LOWER_LIFTING_WORKOUT_ID:
                return new LiftingWorkout(LOWER_LIFTING_WORKOUT_ID) ;
            default:
                return null ;
        }
    }
}
