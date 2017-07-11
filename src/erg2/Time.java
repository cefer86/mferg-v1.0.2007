
package erg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * Autor: Cesar Peña
 *
 */
public class Time extends javax.swing.JPanel {
    
    private Test0 form2;
    private double TotalTime;
    private double TotalTimeEst;
    private double divV,divT;
    Font f3,f4;
    
    public Time() {
        initComponents();
    }
    
    public Time(Test0 fr) {
       this.form2 = fr;
       f3= new Font("Fuente3",Font.BOLD,9);
       f4= new Font("Fuente4",Font.BOLD,15);
    }

    public void paintComponent(Graphics g1) {
        
       super.paintComponent(g1);
       Graficar(g1);
       
        }
    
    public void Graficar(Graphics g1){
       
       Graphics2D g = (Graphics2D)g1;
       g.translate( this.getInsets().left,this.getInsets().top );
       g.setColor(Color.BLACK);
       g.fillRect(0,0,this.getWidth(),this.getHeight());
       g.setColor(new Color(0.220f,0.220f,0.220f));
       
       TotalTime = form2.RetTimeTest();
       TotalTimeEst = form2.RetTimeEst();
       divT=(this.getWidth()/16);
       divV=(this.getHeight()/16);
  
       for(int i=1;i<=this.getWidth();i++){
           g.draw(new Line2D.Double(i*divT,0,i*divT,this.getHeight()));
       }
       for(int i=1;i<=this.getHeight();i++){
           g.draw(new Line2D.Double(0,i*divV,this.getWidth(),i*divV));
       }
       
       g.setFont(f3);
       g.setColor(Color.GREEN);
       g.drawString("Tiempo Total del Estimulo:",4,13);
       g.setFont(f4);
       if(TotalTimeEst==0)g.drawString(""+TotalTimeEst+" ms",8,30);
       if(TotalTimeEst!=0)g.drawString(""+TotalTimeEst+" ms",8,30);
       g.setFont(f3);
       g.setColor(Color.GREEN);
       g.drawString("Tiempo Maquina:",4,43);
       g.setFont(f4);
       if(TotalTime==0)g.drawString(""+(double)TotalTime+" ms",8,59);
       if(TotalTime!=0)g.drawString(""+(double)TotalTime+" ms",8,59);
       
    }
       
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
