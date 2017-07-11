
package erg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import javax.swing.JOptionPane;

/**
 *
 * Autor: Cesar Peña
 *
 */

public class anaDatos extends javax.swing.JPanel {
    
    private Test0 form;
    double z ;
    double z0 =0, z1 =0, z2 = 0,z3 = 0, z4= 0, z5= 0;
    int xi,yi,xs,ys;
    double xp;
    Font    f1;
    private double ker1[]= null;
    private Image imagen, imagen2;
    private int Hexg=0;
    
    public anaDatos() {
         initComponents();
    }
    public anaDatos(Test0 fr) {
        this.form = fr;
        f1= new Font("Fuente1",Font.ROMAN_BASELINE,10);
        imagen = Toolkit.getDefaultToolkit().getImage( 
             "C:/Archivos de Programa/netbeans-5.5beta2/Proyects/ERG4/src/Datos/est4.jpg" 
//             "C:/Proyects/ERG4/src/Datos/est4.jpg"
//                "C:/dist/est4.jpg"
                );
        imagen2 = Toolkit.getDefaultToolkit().getImage( 
             "C:/Archivos de Programa/netbeans-5.5beta2/Proyects/ERG4/src/Datos/cv.jpg" 
//             "C:/Proyects/ERG4/src/Datos/cv.jpg" 
//                "C:/dist/cv.jpg"
                );    

    }
    
    public void paintComponent(Graphics g1) {  
       super.paintComponent(g1);
       Graficar(g1);
        }

public void Graficar(Graphics g1){

 Graphics2D g = (Graphics2D)g1;
 
  if (form.RetOpcion()=="wvform" || form.RetOpcion()=="Datos_resp" || form.RetOpcion()=="Mapa_Reg"){ 
    
    if (form.RetOpcion()=="wvform" || form.RetOpcion()=="Datos_resp"){
            this.z = 25;
            this.xi= -20+ this.getWidth()/2;
            this.yi= -10+ this.getHeight()/2;
            g.setColor(Color.WHITE);
            g.fill(new Rectangle.Double(0,0,this.getWidth(),this.getHeight()));
            g.setColor(Color.BLACK);
            g.setFont(f1);
            if(form.importD){
            if(form.Ret_ojoEst()=="Derecho" && form.RetProsc_listo_d() || form.RetOjo_conf()=="Derecho" && form.RetProsc_listo_dCONF())g.drawString("OJO DERECHO",this.getWidth()/2-20,25);
            else if(form.Ret_ojoEst()=="Izquierdo" && form.RetProsc_listo_i() || form.RetOjo_conf()=="Izquierdo" && form.RetProsc_listo_iCONF())g.drawString("OJO IZQUIERDO",this.getWidth()/2-20,25);
            else g.drawString("NO HAY OJO EVALUADO",this.getWidth()/2-40,25);
            }else{
            if(form.Ret_ojoEst()=="Derecho" && form.RetProsc_listo_d() && !form.estimulado)g.drawString("OJO DERECHO",this.getWidth()/2-20,25);
            else if(form.Ret_ojoEst()=="Izquierdo" && form.RetProsc_listo_i() && !form.estimulado)g.drawString("OJO IZQUIERDO",this.getWidth()/2-20,25);
            else g.drawString("NO HAY OJO EVALUADO",this.getWidth()/2-40,25);    
            }
         if(form.RetOpcion()=="Datos_resp"){
           xs = xi-240;
           ys = yi+200;
           int ejex[] = {xs,xs,xs+(int)(0.86*z),xs+(int)(z*0.86*2),xs+(int)(z*0.86*2),xs+(int)(0.86*z)};
           int ejey[] = {ys,ys+(int)(z),ys+(int)(z+z*0.5),ys+(int)(z),ys,ys-(int)(z*0.5)}; 
           g.setColor(Color.RED); 
           g.drawPolygon(ejex,ejey,6);
           g.drawString("ms",50.5f,this.getHeight()-40.2f);
           g.drawString("mV",50.3f,this.getHeight()-52);
        }else if(form.RetOpcion()=="wvform"){
           g.drawLine(30,this.getHeight()-30,45,this.getHeight()-30);
           g.drawLine(30,this.getHeight()-45,30,this.getHeight()-30);
           g.drawString("ms",50.5f,this.getHeight()-25.2f);
           g.drawString("mV",20.3f,this.getHeight()-50);
        }
            
    }else if(form.RetOpcion()=="Mapa_Reg"){
             this.z = 12;
             this.xi= this.getWidth()/4;
             this.yi = this.getHeight()/3;
             g.setColor(Color.WHITE);
             g.fill(new Rectangle.Double(0,0,this.getWidth(),this.getHeight()));
             g.setColor(Color.GRAY);
             g.draw3DRect(this.getWidth()-280,0,2,this.getHeight(),true);
             
            g.setColor(Color.BLACK);
            g.draw(new Rectangle.Double(this.getWidth()/10,100+this.getHeight()/2,9,9));
            g.draw(new Rectangle.Double(this.getWidth()/10,113+this.getHeight()/2,9,9));
            g.draw(new Rectangle.Double(this.getWidth()/10,126+this.getHeight()/2,9,9));
            g.draw(new Rectangle.Double(this.getWidth()/10,139+this.getHeight()/2,9,9));
            g.draw(new Rectangle.Double(this.getWidth()/10,152+this.getHeight()/2,9,9));
            g.draw(new Rectangle.Double(this.getWidth()/10,165+this.getHeight()/2,9,9));
            g.setColor(Color.RED);
            g.fill(new Rectangle.Double(this.getWidth()/10,100+this.getHeight()/2,9,9));
            g.setColor(Color.BLUE);
            g.fill(new Rectangle.Double(this.getWidth()/10,113+this.getHeight()/2,9,9));
            g.setColor(Color.PINK);
            g.fill(new Rectangle.Double(this.getWidth()/10,126+this.getHeight()/2,9,9));
            g.setColor(Color.GREEN);
            g.fill(new Rectangle.Double(this.getWidth()/10,139+this.getHeight()/2,9,9));
            g.setColor(Color.MAGENTA);
            g.fill(new Rectangle.Double(this.getWidth()/10,152+this.getHeight()/2,9,9));
            g.setColor(Color.ORANGE);
            g.fill(new Rectangle.Double(this.getWidth()/10,165+this.getHeight()/2,9,9));
            
            g.setFont(f1);
            g.setColor(Color.BLACK);
            g.drawString("A1",this.getWidth()/8,108+this.getHeight()/2);
            g.drawString("A2",this.getWidth()/8,121+this.getHeight()/2);
            g.drawString("A3",this.getWidth()/8,134+this.getHeight()/2);
            g.drawString("A4",this.getWidth()/8,147+this.getHeight()/2);
            g.drawString("A5",this.getWidth()/8,160+this.getHeight()/2);
            g.drawString("A6",this.getWidth()/8,173+this.getHeight()/2);
            if(form.importD){
            if(form.Ret_ojoEst()=="Derecho" && form.RetProsc_listo_d() || form.RetOjo_conf()=="Derecho" && form.RetProsc_listo_dCONF())g.drawString("OJO DERECHO",this.getWidth()/5,38);
            else if(form.Ret_ojoEst()=="Izquierdo" && form.RetProsc_listo_i() || form.RetOjo_conf()=="Izquierdo" && form.RetProsc_listo_iCONF())g.drawString("OJO IZQUIERDO",this.getWidth()/5,38);
            else g.drawString("NO HAY OJO EVALUADO",this.getWidth()/5-20,38);
            }else{
            if(form.Ret_ojoEst()=="Derecho" && form.RetProsc_listo_d() && !form.estimulado)g.drawString("OJO DERECHO",this.getWidth()/5,38);
            else if(form.Ret_ojoEst()=="Izquierdo" && form.RetProsc_listo_i() && !form.estimulado)g.drawString("OJO IZQUIERDO",this.getWidth()/5,38);
            else g.drawString("NO HAY OJO EVALUADO",this.getWidth()/5-20,38);    
            }
            
    }
    //Hexagono 0
    int x0[] = {xi,xi,xi+(int)(0.86*z),xi+(int)(z*0.86*2),xi+(int)(z*0.86*2),xi+(int)(0.86*z)};
    int y0[] = {yi,yi+(int)(z),yi+(int)(z+z*0.5),yi+(int)(z),yi,yi-(int)(z*0.5)};
    int bx[]={x0[5],x0[4],x0[3],x0[2],x0[1],x0[0]};
    int by[]={y0[5],y0[4],y0[3],y0[2],y0[1],y0[0]};
    RetTipo_Graf(g, x0,y0,0);
        if(form.importD){
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform") Ret_Señal(g,xi,yi,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
        }else if(!form.importD){
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform") Ret_Señal(g,xi,yi,Hexg,Hexg+form.kernels.k11.correlacion.RetIndice_time());
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
        }
    // Hexagono 1
    int x1[] ={(int)(bx[5]-0.86*(z+z0)),(int)(bx[5]-0.86*(z+z0)),bx[5],(int)(bx[5]+0.86*(z+z0)),bx[0],bx[5]};
    int y1[]={(int)(by[5]-0.5*(z+z0)),(int)(by[5]-0.5*(z+z0)-(z+z0)),(int)(by[5]-2*(z+z0)),(int)(by[5]-0.5*(z+z0)-(z+z0)),by[0],by[5]};
    //Cambios
    int tx15=x1[0],tx16=x1[1],tx17=x1[2],tx0=x1[3];
    int ty15=y1[0],ty16=y1[1],ty17=y1[2],ty0=y1[3];
       RetTipo_Graf(g, x1,y1,1);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx16,ty16,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 2
    int x2[] ={(int)(bx[5]-0.86*(z+z0)*2),(int)(bx[5]-0.86*(z+z0)*2),tx15,bx[5],bx[4],(int)(bx[5]-0.86*(z+z0))};
    int y2[]={(int)(by[5]+(z+z0)),y0[0],ty15,by[5],by[4],(int)(by[5]+0.5*(z+z0)+(z+z0))};
    //Cambios
    int tx13=x2[0],tx14=x2[1],tx12=x2[5];
    int ty13=y2[0],ty14=y2[1],ty12=y2[5];
        RetTipo_Graf(g, x2,y2,2);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx14,ty14,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 3
    int x3[] ={(int)(bx[4]-0.86*(z+z0)),tx12,bx[4],bx[3],(int)(bx[4]+0.86*(z+z0)),x0[1]};
    int y3[]={(int)(by[4]+0.5*(z+z0)+(z+z0)),ty12,by[4],by[3],(int)(by[4]+0.5*(z+z0)+(z+z0)),(int)(by[4]+2*(z+z0))};
    //Cambios
    int tx11=x3[0],tx9=x3[4],tx10=x3[5];
    int ty11=y3[0],ty9=y3[4],ty10=y3[5];
        RetTipo_Graf(g, x3,y3,3);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx12,ty12,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 4
    int x4[] ={tx9,bx[3],bx[2],(int)(x0[2]+0.86*(z+z0)*2),(int)(x0[2]+0.86*(z+z0)*2),(int)(x0[2]+0.86*(z+z0))};
    int y4[]={ty9,by[3],by[2],y0[2],(int)(y0[2]+(z+z0)),(int)(y0[2]+0.5*(z+z0)+(z+z0))};
    //Cambios
    int tx6=x4[3],tx7=x4[4],tx8=x4[5];
    int ty6=y4[3],ty7=y4[4],ty8=y4[5];
        RetTipo_Graf(g, x4,y4,4);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,bx[3],by[3],Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 5
    int x5[] ={bx[2],bx[1],(int)(bx[2]+0.86*(z+z0)),(int)(bx[2]+0.86*(z+z0)*2),(int)(bx[2]+0.86*(z+z0)*2),tx6};
    int y5[]={by[2],by[1],(int)(by[2]-(z+z0)-0.5*(z+z0)),(int)(by[2]-(z+z0)),y0[3],ty6};
    //Cambios
    int tx3=x5[2],tx4=x5[3],tx5=x5[4];
    int ty3=y5[2],ty4=y5[3],ty5=y5[4];
        RetTipo_Graf(g, x5,y5,5);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,bx[1],by[1],Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 6
    int x6[] ={bx[0],tx0,x0[4],(int)(bx[1]+0.86*(z+z0)),tx3,bx[1]};
    int y6[]={by[0],ty0,(int)(by[1]-(z+z0)*2),(int)(by[1]-0.5*(z+z0)-(z+z0)),ty3,by[1]};
    //Cambios
    int tx1=x6[2],tx2=x6[3];
    int ty1=y6[2],ty2=y6[3];
        RetTipo_Graf(g, x6,y6,6);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx0,ty0,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    
    //----------------Final del Anillo Tetha(j) -----------------------------------------------------
    // Hexagono 7
    int x7[] ={(int)(tx14-0.86*(z+z0+z1)),(int)(tx14-0.86*(z+z0+z1)),tx14,tx16,tx15,tx14};
    int y7[]={(int)(ty14-0.5*(z+z0+z1)),(int)(ty14-0.5*(z+z0+z1)-(z+z0+z1)),(int)(ty14-(z+z0+z1)*2),ty16,ty15,ty14};
    //Cambios
    int ax25=x7[0],ax26=x7[1],ax27=x7[2];
    int ay25=y7[0],ay26=y7[1],ay27=y7[2];
        RetTipo_Graf(g, x7,y7,7);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax26,ay26,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 8
    int x8[] ={(int)(ax25-0.86*(z+z0+z1)),(int)(ax25-0.86*(z+z0+z1)),ax25,tx14,tx13,ax25};
    int y8[]={(int)(ay25+0.5*(z+z0)+(z+z0+z1)),(int)(ay25+0.5*(z+z0+z1)),ay25,ty14,ty13,(int)(ay25+(z+z0+z1)*2)};
    //Cambios
    int ax23=x8[0],ax24=x8[1],ax22=x8[5];
    int ay23=y8[0],ay24=y8[1],ay22=y8[5];
        RetTipo_Graf(g, x8,y8,8);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax24,ay24,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 9
    int x9[] ={(int)(tx13-0.86*(z+z0+z1)),ax22,tx13,tx12,tx11,tx13};
    int y9[]={(int)(ty13+0.5*(z+z0+z1)+(z+z0+z1)),ay22,ty13,ty12,ty11,(int)(ty13+(z+z0+z1)*2)};
    //Cambios
    int ax21=x9[0],ax20=x9[5];
    int ay21=y9[0],ay20=y9[5];
        RetTipo_Graf(g, x9,y9,9);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax22,ay22,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 10
    int x10[] ={(int)(tx11-0.86*(z+z0+z1)),ax20,tx11,tx10,(int)(tx11+0.86*(z+z0+z1)),tx11};
    int y10[]={(int)(ty11+0.5*(z+z0+z1)+(z+z0+z1)),ay20,ty11,ty10,(int)(ty11+0.5*(z+z0+z1)+(z+z0+z1)),(int)(ty11+(z+z0+z1)*2)};
    //Cambios
    int ax19=x10[0],ax17=x10[4],ax18=x10[5];
    int ay19=y10[0],ay17=y10[4],ay18=y10[5];
        RetTipo_Graf(g, x10,y10,10);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax20,ay20,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 11
    int x11[] ={ax17,tx10,tx9,tx8,(int)(tx10+0.86*2*(z+z0+z1)),(int)(tx10+0.86*(z+z0+z1))};
    int y11[]={ay17,ty10,ty9,ty8,(int)(ty10+(z+z0+z1)),(int)(ty10+0.5*(z+z0+z1)+(z+z0+z1))};
    //Cambios
    int ax15=x11[4],ax16=x11[5];
    int ay15=y11[4],ay16=y11[5];
       RetTipo_Graf(g, x11,y11,11);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx10,ty10,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 12
    int x12[] ={ax15,tx8,tx7,(int)(tx8+0.86*2*(z+z0+z1)),(int)(tx8+0.86*2*(z+z0+z1)),(int)(tx8+0.86*(z+z0+z1))};
    int y12[]={ay15,ty8,ty7,ty8,(int)(ty8+(z+z0+z1)),(int)(ty8+0.5*(z+z0+z1)+(z+z0+z1))};
    //Cambios
    int ax12=x12[3],ax13=x12[4],ax14=x12[5];
    int ay12=y12[3],ay13=y12[4],ay14=y12[5];
        RetTipo_Graf(g, x12,y12,12);;
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx8,ty8,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 13
    int x13[] ={tx7,tx6,tx5,(int)(tx7+0.86*2*(z+z0+z1)),(int)(tx7+0.86*(z+z0+z1)*2),ax12};
    int y13[]={ty7,ty6,ty5,(int)(ty7-(z+z0+z1)),ty7,ay12};
    g.setColor( Color.black );
    //Cambios
    int ax10=x13[3],ax11=x13[4];
    int ay10=y13[3],ay11=y13[4];
        RetTipo_Graf(g, x13,y13,13);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx6,ty6,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 14
    int x14[] ={tx5,tx4,(int)(tx4+0.86*(z+z0+z1)),(int)(tx4+0.86*2*(z+z0+z1)),(int)(tx4+0.86*2*(z+z0+z1)),ax10};
    int y14[]={ty5,ty4,(int)(ty4-0.5*(z+z0+z1)),ty4,(int)(ty4+(z+z0+z1)),ay10};
    //Cambios
    int ax7=x14[2],ax8=x14[3],ax9=x14[4];
    int ay7=y14[2],ay8=y14[3],ay9=y14[4];
        RetTipo_Graf(g, x14,y14,14);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform") Ret_Señal(g,tx4,ty4,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 15
    int x15[] ={tx3,tx2,x14[1],(int)(x14[1]+0.86*(z+z0+z1)),ax7,tx4};
    int y15[]={ty3,ty2,y14[1]-2*(int)(z+z0+z1),(int)(y14[1]-0.5*(z+z0+z1)-(z+z0+z1)),ay7,ty4};
    //Cambios
    int ax5=x15[2],ax6=x15[3];
    int ay5=y15[2],ay6=y15[3];
        RetTipo_Graf(g, x15,y15,15);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,tx2,ty2,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 16
    int x16[] ={tx1,tx1,(int)(tx1+0.86*(z+z0+z1)),(int)(tx1+2*(z+z0+z1)*0.86),ax5,tx2};
    int y16[]={ty1,ty1-(int)(z+z0+z1),(int)(ty1-0.5*(z+z0+z1)-(z+z0+z1)),ty1-(int)(z+z0+z1),ay5,ty2};
    //Cambios
    int ax2=x16[1],ax3=x16[2],ax4=x16[3];
    int ay2=y16[1],ay3=y16[2],ay4=y16[3];
        RetTipo_Graf(g, x16,y16,16);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax2,ay2,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 17
    int x17[] ={tx17,(int)(ax2-0.86*(z+z0+z1)*2),(int)(ax2-0.86*(z+z0+z1)),ax2,tx1,tx0};
    int y17[]={ty17,ay2,(int)(ay2-0.5*(z+z0+z1)),ay2,ty1,ty0};
    //Cambios
    int ax0=x17[1],ax1=x17[2];
    int ay0=y17[1],ay1=y17[2];
        RetTipo_Graf(g, x17,y17,17);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax0,ay0,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 18
    int x18[] ={ax27,(int)(ax0-0.86*(z+z0+z1)*2),(int)(ax0-0.86*(z+z0+z1)),ax0,tx17,tx16};
    int y18[]={ay27,ay0,(int)(ay0-0.5*(z+z0+z1)),ay0,ty17,ty16};
    //Cambios
    int ax28=x18[1],ax29=x18[2];
    int ay28=y18[1],ay29=y18[2];
        RetTipo_Graf(g, x18,y18,18);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax28,ay28,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}

    //-------------------- Fin del Anillo ?(k) ---------------------------
    // Hexagono 19
    int x19[] ={(int)(ax24-0.86*(z+z0+z1+z2)),(int)(ax24-0.86*(z+z0+z1+z2)),ax24,ax26,ax25,ax24};
    int y19[]={(int)(ay24-0.5*(z+z0+z1+z2)),(int)(ay24-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),(int)(ay24-2*(z+z0+z1+z2)),ay26,ay25,ay24};
    //Cambios
    int lx32=x19[0],lx33=x19[1],lx34=x19[2];
    int ly32=y19[0],ly33=y19[1],ly34=y19[2];
        RetTipo_Graf(g, x19,y19,19);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx33,ly33,Hexg,Hexg+form.indice_timeImD);
       else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}  
    // Hexagono 20
    int x20[] ={(int)(ax24-2*0.86*(z+z0+z1+z2)),(int)(ax24-2*0.86*(z+z0+z1+z2)),lx32,ax24,ax23,(int)(ax24-0.86*(z+z0+z1+z2))};
    int y20[]={(int)(ay24+(z+z0+z1+z2)),ay24,ly32,ay24,ay23,(int)(ay24+0.5*(z+z0+z1+z2)+(z+z0+z1+z2))};
    //Cambios
    int lx30=x20[0],lx31=x20[1],lx29=x20[5];
    int ly30=y20[0],ly31=y20[1],ly29=y20[5];
        RetTipo_Graf(g, x20,y20,20);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx31,ly31,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}  
    // Hexagono 21
    int x21[] ={(int)(ax23-0.86*(z+z0+z1+z2)),lx29,ax23,ax22,ax21,ax23};
    int y21[]={(int)(ay23+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly29,ay23,ay22,ay21,ay23+2*(int)(z+z0+z1+z2)};
    //Cambios
    int lx28=x21[0],lx27=x21[5];
    int ly28=y21[0],ly27=y21[5];
       RetTipo_Graf(g, x21,y21,21);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx29,ly29,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}  
    // Hexagono 22
    int x22[] ={(int)(ax21-0.86*(z+z0+z1+z2)),lx27,ax21,ax20,ax19,ax21};
   int y22[]={(int)(ay21+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly27,ay21,ay20,ay19,ay21+2*(int)(z+z0+z1+z2)};
    //Cambios
    int lx26=x22[0],lx25=x22[5];
    int ly26=y22[0],ly25=y22[5];
        RetTipo_Graf(g, x22,y22,22);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx27,ly27,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}  
    // Hexagono 23
    int x23[] ={(int)(ax19-0.86*(z+z0+z1+z2)),lx25,ax19,ax18,(int)(ax19+0.86*(z+z0+z1+z2)),ax19};
    int y23[]={(int)(ay19+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly25,ay19,ay18,(int)(ay19+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay19+2*(int)(z+z0+z1+z2)};
    //Cambios
    int lx24=x23[0],lx23=x23[5],lx22=x23[4];
    int ly24=y23[0],ly23=y23[5],ly22=y23[4];
        RetTipo_Graf(g, x23,y23,23);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx25,ly25,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}  
    // Hexagono 24
    int x24[] ={lx22,ax18,ax17,ax16,(int)(ax17+0.86*(z+z0+z1+z2)),ax17};
    int y24[]={ly22,ay18,ay17,ay16,(int)(ay17+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay17+2*(int)(z+z0+z1+z2)};
    //Cambios
    int lx20=x24[4],lx21=x24[5];
    int ly20=y24[4],ly21=y24[5];
        RetTipo_Graf(g, x24,y24,24);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax18,ay18,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}  
    // Hexagono 25
    int x25[] ={lx20,ax16,ax15,ax14,(int)(ax15+0.86*(z+z0+z1+z2)),ax15};
    int y25[]={ly20,ay16,ay15,ay14,(int)(ay15+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay15+2*(int)(z+z0+z1+z2)};
    //Cambios
    int lx18=x25[4],lx19=x25[5];
    int ly18=y25[4],ly19=y25[5];
        RetTipo_Graf(g, x25,y25,25);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax16,ay16,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}  
    // Hexagono 26
    int x26[] ={lx18,ax14,ax13,(int)(ax13+0.86*(z+z0+z1+z2)),(int)(ax13+0.86*(z+z0+z1+z2)),ax13};
    int y26[]={ly18,ay14,ay13,(int)(ay13+0.5*(z+z0+z1+z2)),(int)(ay13+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay13+2*(int)(z+z0+z1+z2)};
    //Cambios
    int lx15=x26[3],lx16=x26[4],lx17=x26[5];
    int ly15=y26[3],ly16=y26[4],ly17=y26[5];
        RetTipo_Graf(g, x26,y26,26);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax14,ay14,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 27
    int x27[] ={ax13,ax12,ax11,(int)(ax11+0.86*(z+z0+z1+z2)),(int)(ax11+0.86*(z+z0+z1+z2)),lx15};
    int y27[]={ay13,ay12,ay11,(int)(ay11+0.5*(z+z0+z1+z2)),(int)(ay11+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly15};
    //Cambios
    int lx13=x27[3],lx14=x27[4];
    int ly13=y27[3],ly14=y27[4];
        RetTipo_Graf(g, x27,y27,27);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax12,ay12,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){} 
    // Hexagono 28
    int x28[] ={ax11,ax10,ax9,(int)(ax9+0.86*(z+z0+z1+z2)),(int)(ax9+0.86*(z+z0+z1+z2)),lx13};
    int y28[]={ay11,ay10,ay9,(int)(ay9+0.5*(z+z0+z1+z2)),(int)(ay9+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly13};
    //Cambios
    int lx11=x28[3],lx12=x28[4];
    int ly11=y28[3],ly12=y28[4];
        RetTipo_Graf(g, x28,y28,28);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax10,ay10,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 29
    int x29[] ={ax9,ax8,(int)(ax8+0.86*(z+z0+z1+z2)),(int)(ax8+2*0.86*(z+z0+z1+z2)),(int)(ax8+2*0.86*(z+z0+z1+z2)),lx11};
    int y29[]={ay9,ay8,(int)(ay8-0.5*(z+z0+z1+z2)),ay8,(int)(ay8+(z+z0+z1+z2)),ly11};
    //Cambios
    int lx9=x29[3],lx10=x29[4],lx8=x29[2];
    int ly9=y29[3],ly10=y29[4],ly8=y29[2];
        RetTipo_Graf(g, x29,y29,29);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax8,ay8,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 30
    int x30[] ={ax7,ax6,(int)(ax6+0.86*(z+z0+z1+z2)),(int)(ax6+2*0.86*(z+z0+z1+z2)),lx8,ax8};
    int y30[]={ay7,ay6,(int)(ay6-0.5*(z+z0+z1+z2)),ay6,ly8,ay8};
    //Cambios
    int lx6=x30[2],lx7=x30[3];
    int ly6=y30[2],ly7=y30[3];
        RetTipo_Graf(g, x30,y30,30);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax6,ay6,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 31
    int x31[] ={ax5,ax4,(int)(ax4+0.86*(z+z0+z1+z2)),(int)(ax4+2*0.86*(z+z0+z1+z2)),lx6,ax6};
    int y31[]={ay5,ay4,(int)(ay4-0.5*(z+z0+z1+z2)),ay4,ly6,ay6};
    //Cambios
    int lx4=x31[2],lx5=x31[3];
    int ly4=y31[2],ly5=y31[3];
        RetTipo_Graf(g, x31,y31,31);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,ax4,ay4,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 32
    int x32[] ={ax3,ax3,(int)(ax3+0.86*(z+z0+z1+z2)),(int)(ax3+2*0.86*(z+z0+z1+z2)),lx4,ax4};
    int y32[]={ay3,ay3-(int)(z+z0+z1+z2),(int)(ay3-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ay3-(int)(z+z0+z1+z2),ly4,ay4};
    //Cambios
    int lx1=x32[1],lx2=x32[2],lx3=x32[3];
    int ly1=y32[1],ly2=y32[2],ly3=y32[3];
        RetTipo_Graf(g, x32,y32,32);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx1,ly1,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 33
    int x33[] ={ax1,ax1,(int)(ax1+0.86*(z+z0+z1+z2)),lx1,ax3,ax2};
    int y33[]={ay1,ay1-(int)(z+z0+z1+z2),(int)(ay1-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ly1,ay3,ay2};
    //Cambios
    int lx41=x33[1],lx0=x33[2];
    int ly41=y33[1],ly0=y33[2];
        RetTipo_Graf(g, x33,y33,33);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx41,ly41,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 34
    int x34[] ={ax29,ax29,(int)(ax29+0.86*(z+z0+z1+z2)),lx41,ax1,ax0};
    int y34[]={ay29,ay29-(int)(z+z0+z1+z2),(int)(ay29-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ly41,ay1,ay0};
    //Cambios
    int lx39=x34[1],lx40=x34[2];
    int ly39=y34[1],ly40=y34[2];
        RetTipo_Graf(g, x34,y34,34);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx39,ly39,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 35
    int x35[] ={(int)(ax28-0.86*(z+z0+z1+z2)),(int)(ax28-0.86*(z+z0+z1+z2)),ax28,lx39,ax29,ax28};
    int y35[]={(int)(ay28-0.5*(z+z0+z1+z2)),(int)(ay28-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ay28-2*(int)(z+z0+z1+z2),ly39,ay29,ay28};
    //Cambios
    int lx36=x35[0],lx37=x35[1],lx38=x35[2];
    int ly36=y35[0],ly37=y35[1],ly38=y35[2];
        RetTipo_Graf(g, x35,y35,35);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx37,ly37,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
   // Hexagono 36
    int x36[] ={lx34,lx34,lx36,ax28,ax27,ax26};
    int y36[]={ly34,ly34-(int)(z+z0+z1+z2),ly36,ay28,ay27,ay26};
    //Cambios
    int lx35=x36[1];
    int ly35=y36[1];
        RetTipo_Graf(g, x36,y36,36);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx35,ly35,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}

    //---------------------Final del Anillo ?(n) ------------------------------------------
    // Hexagono 37
    int x37[] ={(int)(lx31-0.86*(z+z0+z1+z2+z3)),(int)(lx31-0.86*(z+z0+z1+z2+z3)),lx31,lx33,lx32,lx31};
    int y37[]={(int)(ly31-0.5*(z+z0+z1+z2+z3)),(int)(ly31-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),ly31-2*(int)(z+z0+z1+z2+z3),ly33,ly32,ly31};
    //Cambios
    int px42=x37[0],px43=x37[1],px44=x37[2];
    int py42=y37[0],py43=y37[1],py44=y37[2];
       RetTipo_Graf(g, x37,y37,37);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px43,py43,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 38
    int x38[] ={(int)(px42-0.86*(z+z0+z1+z2+z3)),(int)(px42-0.86*(z+z0+z1+z2+z3)),px42,lx31,lx30,px42};
    int y38[]={(int)(py42+0.5*(z+z0)+(z+z0+z1+z2+z3)),(int)(py42+0.5*(z+z0+z1+z2+z3)),py42,ly31,ly30,py42+2*(int)(z+z0+z1+z2+z3)};
    //Cambios
    int px40=x38[0],px41=x38[1],px39=x38[5];
    int py40=y38[0],py41=y38[1],py39=y38[5];
        RetTipo_Graf(g, x38,y38,38);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px41,py41,Hexg,Hexg+form.indice_timeImD);
        else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 39
    int x39[] ={(int)(lx30-0.86*(z+z0+z1+z2+z3)),px39,lx30,lx29,lx28,lx30};
    int y39[]={(int)(ly30+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py39,ly30,ly29,ly28,ly30+2*(int)(z+z0)};
    //Cambios
    int px38=x39[0],px37=x39[5];
    int py38=y39[0],py37=y39[5];
        RetTipo_Graf(g, x39,y39,39);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px39,py39,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 40
    int x40[] ={(int)(lx28-0.86*(z+z0+z1+z2+z3)),px37,lx28,lx27,lx26,lx28};
    int y40[]={(int)(ly28+0.5*(z+z0)+(z+z0+z1+z2+z3)),py37,ly28,ly27,ly26,ly28+2*(int)(z+z0+z1+z2+z3)};
    //Cambios
    int px36=x40[0],px35=x40[5];
    int py36=y40[0],py35=y40[5];
        RetTipo_Graf(g, x40,y40,40);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px37,py37,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 41
    int x41[] ={(int)(lx26-0.86*(z+z0+z1+z2+z3)),px35,lx26,lx25,lx24,lx26};
    int y41[]={(int)(ly26+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py35,ly26,ly25,ly24,ly26+2*(int)(z+z0+z1+z2+z3)};
    //Cambios
    int px34=x41[0],px33=x41[5];
    int py34=y41[0],py33=y41[5];
        RetTipo_Graf(g, x41,y41,41);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px35,py35,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 42
    int x42[] ={(int)(lx24-0.86*(z+z0+z1+z2+z3)),px33,lx24,lx23,(int)(lx24+0.86*(z+z0+z1+z2+z3)),lx24};
    int y42[]={(int)(ly24+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py33,ly24,ly23,(int)(ly24+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),ly24+2*(int)(z+z0+z1+z2+z3)};
    //Cambios
    int px32=x42[0],px31=x42[5],px30=x42[4];
    int py32=y42[0],py31=y42[5],py30=y42[4];
        RetTipo_Graf(g, x42,y42,42);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px33,py33,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 43
    int x43[] ={px30,lx23,lx22,lx21,(int)(lx22+0.86*(z+z0+z1+z2+z3)),lx22};
    int y43[]={py30,ly23,ly22,ly21,(int)(ly22+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),(int)(ly22+2*(z+z0+z1+z2+z3))};
    //Cambios
    int px29=x43[5],px28=x43[4];
    int py29=y43[5],py28=y43[4];
        RetTipo_Graf(g, x43,y43,43);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx23,ly23,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 44
    int x44[] ={px28,lx21,lx20,lx19,(int)(lx20+0.86*(z+z0+z1+z2+z3)),lx20};
    int y44[]={py28,ly21,ly20,ly19,(int)(ly20+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),(int)(ly20+2*(z+z0+z1+z2+z3))};
    //Cambios
    int px27=x44[5],px26=x44[4];
    int py27=y44[5],py26=y44[4];
        RetTipo_Graf(g, x44,y44,44);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx21,ly21,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 45
    int x45[] ={px26,lx19,lx18,lx17,(int)(lx18+0.86*(z+z0+z1+z2+z3)),lx18};
    int y45[]={py26,ly19,ly18,ly17,(int)(ly18+0.5*(z+z0)+(z+z0+z1+z2+z3)),(int)(ly18+2*(z+z0+z1+z2+z3))};
    //Cambios
    int px25=x45[5],px24=x45[4];
    int py25=y45[5],py24=y45[4];
        RetTipo_Graf(g, x45,y45,45);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx19,ly19,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 46
    int x46[] ={px24,lx17,lx16,(int)(lx16+0.86*(z+z0+z1+z2+z3)),(int)(lx16+0.86*(z+z0+z1+z2+z3)),lx16};
    int y46[]={py24,ly17,ly16,(int)(ly16+0.5*(z+z0+z1+z2+z3)),(int)(ly16+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),ly16+2*(int)(z+z0+z1+z2+z3)};
    //Cambios
    int px23=x46[5],px22=x46[4],px21=x46[3];
    int py23=y46[5],py22=y46[4],py21=y46[3];
        RetTipo_Graf(g, x46,y46,46);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx17,ly17,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 47
    int x47[] ={lx16,lx15,lx14,(int)(lx14+0.86*(z+z0+z1+z2+z3)),(int)(lx14+0.86*(z+z0+z1+z2+z3)),px21};
    int y47[]={ly16,ly15,ly14,(int)(ly14+0.5*(z+z0+z1+z2+z3)),(int)(ly14+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py21};
    //Cambios
    int px20=x47[4],px19=x47[3];
    int py20=y47[4],py19=y47[3];
        RetTipo_Graf(g, x47,y47,47);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx15,ly15,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 48
    int x48[] ={lx14,lx13,lx12,(int)(lx12+0.86*(z+z0+z1+z2+z3)),(int)(lx12+0.86*(z+z0+z1+z2+z3)),px19};
    int y48[]={ly14,ly13,ly12,(int)(ly12+0.5*(z+z0+z1+z2+z3)),(int)(ly12+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py19};
    //Cambios
    int px18=x48[4],px17=x48[3];
    int py18=y48[4],py17=y48[3];
        RetTipo_Graf(g, x48,y48,48);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx13,ly13,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 49
    int x49[] ={lx12,lx11,lx10,(int)(lx10+0.86*(z+z0+z1+z2+z3)),(int)(lx10+0.86*(z+z0+z1+z2+z3)),px17};
    int y49[]={ly12,ly11,ly10,(int)(ly10+0.5*(z+z0+z1+z2+z3)),(int)(ly10+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py17};
    //Cambios
    int px16=x49[4],px15=x49[3];
    int py16=y49[4],py15=y49[3];
        RetTipo_Graf(g, x49,y49,49);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx11,ly11,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 50
    int x50[] ={lx10,lx9,(int)(lx9+0.86*(z+z0+z1+z2+z3)),(int)(lx9+2*0.86*(z+z0+z1+z2+z3)),(int)(lx9+2*0.86*(z+z0+z1+z2+z3)),px15};
    int y50[]={ly10,ly9,(int)(ly9-0.5*(z+z0+z1+z2+z3)),ly9,ly9+(int)(z+z0+z1+z2+z3),py15};
    //Cambios
    int px14=x50[4],px13=x50[3],px12=x50[2];
    int py14=y50[4],py13=y50[3],py12=y50[2];
        RetTipo_Graf(g, x50,y50,50);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx9,ly9,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 51
    int x51[] ={lx8,lx7,(int)(lx7+0.86*(z+z0+z1+z2+z3)),(int)(lx7+2*0.86*(z+z0+z1+z2+z3)),px12,lx9};
    int y51[]={ly8,ly7,(int)(ly7-0.5*(z+z0+z1+z2+z3)),ly7,py12,ly9};
    //Cambios
    int px11=x51[3],px10=x51[2];
    int py11=y51[3],py10=y51[2];
        RetTipo_Graf(g, x51,y51,51);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx7,ly7,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 52
    int x52[] ={lx6,lx5,(int)(lx5+0.86*(z+z0+z1+z2+z3)),(int)(lx5+2*0.86*(z+z0+z1+z2+z3)),px10,lx7};
    int y52[]={ly6,ly5,(int)(ly5-0.5*(z+z0+z1+z2+z3)),ly5,py10,ly7};
    //Cambios
    int px9=x52[3],px8=x52[2];
    int py9=y52[3],py8=y52[2];
        RetTipo_Graf(g, x52,y52,52);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx5,ly5,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 53
    int x53[] ={lx4,lx3,(int)(lx3+0.86*(z+z0+z1+z2+z3)),(int)(lx3+2*0.86*(z+z0+z1+z2+z3)),px8,lx5};
    int y53[]={ly4,ly3,(int)(ly3-0.5*(z+z0+z1+z2+z3)),ly3,py8,ly5};
    //Cambios
    int px7=x53[3],px6=x53[2];
    int py7=y53[3],py6=y53[2];
        RetTipo_Graf(g, x53,y53,53);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,lx3,ly3,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 54
    int x54[] ={lx2,lx2,(int)(lx2+0.86*(z+z0+z1+z2+z3)),(int)(lx2+2*0.86*(z+z0+z1+z2+z3)),px6,lx3};
    int y54[]={ly2,ly2-(int)(z+z0+z1+z2+z3),(int)(ly2-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),ly2-(int)(z+z0+z1+z2+z3),py6,ly3};
    //Cambios
    int px5=x54[3],px4=x54[2],px3=x54[1];
    int py5=y54[3],py4=y54[2],py3=y54[1];
        RetTipo_Graf(g, x54,y54,54);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px3,py3,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 55
    int x55[] ={lx0,lx0,(int)(lx0+0.86*(z+z0+z1+z2+z3)),px3,lx2,lx1};
    int y55[]={ly0,ly0-(int)(z+z0+z1+z2+z3),(int)(ly0-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py3,ly2,ly1};
    //Cambios
    int px2=x55[2],px1=x55[1];
    int py2=y55[2],py1=y55[1];
        RetTipo_Graf(g, x55,y55,55);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px1,py1,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 56
    int x56[] ={lx40,lx40,(int)(lx40+0.86*(z+z0+z1+z2+z3)),px1,lx0,lx41};
    int y56[]={ly40,ly40-(int)(z+z0+z1+z2+z3),(int)(ly40-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py1,ly0,ly41};
    //Cambios
    int px53=x56[1],px0=x56[2];
    int py53=y56[1],py0=y56[2];
       RetTipo_Graf(g, x56,y56,56);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px53,py53,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 57
    int x57[] ={lx38,lx38,(int)(lx38+0.86*(z+z0+z1+z2+z3)),px53,lx40,lx39};
    int y57[]={ly38,ly38-(int)(z+z0+z1+z2+z3),(int)(ly38-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py53,ly40,ly39};
    //Cambios
    int px51=x57[1],px52=x57[2];
    int py51=y57[1],py52=y57[2];
        RetTipo_Graf(g, x57,y57,57);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px51,py51,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 58
    int x58[] ={(int)(lx37-0.86*(z+z0+z1+z2+z3)),(int)(lx37-0.86*(z+z0+z1+z2+z3)),lx37,px51,lx38,lx37};
    int y58[]={(int)(ly37-0.5*(z+z0+z1+z2+z3)),(int)(ly37-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),ly37-2*(int)(z+z0+z1+z2+z3),py51,ly38,ly37};
    //Cambios
    int px48=x58[0],px49=x58[1],px50=x58[2];
    int py48=y58[0],py49=y58[1],py50=y58[2];
        RetTipo_Graf(g, x58,y58,58);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px49,py49,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 59
    int x59[] ={(int)(lx35-0.86*(z+z0+z1+z2+z3)),(int)(lx35-0.86*(z+z0+z1+z2+z3)),px48,lx37,lx36,lx35};
    int y59[]={(int)(ly35-0.5*(z+z0+z1+z2+z3)),(int)(ly35-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py48,ly37,ly36,ly35};
    //Cambios
    int px46=x59[0],px47=x59[1];
    int py46=y59[0],py47=y59[1];
        RetTipo_Graf(g, x59,y59,59);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px47,py47,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 60
    int x60[] ={px44,px44,px46,lx35,lx34,lx33};
    int y60[]={py44,py44-(int)(z+z0+z1+z2+z3),py46,ly35,ly34,ly33};
    //Cambios
    int px45=x60[1];
    int py45=y60[1];
        RetTipo_Graf(g, x60,y60,60);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px45,py45,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    //------------- Final del Anillo ?(m) ------------------------------------------
    // Hexagono 61
    int x61[] ={px42-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px42-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px42-(int)(0.86*(z+z0+z1+z2+z3+z4)),px43,px42,px41};
    int y61[]={py42,py42-(int)(z+z0+z1+z2+z3+z4),py42-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py43,py42,py41};
    //Cambios
    int rx52=x61[0],rx53=x61[1],rx54=x61[2];
    int ry52=y61[0],ry53=y61[1],ry54=y61[2];
        RetTipo_Graf(g, x61,y61,61);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx53,ry53,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 62
    int x62[] ={px40-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px40-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx52,px41,px40,px40-(int)(0.86*(z+z0+z1+z2+z3+z4))};
    int y62[]={py40,py40-(int)(z+z0+z1+z2+z3+z4),ry52,py41,py40,py40+(int)(0.5*(z+z0+z1+z2+z3+z4))};
    //Cambios
    int rx50=x62[0],rx51=x62[1],rx49=x62[5];
    int ry50=y62[0],ry51=y62[1],ry49=y62[5];
          RetTipo_Graf(g, x62,y62,62);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx51,ry51,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 63
    int x63[] ={px38-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx49,px40,px39,px38,px38-(int)(0.86*(z+z0+z1+z2+z3+z4))};
    int y63[]={py38,ry49,py40,py39,py38,py38+(int)(0.5*(z+z0+z1+z2+z3+z4))};
    //Cambios
    int rx48=x63[0],rx47=x63[5];
    int ry48=y63[0],ry47=y63[5];
        RetTipo_Graf(g, x63,y63,63);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx49,ry49,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 64
    int x64[] ={px36-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx47,px38,px37,px36,px36-(int)(0.86*(z+z0+z1+z2+z3+z4))};
    int y64[]={py36,ry47,py38,py37,py36,py36+(int)(0.5*(z+z0+z1+z2+z3+z4))};
    //Cambios
    int rx46=x64[0],rx45=x64[5];
    int ry46=y64[0],ry45=y64[5];
        RetTipo_Graf(g, x64,y64,64);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx47,ry47,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 65
    int x65[] ={px34-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx45,px36,px35,px34,px34-(int)(0.86*(z+z0+z1+z2+z3+z4))};
    int y65[]={py34,ry45,py36,py35,py34,py34+(int)(0.5*(z+z0+z1+z2+z3+z4))};
    //Cambios
    int rx44=x65[0],rx43=x65[5];
    int ry44=y65[0],ry43=y65[5];
        RetTipo_Graf(g, x65,y65,65);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx45,ry45,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 66
    int x66[] ={px32-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx43,px34,px33,px32,px32-(int)(0.86*(z+z0+z1+z2+z3+z4))};
    int y66[]={py32,ry43,py34,py33,py32,py32+(int)(0.5*(z+z0+z1+z2+z3+z4))};
    //Cambios
    int rx42=x66[0],rx41=x66[5];
    int ry42=y66[0],ry41=y66[5];
        RetTipo_Graf(g, x66,y66,66);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx43,ry43,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 67
    int x67[] ={px32-(int)(0.86*(z+z0+z1+z2+z3+z4)),rx41,px32,px31,px31,px32};
    int y67[]={py32+(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry41,py32,py31,py31+(int)(z+z0+z1+z2+z3+z4),py32+2*(int)(z+z0+z1+z2+z3+z4)};
    //Cambios
    int rx40=x67[0],rx39=x67[5],rx38=x67[4];
    int ry40=y67[0],ry39=y67[5],ry38=y67[4];
        RetTipo_Graf(g, x67,y67,67);
         if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx41,ry41,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 68
    int x68[] ={rx38,px31,px30,px29,px29,px30};
    int y68[]={ry38,py31,py30,py29,py29+(int)(z+z0+z1+z2+z3+z4),py30+2*(int)(z+z0+z1+z2+z3+z4)};
    //Cambios
    int rx36=x68[4],rx37=x68[5];
    int ry36=y68[4],ry37=y68[5];
        RetTipo_Graf(g, x68,y68,68);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px31,py31,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 69
    int x69[] ={rx36,px29,px28,px27,px27,px28};
    int y69[]={ry36,py29,py28,py27,py27+(int)(z+z0+z1+z2+z3+z4),py28+2*(int)(z+z0+z1+z2+z3+z4)};
    //Cambios
    int rx34=x69[4],rx35=x69[5];
    int ry34=y69[4],ry35=y69[5];
        RetTipo_Graf(g, x69,y69,69);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px29,py29,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 70
    int x70[] ={rx34,px27,px26,px25,px25,px26};
    int y70[]={ry34,py27,py26,py25,py25+(int)(z+z0+z1+z2+z3+z4),py26+2*(int)(z+z0+z1+z2+z3+z4)};
    //Cambios
    int rx32=x70[4],rx33=x70[5];
    int ry32=y70[4],ry33=y70[5];
        RetTipo_Graf(g, x70,y70,70);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px27,py27,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 71
    int x71[] ={rx32,px25,px24,px23,px23,px24};
    int y71[]={ry32,py25,py24,py23,py23+(int)(z+z0+z1+z2+z3+z4),py24+2*(int)(z+z0+z1+z2+z3+z4)};
    //Cambios
    int rx30=x71[4],rx31=x71[5];
    int ry30=y71[4],ry31=y71[5];
       RetTipo_Graf(g, x71,y71,71);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px25,py25,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 72
    int x72[] ={rx30,px23,px22,px22+(int)(0.86*(z+z0+z1+z2+z3+z4)),px22+(int)(0.86*(z+z0+z1+z2+z3+z4)),px22};
    int y72[]={ry30,py23,py22,py22+(int)(0.5*(z+z0+z1+z2+z3+z4)),py22+(int)((z+z0+z1+z2+z3+z4)+0.5*(z+z0+z1+z2+z3+z4)),py22+2*(int)(z+z0+z1+z2+z3+z4)};
    //Cambios
    int rx28=x72[4],rx29=x72[5],rx27=x72[3];
    int ry28=y72[4],ry29=y72[5],ry27=y72[3];
        RetTipo_Graf(g, x72,y72,72);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px23,py23,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
   // Hexagono 73
    int x73[] ={px22,px21,px20,px20+(int)(0.86*(z+z0+z1+z2+z3+z4)),px20+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx27};
    int y73[]={py22,py21,py20,py20+(int)(0.5*(z+z0+z1+z2+z3+z4)),py20+(int)((z+z0+z1+z2+z3+z4)+0.5*(z+z0+z1+z2+z3+z4)),ry27};
    //Cambios
    int rx25=x73[3],rx26=x73[4];
    int ry25=y73[3],ry26=y73[4];
       RetTipo_Graf(g, x73,y73,73);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px21,py21,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 74
    int x74[] ={px20,px19,px18,px20+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px20+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx25};
    int y74[]={py20,py19,py18,py20-(int)((z+z0+z1+z2+z3+z4)),py20,ry25};
   //Cambios
    int rx23=x74[3],rx24=x74[4];
    int ry23=y74[3],ry24=y74[4];
        RetTipo_Graf(g, x74,y74,74);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px19,py19,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 75
    int x75[] ={px18,px17,px16,px18+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px18+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx23};
    int y75[]={py18,py17,py16,py18-(int)((z+z0+z1+z2+z3+z4)),py18,ry23};
    //Cambios
    int rx21=x75[3],rx22=x75[4];
    int ry21=y75[3],ry22=y75[4];
        RetTipo_Graf(g, x75,y75,75);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px17,py17,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 76
    int x76[] ={px16,px15,px14,px16+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px16+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx21};
    int y76[]={py16,py15,py14,py16-(int)((z+z0+z1+z2+z3+z4)),py16,ry21};
    //Cambios
    int rx19=x76[3],rx20=x76[4];
    int ry19=y76[3],ry20=y76[4];
        RetTipo_Graf(g, x76,y76,76);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px15,py15,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 77
    int x77[] ={px14,px13,px14+(int)(0.86*(z+z0+z1+z2+z3+z4)),px14+(int)(2*0.86*(z+z0+z1+z2+z3)),px14+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx19};
    int y77[]={py14,py13,py14-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py14-(int)(z+z0+z1+z2+z3+z4),py14,ry19};
    //Cambios
    int rx17=x77[3],rx18=x77[4],rx16=x77[2];
    int ry17=y77[3],ry18=y77[4],ry16=y77[2];
        RetTipo_Graf(g, x77,y77,77);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px13,py13,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 78
    int x78[] ={px12,px11,px12+(int)(0.86*(z+z0+z1+z2+z3+z4)),px12+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx16,px13};
    int y78[]={py12,py11,py12-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py12-(int)(z+z0+z1+z2+z3+z4),ry16,py13};
    //Cambios
    int rx14=x78[2],rx15=x78[3];
    int ry14=y78[2],ry15=y78[3];
        RetTipo_Graf(g, x78,y78,78);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px11,py11,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 79
    int x79[] ={px10,px9,px10+(int)(0.86*(z+z0+z1+z2+z3+z4)),px10+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx14,px11};
    int y79[]={py10,py9,py10-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py10-(int)(z+z0+z1+z2+z3+z4),ry14,py11};
    //Cambios
    int rx12=x79[2],rx13=x79[3];
    int ry12=y79[2],ry13=y79[3];
        RetTipo_Graf(g, x79,y79,79);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px9,py9,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 80
    int x80[] ={px8,px7,px8+(int)(0.86*(z+z0+z1+z2+z3+z4)),px8+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx12,px9};
    int y80[]={py8,py7,py8-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py8-(int)(z+z0+z1+z2+z3+z4),ry12,py9};
    //Cambios
    int rx10=x80[2],rx11=x80[3];
    int ry10=y80[2],ry11=y80[3];
        RetTipo_Graf(g, x80,y80,80);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px7,py7,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 81
    int x81[] ={px6,px5,px6+(int)(0.86*(z+z0+z1+z2+z3+z4)),px6+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx10,px7};
    int y81[]={py6,py5,py6-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py6-(int)(z+z0+z1+z2+z3+z4),ry10,py7};
    //Cambios
    int rx8=x81[2],rx9=x81[3];
    int ry8=y81[2],ry9=y81[3];
        RetTipo_Graf(g, x81,y81,81);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,px5,py5,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 82
    int x82[] ={px4,px4,px4+(int)(0.86*(z+z0+z1+z2+z3+z4)),px4+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx8,px5};
    int y82[]={py4,py4-(int)(z+z0+z1+z2+z3+z4),py4-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py4-(int)(z+z0+z1+z2+z3+z4),ry8,py5};
    //Cambios
    int rx5=x82[1],rx6=x82[2],rx7=x82[3];
    int ry5=y82[1],ry6=y82[2],ry7=y82[3];
        RetTipo_Graf(g, x82,y82,82);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx5,ry5,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 83
    int x83[] ={px2,px2,px2+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx5,px4,px3};
    int y83[]={py2,py2-(int)(z+z0+z1+z2+z3+z4),py2-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry5,py4,py3};
    //Cambios
    int rx3=x83[1],rx4=x83[2];
    int ry3=y83[1],ry4=y83[2];
        RetTipo_Graf(g, x83,y83,83);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx3,ry3,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 84
    int x84[] ={px0,px0,px0+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx3,px2,px1};
    int y84[]={py0,py0-(int)(z+z0+z1+z2+z3+z4),py0-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry3,py2,py1};
   //Cambios
    int rx1=x84[1],rx2=x84[2];
    int ry1=y84[1],ry2=y84[2];
        RetTipo_Graf(g, x84,y84,84);
       if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx1,ry1,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 85
    int x85[] ={px52,px52,px52+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx1,px0,px53};
    int y85[]={py52,py52-(int)(z+z0+z1+z2+z3+z4),py52-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry1,py0,py53};
    //Cambios
    int rx65=x85[1],rx0=x85[2];
    int ry65=y85[1],ry0=y85[2];
        RetTipo_Graf(g, x85,y85,85);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx65,ry65,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 86
    int x86[] ={px50,px50,px50+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx65,px52,px51};
    int y86[]={py50,py50-(int)(z+z0+z1+z2+z3+z4),py50-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry65,py52,py51};
    //Cambios
    int rx63=x86[1],rx64=x86[2];
    int ry63=y86[1],ry64=y86[2];
        RetTipo_Graf(g, x86,y86,86);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx63,ry63,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 87
    int x87[] ={px50-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px50-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px50-(int)(0.86*(z+z0+z1+z2+z3+z4)),rx63,px50,px49};
    int y87[]={py50,py50-(int)(z+z0+z1+z2+z3+z4),py50-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry63,py50,py49};
    //Cambios
    int rx60=x87[0],rx61=x87[1],rx62=x87[2];
    int ry60=y87[0],ry61=y87[1],ry62=y87[2];
        RetTipo_Graf(g, x87,y87,87);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx61,ry61,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 88
    int x88[] ={px48-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px48-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx60,px49,px48,px47};
    int y88[]={py48,py48-(int)(z+z0+z1+z2+z3+z4),ry60,py49,py48,py47};
    //Cambios
    int rx58=x88[0],rx59=x88[1];
    int ry58=y88[0],ry59=y88[1];
       RetTipo_Graf(g, x88,y88,88);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx59,ry59,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 89
    int x89[] ={px46-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px46-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx58,px47,px46,px45};
    int y89[]={py46,py46-(int)(z+z0+z1+z2+z3+z4),ry58,py47,py46,py45};
    //Cambios
    int rx56=x89[0],rx57=x89[1];
    int ry56=y89[0],ry57=y89[1];
        RetTipo_Graf(g, x89,y89,89);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx57,ry57,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 90
    int x90[] ={rx54,px44-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx56,px45,px44,px43};
    int y90[]={ry54,py44-(int)(z+z0+z1+z2+z3+z4),ry56,py45,py44,py43};
   //Cambios
    int rx55=x90[1];
    int ry55=y90[1];
        RetTipo_Graf(g, x90,y90,90);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx55,ry55,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // ------------------- Fin del Anillo ?(m) -------------------------------------
    // Hexagono 91
    int x91[] ={rx54-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx54-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx54-(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx55,rx54,rx53};
    int y91[]={ry54,ry54-(int)(z+z0+z1+z2+z3+z4+z5),ry54-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry55,ry54,ry53};
    //Cambios
    int sx0=x91[0],sx1=x91[1],sx2=x91[2];
    int sy0=y91[0],sy1=y91[1],sy2=y91[2];
       RetTipo_Graf(g, x91,y91,91);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,sx1,sy1,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 92
    int x92[] ={sx2,rx56-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx56-(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx57,rx56,rx55};
    int y92[]={sy2,ry56-(int)(z+z0+z1+z2+z3+z4+z5),ry56-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry57,ry56,ry55};
    //Cambios
    int sx3=x92[1],sx4=x92[2];
    int sy3=y92[1],sy4=y92[2];
        RetTipo_Graf(g, x92,y92,92);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,sx3,sy3,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 93
    int x93[] ={sx4,rx58-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx58-(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx59,rx58,rx57};
   int y93[]={sy4,ry58-(int)(z+z0+z1+z2+z3+z4+z5),ry58-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry59,ry58,ry57};
    //Cambios
    int sx5=x93[1],sx6=x93[2];
    int sy5=y93[1],sy6=y93[2];
        RetTipo_Graf(g, x93,y93,93);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,sx5,sy5,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 94
    int x94[] ={rx46-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx46-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx48,rx47,rx46,rx46-(int)(0.86*(z+z0+z1+z2+z3+z4+z5))};
    int y94[]={ry46,ry46-(int)(z+z0+z1+z2+z3+z4+z5),ry48,ry47,ry46,ry46+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};
    //Cambios
    int sx7=x94[0],sx8=x94[1],sx9=x94[5];
    int sy7=y94[0],sy8=y94[1],sy9=y94[5];
       RetTipo_Graf(g, x94,y94,94);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,sx8,sy8,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 95
    int x95[] ={rx44-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx9,rx46,rx45,rx44,rx44-(int)(0.86*(z+z0+z1+z2+z3))};
    int y95[]={ry44,sy9,ry46,ry45,ry44,ry44+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};
    //Cambios
    int sx10=x95[0],sx11=x95[5];
    int sy10=y95[0],sy11=y95[5];
        RetTipo_Graf(g, x95,y95,95);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,sx9,sy9,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 96
    int x96[] ={rx42-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx11,rx44,rx43,rx42,rx42-(int)(0.86*(z+z0+z1+z2+z3+z4+z5))};
    int y96[]={ry42,sy11,ry44,ry43,ry42,ry42+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};
    //Cambios
    int sx12=x96[0],sx13=x96[5];
    int sy12=y96[0],sy13=y96[5];
        RetTipo_Graf(g, x96,y96,96);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,sx11,sy11,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 97
    int x97[] ={rx26,rx25,rx24,rx26+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx26+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx26+(int)(0.86*(z+z0+z1+z2+z3+z4+z5))};
   int y97[]={ry26,ry25,ry24,ry26-(int)(z+z0+z1+z2+z3+z4+z5),ry26,ry26+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};
    //Cambios
    int sx25=x97[3],sx26=x97[4],sx27=x97[5];
    int sy25=y97[3],sy26=y97[4],sy27=y97[5];
        RetTipo_Graf(g, x97,y97,97);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx25,ry25,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 98
    int x98[] ={rx24,rx23,rx22,rx24+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx24+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx25};
    int y98[]={ry24,ry23,ry22,ry24-(int)(z+z0+z1+z2+z3+z4+z5),ry24,sy25};
    //Cambios
    int sx23=x98[3],sx24=x98[4];
    int sy23=y98[3],sy24=y98[4];
        RetTipo_Graf(g, x98,y98,98);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx23,ry23,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 99
    int x99[] ={rx22,rx21,rx20,rx22+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx22+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx23};
    int y99[]={ry22,ry21,ry20,ry22-(int)(z+z0+z1+z2+z3+z4+z5),ry22,sy23};
   //Cambios
    int sx21=x99[3],sx22=x99[4];
    int sy21=y99[3],sy22=y99[4];
        RetTipo_Graf(g, x99,y99,99);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx21,ry21,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 100
    int x100[] ={rx14,rx13,rx14+(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx14+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx14+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx15};
    int y100[]={ry14,ry13,ry14-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry14-(int)((z+z0+z1+z2+z3+z4+z5)),ry14,ry15};
    //Cambios
    int sx18=x100[2],sx19=x100[3],sx20=x100[4];
    int sy18=y100[2],sy19=y100[3],sy20=y100[4];
        RetTipo_Graf(g, x100,y100,100);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx13,ry13,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 101
    int x101[] ={rx12,rx11,rx12+(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx12+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx18,rx13};
    int y101[]={ry12,ry11,ry12-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry12-(int)((z+z0+z1+z2+z3+z4+z5)),sy18,ry13};
    //Cambios
    int sx16=x101[2],sx17=x101[3];
    int sy16=y101[2],sy17=y101[3];
        RetTipo_Graf(g, x101,y101,101);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx11,ry11,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
    // Hexagono 102
    int x102[] ={rx10,rx9,rx10+(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx10+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx16,rx11};
    int y102[]={ry10,ry9,ry10-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry10-(int)((z+z0+z1+z2+z3+z4+z5)),sy16,ry11};
    //Cambios
    int sx14=x102[2],sx15=x102[3];
    int sy14=y102[2],sy15=y102[3];
        RetTipo_Graf(g, x102,y102,102);
        if (form.RetON_OFF_wvf() == "on_wvf" && form.RetOpcion()=="wvform")Ret_Señal(g,rx9,ry9,Hexg,Hexg+form.indice_timeImD);
         else if(form.RetON_OFF_wvf() == "on_dr" && form.RetOpcion()=="Datos_resp"){}
        Hexg=0;
//        for(int k=0; k<103;k++)System.out.println("dens["+k+"] = "+form.RetDensidad_Ker1er(k));
 }

else if(form.RetOpcion()=="Resp_3D"){
        int ancho,alto;
        ancho=imagen.getWidth(this);  
        alto=imagen.getHeight(this);
        g.translate( this.getInsets().left,this.getInsets().top );
        g.drawImage( imagen,0,0,ancho,alto,this );
        g.setFont(f1);
        if(form.importD){
            if(form.Ret_ojoEst()=="Derecho" && form.RetProsc_listo_d() || form.RetOjo_conf()=="Derecho" && form.RetProsc_listo_dCONF())g.drawString("OJO DERECHO",this.getWidth()/2-40,25);
            else if(form.Ret_ojoEst()=="Izquierdo" && form.RetProsc_listo_i() || form.RetOjo_conf()=="Izquierdo" && form.RetProsc_listo_iCONF())g.drawString("OJO IZQUIERDO",this.getWidth()/2-40,25);
            else g.drawString("NO HAY OJO EVALUADO",this.getWidth()/2-40,25);
            }else{
            if(form.Ret_ojoEst()=="Derecho" && form.RetProsc_listo_d() && !form.estimulado)g.drawString("OJO DERECHO",this.getWidth()/2-40,25);
            else if(form.Ret_ojoEst()=="Izquierdo" && form.RetProsc_listo_i() && !form.estimulado)g.drawString("OJO IZQUIERDO",this.getWidth()/2-40,25);
            else g.drawString("NO HAY OJO EVALUADO",this.getWidth()/2-40,25);    
            }
 }else if(form.RetOpcion()=="Campo_Visual"){
        int ancho,alto;
        ancho=imagen2.getWidth(this);  
        alto=imagen2.getHeight(this);
        g.translate( this.getInsets().left,this.getInsets().top );
        g.drawImage( imagen2,0,0,ancho,alto,this );
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
    
    public Graphics Ret_Señal(Graphics2D g, int sx, int sy, int Hexa, int Hexs){
            xp=10;
            this.ker1 = form.Retk1WVF();
            for(int s=Hexa*form.M; s<Hexs*form.M;s++){
                g.setColor(Color.RED);
                if(form.M <=5){
                    if (s>Hexa*form.M) g.draw(new Line2D.Double(sx+(xp-0.9),sy-2*ker1[s-1]+13,sx+xp,sy-2*ker1[s]+13));} 
                else if(form.M >5 && form.M <=20){
                    if (s>Hexa*form.M && s<=(Hexs-2)*form.M) g.draw(new Line2D.Double(sx+(xp-0.9),sy-2*ker1[s-1]+13,sx+xp,sy-2*ker1[s]+13));}
                else if(form.M>20){
                    if (s>Hexa*form.M && s<=(Hexs-3)*form.M) g.draw(new Line2D.Double(sx+(xp-0.9),sy-2*ker1[s-1]+13,sx+xp,sy-2*ker1[s]+13));}
                xp=xp+0.03*form.RetBaseTiempo_delta_r();}
            Hexg=Hexs;
            return g;
    }

    public Graphics RetTipo_Graf(Graphics2D g, int[] x, int[] y,int hex){
        if(form.RetOpcion()=="Mapa_Reg"){
            
            if(hex==0){g.setColor(Color.BLACK);
            g.drawPolygon(x,y,6);g.setColor(Color.RED); g.fillPolygon(x,y,6);}
            if(hex>=1 && hex<=6){g.setColor(Color.BLACK);
            g.drawPolygon(x,y,6);g.setColor(Color.BLUE); g.fillPolygon(x,y,6);}
            if(hex>=7 && hex<=18){g.setColor(Color.BLACK);
            g.drawPolygon(x,y,6);g.setColor(Color.PINK); g.fillPolygon(x,y,6);}
            if(hex>=19 && hex<=36){g.setColor(Color.BLACK);
            g.drawPolygon(x,y,6);g.setColor(Color.GREEN); g.fillPolygon(x,y,6);}
            if(hex>=37 && hex<=60){g.setColor(Color.BLACK);
            g.drawPolygon(x,y,6);g.setColor(Color.MAGENTA); g.fillPolygon(x,y,6);}
            if(hex>=61 && hex<=102){g.setColor(Color.BLACK);
            g.drawPolygon(x,y,6);g.setColor(Color.ORANGE); g.fillPolygon(x,y,6);}
            
        }else{
            g.setColor(Color.BLACK);
            g.drawPolygon(x,y,6);
        }
        return g;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
