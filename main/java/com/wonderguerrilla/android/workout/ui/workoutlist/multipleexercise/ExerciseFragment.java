package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wonderguerrilla.android.workout.ui.workoutlist.WorkoutHolder;
import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises.ExerciseView;
import workout.Exercise;
import workout.ExerciseWorkout;

/**
 * Created by sebluy on 12/25/14.
 */
public class ExerciseFragment extends Fragment {

    public static final String EXTRA_EXERCISE_NUMBER =
            "com.wonderguerrilla.android.workout.exercise_number" ;

    private ExerciseView mExerciseView;

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
        mExerciseView = ExerciseView.get(exercise) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View v = inflater.inflate(mExerciseView.getLayout(), parent, false) ;
        mExerciseView.fillLayout(v) ;

        return v ;
    }
}
