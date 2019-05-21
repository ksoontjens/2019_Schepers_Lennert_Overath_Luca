/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
/**
 *
 * @author lenne
 */
public class SoundEffect{
    Clip clip;
    
    public void setFile(String soundFileName){
        try{
            File file = new File(soundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        
        }
        catch(Exception ex){
            
        }
    
    }
    
    public void Play(){
        clip.setFramePosition(0);
        clip.start();
    }
}
