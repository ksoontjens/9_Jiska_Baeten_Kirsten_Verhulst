
package hellotvxlet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;
import org.havi.ui.HVisible;

public class Enemy extends Sprite{
    Image mijnimg;
    int richting = 1;
    int teller=0;
    
    Random r;
    
    static int aantaEnemies =0;
    public Enemy(int x, int y)
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
    
    public void update (int tijd){
        int x = this.getX();
        int y = this.getY();
        x=x+richting;
        if(x>=720 - mijnimg.getWidth(this)) richting = -1;
        if(x<=0) richting =1;
        this.setLocation(x,y);
        
        teller++;
                if (teller>50) //nieuwe raket
                {
                    teller = 0;
                    EnemyRocket raket = new EnemyRocket(x+20,y+20);
                    HelloTVXlet.getScene().add(raket);
                    HelloTVXlet.getPublisher().register(raket);
                    
                }
    }
}
