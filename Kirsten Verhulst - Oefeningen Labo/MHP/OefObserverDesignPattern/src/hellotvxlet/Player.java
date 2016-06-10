
package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HVisible;

public class Player extends Sprite{
    Image mijnimg;
    
    static int aantaEnemies =0;
    public Player(int x, int y)
    {
        super(x,y);
        mijnimg= this.getToolkit().getImage("schip.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(mijnimg, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setGraphicContent(mijnimg, HVisible.NORMAL_STATE);
        this.setSize(mijnimg.getWidth(this),mijnimg.getHeight(this));
        
    }

    public void update(int tijd) {
        int x = this.getX();
        int y = this.getY();
        
        this.setLocation(x,y);
    }
}