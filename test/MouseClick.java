package test;

import java.awt.Toolkit;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Utility class for handling mouse click sound effects
 * @author Admin
 */
public class MouseClick {
    
    public static void playClickSound() {
        try {
            URL soundURL = MouseClick.class.getResource("../sound/click.wav");

            if (soundURL != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                // Fallback: Use system beep if sound file not found
                Toolkit.getDefaultToolkit().beep();
            }

        } catch (Exception e) {
            // If there's any error, fall back to system beep
            System.err.println("Could not play click sound: " + e.getMessage());
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public static void playNotificationSound() {
        try {
            URL soundURL = MouseClick.class.getResource("../sound/confirmation.wav");

            if (soundURL != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                // Fallback: Use system beep if sound file not found
                Toolkit.getDefaultToolkit().beep();
            }

        } catch (Exception e) {
            // If there's any error, fall back to system beep
            System.err.println("Could not play notification sound: " + e.getMessage());
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    /**
     * Generic method to play any sound file
     * @param soundFileName The name of the sound file (without path)
     * @param soundDirectory The directory path where the sound file is located (default: "../sound/")
     */
    public static void playSound(String soundFileName, String soundDirectory) {
        try {
            String soundPath = soundDirectory + soundFileName;
            URL soundURL = MouseClick.class.getResource(soundPath);

            if (soundURL != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                // Fallback: Use system beep if sound file not found
                Toolkit.getDefaultToolkit().beep();
            }

        } catch (Exception e) {
            // If there's any error, fall back to system beep
            System.err.println("Could not play sound '" + soundFileName + "': " + e.getMessage());
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    /**
     * Overloaded method to play sound with default directory
     * @param soundFileName The name of the sound file
     */
    public static void playSound(String soundFileName) {
        playSound(soundFileName, "../sound/");
    }
}