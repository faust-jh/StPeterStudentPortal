package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FacultyNavigation extends AppCompatActivity {

    BottomNavigationView facultyBottomNavigationView;

    FacultyDashboardFragment facultydashboardFragment = new FacultyDashboardFragment();
    FacultyEventFragment facultyeventFragment = new FacultyEventFragment();
    FacultyGradesFragment facultygradesFragment = new FacultyGradesFragment();
    FacultyMasterListFragment facultymasterlistFragment = new FacultyMasterListFragment();
    FacultyScheduleFragment facultyscheduleFragment = new FacultyScheduleFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_navigation);

        facultyBottomNavigationView  = findViewById(R.id.facultyBottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container2,facultydashboardFragment).commit();

        facultyBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.FDashboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container2,facultydashboardFragment).commit();
                        return true;
                    case R.id.FEvents:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container2,facultyeventFragment).commit();
                        return true;
                    case R.id.MasterList:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container2,facultygradesFragment).commit();
                        return true;
                    case R.id.FGrades:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container2,facultymasterlistFragment).commit();
                        return true;
                    case R.id.Schedule:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container2,facultyscheduleFragment).commit();
                        return true;
                }

                return false;
            }
        });
    }
}