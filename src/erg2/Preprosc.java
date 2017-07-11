
package erg2;

/**
 *
 * Autor: Cesar Peña
 *
 */

public class Preprosc {
    
    private Test0 form2;
    private Kernels form3;
    private String cad_pat="",x1="",x2="",x3="",w="";
    private String[] pat_b;
    private double[] k1;
    private double[] k2;
    private double[] k3;
    private int N_pat;
    char s;
    int val_b,p=0;
    
    public Preprosc(Test0 fr) {
        this.form2 = fr;
    }
    public Preprosc(Kernels fr1) {
        this.form3 = fr1;
    }
    /**
     *Encargado de Extraer la matriz de M (patrones) x 103
     */    
    public void EnvioPat(String pat, int N_pat,int Nm){
        this.N_pat = N_pat;
        pat_b = new String[105];

        for(int k=0;k<103;k++){
            for(int l=0;l<N_pat;l++){
              s = pat.charAt(l*105+l+k); 
              cad_pat = cad_pat+s;   
            }
           pat_b[k]=cad_pat; 
           cad_pat=""; 
           w+=pat_b[k]+";";
         }
//        System.out.println(w+"\n");w="";  
//        System.out.println(pat);
    }
    
    public double[] RetKernel_01(){
        
        k1 = new double[103*4*N_pat];  // Son 4 intervalos por cada PB (1 estimulo) de los N_pat patrones a lo largo de 103 hexagonos 
        
        for(int j=0;j<103;j++){
            for(int n=0;n<N_pat;n++){
                if(pat_b[j].charAt(n)=='0'){ 
                    k1[4*N_pat*j+4*n]=1;
                    k1[4*N_pat*j+1+4*n]=0;
                    k1[4*N_pat*j+2+4*n]=0;
                    k1[4*N_pat*j+3+4*n]=0;
                }else if(pat_b[j].charAt(n)=='1'){
                    k1[4*N_pat*j+4*n]=-1;
                    k1[4*N_pat*j+1+4*n]=0;
                    k1[4*N_pat*j+2+4*n]=0;
                    k1[4*N_pat*j+3+4*n]=0;
                }
//            System.out.println((20*j+4*n) +","+(20*j+1+4*n)+","+(20*j+2+4*n)+","+(20*j+3+4*n));
          }
        }
        
        return k1;
    }
    
    
    
    public double[] RetKernel_02(){
        
        k2 = new double[103*4*N_pat];
        
        for(int j=0;j<103;j++){
          for(int n=0;n<N_pat;n++){
            if(n==0) {
            k2[4*N_pat*j+4*n]=0;
            k2[4*N_pat*j+1+4*n]=0;
            k2[4*N_pat*j+2+4*n]=0;
            k2[4*N_pat*j+3+4*n]=0;  
            }
           }
        }
        
    
    for(int j=0;j<103;j++){
        for(int n=0;n<N_pat;n++){
            
            if(n!=0){
            if(n==N_pat-1 && j==102) break;
            
            k2[4*N_pat*j+4*n]=k1[4*N_pat*j+4*(n-1)]*k1[4*N_pat*j+4*n];
            k2[4*N_pat*j+1+4*n]=0;
            k2[4*N_pat*j+2+4*n]=0;
            k2[4*N_pat*j+3+4*n]=0;
            
//            System.out.println((20*j+4*n) +","+(20*j+1+4*n)+","+(20*j+2+4*n)+","+(20*j+3+4*n));
            }
        }
    }   
    
            k2[k2.length-4]=k1[k2.length-4]*k1[k2.length-8];
            k2[k2.length-3]=0;
            k2[k2.length-2]=0;
            k2[k2.length-1]=0;
                
        return k2;
    }
    
    
    
    public double[] RetKernel_03(){
        
     k3 = new double[103*4*N_pat];
        
        for(int j=0;j<103;j++){
          for(int n=0;n<N_pat;n++){
            if(n==0) {
            k3[4*N_pat*j+4*n]=0;
            k3[4*N_pat*j+1+4*n]=0;
            k3[4*N_pat*j+2+4*n]=0;
            k3[4*N_pat*j+3+4*n]=0;  
            }
           }
        }
        
        
   for(int j=0;j<103;j++){
        for(int n=0;n<N_pat;n++){
            
            if(n!=0){
            if(n==N_pat-1 && j==102) break;
            
            k3[4*N_pat*j+4*n]=k2[4*N_pat*j+4*(n-1)]*k2[4*N_pat*j+4*n];
            k3[4*N_pat*j+1+4*n]=0;
            k3[4*N_pat*j+2+4*n]=0;
            k3[4*N_pat*j+3+4*n]=0;
            
//            System.out.println((20*j+4*n) +","+(20*j+1+4*n)+","+(20*j+2+4*n)+","+(20*j+3+4*n));
            }
        }
    }   
    
            k3[k3.length-4]=k2[k3.length-4]*k2[k3.length-8];
            k3[k3.length-3]=0;
            k3[k3.length-2]=0;
            k3[k3.length-1]=0;
                
         return k3;
    }
    
}
