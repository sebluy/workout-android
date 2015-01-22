package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.ExerciseListFragment;
import com.wonderguerrilla.android.workout.workout.BasketballWorkout;
import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.run.RunWorkout;

/**
 * Created by sebluy on 1/19/15.
 */
public class WorkoutFragment extends Fragment {

    public static Fragment get(Workout workout) {
        if (workout.getClass() == MultipleExerciseWorkout.class) {
            return new ExerciseListFragment() ;
        } else if (workout.getClass() == RunWorkout.class) {
            return new RunWorkoutFragment() ;
        } else if (workout.getClass() == BasketballWorkout.class) {
            return new BasketballWorkoutFragment() ;
        } else {
            return new WorkoutFragment() ;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Workout mWorkout ;

    public int getLayout() {
        return R.layout.fragment_workout ;
    }

    public void fillLayout(View view) {
        TextView title = (TextView)view.findViewById(R.id.name) ;
        title.setText(mWorkout.getName()) ;
    }

    public void commit() {
        mWorkout.commit() ;
        Toast.makeText(getActivity(), "Much success!", Toast.LENGTH_SHORT).show() ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = WorkoutHolder.getCurrent() ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), parent, false) ;
        fillLayout(view) ;
        return view ;
    }
}
