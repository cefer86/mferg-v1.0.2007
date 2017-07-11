

package erg2;



import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.Date;
/**
 *
 * Autor: Cesar Peña
 */

public class RelojModeloSwing extends Observable
 {

     public RelojModeloSwing()
     {
         Timer timer = new Timer (1000, new ActionListener ()
         {
             public void actionPerformed(ActionEvent e)
             {
                 setChanged();
                 notifyObservers (new Date());
             }
         });
         timer.start();
     }
     
}

