
package erg2;

import java.util.Random;

/**
 *
 * Autor: Cesar Peña
 *
 */

public class DensK {
    
    Random d = new Random();
    double f;
    double dlt = 0.01;
    double Kernel_1erOrden[]=null;
    double fun[][] = null;
    double suma[] =new double[103];
    private double A1[] = null, A2[]=null, A3[]=null, A4[]=null, A5[]=null, A6[]=null;
    private double C1[] = null, C2[]=null, C3[]=null, C4[]=null;
    private double Z1[] = null, Z2[]=null, Z3[]=null, Z4[]=null;
    private Test0 form;
    double aux=0;
    
//    public DensK(){
//     this.fun= new double[103][20];
//     for(int i=0;i<fun.length;i++){
//         for(int j=0; j<fun[i].length;j++){
//             fun[i][j]=7000*(Math.cos(3.1467*j)-Math.sin(3.15468*j));
//         }
//     }
//     Inte();
//    }
        
    public DensK(Test0 form) {
    this.form = form;
    this.Kernel_1erOrden = form.Retk1WVF();
    this.fun = new double[103][this.Kernel_1erOrden.length/103];
    this.A1 = new double[this.Kernel_1erOrden.length/103];
    this.A2 = new double[this.Kernel_1erOrden.length/103];
    this.A3 = new double[this.Kernel_1erOrden.length/103];
    this.A4 = new double[this.Kernel_1erOrden.length/103];
    this.A5 = new double[this.Kernel_1erOrden.length/103];
    this.A6 = new double[this.Kernel_1erOrden.length/103];
    this.C1 = new double[this.Kernel_1erOrden.length/103];
    this.C2 = new double[this.Kernel_1erOrden.length/103];
    this.C3 = new double[this.Kernel_1erOrden.length/103];
    this.C4 = new double[this.Kernel_1erOrden.length/103];
    this.Z1 = new double[this.Kernel_1erOrden.length/103];
    this.Z2 = new double[this.Kernel_1erOrden.length/103];
    this.Z3 = new double[this.Kernel_1erOrden.length/103];
    this.Z4 = new double[this.Kernel_1erOrden.length/103];
    
    for(int i=0; i<103;i++){
     for(int j=0;j<this.Kernel_1erOrden.length/103;j++){
        this.fun[i][j]= this.Kernel_1erOrden[j+i*this.Kernel_1erOrden.length/103];
     }
    }
    
      Inte();
      Anillos_Cuad();
    }
    
    public void Inte(/*int x0, int x1*/){ // Metodo Trapezoidal    
    
        dlt=dlt/2;
        for(int i=0;i<fun.length;i++){
             for(int j=1;j<fun[i].length-1;j++){
                  suma[i] = suma[i] + 2*fun[i][j]; 
                }
           }
        for(int i=0;i<fun.length;i++){
             for(int j=0;j<fun[i].length;j=j+fun[i].length-1){
                  suma[i] = suma[i] + fun[i][j]; 
                }
            suma[i] = suma[i]*dlt;
           }
    }
   
    public void Anillos_Cuad(){
     
        A1 = fun[0];
    for(int n=0; n<A2.length;n++){
        for(int m=1; m<=6;m++){
        aux= aux+fun[m][n]/6;
          }
        A2[n]=aux; aux=0;
      }
    for(int n=0; n<A3.length;n++){
        for(int m=7; m<=18;m++){
        aux= aux+fun[m][n]/12;
          }
        A3[n]=aux; aux=0;
      }
    for(int n=0; n<A4.length;n++){
        for(int m=19; m<=36;m++){
        aux= aux+fun[m][n]/18;
          }
        A4[n]=aux; aux=0;
      }
    for(int n=0; n<A5.length;n++){
        for(int m=37; m<=60;m++){
        aux= aux+fun[m][n]/24;
          }
        A5[n]=aux; aux=0;
      }
    for(int n=0; n<A6.length;n++){
        for(int m=61; m<=102;m++){
        aux= aux+fun[m][n]/42;
          }
        A6[n]=aux; aux=0;
      }
        
     for(int k=0;k<C1.length;k++){

            C1[k] = (fun[1][k]+fun[7][k]+fun[19][k]+fun[37][k]+fun[61][k]+fun[17][k]+fun[18][k]+fun[36][k]+fun[60][k]+fun[90][k]+fun[91][k]
                    +fun[34][k]+fun[35][k]+fun[59][k]+fun[89][k]+fun[92][k]+fun[56][k]+fun[57][k]+fun[58][k]+fun[88][k]+fun[93][k]+fun[85][k]
                    +fun[86][k]+fun[87][k])/24;
            C3[k] = (fun[4][k]+fun[13][k]+fun[28][k]+fun[49][k]+fun[76][k]+fun[11][k]+fun[12][k]+fun[27][k]+fun[48][k]+fun[75][k]+fun[99][k]
                    +fun[25][k]+fun[26][k]+fun[47][k]+fun[74][k]+fun[98][k]+fun[44][k]+fun[45][k]+fun[46][k]+fun[73][k]+fun[97][k]+fun[70][k]
                    +fun[71][k]+fun[72][k])/24;
            C2[k] = (fun[5][k]+fun[14][k]+fun[29][k]+fun[50][k]+fun[77][k]+fun[6][k]+fun[15][k]+fun[30][k]+fun[51][k]+fun[78][k]+fun[16][k]
                    +fun[31][k]+fun[52][k]+fun[79][k]+fun[100][k]+fun[33][k]+fun[32][k]+fun[53][k]+fun[80][k]+fun[101][k]+fun[55][k]+fun[54][k]
                    +fun[81][k]+fun[102][k]+fun[84][k]+fun[83][k]+fun[82][k])/32;
            C4[k] = (fun[2][k]+fun[8][k]+fun[20][k]+fun[38][k]+fun[62][k]+fun[3][k]+fun[9][k]+fun[21][k]+fun[39][k]+fun[63][k]+fun[10][k]
                    +fun[22][k]+fun[40][k]+fun[64][k]+fun[94][k]+fun[24][k]+fun[23][k]+fun[41][k]+fun[65][k]+fun[95][k]+fun[43][k]+fun[42][k]
                    +fun[66][k]+fun[96][k]+fun[69][k]+fun[68][k]+fun[67][k])/32;

            Z2[k] = (fun[1][k] +fun[7][k] +fun[19][k]+fun[37][k]+fun[61][k]+fun[17][k]+fun[18][k]+fun[36][k]+fun[60][k]+fun[90][k]+fun[91][k]
                    +fun[34][k]+fun[35][k]+fun[59][k]+fun[89][k]+fun[92][k]+fun[56][k]+fun[57][k]+fun[58][k]+fun[88][k]+fun[93][k]+fun[85][k]
                    +fun[86][k]+fun[87][k])/24;
            Z4[k] = (fun[4][k] +fun[13][k]+fun[28][k]+fun[49][k]+fun[76][k]+fun[11][k]+fun[12][k]+fun[27][k]+fun[48][k]+fun[75][k]+fun[99][k]
                    +fun[25][k]+fun[26][k]+fun[47][k]+fun[74][k]+fun[98][k]+fun[44][k]+fun[45][k]+fun[46][k]+fun[73][k]+fun[97][k]+fun[70][k]
                    +fun[71][k]+fun[72][k])/24;
            Z1[k] = (fun[5][k]  +fun[14][k]+fun[29][k]+fun[50][k] +fun[77][k]+fun[6][k] +fun[15][k]+fun[30][k]+fun[51][k] +fun[78][k]+fun[16][k]
                    +fun[31][k] +fun[52][k]+fun[79][k]+fun[100][k]+fun[33][k]+fun[32][k]+fun[53][k]+fun[80][k]+fun[101][k]+fun[55][k]+fun[54][k]
                    +fun[81][k]+fun[102][k]+fun[84][k]+fun[83][k] +fun[82][k])/32;
            Z3[k] = (fun[2][k]+fun[8][k]+fun[20][k]+fun[38][k]+fun[62][k]+fun[3][k]+fun[9][k]+fun[21][k]+fun[39][k]+fun[63][k]+fun[10][k]
                    +fun[22][k]+fun[40][k]+fun[64][k]+fun[94][k]+fun[24][k]+fun[23][k]+fun[41][k]+fun[65][k]+fun[95][k]+fun[43][k]+fun[42][k]
                    +fun[66][k]+fun[96][k]+fun[69][k]+fun[68][k]+fun[67][k])/32;  
                        
        }       
        
    }
    
    public double RetDens(int s){
        return Math.abs(suma[s]); 
    }
    public double[] RetAnillo_A1(){
        return A1;
    }
    public double[] RetAnillo_A2(){
        return A2;
    }
    public double[] RetAnillo_A3(){
        return A3;
    }
    public double[] RetAnillo_A4(){
        return A4;
    }
    public double[] RetAnillo_A5(){
        return A5;
    }
    public double[] RetAnillo_A6(){
        return A6;
    }
    public double[] RetCuad_C1D(){
        return C1;
    }
    public double[] RetCuad_C2D(){
        return C2;
    }
    public double[] RetCuad_C3D(){
        return C3;
    }
    public double[] RetCuad_C4D(){
        return C4;
    }
    public double[] RetCuad_C1Z(){
        return Z1;
    }
    public double[] RetCuad_C2Z(){
        return Z2;
    }
    public double[] RetCuad_C3Z(){
        return Z3;
    }
    public double[] RetCuad_C4Z(){
        return Z4;
    }

}
