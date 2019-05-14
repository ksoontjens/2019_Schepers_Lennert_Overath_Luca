/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask{
    
    HelloTVXlet htv;
    
    public  MijnTimerTask( HelloTVXlet htv)
    {
        this.htv=htv;
    }
    public void run(){
htv.run();
    }

}
