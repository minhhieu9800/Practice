package com.example.tello.project.adapter;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tello.project.ListQuestionActivity;
import com.example.tello.project.Model.Answer;
import com.example.tello.project.Model.Question;
import com.example.tello.project.action.IOnClickItem;
import com.example.tello.project.R;
import com.example.tello.project.holder.ItemAnswer;

import java.io.IOException;
import java.util.List;

public class ItemQuestionAdapter extends RecyclerView.Adapter<ItemAnswer> {
    private List<Answer> mListAnswer;
    private ListQuestionActivity mListQuestionActivity;
    private Question mQuestion;
    public boolean isConfirm;
    private IOnClickItem IOnClickItem;


    public ItemQuestionAdapter(Question question, ListQuestionActivity mListQuestionActivity, IOnClickItem IOnClickItem) {
        this.mQuestion = question;
        this.mListQuestionActivity = mListQuestionActivity;
        mListAnswer = question.getListAnswer();
        this.IOnClickItem = IOnClickItem;
    }

    @NonNull
    @Override
    public ItemAnswer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_answer,viewGroup,false);
        return new ItemAnswer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemAnswer itemAnswer , final int i) {
        final Answer answer = mListAnswer.get(i);
        itemAnswer.tvAbove.setText(answer.getWordKorean());
        itemAnswer.tvUpper.setText(answer.getWordEnglish());
        itemAnswer.btnSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(mListQuestionActivity,Uri.parse(answer.getLinkAudio()));
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        });
        itemAnswer.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IOnClickItem.OnClick(i);
            }
        });

        itemAnswer.linearItemAnswer.setVisibility((answer.isClick())?View.VISIBLE:View.INVISIBLE);
        itemAnswer.tvUpper.setTextColor((answer.isClick())?Color.parseColor("#ffffff"):Color.parseColor("#000000"));
        itemAnswer.tvAbove.setTextColor((answer.isClick())?Color.parseColor("#ffffff"):Color.parseColor("#000000"));
        itemAnswer.btnSpeaker.setImageResource((answer.isClick())?R.drawable.ic_speaker_choose:R.drawable.ic_speaker);
        if(isConfirm){
            if(i == mQuestion.getIntdexOfAnswer()){
                itemAnswer.linearItemAnswer.setBackgroundColor(Color.parseColor("#a98aa7ef"));
            }else {
                itemAnswer.linearItemAnswer.setBackgroundColor(Color.parseColor("#a9f99ea9"));
            }
        }else{
            itemAnswer.linearItemAnswer.setBackgroundColor(Color.parseColor("#a981e8ac"));
        }
    }

    @Override
    public int getItemCount() {
        return (mListAnswer.size()>0?mListAnswer.size():0);
    }
}
