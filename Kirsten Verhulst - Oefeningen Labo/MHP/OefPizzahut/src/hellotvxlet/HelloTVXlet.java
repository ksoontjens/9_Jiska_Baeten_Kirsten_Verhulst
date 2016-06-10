package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import org.havi.ui.event.HRcEvent;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {
    HBackgroundDevice hBackgrDev;
    HBackgroundImage pizza1, pizza2,pizza3,pizza4;
    HStillImageBackgroundConfiguration hsbic;
    int imageTeller,cursor;
    HScene scene = HSceneFactory.getInstance().getDefaultHScene();
    HStaticText orderhst;
    String orderstring = "Orderlijst \n";
    

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {

    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScreen hscreen = HScreen.getDefaultHScreen();
        hBackgrDev = hscreen.getDefaultHBackgroundDevice();
        hBackgrDev.reserveDevice(this);     //bovenaan implements resourceClien toevoegen
                                            //+ import+ implement all abstract methods
        HBackgroundConfigTemplate cfgTemplate = new HBackgroundConfigTemplate();
        cfgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
                HBackgroundConfigTemplate.REQUIRED);
        
        hsbic = (HStillImageBackgroundConfiguration) hBackgrDev.getBestConfiguration(cfgTemplate);
        
        try{
        
        if (hBackgrDev.setBackgroundConfiguration(hsbic))
        { System.out.println("resvervatie & configuratie gelukt!");}
        }
        catch (Exception ex) {ex.printStackTrace();}
        
        
        pizza1=new HBackgroundImage("pizza1.m2v");
        pizza1.load(this);
        pizza2=new HBackgroundImage("pizza2.m2v");
        pizza2.load(this);
        pizza3=new HBackgroundImage("pizza3.m2v");
        pizza3.load(this);
        pizza4=new HBackgroundImage("pizza4.m2v");
        pizza4.load(this);
        
        UserEventRepository rep = new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        EventManager e = EventManager.getInstance();
        e.addUserEventListener(this, rep);
        
            
        orderhst = new HStaticText(orderstring,400,50,300,400);
        orderhst.setVerticalAlignment(HStaticText.VALIGN_TOP);
        orderhst.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        scene.add(orderhst);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
 
    }

    public void startXlet() throws XletStateChangeException {

    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        imageTeller++;
    if(imageTeller == 4)System.out.println("Alles is geladen");
    try{ hsbic.displayImage(pizza1); } catch (Exception ex){ ex.printStackTrace();}
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType()==KeyEvent.KEY_PRESSED)
        {
            if(e.getCode()==HRcEvent.VK_LEFT) //setup boxen havi import gebruiken ipv blu-ray
            {
             cursor--; if (cursor<1) cursor=4;
            }
            if(e.getCode()==HRcEvent.VK_RIGHT) //setup boxen havi import gebruiken ipv blu-ray
            {
             cursor++; if (cursor>4) cursor=1;
            }
            if(e.getCode()==HRcEvent.VK_ENTER) //setup boxen havi import gebruiken ipv blu-ray
            {
             if(cursor==1) orderstring = orderstring+ "Meat Lovers\n";
            if(cursor==2) orderstring = orderstring+ "Pepperoni Lover\n";
            if(cursor==3) orderstring = orderstring+ "Cheese Lovers\n";
            if(cursor==4) orderstring = orderstring+ "Vegi Lovers\n";
            }
            orderhst.setTextContent(orderstring, HStaticText.NORMAL_STATE);
        }
        try{
        if(cursor==1) hsbic.displayImage(pizza1);
        if(cursor==2) hsbic.displayImage(pizza2);
        if(cursor==3) hsbic.displayImage(pizza3);
        if(cursor==4) hsbic.displayImage(pizza4);
        }
        catch (Exception ex){}
    }
   

}
