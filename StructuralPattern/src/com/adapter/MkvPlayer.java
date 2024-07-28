package com.adapter;

public class MkvPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }

    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }

    public void playMkv(String fileName) {
        System.out.println("Playing mkv file. Name: " + fileName);
    }
}
