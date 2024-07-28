package com.adapter;

public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        switch (audioType.toLowerCase()) {
            case "vlc":
                advancedMusicPlayer = new VlcPlayer();
                break;
            case "mp4":
                advancedMusicPlayer = new Mp4Player();
                break;
            case "avi":
                advancedMusicPlayer = new AviPlayer();
                break;
            case "mkv":
                advancedMusicPlayer = new MkvPlayer();
                break;
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toLowerCase()) {
            case "vlc":
                advancedMusicPlayer.playVlc(fileName);
                break;
            case "mp4":
                advancedMusicPlayer.playMp4(fileName);
                break;
            case "avi":
                ((AviPlayer) advancedMusicPlayer).playAvi(fileName);
                break;
            case "mkv":
                ((MkvPlayer) advancedMusicPlayer).playMkv(fileName);
                break;
        }
    }
}
