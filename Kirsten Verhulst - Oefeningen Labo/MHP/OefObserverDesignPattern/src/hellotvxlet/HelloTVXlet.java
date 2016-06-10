package hellotvxlet;

import java.util.Timer;
import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet{
    static HScene scene; //dit hoort bij de klasse, niet het object
    static Subject publisher;
    
    public static HScene getScene()
    {
        return scene;
    }

    static Object getPublisher() {
        return publisher;
    }
    
    public void initXlet(XletContext arg0) throws XletStateChangeException {
        scene =HSceneFactory.getInstance().getDefaultHScene();
        
        Enemy s1 = new Enemy(100,100);
        scene.add(s1);
        EnemyRocket s2 =new EnemyRocket (100,200);
        scene.add(s2);
        Player play1 = new Player(400,500);
        scene.add(play1);
        
        publisher = new Subject();
        Timer tim1 =  new Timer();
        tim1.scheduleAtFixedRate(publisher,0,10); //elke 10ms
        
        for(int x=0;x<10;x++)
            for(int y=0;y<5;y++)
            {
                Enemy e = new Enemy(x*50,y*50);
                scene.add(e);
                publisher.register(e);
            }
        
        publisher.register(s1);
        publisher.register(s2);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void startXlet() throws XletStateChangeException {
       
    }

    public void pauseXlet() {
        
    }

    public void destroyXlet(boolean arg0) throws XletStateChangeException {
        
    }

}
