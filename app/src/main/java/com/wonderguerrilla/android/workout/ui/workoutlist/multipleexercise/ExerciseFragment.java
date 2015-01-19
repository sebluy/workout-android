package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wonderguerrilla.android.workout.ui.workoutlist.WorkoutHolder;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;

/**
 * Created by sebluy on 12/25/14.
 */
public class ExerciseFragment extends Fragment {

    public static final String EXTRA_EXERCISE_NUMBER =
            "com.wonderguerrilla.android.workout.exercise_number" ;

    private ExerciseUI mExerciseUI ;

    public static ExerciseFragment newInstance(int exerciseNumber) {
        Bundle args = new Bundle() ;
        args.putInt(EXTRA_EXERCISE_NUMBER, exerciseNumber) ;

        ExerciseFragment fragment = new ExerciseFragment() ;
        fragment.setArguments(args) ;

        return fragment ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        int exerciseNumber = getArguments().getInt(EXTRA_EXERCISE_NUMBER) ;
        MultipleExerciseWorkout workout = (MultipleExerciseWorkout) WorkoutHolder.getCurrent() ;
        Exercise exercise = workout.getExercise(exerciseNumber) ;
        mExerciseUI = ExerciseUI.get(exercise) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View v = inflater.inflate(mExerciseUI.getLayout(), parent, false) ;
        mExerciseUI.fillLayout(v) ;

        return v ;
    }
}
