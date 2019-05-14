/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class Spaceship extends Sprite {
    
        public Spaceship(int x, int y, String filename) {
        super(x,y,filename);
      
        sy=sy - image.getHeight(this);
        setXY(sx,sy);
        }

    public void leef() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
