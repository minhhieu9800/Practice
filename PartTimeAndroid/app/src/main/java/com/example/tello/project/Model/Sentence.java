package com.example.tello.project.Model;

public class Sentence {
    private String linkAudio;
    private String sentenceKorea;
    private String sentenceVietNam;

    public Sentence(String linkAudio, String sentenceKorea, String sentenceVietNam) {
        this.linkAudio = linkAudio;
        this.sentenceKorea = sentenceKorea;
        this.sentenceVietNam = sentenceVietNam;
    }

    public String getLinkAudio() {
        return linkAudio;
    }

    public void setLinkAudio(String linkAudio) {
        this.linkAudio = linkAudio;
    }

    public String getSentenceKorea() {
        return sentenceKorea;
    }

    public void setSentenceKorea(String sentenceKorea) {
        this.sentenceKorea = sentenceKorea;
    }

    public String getSentenceVietNam() {
        return sentenceVietNam;
    }

    public void setSentenceVietNam(String sentenceVietNam) {
        this.sentenceVietNam = sentenceVietNam;
    }
}
