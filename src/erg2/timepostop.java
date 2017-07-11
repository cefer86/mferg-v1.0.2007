

package erg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.Timer;

/**
 *
 * Autor: Cesar Peña
 */
public class timepostop implements Runnable{
    
    public Timer timer;
    private TimerListener t;
    public Test0 fr;
    
    public timepostop(Test0 fr) {
        t = new TimerListener();
        timer = new Timer(1000, t);
        this.fr = fr;
    }

    public void run() {
        timer.start();
      }
    public void stop() {
        timer.stop();
    }
     
    class TimerListener implements ActionListener {
        boolean l;
        public int tt=0,dtt=0;
            public void actionPerformed(ActionEvent evt) {
                if (timer.isRunning() && !fr.play_time) {
                    l=false;
                    dtt=tt*timer.getDelay();
                    tt++;
                    System.out.println(dtt);
                }else  l=true;
             }
            public boolean RetListo(){
                return l;
            }
            
        }
    
    public boolean RetListo(){
        return t.RetListo();
    }
    
}
