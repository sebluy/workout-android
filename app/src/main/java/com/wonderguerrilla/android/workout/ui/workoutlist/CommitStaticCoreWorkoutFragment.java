package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutFeedback;

/**
 * Created by sebluy on 1/19/15.
 */
public class CommitStaticCoreWorkoutFragment extends Fragment {

    private MultipleExerciseWorkout mWorkout ;
    private StaticCoreWorkoutFeedback mFeedback ;

    public int getLayout() {
        return R.layout.fragment_commit_static_core_workout ;
    }

    public void fillLayout(View view) {
        ListView order = (ListView)view.findViewById(R.id.exercises) ;
        order.setAdapter(new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, mFeedback.getFeedbackList())) ;

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
        mWorkout = WorkoutHolder.getCurrent() ;
        mFeedback = new StaticCoreWorkoutFeedback(mWorkout) ;
    }

    private void commit() {
        mWorkout.commit(mFeedback) ;
        getActivity().finish() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), parent, false) ;
        fillLayout(view) ;
        return view ;
    }
}
