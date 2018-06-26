package com.example.somaiya.somaiyaclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class course_act extends AppCompatActivity {
    Magnify mag = new Magnify();
    private float zoomFactor = 1.25f;
    private boolean xyz = Magnify.getInstance().getData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_act);
        View v=findViewById(android.R.id.content);
        Button i = findViewById(R.id.button6);
        v.setPivotX(i.getX()/2);
        v.setPivotY(v.getY()/2);
        if(Magnify.getInstance().getData())
            mag.enlarge(true,findViewById(android.R.id.content),zoomFactor);
    }
}
