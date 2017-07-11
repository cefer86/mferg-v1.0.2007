package erg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * Autor: Cesar Peña
 *
 */
public class adqDatos extends javax.swing.JPanel implements MouseListener, MouseMotionListener {
    
    private Test0 form;
    private double divV, divT;
    int     offsetX, offsetY;   
    boolean dragging; 
    int     x0,y0;
    double  mx=12.231;
    Font    f1;
    private double BL = 0.0;
    private double y[] = null;
    
    public adqDatos() {
        initComponents();
    }
    public adqDatos(Test0 fr) {
       this.form = fr;
       addMouseListener(this);
       addMouseMotionListener(this);
       f1= new Font("Fuente1",Font.BOLD,10);
       offsetX=x0;
       this.x0=0;
      
    }
    
    public void paintComponent(Graphics g1) {
       super.paintComponent(g1);
       Graficar(g1, x0);
        }
    
    public void Graficar(Graphics g1, int xi){
       Graphics2D g = (Graphics2D)g1;
       BL = form.RetBl();
       g.translate( this.getInsets().left,this.getInsets().top );
       g.setColor(Color.BLACK);
       g.fillRect(0,0,this.getWidth(),this.getHeight());
       g.setFont(f1);
       this.y = form.s_entrada;
       divT=(this.getWidth()/50);
       divV=(this.getHeight()/50);
       
       g.setColor(new Color(0.30f,0.30f,0.30f));
       for(int i=1;i<=this.getWidth();i++){
           g.draw(new Line2D.Double(i*divT,0,i*divT,this.getWidth()));
       }
       for(int i=1;i<=this.getHeight();i++){
           g.draw(new Line2D.Double(0,i*divV,this.getWidth(),i*divV));
       }
       
       if(this.form.s_entrada!=null && !this.form.Import_estim){
           
       for(int x=0;x<y.length;x++){
         g.setColor(Color.YELLOW);
         g.draw(new Rectangle2D.Double((x*0.04+xi/mx)*divT,this.getHeight()/2-(y[x])*(this.getHeight()-200)*divV/15-BL*4,1,1));
         g.setColor(Color.WHITE);
         g.fill(new Rectangle2D.Double((80*x*0.04+xi/mx)*divT,this.getHeight()/2-BL*4,3,3));
         if(x!=0){
         g.setColor(Color.CYAN);    
         g.draw(new Line2D.Double((x*0.04+xi/mx)*divT,(this.getHeight()/2-(y[x])*(this.getHeight()-200)*divV/15-BL*4),
         ((x*0.04+xi/mx)-0.04)*divT,(this.getHeight()/2-(y[x-1])*(this.getHeight()-200)*divV/15-BL*4)));   
                }
        }
       
        g.drawString("T_MS: "+(form.tiempo_muest*1000)+" ms",this.getWidth()-90.0f,this.getHeight()-9.2f);    
       }
       
       
       g.setColor(Color.YELLOW);
       g.drawLine(12,this.getHeight()-10,28,this.getHeight()-10);
       g.drawLine(12,this.getHeight()-25,12,this.getHeight()-10);
       g.drawString("ms",29.5f,this.getHeight()-9.2f);
       g.drawString("mV",6.3f,this.getHeight()-26);
       g.setColor(Color.RED);
       g.draw(new Line2D.Double(0,this.getHeight()/2-BL*4,this.getWidth(),this.getHeight()/2-BL*4));
       
         
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
    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent evt) {
         if (dragging)  
            return;
         int x = evt.getX();  // clic inicial
         offsetX = x - x0;
         dragging = true;     
    }

    public void mouseReleased(MouseEvent e) {
        dragging = false;        
          repaint(); 
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent evt) {
        if (dragging == false)  return;
          int x = evt.getX();   // posición del mouse
          x0 = x - offsetX;     // mover origen
          repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }
    
}
