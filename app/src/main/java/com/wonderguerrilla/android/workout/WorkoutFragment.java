package com.wonderguerrilla.android.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutFragment extends ListFragment {

    Workout mWorkout ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = WorkoutHolder.get() ;
        setListAdapter(new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, mWorkout.getExerciseNames())) ;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity(), ExercisePagerActivity.class) ;
        intent.putExtra(ExerciseFragment.EXTRA_EXERCISE_NUMBER, position) ;
        startActivity(intent) ;
    }

}
