
package erg2;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * Autor: Cesar Peña
 *
 */
public class BarraProgress extends javax.swing.JFrame implements Runnable{
    
    public final static int ONE_SECOND = 1000;
    private Timer timer;
    private Hilo Hilo;
    private TimerListener t;
    String f;

    public BarraProgress(){
        
    }
    
    public BarraProgress(int g) {
        Hilo = new Hilo(g);
        initComponents();
        t = new TimerListener();
        timer = new Timer(ONE_SECOND, t);
        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);

    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jProgressBar1 = new JProgressBar(0, Hilo.getLengthOfTask());
        Process = new javax.swing.JLabel();

        Process.setFont(new java.awt.Font("Arial", 0, 11));
        Process.setText("Iniciando ....");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Process)
                    .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 344, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(Process)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    class TimerListener implements ActionListener {
        boolean l;
            public void actionPerformed(ActionEvent evt) {
                jProgressBar1.setValue(Hilo.RetVal());
                Process.setText(Hilo.RetMens());
                if (Hilo.hecho()) {
                    Toolkit.getDefaultToolkit().beep();
                    timer.stop();
                    if(!timer.isRunning()) {l = true;} else l=false; 
                }
            }
            public boolean RetListo(){
                return l;
            }
            
        }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarraProgress().setVisible(true);
            }
        });
      }

    public void run() {
        Hilo.Iniciar();
        timer.start();
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Process;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
}
