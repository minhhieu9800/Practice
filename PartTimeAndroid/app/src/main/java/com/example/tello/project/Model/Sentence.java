package com.example.tello.project.Model;

public class Sentence {
    private String linkAudio;
    private String sentence;

    public Sentence(String linkAudio, String sentence) {
        this.linkAudio = linkAudio;
        this.sentence = sentence;
    }

    public String getLinkAudio() {
        return linkAudio;
    }

    public void setLinkAudio(String linkAudio) {
        this.linkAudio = linkAudio;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
