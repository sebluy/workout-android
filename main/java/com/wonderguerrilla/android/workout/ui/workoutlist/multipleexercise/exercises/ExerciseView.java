package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises;

import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;
import workout.Exercise;
import workout.calisthenic.CalisthenicExercise;
import workout.lifting.LiftingExercise;
import workout.staticcore.StaticCoreExercise;

/**
 * Created by sebluy on 1/19/15.
 */
public class ExerciseView {

    public static ExerciseView get(Exercise exercise) {
        if (exercise.getClass() == LiftingExercise.class) {
            return new LiftingExerciseView(exercise);
        } else if (exercise.getClass() == StaticCoreExercise.class) {
            return new StaticCoreExerciseView(exercise) ;
        } else if (exercise.getClass() == CalisthenicExercise.class) {
            return new CalisthenicExerciseView(exercise) ;
        } else {
            return new ExerciseView(exercise);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Exercise mExercise ;

    public ExerciseView(Exercise exercise) {
        mExercise = exercise ;
    }

    public int getLayout() {
        return R.layout.fragment_exercise ;
    }

    public void fillLayout(View view) {
        TextView name = (TextView)view.findViewById(R.id.name) ;
        name.setText(mExercise.getName()) ;
    }

    public int getListItemLayout() {
        return R.layout.list_item_exercise ;
    }

    public void fillListItemLayout(View convertView) {
        fillLayout(convertView) ;
    }

}
