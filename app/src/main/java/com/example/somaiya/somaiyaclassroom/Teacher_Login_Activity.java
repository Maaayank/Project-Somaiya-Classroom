package com.example.somaiya.somaiyaclassroom;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Teacher_Login_Activity extends AppCompatActivity implements BottomNavigationViewEx.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__login);

        BottomNavigationViewEx navigation= findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.enableItemShiftingMode(false);
        navigation.enableShiftingMode(false);
        navigation.setTextSize(8);
        navigation.setIconSize(35,26);
        LoadFragment(new Syllabus());
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,AlreadyRegisteredLoginProf.class));
        }

    }

    private  boolean LoadFragment(Fragment fragment)
    {
        if(fragment !=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
           return  false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
      Fragment fragment=null;
      switch (menuItem.getItemId())
      {
          case R.id.syllabus:
              fragment=new Syllabus();
              break;

          case R.id.solution :
              fragment=new Easysolution();
              break;

          case R.id.papers:
              fragment=new PreviousPapers();
              break;

          case R.id.event:
              fragment=new Addevent();
              break;

          case R.id.course:
              fragment=new courseMaterial();
              break;


      }
      return LoadFragment(fragment);
    }
}




