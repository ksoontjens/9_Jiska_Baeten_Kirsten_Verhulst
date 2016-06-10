package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

public class PlayerHeart extends Sprite{
    Image playerImg;
    
    public PlayerHeart(int x, int y)
    {
       super(x,y); //moet op de eerste lijn staan
       playerImg = this.getToolkit().getImage("heartgreen.png");
       MediaTracker mt = new MediaTracker(this); 
      
       mt.addImage(playerImg, 1);
       try {
       mt.waitForAll();
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
       this.setGraphicContent(playerImg, HVisible.NORMAL_STATE);
       this.setSize(playerImg.getWidth(this), playerImg.getHeight(this));
    }
    
    public void update(int tijd) {
        int x = this.getX(); //zijn methodes van HStaticIcon
        int y= this.getY();
        this.setLocation(x, y);
    }  
}
