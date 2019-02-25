package com.np.dipendra.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.np.dipendra.myapplication.MainActivity;
import com.np.dipendra.myapplication.NewInterface;
import com.np.dipendra.myapplication.R;
import com.np.dipendra.myapplication.fragments.Announcement;
import com.np.dipendra.myapplication.fragments.DashboardFragment;
import com.np.dipendra.myapplication.modal.DashboardItems;

import java.util.List;


public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder> {
    Context context;
    List<DashboardItems> dashboardItems;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    private NewInterface myListener;

    public DashboardAdapter(NewInterface listener, List<DashboardItems> dashboardItems) {
        this.myListener = listener;
        this.dashboardItems = dashboardItems;
    }


    @NonNull
    @Override
    public DashboardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
        myViewHolder.textViewItem.setText(dashboardItems.get(position).getItem());
        myViewHolder.image.setImageResource(dashboardItems.get(position).getImage());
        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myListener.onItemClick(dashboardItems.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return dashboardItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.textViewItem);
            image = itemView.findViewById(R.id.image);
        }
    }


}
