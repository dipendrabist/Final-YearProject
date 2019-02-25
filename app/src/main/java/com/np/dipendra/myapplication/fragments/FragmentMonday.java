package com.np.dipendra.myapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.np.dipendra.myapplication.R;
import com.np.dipendra.myapplication.adapters.RoutineAdapter;
import com.np.dipendra.myapplication.modal.RoutineItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentMonday extends Fragment {
    public FragmentMonday() {

    }

    List<RoutineItem> routineItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private View view;
    private static final String URL = "http://10.0.2.2/app/monday_routine.php";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        routineItems=new ArrayList<>();
        loadRoutine();

    }

    private void loadRoutine() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i <jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        routineItems.add(new RoutineItem(jsonObject.getString("time"),
                                jsonObject.getString("lecture"),
                                jsonObject.getString("lecturer")

                        ));
                    }
                    RoutineAdapter routineAdapter = new RoutineAdapter(getActivity(), routineItems);
                    recyclerView.setAdapter(routineAdapter);
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_routine, container, false);

        super.onCreate(savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_routine);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        getActivity().setTitle("Routine");

        return view;
    }

}
