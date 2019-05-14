
/**
 *
 * @author student
 *
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public abstract class Sprite extends HComponent implements Levend {
    Image image;
    Image straal;
    public int sx = 0;
    public int sy = 0;

    public Sprite(int x, int y, String filename) {
        image = this.getToolkit().getImage(filename);
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
        this.setBounds(sx,sy,image.getWidth(this),image.getHeight(this));
    }
    public void setXY( int x, int y)
    {
        sx=x;
        sy=y;
        this.setBounds(sx,sy,image.getWidth(this),image.getHeight(this));
    }
    public void paint(Graphics g)
    {
     
        g.drawImage(image, 0, 0, this);
     
    }


}