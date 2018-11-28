package com.example.tello.project.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tello.project.ListQuestionActivity;
import com.example.tello.project.Model.Answer;
import com.example.tello.project.Model.Question;
import com.example.tello.project.action.IOnClick;
import com.example.tello.project.action.IOnClickItem;
import com.example.tello.project.R;
import com.example.tello.project.adapter.ItemQuestionAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListQuestionFragment extends Fragment implements IOnClickItem,IOnClick {
    ItemQuestionAdapter adapter;
    Question question;
    private RecyclerView mRecyclerView;
    private ListQuestionActivity mListQuestionActivity;
    int postion = -1 ;
    private Button mBtnConfirm;
    private ListQuestionFragment mListQuestionFragment;

    @SuppressLint("ValidFragment")
    public ListQuestionFragment(Question question,ListQuestionActivity listQuestionActivity) {
        this.question = question;
        this.mListQuestionActivity = listQuestionActivity;
        mListQuestionFragment = this;
    }

    public ListQuestionFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_recycler_view_question_,container,false);
        mRecyclerView = view.findViewById(R.id.recycler_list_answer);
        adapter = new ItemQuestionAdapter(question,mListQuestionActivity,this);

        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

        mBtnConfirm = view.findViewById(R.id.btn_confirm);
        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answer result = question.getListAnswer().get(question.getIntdexOfAnswer());
                if(postion == -1){
                    Toast.makeText(mListQuestionActivity,"Please choose answer first",Toast.LENGTH_LONG).show();
                }else {
                    if (question.getIntdexOfAnswer() != postion) {
                        AnswerWrongFragment fragmentWrongAnswer = new AnswerWrongFragment(result.getWordKorean(), result.getWordEnglish(), mListQuestionFragment);
                        fragmentWrongAnswer.setCancelable(false);
                        fragmentWrongAnswer.show(mListQuestionActivity.getSupportFragmentManager(), "wrongfragment");

                    } else {
                        AnswerRightFragment fragmentRightAnswer = new AnswerRightFragment(result.getWordKorean(), result.getWordEnglish(), mListQuestionFragment);
                        fragmentRightAnswer.setCancelable(false);
                        fragmentRightAnswer.show(mListQuestionActivity.getSupportFragmentManager(), "rightfragment");
                    }
                    adapter.isConfirm = true;
                    adapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }

    @Override
    public void OnClick(int position) {
        if(position != this.postion){
            adapter.isClick = true;
            for(Answer answer:question.getListAnswer()){
                answer.setClick(false);
            }
            question.getListAnswer().get(position).setClick(true);
            this.postion = position;
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onBack() {
        loadNewAdapter();
    }

    @Override
    public void onNext() {
       loadNewAdapter();
        Toast.makeText(getContext(),"Next Question Load",Toast.LENGTH_LONG).show();
    }
    private void loadNewAdapter(){
        for(Answer answer:question.getListAnswer()){
            answer.setClick(false);
        }
        adapter.isClick = false;
        adapter.isConfirm = false;
        this.postion = -1;
        adapter.notifyDataSetChanged();
    }
}
