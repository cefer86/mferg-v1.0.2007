
package erg3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.math.BigDecimal;
/**
 *
 * Autor: Cesar Peña
 */
public class DatosMMM extends javax.swing.JPanel {
    
    private GrafWave_DWT form;
    private mferg form2;
    private int TotalCoef;
    private long TotalTime;
    private double TotalTimeEst;
    private double divV,divT;
    Font f3,f4;
    
    
    
    public DatosMMM() {
        initComponents();
    }
    
    public DatosMMM(GrafWave_DWT fr, mferg fr2) {
       this.form = fr;
       this.form2 = fr2;
       this.TotalCoef = form2.r1.cc1.RetTotalCoef();
       f3= new Font("Fuente3",Font.PLAIN,11);
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
       BigDecimal bg1 = new BigDecimal(form2.r1.cc1.RetMaximo()).setScale(8,BigDecimal.ROUND_UP);
       BigDecimal bg2 = new BigDecimal(form2.r1.cc1.RetMinimo()).setScale(8,BigDecimal.ROUND_UP);
       BigDecimal bg3 = new BigDecimal(form2.r1.cc1.RetMedia()).setScale(8,BigDecimal.ROUND_UP);
       g.drawString("Máximo:  "+bg1,23,25);
       g.drawString("Mínimo:  "+bg2,23,44);
       g.drawString("Media :  "+bg3,23,63);
       g.drawString("N : "+TotalCoef,23,82);
       g.setColor(new Color(0.36f,0.5f,0.8f));
       g.fillRect(11,36,6,6);
       g.setColor(Color.RED);
       g.fillRect(11,17,6,6);
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
