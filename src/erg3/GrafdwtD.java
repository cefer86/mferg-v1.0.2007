
package erg3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.math.BigDecimal;

/**
 *
 * Autor: Cesar Peña
 */
public class GrafdwtD extends javax.swing.JPanel {
    
    private GrafWave_DWT form;
    private mferg form2;
    private Integer[][] rr=null;
    private int MAX, L,wmax,wmin,wmed;
    private double divN,divT;
    private BigDecimal max,min,med;
    private Font f3= new Font("Fuente3",Font.BOLD,10);
    
    public GrafdwtD(GrafWave_DWT form, Integer[][] cof, int NMAX, int L, mferg fr) {
        this.form = form;
        this.rr = cof;
        this.MAX =NMAX;
        this.L=L;
        this.form2 = fr;
        this.max = new BigDecimal(form2.r1.cc1.RetMaximo()).setScale(3,BigDecimal.ROUND_UP);
        this.min = new BigDecimal(form2.r1.cc1.RetMinimo()).setScale(3,BigDecimal.ROUND_UP);
        this.med = new BigDecimal(form2.r1.cc1.RetMedia()).setScale(3,BigDecimal.ROUND_UP);
    }
    public GrafdwtD() {
        initComponents();
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
    
    public void paintComponent(Graphics g1) {
       super.paintComponent(g1);
       Graficar(g1);
        }

    public void Graficar(Graphics g1){
        
       Graphics2D g = (Graphics2D)g1;
       g.translate( this.getInsets().left,this.getInsets().top );
       g.setColor(Color.BLACK);
       g.fillRect(0,0,this.getWidth(),this.getHeight());
       
       divN = 0.7*this.getHeight()/(rr.length-1);
       divT = 0.7*this.getWidth()/L;

       Integer[] cod = new Integer[MAX+1];
       for(int k=1;k<cod.length;k++) cod[k]=k;
       
       for(int i=1;i<rr.length;i++){
       for(int j=1;j<rr[i].length;j++){
           
       for(int n=1;n<cod.length;n++){
           if(rr[i][j]==cod[n]){ 
           g.setColor(new Color(0.015384615384615384615384615384615f*n,0.0087519379844961240310077519379845f*n,0.0039840637450199203187250996015936f*n));
           if(i==form2.r1.cc1.Ret_imx() && j==form2.r1.cc1.Ret_jmx())wmax=n;
           if(i==form2.r1.cc1.Ret_imn() && j==form2.r1.cc1.Ret_jmn() )wmin=n; 
           if(i==form2.r1.cc1.Ret_imed() && j==form2.r1.cc1.Ret_jmed() )wmed=n; 
           break;}
       }      
       if(i==form2.r1.cc1.Ret_imx() && j==form2.r1.cc1.Ret_jmx() && form.RetSMax())g.setColor(Color.RED);
       else if(i==form2.r1.cc1.Ret_imn() && j==form2.r1.cc1.Ret_jmn() && form.RetSMin())g.setColor(new Color(0.36f,0.5f,0.8f)); 
       g.fill(new Rectangle2D.Double((j-1)*divT+50,(i-1)*divN+45,divT,divN));
       g.setColor(Color.WHITE);
       g.fill(new Rectangle2D.Double(43,(i-1)*divN+45+divN/2,3,3));
       g.drawString("2^"+(rr.length-i),20,(int)((i-1)*divN+45+divN/2));
       if(j%(int)(rr[i].length/7)==0){
           g.fill(new Rectangle2D.Double((j-1)*divT+50+divT/2,3*divN+50,3,3));
           g.drawString(""+j,(int)((j-1)*divT+49+divT/2),(int)(3*divN+70));
       }
       
       }
    }
       g.setColor(Color.WHITE); 
       g.draw(new Line2D.Double(45,45,45,3*divN+50));
       g.draw(new Line2D.Double(45,3*divN+50,(rr[1].length-1)*divT+50,3*divN+50));
       g.setColor(Color.GRAY);
       g.draw3DRect(this.getWidth()-150,0,2,this.getHeight(),true);
       g.setColor(Color.LIGHT_GRAY);
       g.fill(new Rectangle2D.Double(this.getWidth()-150,0,150,this.getHeight()));
       g.setColor(Color.BLACK);
       g.setFont(f3);
       g.drawString("ESCALA DE COLORES",this.getWidth()-133,20);
       // Escala de Colores
       for(int k=1;k<cod.length;k++){
          g.setColor(new Color(0.015384615384615384615384615384615f*k,0.0087519379844961240310077519379845f*k,0.0039840637450199203187250996015936f*k)); 
          g.fill(new Rectangle2D.Double(this.getWidth()-120,3*divN+50-(k-1)*5,15,5));
          g.setColor(Color.BLACK);
          g.setFont(f3);
          if(k==wmin)g.drawString("<"+min,this.getWidth()-100,(int)(3*divN+50-(k-1)*5));
          if(k==wmax)g.drawString("<"+max,this.getWidth()-100,(int)(3*divN+50-(k-1)*5)+10);
          if(k==wmed)g.drawString("<"+med,this.getWidth()-100,(int)(3*divN+50-(k-1)*5)+10);
       }
 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
