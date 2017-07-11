
package erg3;

/**
 *
 * Autor: Cesar Peña
 */
public class DWT_Coef {

    private double cof[][] = null, coff[]=null;
    private Integer cof_cc[][]=null;
    private Integer sum_A[] = null;
    private Integer fst[] = null,primero[]=null,lg[]=null,ultimo[]=null;
    private double dd1[] = null,tmp2[][]=null;
    private double maximo[]=null, minimo[]=null, maxcof, mincof,medcof,tem;
    public int NMAX_Codf=64,ls,nivel,imx,jmx,imn,jmn,imed,jmed;    
    
    public DWT_Coef(double[] C, Integer[] L, int ls, int nivel) {
        this.ls = ls;
        this.nivel= nivel;
        this.cof = new double[nivel+1][ls];
        this.coff = new double[(cof.length-1)*ls+nivel-1];
        for(int u=0;u<cof.length-1;u++){
           dd1 = Ret_CoefDetalle(C,L,u);
           this.tmp2 = new double[(int)(Math.pow(2,u+1))+1][dd1.length];
           for(int h=1;h<tmp2.length;h++){
               for(int j=1;j<dd1.length;j++) tmp2[h][j]=dd1[j];
           }
           cof[u+1]=Ext_Coef(tmp2,dd1.length,ls,u+1);
        }
            cof_cc=Cod_Color(cof,ls);
            cof_cc=Flip_UD(cof_cc,ls);
            mincof=Math.abs(cof[1][1]);
            tem=Math.abs(this.RetMedia()-cof[1][1]);
            imed=1;
            jmed=1;
            for(int i=1;i<cof.length;i++){  
                for(int j=1;j<cof[i].length;j++){
                    if(maxcof>=Math.abs(cof[i][j])) maxcof = maxcof;
                    else if(maxcof<Math.abs(cof[i][j])) {maxcof =Math.abs(cof[i][j]);imx=i+cof.length-2*i; jmx=j;}
                    if(mincof<=Math.abs(cof[i][j])) mincof = mincof;
                    else if(mincof>Math.abs(cof[i][j])){mincof =Math.abs(cof[i][j]);imn=i+cof.length-2*i; jmn=j;}
                
                    if(i>=1 && j>1){
                    if(Math.abs(cof[i][j]-this.RetMedia())<tem) {
                        imed=i+cof.length-2*i;
                        jmed=j;
                        tem=Math.abs(cof[i][j]-this.RetMedia());
                        }else{
                        imed=imed;
                        jmed=jmed;
                        tem=tem;
                        }
                      }
                    }
              }
//            for(int i=1;i<cof_cc.length;i++){
//            for(int j=1;j<cof_cc[i].length;j++)System.out.println("cof_cc["+i+","+j+"]= "+cof_cc[i][j]);}
    }
    
    public double[] Ret_CoefDetalle(double[] c, Integer[] d, int u){
        
        this.fst = SumaAcum(d);
        this.primero = new Integer[fst.length-2];
        this.lg = new Integer[d.length-2];
        this.ultimo = new Integer[lg.length];
          
        for(int j=fst.length-2;j>=1;j--) primero[fst.length-2-j]=fst[j];
        for(int i=fst.length-1;i>=2;i--) lg[fst.length-1-i]=d[i];
        for(int k=1;k<lg.length;k++) ultimo[k]=lg[k]+primero[k]-1;
        double tmp[] = new double[ultimo[u+1]-primero[u+1]+2];
        for(int h=primero[u+1];h<=ultimo[u+1];h++)tmp[h-primero[u+1]+1]=c[h-1];

        return tmp;
    }
    public Integer[] SumaAcum(Integer[] Z){
        int suma=0;
        this.sum_A = new Integer[Z.length];
        for(int x=1;x<Z.length;x++){ 
            suma=suma+Z[x];
            sum_A[x]=suma+1;
        }
        return sum_A;
    }
    public double[] Ext_Coef(double[][] x,int n, int L, int u){ 
        
        float d=0.0f;
        int p_o,s_o;
        double tmp3[] = new double[(x.length-1)*n-(int)(Math.pow(2,u)-1)];
        double tmp4[] = null;
        for(int i=1;i<x.length;i++){
            for(int j=1;j<x[i].length;j++) tmp3[(j-1)*(x.length-1)+i]=x[i][j];}

        d=(tmp3.length-L)/2;
        p_o = (int)(1+Math.floor(d));
        s_o = (int)(tmp3.length-1-Math.ceil(d));
        if(L >=20 && L%5==0 && L%10!=0 && L%2!=0)tmp4 = new double[s_o-p_o+2+1];
        else tmp4 = new double[s_o-p_o+2];
        for(int y=p_o;y<=s_o;y++) {
            if(Math.abs(tmp3[y])<Math.pow(2,-52))tmp4[y-p_o+1]=0.0;
            else tmp4[y-p_o+1]=tmp3[y];
        }
        
        return tmp4;
    }
    
    public Integer[][] Cod_Color(double[][] M, int ls){
        double M_trans[][]= new double[ls+1][M.length];
        double M_trans2[][]= new double[ls+1][M.length];
        Integer tmp5[][]=new Integer[M.length][ls+1];
        this.maximo = new double[M.length];
        this.minimo = new double[M.length];
        
        for(int k=1;k<minimo.length;k++) minimo[k]=1.5;
        for(int i=1;i<M_trans.length;i++){
            for(int j=1;j<M_trans[i].length;j++){ 
                M_trans[i][j]=Math.abs(M[j][i]);
                if(minimo[j]<=M_trans[i][j]) minimo[j] = minimo[j];
                else if(minimo[j]>M_trans[i][j]) minimo[j] =M_trans[i][j];
            }
        }
        for(int i=1;i<M_trans.length;i++){
            for(int j=1;j<M_trans[i].length;j++){
                if(M_trans[i][j]==minimo[j]) M_trans[i][j]=0.0;
                else M_trans[i][j]=M_trans[i][j]-minimo[j];
             }
        }  
       for(int i=1;i<M_trans.length;i++){
            for(int j=1;j<M_trans[i].length;j++){
                if(maximo[j]>=M_trans[i][j]) maximo[j] = maximo[j];
                else if(maximo[j]<M_trans[i][j]) maximo[j] =M_trans[i][j];
            }
        }
        for(int i=1;i<M_trans2.length;i++){
            for(int j=1;j<M_trans2[i].length;j++){
                M_trans2[i][j]=maximo[j];
            }
        }
        for(int i=1;i<M_trans2.length;i++){
            for(int j=1;j<M_trans2[i].length;j++){
                M_trans[i][j]= Math.floor(NMAX_Codf*M_trans[i][j]/M_trans2[i][j])+1;
            }
        }
        for(int i=1;i<tmp5.length;i++){
            for(int j=1;j<tmp5[i].length;j++){
               if(M_trans[j][i]>NMAX_Codf)tmp5[i][j]=NMAX_Codf;
               else tmp5[i][j]=(int)M_trans[j][i]; 
            }
        }
        return tmp5;
    }
    
    public Integer[][] Flip_UD(Integer[][] K, int ls){
        Integer Kx[][] = new Integer[K.length][ls+1];
        for(int i=1;i<Kx.length;i++){
            for(int j=1;j<Kx[i].length;j++)Kx[i][j]= K[i+K.length-2*i][j];}
        return Kx;
    }
    
    public Integer[][] Ret_Cof(){
        return cof_cc;
    }
    public int RetNMAX(){
        return NMAX_Codf;
    }
    public int RetLsignal(){
        return ls;
    }
    public double RetMinimo(){
        return mincof;
    }
    public double RetMaximo(){
        return maxcof;
    }
    public int RetTotalCoef(){
        return ls*nivel;
    }
    public int Ret_imx(){
        return imx;
    }
    public int Ret_jmx(){
        return jmx;
    }
    public int Ret_imn(){
        return imn;
    }
    public int Ret_jmn(){
        return jmn;
    }
    public int Ret_imed(){
        return imed;
    }
    public int Ret_jmed(){
        return jmed;
    }
    public double RetMedia(){
       double suma=0.0,N=0;
       for(int i=1;i<cof.length;i++){
       for(int j=1;j<cof[i].length;j++){
           suma=suma+Math.abs(cof[i][j]); N=N+1;     
           }
        }
       suma=suma/N;
       return suma;
    }
       
}
