package erg2;



import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;
import erg2.Axis;
import erg2.DensK;
import erg3.Gauss;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.math.BigDecimal;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Geometry;
import javax.media.j3d.Node;
import javax.media.j3d.QuadArray;
import javax.media.j3d.RenderingAttributes;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TriangleFanArray;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

/**
 *
 * Autor: Cesar Peña
 *
 */

public class Jed extends javax.swing.JFrame{
    
    private Transform3D rotate1 = new Transform3D();
    private Transform3D rotate2 = new Transform3D();
    private Gauss g1[];
    private Gauss g;
    private float scalg,minZ,maxZ;
    private double minimo, maximo,sumaHex,Nhex,tempp;
    private Test0 form;
    private boolean line_onoff,enum_onoff,as0=true,as2=true;
    private double dens[] = new double[103];
    private Integer maxmin[]= new Integer[2];
    private double hexmax = 0.0,hexmin=0.0;
    public int xo=0,yo=0;
    public int xi=0,yi=0,xm,ym;
    private double mediapointG,Ng;
    private DensK j;
    private BigDecimal b;
    private Transform3D x;
    private TransformGroup tg0;
    private Text2D d;
    private ButtonGroup grupobot;
    private BigDecimal bmax[] = new BigDecimal[25];
    private BigDecimal bmim[] = new BigDecimal[25];
    private BigDecimal maxim,minin,medi;
    private boolean cx[] = new boolean[25];
    private double hexmx[] = new double[25];
    private double hexmn[] = new double[25];
    private int xminsel,xminsel1,xmedsel;
    private Axis ejes;
    float   d1=0.0900f*scalg, 
            d2 =0.51f* 0.15f*scalg, 
            d3=0.045f*scalg, 
            d4=0.154579999999999f*scalg, 
            d5=0.232578999999999999f*scalg, 
            d6=0.3113677999999f*scalg, 
            d7=0.3900278999999f*scalg;
    public NoiseG2 Geometria_Noise;
    private Text2D minn,maxx,medd,unid;
    private Appearance Ap,Ap1;
    private RenderingAttributes Ra,Ra1;
    private Text2D text2db[]= new Text2D[25];
    private Shape3D sqa[] = new Shape3D[25];
    private Shape3D sqa1[] = new Shape3D[25];
    private Appearance aptext[] = new Appearance[25];
    private Appearance aptext1[] = new Appearance[4];

   public class NoiseG2 extends Shape3D{

            public NoiseG2() {
                    this.setGeometry(NoiseGeomet());
            }

    private Geometry NoiseGeomet() {
                
                g.returnGauss(0.0,0.5);
                for(int k=0; k<103;k++){
//                    if(!form.importD){
//                        if (form.Ret_ojoEst()=="Izquierdo" && form.RetProsc_listo_i())dens[k]=form.RetDensidad_Ker1er_I(k);
//                        else if(form.Ret_ojoEst()=="Derecho" && form.RetProsc_listo_d())dens[k]=form.RetDensidad_Ker1er_D(k);
//                    }else if(form.importD){
                        if(form.RetOjo_conf()=="Izquierdo" && form.RetProsc_listo_iCONF()) dens[k]=form.RetDensidad_Ker1er_Iconf(k);
                        else if(form.RetOjo_conf()=="Derecho" && form.RetProsc_listo_dCONF())dens[k]=form.RetDensidad_Ker1er_Dconf(k);    
//                    }
                }       
                
                for(int m=0;m<=60;m++){
                    if(m>=0&&m<=5){
                        g1[m]=new Gauss((5-m*2)*0.1,15*0.1);
                        g1[m+6]=new Gauss((5-m*2)*0.1,-15*0.1);
                        g1[m].returnGauss(0.2,dens[72-m]);
                        g1[m+6].returnGauss(0.2,dens[82+m]);
                    }else if(m>=12&&m<=20){           
                        g1[m]=new Gauss((8-(m-12)*2)*0.1,12*0.1);                        
                        g1[m+9]=new Gauss((8-(m-12)*2)*0.1,-12*0.1);
                    }else if(m>=30&&m<=39){
                        g1[m]=new Gauss((9-(m-30)*2)*0.1,9*0.1);
                        g1[m+10]=new Gauss((9-(m-30)*2)*0.1,-9*0.1);
                        g1[m+42]=new Gauss((9-(m-30)*2)*0.1,3*0.1);
                        g1[m+52]=new Gauss((9-(m-30)*2)*0.1,-3*0.1);                                                
                    }else if(m>=50&&m<=60){
                        g1[m]=new Gauss((10-(m-50)*2)*0.1,6*0.1);
                        g1[m+11]=new Gauss((10-(m-50)*2)*0.1,-6*0.1);
                        g1[m+42]=new Gauss((10-(m-50)*2)*0.1,0.0);                        
                     }
                 }
                        g1[12].returnGauss(0.2,dens[97]);
                        g1[13].returnGauss(0.2,dens[73]);
                        g1[14].returnGauss(0.2,dens[46]);
                        g1[15].returnGauss(0.2,dens[45]);
                        g1[16].returnGauss(0.2,dens[44]);
                        g1[17].returnGauss(0.2,dens[43]);
                        g1[18].returnGauss(0.2,dens[42]);
                        g1[19].returnGauss(0.2,dens[66]);
                        g1[20].returnGauss(0.2,dens[96]);
                        g1[12+9].returnGauss(0.2,dens[102]);
                        g1[13+9].returnGauss(0.2,dens[81]);
                        g1[14+9].returnGauss(0.2,dens[54]);
                        g1[15+9].returnGauss(0.2,dens[55]);
                        g1[16+9].returnGauss(0.2,dens[56]);
                        g1[17+9].returnGauss(0.2,dens[57]);
                        g1[18+9].returnGauss(0.2,dens[58]);
                        g1[19+9].returnGauss(0.2,dens[88]);
                        g1[20+9].returnGauss(0.2,dens[93]); 
                        g1[30].returnGauss(0.2,dens[98]);
                        g1[31].returnGauss(0.2,dens[74]);
                        g1[32].returnGauss(0.2,dens[47]);
                        g1[33].returnGauss(0.2,dens[26]);
                        g1[34].returnGauss(0.2,dens[25]);
                        g1[35].returnGauss(0.2,dens[24]);
                        g1[36].returnGauss(0.2,dens[23]);
                        g1[37].returnGauss(0.2,dens[41]);
                        g1[38].returnGauss(0.2,dens[65]);
                        g1[39].returnGauss(0.2,dens[95]);
                        g1[30+10].returnGauss(0.2,dens[101]);
                        g1[31+10].returnGauss(0.2,dens[80]);
                        g1[32+10].returnGauss(0.2,dens[53]);
                        g1[33+10].returnGauss(0.2,dens[32]);
                        g1[34+10].returnGauss(0.2,dens[33]);
                        g1[35+10].returnGauss(0.2,dens[34]);
                        g1[36+10].returnGauss(0.2,dens[35]);
                        g1[37+10].returnGauss(0.2,dens[59]);
                        g1[38+10].returnGauss(0.2,dens[89]);
                        g1[39+10].returnGauss(0.2,dens[92]);
                        g1[30+42].returnGauss(0.2,dens[76]);
                        g1[31+42].returnGauss(0.2,dens[49]);
                        g1[32+42].returnGauss(0.2,dens[28]);
                        g1[33+42].returnGauss(0.2,dens[13]);
                        g1[34+42].returnGauss(0.2,dens[4]);
                        g1[35+42].returnGauss(0.2,dens[3]);
                        g1[36+42].returnGauss(0.2,dens[9]);
                        g1[37+42].returnGauss(0.2,dens[21]);
                        g1[38+42].returnGauss(0.2,dens[39]);
                        g1[39+42].returnGauss(0.2,dens[63]);
                        g1[30+52].returnGauss(0.2,dens[78]);
                        g1[31+52].returnGauss(0.2,dens[51]);
                        g1[32+52].returnGauss(0.2,dens[30]);
                        g1[33+52].returnGauss(0.2,dens[15]);
                        g1[34+52].returnGauss(0.2,dens[6]);
                        g1[35+52].returnGauss(0.2,dens[1]);
                        g1[36+52].returnGauss(0.2,dens[7]);
                        g1[37+52].returnGauss(0.2,dens[19]);
                        g1[38+52].returnGauss(0.2,dens[37]);
                        g1[39+52].returnGauss(0.2,dens[61]);
                        g1[50].returnGauss(0.2,dens[99]);
                        g1[51].returnGauss(0.2,dens[75]);
                        g1[52].returnGauss(0.2,dens[48]);
                        g1[53].returnGauss(0.2,dens[27]);
                        g1[54].returnGauss(0.2,dens[12]);
                        g1[55].returnGauss(0.2,dens[11]);
                        g1[56].returnGauss(0.2,dens[10]);
                        g1[57].returnGauss(0.2,dens[22]);
                        g1[58].returnGauss(0.2,dens[40]);
                        g1[59].returnGauss(0.2,dens[64]);
                        g1[60].returnGauss(0.2,dens[94]);
                        g1[50+11].returnGauss(0.2,dens[100]);
                        g1[51+11].returnGauss(0.2,dens[79]);
                        g1[52+11].returnGauss(0.2,dens[52]);
                        g1[53+11].returnGauss(0.2,dens[31]);
                        g1[54+11].returnGauss(0.2,dens[16]);
                        g1[55+11].returnGauss(0.2,dens[17]);
                        g1[56+11].returnGauss(0.2,dens[18]);
                        g1[57+11].returnGauss(0.2,dens[36]);
                        g1[58+11].returnGauss(0.2,dens[60]);
                        g1[59+11].returnGauss(0.2,dens[90]);
                        g1[60+11].returnGauss(0.2,dens[91]);
                        g1[50+42].returnGauss(0.2,dens[77]);
                        g1[51+42].returnGauss(0.2,dens[50]);
                        g1[52+42].returnGauss(0.2,dens[29]);
                        g1[53+42].returnGauss(0.2,dens[14]);
                        g1[54+42].returnGauss(0.2,dens[5]);
                        g1[55+42].returnGauss(0.2,dens[0]);
                        g1[56+42].returnGauss(0.2,dens[2]);
                        g1[57+42].returnGauss(0.2,dens[8]);
                        g1[58+42].returnGauss(0.2,dens[20]);
                        g1[59+42].returnGauss(0.2,dens[38]);
                        g1[60+42].returnGauss(0.2,dens[62]);
                        g1[97] = new Gauss(0.0,0.0);
                        g1[97].returnGauss(0.2,25.89);    
               
             double sumaGauss=0.0;
              
               for(int i=1;i<=37;i++){  
                for(int j=1;j<=36;j++){
                    for(int k=0;k<=102;k++){
                            sumaGauss = sumaGauss + g1[k].returnZ(i,j);
                        }
                        g.z[i][j]=sumaGauss;
                        sumaGauss =0.0;
                    }
              }
               // Calculo del Valor Maximo, Minimo y Media de la Grafica de Densidad P1
                minimo = g.returnZ(5,5);
                maximo = g.returnZ(5,5);
                hexmin   = g.z[19][19];hexmn[0]  = g.z[19][19];hexmn[1]  = g.z[19][19];hexmn[2]  = g.z[19][19];hexmn[3]  = g.z[19][19];hexmn[4]  = g.z[19][19];
                hexmn[10] = g.z[19][19];hexmn[9] = g.z[19][19];hexmn[8]  = g.z[19][19];hexmn[7]  = g.z[19][19];hexmn[6]  = g.z[19][19];hexmn[5]  = g.z[19][19];
                hexmn[11] = g.z[19][19];hexmn[12] = g.z[19][19];hexmn[13] = g.z[19][19];hexmn[14] = g.z[19][19];hexmn[15] = g.z[19][19];hexmn[16] = g.z[19][19];
                hexmn[22] = g.z[19][19];hexmn[21] = g.z[19][19];hexmn[20] = g.z[19][19];hexmn[19] = g.z[19][19];hexmn[18] = g.z[19][19];hexmn[17] = g.z[19][19];
                hexmn[23] = g.z[19][19];hexmn[24] = g.z[19][19];
               
              for(int i=1;i<=37;i++){  
                for(int j=1;j<=36;j++){
                        if(maximo>=g.z[i][j]) maximo = maximo;
                        else if(maximo<g.z[i][j]) maximo =g.z[i][j];
                        if(minimo<=g.z[i][j]) minimo = minimo;
                        else if(minimo>g.z[i][j]) minimo =g.z[i][j];
                        Ng = Ng +1;
                        mediapointG = mediapointG + g.z[i][j];
                 }
              }
                 mediapointG = mediapointG/Ng;
                // Definicion de la Geometria para la Grafica de Densidad P1
                TriangleFanArray tfa;
                
                int     N = 7;
                int     totalN = 206*(N+1);
                Point3f coords[] = new Point3f[totalN];
                Color3f colors[] = new Color3f[totalN];
                
                int     stripCounts[] = 
                {N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1,
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, 
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1,
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1,
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, 
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1,
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, 
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, 
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1,
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, 
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, 
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1,
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1,
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, 
                 N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1, N+1
                 };
                float   r = 0.05f*scalg; // Antes => 0.1f
                float w = 0.1f*scalg; 
                int     n;
                double  a;
                float   x, y;
                float d1=0.0900f*scalg, d2 =0.51f* 0.15f*scalg, d3=0.045f*scalg, d4=0.154579999999999f*scalg, d5=0.232578999999999999f*scalg, d6=0.3113677999999f*scalg, d7=0.3900278999999f*scalg;
                             
                // Centroides de cada Cono con Altura Gauss(x,y)                    
                coords[0*(N+1)] = new Point3f(0.0f, 0.0f, minZ-0.2f+scalg*0.02f*(g.returnZ(19,19)+(maxZ-1.0f))); // H0
                coords[1*(N+1)] = new Point3f(0.0f, 0.0f, 0.0f);
                coords[2*(N+1)] = new Point3f(0.0f, d1, minZ-0.2f+scalg*0.02f*(g.returnZ(17,19)+(maxZ-1.0f)));  // H2
                coords[3*(N+1)] = new Point3f(0.0f, d1, 0.0f);
                coords[4*(N+1)] = new Point3f(0.0f, -d1, minZ-0.2f+scalg*0.02f*(g.returnZ(21,19)+(maxZ-1.0f)));  // H5
                coords[5*(N+1)] = new Point3f(0.0f, -d1, 0.0f);
                coords[6*(N+1)] = new Point3f(0.0f, 2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(15,19)+(maxZ-1.0f)));  // H8
                coords[7*(N+1)] = new Point3f(0.0f, 2*d1, 0.0f);
                coords[8*(N+1)] = new Point3f(0.0f, -2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(23,19)+(maxZ-1.0f)));  // H14
                coords[9*(N+1)] = new Point3f(0.0f, -2*d1, 0.0f);
                coords[10*(N+1)] = new Point3f(0.0f, 3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(13,19)+(maxZ-1.0f)));  // H20
                coords[11*(N+1)] = new Point3f(0.0f, 3*d1, 0.0f);
                coords[12*(N+1)] = new Point3f(0.0f, -3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(25,19)+(maxZ-1.0f)));  // H29
                coords[13*(N+1)] = new Point3f(0.0f, -3*d1, 0.0f);
                coords[14*(N+1)] = new Point3f(0.0f, 4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(11,19)+(maxZ-1.0f)));  // H38
                coords[15*(N+1)] = new Point3f(0.0f, 4*d1, 0.0f);
                coords[16*(N+1)] = new Point3f(0.0f, -4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(27,19)+(maxZ-1.0f)));  // H50
                coords[17*(N+1)] = new Point3f(0.0f, -4*d1, 0.0f);
                coords[18*(N+1)] = new Point3f(0.0f, 5*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(9,19)+(maxZ-1.0f)));   //  H62
                coords[19*(N+1)] = new Point3f(0.0f, 5*d1, 0.0f);
                coords[20*(N+1)] = new Point3f(0.0f, -5*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(29,19)+(maxZ-1.0f)));  // H77
                coords[21*(N+1)] = new Point3f(0.0f, -5*d1, 0.0f);
                coords[22*(N+1)] = new Point3f(-d2,d3, minZ-0.2f+scalg*0.02f*(g.returnZ(18,16)+(maxZ-1.0f))); // H3
                coords[23*(N+1)] = new Point3f(-d2,d3, 0.0f);
                coords[24*(N+1)] = new Point3f(-d2,-d3, minZ-0.2f+scalg*0.02f*(g.returnZ(20,16)+(maxZ-1.0f))); // H4
                coords[25*(N+1)] = new Point3f(-d2,-d3, 0.0f);
                coords[26*(N+1)] = new Point3f(-d2,3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(16,16)+(maxZ-1.0f))); // H9
                coords[27*(N+1)] = new Point3f(-d2,3*d3, 0.0f);
                coords[28*(N+1)] = new Point3f(-d2,-3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(22,16)+(maxZ-1.0f))); // H13
                coords[29*(N+1)] = new Point3f(-d2,-3*d3, 0.0f);
                coords[30*(N+1)] = new Point3f(-d2,5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(14,16)+(maxZ-1.0f))); // H21
                coords[31*(N+1)] = new Point3f(-d2,5*d3, 0.0f);
                coords[32*(N+1)] = new Point3f(-d2,-5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(24,16)+(maxZ-1.0f))); // H28
                coords[33*(N+1)] = new Point3f(-d2,-5*d3, 0.0f);
                coords[34*(N+1)] = new Point3f(-d2,7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(12,16)+(maxZ-1.0f))); // H39
                coords[35*(N+1)] = new Point3f(-d2,7*d3, 0.0f);
                coords[36*(N+1)] = new Point3f(-d2,-7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(26,16)+(maxZ-1.0f))); // H49
                coords[37*(N+1)] = new Point3f(-d2,-7*d3, 0.0f);
                coords[38*(N+1)] = new Point3f(-d2,9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(10,16)+(maxZ-1.0f))); // H63
                coords[39*(N+1)] = new Point3f(-d2,9*d3, 0.0f);
                coords[40*(N+1)] = new Point3f(-d2,-9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(28,16)+(maxZ-1.0f))); // H76
                coords[41*(N+1)] = new Point3f(-d2,-9*d3, 0.0f);
                coords[42*(N+1)] = new Point3f(d2,d3, minZ-0.2f+scalg*0.02f*(g.returnZ(18,22)+(maxZ-1.0f))); // H1
                coords[43*(N+1)] = new Point3f(d2,d3, 0.0f);
                coords[44*(N+1)] = new Point3f(d2,-d3, minZ-0.2f+scalg*0.02f*(g.returnZ(20,22)+(maxZ-1.0f))); // H6
                coords[45*(N+1)] = new Point3f(d2,-d3, 0.0f);
                coords[46*(N+1)] = new Point3f(d2,3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(16,22)+(maxZ-1.0f))); // H7
                coords[47*(N+1)] = new Point3f(d2,3*d3, 0.0f);
                coords[48*(N+1)] = new Point3f(d2,-3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(22,22)+(maxZ-1.0f))); // H15
                coords[49*(N+1)] = new Point3f(d2,-3*d3, 0.0f);
                coords[50*(N+1)] = new Point3f(d2,5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(14,22)+(maxZ-1.0f))); // H19
                coords[51*(N+1)] = new Point3f(d2,5*d3, 0.0f);
                coords[52*(N+1)] = new Point3f(d2,-5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(24,22)+(maxZ-1.0f))); // H30
                coords[53*(N+1)] = new Point3f(d2,-5*d3, 0.0f);
                coords[54*(N+1)] = new Point3f(d2,7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(12,22)+(maxZ-1.0f))); // H37
                coords[55*(N+1)] = new Point3f(d2,7*d3, 0.0f);
                coords[56*(N+1)] = new Point3f(d2,-7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(26,22)+(maxZ-1.0f))); // H51
                coords[57*(N+1)] = new Point3f(d2,-7*d3, 0.0f);
                coords[58*(N+1)] = new Point3f(d2,9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(10,22)+(maxZ-1.0f))); // H61
                coords[59*(N+1)] = new Point3f(d2,9*d3, 0.0f);
                coords[60*(N+1)] = new Point3f(d2,-9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(28,22)+(maxZ-1.0f))); // H78
                coords[61*(N+1)] = new Point3f(d2,-9*d3, 0.0f);
                coords[62*(N+1)] = new Point3f(-d4, 0.0f, minZ-0.2f+scalg*0.02f*(g.returnZ(19,13)+(maxZ-1.0f))); // H11
                coords[63*(N+1)] = new Point3f(-d4, 0.0f, 0.0f);
                coords[64*(N+1)] = new Point3f(-d4, d1, minZ-0.2f+scalg*0.02f*(g.returnZ(17,13)+(maxZ-1.0f)));  // H10
                coords[65*(N+1)] = new Point3f(-d4, d1, 0.0f);
                coords[66*(N+1)] = new Point3f(-d4, -d1, minZ-0.2f+scalg*0.02f*(g.returnZ(21,13)+(maxZ-1.0f)));  // H12
                coords[67*(N+1)] = new Point3f(-d4, -d1, 0.0f);
                coords[68*(N+1)] = new Point3f(-d4, 2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(15,13)+(maxZ-1.0f)));  // H22
                coords[69*(N+1)] = new Point3f(-d4, 2*d1, 0.0f);
                coords[70*(N+1)] = new Point3f(-d4, -2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(23,13)+(maxZ-1.0f)));  // H27
                coords[71*(N+1)] = new Point3f(-d4, -2*d1, 0.0f);
                coords[72*(N+1)] = new Point3f(-d4, 3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(13,13)+(maxZ-1.0f)));  // H40
                coords[73*(N+1)] = new Point3f(-d4, 3*d1, 0.0f);
                coords[74*(N+1)] = new Point3f(-d4, -3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(25,13)+(maxZ-1.0f)));  // H48
                coords[75*(N+1)] = new Point3f(-d4, -3*d1, 0.0f);
                coords[76*(N+1)] = new Point3f(-d4, 4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(11,13)+(maxZ-1.0f)));  // H64
                coords[77*(N+1)] = new Point3f(-d4, 4*d1, 0.0f);
                coords[78*(N+1)] = new Point3f(-d4, -4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(27,13)+(maxZ-1.0f)));  // H75
                coords[79*(N+1)] = new Point3f(-d4, -4*d1, 0.0f);
                coords[80*(N+1)] = new Point3f(-d4, 5*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(9,13)+(maxZ-1.0f)));   //  H94
                coords[81*(N+1)] = new Point3f(-d4, 5*d1, 0.0f);
                coords[82*(N+1)] = new Point3f(-d4, -5*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(29,13)+(maxZ-1.0f)));  // H99
                coords[83*(N+1)] = new Point3f(-d4, -5*d1, 0.0f);
                coords[84*(N+1)] = new Point3f(d4, 0.0f, minZ-0.2f+scalg*0.02f*(g.returnZ(19,25)+(maxZ-1.0f))); // H17
                coords[85*(N+1)] = new Point3f(d4, 0.0f, 0.0f);
                coords[86*(N+1)] = new Point3f(d4, d1, minZ-0.2f+scalg*0.02f*(g.returnZ(17,25)+(maxZ-1.0f)));  // H18
                coords[87*(N+1)] = new Point3f(d4, d1, 0.0f);
                coords[88*(N+1)] = new Point3f(d4, -d1, minZ-0.2f+scalg*0.02f*(g.returnZ(21,25)+(maxZ-1.0f)));  // H16
                coords[89*(N+1)] = new Point3f(d4, -d1, 0.0f);
                coords[90*(N+1)] = new Point3f(d4, 2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(15,25)+(maxZ-1.0f)));  // H36
                coords[91*(N+1)] = new Point3f(d4, 2*d1, 0.0f);
                coords[92*(N+1)] = new Point3f(d4, -2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(23,25)+(maxZ-1.0f)));  // H31
                coords[93*(N+1)] = new Point3f(d4, -2*d1, 0.0f);
                coords[94*(N+1)] = new Point3f(d4, 3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(13,25)+(maxZ-1.0f)));  // H60
                coords[95*(N+1)] = new Point3f(d4, 3*d1, 0.0f);
                coords[96*(N+1)] = new Point3f(d4, -3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(25,25)+(maxZ-1.0f)));  // H52
                coords[97*(N+1)] = new Point3f(d4, -3*d1, 0.0f);
                coords[98*(N+1)] = new Point3f(d4, 4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(11,25)+(maxZ-1.0f)));  // H90
                coords[99*(N+1)] = new Point3f(d4, 4*d1, 0.0f);
                coords[100*(N+1)] = new Point3f(d4, -4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(27,25)+(maxZ-1.0f)));  // H79
                coords[101*(N+1)] = new Point3f(d4, -4*d1, 0.0f);
                coords[102*(N+1)] = new Point3f(d4, 5*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(9,25)+(maxZ-1.0f)));   //  H91
                coords[103*(N+1)] = new Point3f(d4, 5*d1, 0.0f);
                coords[104*(N+1)] = new Point3f(d4, -5*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(29,25)+(maxZ-1.0f)));  // H100
                coords[105*(N+1)] = new Point3f(d4, -5*d1, 0.0f);
                coords[106*(N+1)] = new Point3f(-d5,d3, minZ-0.2f+scalg*0.02f*(g.returnZ(18,10)+(maxZ-1.0f))); // H24
                coords[107*(N+1)] = new Point3f(-d5,d3, 0.0f);
                coords[108*(N+1)] = new Point3f(-d5,-d3, minZ-0.2f+scalg*0.02f*(g.returnZ(20,10)+(maxZ-1.0f))); // H25
                coords[109*(N+1)] = new Point3f(-d5,-d3, 0.0f);
                coords[110*(N+1)] = new Point3f(-d5,3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(16,10)+(maxZ-1.0f))); // H23
                coords[111*(N+1)] = new Point3f(-d5,3*d3, 0.0f);
                coords[112*(N+1)] = new Point3f(-d5,-3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(22,10)+(maxZ-1.0f))); // H26
                coords[113*(N+1)] = new Point3f(-d5,-3*d3, 0.0f);
                coords[114*(N+1)] = new Point3f(-d5,5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(14,10)+(maxZ-1.0f))); // H41
                coords[115*(N+1)] = new Point3f(-d5,5*d3, 0.0f);
                coords[116*(N+1)] = new Point3f(-d5,-5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(24,10)+(maxZ-1.0f))); // H47
                coords[117*(N+1)] = new Point3f(-d5,-5*d3, 0.0f);
                coords[118*(N+1)] = new Point3f(-d5,7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(12,10)+(maxZ-1.0f))); // H65
                coords[119*(N+1)] = new Point3f(-d5,7*d3, 0.0f);
                coords[120*(N+1)] = new Point3f(-d5,-7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(26,10)+(maxZ-1.0f))); // H74
                coords[121*(N+1)] = new Point3f(-d5,-7*d3, 0.0f);
                coords[122*(N+1)] = new Point3f(-d5,9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(10,10)+(maxZ-1.0f))); // H95
                coords[123*(N+1)] = new Point3f(-d5,9*d3, 0.0f);
                coords[124*(N+1)] = new Point3f(-d5,-9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(28,10)+(maxZ-1.0f))); // H98
                coords[125*(N+1)] = new Point3f(-d5,-9*d3, 0.0f);
                coords[126*(N+1)] = new Point3f(d5,d3, minZ-0.2f+scalg*0.02f*(g.returnZ(18,28)+(maxZ-1.0f))); // H34
                coords[127*(N+1)] = new Point3f(d5,d3, 0.0f);
                coords[128*(N+1)] = new Point3f(d5,-d3, minZ-0.2f+scalg*0.02f*(g.returnZ(20,28)+(maxZ-1.0f))); // H33
                coords[129*(N+1)] = new Point3f(d5,-d3, 0.0f);
                coords[130*(N+1)] = new Point3f(d5,3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(16,28)+(maxZ-1.0f))); // H35
                coords[131*(N+1)] = new Point3f(d5,3*d3, 0.0f);
                coords[132*(N+1)] = new Point3f(d5,-3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(22,28)+(maxZ-1.0f))); // H32
                coords[133*(N+1)] = new Point3f(d5,-3*d3, 0.0f);
                coords[134*(N+1)] = new Point3f(d5,5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(14,28)+(maxZ-1.0f))); // H59
                coords[135*(N+1)] = new Point3f(d5,5*d3, 0.0f);
                coords[136*(N+1)] = new Point3f(d5,-5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(24,28)+(maxZ-1.0f))); // H53
                coords[137*(N+1)] = new Point3f(d5,-5*d3, 0.0f);
                coords[138*(N+1)] = new Point3f(d5,7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(12,28)+(maxZ-1.0f))); // H89
                coords[139*(N+1)] = new Point3f(d5,7*d3, 0.0f);
                coords[140*(N+1)] = new Point3f(d5,-7*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(26,28)+(maxZ-1.0f))); // H80
                coords[141*(N+1)] = new Point3f(d5,-7*d3, 0.0f);
                coords[142*(N+1)] = new Point3f(d5,9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(10,28)+(maxZ-1.0f))); // H92
                coords[143*(N+1)] = new Point3f(d5,9*d3, 0.0f);
                coords[144*(N+1)] = new Point3f(d5,-9*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(28,28)+(maxZ-1.0f))); // H101
                coords[145*(N+1)] = new Point3f(d5,-9*d3, 0.0f);
                coords[146*(N+1)] = new Point3f(d6, 0.0f, minZ-0.2f+scalg*0.02f*(g.returnZ(19,31)+(maxZ-1.0f))); // H56
                coords[147*(N+1)] = new Point3f(d6, 0.0f, 0.0f);
                coords[148*(N+1)] = new Point3f(d6, d1, minZ-0.2f+scalg*0.02f*(g.returnZ(17,31)+(maxZ-1.0f)));  // H57
                coords[149*(N+1)] = new Point3f(d6, d1, 0.0f);
                coords[150*(N+1)] = new Point3f(d6, -d1, minZ-0.2f+scalg*0.02f*(g.returnZ(21,31)+(maxZ-1.0f)));  // H55
                coords[151*(N+1)] = new Point3f(d6, -d1, 0.0f);
                coords[152*(N+1)] = new Point3f(d6, 2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(15,31)+(maxZ-1.0f)));  // H58
                coords[153*(N+1)] = new Point3f(d6, 2*d1, 0.0f);
                coords[154*(N+1)] = new Point3f(d6, -2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(23,31)+(maxZ-1.0f)));  // H54
                coords[155*(N+1)] = new Point3f(d6, -2*d1, 0.0f);
                coords[156*(N+1)] = new Point3f(d6, 3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(13,31)+(maxZ-1.0f)));  // H88
                coords[157*(N+1)] = new Point3f(d6, 3*d1, 0.0f);
                coords[158*(N+1)] = new Point3f(d6, -3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(25,31)+(maxZ-1.0f)));  // H81
                coords[159*(N+1)] = new Point3f(d6, -3*d1, 0.0f);
                coords[160*(N+1)] = new Point3f(d6, 4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(11,31)+(maxZ-1.0f)));  // H93
                coords[161*(N+1)] = new Point3f(d6, 4*d1, 0.0f);
                coords[162*(N+1)] = new Point3f(d6, -4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(27,31)+(maxZ-1.0f)));  // H102
                coords[163*(N+1)] = new Point3f(d6, -4*d1, 0.0f);
                coords[164*(N+1)] = new Point3f(-d6, 0.0f, minZ-0.2f+scalg*0.02f*(g.returnZ(19,7)+(maxZ-1.0f))); // H44
                coords[165*(N+1)] = new Point3f(-d6, 0.0f, 0.0f);
                coords[166*(N+1)] = new Point3f(-d6, d1, minZ-0.2f+scalg*0.02f*(g.returnZ(17,7)+(maxZ-1.0f)));  // H43
                coords[167*(N+1)] = new Point3f(-d6, d1, 0.0f);
                coords[168*(N+1)] = new Point3f(-d6, -d1, minZ-0.2f+scalg*0.02f*(g.returnZ(21,7)+(maxZ-1.0f)));  // H45
                coords[169*(N+1)] = new Point3f(-d6, -d1, 0.0f);
                coords[170*(N+1)] = new Point3f(-d6, 2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(15,7)+(maxZ-1.0f)));  // H42
                coords[171*(N+1)] = new Point3f(-d6, 2*d1, 0.0f);
                coords[172*(N+1)] = new Point3f(-d6, -2*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(23,7)+(maxZ-1.0f)));  // H46
                coords[173*(N+1)] = new Point3f(-d6, -2*d1, 0.0f);
                coords[174*(N+1)] = new Point3f(-d6, 3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(13,7)+(maxZ-1.0f)));  // H66
                coords[175*(N+1)] = new Point3f(-d6, 3*d1, 0.0f);
                coords[176*(N+1)] = new Point3f(-d6, -3*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(25,7)+(maxZ-1.0f)));  // H73
                coords[177*(N+1)] = new Point3f(-d6, -3*d1, 0.0f);
                coords[178*(N+1)] = new Point3f(-d6, 4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(11,7)+(maxZ-1.0f)));  // H96
                coords[179*(N+1)] = new Point3f(-d6, 4*d1, 0.0f);
                coords[180*(N+1)] = new Point3f(-d6, -4*d1, minZ-0.2f+scalg*0.02f*(g.returnZ(27,7)+(maxZ-1.0f)));  // H97
                coords[181*(N+1)] = new Point3f(-d6, -4*d1, 0.0f);
                coords[182*(N+1)] = new Point3f(-d7,d3, minZ-0.2f+scalg*0.02f*(g.returnZ(18,4)+(maxZ-1.0f))); // H69
                coords[183*(N+1)] = new Point3f(-d7,d3, 0.0f);
                coords[184*(N+1)] = new Point3f(-d7,-d3, minZ-0.2f+scalg*0.02f*(g.returnZ(20,4)+(maxZ-1.0f))); // H70
                coords[185*(N+1)] = new Point3f(-d7,-d3, 0.0f);
                coords[186*(N+1)] = new Point3f(-d7,3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(16,4)+(maxZ-1.0f))); // H68
                coords[187*(N+1)] = new Point3f(-d7,3*d3, 0.0f);
                coords[188*(N+1)] = new Point3f(-d7,-3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(22,4)+(maxZ-1.0f))); // H71
                coords[189*(N+1)] = new Point3f(-d7,-3*d3, 0.0f);
                coords[190*(N+1)] = new Point3f(-d7,5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(14,4)+(maxZ-1.0f))); // H67
                coords[191*(N+1)] = new Point3f(-d7,5*d3, 0.0f);
                coords[192*(N+1)] = new Point3f(-d7,-5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(24,4)+(maxZ-1.0f))); // H72
                coords[193*(N+1)] = new Point3f(-d7,-5*d3, 0.0f);
                coords[194*(N+1)] = new Point3f(d7,d3, minZ-0.2f+scalg*0.02f*(g.returnZ(18,34)+(maxZ-1.0f))); // H85
                coords[195*(N+1)] = new Point3f(d7,d3, 0.0f);
                coords[196*(N+1)] = new Point3f(d7,-d3, minZ-0.2f+scalg*0.02f*(g.returnZ(20,34)+(maxZ-1.0f))); // H84
                coords[197*(N+1)] = new Point3f(d7,-d3, 0.0f);
                coords[198*(N+1)] = new Point3f(d7,3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(16,34)+(maxZ-1.0f))); // H86
                coords[199*(N+1)] = new Point3f(d7,3*d3, 0.0f);
                coords[200*(N+1)] = new Point3f(d7,-3*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(22,34)+(maxZ-1.0f))); // H83
                coords[201*(N+1)] = new Point3f(d7,-3*d3, 0.0f);
                coords[202*(N+1)] = new Point3f(d7,5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(14,34)+(maxZ-1.0f))); // H87
                coords[203*(N+1)] = new Point3f(d7,5*d3, 0.0f);
                coords[204*(N+1)] = new Point3f(d7,-5*d3, minZ-0.2f+scalg*0.02f*(g.returnZ(12,34)+(maxZ-1.0f))); // H82
                coords[205*(N+1)] = new Point3f(d7,-5*d3, 0.0f);
                
                for (int k=0; k<=204;k=k+2){
                    
                        if(k==0)       colors[k*(N+1)] = RetColor3D(true,maximo,minimo,19,19);
                        else if(k==2)  colors[k*(N+1)] = RetColor3D(true,maximo,minimo,17,19);
                        else if(k==4)  colors[k*(N+1)] = RetColor3D(true,maximo,minimo,21,19);
                        else if(k==6)  colors[k*(N+1)] = RetColor3D(true,maximo,minimo,15,19);
                        else if(k==8)  colors[k*(N+1)] = RetColor3D(true,maximo,minimo,23,19);
                        else if(k==10) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,13,19);
                        else if(k==12) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,25,19);
                        else if(k==14) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,11,19);
                        else if(k==16) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,27,19);
                        else if(k==18) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,9,19);
                        else if(k==20) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,29,19);
                        else if(k==22) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,18,16);
                        else if(k==24) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,20,16);
                        else if(k==26) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,16,16);
                        else if(k==28) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,22,16);
                        else if(k==30) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,14,16);
                        else if(k==32) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,24,16);
                        else if(k==34) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,12,16);
                        else if(k==36) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,26,16);
                        else if(k==38) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,10,16);
                        else if(k==40) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,28,16);
                        else if(k==42) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,18,22);
                        else if(k==44) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,20,22);
                        else if(k==46) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,16,22);
                        else if(k==48) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,22,22);
                        else if(k==50) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,14,22);
                        else if(k==52) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,24,22);
                        else if(k==54) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,12,22);
                        else if(k==56) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,26,22);
                        else if(k==58) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,10,22);
                        else if(k==60) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,28,22);
                        else if(k==62) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,19,13);
                        else if(k==64) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,17,13);
                        else if(k==66) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,21,13);
                        else if(k==68) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,15,13);
                        else if(k==70) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,23,13);
                        else if(k==72) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,13,13);
                        else if(k==74) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,25,13);
                        else if(k==76) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,11,13);
                        else if(k==78) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,27,13);
                        else if(k==80) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,9,13);
                        else if(k==82) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,29,13);
                        else if(k==84) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,19,25);
                        else if(k==86) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,17,25);
                        else if(k==88) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,21,25);
                        else if(k==90) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,15,25);
                        else if(k==92) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,23,25);
                        else if(k==94) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,13,25);
                        else if(k==96) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,25,25);
                        else if(k==98) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,11,25);
                        else if(k==100) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,27,25);
                        else if(k==102) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,9,25);
                        else if(k==104) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,29,25);
                        else if(k==106) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,18,10);
                        else if(k==108) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,20,10);
                        else if(k==110) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,16,10);
                        else if(k==112) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,22,10);
                        else if(k==114) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,14,10);
                        else if(k==116) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,24,10);
                        else if(k==118) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,12,10);
                        else if(k==120) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,26,10);
                        else if(k==122) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,10,10);
                        else if(k==124) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,28,10);
                        else if(k==126) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,18,28);
                        else if(k==128) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,20,28);
                        else if(k==130) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,16,28);
                        else if(k==132) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,22,28);
                        else if(k==134) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,14,28);
                        else if(k==136) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,24,28);
                        else if(k==138) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,12,28);
                        else if(k==140) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,26,28);
                        else if(k==142) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,10,28);
                        else if(k==144) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,28,28);
                        else if(k==146) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,19,31);
                        else if(k==148) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,17,31);
                        else if(k==150) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,21,31);
                        else if(k==152) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,15,31);
                        else if(k==154) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,23,31);
                        else if(k==156) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,13,31);
                        else if(k==158) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,25,31);
                        else if(k==160) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,11,31);
                        else if(k==162) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,27,31);
                        else if(k==164) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,19,7);
                        else if(k==166) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,17,7);
                        else if(k==168) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,21,7);
                        else if(k==170) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,15,7);
                        else if(k==172) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,23,7);
                        else if(k==174) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,13,7);
                        else if(k==176) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,25,7);
                        else if(k==178) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,11,7);
                        else if(k==180) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,27,7);
                        else if(k==182) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,18,4);
                        else if(k==184) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,20,4);
                        else if(k==186) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,16,4);
                        else if(k==188) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,22,4);
                        else if(k==190) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,14,4);
                        else if(k==192) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,24,4);
                        else if(k==194) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,18,34);
                        else if(k==196) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,20,34);
                        else if(k==198) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,16,34);
                        else if(k==200) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,22,34);
                        else if(k==202) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,14,34);
                        else if(k==204) colors[k*(N+1)] = RetColor3D(true,maximo,minimo,12,34);
                        colors[(k+1)*(N+1)] = new Color3f(0.51f,0.35f,0.0f);
                }
                
                for(a = 0,n = 0; n < N; a = 2.0*Math.PI/(N-1) * ++n){                    
                                      
                        x = (float) (r * Math.cos(a));
                        y = (float) (r * Math.sin(a));
                        
                        
                        coords[0*(N+1)+n+1] = RetcorCont(n,x, y, 19,21);
                        coords[1*(N+1)+N-n] = RetcorCont(n,x, y, 19,21);
                        coords[2*(N+1)+n+1] = RetcorCont(n,x, y+d1,17,21);
                        coords[3*(N+1)+N-n] = RetcorCont(n,x, y+d1,17,21);   
                        coords[4*(N+1)+n+1] = RetcorCont(n,x, y-d1,21,21);
                        coords[5*(N+1)+N-n] = RetcorCont(n,x, y-d1,21,21);
                        coords[6*(N+1)+n+1] = RetcorCont(n,x, y+2*d1,15,21);
                        coords[7*(N+1)+N-n] = RetcorCont(n,x, y+2*d1,15,21);            
                        coords[8*(N+1)+n+1] = RetcorCont(n,x, y-2*d1,23,21);
                        coords[9*(N+1)+N-n] = RetcorCont(n,x, y-2*d1,23,21);
                        coords[10*(N+1)+n+1] = RetcorCont(n,x, y+3*d1,13,21);
                        coords[11*(N+1)+N-n] = RetcorCont(n,x, y+3*d1,13,21);
                        coords[10*(N+1)+n+1] = RetcorCont(n,x, y+3*d1,13,21);
                        coords[11*(N+1)+N-n] = RetcorCont(n,x, y+3*d1,13,21);
                        coords[12*(N+1)+n+1] = RetcorCont(n,x, y-3*d1,25,21);
                        coords[13*(N+1)+N-n] = RetcorCont(n,x, y-3*d1,25,21);                        
                        coords[14*(N+1)+n+1] = RetcorCont(n,x, y+4*d1,11,21);
                        coords[15*(N+1)+N-n] = RetcorCont(n,x, y+4*d1,11,21);
                        coords[16*(N+1)+n+1] = RetcorCont(n,x, y-4*d1,27,21);
                        coords[17*(N+1)+N-n] = RetcorCont(n,x, y-4*d1,27,21);
                        coords[18*(N+1)+n+1] = RetcorCont(n,x, y+5*d1,9,21);
                        coords[19*(N+1)+N-n] = RetcorCont(n,x, y+5*d1,9,21);
                        coords[20*(N+1)+n+1] = RetcorCont(n,x, y-5*d1,29,21);
                        coords[21*(N+1)+N-n] = RetcorCont(n,x, y-5*d1,29,21);
                        coords[22*(N+1)+n+1] = RetcorCont(n,x-d2, y+d3, 18,18);
                        coords[23*(N+1)+N-n] = RetcorCont(n,x-d2, y+d3, 18,18);
                        coords[24*(N+1)+n+1] = RetcorCont(n,x-d2, y-d3, 20,18);
                        coords[25*(N+1)+N-n] = RetcorCont(n,x-d2, y-d3, 20,18);
                        coords[26*(N+1)+n+1] = RetcorCont(n,x-d2, y+3*d3, 16,18);
                        coords[27*(N+1)+N-n] = RetcorCont(n,x-d2, y+3*d3, 16,18);
                        coords[28*(N+1)+n+1] = RetcorCont(n,x-d2, y-3*d3, 22,18);
                        coords[29*(N+1)+N-n] = RetcorCont(n,x-d2, y-3*d3, 22,18);
                        coords[30*(N+1)+n+1] = RetcorCont(n,x-d2, y+5*d3, 14,18);
                        coords[31*(N+1)+N-n] = RetcorCont(n,x-d2, y+5*d3, 14,18);             
                        coords[32*(N+1)+n+1] = RetcorCont(n,x-d2, y-5*d3, 24,18);
                        coords[33*(N+1)+N-n] = RetcorCont(n,x-d2, y-5*d3, 24,18);
                        coords[34*(N+1)+n+1] = RetcorCont(n,x-d2, y+7*d3, 12,18);
                        coords[35*(N+1)+N-n] = RetcorCont(n,x-d1, y+7*d3, 12,18);
                        coords[36*(N+1)+n+1] = RetcorCont(n,x-d2, y-7*d3, 26,18);
                        coords[37*(N+1)+N-n] = RetcorCont(n,x-d2, y-7*d3, 26,18);
                        coords[38*(N+1)+n+1] = RetcorCont(n,x-d2, y+9*d3, 10,18);
                        coords[39*(N+1)+N-n] = RetcorCont(n,x-d2, y+9*d3, 10,18);
                        coords[40*(N+1)+n+1] = RetcorCont(n,x-d2, y-9*d3, 28,18);
                         coords[41*(N+1)+N-n] = RetcorCont(n,x-d2, y-9*d3, 28,18);
                         coords[42*(N+1)+n+1] = RetcorCont(n,x+d2, y+d3, 18,24);
                         coords[43*(N+1)+N-n] = RetcorCont(n,x+d2, y+d3, 18,24);
                         coords[44*(N+1)+n+1] = RetcorCont(n,x+d2, y-d3, 20,24);
                         coords[45*(N+1)+N-n] = RetcorCont(n,x+d2, y-d3, 20,24);
                         coords[46*(N+1)+n+1] = RetcorCont(n,x+d2, y+3*d3, 16,24);
                         coords[47*(N+1)+N-n] = RetcorCont(n,x+d2, y+3*d3, 16,24);
                         coords[48*(N+1)+n+1] = RetcorCont(n,x+d2, y-3*d3, 22,24);
                         coords[49*(N+1)+N-n] = RetcorCont(n,x+d2, y-3*d3, 22,24);
                         coords[50*(N+1)+n+1] = RetcorCont(n,x+d2, y+5*d3, 14,24);
                         coords[51*(N+1)+N-n] = RetcorCont(n,x+d2, y+5*d3, 14,24);
                         coords[52*(N+1)+n+1] = RetcorCont(n,x+d2, y-5*d3, 24,24);
                         coords[53*(N+1)+N-n] = RetcorCont(n,x+d2, y-5*d3, 24,24);
                         coords[54*(N+1)+n+1] = RetcorCont(n,x+d2, y+7*d3, 12,24);
                         coords[55*(N+1)+N-n] = RetcorCont(n,x+d2, y+7*d3, 12,24);
                         coords[56*(N+1)+n+1] = RetcorCont(n,x+d2, y-7*d3, 26,24);
                         coords[57*(N+1)+N-n] = RetcorCont(n,x+d2, y-7*d3, 26,24);
                         coords[58*(N+1)+n+1] = RetcorCont(n,x+d2, y+9*d3, 10,24);
                         coords[59*(N+1)+N-n] = RetcorCont(n,x+d2, y+9*d3, 10,24);
                         coords[60*(N+1)+n+1] = RetcorCont(n,x+d2, y-9*d3, 28,24);
                         coords[61*(N+1)+N-n] = RetcorCont(n,x+d2, y-9*d3, 28,24);
                         coords[62*(N+1)+n+1] = RetcorCont(n,x-d4, y, 19,15);
                         coords[63*(N+1)+N-n] = RetcorCont(n,x-d4, y, 19,15);
                         coords[64*(N+1)+n+1] = RetcorCont(n,x-d4, y+d1,17,15);
                         coords[65*(N+1)+N-n] = RetcorCont(n,x-d4, y+d1,17,15);
                         coords[66*(N+1)+n+1] = RetcorCont(n,x-d4, y-d1,21,15);
                         coords[67*(N+1)+N-n] = RetcorCont(n,x-d4, y-d1,21,15);
                         coords[68*(N+1)+n+1] = RetcorCont(n,x-d4, y+2*d1,15,15);
                         coords[69*(N+1)+N-n] = RetcorCont(n,x-d4, y+2*d1,15,15);
                         coords[70*(N+1)+n+1] = RetcorCont(n,x-d4, y-2*d1,23,15);
                         coords[71*(N+1)+N-n] = RetcorCont(n,x-d4, y-2*d1,23,15);
                         coords[72*(N+1)+n+1] = RetcorCont(n,x-d4, y+3*d1,13,15);
                         coords[73*(N+1)+N-n] = RetcorCont(n,x-d4, y+3*d1,13,15);
                         coords[74*(N+1)+n+1] = RetcorCont(n,x-d4, y-3*d1,25,15);
                         coords[75*(N+1)+N-n] = RetcorCont(n,x-d4, y-3*d1,25,15);
                         coords[76*(N+1)+n+1] = RetcorCont(n,x-d4, y+4*d1,11,15);
                         coords[77*(N+1)+N-n] = RetcorCont(n,x-d4, y+4*d1,11,15);
                         coords[78*(N+1)+n+1] = RetcorCont(n,x-d4, y-4*d1,27,15);
                         coords[79*(N+1)+N-n] = RetcorCont(n,x-d4, y-4*d1,27,15);
                         coords[80*(N+1)+n+1] = RetcorCont(n,x-d4, y+5*d1,9,15);
                         coords[81*(N+1)+N-n] = RetcorCont(n,x-d4, y+5*d1,9,15);
                         coords[82*(N+1)+n+1] = RetcorCont(n,x-d4, y-5*d1,29,15);
                         coords[83*(N+1)+n+1] = RetcorCont(n,x-d4, y-5*d1,29,15);
                         coords[84*(N+1)+n+1] = RetcorCont(n,x+d4, y, 19,27);
                         coords[85*(N+1)+N-n] = RetcorCont(n,x+d4, y, 19,27);
                         coords[86*(N+1)+n+1] = RetcorCont(n,x+d4, y+d1,17,27);
                         coords[87*(N+1)+N-n] = RetcorCont(n,x+d4, y+d1,17,27);
                         coords[88*(N+1)+n+1] = RetcorCont(n,x+d4, y-d1,21,27);
                         coords[89*(N+1)+N-n] = RetcorCont(n,x+d4, y-d1,21,27);
                         coords[90*(N+1)+n+1] = RetcorCont(n,x+d4, y+2*d1,15,27);
                         coords[91*(N+1)+N-n] = RetcorCont(n,x+d4, y+2*d1,15,27);
                         coords[92*(N+1)+n+1] = RetcorCont(n,x+d4, y-2*d1,23,27);
                         coords[93*(N+1)+N-n] = RetcorCont(n,x+d4, y-2*d1,23,27);
                         coords[94*(N+1)+n+1] = RetcorCont(n,x+d4, y+3*d1,13,27);
                         coords[95*(N+1)+N-n] = RetcorCont(n,x+d4, y+3*d1,13,27);
                         coords[96*(N+1)+n+1] = RetcorCont(n,x+d4, y-3*d1,25,27);
                         coords[97*(N+1)+N-n] = RetcorCont(n,x+d4, y-3*d1,25,27);
                         coords[98*(N+1)+n+1] = RetcorCont(n,x+d4,y+4*d1,11,27);
                         coords[99*(N+1)+N-n] = RetcorCont(n,x+d4,y+4*d1,11,27);
                         coords[100*(N+1)+n+1] = RetcorCont(n,x+d4, y-4*d1,27,27);
                         coords[101*(N+1)+N-n] = RetcorCont(n,x+d4, y-4*d1,27,27);
                         coords[102*(N+1)+n+1] = RetcorCont(n,x+d4, y+5*d1,9,27);
                         coords[103*(N+1)+N-n] = RetcorCont(n,x+d4, y+5*d1,9,27);
                         coords[104*(N+1)+n+1] = RetcorCont(n,x+d4, y-5*d1,29,27);
                         coords[105*(N+1)+n+1] = RetcorCont(n,x+d4, y-5*d1,29,27);
                         coords[106*(N+1)+n+1] = RetcorCont(n,x-d5, y+d3, 18,12);
                         coords[107*(N+1)+N-n] = RetcorCont(n,x-d5, y+d3, 18,12);
                         coords[108*(N+1)+n+1] = RetcorCont(n,x-d5, y-d3, 20,12);
                         coords[109*(N+1)+N-n] = RetcorCont(n,x-d5, y-d3, 20,12);
                         coords[110*(N+1)+n+1] = RetcorCont(n,x-d5, y+3*d3, 16,12);
                         coords[111*(N+1)+N-n] = RetcorCont(n,x-d5, y+3*d3, 16,12);
                         coords[112*(N+1)+n+1] = RetcorCont(n,x-d5, y-3*d3, 22,12);
                         coords[113*(N+1)+N-n] = RetcorCont(n,x-d5, y-3*d3, 22,12);
                         coords[114*(N+1)+n+1] = RetcorCont(n,x-d5, y+5*d3, 14,12);
                         coords[115*(N+1)+N-n] = RetcorCont(n,x-d5, y+5*d3, 14,12);
                         coords[116*(N+1)+n+1] = RetcorCont(n,x-d5, y-5*d3, 24,12);
                         coords[117*(N+1)+N-n] = RetcorCont(n,x-d5, y-5*d3, 24,12);
                         coords[118*(N+1)+n+1] = RetcorCont(n,x-d5, y+7*d3, 12,12);
                         coords[119*(N+1)+N-n] = RetcorCont(n,x-d5, y+7*d3, 12,12);
                        coords[120*(N+1)+n+1] = RetcorCont(n,x-d5, y-7*d3, 26,12);
                        coords[121*(N+1)+N-n] = RetcorCont(n,x-d5, y-7*d3, 26,12);
                        coords[122*(N+1)+n+1] = RetcorCont(n,x-d5, y+9*d3, 10,12);
                        coords[123*(N+1)+N-n] = RetcorCont(n,x-d5, y+9*d3, 10,12);
                        coords[124*(N+1)+n+1] = RetcorCont(n,x-d5, y-9*d3, 28,12);
                        coords[125*(N+1)+N-n] = RetcorCont(n,x-d5, y-9*d3, 28,12);
                        coords[126*(N+1)+n+1] = RetcorCont(n,x+d5, y+d3, 18,30);
                        coords[127*(N+1)+N-n] = RetcorCont(n,x+d5, y+d3, 18,30);
                        coords[128*(N+1)+n+1] = RetcorCont(n,x+d5, y-d3, 20,30);
                        coords[129*(N+1)+N-n] = RetcorCont(n,x+d5, y-d3, 20,30);
                        coords[130*(N+1)+n+1] = RetcorCont(n,x+d5, y+3*d3, 16,30);
                        coords[131*(N+1)+N-n] = RetcorCont(n,x+d5, y+3*d3, 16,30);
                        coords[132*(N+1)+n+1] = RetcorCont(n,x+d5, y-3*d3, 22,30);
                        coords[133*(N+1)+N-n] = RetcorCont(n,x+d5, y-3*d3, 22,30);
                        coords[134*(N+1)+n+1] = RetcorCont(n,x+d5, y+5*d3, 14,30);
                        coords[135*(N+1)+N-n] = RetcorCont(n,x+d5, y+5*d3, 14,30);
                        coords[136*(N+1)+n+1] = RetcorCont(n,x+d5, y-5*d3, 24,30);
                        coords[137*(N+1)+N-n] = RetcorCont(n,x+d5, y-5*d3, 24,30);
                        coords[138*(N+1)+n+1] = RetcorCont(n,x+d5, y+7*d3, 12,30);
                        coords[139*(N+1)+N-n] = RetcorCont(n,x+d5, y+7*d3, 12,30);
                        coords[140*(N+1)+n+1] = RetcorCont(n,x+d5, y-7*d3, 26,30);
                        coords[141*(N+1)+N-n] = RetcorCont(n,x+d5, y-7*d3, 26,30);
                        coords[142*(N+1)+n+1] = RetcorCont(n,x+d5, y+9*d3, 10,30);
                        coords[143*(N+1)+N-n] = RetcorCont(n,x+d5, y+9*d3, 10,30);
                        coords[144*(N+1)+n+1] = RetcorCont(n,x+d5, y-9*d3, 28,30);
                        coords[145*(N+1)+N-n] = RetcorCont(n,x+d5, y-9*d3, 28,30);
                        coords[146*(N+1)+n+1] = RetcorCont(n,x+d6, y, 19,33);
                        coords[147*(N+1)+N-n] = RetcorCont(n,x+d6, y, 19,33);
                        coords[148*(N+1)+n+1] = RetcorCont(n,x+d6, y+d1,17,33);
                        coords[149*(N+1)+N-n] = RetcorCont(n,x+d6, y+d1,17,33);
                        coords[150*(N+1)+n+1] = RetcorCont(n,x+d6, y-d1, 21,33);
                        coords[151*(N+1)+N-n] = RetcorCont(n,x+d6, y-d1, 21,33);
                        coords[152*(N+1)+n+1] = RetcorCont(n,x+d6, y+2*d1,15,33);
                        coords[153*(N+1)+N-n] = RetcorCont(n,x+d6, y+2*d1,15,33);
                        coords[154*(N+1)+n+1] = RetcorCont(n,x+d6, y-2*d1, 23,33);
                        coords[155*(N+1)+N-n] = RetcorCont(n,x+d6, y-2*d1, 23,33);
                        coords[156*(N+1)+n+1] = RetcorCont(n,x+d6, y+3*d1,13,33);
                        coords[157*(N+1)+N-n] = RetcorCont(n,x+d6, y+3*d1,13,33);
                        coords[158*(N+1)+n+1] = RetcorCont(n,x+d6, y-3*d1,25,33);
                        coords[159*(N+1)+N-n] = RetcorCont(n,x+d6, y-3*d1,25,33);
                        coords[160*(N+1)+n+1] = RetcorCont(n,x+d6, y+4*d1,11,33);
                        coords[161*(N+1)+N-n] = RetcorCont(n,x+d6, y+4*d1,11,33);
                        coords[162*(N+1)+n+1] = RetcorCont(n,x+d6, y-4*d1,27,33);
                        coords[163*(N+1)+N-n] = RetcorCont(n,x+d6, y-4*d1,27,33);
                        coords[164*(N+1)+n+1] = RetcorCont(n,x-d6, y, 19,9);
                        coords[165*(N+1)+N-n] = RetcorCont(n,x-d6, y, 19,9);
                        coords[166*(N+1)+n+1] = RetcorCont(n,x-d6, y+d1,17,9);
                        coords[167*(N+1)+N-n] = RetcorCont(n,x-d6, y+d1,17,9);
                        coords[168*(N+1)+n+1] = RetcorCont(n,x-d6, y-d1,21,9);
                        coords[169*(N+1)+N-n] = RetcorCont(n,x-d6, y-d1,21,9);
                        coords[170*(N+1)+n+1] = RetcorCont(n,x-d6, y+2*d1,15,9);
                        coords[171*(N+1)+N-n] = RetcorCont(n,x-d6, y+2*d1,15,9);
                        coords[172*(N+1)+n+1] = RetcorCont(n,x-d6, y-2*d1,23,9);
                        coords[173*(N+1)+N-n] = RetcorCont(n,x-d6, y-2*d1,23,9);
                        coords[174*(N+1)+n+1] = RetcorCont(n,x-d6, y+3*d1,13,9);
                        coords[175*(N+1)+N-n] = RetcorCont(n,x-d6, y+3*d1,13,9);
                        coords[176*(N+1)+n+1] = RetcorCont(n,x-d6, y-3*d1,25,9);
                        coords[177*(N+1)+N-n] = RetcorCont(n,x-d6, y-3*d1,25,9);
                        coords[178*(N+1)+n+1] = RetcorCont(n,x-d6, y+4*d1,11,9);
                        coords[179*(N+1)+N-n] = RetcorCont(n,x-d6, y+4*d1,11,9);
                        coords[180*(N+1)+n+1] = RetcorCont(n,x-d6, y-4*d1,27,9);
                        coords[181*(N+1)+N-n] = RetcorCont(n,x-d6, y-4*d1,27,9);
                        coords[182*(N+1)+n+1] = RetcorCont(n,x-d7, y+d3, 18,6);
                        coords[183*(N+1)+N-n] = RetcorCont(n,x-d7, y+d3, 18,6);
                        coords[184*(N+1)+n+1] = RetcorCont(n,x-d7, y-d3, 20,6);
                        coords[185*(N+1)+N-n] = RetcorCont(n,x-d7, y-d3, 20,6);
                        coords[186*(N+1)+n+1] = RetcorCont(n,x-d7, y+3*d3, 16,6);
                        coords[187*(N+1)+N-n] = RetcorCont(n,x-d7, y+3*d3, 16,6);
                        coords[188*(N+1)+n+1] = RetcorCont(n,x-d7, y-3*d3, 22,6);
                        coords[189*(N+1)+N-n] = RetcorCont(n,x-d7, y-3*d3, 22,6);
                        coords[190*(N+1)+n+1] = RetcorCont(n,x-d7, y+5*d3, 14,6);
                        coords[191*(N+1)+N-n] = RetcorCont(n,x-d7, y+5*d3, 14,6);
                        coords[192*(N+1)+n+1] = RetcorCont(n,x-d7, y-5*d3, 24,6);
                        coords[193*(N+1)+N-n] = RetcorCont(n,x-d7, y-5*d3, 24,6);
                        coords[194*(N+1)+n+1] = RetcorCont(n,x+d7, y+d3, 18,36);
                        coords[195*(N+1)+N-n] = RetcorCont(n,x+d7, y+d3, 18,36);
                        coords[196*(N+1)+n+1] = RetcorCont(n,x+d7, y-d3, 20,36);
                        coords[197*(N+1)+N-n] = RetcorCont(n,x+d7, y-d3, 20,36);
                        coords[198*(N+1)+n+1] = RetcorCont(n,x+d7, y+3*d3, 16,36);
                        coords[199*(N+1)+N-n] = RetcorCont(n,x+d7, y+3*d3, 16,36);
                        coords[200*(N+1)+n+1] = RetcorCont(n,x+d7, y-3*d3, 22,36);
                        coords[201*(N+1)+N-n] = RetcorCont(n,x+d7, y-3*d3, 22,36);
                        coords[202*(N+1)+n+1] = RetcorCont(n,x+d7, y+5*d3, 14,36);
                        coords[203*(N+1)+N-n] = RetcorCont(n,x+d7, y+5*d3, 14,36);
                        coords[204*(N+1)+n+1] = RetcorCont(n,x+d7, y-5*d3, 24,36);
                        coords[205*(N+1)+N-n] = RetcorCont(n,x+d7, y-5*d3, 24,36);
                        
                        
                        for (int k=0; k<=204;k=k+2){
                            
                        if(k==0)      colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,19,19);
                        else if(k==2) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,17,19);
                        else if(k==4) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,21,19);
                        else if(k==6) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,15,19);
                        else if(k==8) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,23,19);
                        else if(k==10) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,13,19);
                        else if(k==12) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,25,19);
                        else if(k==14) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,11,19);
                        else if(k==16) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,27,19);
                        else if(k==18) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,9,19);
                        else if(k==20) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,29,19);
                        else if(k==22) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,18,16);
                        else if(k==24) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,20,16);
                        else if(k==26) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,16,16);
                        else if(k==28) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,22,16);
                        else if(k==30) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,14,16);
                        else if(k==32) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,24,16);
                        else if(k==34) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,12,16);
                        else if(k==36) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,26,16);
                        else if(k==38) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,10,16);
                        else if(k==40) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,28,16);
                        else if(k==42) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,18,22);
                        else if(k==44) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,20,22);
                        else if(k==46) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,16,22);
                        else if(k==48) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,22,22);
                        else if(k==50) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,14,22);
                        else if(k==52) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,24,22);
                        else if(k==54) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,12,22);
                        else if(k==56) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,26,22);
                        else if(k==58) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,10,22);
                        else if(k==60) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,28,22);
                        else if(k==62) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,19,13);
                        else if(k==64) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,17,13);
                        else if(k==66) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,21,13);
                        else if(k==68) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,15,13);
                        else if(k==70) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,23,13);
                        else if(k==72) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,13,13);
                        else if(k==74) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,25,13);
                        else if(k==76) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,11,13);
                        else if(k==78) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,27,13);
                        else if(k==80) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,9,13);
                        else if(k==82) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,29,13);
                        else if(k==84) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,19,25);
                        else if(k==86) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,17,25);
                        else if(k==88) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,21,25);
                        else if(k==90) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,15,25);
                        else if(k==92) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,23,25);
                        else if(k==94) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,13,25);
                        else if(k==96) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,25,25);
                        else if(k==98) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,11,25);
                        else if(k==100) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,27,25);
                        else if(k==102) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,9,25);
                        else if(k==104) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,29,25);
                        else if(k==106) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,18,10);
                        else if(k==108) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,20,10);
                        else if(k==110) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,16,10);
                        else if(k==112) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,22,10);
                        else if(k==114) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,14,10);
                        else if(k==116) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,24,10);
                        else if(k==118) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,12,10);
                        else if(k==120) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,26,10);
                        else if(k==122) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,10,10);
                        else if(k==124) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,28,10);
                        else if(k==126) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,18,28);
                        else if(k==128) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,20,28);
                        else if(k==130) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,16,28);
                        else if(k==132) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,22,28);
                        else if(k==134) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,14,28);
                        else if(k==136) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,24,28);
                        else if(k==138) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,12,28);
                        else if(k==140) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,26,28);
                        else if(k==142) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,10,28);
                        else if(k==144) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,28,28);
                        else if(k==146) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,19,31);
                        else if(k==148) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,17,31);
                        else if(k==150) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,21,31);
                        else if(k==152) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,15,31);
                        else if(k==154) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,23,31);
                        else if(k==156) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,13,31);
                        else if(k==158) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,25,31);
                        else if(k==160) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,11,31);
                        else if(k==162) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,27,31);
                        else if(k==164) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,19,7);
                        else if(k==166) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,17,7);
                        else if(k==168) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,21,7);
                        else if(k==170) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,15,7);
                        else if(k==172) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,23,7);
                        else if(k==174) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,13,7);
                        else if(k==176) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,25,7);
                        else if(k==178) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,11,7);
                        else if(k==180) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,27,7);
                        else if(k==182) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,18,4);
                        else if(k==184) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,20,4);
                        else if(k==186) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,16,4);
                        else if(k==188) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,22,4);
                        else if(k==190) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,14,4);
                        else if(k==192) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,24,4);
                        else if(k==194) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,18,34);
                        else if(k==196) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,20,34);
                        else if(k==198) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,16,34);
                        else if(k==200) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,22,34);
                        else if(k==202) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,14,34);
                        else if(k==204) colors[k*(N+1)+N-n] = RetColor3D(true,maximo,minimo,12,34);
                        colors[(k+1)*(N+1)+N-n] = new Color3f(0.0f,0.0f,0.4f);
                        }

                }
     
        tfa = new TriangleFanArray (totalN,TriangleFanArray.COORDINATES | TriangleFanArray.COLOR_3,stripCounts);
        tfa.setCoordinates(0, coords);
        tfa.setColors(0,colors);

        return tfa;

	} 

    public Point3f RetcorCont(int n,float par1, float par2, int x, int y){
        
        Point3f r = null;
        if(n==0) r= new Point3f(par1,par2,minZ-0.2f+scalg*0.02f*(g.returnZ(x,y)+(maxZ-1.0f)));
        if(n==1) r= new Point3f(par1,par2,minZ-0.2f+scalg*0.02f*(g.returnZ(x-1,y-1)+(maxZ-1.0f)));
        if(n==2) r= new Point3f(par1,par2,minZ-0.2f+scalg*0.02f*(g.returnZ(x-1,y-3)+(maxZ-1.0f)));
        if(n==3) r= new Point3f(par1,par2,minZ-0.2f+scalg*0.02f*(g.returnZ(x,y-4)+(maxZ-1.0f)));
        if(n==4) r= new Point3f(par1,par2,minZ-0.2f+scalg*0.02f*(g.returnZ(x+1,y-3)+(maxZ-1.0f)));
        if(n==5) r= new Point3f(par1,par2,minZ-0.2f+scalg*0.02f*(g.returnZ(x+1,y-1)+(maxZ-1.0f)));
        if(n==6) r= new Point3f(par1,par2,minZ-0.2f+scalg*0.02f*(g.returnZ(x,y)+(maxZ-1.0f)));
        
       return r;
    }

        public Color3f RetColor3D(boolean r, double maximo, double minimo,int x, int y) {
            
            Color3f m = new Color3f();
     
        if(g.returnZ(x,y)>=minimo && g.returnZ(x,y)<maximo-maximo*0.96){m = new Color3f(0.086f,0.086f,0.086f);cx[0]=true;xmedsel=xminsel=0;
                    if(hexmx[0]>=g.returnZ(x,y))hexmx[0] = hexmx[0]; 
                    else if(hexmx[0]<g.returnZ(x,y))hexmx[0] = g.returnZ(x,y);
                    if(hexmn[0]<=g.returnZ(x,y))hexmn[0] = hexmn[0];
                    else if(hexmn[0]>g.returnZ(x,y))hexmn[0] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.96 && g.returnZ(x,y)<maximo-maximo*0.92){m = new Color3f(0.343f,0.108f,0.587f);cx[1]=true;xmedsel=xminsel=1;
                    if(hexmx[1]>=g.returnZ(x,y))hexmx[1] = hexmx[1]; 
                    else if(hexmx[1]<g.returnZ(x,y))hexmx[1] = g.returnZ(x,y);
                    if(hexmn[1]<=g.returnZ(x,y))hexmn[1] = hexmn[1];
                    else if(hexmn[1]>g.returnZ(x,y))hexmn[1] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.92 && g.returnZ(x,y)<maximo-maximo*0.88){m = new Color3f(0.612f,0.108f,0.587f);cx[2]=true;xmedsel=xminsel=2;
                    if(hexmx[2]>=g.returnZ(x,y))hexmx[2] = hexmx[2]; 
                    else if(hexmx[2]<g.returnZ(x,y))hexmx[2] = g.returnZ(x,y);
                    if(hexmn[2]<=g.returnZ(x,y))hexmn[2] = hexmn[2];
                    else if(hexmn[2]>g.returnZ(x,y))hexmn[2] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.88 && g.returnZ(x,y)<maximo-maximo*0.84){m = new Color3f(0.636f,0.353f,0.453f);cx[3]=true;xmedsel=xminsel=3;
                    if(hexmx[3]>=g.returnZ(x,y))hexmx[3] = hexmx[3]; 
                    else if(hexmx[3]<g.returnZ(x,y))hexmx[3] = g.returnZ(x,y);
                    if(hexmn[3]<=g.returnZ(x,y))hexmn[3] = hexmn[3];
                    else if(hexmn[3]>g.returnZ(x,y))hexmn[3] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.84 && g.returnZ(x,y)<maximo-maximo*0.80){m = new Color3f(0.343f,0.108f,0.893f);cx[4]=true;xmedsel=xminsel=4;
                    if(hexmx[4]>=g.returnZ(x,y))hexmx[4] = hexmx[4]; 
                    else if(hexmx[4]<g.returnZ(x,y))hexmx[4] = g.returnZ(x,y);
                    if(hexmn[4]<=g.returnZ(x,y))hexmn[4] = hexmn[4];
                    else if(hexmn[4]>g.returnZ(x,y))hexmn[4] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.80 && g.returnZ(x,y)<maximo-maximo*0.76){m = new Color3f(0.0f,0.120f,0.841f);cx[5]=true;xmedsel=xminsel=5;
                    if(hexmx[5]>=g.returnZ(x,y))hexmx[5] = hexmx[5]; 
                    else if(hexmx[5]<g.returnZ(x,y))hexmx[5] = g.returnZ(x,y);
                    if(hexmn[5]<=g.returnZ(x,y))hexmn[5] = hexmn[5];
                    else if(hexmn[5]>g.returnZ(x,y))hexmn[5] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.76 && g.returnZ(x,y)<maximo-maximo*0.72){m = new Color3f(0.0f,0.0f,1.0f);cx[6]=true;xmedsel=xminsel=6;
                    if(hexmx[6]>=g.returnZ(x,y))hexmx[6] = hexmx[6]; 
                    else if(hexmx[6]<g.returnZ(x,y))hexmx[6] = g.returnZ(x,y);
                    if(hexmn[6]<=g.returnZ(x,y))hexmn[6] = hexmn[6];
                    else if(hexmn[6]>g.returnZ(x,y))hexmn[6] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.72 && g.returnZ(x,y)<maximo-maximo*0.68){m = new Color3f(0.0f,0.391f,0.511f);cx[7]=true;xmedsel=xminsel=7;
                    if(hexmx[7]>=g.returnZ(x,y))hexmx[7] = hexmx[7]; 
                    else if(hexmx[7]<g.returnZ(x,y))hexmx[7] = g.returnZ(x,y);
                    if(hexmn[7]<=g.returnZ(x,y))hexmn[7] = hexmn[7];
                    else if(hexmn[7]>g.returnZ(x,y))hexmn[7] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.68 && g.returnZ(x,y)<maximo-maximo*0.64){m = new Color3f(0.0f,0.45f,0.49f);cx[8]=true;xmedsel=xminsel=8;
                    if(hexmx[8]>=g.returnZ(x,y))hexmx[8] = hexmx[8]; 
                    else if(hexmx[8]<g.returnZ(x,y))hexmx[8] = g.returnZ(x,y);
                    if(hexmn[8]<=g.returnZ(x,y))hexmn[8] = hexmn[8];
                    else if(hexmn[8]>g.returnZ(x,y))hexmn[8] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.64 && g.returnZ(x,y)<maximo-maximo*0.60){m = new Color3f(0.0f,0.612f,0.511f);cx[9]=true;xmedsel=xminsel=9;
                    if(hexmx[9]>=g.returnZ(x,y))hexmx[9] = hexmx[9]; 
                    else if(hexmx[9]<g.returnZ(x,y))hexmx[9] = g.returnZ(x,y);
                    if(hexmn[9]<=g.returnZ(x,y))hexmn[9] = hexmn[9];
                    else if(hexmn[9]>g.returnZ(x,y))hexmn[9] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.60 && g.returnZ(x,y)<maximo-maximo*0.56){m = new Color3f(0.0f,0.734f,0.315f);cx[10]=true;xmedsel=xminsel=10;
                    if(hexmx[10]>=g.returnZ(x,y))hexmx[10] = hexmx[10]; 
                    else if(hexmx[10]<g.returnZ(x,y))hexmx[10] = g.returnZ(x,y);
                    if(hexmn[10]<=g.returnZ(x,y))hexmn[10] = hexmn[10];
                    else if(hexmn[10]>g.returnZ(x,y))hexmn[10] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.56 && g.returnZ(x,y)<maximo-maximo*0.52){m = new Color3f(0.0f,0.734f,0.114f);cx[11]=true;xmedsel=xminsel=11;
                    if(hexmx[11]>=g.returnZ(x,y))hexmx[11] = hexmx[11]; 
                    else if(hexmx[11]<g.returnZ(x,y))hexmx[11] = g.returnZ(x,y);
                    if(hexmn[11]<=g.returnZ(x,y))hexmn[11] = hexmn[11];
                    else if(hexmn[11]>g.returnZ(x,y))hexmn[11] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.52 && g.returnZ(x,y)<maximo-maximo*0.48){m = new Color3f(0.0f,0.86f,0.01f);cx[12]=true;xmedsel=xminsel=12;
                    if(hexmx[12]>=g.returnZ(x,y))hexmx[12] = hexmx[12]; 
                    else if(hexmx[12]<g.returnZ(x,y))hexmx[12] = g.returnZ(x,y);
                    if(hexmn[12]<=g.returnZ(x,y))hexmn[12] = hexmn[12];
                    else if(hexmn[12]>g.returnZ(x,y))hexmn[12] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.48 && g.returnZ(x,y)<maximo-maximo*0.44){m = new Color3f(0.758f,0.905f,0.440f);cx[13]=true;xmedsel=xminsel=13;
                    if(hexmx[13]>=g.returnZ(x,y))hexmx[13] = hexmx[13]; 
                    else if(hexmx[13]<g.returnZ(x,y))hexmx[13] = g.returnZ(x,y);
                    if(hexmn[13]<=g.returnZ(x,y))hexmn[13] = hexmn[13];
                    else if(hexmn[13]>g.returnZ(x,y))hexmn[13] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.44 && g.returnZ(x,y)<maximo-maximo*0.40){m = new Color3f(0.7f,0.8f,0.1f);cx[14]=true;xmedsel=xminsel=14;
                    if(hexmx[14]>=g.returnZ(x,y))hexmx[14] = hexmx[14]; 
                    else if(hexmx[14]<g.returnZ(x,y))hexmx[14] = g.returnZ(x,y);
                    if(hexmn[14]<=g.returnZ(x,y))hexmn[14] = hexmn[14];
                    else if(hexmn[14]>g.returnZ(x,y))hexmn[14] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.40 && g.returnZ(x,y)<maximo-maximo*0.36){m = new Color3f(0.795f,0.695f,0.073f);cx[15]=true;xmedsel=xminsel=15;
                    if(hexmx[15]>=g.returnZ(x,y))hexmx[15] = hexmx[15]; 
                    else if(hexmx[15]<g.returnZ(x,y))hexmx[15] = g.returnZ(x,y);
                    if(hexmn[15]<=g.returnZ(x,y))hexmn[15] = hexmn[15];
                    else if(hexmn[15]>g.returnZ(x,y))hexmn[15] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.36 && g.returnZ(x,y)<maximo-maximo*0.32){m = new Color3f(0.795f,0.620f,0.073f);cx[16]=true;xmedsel=xminsel=16;
                    if(hexmx[16]>=g.returnZ(x,y))hexmx[16] = hexmx[16]; 
                    else if(hexmx[16]<g.returnZ(x,y))hexmx[16] = g.returnZ(x,y);
                    if(hexmn[16]<=g.returnZ(x,y))hexmn[16] = hexmn[16];
                    else if(hexmn[16]>g.returnZ(x,y))hexmn[16] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.32 && g.returnZ(x,y)<maximo-maximo*0.28){m = new Color3f(0.795f,0.461f,0.073f);cx[17]=true;xmedsel=xminsel=17;
                    if(hexmx[17]>=g.returnZ(x,y))hexmx[17] = hexmx[17]; 
                    else if(hexmx[17]<g.returnZ(x,y))hexmx[17] = g.returnZ(x,y);
                    if(hexmn[17]<=g.returnZ(x,y))hexmn[17] = hexmn[17];
                    else if(hexmn[17]>g.returnZ(x,y))hexmn[17] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.28 && g.returnZ(x,y)<maximo-maximo*0.24){m = new Color3f(0.795f,0.421f,0.073f);cx[18]=true;xmedsel=xminsel=18;
                    if(hexmx[18]>=g.returnZ(x,y))hexmx[18] = hexmx[18]; 
                    else if(hexmx[18]<g.returnZ(x,y))hexmx[18] = g.returnZ(x,y);
                    if(hexmn[18]<=g.returnZ(x,y))hexmn[18] = hexmn[18];
                    else if(hexmn[18]>g.returnZ(x,y))hexmn[18] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.24 && g.returnZ(x,y)<maximo-maximo*0.20){m = new Color3f(0.795f,0.350f,0.073f);cx[19]=true;xmedsel=xminsel=19;
                    if(hexmx[19]>=g.returnZ(x,y))hexmx[19] = hexmx[19]; 
                    else if(hexmx[19]<g.returnZ(x,y))hexmx[19] = g.returnZ(x,y);
                    if(hexmn[19]<=g.returnZ(x,y))hexmn[19] = hexmn[19];
                    else if(hexmn[19]>g.returnZ(x,y))hexmn[19] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.20 && g.returnZ(x,y)<maximo-maximo*0.16){m = new Color3f(0.795f,0.250f,0.073f);cx[20]=true;xmedsel=xminsel=20;
                    if(hexmx[20]>=g.returnZ(x,y))hexmx[20] = hexmx[20]; 
                    else if(hexmx[20]<g.returnZ(x,y))hexmx[20] = g.returnZ(x,y);
                    if(hexmn[20]<=g.returnZ(x,y))hexmn[20] = hexmn[20];
                    else if(hexmn[20]>g.returnZ(x,y))hexmn[20] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.16 && g.returnZ(x,y)<maximo-maximo*0.12){m = new Color3f(0.795f,0.180f,0.073f);cx[21]=true;xmedsel=xminsel=21;
                    if(hexmx[21]>=g.returnZ(x,y))hexmx[21] = hexmx[21]; 
                    else if(hexmx[21]<g.returnZ(x,y))hexmx[21] = g.returnZ(x,y);
                    if(hexmn[21]<=g.returnZ(x,y))hexmn[21] = hexmn[21];
                    else if(hexmn[21]>g.returnZ(x,y))hexmn[21] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.12 && g.returnZ(x,y)<maximo-maximo*0.08){m = new Color3f(0.85f,0.120f,0.073f);cx[22]=true;xmedsel=xminsel=22;
                    if(hexmx[22]>=g.returnZ(x,y))hexmx[22] = hexmx[22]; 
                    else if(hexmx[22]<g.returnZ(x,y))hexmx[22] = g.returnZ(x,y);
                    if(hexmn[22]<=g.returnZ(x,y))hexmn[22] = hexmn[22];
                    else if(hexmn[22]>g.returnZ(x,y))hexmn[22] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.08 && g.returnZ(x,y)<maximo-maximo*0.04){m = new Color3f(1.0f,0.01f,0.013f);cx[23]=true;xmedsel=xminsel=23;
                    if(hexmx[23]>=g.returnZ(x,y))hexmx[23] = hexmx[23]; 
                    else if(hexmx[23]<g.returnZ(x,y))hexmx[23] = g.returnZ(x,y);
                    if(hexmn[23]<=g.returnZ(x,y))hexmn[23] = hexmn[23];
                    else if(hexmn[23]>g.returnZ(x,y))hexmn[23] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>=maximo-maximo*0.04 && g.returnZ(x,y)<=maximo+0.0001)    {m = new Color3f(1.0f,1.0f,1.0f);cx[24]=true;xmedsel=xminsel=24;
                    if(hexmx[24]>=g.returnZ(x,y))hexmx[24]= hexmx[24]; 
                    else if(hexmx[24]<g.returnZ(x,y))hexmx[24] = g.returnZ(x,y);
                    if(hexmn[24]<=g.returnZ(x,y))hexmn[24] = hexmn[24];
                    else if(hexmn[24]>g.returnZ(x,y))hexmn[24] = g.returnZ(x,y);}
        else if(g.returnZ(x,y)>maximo+0.0001) System.out.println("No Existe :"+g.returnZ(x,y)); 
             
            if(r){   
                if(hexmax>=g.returnZ(x,y))    {hexmax = hexmax; xo=xo; yo=yo;} // hexmax: Máximo Centroide
                else if(hexmax<g.returnZ(x,y)){hexmax = g.returnZ(x,y);xo=x; yo=y; }
                if(hexmin<=g.returnZ(x,y))    {hexmin = hexmin;xi=xi; yi=yi;} // hexmin: Minimo Centroide
                else if(hexmin>g.returnZ(x,y)){hexmin = g.returnZ(x,y);xi=x; yi=y;xminsel1=xminsel;}

                sumaHex= sumaHex+g.returnZ(x,y);
                Nhex = Nhex+1;
            }else if(!r){
                xm = x; 
                ym = y;
            }
                MaxMinHex(xo,yo,xi,yi);
                return m;
        }
  
    } // Fin de la Clase NoiseG2

    public Jed(){
     }
    
    public Jed(Test0 fr, String ojo) {
        initComponents();
        this.form = fr;
        this.scalg = (float)form.RetScalZ();
        this.g = new Gauss(0,0);
        this.g1 = new Gauss[103];
        this.line_onoff = form.RetlineON_OFF();
        this.enum_onoff = form.RetEnumON_OFF();
        this.minZ = (float)form.RetMinZ();
        this.maxZ = (float)form.RetMaxZ();
//        this.j = new DensK();
        this.setTitle("OJO "+ojo+" - Diagrama 3D mfERG V1.0 Cesar Peña");
        Canvas3D canvas3D = createCanvas3D();
        BranchGroup scene = createSceneGraph();
        conexion( canvas3D, scene);
        eje.setSelected(true);

        
    }
    private Canvas3D createCanvas3D() {
         getContentPane().setLayout(new BorderLayout());
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         GraphicsDevice gd = ge.getDefaultScreenDevice();
         GraphicsConfiguration config = gd.getDefaultConfiguration();//SimpleUniverse.getPreferredConfiguration();
         Canvas3D canvas3D = new Canvas3D(config);
         getContentPane().add(canvas3D);
         return canvas3D;
       }

       private void conexion(Canvas3D canvas3D, BranchGroup scene) {
         SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
         simpleU.getViewingPlatform().setNominalViewingTransform();
         simpleU.addBranchGraph(scene);
       }
    
   private BranchGroup createSceneGraph() {
       
      BranchGroup objRoot = new BranchGroup();
      BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
      Transform3D objTrans = new Transform3D();
      Transform3D objTrans2 = new Transform3D();
      Transform3D objTrans3 = new Transform3D();
      objTrans.rotX(-Math.PI/3.6f);
      objTrans2.rotZ(Math.PI/4.0f);
      objTrans3.set(new Vector3f(0.1f,0.0f,-0.2f));
      objTrans2.mul(objTrans3);
      objTrans.mul(objTrans2);
      TransformGroup w = new TransformGroup(objTrans);
      TransformGroup objRotate = new TransformGroup();
      objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      w.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      w.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
            
      objRoot.addChild(w);
      w.addChild(objRotate);
      Geometria_Noise= new NoiseG2();
      objRotate.addChild(Geometria_Noise);
      ejes=new Axis().getBG();
      ejes.ver(true);
      objRotate.addChild(ejes); 
      
//        Cuadros de Colores
         Color3f c[] = new Color3f[25];
         QuadArray qa[] = new QuadArray[25];
         for(int i=0;i<qa.length;i++){
             qa[i]= new QuadArray(4, QuadArray.COORDINATES |QuadArray.TEXTURE_COORDINATE_2|QuadArray.COLOR_3);
             qa[i].setCoordinate(0, new Point3f(-0.06f, 0.05f, -5.0f));
             qa[i].setCoordinate(1, new Point3f(-0.06f,-0.05f, -5.0f));
             qa[i].setCoordinate(2, new Point3f( 0.06f,-0.05f, -5.0f));
             qa[i].setCoordinate(3, new Point3f( 0.06f, 0.05f, -5.0f));
             if(i==0)       c[i] = new Color3f(0.086f, 0.086f, 0.086f);
             else if(i==1)  c[i] = new Color3f(0.343f, 0.108f, 0.587f);
             else if(i==2)  c[i] = new Color3f(0.612f, 0.108f, 0.587f);
             else if(i==3)  c[i] = new Color3f(0.636f, 0.353f, 0.453f);
             else if(i==4)  c[i] = new Color3f(0.343f, 0.108f, 0.893f);
             else if(i==5)  c[i] = new Color3f(0.0f, 0.120f, 0.841f);
             else if(i==6)  c[i] = new Color3f(0.0f, 0.0f, 1.0f);
             else if(i==7)  c[i] = new Color3f(0.0f, 0.391f, 0.511f);
             else if(i==8)  c[i] = new Color3f(0.0f, 0.45f, 0.49f );
             else if(i==9)  c[i] = new Color3f(0.0f, 0.612f, 0.511f);
             else if(i==10) c[i] = new Color3f( 0.0f, 0.734f, 0.315f);
             else if(i==11) c[i] = new Color3f(0.0f, 0.734f, 0.114f);
             else if(i==12) c[i] = new Color3f(0.0f, 0.86f, 0.01f);
             else if(i==13) c[i] = new Color3f(0.758f, 0.905f, 0.440f);
             else if(i==14) c[i] = new Color3f(0.7f, 0.8f, 0.1f);
             else if(i==15) c[i] = new Color3f(0.795f, 0.695f, 0.073f);
             else if(i==16) c[i] = new Color3f(0.795f, 0.620f, 0.073f);
             else if(i==17) c[i] = new Color3f(0.795f, 0.461f, 0.073f);
             else if(i==18) c[i] = new Color3f(0.795f, 0.421f, 0.073f);   
             else if(i==19) c[i] = new Color3f(0.795f, 0.350f, 0.073f);
             else if(i==20) c[i] = new Color3f(0.795f, 0.250f, 0.073f);
             else if(i==21) c[i] = new Color3f(0.795f, 0.180f, 0.073f);
             else if(i==22) c[i] = new Color3f(0.85f, 0.120f, 0.073f);
             else if(i==23) c[i] = new Color3f(1.0f, 0.01f, 0.013f);
             else if(i==24) c[i] = new Color3f(1.0f, 1.0f, 1.0f);   
             for (int g = 0; g < 4; g++) qa[i].setColor(g, c[i]);
         }
         
         for(int j=0;j<qa.length;j++){
             sqa[j] = new Shape3D(qa[j]);
             sqa[j].setAppearance(new Appearance());
             sqa[j].setCapability(sqa[j].ALLOW_APPEARANCE_WRITE);
             sqa1[j] = new Shape3D(qa[j]);
             sqa1[j].setAppearance(new Appearance());
             sqa1[j].setCapability(sqa1[j].ALLOW_APPEARANCE_WRITE);
          }

//------------------------------------------------
//      Nodos para la Opcion ENUMERADO (3D)
//------------------------------------------------      
      
      for(int i=0; i<text2db.length;i++){
          bmax[i] = new BigDecimal(hexmx[i]).setScale(4,BigDecimal.ROUND_UP);
          bmim[i] = new BigDecimal(hexmn[i]).setScale(4,BigDecimal.ROUND_UP);
          if(cx[i])text2db[i] = new Text2D(""+bmim[i]+" - "+bmax[i]+">",new Color3f(0.0f, 1.0f, 0.0f),"Helvetica", 9, Font.BOLD);
          else text2db[i] = new Text2D(""+bmim[i]+" - "+bmax[i]+">",new Color3f(),"Helvetica", 9, Font.BOLD);    
      }         
      for(int i=0;i<text2db.length;i++){
          text2db[i].setCapability(text2db[i].ALLOW_APPEARANCE_WRITE);
      }  
      for(int k=0;k<aptext.length;k++)
      aptext[k] = text2db[k].getAppearance();   
      // Intervalos de Valores  
        Transform3D intervalos[] = new Transform3D[25];
        TransformGroup scb[] = new TransformGroup[25];
        for(int i=0; i<intervalos.length;i++){
            intervalos[i]= new Transform3D();
            intervalos[i].set(new Vector3f(2.78f,-0.9f+(float)(0.1*i),0.1f));
            scb[i] = new TransformGroup(intervalos[i]);
        }

      // Marcas de Colores
        Transform3D dezb[] = new Transform3D[25];
        TransformGroup scc[] = new TransformGroup[25];
        for(int i=0; i<intervalos.length;i++){
            dezb[i]= new Transform3D();
            dezb[i].set(new Vector3f(0.57f,(float)(-0.31f+i*0.032f),0.1f));
            scc[i] = new TransformGroup(dezb[i]);
        }
      
// Fin de los Nodos de Opcion ENUMERADO (3D)
//-------------------------------------------
//      Nodos para Opcion LINEA (3D)
//-------------------------------------------         
         
      maxim = new BigDecimal(this.RetMaxJed()).setScale(3,BigDecimal.ROUND_UP);
      minin = new BigDecimal(this.RetMinJed()).setScale(3,BigDecimal.ROUND_UP);
      medi = new BigDecimal(this.RetMediaJed()).setScale(3,BigDecimal.ROUND_UP);

      minn = new Text2D(""+minin,new Color3f(1.0f, 1.0f, 1.0f),"Helvetica1", 9, Font.BOLD);
      maxx = new Text2D(""+maxim,new Color3f(1.0f, 1.0f, 1.0f),"Helvetica1", 9, Font.BOLD);
      medd = new Text2D(""+medi,new Color3f(1.0f,1.0f,1.0f),"Helvetica1",9,Font.BOLD);
      unid = new Text2D("µV",new Color3f(1.0f, 1.0f, 1.0f),"Helvetica1", 9, Font.BOLD);
      
      minn.setCapability(minn.ALLOW_APPEARANCE_WRITE);
      maxx.setCapability(maxx.ALLOW_APPEARANCE_WRITE);
      medd.setCapability(medd.ALLOW_APPEARANCE_WRITE);
      unid.setCapability(unid.ALLOW_APPEARANCE_WRITE);      
      Transform3D minimo = new Transform3D();
      Transform3D maximo = new Transform3D();
      Transform3D media = new Transform3D();
      maximo.set(new Vector3f(-0.34f+0.91f,-0.6f,0.01f));
      Transform3D unidad = new Transform3D();
      unidad.set(new Vector3f(-0.34f+1.1f,-0.6f,0.01f));      
      
      // Marcas de Colores
      Transform3D dez[] = new Transform3D[25];
      TransformGroup sc[] = new TransformGroup[25];
      for(int j=0; j<dez.length;j++){
          dez[j]=new Transform3D();
          dez[j].set(new Vector3f(-1.9f+(float)(j*0.12)+0.9f,-1.9f,0.01f));
          sc[j]=new TransformGroup(dez[j]);
          if(xminsel1==j)minimo.set(new Vector3f(-0.34f+(float)(j*0.04),-0.6f,0.01f));

      }
      tempp = Math.abs(this.RetMediaJed()-g.returnZ(19,19));
      MediaPuntos();
      for(int j=0; j<dez.length;j++)
          if(xmedsel == j)media.set(new Vector3f(-0.34f+(float)(j*0.04),-0.6f,0.01f));
      
      TransformGroup mino = new TransformGroup(minimo);
      TransformGroup maxm = new TransformGroup(maximo);
      TransformGroup uni = new TransformGroup(unidad);
      TransformGroup medi = new TransformGroup(media);
      
      
//      Fin de los Nodos  Opcion LINEA (3D)
//-----------------------------------------------------
   
         for(int i=0;i<scc.length;i++){
             objRoot.addChild(scc[i]);
             scc[i].addChild(text2db[i]);
           }
         for(int i=0;i<cx.length;i++){
             if(cx[i]){
                 objRoot.addChild(scb[i]);
                 scb[i].addChild(sqa1[i]);
             }else{;}
            }
   
          objRoot.addChild(mino);
          mino.addChild(minn);
          objRoot.addChild(maxm);
          maxm.addChild(maxx);
          objRoot.addChild(uni);
          uni.addChild(unid);
          objRoot.addChild(medi);
          medi.addChild(medd);
             for(int i=0;i<qa.length;i++){
               objRoot.addChild(sc[i]);
               sc[i].addChild(sqa[i]);
             }
          
          
if(enum_onoff){
    VerEnumerado(true);
    enumerado.setSelected(true);
}else{
    VerEnumerado(false);
    enumerado.setSelected(false);
    as2 = false;
}

if(line_onoff){
    VerLinea(true);  
}else{ 
    VerLinea(false);
}
          
         
      MouseRotate myMouseRotate = new MouseRotate();
      myMouseRotate.setTransformGroup(w);
      myMouseRotate.setSchedulingBounds(new BoundingSphere());
      objRoot.addChild(myMouseRotate);

      MouseZoom behavior2 = new MouseZoom();
      behavior2.setTransformGroup(w);
      behavior2.setSchedulingBounds(bounds);
      objRoot.addChild(behavior2);

      MouseTranslate behavior3 = new MouseTranslate();
      behavior3.setTransformGroup(w);
      behavior3.setSchedulingBounds(new BoundingSphere());
      objRoot.addChild(behavior3);

      Color3f bgColor = new Color3f(0.0f, 0.0f, 0.01f);
      Background bgNode = new Background(bgColor);
      bgNode.setApplicationBounds(bounds);
      objRoot.addChild(bgNode);
      
      objRoot.compile();

	return objRoot;
       }
       


    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        enumerado = new javax.swing.JCheckBox();
        eje = new javax.swing.JCheckBox();
        estJed1 = new EstJed(this);

        setResizable(false);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Visualizaci\u00f3n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        enumerado.setFont(new java.awt.Font("Arial", 0, 11));
        enumerado.setText("Enumerado (3D)");
        enumerado.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        enumerado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        enumerado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enumeradoActionPerformed(evt);
            }
        });

        eje.setFont(new java.awt.Font("Arial", 0, 11));
        eje.setText("Ejes X,Y,Z");
        eje.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        eje.setMargin(new java.awt.Insets(0, 0, 0, 0));
        eje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(enumerado)
                    .add(eje))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(enumerado)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(eje)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        estJed1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout estJed1Layout = new org.jdesktop.layout.GroupLayout(estJed1);
        estJed1.setLayout(estJed1Layout);
        estJed1Layout.setHorizontalGroup(
            estJed1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 143, Short.MAX_VALUE)
        );
        estJed1Layout.setVerticalGroup(
            estJed1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 161, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout panel1Layout = new org.jdesktop.layout.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, estJed1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel1Layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 453, Short.MAX_VALUE)
                .add(estJed1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(panel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(631, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void VerLinea(boolean ver){
        Ap1 = new Appearance();
        Ra1 = new RenderingAttributes();
        Ra1.setVisible(ver);
        Ap1.setRenderingAttributes(Ra1);
        for(int k=0;k<sqa.length;k++){
            sqa[k].setAppearance(Ap1);
            if(!ver){
                minn.setAppearance(Ap1);
                maxx.setAppearance(Ap1);
                medd.setAppearance(Ap1);
                unid.setAppearance(Ap1);
            }
        }
    }
   
    
    public void VerEnumerado(boolean ver){
        Ap = new Appearance();
        Ra = new RenderingAttributes();
        Ra.setVisible(ver);
        Ap.setRenderingAttributes(Ra);
        
        for(int k=0;k<sqa1.length;k++){
            sqa1[k].setAppearance(Ap);
            if(ver)text2db[k].setAppearance(aptext[k]);
            else text2db[k].setAppearance(Ap);
        }
    }
    
    private void enumeradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enumeradoActionPerformed
          JCheckBox act = (JCheckBox)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && !as2){
            as2 = true;    
            VerEnumerado(true);
        }else if(act.getVerifyInputWhenFocusTarget() && as2){
            as2 = false;
            VerEnumerado(false);
        }  
    }//GEN-LAST:event_enumeradoActionPerformed
    
    private void ejeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejeActionPerformed
    JCheckBox act = (JCheckBox)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && !as0){
            as0 = true;    
            ejes.ver(true);
        }else if(act.getVerifyInputWhenFocusTarget() && as0){
            as0 = false;
            ejes.ver(false);
        }
        
    }//GEN-LAST:event_ejeActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jed().setVisible(true);
            }
        });
    }
    
     public void MediaPuntos(){
           Color3f n = new Color3f();
           int z=1;
           int h=19;
           for(int i=2;i<=18;i+=2){
               h=h+(int)Math.pow(-1,z)*i;
               if(Math.abs(g.returnZ(h,19)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,19);
                    tempp=Math.abs(g.returnZ(h,19)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
           z++;}
           z=1;
           h=18;
           for(int i=2;i<=16;i+=2){
              if(Math.abs(g.returnZ(h,16)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,16);
                    tempp=Math.abs(g.returnZ(h,16)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=18;
           for(int i=2;i<=16;i+=2){
              if(Math.abs(g.returnZ(h,22)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,22);
                    tempp=Math.abs(g.returnZ(h,22)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=19;
           for(int i=2;i<=18;i+=2){
              if(Math.abs(g.returnZ(h,13)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,13);
                    tempp=Math.abs(g.returnZ(h,13)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=19;
           for(int i=2;i<=18;i+=2){
              if(Math.abs(g.returnZ(h,25)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,25);
                    tempp=Math.abs(g.returnZ(h,25)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=18;
           for(int i=2;i<=16;i+=2){
              if(Math.abs(g.returnZ(h,10)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,10);
                    tempp=Math.abs(g.returnZ(h,10)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=18;
           for(int i=2;i<=16;i+=2){
              if(Math.abs(g.returnZ(h,28)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,28);
                    tempp=Math.abs(g.returnZ(h,28)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=19;
           for(int i=2;i<=14;i+=2){
              if(Math.abs(g.returnZ(h,31)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,31);
                    tempp=Math.abs(g.returnZ(h,31)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=19;
           for(int i=2;i<=14;i+=2){
              if(Math.abs(g.returnZ(h,7)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,7);
                    tempp=Math.abs(g.returnZ(h,7)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=18;
           for(int i=2;i<=8;i+=2){
              if(Math.abs(g.returnZ(h,4)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,4);
                    tempp=Math.abs(g.returnZ(h,4)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
           z=1;
           h=18;
           for(int i=2;i<=6;i+=2){
              if(Math.abs(g.returnZ(h,34)-this.RetMediaJed())<tempp) {
                    n = this.Geometria_Noise.RetColor3D(false,maximo,minimo,h,34);
                    tempp=Math.abs(g.returnZ(h,34)-this.RetMediaJed());
                    }else{
                    tempp=tempp;    
                    }
               h=h+(int)Math.pow(-1,z)*i;
               z++;}
       }
     
    public void MaxMinHex(int xo, int yo, int xi, int yi){
         // Hexagono Maximo
         if(yo==19)
             switch(xo){
                 case 19: maxmin[0] = 0; break;
                 case 17: maxmin[0] = 2; break;
                 case 21: maxmin[0] = 5; break;
                 case 15: maxmin[0] = 8; break;
                 case 23: maxmin[0] = 14; break;
                 case 13: maxmin[0] = 20; break;
                 case 25: maxmin[0] = 29; break;
                 case 11: maxmin[0] = 38; break;
                 case 27: maxmin[0] = 50; break;
                 case 9:  maxmin[0] = 62; break;
                 case 29: maxmin[0] = 77; break;
             }    
         else if(yo==16)
            switch(xo){
                 case 18: maxmin[0] = 3; break;
                 case 20: maxmin[0] = 4; break;
                 case 16: maxmin[0] = 9; break;
                 case 22: maxmin[0] = 13; break;
                 case 14: maxmin[0] = 21; break;
                 case 24: maxmin[0] = 28; break;
                 case 12: maxmin[0] = 39; break;
                 case 26: maxmin[0] = 49; break;
                 case 10: maxmin[0] = 63; break;
                 case 28:  maxmin[0] = 76; break;
             }
         else if(yo==22) 
             switch(xo){
                 case 18: maxmin[0] = 1; break;
                 case 20: maxmin[0] = 6; break;
                 case 16: maxmin[0] = 7; break;
                 case 22: maxmin[0] = 15; break;
                 case 14: maxmin[0] = 19; break;
                 case 24: maxmin[0] = 30; break;
                 case 12: maxmin[0] = 37; break;
                 case 26: maxmin[0] = 51; break;
                 case 10: maxmin[0] = 61; break;
                 case 28:  maxmin[0] = 78; break;
             }
         else if(yo==13)
             switch(xo){
                 case 19: maxmin[0] = 11; break;
                 case 17: maxmin[0] = 10; break;
                 case 21: maxmin[0] = 12; break;
                 case 15: maxmin[0] = 22; break;
                 case 23: maxmin[0] = 27; break;
                 case 13: maxmin[0] = 40; break;
                 case 25: maxmin[0] = 48; break;
                 case 11: maxmin[0] = 64; break;
                 case 27: maxmin[0] = 75; break;
                 case 9:  maxmin[0] = 94; break;
                 case 29: maxmin[0] = 99; break;
             } 
         else if(yo==25)
             switch(xo){
                 case 19: maxmin[0] = 17; break;
                 case 17: maxmin[0] = 18; break;
                 case 21: maxmin[0] = 16; break;
                 case 15: maxmin[0] = 36; break;
                 case 23: maxmin[0] = 31; break;
                 case 13: maxmin[0] = 60; break;
                 case 25: maxmin[0] = 52; break;
                 case 11: maxmin[0] = 90; break;
                 case 27: maxmin[0] = 79; break;
                 case 9:  maxmin[0] = 91; break;
                 case 29: maxmin[0] = 100; break;
             }    
          else if(yo==10)
             switch(xo){
                 case 18: maxmin[0] = 24; break;
                 case 20: maxmin[0] = 25; break;
                 case 16: maxmin[0] = 23; break;
                 case 22: maxmin[0] = 26; break;
                 case 14: maxmin[0] = 41; break;
                 case 24: maxmin[0] = 47; break;
                 case 12: maxmin[0] = 65; break;
                 case 26: maxmin[0] = 74; break;
                 case 10: maxmin[0] = 95; break;
                 case 28:  maxmin[0] = 98; break;
             }
           else if(yo==28)
             switch(xo){
                 case 18: maxmin[0] = 34; break;
                 case 20: maxmin[0] = 33; break;
                 case 16: maxmin[0] = 35; break;
                 case 22: maxmin[0] = 32; break;
                 case 14: maxmin[0] = 59; break;
                 case 24: maxmin[0] = 53; break;
                 case 12: maxmin[0] = 89; break;
                 case 26: maxmin[0] = 80; break;
                 case 10: maxmin[0] = 92; break;
                 case 28:  maxmin[0] = 101; break;
             }
         else if(yo==31)
             switch(xo){
                 case 19: maxmin[0] = 56; break;
                 case 17: maxmin[0] = 57; break;
                 case 21: maxmin[0] = 55; break;
                 case 15: maxmin[0] = 58; break;
                 case 23: maxmin[0] = 54; break;
                 case 13: maxmin[0] = 88; break;
                 case 25: maxmin[0] = 81; break;
                 case 11: maxmin[0] = 93; break;
                 case 27: maxmin[0] = 102; break;
             }    
          else if(yo==7)
             switch(xo){
                 case 19: maxmin[0] = 44; break;
                 case 17: maxmin[0] = 43; break;
                 case 21: maxmin[0] = 45; break;
                 case 15: maxmin[0] = 42; break;
                 case 23: maxmin[0] = 46; break;
                 case 13: maxmin[0] = 66; break;
                 case 25: maxmin[0] = 73; break;
                 case 11: maxmin[0] = 96; break;
                 case 27: maxmin[0] = 97; break;
             }    
          else if(yo==4)
             switch(xo){
                 case 18: maxmin[0] = 69; break;
                 case 20: maxmin[0] = 70; break;
                 case 16: maxmin[0] = 68; break;
                 case 22: maxmin[0] = 71; break;
                 case 14: maxmin[0] = 67; break;
                 case 24: maxmin[0] = 72; break;
             }    
          else if(yo==34)
             switch(xo){
                 case 18: maxmin[0] = 85; break;
                 case 20: maxmin[0] = 84; break;
                 case 16: maxmin[0] = 86; break;
                 case 22: maxmin[0] = 83; break;
                 case 14: maxmin[0] = 87; break;
                 case 24: maxmin[0] = 82; break;
             }    
         // Hexagono Minimo 
          if(yi==19)
             switch(xi){
                 case 19: maxmin[1] = 0; break;
                 case 17: maxmin[1] = 2; break;
                 case 21: maxmin[1] = 5; break;
                 case 15: maxmin[1] = 8; break;
                 case 23: maxmin[1] = 14; break;
                 case 13: maxmin[1] = 20; break;
                 case 25: maxmin[1] = 29; break;
                 case 11: maxmin[1] = 38; break;
                 case 27: maxmin[1] = 50; break;
                 case 9:  maxmin[1] = 62; break;
                 case 29: maxmin[1] = 77; break;
             }    
         else if(yi==16)
            switch(xi){
                 case 18: maxmin[1] = 3; break;
                 case 20: maxmin[1] = 4; break;
                 case 16: maxmin[1] = 9; break;
                 case 22: maxmin[1] = 13; break;
                 case 14: maxmin[1] = 21; break;
                 case 24: maxmin[1] = 28; break;
                 case 12: maxmin[1] = 39; break;
                 case 26: maxmin[1] = 49; break;
                 case 10: maxmin[1] = 63; break;
                 case 28:  maxmin[1] = 76; break;
             }
         else if(yi==22) 
             switch(xi){
                 case 18: maxmin[1] = 1; break;
                 case 20: maxmin[1] = 6; break;
                 case 16: maxmin[1] = 7; break;
                 case 22: maxmin[1] = 15; break;
                 case 14: maxmin[1] = 19; break;
                 case 24: maxmin[1] = 30; break;
                 case 12: maxmin[1] = 37; break;
                 case 26: maxmin[1] = 51; break;
                 case 10: maxmin[1] = 61; break;
                 case 28:  maxmin[1] = 78; break;
             }
         else if(yi==13)
             switch(xi){
                 case 19: maxmin[1] = 11; break;
                 case 17: maxmin[1] = 10; break;
                 case 21: maxmin[1] = 12; break;
                 case 15: maxmin[1] = 22; break;
                 case 23: maxmin[1] = 27; break;
                 case 13: maxmin[1] = 40; break;
                 case 25: maxmin[1] = 48; break;
                 case 11: maxmin[1] = 64; break;
                 case 27: maxmin[1] = 75; break;
                 case 9:  maxmin[1] = 94; break;
                 case 29: maxmin[1] = 99; break;
             } 
         else if(yi==25)
             switch(xi){
                 case 19: maxmin[1] = 17; break;
                 case 17: maxmin[1] = 18; break;
                 case 21: maxmin[1] = 16; break;
                 case 15: maxmin[1] = 36; break;
                 case 23: maxmin[1] = 31; break;
                 case 13: maxmin[1] = 60; break;
                 case 25: maxmin[1] = 52; break;
                 case 11: maxmin[1] = 90; break;
                 case 27: maxmin[1] = 79; break;
                 case 9:  maxmin[1] = 91; break;
                 case 29: maxmin[1] = 100; break;
             }    
          else if(yi==10)
             switch(xi){
                 case 18: maxmin[1] = 24; break;
                 case 20: maxmin[1] = 25; break;
                 case 16: maxmin[1] = 23; break;
                 case 22: maxmin[1] = 26; break;
                 case 14: maxmin[1] = 41; break;
                 case 24: maxmin[1] = 47; break;
                 case 12: maxmin[1] = 65; break;
                 case 26: maxmin[1] = 74; break;
                 case 10: maxmin[1] = 95; break;
                 case 28:  maxmin[1] = 98; break;
             }
           else if(yi==28)
             switch(xi){
                 case 18: maxmin[1] = 34; break;
                 case 20: maxmin[1] = 33; break;
                 case 16: maxmin[1] = 35; break;
                 case 22: maxmin[1] = 32; break;
                 case 14: maxmin[1] = 59; break;
                 case 24: maxmin[1] = 53; break;
                 case 12: maxmin[1] = 89; break;
                 case 26: maxmin[1] = 80; break;
                 case 10: maxmin[1] = 92; break;
                 case 28:  maxmin[1] = 101; break;
             }
         else if(yi==31)
             switch(xi){
                 case 19: maxmin[1] = 56; break;
                 case 17: maxmin[1] = 57; break;
                 case 21: maxmin[1] = 55; break;
                 case 15: maxmin[1] = 58; break;
                 case 23: maxmin[1] = 54; break;
                 case 13: maxmin[1] = 88; break;
                 case 25: maxmin[1] = 81; break;
                 case 11: maxmin[1] = 93; break;
                 case 27: maxmin[1] = 102; break;
             }    
          else if(yi==7)
             switch(xi){
                 case 19: maxmin[1] = 44; break;
                 case 17: maxmin[1] = 43; break;
                 case 21: maxmin[1] = 45; break;
                 case 15: maxmin[1] = 42; break;
                 case 23: maxmin[1] = 46; break;
                 case 13: maxmin[1] = 66; break;
                 case 25: maxmin[1] = 73; break;
                 case 11: maxmin[1] = 96; break;
                 case 27: maxmin[1] = 97; break;
             }    
          else if(yi==4)
             switch(xi){
                 case 18: maxmin[1] = 69; break;
                 case 20: maxmin[1] = 70; break;
                 case 16: maxmin[1] = 68; break;
                 case 22: maxmin[1] = 71; break;
                 case 14: maxmin[1] = 67; break;
                 case 24: maxmin[1] = 72; break;
             }    
          else if(yi==34)
             switch(xi){
                 case 18: maxmin[1] = 85; break;
                 case 20: maxmin[1] = 84; break;
                 case 16: maxmin[1] = 86; break;
                 case 22: maxmin[1] = 83; break;
                 case 14: maxmin[1] = 87; break;
                 case 24: maxmin[1] = 82; break;
             }    
     }   
    
    
    public double RetMaxJed(){
        return hexmax;//maximo;
    }
    public double RetMinJed(){
        return hexmin;//minimo;
    }
    public Integer[] RetMaxMinHex(){
        return maxmin;
    }
    public double RetMediaJed(){
        return sumaHex/Nhex; // mediapointG;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox eje;
    private javax.swing.JCheckBox enumerado;
    private erg2.EstJed estJed1;
    private javax.swing.JPanel jPanel1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
    
}
