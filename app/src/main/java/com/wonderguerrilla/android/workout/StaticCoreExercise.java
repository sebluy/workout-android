package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by sebluy on 12/25/14.
 */

public class StaticCoreExercise extends Exercise {

    int mDuration ;

    public StaticCoreExercise(String name, JSONObject object) {
        super(name) ;
        try {
            mDuration = object.getInt("Duration") ;
        } catch (Exception e) {}
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_static_core_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;

        TextView duration = (TextView)view.findViewById(R.id.duration) ;
        duration.setText(mDuration + " Seconds") ;
    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_static_core_exercise ;
    }

}
