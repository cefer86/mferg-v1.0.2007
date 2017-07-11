
package erg3;

/**
 *Autor: Cesar Peña
 */

public class Gauss {
    
    
    int N=37;
    int M=36;
    private double n=-1.8;
    public double s,dx=0,dy=0;
    private double k1,A;
    private double n_0;
    private double n_1;
    private double n_2;
    private double n_3;
    private double n_4; 
       
    private double x[] = new double[N+1];
    private double y[] = new double[M+1];
    private double z0[][] = new double[N+1][M+1];
    public double z[][] = new double[N+1][M+1];
    private double zm[][] = new double[N+1][M+1];
    
    
    public Gauss(double dx, double dy) {
        this.dx=dx;
        this.dy=-dy;
        
         }
          
    public Gauss() {
         }
   
    public void returnGauss(double s, double amp){
        
        this.s = s;
        this.k1=-2*s*s;
        this.A = amp;
        this.n_0=0;
        this.n_1=A*0.25;//(1/k2)*0.25;
        this.n_2=A*0.50;//(1/k2)*0.50;
        this.n_3=A*0.75;//(1/k2)*0.75;
        this.n_4=A;//(1/k2); 
        
        for(int i=1;i<=x.length-1;i++){
            x[i]=n;
            n=n+0.1;
        }
        
        n=-1.8;
        for(int i=1;i<=y.length-1;i++){
            y[i]=n;  
            n=n+0.1;
        }
        
        // Impresion en Pantalla de la Rejilla
//        for(int i=1;i<=x.length-1;i++){
//            for (int j=1; j<=y.length-1;j++){
//              System.out.println("("+ i + "," + j + ") = " + x[i]+" ,"+y[j]);  
//            }
//        }
        
        for(int i=1;i<=x.length-1;i++){
            for(int j=1; j<=y.length-1;j++){
           z0[i][j] = java.lang.Math.pow((x[i]-dx),2.0)+java.lang.Math.pow((y[j]-dy),2.0);
           z[i][j]= A*java.lang.Math.exp(z0[i][j]/k1);
            }
        }
        
        //Impresion en Pantalla de Z
//        for(int i=1;i<=x.length-1;i++){
//            for(int j=1;j<=y.length-1;j++){
//               System.out.print(" "+z[i][j]);   
//                 }
//                System.out.println(" ");
//            }
     
       } // Fin del Metodo Gauss
    
     public double[][] EstNivGauss(){
         for(int i=1;i<=x.length-1;i++){
            for (int j=1; j<=y.length-1;j++){
                 if(n_0<=z[i][j] && z[i][j]<n_1){
                  zm[i][j]=0;
                }else if(n_1<=z[i][j] && z[i][j]<n_2){
                  zm[i][j]=1;
                }else if(n_2<=z[i][j] && z[i][j]<n_3){
                  zm[i][j]=2;
                }else if(n_3<=z[i][j] && z[i][j]<=n_4){
                  zm[i][j]=3;
                }
            }
        }
           
         for(int i=1;i<=x.length-1;i++){
            for (int j=1; j<=y.length-1;j++){
                 if(1<=i && i<=10 && 1<=j && j<=2){
                     zm[i][j]=4;
                 }else if (1<=i && i<=6 && 3<=j && j<=4){
                     zm[i][j]=4;
                 }else if(1<=i && i<=4 && 5<=j && j<=6){
                     zm[i][j]=4;
                 }else if(1<=i && i<=2 && 7<=j && j<=10){
                     zm[i][j]=4;
                 }else if (1<=i && i<=2 && 27<=j && j<=36){
                     zm[i][j]=4;
                 }else if(1<=i && i<=4 && 31<=j && j<=36){
                     zm[i][j]=4;
                 }else if(1<=i && i<=6 && 33<=j && j<=36){
                     zm[i][j]=4;
                 }else if(1<=i && i<=10 && 35<=j && j<=36){
                     zm[i][j]=4;
                 }else if(28<=i && i<=37 && 1<=j && j<=2){
                     zm[i][j]=4;
                 }else if(32<=i && i<=37 && 3<=j && j<=4){
                     zm[i][j]=4;
                 }else if(34<=i && i<=37 && 5<=j && j<=6){
                     zm[i][j]=4;
                 }else if(36<=i && i<=37 && 7<=j && j<=10){
                     zm[i][j]=4;
                 }else if(28<=i && i<=37 && 35<=j && j<=36){
                     zm[i][j]=4;
                 }else if(32<=i && i<=37 && 33<=j && j<=36){
                     zm[i][j]=4;
                 }else if(34<=i && i<=37 && 31<=j && j<=36){
                     zm[i][j]=4;
                 }else if(36<=i && i<=37 && 27<=j && j<=36){
                     zm[i][j]=4;
                 }
            }
        }
         
       return zm;
     }
    
    
     public float returnX(int k){
        return (float) x[k];  
     }
    
      public float returnY(int k){
        return (float) y[k];  
     }
      
     public float returnZ(int i, int j){
         return (float) z[i][j];
     } 
   
     
}
