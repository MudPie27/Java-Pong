package src;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// For playing sound in game
public class SoundEffects {

    private Clip ballHit;
    private Clip backgroundMusic;

    public SoundEffects() {
        loadSounds();
    }

    private void loadSounds() {

        try {
            // AudioInputStream ballHitSound = AudioSystem.getAudioInputStream(new File("E:\\Intern northpnd\\Pong\\Pong\\src\\ballHit.wav"));
            // ballHit = AudioSystem.getClip();
            // ballHit.open(ballHitSound);

            File bgmFile = new File("BGM.wav");
            AudioInputStream bgmSound = AudioSystem.getAudioInputStream(bgmFile);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(bgmSound);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playEffect() {
        if (ballHit.isRunning()) {
            ballHit.stop();
        }
        ballHit.setFramePosition(0);
        ballHit.start();
    }

    public void playBGM() {
        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }
}