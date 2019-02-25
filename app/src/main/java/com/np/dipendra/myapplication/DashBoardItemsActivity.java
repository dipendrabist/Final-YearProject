package com.np.dipendra.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.np.dipendra.myapplication.fragments.Announcement;

public class DashBoardItemsActivity extends AppCompatActivity {
    TextView tvName;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboarditems);
        String dashboarditems = getIntent().getStringExtra("dashboardItems");
        switch (dashboarditems){
            case "Announcements":
                fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_container2,new Announcement());
                fragmentTransaction.commit();
                break;
//            case "Attendance":
//                fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.rl_container2,new Attendance());
//                fragmentTransaction.commit();
//                break;
//            case "Results":
//                fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.rl_container2,new Announcement());
//                fragmentTransaction.commit();
//                break;
//            case "Exams":
//                fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.rl_container2,new Announcement());
//                fragmentTransaction.commit();
//                break;
            case "Routine":
                Intent intent=new Intent(DashBoardItemsActivity.this, TabActivityMain.class);
                startActivity(intent);
                break;
//            case "Today's Lecture":
//                fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.rl_container2,new Announcement());
//                fragmentTransaction.commit();
//                break;

        }

//        tvName = findViewById(R.id.tv_name);
//        tvName.setText(dashboarditems);

    }
}
