package com.example.tello.project;

import android.os.Bundle;

import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.tello.project.Model.Answer;
import com.example.tello.project.Model.Question;
import com.example.tello.project.fragment.ListQuestionFragment;

import java.util.ArrayList;
import java.util.List;


public class ListQuestionActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    Question question;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_question);
        int view = getIntent().getExtras().getInt("View");
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(view == 1) {
            createQuestion();
            fragmentTransaction.add(R.id.frame_fragment, new ListQuestionFragment(question, this));
        }
        fragmentTransaction.commit();
    }

    private void createQuestion(){
        if(question == null){
            question = new Question();
        }
        List<Answer> listAnswer = new ArrayList<>();
        for(int i=0;i<4;i++){
            Answer answer = new Answer();
            answer.setWordEnglish("asd");
            answer.setWordKorean("bcd");
            answer.setLinkAudio("https://mp3.zing.vn/bai-hat/24H-LyLy-Magazine/ZW9FU9OW.html?play_song=1");
            answer.setLinkImg("https://arstechnica.com/science/2016/02/tiny-blurry-pictures-find-the-limits-of-computer-image-recognition/");
            listAnswer.add(answer);
        }
        question.setListAnswer(listAnswer);
        question.setIntdexOfAnswer(0);
        question.setTitle("asdasd");
    }
}
