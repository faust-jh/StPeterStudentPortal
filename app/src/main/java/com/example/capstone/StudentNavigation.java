package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class StudentNavigation extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    StudentDashboardFragment studentdashboardFragment = new StudentDashboardFragment();
    StudentGradeFragment studentgradeFragment = new StudentGradeFragment();
    StudentAcademicInfoFragment studentacademicinfoFragment = new StudentAcademicInfoFragment();
    StudentInformationFragment studentinformationFragment = new StudentInformationFragment();
    StudentRequestFragment studentrequestFragment = new StudentRequestFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_navigation);

        bottomNavigationView  = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,studentdashboardFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Dashboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,studentdashboardFragment).commit();
                        return true;
                    case R.id.Grades:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,studentgradeFragment).commit();
                        return true;
                    case R.id.AcadInfo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,studentacademicinfoFragment).commit();
                        return true;
                    case R.id.StudInfo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,studentinformationFragment).commit();
                        return true;
                    case R.id.Request:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,studentrequestFragment).commit();
                        return true;
                }

                return false;
            }
        });
    }
}