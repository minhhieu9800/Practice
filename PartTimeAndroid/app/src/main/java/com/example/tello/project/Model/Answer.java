package com.example.tello.project.Model;

public class Answer {
    private String linkImg;
    private String wordKorean;
    private String wordEnglish;
    private String linkAudio;
    private boolean isClick;

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getWordKorean() {
        return wordKorean;
    }

    public void setWordKorean(String wordKorean) {
        this.wordKorean = wordKorean;
    }

    public String getWordEnglish() {
        return wordEnglish;
    }

    public void setWordEnglish(String wordEnglish) {
        this.wordEnglish = wordEnglish;
    }

    public String getLinkAudio() {
        return linkAudio;
    }

    public void setLinkAudio(String linkAudio) {
        this.linkAudio = linkAudio;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }
}
