/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

/**
 *
 * @author Luca
 */
public class Heart extends Sprite{
    Image image2;
    boolean rood=true;
    public Heart(int x, int y, String filename, String filename2) {
        super(x,y,filename);
         image2 = this.getToolkit().getImage(filename2);
        sx=x;
        sy=y;
      
        
        
  
        //straal = this.getToolkit().getImage("spaceship.PNG");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(image, 0);
        
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
        sy=sy - image.getHeight(this);
        setXY(sx,sy);
        }

    public void leef() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
       public void paint(Graphics g)
    {
     if (rood)
        g.drawImage(image, 0, 0, this);
     else
        g.drawImage(image2, 0, 0, this);
    }
}
