package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wonderguerrilla.android.workout.ui.workoutlist.WorkoutHolder;
import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises.ExerciseLayout;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.ExerciseWorkout;

/**
 * Created by sebluy on 12/25/14.
 */
public class ExerciseFragment extends Fragment {

    public static final String EXTRA_EXERCISE_NUMBER =
            "com.wonderguerrilla.android.workout.exercise_number" ;

    private ExerciseLayout mExerciseLayout;

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
        ExerciseWorkout workout = (ExerciseWorkout)WorkoutHolder.getCurrent() ;
        Exercise exercise = workout.getExercise(exerciseNumber) ;
        mExerciseLayout = ExerciseLayout.get(exercise) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View v = inflater.inflate(mExerciseLayout.getLayout(), parent, false) ;
        mExerciseLayout.fillLayout(v) ;

        return v ;
    }
}