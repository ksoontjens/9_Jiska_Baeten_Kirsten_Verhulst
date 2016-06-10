/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask{
    
    HelloTVXlet xlet; //link naat een HelloTVXlet
    
    public MijnTimerTask(HelloTVXlet x)
    {
        xlet = x;
    }

    public void run() {
        System.out.println("tick...");
        xlet.callback();
        
    }

}
