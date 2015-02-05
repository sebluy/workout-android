package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wonderguerrilla.android.workout.R;

import workout.Workout;
import workout.staticcore.StaticCoreWorkout;

/**
 * Created by sebluy on 1/19/15.
 */
public class CommitWorkoutFragment extends Fragment {

    public static Fragment get(Workout workout) {
        if (workout.getClass() == StaticCoreWorkout.class) {
            return new StaticCoreExerciseFeedbackFragment() ;
        } else {
            return new CommitWorkoutFragment() ;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Workout mWorkout ;

    public int getLayout() {
        return R.layout.fragment_commit_workout ;
    }

    public void fillLayout(View view) {
        Button commit = (Button)view.findViewById(R.id.commit) ;
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commit() ;
            }
        });
    }

    private void commit() {
        mWorkout.commit() ;
        Toast.makeText(getActivity(), "Much success!", Toast.LENGTH_SHORT).show() ;
        getActivity().finish() ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = WorkoutHolder.getCurrent() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), parent, false) ;
        fillLayout(view) ;
        return view ;
    }
}
