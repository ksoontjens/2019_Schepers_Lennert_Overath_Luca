package hellotvxlet;

import java.awt.Color;
import java.awt.Image;
import java.lang.Math;
import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;


public class HelloTVXlet implements Xlet {

    
    static int cubeWidth = 200, cubeHeigth = 400;
    static int sceneWidth = 800, sceneHeight = 600;
    static Sound sound = new Sound();
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
      
        HStaticText redCube = new HStaticText("Press 'Q'",(sceneWidth - cubeWidth)/2, (sceneHeight - cubeHeigth)/2, cubeWidth, cubeHeigth);
        redCube.setBackgroundMode(HVisible.BACKGROUND_FILL);
        redCube.setBackground(Color.RED);
        HStaticText greenCube = new HStaticText("Press 'S'",(sceneWidth - cubeWidth)/2, (sceneHeight - cubeHeigth)/2, cubeWidth, cubeHeigth);
        greenCube.setBackgroundMode(HVisible.BACKGROUND_FILL);
        greenCube.setBackground(Color.GREEN);
        HStaticText blueCube = new HStaticText("Press 'D'",(sceneWidth - cubeWidth)/2, (sceneHeight - cubeHeigth)/2, cubeWidth, cubeHeigth);
        blueCube.setBackgroundMode(HVisible.BACKGROUND_FILL);
        blueCube.setBackground(Color.BLUE);
        
        HStaticText[] cubes = {redCube, greenCube, blueCube};
        HStaticText activeCube = cubes[(int)Math.floor(Math.random()*cubes.length)];
           
        scene.add(activeCube);

        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.setBackground(Color.BLACK);
        scene.setVisible(true);

        sound.PlaySound();
        
        scene.validate();
        
 
      
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
