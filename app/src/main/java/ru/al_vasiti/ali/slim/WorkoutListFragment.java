package ru.al_vasiti.ali.slim;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by РС on 23.09.2017.
 */

public class WorkoutListFragment extends ListFragment{
    static interface WorkoutListListener{
        void itemClicked(long id);
    }

    private WorkoutListListener listener;
    public WorkoutListFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle  savedInstanceState){
        String[]names=new String[Workout.workouts.length];
        for (int i=0; i<names.length;i++){
            names[i]=Workout.workouts[i].getName();
        }
        ArrayAdapter<String>adapter=new
                ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1,
                names);
                setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.listener=(WorkoutListListener)activity;
    }
    @Override
    public void onListItemClick(ListView I,View v,int position,long id){
        if(listener!=null){
            listener.itemClicked(id);
        }
    }
}
