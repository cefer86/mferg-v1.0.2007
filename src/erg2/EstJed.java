package erg2;

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
public class EstJed extends javax.swing.JPanel {
    
    private Jed form;
    private double divV,divT;
    Font f3,f4;
    private Integer mxmi[] = null;
    
    
    public EstJed() {
        initComponents();
    }
    
    public EstJed(Jed fr) {
        this.form = fr;
        f3= new Font("Fuente3",Font.BOLD,10);
        f4= new Font("Fuente4",Font.BOLD,13);
        this.mxmi = form.RetMaxMinHex();
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
       BigDecimal bg1 = new BigDecimal(form.RetMaxJed()).setScale(10,BigDecimal.ROUND_UP);
       BigDecimal bg2 = new BigDecimal(form.RetMinJed()).setScale(10,BigDecimal.ROUND_UP);
       BigDecimal bg3 = new BigDecimal(form.RetMediaJed()).setScale(10,BigDecimal.ROUND_UP);
       
       g.setColor(Color.GREEN);
       
       g.setFont(f3);
       g.drawString("Densidad Máxima:(C)",6,18);
       g.drawString("Hexágono: "+mxmi[0],6,48);
       g.setFont(f4);
       g.drawString(""+ bg1+" µV/ms",10,35);
       
       g.setFont(f3);
       g.drawString("Densidad Mínima:(C)",6,73);
       g.drawString("Hexágono: "+mxmi[1],6,103);
       g.setFont(f4);
       g.drawString(""+bg2+" µV/ms",10,90);
       
       g.setFont(f3);
       g.drawString("Densidad Media:(C)",6,128);
//       g.drawString("Hexágono: "+mxmi[1],6,158);
       g.setFont(f4);
       g.drawString(""+bg3+" µV/ms",10,145);

       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
