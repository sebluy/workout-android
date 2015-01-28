package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises.StaticCoreExerciseFeedbackLayout;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseFeedback;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkout;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutFeedback;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/19/15.
 */
public class StaticCoreExerciseFeedbackFragment extends Fragment {

    public static final String EXTRA_EXERCISE_FEEDBACK_NUMBER =
            "com.wonderguerrilla.android.workout.exercise_feedback_number" ;

    private StaticCoreExerciseFeedbackLayout mLayout ;

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
        mLayout = new StaticCoreExerciseFeedbackLayout(feedback) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(mLayout.getLayout(), parent, false) ;
        mLayout.fillLayout(view) ;
        return view ;
    }


}
