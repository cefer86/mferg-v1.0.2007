
package erg3;

import erg2.Test0;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JSlider;
/**
 *
 * Autor: Cesar Peña
 */
public class DWT_Form1 extends javax.swing.JFrame {
    
    private DWT_Des DD[]=null,f11,f12,f21,f22;
    private double dvk1,dsk1,dvk2,dsk2,dvk3,dsk3;
    private double s_ent[]=null;//{-2.7210,-3.6739,-4.0364,-3.7389,-2.8703,-1.6527,-0.3843,0.6347,1.1755,1.1336,0.5503,-0.4036,-1.4755,-2.3970,-2.9526,-3.0309,-2.6485,-1.9392,-1.1131,-0.3980,0.0223,0.0554,-0.2787,-0.8574,-1.4939,-1.9914};
    private double det1[]=null,apx1[]=null,det2[]=null,apx2[]=null,det[][]=null,apx[][]=null;
    private double C[] = null;
    private Integer L[] = null;
    public DWT_Coef cc1;
    private String opc;
    Font  f2 = new Font("Fuente1",Font.BOLD,10);
    String ojo, cuad;
    private int Nmax=3;
    public Test0 frame;
    
    public DWT_Form1(){}
    
    public DWT_Form1(Test0 frame, double[] ent, String cuad, String ojo) {
        this.setTitle( cuad +"-"+ojo+": Descomposición - mfERG - V. 1.0 Cesar Peña");
        this.frame = frame;
        this.ojo = ojo;
        this.cuad = cuad;
        this.s_ent = ent;
        
        this.det = new double[Nmax][];
        this.apx = new double[Nmax][];
        this.DD = new DWT_Des[Nmax*2];
        this.DD[0] = new DWT_Des(s_ent,"D");
        this.DD[1] = new DWT_Des(s_ent,"A");
        this.det[0] = DD[0].RetDownSampled();
        this.apx[0] = DD[1].RetDownSampled();  
        for(int j=2;j<2*Nmax;j+=2){
            DD[j]= new DWT_Des(apx[(j-2)/2],"D");
            DD[j+1]= new DWT_Des(apx[(j-2)/2],"A");
            det[j-j/2]= DD[j].RetDownSampled();
            apx[j-j/2]= DD[j+1].RetDownSampled();
        }
         int sdet=0;
         for(int i=0;i<det.length;i++) sdet=sdet+det[i].length;
         sdet=sdet+apx[Nmax-1].length;
         this.C = new double[sdet];
         this.L = new Integer[Nmax+3];
         int s1,s2;
         s1=apx[Nmax-1].length;
         s2=apx[Nmax-1].length+det[Nmax-1].length;
         
         int p=1;
         for(int k=0;k<C.length;k++){
             if(k>=0 && k<=apx[Nmax-1].length-1) C[k]=apx[Nmax-1][k];
             if(k>s1-1 && k<=s2-1) C[k]=det[Nmax-p][k-s1];
                if(k==s2-1 && k!=C.length-1){
                        s1=apx[Nmax-1].length;
                        s2=apx[Nmax-1].length+det[Nmax-1].length;
                     for(int r=0;r<p;r++){
                     s1=s1+det[Nmax-1-r].length;
                     s2=s2+det[Nmax-2-r].length;
                    }
                 p++;
                }
         }
        L[1]=apx[Nmax-1].length; 
        L[L.length-1]=s_ent.length;
        for(int s=2;s<=L.length-2;s++) L[s]=det[Nmax-s+1].length;

//        this.f11 = new DWT_Des(s_ent,"D");
//        this.det1 = f11.RetDownSampled();
//        this.f12 = new DWT_Des(s_ent,"A");
//        this.apx1 = f12.RetDownSampled();
//        this.f21 = new DWT_Des(apx1,"D");
//        this.det2 = f21.RetDownSampled();
//        this.f22 = new DWT_Des(apx1,"A");
//        this.apx2 = f22.RetDownSampled();
//        
//        this.C = new double[apx2.length+det2.length+det1.length];
//        this.L = new Integer[5];
//        for(int k=0;k<C.length;k++){
//            if(k>=0 && k<=apx2.length-1) C[k]=apx2[k];
//            else if(k>apx2.length-1 && k<=apx2.length+det2.length-1) C[k]=det2[k-apx2.length];
//            else if(k>apx2.length+det2.length-1) C[k]=det1[k-apx2.length-det2.length];
//        } 
//        L[1]=apx2.length; 
//        L[2]=det2.length; 
//        L[3]=det1.length;
//        L[4]=s_ent.length;
        
        initComponents();
        mV_S.setMajorTickSpacing(10);
        mV_S.setMinorTickSpacing(5);
        mV_S.setPaintTicks(true);
        mV_S.setValue(50);
        mV_S.setBorder(BorderFactory.createEmptyBorder(0,0,5,5)); 
        ms_S.setMajorTickSpacing(10);
        ms_S.setMinorTickSpacing(5);
        ms_S.setPaintTicks(true);
        ms_S.setValue(50);
        ms_S.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        jComboBox1.setSelectedIndex(0);
        jComboBox1.setFont(f2);
        this.cc1 = new DWT_Coef(C,L,s_ent.length,Nmax);
        
//        for(int l=0;l<det[0].length;l++)System.out.println("Det0["+l+"]= "+det[0][l]);
//        for(int l=0;l<det[1].length;l++)System.out.println("Det1["+l+"]= "+det[1][l]);
//        for(int l=0;l<det[2].length;l++)System.out.println("Det2["+l+"]= "+det[2][l]);        
//        for(int l=0;l<apx[0].length;l++)System.out.println("Aprox0["+l+"]= "+apx[0][l]);
//        for(int l=0;l<apx[1].length;l++)System.out.println("Aprox1["+l+"]= "+apx[1][l]);
//        for(int l=0;l<apx[2].length;l++)System.out.println("Aprox2["+l+"]= "+apx[2][l]);        
//        for(int l=0;l<C.length;l++)System.out.println("C["+l+"]= "+C[l]);
//        for(int l=1;l<L.length;l++)System.out.println("L["+l+"]= "+L[l]);
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mV_S = new javax.swing.JSlider();
        jPanel3 = new javax.swing.JPanel();
        ms_S = new javax.swing.JSlider();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        graf_DWT1 = new Graf_DWT(this,ojo,cuad);
        graf_DWT_A1 = new Graf_DWT_A(this,cuad);
        graf_DWT_D1 = new Graf_DWT_D(this,cuad);

        setResizable(false);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escalado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-      mV/Div     +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        mV_S.setForeground(new java.awt.Color(204, 0, 51));
        mV_S.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mV_SStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mV_S, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(mV_S, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-      ms/Div     +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        ms_S.setForeground(new java.awt.Color(204, 0, 0));
        ms_S.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ms_SStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ms_S, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(ms_S, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Niveles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aproximaci\u00f3n", "Detalle" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jComboBox1, 0, 102, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        graf_DWT1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout graf_DWT1Layout = new org.jdesktop.layout.GroupLayout(graf_DWT1);
        graf_DWT1.setLayout(graf_DWT1Layout);
        graf_DWT1Layout.setHorizontalGroup(
            graf_DWT1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 658, Short.MAX_VALUE)
        );
        graf_DWT1Layout.setVerticalGroup(
            graf_DWT1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 174, Short.MAX_VALUE)
        );

        graf_DWT_A1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout graf_DWT_A1Layout = new org.jdesktop.layout.GroupLayout(graf_DWT_A1);
        graf_DWT_A1.setLayout(graf_DWT_A1Layout);
        graf_DWT_A1Layout.setHorizontalGroup(
            graf_DWT_A1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 658, Short.MAX_VALUE)
        );
        graf_DWT_A1Layout.setVerticalGroup(
            graf_DWT_A1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 188, Short.MAX_VALUE)
        );

        graf_DWT_D1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout graf_DWT_D1Layout = new org.jdesktop.layout.GroupLayout(graf_DWT_D1);
        graf_DWT_D1.setLayout(graf_DWT_D1Layout);
        graf_DWT_D1Layout.setHorizontalGroup(
            graf_DWT_D1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 658, Short.MAX_VALUE)
        );
        graf_DWT_D1Layout.setVerticalGroup(
            graf_DWT_D1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 175, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(graf_DWT_D1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, graf_DWT_A1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, graf_DWT1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(33, 33, 33)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(graf_DWT1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(graf_DWT_A1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(graf_DWT_D1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(38, 38, 38))))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    JComboBox cb = (JComboBox)evt.getSource();
        opc = (String)cb.getSelectedItem();
        graf_DWT1.repaint();
        graf_DWT_A1.repaint();
        graf_DWT_D1.repaint();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ms_SStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ms_SStateChanged
    JSlider bl2 = (JSlider)evt.getSource();
        if (!bl2.getValueIsAdjusting()) {
            double fps = (double)((JSlider)evt.getSource()).getValue()-50;
            dsk1 = fps;
        }  
        graf_DWT1.repaint();
        graf_DWT_A1.repaint();
        graf_DWT_D1.repaint();
    }//GEN-LAST:event_ms_SStateChanged

    private void mV_SStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mV_SStateChanged
    JSlider bl1 = (JSlider)evt.getSource();
        if (!bl1.getValueIsAdjusting()) {
            double fps = (double)((JSlider)evt.getSource()).getValue()-50;
            dvk1 = fps;
        }
        graf_DWT1.repaint();
        graf_DWT_A1.repaint();
        graf_DWT_D1.repaint();
    }//GEN-LAST:event_mV_SStateChanged
    
    public double Ret_mV(){
        return dvk1;
    }
    public double Ret_ms(){
        return dsk1;
    }
    public double[] Ret_S(){
        return s_ent;
    }
    public double[] Ret_A1(){
        return apx[Nmax-2];
    }
    public double[] Ret_D1(){
        return det[Nmax-2];
    }
    public double[] Ret_A2(){
        return apx[Nmax-1];
    }
    public double[] Ret_D2(){
        return det[Nmax-1];
    }
    public String Ret_opc(){
        return opc;
    }    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DWT_Form1().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private erg3.Graf_DWT graf_DWT1;
    private erg3.Graf_DWT_A graf_DWT_A1;
    private erg3.Graf_DWT_D graf_DWT_D1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSlider mV_S;
    private javax.swing.JSlider ms_S;
    // End of variables declaration//GEN-END:variables
    
}
