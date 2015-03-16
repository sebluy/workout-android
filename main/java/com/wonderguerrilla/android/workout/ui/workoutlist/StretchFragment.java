package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises.TimerView;

/**
 * Created by sebluy on 1/19/15.
 */
public class StretchFragment extends Fragment {

    StretchView mDurationView ;

    public int getLayout() {
        return R.layout.fragment_stretch;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stretch, parent, false) ;
        mDurationView = (StretchView)view.findViewById(R.id.time);
        mDurationView.setText("15.0 Seconds") ;
        return view ;
    }

    @Override
    public void onDestroy() {
        super.onDestroy() ;
        mDurationView.getTimer().cancel() ;
    }

}
