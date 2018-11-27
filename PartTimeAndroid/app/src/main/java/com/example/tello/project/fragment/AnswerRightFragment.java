package com.example.tello.project.fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tello.project.R;
import com.example.tello.project.action.IOnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnswerRightFragment extends DialogFragment implements View.OnClickListener {
    private ImageView mBtnSpeaker;
    private TextView mTvWordKorea,mTvWordVietNam,mBtnNext;
    private String wordKorea,wordVietNam;
    private IOnClick iOnClick;

    public AnswerRightFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public AnswerRightFragment(String wordKorean, String wordEnglish,IOnClick iOnClick) {
        this.wordKorea = wordKorean;
        this.wordVietNam = wordEnglish;

        this.iOnClick = iOnClick;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogStyle);
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_right,container,false);
        mTvWordVietNam = view.findViewById(R.id.tv_word_viet_nam);
        mTvWordKorea = view.findViewById(R.id.tv_word_korea);
        mTvWordKorea.setText(wordKorea);
        mTvWordVietNam.setText(wordVietNam);

        mBtnSpeaker = view.findViewById(R.id.btn_speaker);
        mBtnSpeaker.setOnClickListener(this);
        mBtnNext = view.findViewById(R.id.btn_next);
        mBtnNext.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_speaker:
                Toast.makeText(getContext(),"Speak",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_next:
                iOnClick.onNext();
                getDialog().dismiss();
                break;
        }
    }
}
