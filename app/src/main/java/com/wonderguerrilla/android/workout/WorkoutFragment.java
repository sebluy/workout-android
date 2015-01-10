package com.wonderguerrilla.android.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WorkoutFragment extends Fragment {

    Workout mWorkout ;

    public void startNewExercisePagerActivity(String workoutName) {
        Intent intent = new Intent(getActivity(), ExercisePagerActivity.class) ;
        startActivity(intent) ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = WorkoutHolder.get() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(mWorkout.getLayout(), parent, false) ;
        mWorkout.fillLayout(view, this) ;
        return view ;
    }
}
