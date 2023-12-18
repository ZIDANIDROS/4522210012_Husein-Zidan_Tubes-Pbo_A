package com.example.mymusicplayer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicPlayerController {

    @FXML
    private Label statusLabel;

    private MediaPlayer mediaPlayer;

    public void playMusic() {
        File audioFile = new File("music/ORQUESTRA MALDITA (BRAZILIAN PHONK).mp3");

        if (audioFile.exists()) {
            Media media = new Media(audioFile.toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setOnReady(() -> {
                statusLabel.setText("Playing: " + audioFile.getName());
                mediaPlayer.play();
            });
        } else {
            statusLabel.setText("File not found!");
        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            statusLabel.setText("Paused");
        }
    }

    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            statusLabel.setText("Stopped");
        }
    }
}
