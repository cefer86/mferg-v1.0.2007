
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
public class GrafComp1 extends javax.swing.JPanel implements MouseListener, MouseMotionListener{
    
    private mferg form;
    private double divV, divT,maximo,minimo,maximo1,minimo1,dv1,dv2;
    double SV2,ST2;
    double  datxy0[]= null;
    double  datxy1[]=null;
    double  sig[]=null;
    int     offsetX, offsetY;   
    boolean dragging; 
    int     x0;
    private BigDecimal bg1,bg0;
    int y0;
    double  mx=12.231;
    double  my=23.131;
    Font    f1;
    
    
    public GrafComp1() {
        initComponents();
    }
    public GrafComp1(mferg fr, double[] der, double[] izq) {
       this.form = fr;
       addMouseListener(this);
       addMouseMotionListener(this);
       datxy0 = der;
       datxy1 = izq;
       sig = new double[datxy0.length];
       this.x0=0;
       this.y0=this.getHeight()/2;
       offsetX=x0; 
       offsetY=y0;  
       f1= new Font("Fuente1",Font.BOLD,10);
       for(int i=0;i<datxy0.length;i++){
           if(maximo >=Math.abs(datxy0[i])) maximo = maximo;
           else maximo = Math.abs(datxy0[i]);
           if(minimo <=Math.abs(datxy0[i])) minimo = minimo;
           else minimo = Math.abs(datxy0[i]);
       }
       for(int i=0;i<datxy1.length;i++){
           if(maximo1 >=Math.abs(datxy1[i])) maximo1 = maximo1;
           else maximo1 = Math.abs(datxy1[i]);
           if(minimo1 <=Math.abs(datxy1[i])) minimo1 = minimo1;
           else minimo1 = Math.abs(datxy1[i]);
       }
       dv1=maximo-minimo;
       dv2=maximo1-minimo1;
    }
    
    protected void paintComponent(Graphics g1) {
        
       super.paintComponent(g1);
       Graficar(g1,x0,y0);
         
    }
    
    public void Graficar(Graphics g1,int xi,int yi){
        
       Graphics2D g = (Graphics2D)g1;
       SV2=form.RetScaVolt2();
       ST2=form.RetScaTiem2();
       
       // Reconocer Puntos Positivos y Negativos
       for(int i=0; i<datxy0.length; i++){
           if(datxy0[i]==y0){
               sig[i]=0;
           }else if(datxy0[i]<y0){
              sig[i]=1; 
           }else if(datxy0[i]>y0){
              sig[i]=2; 
           }
       }
        
       g.translate( this.getInsets().left,this.getInsets().top );
       g.setColor(Color.BLACK);
       g.fillRect(0,0,this.getWidth(),this.getHeight());
       g.setColor(new Color(0.220f,0.220f,0.220f));
       
       
      // Divisiones de Dominio y Tiempo en la Cuadrícula
       divT=(this.getWidth()/(50-ST2+1));
       divV=(this.getHeight()/(50-SV2+1));
            
       //Graficación de la Cuadrícula
       
       for(int i=1;i<=this.getWidth();i++){
           g.draw(new Line2D.Double(i*divT,0,i*divT,this.getHeight()));
       }
       for(int i=1;i<=this.getHeight();i++){
           g.draw(new Line2D.Double(0,i*divV,this.getWidth(),i*divV));
       }
       
       g.setColor(Color.YELLOW);
       g.setFont(f1);
       g.drawString("I-N",this.getWidth()-25,15);
       
       if(form.RetOjo()=="Derecho"){
           g.drawString("Ojo Derecho -",this.getWidth()-100,15);
       }else{
           g.drawString("Ojo Izquierdo -",this.getWidth()-100,15); 
       }
       
       g.setColor(Color.YELLOW);
       g.drawLine(12,this.getHeight()-10,28,this.getHeight()-10);
       g.drawLine(12,this.getHeight()-25,12,this.getHeight()-10);
       g.drawString("ms",29.5f,this.getHeight()-9.2f);
       g.drawString("mV",6.3f,this.getHeight()-26);
       
       //Graficación de los ejes
      g.setColor(Color.WHITE); 
      g.draw(new Line2D.Double(3+xi/mx*divT,0,3+xi/mx*divT,this.getHeight()));
      g.draw(new Line2D.Double(0,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15,this.getWidth(),this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15)); 
      if(form.RetOjo()=="Derecho")
      for(int k=0;k<80;k++){
      bg0 = new BigDecimal(k*dv1).setScale(2,BigDecimal.ROUND_UP);
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15-k*(0.15*dv1)*(this.getHeight()-200)*divV/15,3,3));
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+k*(0.15*dv1)*(this.getHeight()-200)*divV/15,3,3));
      if(k!=0){
      g.drawString(""+bg0,(float)(xi/mx*divT+15),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15-k*(0.15*dv1)*(this.getHeight()-200)*divV/15));
      g.drawString("-"+bg0,(float)(xi/mx*divT+15),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+k*(0.15*dv1)*(this.getHeight()-200)*divV/15));
       }
      }
      else if(form.RetOjo()=="Izquierdo")
      for(int k=0;k<80;k++){
      bg0 = new BigDecimal(k*dv2).setScale(2,BigDecimal.ROUND_UP);    
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15-k*(0.15*dv2)*(this.getHeight()-200)*divV/15,3,3));
      g.fill(new Rectangle2D.Double(3+xi/mx*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+k*(0.15*dv2)*(this.getHeight()-200)*divV/15,3,3));
      if(k!=0){
      g.drawString(""+bg0,(float)(xi/mx*divT+15),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15-k*(0.15*dv2)*(this.getHeight()-200)*divV/15));
      g.drawString("-"+bg0,(float)(xi/mx*divT+15),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+k*(0.15*dv2)*(this.getHeight()-200)*divV/15));
       }
      } 
     
    int u=0;   
    if(form.RetOjo()=="Derecho"){ 
           
     for(int x=0;x<datxy0.length;x++){
         g.setColor(Color.YELLOW);    
         g.draw(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+(-0.15*datxy0[x]+yi/my)*(this.getHeight()-200)*divV/15,2,2));
         if(!form.Main.importD){
         if(x==u*form.Main.kernels.k11.correlacion.RetIndice_time()){ 
         g.setColor(Color.WHITE);
         g.fill(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15,3,3));  
         bg1 = new BigDecimal(u*form.Main.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
         g.drawString(""+bg1,(float)((x+xi/mx)*divT),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+12));
         u++;
          }
         }else{
         if(x==u*form.Main.indice_timeImD){ 
         g.setColor(Color.WHITE);
         g.fill(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15,3,3));  
         bg1 = new BigDecimal(u*form.Main.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
         g.drawString(""+bg1,(float)((x+xi/mx)*divT),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+12));
         u++;
          }
      }
         if(x!=0){
         g.setColor(Color.GREEN);
         g.draw(new Line2D.Double((x+xi/mx)*divT,(this.getHeight()/2+(-0.15*datxy0[x]+yi/my)*(this.getHeight()-200)*divV/15),
            (x+xi/mx-1)*divT,(this.getHeight()/2+(-0.15*datxy0[x-1]+yi/my)*(this.getHeight()-200)*divV/15)));   
         }
       }
      }else{
        u=0;
       for(int x=0;x<datxy1.length;x++){
         g.setColor(Color.YELLOW);          
         g.draw(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+(-0.15*datxy1[x]+yi/my)*(this.getHeight()-200)*divV/15,2,2));
         
         if(!form.Main.importD){
         if(x==u*form.Main.kernels.k11.correlacion.RetIndice_time()){ 
         g.setColor(Color.WHITE);
         g.fill(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15,3,3));  
         bg1 = new BigDecimal(u*form.Main.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
         g.drawString(""+bg1,(float)((x+xi/mx)*divT),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+12));
         u++;
          }
         }else{
         if(x==u*form.Main.indice_timeImD){ 
         g.setColor(Color.WHITE);
         g.fill(new Rectangle2D.Double((x+xi/mx)*divT,this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15,3,3));  
         bg1 = new BigDecimal(u*form.Main.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
         g.drawString(""+bg1,(float)((x+xi/mx)*divT),(float)(this.getHeight()/2+yi/my*(this.getHeight()-200)*divV/15+12));
         u++;
          }
      }
         if(x!=0){
         g.setColor(Color.GREEN);    
         g.draw(new Line2D.Double((x+xi/mx)*divT,(this.getHeight()/2+(-0.15*datxy1[x]+yi/my)*(this.getHeight()-200)*divV/15),
        (x+xi/mx-1)*divT,(this.getHeight()/2+(-0.15*datxy1[x-1]+yi/my)*(this.getHeight()-200)*divV/15)));   
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
    }// </editor-fold>//GEN-END:initComponents
    public double[] Ret_IN_D(){
        return datxy0;
    }
    public double[] Ret_IN_I(){
        return datxy1;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseClicked(MouseEvent evt) {
    }

    public void mousePressed(MouseEvent evt) {
        if (dragging)  
            return;
         int x = evt.getX();  // clic inicial
         int y = evt.getY();
         offsetX = x - x0;  
         offsetY = y - y0;
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
          
          if (dragging == false)  
            return;

          int x = evt.getX();   // posición del mouse
          int y = evt.getY();
          x0 = x - offsetX;     // mover origen
          y0 = y - offsetY;    
                               
          repaint();

    }

    public void mouseMoved(MouseEvent e) {
    }
    
}
