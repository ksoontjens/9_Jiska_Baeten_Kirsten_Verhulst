/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import java.net.URL;
import org.dvb.ui.*;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
    private int  setHeight, setWidth;
    private Image afbeelding;
    
    public MijnComponent(int x, int y, int height, int width)
    {
        this.setBounds(x,y,width,height);
        setHeight = height;
        setWidth = width;
        this.getToolkit().getImage("schip.png");
        //in c:\program files\technotrend\fileio\DMSCm\0.03
        
        MediaTracker mt = new MediaTracker(null);
        mt.addImage(schipimg, 0);
    }
    

    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(0,0,63,179));
        g.fillRoundRect(10,10,setWidth -10,setHeight-10,15,15); //x,y, br, hoogte
        g.setColor(new DVBColor(0,0,179,179));
        g.fillRoundRect(0,0,setWidth -10,setHeight-10,15,15);
        g.setColor(new DVBColor(255,255,0,255));
        g.drawString("Tekst1", 15, 25);
        
        g.drawImage(afbeelding, 0, 0, null);
    }

}
