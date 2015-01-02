package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExercise implements Exercise {

    private static final String[] CHEST_EXERCISES = {
            "Normal Push-Up",
            "Knuckle Push-Up",
            "Fingertip Push-Up",
            "Wide Grip Push-Up",
            "Diamond Push-Up",
            "T Push-Up",
            "Pike Push-Up",
            "Dive Bomber Push-Up",
    } ;

    private static final String[] BACK_EXERCISES = {
            "Normal Grid Pull-Up",
            "Narrow Grip Pull-Up",
            "Wide Grip Pull-Up",
            "Parallel Pull-Up",
            "Commando Pull-Up Right",
            "Commando Pull-Up Left"
    } ;

    private static final String[] ABDOMINAL_EXERCISES = {
            "Normal Crunch",
            "Reverse Crunch",
            "Double Crunch",
            "Bicycle Crunch",
            "Wiper",
            "Flutter Kick"
    } ;

    private static final String[] SQUAT_EXERCISES = {
            "Squat",
            "Vertical Jump",
            "Forward Jump",
            "Horizontal Jump"
    } ;

    private static final String[] LUNGE_EXERCISES = {
            "Forward Lunge",
            "Backward Lunge"
    } ;

    public static final String[][] CALISTHENIC_EXERCISES = {
            CHEST_EXERCISES,
            BACK_EXERCISES,
            ABDOMINAL_EXERCISES,
            SQUAT_EXERCISES,
            LUNGE_EXERCISES
    } ;

    static String randomExerciseName(int type) {
        Random generator = new Random() ;
        int exercise = generator.nextInt(CALISTHENIC_EXERCISES[type].length) ;
        return CALISTHENIC_EXERCISES[type][exercise] ;
    }

    private String mName ;
    int mRepetitions ;
    String mSpeed ; /* perhaps use enum for speed */

    public CalisthenicExercise(String name, int repetitions, String speed) {
        mName = name ;
        mRepetitions = repetitions ;
        mSpeed = speed ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_calisthenic_exercise ;
    }

    @Override
    public void fillLayout(View v) {

        TextView name = (TextView)v.findViewById(R.id.calisthenic_exercise_name) ;
        TextView reps = (TextView)v.findViewById(R.id.calisthenic_exercise_repetitions) ;
        TextView speed = (TextView)v.findViewById(R.id.calisthenic_exercise_speed) ;

        name.setText(mName) ;
        reps.setText(mRepetitions + " Repetitions") ;
        speed.setText(mSpeed) ;

    }
}
