package hellotvxlet;

import org.havi.ui.HStaticIcon;

public abstract class Sprite extends HStaticIcon implements ObserverInterface{
    public Sprite(int x, int y)//geef x en y pos mee
    {
        super();
        this.setLocation(x, y);
        this.setSize(50, 50);
    }
}
