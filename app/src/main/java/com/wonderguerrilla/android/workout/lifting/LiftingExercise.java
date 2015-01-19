package com.wonderguerrilla.android.workout.lifting;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.Exercise;
import com.wonderguerrilla.android.workout.R;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExercise extends Exercise {

    private double mWeight ;
    private String mUnit ;
    private int mRepetitions ;

    public LiftingExercise(String name, double weight, String unit, int repetitions) {
        super(name) ;
        mWeight = weight ;
        mUnit = unit ;
        mRepetitions = repetitions ;
    }

    public double getWeight() {
        return mWeight;
    }

    public int getRepetitions() {
        return mRepetitions;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_lifting_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;

        TextView weight = (TextView)view.findViewById(R.id.weight) ;
        EditText repetitions = (EditText)view.findViewById(R.id.edit_repetitions) ;
        repetitions.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = s.toString() ;
                if (!string.equals("")) {
                    mRepetitions = Integer.parseInt(string);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        weight.setText(mWeight + " " + mUnit) ;
        repetitions.setText(String.valueOf(mRepetitions)) ;

    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_lifting_exercise ;
    }

    @Override
    public void fillListItemLayout(View view) {
        super.fillLayout(view) ;

        TextView weight = (TextView)view.findViewById(R.id.weight) ;
        weight.setText(String.valueOf(mWeight + " " + mUnit)) ;

        TextView repetitions = (TextView)view.findViewById(R.id.repetitions) ;
        repetitions.setText(String.valueOf(mRepetitions + " Repetitions")) ;
    }

}
