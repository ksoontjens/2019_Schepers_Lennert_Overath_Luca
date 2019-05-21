package hellotvxlet;




import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import java.util.Timer;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import org.havi.ui.HVisible;

public class HelloTVXlet implements Xlet, UserEventListener {
int size = 150;
MijnTimerTask mtt = new MijnTimerTask(this);
HScene scene=HSceneFactory.getInstance().getDefaultHScene();
HStaticText nieuw;
HStaticText counter;
boolean leeg=true, isPressed = false, firstCube = true;
int getal, score = 0;
//timer voor de fps te controleren
Timer t=new Timer();
int lives = 3;
Heart[] hearts = new Heart[3];
int MAXLIVES = 3, HEARTSHEIGHT = 100, HEARTWIDTH = 60, temp = 0, delay= 2000;

    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context){
      
      
      Instructions();
      scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
      scene.setBackground(Color.BLACK);
      
      
      //maak een verzameling (repository), voeg hier de 4 pijltjes aan toe
      UserEventRepository rep = new UserEventRepository("naam");
      rep.addKey(HRcEvent.VK_COLORED_KEY_0);
      rep.addKey(HRcEvent.VK_COLORED_KEY_1);
      rep.addKey(HRcEvent.VK_COLORED_KEY_2);
      rep.addKey(HRcEvent.VK_COLORED_KEY_3);
      rep.addKey(HRcEvent.VK_1);
      rep.addKey(HRcEvent.VK_2);
      rep.addKey(HRcEvent.VK_3);
      rep.addKey(HRcEvent.VK_ENTER);
      
      //gebruik het signleton van eventmanager om aan te geven
      // naar waar
      EventManager.getInstance().addUserEventListener(this,rep);
      
      scene.validate();
      scene.setVisible(true);
      
      updateLevens();
      
      t.schedule(mtt, 2000, delay);
      
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }
    
    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void Instructions(){
      HStaticText hstR=new HStaticText("Q",scene.getWidth()/6 - size / 2,scene.getHeight() - size * 2,size,size);
      HStaticText hstG=new HStaticText("S",scene.getWidth() * 3/6 - size / 2,scene.getHeight() - size * 2,size,size);
      HStaticText hstB=new HStaticText("D",scene.getWidth() * 5/6 - size / 2,scene.getHeight() - size * 2,size,size);
      
      hstR.setBackgroundMode(HVisible.BACKGROUND_FILL);
      hstR.setBackground(Color.RED);
      hstG.setBackgroundMode(HVisible.BACKGROUND_FILL);
      hstG.setBackground(Color.GREEN);
      hstB.setBackgroundMode(HVisible.BACKGROUND_FILL);
      hstB.setBackground(Color.BLUE);
      
      scene.add(hstR);
      scene.add(hstG);
      scene.add(hstB);
        
    }
    
    public void updateLevens()
    {
        System.out.println(lives);
        
        if(lives > 0)
        {
            for(int i = 0; i < MAXLIVES; i++)
            {
            //   if (hearts[i]!=null) scene.remove(hearts[i]);
                if (hearts[i]==null)   
                {
                    hearts[i] = new Heart(scene.getWidth() - HEARTWIDTH * (i + 1), HEARTSHEIGHT , "FullHealth.png","NoHealth.png");
                    scene.add(hearts[i]);
                    scene.popToFront(hearts[i]);
                }
                
                if(lives >= i + 1)
                {
                    hearts[i].rood=true;
                    
                } 
                else {
                     hearts[i].rood=false;
                    
                }
                
                hearts[i].repaint();

               
            }
        }      else
        {
            scene.removeAll();
            HStaticText lose = new HStaticText("YOU LOSE \nPress enter to restart",0,0, scene.getWidth(), scene.getHeight());
            lose.setFont(Font.getFont("BOLD"));
            scene.add(lose);
        }
    }
    public void run()
    {
        if (lives==0) return;
            if (leeg)
            {
                System.out.println("box leeg");
                nieuw=new HStaticText("",scene.getWidth() * 1/2 - size / 2,100,size,size);
                nieuw.setBackground(Color.GRAY);
                nieuw.setBackgroundMode(HVisible.BACKGROUND_FILL);
                scene.add(nieuw);
                Random r=new Random();
                
                if(firstCube){
                    getal=r.nextInt(3);
                    firstCube = false;
                }
                else
                {
                    do
                    {
                        getal=r.nextInt(3);
                        
                    }while(getal == temp);
                }
                temp = getal;
                
                if (getal==1)      nieuw.setBackground(Color.RED);
                if (getal==2)      nieuw.setBackground(Color.GREEN);
                if (getal==0)      nieuw.setBackground(Color.BLUE);

                leeg=false;
            }
            else
            {
            nieuw.setBackground(Color.GRAY);
                leeg=true;
            }
        
            scene.popToFront(nieuw);
            scene.repaint();
            delay -= (delay / 50);
            System.out.println("delay"+delay);
            t.cancel();
            t=new Timer();
           mtt=new MijnTimerTask(this);
            t.schedule(mtt, delay, delay);
            System.out.println(delay);
        }
  
        
        
        
       
 
    
    
    
// wordt met implement all abstract methods gedaan
    public void userEventReceived(UserEvent e) {
        
        counter = new HStaticText("score: " + score, scene.getWidth()/10, scene.getHeight() / 10, 200,100);
        counter.setBackgroundMode(HVisible.BACKGROUND_FILL);
        counter.setBackground(Color.BLACK);
        
        if (!isPressed)
        {
            System.out.println("Keypressed " + score);
            if(e.getCode() == HRcEvent.VK_COLORED_KEY_0 || e.getCode() == HRcEvent.VK_1) //f5
            {
                System.out.println("RED");
                

                if (!leeg)
                {
                    if (nieuw.getBackground()==Color.RED)
                    {
                        System.out.println("GOED!");
                        score++;
                        nieuw.setBackground(Color.GRAY);
                        nieuw.setBackgroundMode(HVisible.BACKGROUND_FILL);
                        scene.add(nieuw);
                    }
                    else
                    {
                        lives--;
                        updateLevens();
                    }
                    nieuw.setBackground(Color.GRAY);
                }


            }

            if(e.getCode() == HRcEvent.VK_COLORED_KEY_1 || e.getCode() == HRcEvent.VK_2)//f6
            {
                System.out.println("GREEN " + score);

                if (!leeg)
                {
                    if (nieuw.getBackground()==Color.GREEN) 
                    {
                        System.out.println("GOED!");
                        score++;
                        nieuw.setBackground(Color.GRAY);
                        nieuw.setBackgroundMode(HVisible.BACKGROUND_FILL);
                        scene.add(nieuw);
                    }
                    else
                    {
                        lives--;
                        updateLevens();
                    }
                    nieuw.setBackground(Color.GRAY);
                }
            }

            if(e.getCode() == HRcEvent.VK_COLORED_KEY_3 || e.getCode() == HRcEvent.VK_3) //f8
            {
                System.out.println("BLUE " + score);

                if (!leeg)
                {
                    if (nieuw.getBackground()==Color.BLUE)
                    {
                        System.out.println("GOED!");
                        score++;
                        nieuw.setBackground(Color.GRAY);
                        nieuw.setBackgroundMode(HVisible.BACKGROUND_FILL);
                        scene.add(nieuw);
                    }
                    else
                    {
                        lives--;
                        updateLevens();
                    }
                    nieuw.setBackground(Color.GRAY);
                }

            }
            if(lives <= 0 && (e.getCode() == HRcEvent.VK_COLORED_KEY_2 || e.getCode() == HRcEvent.VK_ENTER))
            {
                scene.removeAll();
                lives = 3;
                score = 0;
                firstCube = true;
                Instructions();
                delay = 2000;
                hearts = new Heart[3];
                updateLevens();
            }
            isPressed = true;
        }
        if(e.getType() == HRcEvent.KEY_RELEASED)
        {
            isPressed = false;
        }
        
        scene.add(counter);
        scene.popToFront(counter);
        scene.repaint();
    }
}
