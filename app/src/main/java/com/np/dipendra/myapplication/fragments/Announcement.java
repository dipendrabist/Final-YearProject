package com.np.dipendra.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.np.dipendra.myapplication.R;
import com.np.dipendra.myapplication.adapters.AnnoucementAdapter;
import com.np.dipendra.myapplication.modal.Announcements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Announcement extends Fragment {
    List<Announcements> announcementsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private View view;
    private static final String URL = "http://10.0.2.2/app/fetch_announcement.php";
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = layoutInflater.inflate(R.layout.fragment_announcement, container, false);

        super.onCreate(savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getActivity().setTitle("Announcements");

        return view;
  }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        announcementsList = new ArrayList<>();
        loadAnnouncements();
    }

    private void loadAnnouncements() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        announcementsList.add(new Announcements(jsonObject.getString("announcement"),
                                jsonObject.getString("date"),
                                jsonObject.getString("department"),
                                jsonObject.getString("image")
                        ));
                    }
                    AnnoucementAdapter annoucementAdapter = new AnnoucementAdapter(getActivity(), announcementsList);
                    recyclerView.setAdapter(annoucementAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}



