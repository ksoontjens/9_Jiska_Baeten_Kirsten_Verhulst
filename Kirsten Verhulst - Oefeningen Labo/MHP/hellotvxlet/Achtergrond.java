package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

public class Achtergrond extends HComponent{

    int setWidth;
    int setHeight;
    Image Undyne = this.getToolkit().getImage("UndyneKleiner.gif");
    
    public Achtergrond(int x, int y, int width, int height)
    {
    this.setBounds(x, y, width, height); //instantieer de grootte en locatie
    setWidth = width;
    setHeight = height;    
    }
    public void paint(Graphics g)
    {

        g.setColor(new DVBColor(0,0,0, 255)); 
        g.fillRect(0, 0, 720, 576); //zwarte achtergrond
        g.drawImage(Undyne, 210, 0, this); //NYAAAAAH!!!
        g.fillRect(297, 225, 125, 125);//black square behind playing field
        
        g.setColor(new DVBColor(255,255,255, 255)); //wit
        g.drawRect(297, 225, 125, 125); //buitenkant
        
        g.setColor(new DVBColor(65,70, 236, 255)); //zet op blauw
        g.drawLine(302,235, 340, 330); //2d schield
        
        g.setColor(new DVBColor(0,192, 0, 255)); //zet op groen
        g.drawOval(302, 230, 115, 115); //cirkel
         
    }
}
