package erg2;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Datos.AbrirGuardar;

/**
 *
 * Autor: Cesar Peña
 */
public class ProsOjo extends javax.swing.JFrame {
    
    private String ojoEst;
    private Test0 fr;
    private AbrirGuardar ag1;
    Font  f2 = new Font("Fuente1",Font.BOLD,10);
    
    public ProsOjo(Test0 fr){
        this.fr = fr;
        this.setTitle("Ojo Estimulado");
        this.setLocation(500,500);
        initComponents();
        ojosel.setSelectedIndex(0);
        ojosel.setFont(f2);
    }
    public ProsOjo() {
        initComponents();
    }
    
   
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        ojosel = new javax.swing.JComboBox();
        ok2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        canc = new javax.swing.JButton();

        setResizable(false);
        ojosel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Derecho", "Izquierdo" }));
        ojosel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ojoselActionPerformed(evt);
            }
        });

        ok2.setFont(new java.awt.Font("Arial", 0, 11));
        ok2.setText("O.K");
        ok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel1.setText("Seleccione el Ojo : ");

        canc.setFont(new java.awt.Font("Arial", 0, 11));
        canc.setText("Cancelar");
        canc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ojosel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(ok2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(canc, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(ok2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(canc)
                    .add(ojosel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancActionPerformed
        this.setVisible(false);
        if((!this.fr.listo_prosc_i && !this.fr.listo_prosc_d) || (this.fr.listo_prosc_i && !this.fr.listo_prosc_d) || (!this.fr.listo_prosc_i && this.fr.listo_prosc_d)) {
               this.fr.estimulado = true;
           }
    }//GEN-LAST:event_cancActionPerformed

    private void ojoselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ojoselActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        ojoEst = (String)cb.getSelectedItem();
    }//GEN-LAST:event_ojoselActionPerformed

    private void ok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok2ActionPerformed
          this.fr.Import_estim=false;
          ag1 = new AbrirGuardar(this.fr,true);
          ag1.setVisible(true);
          if(!ag1.RetEstado()){
          this.fr.s_entrada = ag1.RetSignal();
          this.fr.tiempo_muest = ag1.RetTiempoMuestreo();
          ag1.setVisible(false);
        try{
           this.fr.kernels = new Kernels(this.fr,this.RetOjo_Pros());
           this.fr.indice_timeImD = this.fr.kernels.k11.correlacion.RetIndice_time();
           this.fr.kernels.setVisible(true);
           this.fr.kernels.guardar.setEnabled(true);
           this.fr.k1Graf = this.fr.kernels.RetK1graf();
           this.setVisible(false);
            if(this.RetOjo_Pros()=="Izquierdo"){
            this.fr.ddkk = new DensK(this.fr);
            this.fr.listo_prosc_i = true;}
            else if(this.RetOjo_Pros()=="Derecho"){ 
            this.fr.ddkk2 = new DensK(this.fr);
            this.fr.listo_prosc_d = true;}
            if(this.fr.listo_prosc_i && this.fr.listo_prosc_d) {
            this.fr.importar.setEnabled(true);
             }
        this.fr.ojoEst = this.ojoEst;   
        this.fr.on_offwvf = "on_wvf";
        this.fr.on_offdr = "on_dr";
        this.fr.anaDatos1.repaint();    
        }catch(java.lang.NullPointerException e){
        JOptionPane.showMessageDialog(null,"No se ha realizado NINGÚN Estimulo ","Error!",2);}
          }else {this.setVisible(false);ag1.setVisible(false);}
    }//GEN-LAST:event_ok2ActionPerformed
    
    public String RetOjo_Pros(){
        return ojoEst;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProsOjo().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox ojosel;
    private javax.swing.JButton ok2;
    // End of variables declaration//GEN-END:variables
    
}
