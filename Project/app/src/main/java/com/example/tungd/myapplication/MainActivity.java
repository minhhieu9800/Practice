package com.example.tungd.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tungd.myapplication.Model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Question> listQuestion = new ArrayList<>();
        
    }
}
