package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises.StaticCoreExerciseFeedbackView;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseFeedback;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkout;

/**
 * Created by sebluy on 1/19/15.
 */
public class StaticCoreExerciseFeedbackFragment extends Fragment {

    public static final String EXTRA_EXERCISE_FEEDBACK_NUMBER =
            "com.wonderguerrilla.android.workout.exercise_feedback_number" ;

    private StaticCoreExerciseFeedbackView mLayout ;

    public static StaticCoreExerciseFeedbackFragment newInstance(int number) {
        Bundle args = new Bundle() ;
        args.putInt(EXTRA_EXERCISE_FEEDBACK_NUMBER, number) ;

        StaticCoreExerciseFeedbackFragment fragment = new StaticCoreExerciseFeedbackFragment() ;
        fragment.setArguments(args) ;

        return fragment ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        int number = getArguments().getInt(EXTRA_EXERCISE_FEEDBACK_NUMBER) ;
        StaticCoreWorkout workout = (StaticCoreWorkout)WorkoutHolder.getCurrent() ;

        StaticCoreExerciseFeedback feedback = workout.getFeedback().getFeedbackList().get(number) ;
        mLayout = new StaticCoreExerciseFeedbackView(feedback) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(mLayout.getLayout(), parent, false) ;
        mLayout.fillLayout(view) ;
        return view ;
    }


}
