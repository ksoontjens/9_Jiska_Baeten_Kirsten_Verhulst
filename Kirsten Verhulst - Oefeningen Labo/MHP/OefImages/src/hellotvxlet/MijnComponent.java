/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

/**
 *
 * @author Kirsten Verhulst
 */
public class MijnComponent extends HComponent {
    private int  setHeight, setWidth, x, y;
    private Image afbeelding, achtergrond;
    int sy = 0;
    
    public MijnComponent(int x, int y, int width, int height)
    {
        this.setBounds(x,y,width,height);
        this.x = 500;
 
        afbeelding = this.getToolkit().getImage("schip.png");
        achtergrond = this.getToolkit().getImage("sterren.png");
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(afbeelding, 0); //img, volgnmr
        mt.addImage(achtergrond, 2);
        try{
            mt.waitForAll();
        }
        catch (InterruptedException ex){ ex.printStackTrace();}
    }
    

    public void paint(Graphics g)
    {
        g.drawImage(achtergrond,0,sy,null);
        g.drawImage(achtergrond,0,sy-570,null);
        g.drawImage(afbeelding, x, 520, null);
    }
    
    public void moveLeft()
    {
        x -= 10; if (x<0)x = 0;
        this.repaint();
    }

        public void moveRight()
    {
        x+=10; if (x>672) x = 672; //720-48
        this.repaint();
    }
        
        public void scroll()
        {
            sy+=5; if (sy>570) sy =0;
            this.repaint();
        }
}
