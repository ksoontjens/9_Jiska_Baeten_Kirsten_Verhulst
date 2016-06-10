package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    HTextButton button1;
    HTextButton button2;
    HTextButton button3;
    HTextButton button4;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {  
        System.out.println("initXlet");
        scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
        System.out.println("startXlet");
        HStaticText label =new HStaticText("HELLO",300,100,100,50);
                                            //string, x, y, breedte, hoogte
        label.setBackgroundMode(HVisible.BACKGROUND_FILL);
        //label.setBackground(Color.BLACK);
        label.setBackground(new DVBColor(255,0,0,127)); //R,G,B,alpha
        
        button1=new HTextButton("BUTTON1",100,200,200,50);
        button2=new HTextButton("BUTTON2",100,300,200,50);
        button3=new HTextButton("BUTTON1",200,200,200,50);
        button4=new HTextButton("BUTTON2",200,300,200,50);
        
                
        button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button1.setBackground(new DVBColor(255,0,0,127));
        
        scene.add(button1);
        scene.add(button2);     // up   down   left right
        button1.setFocusTraversal(null,button3,null,button2);
        button2.setFocusTraversal(null,button4,button1,null);
        button3.setFocusTraversal(button1, null, null, button4);
        button4.setFocusTraversal(button2, null, button3, null);
        
        button1.setActionCommand("button1klik");
        button1.addHActionListener(this);   //bovenaan toevoegen bij implements
                    //public class HelloTvXlet implements Xlet,HActionListener
        
        button2.setActionCommand("button2klik");
        
                
        scene.add(label);
        scene.validate();
        scene.setVisible(true);
        button1.requestFocus();
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        
        if(event.getActionCommand().equals(("button1klik")))
        {
            button1.setBackground(Color.BLUE);
            scene.repaint();
        }
    }
}
