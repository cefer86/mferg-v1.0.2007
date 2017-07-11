
package erg2;

import javax.swing.SwingUtilities;

/**
 *
 * Autor: Cesar Peña
 */

public abstract class SwingWork {
    
   private Object value;
    private Thread thread;

    public abstract Object construct();

    public void finished() {
    }

    public Object get() {
        while (true) {  // keep trying if we're interrupted
            Thread t;
            synchronized (SwingWork.this) {
                t = thread;
                if (t == null) {
                    return value;
                }
            }
            try {
                t.join();
            }
            catch (InterruptedException e) {
            }
        }
    }

    public SwingWork() {
        final Runnable doFinished = new Runnable() {
           public void run() { finished(); }
        };

        Runnable doConstruct = new Runnable() { 
            public void run() {
                synchronized(SwingWork.this) {
                    value = construct();
                    thread = null;
                }
                SwingUtilities.invokeLater(doFinished);
            }
        };

        thread = new Thread(doConstruct);
        thread.start();
    }
    
}
