package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

//this is the shield
public class Player extends Sprite{
    Image playerImg;
    
    public Player(int x, int y)
    {
       super(x,y); //moet op de eerste lijn staan
       
       playerImg = this.getToolkit().getImage("shield.png");
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
    
    public void moveleft()
    {
    int x = this.getX();
    int y = this.getY();
    x-=5;
    this.setLocation(x, y);
    this.repaint();    
    }
    
    public void moveright()
    {
    int x = this.getX();
    int y = this.getY();
    x+=5;
    this.setLocation(x, y);
    this.repaint();
    }
    
    public void moveup()
    {
    int x = this.getX();
    int y = this.getY();
    y-=5;
    this.setLocation(x, y);
    this.repaint();  
    }
    
    public void movedown()
    {
    int x = this.getX();
    int y = this.getY();
    y+=5;
    this.setLocation(x, y);
    this.repaint();
    }
}
