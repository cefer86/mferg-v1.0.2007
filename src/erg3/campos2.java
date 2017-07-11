
package erg3;

import erg2.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Autor: Cesar Peña
 */
public class campos2 extends javax.swing.JPanel {
    
    private mferg form;
    private Test0 form1;
    private Font f2;
    
    Gauss matod = new Gauss(0.2,0.4);
    Gauss matod1 = new Gauss(-0.6,-0.56);
    Gauss matod2 = new Gauss(-0.6,0.56);
        
    double etiqod[][] = null;
    double etiqod1[][] = null;
    double etiqod2[][] = null;
    int N=37;
    int M=36;
    
    public campos2() {
        initComponents();
    }
    public campos2(mferg fr) {
        this.form = fr;
        
        matod.returnGauss(0.2,0.78);
        etiqod=matod.EstNivGauss();
        matod1.returnGauss(0.154,0.95);
        etiqod1=matod1.EstNivGauss();
        matod2.returnGauss(0.4,0.62);
        etiqod2=matod2.EstNivGauss();
        f2 = new Font("Fuente2",Font.BOLD,10);
    }
    
    public campos2(Test0 fr1){
        this.form1 = fr1;
        matod.returnGauss(0.2,0.78);
        etiqod=matod.EstNivGauss();
        matod1.returnGauss(0.154,0.95);
        etiqod1=matod1.EstNivGauss();
        matod2.returnGauss(0.4,0.62);
        etiqod2=matod2.EstNivGauss();
        f2 = new Font("Fuente2",Font.BOLD,10);
        
    }
    
    
    public void paint(Graphics g) {
        
        super.paintComponent(g);
        
        int deltax=this.getWidth()/(int)90.09899;  //70
        int deltay=this.getHeight()/51; //45
        int ancho_p=2, alto_p=2;
        
        int ix1 = this.getWidth()/2-deltax;
        int ix2 = this.getWidth()/2+deltax;
        int iy1 = this.getHeight()/2-deltax;
        int iy2 = this.getHeight()/2+deltax;
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<M;j++){
                etiqod[i][j]=etiqod[i][j]+etiqod1[i][j]+etiqod2[i][j];
            }
        }
        
        g.translate( this.getInsets().left,this.getInsets().top );
        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.GRAY);
        g.drawLine(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2);
        g.drawLine(this.getWidth()/2,0,this.getWidth()/2,this.getHeight());
        
        g.setColor(Color.GREEN);
        g.setFont(f2);
        g.drawString("ST",this.getWidth()/6,this.getHeight()/3);
        g.drawString("IT",this.getWidth()/6,this.getHeight()/2+this.getHeight()/5);
        g.drawString("SN",this.getWidth()/2+2*this.getWidth()/6,this.getHeight()/3);
        g.drawString("IN",this.getWidth()/2+2*this.getWidth()/6,this.getHeight()/2+this.getHeight()/5);
        
        g.drawString("Ojo Derecho",5,this.getHeight()-10);
        
        g.setColor(Color.RED);
        g.fillRect(8,22,10,10);
        g.setColor(Color.YELLOW);
        g.fillRect(8,35,10,10);
        g.setColor(Color.GREEN);
        g.fillRect(8,48,10,10);
        g.setColor(Color.BLUE);
        g.fillRect(8,61,10,10);
                
        g.setColor(Color.WHITE);
        
 // Cuadrante Superior Nasal
        for(int k=0; k<19;k++){
            for(int j=0;j<8;j++){
                
             if(etiqod[20-(k+1)][18-j]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][18-j]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][18-j]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][18-j]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][18-j]>=4){
                 g.setColor(Color.RED);
             }   
             
            g.fillRect(ix1-k*deltax,iy1-j*deltay,ancho_p,alto_p);
            
            }
        }
        
        
        for(int k=0; k<17;k++){
            for(int j=8;j<12;j++){
                
             if(etiqod[20-(k+1)][7+(11-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][7+(11-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][7+(11-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][7+(11-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][7+(11-j)]>=4){
                 g.setColor(Color.RED);
             }   
                
            g.fillRect(ix1-k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        
        
        
        for(int k=0; k<15;k++){
            for(int j=12;j<14;j++){
                
                if(etiqod[20-(k+1)][5+(13-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][5+(13-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][5+(13-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][5+(13-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][5+(13-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix1-k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        
        for(int k=0; k<13;k++){
            for(int j=14;j<16;j++){
                
              if(etiqod[20-(k+1)][3+(15-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][3+(15-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][3+(15-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][3+(15-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][3+(15-j)]>=4){
                 g.setColor(Color.RED);
             } 
                
        g.fillRect(ix1-k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        
        for(int k=0; k<9;k++){
            for(int j=16;j<18;j++){
                
                if(etiqod[20-(k+1)][1+(17-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][1+(17-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][1+(17-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][1+(17-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][1+(17-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix1-k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        
        // Cuadrante Superior Temporal
        for(int k=0; k<18;k++){
            for(int j=0;j<8;j++){
                
             if(etiqod[19+(k+1)][18-j]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][18-j]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][18-j]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][18-j]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][18-j]>=4){
                 g.setColor(Color.RED);
             }    
                
        g.fillRect(ix2+k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        for(int k=0; k<16;k++){
            for(int j=8;j<12;j++){
                
            if(etiqod[19+(k+1)][7+(11-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][7+(11-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][7+(11-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][7+(11-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][7+(11-j)]>=4){
                 g.setColor(Color.RED);
             }   
                
        g.fillRect(ix2+k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        for(int k=0; k<14;k++){
            for(int j=12;j<14;j++){
                
                if(etiqod[19+(k+1)][5+(13-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][5+(13-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][5+(13-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][5+(13-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][5+(13-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix2+k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        for(int k=0; k<12;k++){
            for(int j=14;j<16;j++){
                
                if(etiqod[19+(k+1)][3+(15-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][3+(15-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][3+(15-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][3+(15-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][3+(15-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix2+k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        for(int k=0; k<8;k++){
            for(int j=16;j<18;j++){
                
                if(etiqod[19+(k+1)][1+(17-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][1+(17-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][1+(17-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][1+(17-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][1+(17-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix2+k*deltax,iy1-j*deltay,ancho_p,alto_p);
            }
        }
        
        // Cuadrante Inferior Nasal
        for(int k=0; k<19;k++){
            for(int j=0;j<8;j++){
                
             if(etiqod[20-(k+1)][18+(j+1)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][18+(j+1)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][18+(j+1)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][18+(j+1)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][18+(j+1)]>=4){
                 g.setColor(Color.RED);
             }    
                
        g.fillRect(ix1-k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
                
        for(int k=0; k<17;k++){
            for(int j=8;j<12;j++){
                
                if(etiqod[20-(k+1)][30-(11-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][30-(11-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][30-(11-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][30-(11-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][30-(11-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix1-k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
         
        
        for(int k=0; k<15;k++){
            for(int j=12;j<14;j++){
                
               if(etiqod[20-(k+1)][32-(13-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][32-(13-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][32-(13-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][32-(13-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][32-(13-j)]>=4){
                 g.setColor(Color.RED);
             }
               
        g.fillRect(ix1-k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
        
        
        for(int k=0; k<13;k++){
            for(int j=14;j<16;j++){
                
                 if(etiqod[20-(k+1)][34-(15-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][34-(15-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][34-(15-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][34-(15-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][34-(15-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix1-k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
        
        
        for(int k=0; k<9;k++){
            for(int j=16;j<18;j++){
                
                 if(etiqod[20-(k+1)][36-(17-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[20-(k+1)][36-(17-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[20-(k+1)][36-(17-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[20-(k+1)][36-(17-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[20-(k+1)][36-(17-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix1-k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
        
        // Cuadrante Inferior Temporal
        for(int k=0; k<18;k++){
            for(int j=0;j<8;j++){
                
                if(etiqod[19+(k+1)][18+j+1]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][18+j+1]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][18+j+1]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][18+j+1]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][18+j+1]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix2+k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
        
        for(int k=0; k<16;k++){
            for(int j=8;j<12;j++){
                
                if(etiqod[19+(k+1)][30-(11-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][30-(11-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][30-(11-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][30-(11-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][30-(11-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix2+k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
        
       
          for(int k=0; k<14;k++){
            for(int j=12;j<14;j++){
                
                if(etiqod[19+(k+1)][32-(13-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][32-(13-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][32-(13-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][32-(13-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][32-(13-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix2+k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
        
        for(int k=0; k<12;k++){
            for(int j=14;j<16;j++){
                
                 if(etiqod[19+(k+1)][34-(15-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][34-(15-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][34-(15-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][34-(15-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][34-(15-j)]>=4){
                 g.setColor(Color.RED);
             }
                
        g.fillRect(ix2+k*deltax,iy2+j*deltay,ancho_p,alto_p);
            }
        }
        for(int k=0; k<8;k++){
            for(int j=16;j<18;j++){
                
             if(etiqod[19+(k+1)][36-(17-j)]==0){
                 g.setColor(Color.BLUE);
             }else if(etiqod[19+(k+1)][36-(17-j)]==1){
                 g.setColor(Color.GREEN);
             }else if(etiqod[19+(k+1)][36-(17-j)]==2){
                 g.setColor(Color.YELLOW);
             }else if(etiqod[19+(k+1)][36-(17-j)]==3){
                 g.setColor(Color.RED);
             }else if(etiqod[19+(k+1)][36-(17-j)]>=4){
                 g.setColor(Color.RED);
             }   
                
        g.fillRect(ix2+k*deltax,iy2+j*deltay,ancho_p,alto_p);
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
