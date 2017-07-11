
package erg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * Autor: Cesar Peña
 *
 */

public class GrafAnillo extends javax.swing.JPanel {
    
   private Test0 form;
   private double divT,divV,ScalmV,Scalms;
   private double A1[] = null, A2[]=null, A3[]=null, A4[]=null, A5[]=null, A6[]=null;
   Font    f1;
   
    public GrafAnillo() {
        initComponents();
    }
    public GrafAnillo(Test0 fr) {
        this.form = fr;
        this.ScalmV=0.0;
        this.Scalms=0.0;
        f1= new Font("Fuente1",Font.BOLD,10);
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
       
       ScalmV = form.RetScalmV();
       Scalms = form.RetScalms();
        
       g.translate( this.getInsets().left,this.getInsets().top );
       g.setColor(Color.BLACK);
       g.fillRect(0,0,this.getWidth(),this.getHeight());
       g.setColor(new Color(0.220f,0.220f,0.220f));
       
       // Divisiones de Dominio y Tiempo en la Cuadrícula
       divT=(this.getWidth()/(50-Scalms+1));
       divV=(this.getHeight()/(50-ScalmV+1));
       
       //Graficación de la Cuadrícula
       for(int i=1;i<=this.getWidth();i++){
           g.draw(new Line2D.Double(i*divT,0,i*divT,this.getHeight()));
       }
       for(int i=1;i<=this.getHeight();i++){
           g.draw(new Line2D.Double(0,i*divV,this.getWidth(),i*divV));
       }
       
       g.setColor(Color.WHITE);
       g.setFont(f1);
       g.drawLine(12,this.getHeight()-10,28,this.getHeight()-10);
       g.drawLine(12,this.getHeight()-25,12,this.getHeight()-10);
       g.drawString("ms",29.5f,this.getHeight()-9.2f);
       g.drawString("mV",6.3f,this.getHeight()-26);
 
 //Actualiza datos de Anillos
 if(form.RetProsc_listo_d() || form.RetProsc_listo_i() || form.RetProsc_listo_dCONF() || form.RetProsc_listo_iCONF()) {     
 if(form.RetProsc_listo_d() || form.RetProsc_listo_i() ){
 if((form.RetProsc_listo_i() && form.Ret_ojoEst()=="Izquierdo")){   
        this.A1 = form.ddkk.RetAnillo_A1();
        this.A2 = form.ddkk.RetAnillo_A2();
        this.A3 = form.ddkk.RetAnillo_A3();
        this.A4 = form.ddkk.RetAnillo_A4();
        this.A5 = form.ddkk.RetAnillo_A5();
        this.A6 = form.ddkk.RetAnillo_A6();
 }else if((form.RetProsc_listo_d() && form.Ret_ojoEst()=="Derecho")){
        this.A1 = form.ddkk2.RetAnillo_A1();
        this.A2 = form.ddkk2.RetAnillo_A2();
        this.A3 = form.ddkk2.RetAnillo_A3();
        this.A4 = form.ddkk2.RetAnillo_A4();
        this.A5 = form.ddkk2.RetAnillo_A5();
        this.A6 = form.ddkk2.RetAnillo_A6();
 }}
 
 if(form.RetProsc_listo_dCONF() || form.RetProsc_listo_iCONF() ){
 if((form.RetProsc_listo_iCONF() && form.RetOjo_conf()=="Izquierdo")){   
        this.A1 = form.ddkk1.RetAnillo_A1();
        this.A2 = form.ddkk1.RetAnillo_A2();
        this.A3 = form.ddkk1.RetAnillo_A3();
        this.A4 = form.ddkk1.RetAnillo_A4();
        this.A5 = form.ddkk1.RetAnillo_A5();
        this.A6 = form.ddkk1.RetAnillo_A6();
 }else if((form.RetProsc_listo_dCONF() && form.RetOjo_conf()=="Derecho")){
        this.A1 = form.ddkk21.RetAnillo_A1();
        this.A2 = form.ddkk21.RetAnillo_A2();
        this.A3 = form.ddkk21.RetAnillo_A3();
        this.A4 = form.ddkk21.RetAnillo_A4();
        this.A5 = form.ddkk21.RetAnillo_A5();
        this.A6 = form.ddkk21.RetAnillo_A6();
 }}
    
    for(int x=0;x<A1.length;x++){
     g.setColor(Color.RED);
     g.draw(new Rectangle2D.Double((x*form.RetBaseTiempo_delta_r())*divT,this.getHeight()/7+(-A1[x]*1.81)*divV/15,2,2));
     g.setColor(Color.WHITE);
     g.fill(new Rectangle2D.Double((3*x*form.RetBaseTiempo_delta_r())*divT,this.getHeight()/7,2,2));  
     if(x!=0){
     g.setColor(Color.RED);    
     g.draw(new Line2D.Double((x*form.RetBaseTiempo_delta_r())*divT,(this.getHeight()/7+(-A1[x]*1.81)*divV/15),
            (x-1)*form.RetBaseTiempo_delta_r()*divT,(this.getHeight()/7+(-A1[x-1]*1.81)*divV/15)));   
             }
       }
    for(int x=0;x<A2.length;x++){
     g.setColor(Color.BLUE);
     g.draw(new Rectangle2D.Double((x*form.RetBaseTiempo_delta_r())*divT,2*this.getHeight()/7+(-A2[x]*0.15)*divV/15,2,2));
     g.setColor(Color.WHITE);
     g.fill(new Rectangle2D.Double((3*x*form.RetBaseTiempo_delta_r())*divT,2*this.getHeight()/7,2,2));  
     if(x!=0){
     g.setColor(Color.BLUE);    
     g.draw(new Line2D.Double((x*form.RetBaseTiempo_delta_r())*divT,(2*this.getHeight()/7+(-A2[x]*0.15)*divV/15),
            (x-1)*form.RetBaseTiempo_delta_r()*divT,(2*this.getHeight()/7+(-A2[x-1]*0.15)*divV/15)));   
             }
       }
   for(int x=0;x<A3.length;x++){
     g.setColor(Color.PINK);
     g.draw(new Rectangle2D.Double((x*form.RetBaseTiempo_delta_r())*divT,3*this.getHeight()/7+(-A3[x]*0.15)*divV/15,2,2));
     g.setColor(Color.WHITE);
     g.fill(new Rectangle2D.Double((3*x*form.RetBaseTiempo_delta_r())*divT,3*this.getHeight()/7,2,2));  
     if(x!=0){
     g.setColor(Color.PINK);    
     g.draw(new Line2D.Double((x*form.RetBaseTiempo_delta_r())*divT,(3*this.getHeight()/7+(-A3[x]*0.15)*divV/15),
            (x-1)*form.RetBaseTiempo_delta_r()*divT,(3*this.getHeight()/7+(-A3[x-1]*0.15)*divV/15)));   
             }
       }
     for(int x=0;x<A4.length;x++){
     g.setColor(Color.GREEN);
     g.draw(new Rectangle2D.Double((x*form.RetBaseTiempo_delta_r())*divT,4*this.getHeight()/7+(-A4[x]*0.15)*divV/15,2,2));
     g.setColor(Color.WHITE);
     g.fill(new Rectangle2D.Double((3*x*form.RetBaseTiempo_delta_r())*divT,4*this.getHeight()/7,2,2));  
     if(x!=0){
     g.setColor(Color.GREEN);    
     g.draw(new Line2D.Double((x*form.RetBaseTiempo_delta_r())*divT,(4*this.getHeight()/7+(-A4[x]*0.15)*divV/15),
            (x-1)*form.RetBaseTiempo_delta_r()*divT,(4*this.getHeight()/7+(-A4[x-1]*0.15)*divV/15)));   
             }
       }
    for(int x=0;x<A5.length;x++){
     g.setColor(Color.MAGENTA);
     g.draw(new Rectangle2D.Double((x*form.RetBaseTiempo_delta_r())*divT,5*this.getHeight()/7+(-A5[x]*0.15)*divV/15,2,2));
     g.setColor(Color.WHITE);
     g.fill(new Rectangle2D.Double((3*x*form.RetBaseTiempo_delta_r())*divT,5*this.getHeight()/7,2,2));  
     if(x!=0){
     g.setColor(Color.MAGENTA);    
     g.draw(new Line2D.Double((x*form.RetBaseTiempo_delta_r())*divT,(5*this.getHeight()/7+(-A5[x]*0.15)*divV/15),
            (x-1)*form.RetBaseTiempo_delta_r()*divT,(5*this.getHeight()/7+(-A5[x-1]*0.15)*divV/15)));   
             }
       }
    for(int x=0;x<A6.length;x++){
     g.setColor(Color.ORANGE);
     g.draw(new Rectangle2D.Double((x*form.RetBaseTiempo_delta_r())*divT,6*this.getHeight()/7+(-A6[x]*0.15)*divV/15,2,2));
     g.setColor(Color.WHITE);
     g.fill(new Rectangle2D.Double((3*x*form.RetBaseTiempo_delta_r())*divT,6*this.getHeight()/7,2,2));  
     if(x!=0){
     g.setColor(Color.ORANGE);    
     g.draw(new Line2D.Double((x*form.RetBaseTiempo_delta_r())*divT,(6*this.getHeight()/7+(-A6[x]*0.15)*divV/15),
            (x-1)*form.RetBaseTiempo_delta_r()*divT,(6*this.getHeight()/7+(-A6[x-1]*0.15)*divV/15)));   
             }
           }
       }
     }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
