package com.np.dipendra.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.np.dipendra.myapplication.R;
import com.np.dipendra.myapplication.modal.RoutineItem;

import java.util.List;

public class RoutineAdapter extends RecyclerView.Adapter<RoutineAdapter.MyRoutineViewHolder> {

    Context context;
    List<RoutineItem> routineItems;

    public RoutineAdapter(Context context, List<RoutineItem> routineItems) {
        this.context = context;
        this.routineItems = routineItems;
    }

    @NonNull
    @Override
    public MyRoutineViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.routine_items, viewGroup, false);
        MyRoutineViewHolder myRoutineViewHolder = new MyRoutineViewHolder(view);
        return myRoutineViewHolder;
    }

    @Override
    public void onBindViewHolder(MyRoutineViewHolder myRoutineViewHolder, int i) {
        RoutineItem routineItem=routineItems.get(i);
        myRoutineViewHolder.textViewTime.setText(routineItem.getTime());
        myRoutineViewHolder.textViewLecture.setText(routineItem.getLecture());
        myRoutineViewHolder.textViewLecturer.setText(routineItem.getLecturer());
    }

    @Override
    public int getItemCount() {
        return routineItems.size();
    }

    class MyRoutineViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTime;
        TextView textViewLecture;
        TextView textViewLecturer;

        public MyRoutineViewHolder(View itemView) {
            super(itemView);
            textViewTime = itemView.findViewById(R.id.text_time);
            textViewLecture = itemView.findViewById(R.id.text_lecture);
            textViewLecturer = itemView.findViewById(R.id.text_lecturer);

        }
    }
}
