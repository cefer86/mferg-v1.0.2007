package Datos;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import jxl.*;
import erg2.*;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.write.Label;

/**
 *
 * Autor: Cesar Peña
 */
public class AbrirGuardar extends javax.swing.JFrame {
    
    int sel;
    String path="";
    private Date fechaex;
    private Test0 form;
    private double kern1[]=null, kern2[]=null, kern3[]=null;
    private double v_kern1[]=null, v_kern2[]=null, v_kern3[]=null;
    public  double v_mferg[] = null, dt;
    public  double v_k1[]=null, v_k2[]=null, v_k3[]=null;
    private Cell cs1[] = null, cs2[]=null, cs3[]=null;
    private Cell cs1k[] = null, cs2k[]=null, cs3k[]=null;
    public double k1[]=null, k2[]=null, k3[]=null;
    public double  pb,ts;
    public int tp,oe,indice_timeImD;
    public String np,edad,te,uni,doc_identidad,apellido;
    int long_sent0=0,long_sent1=0,long_sent2=0,long_sentk=0;
    private boolean cancelar=false;
    
    public AbrirGuardar() {}
    public AbrirGuardar(Test0 fr, boolean abrir) {
        this.form = fr;
        initComponents();
        if(abrir){
            abgd.setDialogType(JFileChooser.OPEN_DIALOG);
            abgd.setDialogTitle("Abrir Datos - mfERG v1.0 - Cesar Peña");
        }else if(!abrir){
            abgd.setDialogType(JFileChooser.SAVE_DIALOG);
            abgd.setDialogTitle("Guardar Datos - mfERG v1.0 - Cesar Peña");
        }
        this.sel = abgd.showOpenDialog(this);
        if(sel== JFileChooser.APPROVE_OPTION){
            File archivo = abgd.getSelectedFile();
            path = archivo.getAbsolutePath();
            path = path.substring(3,path.length());
            if(abrir)path = "C:\\"+path;
            else  path = "C:\\"+path+".xls";
            if(path.charAt(path.length()-1)!='s' && path.charAt(path.length()-2)!='l' && path.charAt(path.length()-3)!='x')
            JOptionPane.showMessageDialog(null,"Error: Este no es un Formato Válido");
            else{
                if(abrir){
          if(fr.Import_estim){          
                  try {
                      Workbook wr = Workbook.getWorkbook(new File(path));
                      Sheet shr01 = wr.getSheet("PrePros01"); 
                      Sheet shr02 = wr.getSheet("PrePros02"); 
                      Sheet shr03 = wr.getSheet("PrePros03");                       
                      Sheet shr1 = wr.getSheet("PrePros1"); 
                      long_sent0 = shr01.getRows();
                      long_sent1 = shr02.getRows();
                      long_sent2 = shr03.getRows();
                      long_sentk = shr1.getRows();
                      v_k1 = new double[long_sent0*103]; 
                      v_k2 = new double[long_sent1*103]; 
                      v_k3 = new double[long_sent2*103]; 
                      k1 = new double[long_sentk]; 
                      k2 = new double[long_sentk]; 
                      k3 = new double[long_sentk]; 
                      pb=Double.parseDouble(shr1.getCell(3,0).getContents());
                      ts=Double.parseDouble(shr1.getCell(3,10).getContents());
                      tp=Integer.parseInt(shr1.getCell(3,1).getContents());
                      te=shr1.getCell(3,2).getContents();
                      oe=Integer.parseInt(shr1.getCell(3,3).getContents());
                      np=shr1.getCell(3,4).getContents();
                      edad=shr1.getCell(3,5).getContents();
                      uni=shr1.getCell(3,6).getContents();
                      indice_timeImD = Integer.parseInt(shr1.getCell(3,7).getContents());
                      doc_identidad = shr1.getCell(3,8).getContents();
                      apellido = shr1.getCell(3,9).getContents();
                      this.form.nom_p.setText(np);
                      this.form.apl_p.setText(apellido);
                      this.form.edad_p.setText(edad);
                      this.form.doc_p.setText(doc_identidad);
                      this.form.fc_muest.setText("Frecuencia de muestreo: "+new BigDecimal((1/ts)).setScale(4,BigDecimal.ROUND_UP)+" KHz");
                      if(uni=="S")this.form.frec_est.setText("Frecuencia de Estímulo: "+new BigDecimal((1/pb)).setScale(4,BigDecimal.ROUND_UP)+" Hz");
                      else this.form.frec_est.setText("Frecuencia de Estímulo: "+new BigDecimal((1/pb)).setScale(4,BigDecimal.ROUND_UP)+" KHz");
                      if(oe==2)this.form.o_est.setText("Ojo Estimulado: Derecho");
                      else this.form.o_est.setText("Ojo Estimulado: Izquierdo");
                      
                      for(int i=0;i<103;i++){
                          for(int j=0;j<long_sent0;j++){
                             this.v_k1[j+i*long_sent0] = Double.parseDouble(shr01.getCell(i,j).getContents());
                          }
                      }
                      for(int i=0;i<103;i++){
                          for(int j=0;j<long_sent1;j++){
                             this.v_k2[j+i*long_sent1] = Double.parseDouble(shr02.getCell(i,j).getContents());
                             }
                      }
                      for(int i=0;i<103;i++){
                          for(int j=0;j<long_sent2;j++){
                             this.v_k3[j+i*long_sent2] = Double.parseDouble(shr03.getCell(i,j).getContents()); 
                          }                          
                      }
                      
                      for(int i=0;i<long_sentk;i++){
                      this.k1[i] = Double.parseDouble(shr1.getCell(0,i).getContents());
                      this.k2[i] = Double.parseDouble(shr1.getCell(1,i).getContents());
                      this.k3[i] = Double.parseDouble(shr1.getCell(2,i).getContents());
                      }

                  } catch (Exception ex) {
                      ex.printStackTrace();}
                      }else if(!fr.Import_estim){
                               try {
                                  Workbook wk = Workbook.getWorkbook(new File(path));
                                  Sheet sh = wk.getSheet(0);
                                  long_sent0 = sh.getRows();
                                  cs1 = new Cell[long_sent0];
                                  dt = Double.parseDouble(sh.getCell(0,1).getContents()) - Double.parseDouble(sh.getCell(0,0).getContents());
                                  v_mferg = new double[long_sent0]; 
                                  if(this.form.uni_tiempo=="mS")this.form.pbreal.setText("P.B Calculado: "+(this.form.base_tiempo+((long_sent0*dt*1000)/this.form.M-this.form.base_tiempo)));
                                  else if(this.form.uni_tiempo=="S")this.form.pbreal.setText("P.B Calculado: "+(this.form.base_tiempo+((long_sent0*dt)/this.form.M-this.form.base_tiempo)));
                                  for(int i=0;i<cs1.length;i++){
                                  cs1[i] = sh.getCell(1,i); 
                                  this.v_mferg[i] = Double.parseDouble(cs1[i].getContents());
                                  }
                              } catch (Exception ex) {
                                  ex.printStackTrace();}
                      }
            }else if(!abrir){
                        try {
                            
                            WritableWorkbook wk = Workbook.createWorkbook(new File(path));
                            WritableSheet sh01 = wk.createSheet("PrePros01",1);
                            WritableSheet sh02 = wk.createSheet("PrePros02",2);
                            WritableSheet sh03 = wk.createSheet("PrePros03",3);
                            WritableSheet sh1 = wk.createSheet("PrePros1",4);
                            this.v_kern1 = this.form.kernels.k11.RetK1wvf();
                            this.v_kern2 = this.form.kernels.k21.RetK2wvf();
                            this.v_kern3 = this.form.kernels.k31.RetK3wvf();
                            this.kern1 = this.form.kernels.k11.RetK1_binaryCan();
                            this.kern2 = this.form.kernels.k21.RetK2_binaryCan();
                            this.kern3 = this.form.kernels.k31.RetK3_binaryCan();
                            for(int i=0; i<103;i++){
                                for(int j=0;j<this.form.kernels.k11.RetK1wvf().length/103;j++)
                                    sh01.addCell(new Number(i,j,v_kern1[j+i*this.form.kernels.k11.RetK1wvf().length/103]));}
                            for(int i=0; i<103;i++){
                                for(int j=0;j<this.form.kernels.k21.RetK2wvf().length/103;j++)
                                    sh02.addCell(new Number(i,j,v_kern2[j+i*this.form.kernels.k21.RetK2wvf().length/103]));}
                            for(int i=0; i<103;i++){
                                for(int j=0;j<this.form.kernels.k31.RetK3wvf().length/103;j++)
                                    sh03.addCell(new Number(i,j,v_kern3[j+i*this.form.kernels.k31.RetK3wvf().length/103]));}
                            
                            for(int i=0;i<this.form.kernels.k11.RetK1_binaryCan().length;i++){
                                sh1.addCell(new Number(0,i,kern1[i]));}
                            for(int i=0;i<this.form.kernels.k21.RetK2_binaryCan().length;i++){
                                sh1.addCell(new Number(1,i,kern2[i]));}
                            for(int i=0;i<this.form.kernels.k31.RetK3_binaryCan().length;i++){
                                sh1.addCell(new Number(2,i,kern3[i]));}
                                sh1.addCell(new Number(3,0,this.form.base_tiempo));
                                sh1.addCell(new Number(3,1,this.form.M));
                                sh1.addCell(new Label(3,2,this.form.tipo_est));
                                if(this.form.Ret_ojoEst()=="Derecho")sh1.addCell(new Number(3,3,2));
                                 if(this.form.Ret_ojoEst()=="Izquierdo")sh1.addCell(new Number(3,3,1));
                                sh1.addCell(new Label(3,4,this.form.nom_p.getText()));
                                sh1.addCell(new Label(3,5,this.form.edad_p.getText()));
                                sh1.addCell(new Label(3,6,this.form.uni_tiempo));
                                sh1.addCell(new Number(3,7,this.form.kernels.k11.correlacion.RetIndice_time()));
                                sh1.addCell(new Label(3,8,this.form.doc_p.getText()));
                                sh1.addCell(new Label(3,9,this.form.apl_p.getText()));
                                sh1.addCell(new Number(3,10,this.form.tiempo_muest));
                                sh1.addCell(new Label(3,11,new Date().toString()));
                                wk.write();    
                                wk.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch(WriteException es){
                            es.printStackTrace();}

            }                            // Fin del IF de Abrir o Guardar
      
      }
        }else if(sel==JFileChooser.CANCEL_OPTION){this.cancelar=true; }
        else{;}
            
    }
    

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        abgd = new javax.swing.JFileChooser();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        abgd.setCurrentDirectory(new java.io.File("C:\\Docs_mfERG"));
        abgd.setDialogTitle("");
        abgd.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        abgd.setFont(new java.awt.Font("Arial", 0, 11));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(abgd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(abgd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbrirGuardar().setVisible(true);
            }
        });
    }
    

    public double[] RetSignal(){
        return v_mferg;
    }
    public double[] RetSignal_K1(){
        return v_k1;
    }
    public double[] RetSignal_K2(){
        return v_k2;
    }
    public double[] RetSignal_K3(){
        return v_k3;
    }
    public double[] RetS_K1(){
        return k1;
    }
    public double[] RetS_K2(){
        return k2;
    }
    public double[] RetS_K3(){
        return k3;
    }
    public double RetTiempoMuestreo(){
        return dt;
    }
    public int RetIndice_timeImD(){
        return indice_timeImD;
    }
    public boolean RetEstado(){
        return cancelar;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser abgd;
    // End of variables declaration//GEN-END:variables
    
}
