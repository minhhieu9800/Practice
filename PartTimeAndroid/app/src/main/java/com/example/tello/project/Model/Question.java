package com.example.tello.project.Model;

import java.util.List;

public class Question {
    private String title;
    private List<Answer> listAnswer;
    private int intdexOfAnswer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public int getIntdexOfAnswer() {
        return intdexOfAnswer;
    }

    public void setIntdexOfAnswer(int intdexOfAnswer) {
        this.intdexOfAnswer = intdexOfAnswer;
    }
}
