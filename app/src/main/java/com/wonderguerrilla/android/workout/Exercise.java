package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by sebluy on 12/25/14.
 */

public class Exercise {

    private String mName ;

    public Exercise(String name) {
        mName = name ;
    }

    public String getName() {
        return mName ;
    }

    public JSONObject toJSON() {
        return new JSONObject() ;
    }

    public int getLayout() {
        return R.layout.fragment_exercise ;
    }

    public void fillLayout(View view) {
        TextView name = (TextView)view.findViewById(R.id.name) ;
        name.setText(mName) ;
    }
    public int getListItemLayout() {
        return R.layout.list_item_exercise ;
    }

    public void fillListItemLayout(View view) {
        fillLayout(view) ;
    }
}
