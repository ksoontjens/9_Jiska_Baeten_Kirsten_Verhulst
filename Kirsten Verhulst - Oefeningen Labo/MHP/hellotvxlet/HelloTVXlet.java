package hellotvxlet;

import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener
{
    static HScene scene = null;
    static Subject publisher = null;
    Player shield;
    PlayerHeart heart;
    
    public static HScene getScene()
    {return scene;}
    
    public static Subject getPublisher()
    {return publisher;}
    
    public void destroyXlet(boolean unconditional) { 
    }

    public void initXlet(XletContext ctx) {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        shield = new Player(302,235);
        heart = new PlayerHeart(344,270);
     //   EnemyRocket s2= new EnemyRocket(100,200);
        Achtergrond bg=new Achtergrond(0, 0, 720, 576);

        
        
        //scene.add(s2); //zet s2 op de scene
        scene.add(shield);
        scene.add(heart);
        scene.add(bg);// later terug toevoegen want layer probleem
        
        publisher = new Subject();
        Timer tim1 = new Timer();
        tim1.scheduleAtFixedRate(publisher, 0, 10); //elke 10 ms
        
        for(int x = 0; x< 10;x++)
            for(int y=0; y<5;y++)
            {
                Enemy e=new Enemy(x*50, y*50);
                scene.add(e);
                publisher.register(e);
            }
       
     //   publisher.register(s2);
        publisher.register(shield);
        publisher.register(heart);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
       UserEventRepository rep = new UserEventRepository("naam");
       rep.addAllArrowKeys(); 
       EventManager m=EventManager.getInstance(); 
       m.addUserEventListener(this,rep);   
    }
    
    public void userEventReceived(UserEvent e) {
        if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_LEFT)
        {
        shield.moveleft();
        } 
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_RIGHT)
        {
        shield.moveright();
        }
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_UP)
        {
        shield.moveup();
        } 
        else if(e.getType()==KeyEvent.KEY_PRESSED && e.getCode()==HRcEvent.VK_DOWN)
        {
        shield.movedown();
        }
    }
}