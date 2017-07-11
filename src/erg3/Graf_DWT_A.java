package erg3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.math.BigDecimal;

/**
 *
 * Autor: Cesar Peña
 */
public class Graf_DWT_A extends javax.swing.JPanel implements MouseListener, MouseMotionListener {
    
    private DWT_Form1 form;
    private double divT,divV,ScalmV,Scalms,maximo,minimo,dv,maximo1,minimo1,dv1;
    private double apx1[]=null,det1[]=null;
    int     offsetX, offsetY;   
    boolean dragging; 
    int     x0,y0;
    double  mx=12.231;
    private Font f1;
    String  Cd;
    private BigDecimal bd,bg1;
   
    public Graf_DWT_A() {
        initComponents();
    }
    
    public Graf_DWT_A(DWT_Form1 fr, String cuad) {
         this.form = fr;
         addMouseListener(this);
         addMouseMotionListener(this);
         this.Cd = cuad;
         this.apx1 = form.Ret_A1();
         this.det1 = form.Ret_D1();
         offsetX=x0;
         this.x0=0;
         f1= new Font("Fuente1",Font.BOLD,10);
          for(int i=0;i<apx1.length;i++){
           if(maximo >=Math.abs(apx1[i])) maximo = maximo;
           else maximo = Math.abs(apx1[i]);
           if(minimo <=Math.abs(apx1[i])) minimo = minimo;
           else minimo = Math.abs(apx1[i]);
       }
        dv=7.5*(maximo-minimo);
        for(int i=0;i<det1.length;i++){
           if(maximo1 >=Math.abs(det1[i])) maximo1 = maximo1;
           else maximo1 = Math.abs(det1[i]);
           if(minimo1 <=Math.abs(det1[i])) minimo1 = minimo1;
           else minimo1 = Math.abs(det1[i]);
       }
        dv1=7.5*(maximo1-minimo1);
    }
        
    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graficar(g1,x0);
     }

     public void Graficar(Graphics g1, int xi){
       
       Graphics2D g = (Graphics2D)g1;
       ScalmV = form.Ret_mV();
       Scalms = form.Ret_ms();
       
       g.translate( this.getInsets().left,this.getInsets().top );
       g.setColor(Color.BLACK);
       g.fillRect(0,0,this.getWidth(),this.getHeight());
       g.setColor(new Color(0.220f,0.220f,0.220f));
       g.setFont(f1);
      // Divisiones de Dominio y Rango en la Cuadrícula
      divT=(this.getWidth()/(50-Scalms+1));
      divV=(this.getHeight()/(50-ScalmV+1));

      //Graficación de la Cuadrícula
      for(int i=1;i<=this.getWidth();i++){g.draw(new Line2D.Double(i*divT,0,i*divT,this.getHeight()));}
      for(int i=1;i<=this.getHeight();i++){g.draw(new Line2D.Double(0,i*divV,this.getWidth(),i*divV));}
      
      //Graficación de los ejes
      g.setColor(Color.WHITE); 
      g.draw(new Line2D.Double(3+xi/mx*divT,0,3+xi/mx*divT,this.getHeight()));
      g.draw(new Line2D.Double(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2)); 
      if(form.Ret_opc()=="Aproximación")
      for(int k=0;k<80;k++){
      bd = new BigDecimal(k*dv).setScale(2,BigDecimal.ROUND_UP);
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2-k*(0.15*dv)*(this.getHeight()-200)*divV/15,3,3));
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2+k*(0.15*dv)*(this.getHeight()-200)*divV/15,3,3));
      if(k!=0){
      g.drawString("-"+bd,(float)(xi/mx*divT+15),(float)(this.getHeight()/2-k*(0.15*dv)*(this.getHeight()-200)*divV/15));
      g.drawString(""+bd,(float)(xi/mx*divT+15),(float)(this.getHeight()/2+k*(0.15*dv)*(this.getHeight()-200)*divV/15));
       }
      }    
      else if(form.Ret_opc()=="Detalle")    
      for(int k=0;k<80;k++){
      bd = new BigDecimal(k*dv1).setScale(2,BigDecimal.ROUND_UP);
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2-k*(0.15*dv1)*(this.getHeight()-200)*divV/15,3,3));
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2+k*(0.15*dv1)*(this.getHeight()-200)*divV/15,3,3));
      if(k!=0){
      g.drawString("-"+bd,(float)(xi/mx*divT+15),(float)(this.getHeight()/2-k*(0.15*dv1)*(this.getHeight()-200)*divV/15));
      g.drawString(""+bd,(float)(xi/mx*divT+15),(float)(this.getHeight()/2+k*(0.15*dv1)*(this.getHeight()-200)*divV/15));
       }
      }        

     int u=0;
      if(form.Ret_opc()=="Aproximación"){
       g.setColor(Color.GREEN);  
       g.drawString("CA[1] - Cuad: "+Cd,this.getWidth()-100,20);            
       for(int x=0;x<apx1.length;x++){
             g.setColor(Color.GREEN);
             g.draw(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+(apx1[x])*(this.getHeight()-200)*divV/15,2,2));
             
           for(int k=2;k<apx1.length;k+=4){
            if((x+1)==k){
             u++;       
             g.setColor(Color.WHITE);
             g.fill(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2,3,3));  
             bg1 = new BigDecimal(u*form.frame.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
             g.drawString(""+bg1,(float)((x+xi/mx)*divT),(float)(this.getHeight()/2+15.5f));
             break;
            }
            }
             
             if(x!=0){
             g.setColor(Color.YELLOW);    
             g.draw(new Line2D.Double((x+xi/mx)*divT,(this.getHeight()/2+(apx1[x])*(this.getHeight()-200)*divV/15),
            ((x+xi/mx)-1)*divT,(this.getHeight()/2+(apx1[x-1])*(this.getHeight()-200)*divV/15)));   
             }
          }
        
      }else if(form.Ret_opc()=="Detalle"){
         u=0;
        g.setColor(Color.GREEN);  
        g.setFont(f1);
        g.drawString("CD[1] - Cuad: "+Cd,this.getWidth()-100,20);   
        for(int x=0;x<det1.length;x++){
             g.setColor(Color.YELLOW);
             g.draw(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+(det1[x])*(this.getHeight()-200)*divV/15,2,2));
             
             for(int k=2;k<det1.length;k+=4){
            if((x+1)==k){
             u++;       
             g.setColor(Color.WHITE);
             g.fill(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2,3,3));  
             bg1 = new BigDecimal(u*form.frame.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
             g.drawString(""+bg1,(float)((x+xi/mx)*divT),(float)(this.getHeight()/2+15.5f));
             break;
            }
            }
             
             if(x!=0){
             g.setColor(Color.GREEN);    
             g.draw(new Line2D.Double((x+xi/mx)*divT,(this.getHeight()/2+(det1[x])*(this.getHeight()-200)*divV/15),
            ((x+xi/mx)-1)*divT,(this.getHeight()/2+(det1[x-1])*(this.getHeight()-200)*divV/15)));   
             }
          }
        
      }
        
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

    public void mouseClicked(MouseEvent evt) {
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
