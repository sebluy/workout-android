package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wonderguerrilla.android.workout.R;
import workout.run.RunWorkout;

/**
 * Created by sebluy on 1/19/15.
 */
public class RunWorkoutFragment extends WorkoutFragment {

    private RunWorkout mWorkout ;

    @Override
    public int getLayout() {
        return R.layout.fragment_run_workout ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;
        ListView order = (ListView)view.findViewById(R.id.order) ;
        order.setAdapter(new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, mWorkout.getOrder())) ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = (RunWorkout)WorkoutHolder.getCurrent() ;
    }
}
