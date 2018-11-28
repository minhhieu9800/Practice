package com.example.tello.project.fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tello.project.ListQuestionActivity;
import com.example.tello.project.Model.Sentence;
import com.example.tello.project.R;
import com.example.tello.project.action.IOnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortSentenceFragment extends Fragment implements View.OnClickListener,IOnClick {
    private Sentence mSentence;
    private ListQuestionActivity mListQuestionActivity;
    private Button mBtnCheck;
    private ImageView mBtnSpeaker;
    private LinearLayout mLinearSentence,mLinearSortSentence;
    private LinearLayout.LayoutParams params;
    @SuppressLint("ValidFragment")
    public SortSentenceFragment(Sentence mSentence,ListQuestionActivity listQuestionActivity) {
        this.mSentence = mSentence;
        this.mListQuestionActivity = listQuestionActivity;
    }
    public SortSentenceFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sort_sentence,container,false);
        initialView(view);
        createWordInSentence();

        return view;
    }

    private void initialView(View view){
        mBtnCheck = view.findViewById(R.id.btn_check);
        mBtnCheck.setOnClickListener(this);

        mBtnSpeaker = view.findViewById(R.id.btn_speaker);
        mBtnSpeaker.setOnClickListener(this);

        mLinearSentence = view.findViewById(R.id.linear_sentence);
        mLinearSortSentence = view.findViewById(R.id.linear_sort_sentence);

        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,2,2,0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_check:
                int lengthSentenceCheck = mLinearSortSentence.getChildCount();
                if(lengthSentenceCheck != mLinearSentence.getChildCount()){
                    Toast.makeText(mListQuestionActivity,"Please complete sentence !!",Toast.LENGTH_LONG).show();
                }else{
                    String temp = "";
                    for(int i=0;i<lengthSentenceCheck;i++){
                        temp += ((Button)mLinearSortSentence.getChildAt(i)).getText()+" ";
                    }
                    if(temp.trim().equals(mSentence.getSentenceKorea().trim())){
                        AnswerRightFragment answerRightFragment = new AnswerRightFragment(mSentence.getSentenceKorea(),mSentence.getSentenceVietNam(),this);
                        answerRightFragment.setCancelable(false);
                        answerRightFragment.show(mListQuestionActivity.getSupportFragmentManager(),"rightFragment");
                    }else{
                        AnswerWrongFragment answerWrongFragment = new AnswerWrongFragment(mSentence.getSentenceKorea(),mSentence.getSentenceVietNam(),this);
                        answerWrongFragment.setCancelable(false);
                        answerWrongFragment.show(mListQuestionActivity.getSupportFragmentManager(),"wrongFragment");
                    }
                }
                break;
            case R.id.btn_speaker:
                break;
        }
    }

    private void createWordInSentence(){
        String sentence = mSentence.getSentenceKorea().trim();
        String[] words = sentence.split(" ");

        for(String temp:words){
            final Button button = new Button(mListQuestionActivity);
            button.setTextColor(Color.parseColor("#000000"));
            button.setText(temp);
            button.setLayoutParams(params);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickWordToLinearSentence(button.getText().toString());
                    button.setTextColor(getResources().getColor(android.R.color.transparent));
                    button.setEnabled(false);
                }
            });
            mLinearSentence.addView(button);
        }
    }

    private void clickWordToLinearSentence(final String word){
        final Button button = new Button(mListQuestionActivity);
        button.setTextColor(Color.parseColor("#000000"));
        button.setText(word);
        button.setLayoutParams(params);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<mLinearSentence.getChildCount();i++){
                    Button temp = (Button) mLinearSentence.getChildAt(i);
                    if(word.equals(temp.getText())){
                        temp.setTextColor(Color.parseColor("#000000"));
                        temp.setEnabled(true);
                        mLinearSortSentence.removeView(view);
                        break;
                    }
                }
            }
        });
        mLinearSortSentence.addView(button);
    }

    @Override
    public void onBack() {
        mLinearSortSentence.removeAllViews();
        for(int i=0;i<mLinearSentence.getChildCount();i++){
            Button temp = ((Button)mLinearSentence.getChildAt(i));
            temp.setTextColor(Color.parseColor("#000000"));
            temp.setEnabled(true);
        }
    }

    @Override
    public void onNext() {
        Toast.makeText(mListQuestionActivity,"Next Question",Toast.LENGTH_LONG).show();
    }
}
