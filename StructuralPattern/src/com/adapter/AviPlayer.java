package com.adapter;
public class AviPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }

    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }

    public void playAvi(String fileName) {
        System.out.println("Playing avi file. Name: " + fileName);
    }
}
