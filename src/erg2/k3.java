
package erg2;

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
 *
 */
public class k3 extends javax.swing.JPanel implements MouseListener, MouseMotionListener {
    
    private Kernels form1;
    private Test0 form;
    private double divT,divV,ScalmV,Scalms,maximo,minimo,dv;
    private BigDecimal bd,bg1;
    private int N_pat,ds;
    Font f1,f2;
    int     offsetX;
    boolean dragging; 
    int     x0;
    double  mx=12.231;
    public CorrCruz correlacion;
    private double Kernel3corr[]=null;
    private double Kernel3[]=null;
    
    public k3() {
        initComponents();
    }
   
    public k3(Kernels fr, Test0 fr1){
        addMouseListener(this);
        addMouseMotionListener(this);
        this.form1 = fr;
        this.form = fr1;
        this.N_pat = form.M;
        this.ScalmV =0.0;
        this.Scalms =0.0;
        if(!fr1.importD){
        this.Kernel3 = form.RetK3();
        this.correlacion = new CorrCruz(Kernel3,Kernel3.length,form.s_entrada);
        this.Kernel3corr = correlacion.Corr2();
         this.ds = (int)this.Kernel3corr.length/103;
        }else if(fr1.importD){
         this.Kernel3corr = fr1.v_k3;
         this.Kernel3 = fr1.k3;
         this.ds = (int)this.Kernel3corr.length/103;
        }
        f1= new Font("Fuente1",Font.BOLD,10);
        f2= new Font("Fuente1",Font.BOLD,11);
        offsetX=x0; 
        this.x0=0;
        for(int i=0;i<Kernel3corr.length;i++){
           if(maximo >=Math.abs(Kernel3corr[i])) maximo = maximo;
           else maximo = Math.abs(Kernel3corr[i]);
           if(minimo <=Math.abs(Kernel3corr[i])) minimo = minimo;
           else minimo = Math.abs(Kernel3corr[i]);
       }
        dv=maximo-minimo;
    }
    
    public void paintComponent(Graphics g1) {
        
       super.paintComponent(g1);
       Graficar(g1,x0);
       
        }
    
    public void Graficar(Graphics g1, int xi){
       
       Graphics2D g = (Graphics2D)g1;
       double dx=0.1;
       ScalmV = form1.RetmVk3();
       Scalms = form1.RetmSk3();
       
       g.translate( this.getInsets().left,this.getInsets().top );
       g.setColor(Color.BLACK);
       g.fillRect(0,0,this.getWidth(),this.getHeight());
       g.setColor(new Color(0.220f,0.220f,0.220f));
       g.setFont(f1);
       // Divisiones de Dominio y Tiempo en la Cuadrícula
       
       divT=(this.getWidth()/(50-Scalms+1));
       divV=(this.getHeight()/(50-ScalmV+1));
       
       //Graficación de la Cuadrícula
       
       for(int i=1;i<=this.getWidth();i++){g.draw(new Line2D.Double(i*divT*form.RetBaseTiempo_delta_r(),0,i*divT*form.RetBaseTiempo_delta_r(),this.getHeight()));}
       for(int i=1;i<=this.getHeight();i++){g.draw(new Line2D.Double(0,i*divV,this.getWidth(),i*divV));}
       
       //Graficación de los ejes
      g.setColor(Color.WHITE); 
      g.draw(new Line2D.Double(4+xi/mx*divT,0,4+xi/mx*divT,this.getHeight()));
      g.draw(new Line2D.Double(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2)); 
      for(int k=0;k<15;k++){
      bd = new BigDecimal(k*dv).setScale(2,BigDecimal.ROUND_UP);    
      g.fill(new Rectangle2D.Double(4+xi/mx*divT,this.getHeight()/2-k*(dv)*(this.getHeight()-200)*divV/15,3,3));
      g.fill(new Rectangle2D.Double(4+xi/mx*divT,this.getHeight()/2+k*(dv)*(this.getHeight()-200)*divV/15,3,3));
      if(k!=0 && form1.VerValores() && form1.RetOpMot()!="Ventana"){
      g.drawString(""+bd,(float)(8+xi/mx*divT),(float)(this.getHeight()/2-k*(dv)*(this.getHeight()-200)*divV/15));
      g.drawString("-"+bd,(float)(8+xi/mx*divT),(float)(this.getHeight()/2+k*(dv)*(this.getHeight()-200)*divV/15));
       }
      }
      
        for(int w=0;w<103;w++){
          if(form1.RetHex().equals("h"+w)){
              if(form1.RetOpMot()=="Kernels"){
                  
              // Impresion de los Kernels (CORRxy)
              int lo,ls;
              int d=1;
              if(w==102) lo = (w+1)*ds-1;
              else lo = (w+1)*ds;
              if(w==102) ls = (w+1)*4*N_pat-1;
              else ls = (w+1)*4*N_pat;
              
              for(int x=w*ds;x<lo;x++){
                g.setColor(Color.YELLOW);
                g.draw(new Rectangle2D.Double((dx+xi/mx)*divT,this.getHeight()/2+(Kernel3corr[x])*(this.getHeight()-200)*divV/15,1,1));
                if(x!=0){
                g.setColor(Color.GREEN);
                g.draw(new Line2D.Double((dx+xi/mx)*divT,(this.getHeight()/2+(Kernel3corr[x])*(this.getHeight()-200)*divV/15),
                ((dx+xi/mx)-0.1*form.RetBaseTiempo_delta_r())*divT,(this.getHeight()/2+(Kernel3corr[x-1])*(this.getHeight()-200)*divV/15)));   
              if(!form.importD){  
                if(form1.RetOpMot()=="Kernels" && form1.VerValores()&& x==d*correlacion.RetIndice_time()+w*ds){
                    g.setColor(Color.WHITE);
                    g.fill(new Rectangle2D.Double((dx+xi/mx)*divT,this.getHeight()/2,3,3));
                    bg1 = new BigDecimal(d*form.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
                    g.drawString(""+bg1,(float)((dx+xi/mx)*divT),(float)this.getHeight()/2+15.5f);
                    d++;
                  }
              }else{
                 if(form1.RetOpMot()=="Kernels" && form1.VerValores()&& x==d*form.indice_timeImD+w*ds){
                    g.setColor(Color.WHITE);
                    g.fill(new Rectangle2D.Double((dx+xi/mx)*divT,this.getHeight()/2,3,3));
                    bg1 = new BigDecimal(d*form.RetBaseTiempo()).setScale(2,BigDecimal.ROUND_UP);
                    g.drawString(""+bg1,(float)((dx+xi/mx)*divT),(float)this.getHeight()/2+15.5f);
                    d++;
                  }   
              } 
                }
                 dx=dx+0.1*form.RetBaseTiempo_delta_r();                     
               }              
              
              }else if(form1.RetOpMot()=="Ventana" && Kernel3!=null){
              dx=0.1;
              int d=1;
              g.setColor(Color.RED);
              g.draw(new Line2D.Double(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2));
              for(int x=w*ds;x<(w+1)*ds;x++){
                  if(!form.importD){ 
                if(x!=0){
                    if(x==d*correlacion.RetIndice_time()+w*ds){
                       if(Kernel3[x*4/correlacion.RetIndice_time()]==1)
                       g.draw(new Rectangle2D.Double((dx+xi/mx)*divT,this.getHeight()/2-9,4,9));   
                       else if(Kernel3[x*4/correlacion.RetIndice_time()]==-1)
                       g.draw(new Rectangle2D.Double((dx+xi/mx)*divT,this.getHeight()/2,4,9)); 
                       d++;
                    }
                     dx=dx+0.1*form.RetBaseTiempo_delta_r();                      
                }
                }else{
                  if(x!=0){
                    if(x==d*form.indice_timeImD){
                       if(Kernel3[x*4/form.indice_timeImD]==1)
                       g.draw(new Rectangle2D.Double((dx+xi/mx)*divT,this.getHeight()/2-9,4,9));   
                       else if(Kernel3[x*4/form.indice_timeImD]==-1)
                       g.draw(new Rectangle2D.Double((dx+xi/mx)*divT,this.getHeight()/2,4,9)); 
                       d++;
                    }
                     dx=dx+0.1*form.RetBaseTiempo_delta_r();      
                }  
                }
               }
              }
              g.setColor(Color.GREEN);
              g.setFont(f2);
              g.drawString("2S - Kernel Ord. 2: Hex "+w,this.getWidth()-150.5f,this.getHeight()-9.2f);
          } 
      }
       
       g.setColor(Color.YELLOW);
       g.setFont(f1);
      g.drawLine(this.getWidth()-30,30,this.getWidth()-40,30);
       g.drawLine(this.getWidth()-40,30,this.getWidth()-40,20);
       g.drawString("ms",this.getWidth()-27.56f,32);
       g.drawString("mV",this.getWidth()-45.38f,19);
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

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent evt) {
         if (dragging)  
            return;
         int x = evt.getX();  // clic inicial
         offsetX = x - x0;  
         dragging = true; 
    }

    public void mouseReleased(MouseEvent evt) {
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
              x0 = x - offsetX;     // mover origen
              repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }

    public double[] RetK3wvf(){
        return Kernel3corr;
    }
    public double[] RetK3_binaryCan(){
        return Kernel3;
    }
}
