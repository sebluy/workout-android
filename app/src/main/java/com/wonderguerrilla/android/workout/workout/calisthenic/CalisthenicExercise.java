package com.wonderguerrilla.android.workout.workout.calisthenic;

import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.R;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExercise extends Exercise {

    private int mRepetitions ;

    public CalisthenicExercise(String name, int repetitions) {
        super(name) ;
        mRepetitions = repetitions ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_calisthenic_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;
        TextView repetitions = (TextView)view.findViewById(R.id.repetitions) ;
        repetitions.setText(mRepetitions + " Repetitions") ;
    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_calisthenic_exercise ;
    }

    @Override
    public void fillListItemLayout(View view) {
        fillLayout(view) ;
    }
}
