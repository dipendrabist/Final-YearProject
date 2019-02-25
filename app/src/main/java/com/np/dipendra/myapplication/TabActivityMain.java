package com.np.dipendra.myapplication;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.np.dipendra.myapplication.fragments.FragmentFriday;
import com.np.dipendra.myapplication.fragments.FragmentMonday;
import com.np.dipendra.myapplication.fragments.FragmentSunday;
import com.np.dipendra.myapplication.fragments.FragmentThursday;
import com.np.dipendra.myapplication.fragments.FragmentTuesday;
import com.np.dipendra.myapplication.fragments.FragmentWednesday;

import java.util.ArrayList;
import java.util.List;


public class TabActivityMain extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentSunday(), "Sunday");
        adapter.addFrag(new FragmentMonday(), "Monday");
        adapter.addFrag(new FragmentTuesday(), "Tuesday");
        adapter.addFrag(new FragmentWednesday(), "Wednesday");
        adapter.addFrag(new FragmentThursday(), "Thursday");
        adapter.addFrag(new FragmentFriday(), "Friday");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
