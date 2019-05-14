/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class Laser extends Sprite {

    public Laser(int x, int y, String fileName){
        
        super(x,y, fileName);
    }
    
    public void leef() {
      sy -= 10;
      this.setBounds(sx,sy,image.getWidth(this),image.getHeight(this));
      this.repaint();
    }
}
