package com.example.tello.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tello.project.fragment.ListQuestionFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnView1,btnView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnView1 = findViewById(R.id.btn_view_1);
        btnView1.setOnClickListener(this);

        btnView2 = findViewById(R.id.btn_view_2);
        btnView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        Intent intent;
        switch (view.getId()){
            case R.id.btn_view_1:
                bundle.putInt("View",1);
                break;
            case R.id.btn_view_2:
                bundle.putInt("View",2);
                break;
        }
        intent = new Intent(this,ListQuestionActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
