package com.wonderguerrilla.android.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {

    private void startNewExercisePagerActivity(String workoutName) {
        Intent intent = new Intent(getActivity(), ExercisePagerActivity.class) ;
        WorkoutHolder.put(WorkoutGenerator.create(workoutName, getActivity())) ;
        startActivity(intent) ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        String[] workoutNames = WorkoutGenerator.getWorkoutNames() ;
        setListAdapter(new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, workoutNames)) ;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        startNewExercisePagerActivity(WorkoutGenerator.getWorkoutNames()[position]) ;
    }

}
