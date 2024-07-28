package com.adapter;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (!fileName.endsWith("." + audioType.toLowerCase())) {
            System.out.println("Invalid file extension for the given media type.");
            return;
        }

        switch (audioType.toLowerCase()) {
            case "mp3":
                System.out.println("Playing mp3 file. Name: " + fileName);
                break;
            case "vlc":
            case "mp4":
            case "avi":
            case "mkv":
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
                break;
            default:
                System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }

    public void displaySupportedTypes() {
        System.out.println("Supported media types: mp3, mp4, vlc, avi, mkv");
    }
}
