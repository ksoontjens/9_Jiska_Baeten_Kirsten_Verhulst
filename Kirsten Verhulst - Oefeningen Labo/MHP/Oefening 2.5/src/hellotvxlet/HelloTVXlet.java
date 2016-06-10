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
    HTextButton buttonHulp;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {  
        System.out.println("initXlet");
        scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
        System.out.println("startXlet");
        HStaticText label =new HStaticText("Would you smooch a ghost?",10,300,700,100);
                                            //string, x, y, breedte, hoogte
        label.setBackgroundMode(HVisible.BACKGROUND_FILL);
        //label.setBackground(Color.BLACK);
        label.setBackground(new DVBColor(50,50,50,127)); //R,G,B,alpha
        
        button1=new HTextButton("Heck no",25,420,325,60);
        button2=new HTextButton("What?",375,420,325,60);
        button3=new HTextButton("BUTTON 3",25,495,325,60);
        button4=new HTextButton("Heck yes",375,495,325,60);
        buttonHulp=new HTextButton("Hulplijn",550,10,150,40);
        
        
                
        button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button1.setBackground(new DVBColor(50,50,50,127));
        button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button2.setBackground(new DVBColor(50,50,50,127));
        button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button3.setBackground(new DVBColor(50,50,50,127));
        button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button4.setBackground(new DVBColor(50,50,50,127));
        buttonHulp.setBackgroundMode(HVisible.BACKGROUND_FILL);
        buttonHulp.setBackground(new DVBColor(50,50,50,127));
        
        scene.add(button1);
        scene.add(button2);     // up   down   left right
        scene.add(button3);
        scene.add(button4);
        scene.add(buttonHulp);
 
        button1.setFocusTraversal(null,button3,null,button2);
        button2.setFocusTraversal(buttonHulp,button4,button1,null);
        button3.setFocusTraversal(button1, null, null, button4);
        button4.setFocusTraversal(button2, null, button3, null);
        buttonHulp.setFocusTraversal(null,button2,null,null);
        
        button1.setActionCommand("button1klik");
        button1.addHActionListener(this);   //bovenaan toevoegen bij implements
                    //public class HelloTvXlet implements Xlet,HActionListener
        
        button2.setActionCommand("button2klik");
        button2.addHActionListener(this); 
        button3.setActionCommand("button3klik");
        button3.addHActionListener(this); 
        button4.setActionCommand("button4klik");
        button4.addHActionListener(this);
        buttonHulp.setActionCommand("buttonHulpklik");
        buttonHulp.addHActionListener(this); 
                
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
            button1.setBackground(new DVBColor(225,107,107,127));
            scene.remove(button2);
            scene.remove(button3);
            scene.remove(button4);
            scene.repaint();
        }
        if(event.getActionCommand().equals(("button2klik")))
        {
            button2.setBackground(new DVBColor(225,107,107,127));
            scene.remove(button1);
            scene.remove(button3);
            scene.remove(button4);
            scene.repaint();
        }
        if(event.getActionCommand().equals(("button3klik")))
        {
            button3.setBackground(new DVBColor(225,107,107,127));
            scene.remove(button1);
            scene.remove(button2);
            scene.remove(button4);
            
            scene.repaint();
        }
        if(event.getActionCommand().equals(("button4klik")))
        {
            button4.setBackground(new DVBColor(107,225,107,127));
            scene.remove(button1);
            scene.remove(button2);
            scene.remove(button3);
            scene.repaint();
        }
        
        if(event.getActionCommand().equals(("buttonHulpklik")))
        {
            scene.remove(button2);
            scene.remove(button3);
            button1.setFocusTraversal(null,button4,null,button4);
            button4.setFocusTraversal(button1,null,button1,null);
            buttonHulp.setFocusTraversal(null,button1,null,null);
            scene.repaint();
        }
        
        
    }
}
