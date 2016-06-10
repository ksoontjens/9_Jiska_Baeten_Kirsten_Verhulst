package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

//this is the shield
public class Player extends Sprite{
    Image playerImgVertikal= this.getToolkit().getImage("shield_vertical.png");
    Image playerImgHorizontal= this.getToolkit().getImage("shield.png");
    Image currentImg;
    MediaTracker mt;
    
    public Player(int x, int y)
    {
       super(x,y); //moet op de eerste lijn staan
       
       mt = new MediaTracker(this); 
       currentImg = playerImgVertikal;
       changeImage();
       
       this.setGraphicContent(currentImg, HVisible.NORMAL_STATE);
       this.setSize(currentImg.getWidth(this), currentImg.getHeight(this));
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
    currentImg = playerImgVertikal;
    x=302;
    y=230;
    changeImage();

    this.setLocation(x, y);
    this.repaint();    
    }
    
    public void moveright()
    {
    int x = this.getX();
    int y = this.getY();
    x=415;
    y=230;
    currentImg = playerImgVertikal;
    changeImage();
    this.setLocation(x, y);
    this.repaint();
    }
    
    public void moveup()
    {
    int x = this.getX();
    int y = this.getY();
    currentImg = playerImgHorizontal;
    x=302;
    y=230;
    changeImage();
    this.setLocation(x, y);
    this.repaint();  
    }
    
    public void movedown()
    {
    int x = this.getX();
    int y = this.getY();
    currentImg = playerImgHorizontal;
    
    x = 302;
    y = 345;
    changeImage();
    this.setLocation(x, y);
    this.repaint();
    }
    
    private void changeImage()
    {
       mt.addImage(currentImg, 1);
       
       try {
       mt.waitForAll();
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
       this.setGraphicContent(currentImg, HVisible.NORMAL_STATE);
       this.setSize(currentImg.getWidth(this), currentImg.getHeight(this));
    }
    
}
