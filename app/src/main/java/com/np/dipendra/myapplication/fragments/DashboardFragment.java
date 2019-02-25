package com.np.dipendra.myapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.np.dipendra.myapplication.DashBoardItemsActivity;
import com.np.dipendra.myapplication.MainActivity;
import com.np.dipendra.myapplication.NewInterface;
import com.np.dipendra.myapplication.R;
import com.np.dipendra.myapplication.adapters.DashboardAdapter;
import com.np.dipendra.myapplication.modal.DashboardItems;

import java.util.ArrayList;
import java.util.List;


public class DashboardFragment extends Fragment implements NewInterface {
    List<DashboardItems> dashboardItems;
    View view;
    private RecyclerView recyclerViewDashboard;
    private DashboardAdapter dashboardAdapter;
    TextView textViewItem;
    ImageView imageViewItem;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dashboard_fragment, container, false);
        recyclerViewDashboard = view.findViewById(R.id.recycler_view_dashboard);
        dashboardItems = new ArrayList<DashboardItems>();
        dashboardItems.add(new DashboardItems("Announcements", R.drawable.ic_action_announcement));
        dashboardItems.add(new DashboardItems("Attendance", R.drawable.ic_stat_attendance));
        dashboardItems.add(new DashboardItems("Results", R.drawable.ic_stat_result));
        dashboardItems.add(new DashboardItems("Exams", R.drawable.ic_stat_exam));
        dashboardItems.add(new DashboardItems("Routine", R.drawable.ic_stat_routine));
        dashboardItems.add(new DashboardItems("Today's Lecture", R.drawable.ic_stat_lecture));
        dashboardAdapter = new DashboardAdapter(this, dashboardItems);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewDashboard.setLayoutManager(staggeredGridLayoutManager);
        recyclerViewDashboard.setAdapter(dashboardAdapter);
        getActivity().setTitle("Dashboard");
        textViewItem = view.findViewById(R.id.textViewItem);
        imageViewItem = view.findViewById(R.id.image);
        return view;
    }

    @Override
    public void onItemClick(DashboardItems dashboardItems) {
        Intent intent=new Intent(getActivity(), DashBoardItemsActivity.class);
        intent.putExtra("dashboardItems",dashboardItems.getItem());
        startActivity(intent);
    }
}
