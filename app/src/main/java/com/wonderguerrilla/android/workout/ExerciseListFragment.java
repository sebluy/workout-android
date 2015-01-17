package com.wonderguerrilla.android.workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExerciseListFragment extends ListFragment {

    MultipleExerciseWorkout mWorkout ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = (MultipleExerciseWorkout)WorkoutHolder.getCurrent() ;
        ArrayList<Exercise> names = new ArrayList<>(mWorkout.getExercises()) ;
        setListAdapter(new ExerciseAdapter(names)) ;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity(), ExercisePagerActivity.class) ;
        intent.putExtra(ExerciseFragment.EXTRA_EXERCISE_NUMBER, position) ;
        startActivity(intent) ;
    }

    public void update() {
        ExerciseAdapter adapter = (ExerciseAdapter)getListAdapter() ;
        adapter.clear() ;
        ArrayList<Exercise> exercises = mWorkout.getExercises() ;
        for (int i = 0 ; i < exercises.size() ; i++) {
            adapter.add(exercises.get(i)) ;
        }
    }

    private class ExerciseAdapter extends ArrayAdapter<Exercise> {

        public ExerciseAdapter(ArrayList<Exercise> exercises) {
            super(getActivity(), 0, exercises) ;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Exercise exercise = getItem(position) ;

            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(exercise.getListItemLayout(), null) ;
            }

            exercise.fillListItemLayout(convertView) ;

            return convertView ;
        }
    }
}
