/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.HScene;

/**
 *
 * @author student
 */
public class Invader extends Sprite{
HScene mScene;
boolean goRight = true;
    
    public Invader(int x, int y, String filename, HScene scene){
        super(x,y,filename);
        mScene = scene;
    }
    public void leef() {
        if(sx + image.getWidth(this) < mScene.getWidth() && goRight)
        {
            sx++;
            if(sx + image.getWidth(this) == mScene.getWidth())
            {
                goRight = false;
            }
        }
        
        if(sx > 0 && !goRight)
        {
            sx--;
            if(sx == 0)
            {
                goRight = true;
            }
        }
        
        this.setBounds(sx,sy,image.getWidth(this),image.getHeight(this));
        this.repaint();
    }

}
