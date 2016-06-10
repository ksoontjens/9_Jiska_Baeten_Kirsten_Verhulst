package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HScene;
import org.havi.ui.HVisible;

public class EnemyRocket extends Sprite{
    Image mijnimg;
    int direction;
    Random r;
    int y,x;
    HScene scene;
    public EnemyRocket(int x, int y, int richting)
    {
       super(x,y);
       r = new Random();
       this.direction = richting;  
       scene = HelloTVXlet.getScene();
       switch (direction)
       {
           case 1:  //left
               mijnimg = this.getToolkit().getImage("spr_bullet_test_l_0.png");
               break;
           case 2:  //up
               mijnimg = this.getToolkit().getImage("spr_bullet_test_d_0.png");
               break;
           case 3:  //right
               mijnimg = this.getToolkit().getImage("spr_bullet_test_r_0.png");
               break;
           case 4:  //down
               mijnimg = this.getToolkit().getImage("spr_bullet_test_u_0.png");
               break;
               
       }
       MediaTracker mt = new MediaTracker(this); 
      
       mt.addImage(mijnimg, 1);
       try {
       mt.waitForAll();
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
       this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
       this.setSize(mijnimg.getWidth(this), mijnimg.getHeight(this));
    }
    
    public void update(int tijd) {
        scene.popToFront(this);
        int x = this.getX(); //zijn methodes van HStaticIcon
        int y= this.getY();
        
        if (y > 576 || x > 720)//kogels vliegen uit beeld ==> dus vernietigen
        {
            ColissionDetected();
        }
               switch (direction)
       {
           case 1:  //left
                x++;
               break;
           case 2:  //up
                y++;
               break;
           case 3:  //right
                x--;
               break;
           case 4:  //down
               y--;
               break;
                   default:
                       break;
       }
       
        this.setLocation(x, y);
    }
    
   public void ColissionDetected()
   {
       HelloTVXlet.scene.remove(this);
       HelloTVXlet.publisher.unregister(this);
       
   }
           
}
