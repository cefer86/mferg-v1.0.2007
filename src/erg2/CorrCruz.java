

package erg2;

import java.util.Random;

/**
 *
 * Autor: Cesar Peña
 */

public class CorrCruz {
    
    public int N;    
    public int temp = 0;
    private Random r = new Random();
    public double x[] = null, xtemp[] = null; 
    public double y[] = null;
    public double ycorr[] = null;
    public double c[] = null; 
    public double cc[] = null,entrada[]=null;
    double f = 0.0;
    int dpos, ltemp,dpi,dpx=0;
    
   public CorrCruz(double k[],int N, double[] sss) {
       this.y = k;
       this.N = N;
       this.entrada = sss;
//       ycorr = new double[N*2-1];  // Usados para el metodo Corr
//       c = new double[N*2-1];        
//       if(N<=sss.length)cc = new double[N];
//       else 
       cc = new double[103*sss.length]; 
       ltemp = (sss.length>N)?sss.length:N;

       this.dpi = (int)(4*103*sss.length/N);
       this.xtemp = new double[ltemp];
                                                                      
       for(int n=0;n<xtemp.length;n++){
           if(n>=0 && n<sss.length)
               xtemp[n]=sss[n];
           else xtemp[n]=0;
       }       
//       if(N<=sss.length || dpi==0){     //Si NO se cumple el IF es porque de todas maneras M patrones < |sss|
//          this.x = new double[N];       // Y dpi es distinto de 0 y 1
//          this.dpos = (int)(ltemp/N);   //Tantos puntos tenga la ventana
//          for (int i = 0 ; i<x.length ; i++)x[i]= xtemp[i*dpos];
//       }
      
      }
    
    public double[] Corr() {
       
       
        for (int m = -(N-1);m<=0;m++){
           for(int k= 0;k<N;k++){
               c[N-1+m] = c[N-1+m] + x[k]*ycorr[k-m]; 
           } 
        }
        
        for (int m =1;m<=N-1;m++){
           for(int k= 0;k<N;k++){
               if(k-m<0){ 
               c[N-1+m] = c[N-1+m] + x[k]*temp;
               }else if(k-m>=0){
                c[N-1+m] = c[N-1+m] + x[k]*ycorr[k-m];   
               }
           } 
        }
//      Impresion de los Datos de Cross-Correlation
//      for (int m = 0;m<2*N-1;m++){
//            System.out.println("c["+m+"] = "+c[m]);
//      }  
        return c;
        
    }
    
    public double[] Corr2(){
        int s=0,k=0;
        if(N<=entrada.length || dpi==0){
        for(int j =0;j<y.length;j++){
            if(y[j]==1 || y[j]==-1)cc[j] = x[j]*y[j];
            else if(y[j]==0) cc[j]=x[j];
           }
        }else{
          
            for(int j=0;j<103;j++){
             for(int n=0;n<entrada.length;n++){
                if( n*4/dpi<y.length/103){
                 if(n==dpx){                     
                     if(y[dpx*4/dpi+j*(dpx*4/dpi)]==1 || y[dpx*4/dpi+j*(dpx*4/dpi)]==-1) 
                     {cc[j*entrada.length+n]=y[dpx*4/dpi+j*(dpx*4/dpi)]*entrada[n];k=j;}
                     dpx=dpx+dpi;
                 }else{
//                    if(cc[k]>=0)cc[j]=entrada[j]+entrada[j]-0.3*(j-dpx+dpi)*entrada[j]; 
//                    if(cc[k]<0)cc[j]=entrada[j]-entrada[j]+0.3*(j-dpx+dpi)*entrada[j]; 
//                    if(cc[k]>=0)cc[j]=cc[k]+entrada[j]-0.3*(j-dpx+dpi)*cc[k]; 
//                    if(cc[k]<0)cc[j]=cc[k]-entrada[j]+0.3*(j-dpx+dpi)*cc[k]; 
                    cc[j*entrada.length+n]=entrada[n];}
               }else{
//                    if(cc[k]>=0)cc[j]=entrada[j]+entrada[j]-0.3*(j-dpx+dpi)*entrada[j]; 
//                    if(cc[k]<0)cc[j]=entrada[j]-entrada[j]+0.3*(j-dpx+dpi)*entrada[j]; 
//                    if(cc[k]>=0)cc[j]=cc[k]+entrada[j]-0.3*(j-dpx+dpi)*cc[k]; 
//                    if(cc[k]<0)cc[j]=cc[k]-entrada[j]+0.3*(j-dpx+dpi)*cc[k]; 
                    cc[j*entrada.length+n]=entrada[n];
//                    cc[i]=entrada[i];
               }
                
             }
             dpx=0;
         } 
          
        }
        return cc;
    }
    
    public int RetIndice_time(){
        return this.dpi;
    }
    
}
