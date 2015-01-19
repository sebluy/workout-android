package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sebluy on 1/16/15.
 */
public class WorkoutFragment extends Fragment {

    private WorkoutFragmentUI mUI ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mUI = WorkoutFragmentUI.get(WorkoutHolder.getCurrent()) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(mUI.getLayout(), parent, false) ;
        mUI.fillLayout(view) ;
        return view ;
    }
}
