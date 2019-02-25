package com.np.dipendra.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.np.dipendra.myapplication.R;
import com.np.dipendra.myapplication.modal.Announcements;

import java.util.ArrayList;
import java.util.List;


public class AnnoucementAdapter extends RecyclerView.Adapter<AnnoucementAdapter.MyViewHolder>
{
private Context context;
private List<Announcements> announcementList;

    public AnnoucementAdapter(Context context, List<Announcements> announcementList) {
        this.context = context;
        this.announcementList = announcementList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        view= LayoutInflater.from(context).inflate(R.layout.announcements,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
Announcements announcements=announcementList.get(i);
        Glide.with(context).load(announcements.getImage()).into(myViewHolder.imageView);
myViewHolder.textViewAnnouncement.setText(announcements.getAnnouncement());
        myViewHolder.date.setText(announcements.getDate());

        myViewHolder.department.setText(announcements.getDepartment());

    }

    @Override
    public int getItemCount() {
        return announcementList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
TextView textViewAnnouncement, date, department;
ImageView imageView;
        public MyViewHolder(View view) {
            super(view);
            textViewAnnouncement=view.findViewById(R.id.textViewannouncement);
            date=view.findViewById(R.id.textViewDate);
            department=view.findViewById(R.id.textViewDepartment);
            imageView=view.findViewById(R.id.imageViewAnnouncement);
        }
    }
}
