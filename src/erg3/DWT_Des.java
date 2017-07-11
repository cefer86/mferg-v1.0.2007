package erg3;

/**
 *
 * Autor: Cesar Peña
 */

public class DWT_Des {
    
//    {-0.2304,0.7148,-0.6309;,-0.0280,0.1870,0.0308,-0.0329,-0.0106};// Deubechie n=4
//    {-0.0106,0.0329,0.0308,-0.1870,-0.0280,0.6309,0.7148,0.2304};// Deubechie n=4
    private double H_d[]={-0.0267,0.1882,-0.5272,0.6885,-0.2812,-0.2498,0.1959,0.1274,-0.0931,-0.0714,0.0295,0.0332,-0.0036,-0.0107,-0.0014,0.0020,0.0007,-0.0001,-0.0001,-0.0000}; //Deubechie n=10
    private double L_d[]={-0.0000,0.0001,-0.0001,-0.0007,0.0020,0.0014,-0.0107,0.0036,0.0332,-0.0295,-0.0714,0.0931,0.1274,-0.1959,-0.2498,0.2812,0.6885,0.5272,0.1882,0.0267};//Deubechie n=10
    private double s_ent[]=null;
    private double h[]=null;
    private double x[]=null;
    private double y1[];
    private double y2[], y[],Det[],ad_inf[],ad_sup[],s_entSym[],y_sal[],y_sal2[],temp[];
    private int dif=0;
        
    public DWT_Des(double[] x, String t_c) {
       this.s_ent = x;
       if(t_c=="D")Conv_WavFil(H_d,RetSimetria_Entrada(s_ent,H_d.length),H_d.length-1);
       else if(t_c=="A")Conv_WavFil(L_d,RetSimetria_Entrada(s_ent,L_d.length),L_d.length-1);

    }
    
    public double[] RetSimetria_Entrada(double[] s, int N){
        int f,H;
        if(N<=s.length) H=f=N-1;
        else H=f=s.length-1;
        this.s_entSym = new double[s.length+2*H];
        this.ad_inf= new double[H];
        this.ad_sup= new double[H];
        
        for(int i=0;i<H;i++) {
            if(N>s.length && i==0) {;}
            else 
                f--;
            ad_inf[i]=s[f];
            ad_sup[i]=s[s.length-1-i];
        }    
        
        for(int k=0;k<s_entSym.length;k++) {
            if(k<H)s_entSym[k]=ad_inf[k];
            if(k>=H && k<s.length+H)s_entSym[k]=s[k-H];
            if(k>=s.length+H)s_entSym[k]=ad_sup[k-H-1-s.length+1];
        }
        return s_entSym;
    }
    
    
    public void Conv_WavFil(double[] H_d,double[] s_ent, int N){
        
    if (s_ent.length>=H_d.length){
        dif=s_ent.length-H_d.length;
        this.h = new double[H_d.length+dif]; //Relleno con ceros
        for(int k=0;k<h.length;k++) h[k]=0.0;
        for(int i=0;i<h.length-dif;i++) h[i]=H_d[i]; // El vector de ceros con los valores de H_d
        this.x=s_ent;
        
    }else{
        dif=H_d.length-s_ent.length;
        this.x = new double[s_ent.length+dif];
        for(int k=0;k<s_ent.length;k++) x[k]=0.0;
        for(int i=0;i<s_ent.length-dif;i++) x[i]=s_ent[i]; 
        this.h=H_d;
    }

int j=0,i=0,k=0;
double aux=0;
int n=0;
this.y1 = new double[x.length];
this.y2 = new double[x.length-1];
this.y = new double[2*x.length-1];

for (i=0;i<x.length;i++){
    j=i;
        for(k=0;k<=i;k++){  
            y1[i]=x[j]*h[k];
            j=j-1;
            aux=aux+y1[i]; 
           }
    y1[i]=aux;
    aux=0;
    }

j=x.length-1;
for (i=1;i<x.length;i++){
     for (k=i;k<x.length;k++){  
        y2[n]=x[k]*h[j];
        j=j-1;
        aux=aux+y2[n]; 
    }
    j=x.length-1;
    y2[n]=aux;
    n=n+1;
    aux=0;
}

for(int l=0;l<y1.length+y2.length;l++){
    if(l<y1.length)y[l]=y1[l];
    else if(l>=y1.length) y[l]=y2[l-y2.length-1];
}

int d=0;
for(int h=0; h<y.length;h++) if(y[h]==0) d++;
this.y_sal = new double[y.length-d];
for(j=0;j<y_sal.length;j++) y_sal[j]=y[j];
this.y_sal2 = new double[y_sal.length-2*N];
for(j=0;j<y_sal2.length;j++) y_sal2[j]=y_sal[j+N];

//Impresion de los valores de la Convolucion
//  for(int l=0;l<y_sal2.length;l++)System.out.println("y_sal2["+l+"]= "+y_sal2[l]);
            
}
     
    public double[] RetDownSampled(){
        int e=0,l=0;
        while(e<y_sal2.length){
            if(e%2!=0) l++; 
            e++;
        }
        this.Det = new double[l];
        for(int j=0;j<Det.length;j++) Det[j]=y_sal2[j*2+1];
        return Det;
    }
    
     
    
}
