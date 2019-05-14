/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import org.havi.ui.HComponent;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;

/**
 *
 * @author Luca
 */
public class Block extends HComponent implements Levend{
    public Block(int x,int y, int width, int height)
    {
      HStaticText hst=new HStaticText("",x,y,width,height);
      hst.setBackgroundMode(HVisible.BACKGROUND_FILL);
      hst.setBackground(Color.GRAY);
      this.setBounds(x,y,width,height);
    }

    public void leef() {
        
    }
}
