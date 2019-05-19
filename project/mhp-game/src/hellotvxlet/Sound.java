/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;



/**
 *
 * @author lenne
 */
public class Sound {
    String hitSound;
    SoundEffect sfx = new SoundEffect();
    public static void main(String[] args){
    
    }
    
    public Sound(){
    
        hitSound = ".//sounds//hit.wav";
        
    }
    
    public void PlaySound(){
        sfx.setFile(hitSound);
        sfx.Play();
    }
    

}



