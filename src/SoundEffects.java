package src;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



// For playing sound in game
public class SoundEffects {

    void playSound(String soundFile) {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

}