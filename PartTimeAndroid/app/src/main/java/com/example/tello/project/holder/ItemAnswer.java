package com.example.tello.project.holder;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tello.project.R;

public class ItemAnswer extends RecyclerView.ViewHolder {
    public ImageView imgAnswer;
    public TextView tvAbove,tvUpper;
    public ImageView btnSpeaker;
    public LinearLayout linearItemAnswer;
    public ConstraintLayout layoutItemAnswer;
    public CardView cardView;

    public ItemAnswer(@NonNull View itemView) {
        super(itemView);
        imgAnswer = itemView.findViewById(R.id.img_item_question);
        btnSpeaker = itemView.findViewById(R.id.btn_item_question_speaker);
        tvAbove = itemView.findViewById(R.id.tv_item_question_above);
        tvUpper = itemView.findViewById(R.id.tv_item_question_upper);
        linearItemAnswer = itemView.findViewById(R.id.linear_item_answer);
        layoutItemAnswer = itemView.findViewById(R.id.layout_item_answer);
        cardView = itemView.findViewById(R.id.item_answer);
    }
}
