package com.wonderguerrilla.android.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wonderguerrilla.android.workout.workout.Workout;

public class WorkoutListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        String[] workoutNames = WorkoutHolder.getNames() ;
        setListAdapter(new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, workoutNames)) ;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Workout newWorkout = WorkoutHolder.getFromPosition(position) ;
        WorkoutHolder.setCurrent(newWorkout) ;
        Intent intent = new Intent(getActivity(), WorkoutActivity.class) ;
        startActivity(intent) ;
    }

}
