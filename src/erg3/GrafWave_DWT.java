
package erg3;

import javax.swing.JRadioButton;

/**
 *
 * Autor: Cesar Peña
 */
public class GrafWave_DWT extends javax.swing.JFrame {
    
    private int NMAX,L;
    private mferg form;
    private Integer[][] coff=null;
    private boolean min1;
    private boolean max1;
    public GrafWave_DWT(){}
    
    public GrafWave_DWT(Integer[][] cof, int NMAX,int L, mferg fr,String cuad,String ojo) {
        this.NMAX = NMAX;
        this.coff = cof;
        this.L = L;
        this.form = fr;
        this.setTitle("Ojo "+ojo+" - "+cuad+" - Análisis mfERG - V. 1.0 Cesar Peña");
        this.setLocation(50,50);
        initComponents();
    }
    

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        grafdwtD1 = new GrafdwtD(this,coff,NMAX,L,form);
        datosMMM1 = new DatosMMM(this,form);
        jPanel1 = new javax.swing.JPanel();
        min = new javax.swing.JRadioButton();
        max = new javax.swing.JRadioButton();

        setResizable(false);
        grafdwtD1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout grafdwtD1Layout = new org.jdesktop.layout.GroupLayout(grafdwtD1);
        grafdwtD1.setLayout(grafdwtD1Layout);
        grafdwtD1Layout.setHorizontalGroup(
            grafdwtD1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 751, Short.MAX_VALUE)
        );
        grafdwtD1Layout.setVerticalGroup(
            grafdwtD1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 447, Short.MAX_VALUE)
        );

        datosMMM1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout datosMMM1Layout = new org.jdesktop.layout.GroupLayout(datosMMM1);
        datosMMM1.setLayout(datosMMM1Layout);
        datosMMM1Layout.setHorizontalGroup(
            datosMMM1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 169, Short.MAX_VALUE)
        );
        datosMMM1Layout.setVerticalGroup(
            datosMMM1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 110, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Estad\u00edsticas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11), new java.awt.Color(0, 0, 0)));
        min.setFont(new java.awt.Font("Arial", 0, 11));
        min.setText("M\u00ednimo");
        min.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        min.setMargin(new java.awt.Insets(0, 0, 0, 0));
        min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minActionPerformed(evt);
            }
        });

        max.setFont(new java.awt.Font("Arial", 0, 11));
        max.setText("M\u00e1ximo");
        max.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        max.setMargin(new java.awt.Insets(0, 0, 0, 0));
        max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(min)
                .add(19, 19, 19)
                .add(max)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(min)
                    .add(max))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(grafdwtD1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(datosMMM1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(20, 20, 20)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(grafdwtD1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(datosMMM1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxActionPerformed
        JRadioButton act = (JRadioButton)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && as==false){
            as = true;
            max1 = !as;
            grafdwtD1.repaint();
        }else if(act.getVerifyInputWhenFocusTarget() && as==true){
            as = false;
            max1 = !as;
            grafdwtD1.repaint();
        }
    }//GEN-LAST:event_maxActionPerformed

    private void minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minActionPerformed
     JRadioButton act = (JRadioButton)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && as1==false){
            as1 = true;
            min1 = !as1;
            grafdwtD1.repaint();
        }else if(act.getVerifyInputWhenFocusTarget() && as1==true){
            as1 = false;
            min1 = !as1;
            grafdwtD1.repaint();
        }
    }//GEN-LAST:event_minActionPerformed
    boolean as = true; 
    boolean as1 = true;
    
    public boolean RetSMax(){
        return max1;
    }
    public boolean RetSMin(){
        return min1;
    }    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrafWave_DWT().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private erg3.DatosMMM datosMMM1;
    private erg3.GrafdwtD grafdwtD1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton max;
    private javax.swing.JRadioButton min;
    // End of variables declaration//GEN-END:variables
    
}
