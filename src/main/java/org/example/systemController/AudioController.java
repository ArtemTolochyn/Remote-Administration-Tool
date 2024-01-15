package org.example.systemController;

import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;

public class AudioController {

    public void play(String link) throws Exception {
        URL url = new URL(link);
        Clip clip = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.
                getAudioInputStream( url );
        clip.open(ais);
        clip.loop(0);
    }
}