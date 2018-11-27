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
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.tello.project.R;
import com.example.tello.project.action.IOnClick;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnswerWrongFragment extends DialogFragment{
    private TextView mTvWordKorea,mTvWordVietNam;
    private String wordKorea,wordVietNam;
    private TextView mBtnNext;
    private IOnClick iOnClick;

    public AnswerWrongFragment() {
    }

    @SuppressLint("ValidFragment")
    public AnswerWrongFragment(String wordKorea, String wordVietNam,IOnClick iOnClick) {
        this.wordKorea = wordKorea;
        this.wordVietNam = wordVietNam;
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
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_wrong,container,false);

        mTvWordKorea = view.findViewById(R.id.tv_word_korea);
        mTvWordVietNam = view.findViewById(R.id.tv_word_viet_nam);

        mTvWordKorea.setText(wordKorea);
        mTvWordVietNam.setText(wordVietNam);

        mBtnNext = view.findViewById(R.id.btn_try_again);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnClick.onBack();
                getDialog().dismiss();
            }
        });

        return view;
    }

}
