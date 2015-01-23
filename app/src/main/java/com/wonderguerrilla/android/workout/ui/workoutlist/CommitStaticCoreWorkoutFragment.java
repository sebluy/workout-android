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
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseFeedback;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkout;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutFeedback;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/19/15.
 */
public class CommitStaticCoreWorkoutFragment extends Fragment {

    private StaticCoreWorkout mWorkout ;
    private StaticCoreWorkoutFeedback mFeedback ;

    private int getLayout() {
        return R.layout.fragment_commit_static_core_workout ;
    }

    private void fillLayout(View view) {
        ListView feedbackList = (ListView)view.findViewById(R.id.feedback_list) ;
        feedbackList.setAdapter(new CommitStaticCoreAdapter(mFeedback.getFeedbackList())) ;

        Button commit = (Button)view.findViewById(R.id.commit) ;
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commit() ;
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = (StaticCoreWorkout)WorkoutHolder.getCurrent() ;
        mFeedback = new StaticCoreWorkoutFeedback(mWorkout) ;
    }

    private void commit() {
        mWorkout.attachFeedback(mFeedback) ;
        mWorkout.commit() ;
        getActivity().finish() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), parent, false) ;
        fillLayout(view) ;
        return view ;
    }

    private class CommitStaticCoreAdapter extends ArrayAdapter<StaticCoreExerciseFeedback> {

        public CommitStaticCoreAdapter(ArrayList<StaticCoreExerciseFeedback> feedbackList) {
            super(getActivity(), 0, feedbackList) ;
        }

        private int getLayout() {
            return R.layout.list_item_static_core_exercise_feedback ;
        }

        private void fillLayout(View view, final StaticCoreExerciseFeedback feedback) {
            TextView name = (TextView)view.findViewById(R.id.name) ;
            name.setText(feedback.getExercise().getName()) ;

            TextView duration = (TextView)view.findViewById(R.id.duration) ;
            duration.setText(String.valueOf(feedback.getExercise().getDuration())) ;

            EditText difficulty = (EditText)view.findViewById(R.id.edit_difficulty) ;
            difficulty.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String string = s.toString();
                    if (!string.equals("")) {
                        feedback.setDifficulty(Integer.parseInt(string)) ;
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            }) ;

            difficulty.setText(String.valueOf(feedback.getDifficulty())) ;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            StaticCoreExerciseFeedback feedback = getItem(position) ;
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(getLayout(), null) ;
            }

            fillLayout(convertView, feedback) ;

            return convertView ;
        }
    }
}
