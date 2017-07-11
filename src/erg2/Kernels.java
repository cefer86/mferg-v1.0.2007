
package erg2;


import erg2.Preprosc;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import Datos.AbrirGuardar;
/**
 *
 * Autor: Cesar Peña
 *
 */

public class Kernels extends javax.swing.JFrame {
    
    private Test0 form1;
    private double dvk1,dvk2,dvk3;
    private double dsk1,dsk2,dsk3;
    private AbrirGuardar brgr;
    String hex, op_most = "Kernels";
    ButtonGroup grupo1 = new ButtonGroup();
    private double k1graf[] = null;

    public Kernels(){}
        
    
    public Kernels(Test0 fr, String ojo) {
        this.setTitle( " Ojo "+ojo+" mfERG - Derivacion Kernel" );
        this.form1 = fr;
        initComponents();
        mvk1.setMajorTickSpacing(10);
        mvk1.setMinorTickSpacing(5);
        mvk1.setPaintTicks(true);
        mvk1.setValue(50);
        mvk1.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        mvk2.setMajorTickSpacing(10);
        mvk2.setMinorTickSpacing(5);
        mvk2.setPaintTicks(true);
        mvk2.setValue(50);
        mvk2.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        mvk3.setMajorTickSpacing(10);
        mvk3.setMinorTickSpacing(5);
        mvk3.setPaintTicks(true);
        mvk3.setValue(50);
        mvk3.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        msk1.setMajorTickSpacing(10);
        msk1.setMinorTickSpacing(5);
        msk1.setPaintTicks(true);
        msk1.setValue(50);
        msk1.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        msk2.setMajorTickSpacing(10);
        msk2.setMinorTickSpacing(5);
        msk2.setPaintTicks(true);
        msk2.setValue(50);
        msk2.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        msk3.setMajorTickSpacing(10);
        msk3.setMinorTickSpacing(5);
        msk3.setPaintTicks(true);
        msk3.setValue(50);
        msk3.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        SelHex_Ker.setSelectedIndex(0);
        grupo1.add(ker);
        grupo1.add(Vent_ker);
        ker.setSelected(true);
        mvms.setSelected(false);
        this.k1graf = k11.RetK1wvf();
            
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        k11 = new k1(this,form1);
        k21 = new k2(this,form1);
        k31 = new k3(this,form1);
        jPanel1 = new javax.swing.JPanel();
        mvk1 = new javax.swing.JSlider();
        msk1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        mvk2 = new javax.swing.JSlider();
        msk2 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        mvk3 = new javax.swing.JSlider();
        msk3 = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        SelHex_Ker = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        Vent_ker = new javax.swing.JRadioButton();
        ker = new javax.swing.JRadioButton();
        mvms = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        guardar = new javax.swing.JButton();

        setResizable(false);
        k11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout k11Layout = new org.jdesktop.layout.GroupLayout(k11);
        k11.setLayout(k11Layout);
        k11Layout.setHorizontalGroup(
            k11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 644, Short.MAX_VALUE)
        );
        k11Layout.setVerticalGroup(
            k11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 144, Short.MAX_VALUE)
        );

        k21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout k21Layout = new org.jdesktop.layout.GroupLayout(k21);
        k21.setLayout(k21Layout);
        k21Layout.setHorizontalGroup(
            k21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 644, Short.MAX_VALUE)
        );
        k21Layout.setVerticalGroup(
            k21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 144, Short.MAX_VALUE)
        );

        k31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout k31Layout = new org.jdesktop.layout.GroupLayout(k31);
        k31.setLayout(k31Layout);
        k31Layout.setHorizontalGroup(
            k31Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 644, Short.MAX_VALUE)
        );
        k31Layout.setVerticalGroup(
            k31Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 144, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mvk1.setOrientation(javax.swing.JSlider.VERTICAL);
        mvk1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mvk1StateChanged(evt);
            }
        });

        msk1.setOrientation(javax.swing.JSlider.VERTICAL);
        msk1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                msk1StateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel1.setText("mV");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel2.setText("ms");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mvk1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .add(19, 19, 19)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(msk1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(mvk1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(msk1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mvk2.setOrientation(javax.swing.JSlider.VERTICAL);
        mvk2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mvk2StateChanged(evt);
            }
        });

        msk2.setOrientation(javax.swing.JSlider.VERTICAL);
        msk2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                msk2StateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel3.setText("mV");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel4.setText("ms");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mvk2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(17, 17, 17)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(msk2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(mvk2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(msk2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mvk3.setOrientation(javax.swing.JSlider.VERTICAL);
        mvk3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mvk3StateChanged(evt);
            }
        });

        msk3.setOrientation(javax.swing.JSlider.VERTICAL);
        msk3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                msk3StateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel5.setText("mV");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel6.setText("ms");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mvk3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .add(19, 19, 19)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(msk3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel6)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(mvk3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(msk3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jLabel5))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hex\u00e1gono", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        SelHex_Ker.setFont(new java.awt.Font("Arial", 0, 11));
        SelHex_Ker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "h0", "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h10", "h11", "h12", "h13", "h14", "h15", "h16", "h17", "h18", "h19", "h20", "h21", "h22", "h23", "h24", "h25", "h26", "h27", "h28", "h29", "h30", "h31", "h32", "h33", "h34", "h35", "h36", "h37", "h38", "h39", "h40", "h41", "h42", "h43", "h44", "h45", "h46", "h47", "h48", "h49", "h50", "h51", "h52", "h53", "h54", "h55", "h56", "h57", "h58", "h59", "h60", "h61", "h62", "h63", "h64", "h65", "h66", "h67", "h68", "h69", "h70", "h71", "h72", "h73", "h74", "h75", "h76", "h77", "h78", "h79", "h80", "h81", "h82", "h83", "h84", "h85", "h86", "h87", "h88", "h89", "h90", "h91", "h92", "h93", "h94", "h95", "h96", "h97", "h98", "h99", "h100", "h101", "h102" }));
        SelHex_Ker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelHex_KerActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(SelHex_Ker, 0, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(SelHex_Ker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        Vent_ker.setFont(new java.awt.Font("Arial", 0, 11));
        Vent_ker.setText("Ventanas Kernel");
        Vent_ker.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Vent_ker.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Vent_ker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vent_kerActionPerformed(evt);
            }
        });

        ker.setFont(new java.awt.Font("Arial", 0, 11));
        ker.setText("Kernels");
        ker.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ker.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kerActionPerformed(evt);
            }
        });

        mvms.setFont(new java.awt.Font("Arial", 0, 11));
        mvms.setText("mV - ms");
        mvms.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        mvms.setMargin(new java.awt.Insets(0, 0, 0, 0));
        mvms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvmsActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(Vent_ker)
                .add(16, 16, 16)
                .add(ker)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 22, Short.MAX_VALUE)
                .add(mvms)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Vent_ker)
                    .add(ker)
                    .add(mvms))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Archivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        guardar.setFont(new java.awt.Font("Arial", 0, 11));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .add(guardar)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .add(guardar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(k21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(k11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(k31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(26, 26, 26)
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(17, 17, 17)
                        .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, k11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(k21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(k31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(23, 23, 23)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel6, 0, 59, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        brgr = new AbrirGuardar(form1,false);
        brgr.setVisible(true);
        brgr.setVisible(false);
    }//GEN-LAST:event_guardarActionPerformed
    boolean as0 = false;
    private void mvmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvmsActionPerformed
        JRadioButton act = (JRadioButton)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && as0==false){
            as0 = true;    
        }else if(act.getVerifyInputWhenFocusTarget() && as0==true){
            as0 = false;
        }
        k11.repaint();
        k21.repaint();
        k31.repaint();
    }//GEN-LAST:event_mvmsActionPerformed

    private void kerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kerActionPerformed
        op_most = "Kernels";
        k11.repaint();
        k21.repaint();
        k31.repaint();
    }//GEN-LAST:event_kerActionPerformed

    private void Vent_kerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vent_kerActionPerformed
        op_most = "Ventana";
        k11.repaint();
        k21.repaint();
        k31.repaint();
    }//GEN-LAST:event_Vent_kerActionPerformed

    private void SelHex_KerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelHex_KerActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        hex = (String)cb.getSelectedItem();
        k11.repaint();
        k21.repaint();
        k31.repaint();
        
    }//GEN-LAST:event_SelHex_KerActionPerformed

    private void msk3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_msk3StateChanged
         JSlider bl6 = (JSlider)evt.getSource();
        if (!bl6.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   dsk3 = fps;
            }
    k31.repaint();
    }//GEN-LAST:event_msk3StateChanged

    private void mvk3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mvk3StateChanged
         JSlider bl5 = (JSlider)evt.getSource();
        if (!bl5.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   dvk3 = fps;
            }
    k31.repaint();
    }//GEN-LAST:event_mvk3StateChanged

    private void msk2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_msk2StateChanged
         JSlider bl4 = (JSlider)evt.getSource();
        if (!bl4.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   dsk2 = fps;
            }
    k21.repaint();
    }//GEN-LAST:event_msk2StateChanged

    private void mvk2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mvk2StateChanged
     JSlider bl3 = (JSlider)evt.getSource();
        if (!bl3.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   dvk2 = fps;
            }
    k21.repaint();
    }//GEN-LAST:event_mvk2StateChanged

    private void msk1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_msk1StateChanged
         JSlider bl2 = (JSlider)evt.getSource();
        if (!bl2.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   dsk1 = fps;
            }
    k11.repaint();
    }//GEN-LAST:event_msk1StateChanged

    private void mvk1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mvk1StateChanged
        JSlider bl1 = (JSlider)evt.getSource();
        if (!bl1.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   dvk1 = fps;
            }
    k11.repaint();
    }//GEN-LAST:event_mvk1StateChanged
    
    
    public double RetmVk1(){
        return dvk1;
    }
    public double RetmVk2(){
        return dvk2;
    }
    public double RetmVk3(){
        return dvk3;
    }
    public double RetmSk1(){
        return dsk1;
    }
    public double RetmSk2(){
        return dsk2;
    }
    public double RetmSk3(){
        return dsk3;
    }
    public String RetHex(){
        return hex;
    }
    public String RetOpMot(){
        return op_most;
    }
    public double[] RetK1graf(){
        return k1graf;
    }
    public boolean VerValores(){
        return as0;
    }
    

    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kernels().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox SelHex_Ker;
    private javax.swing.JRadioButton Vent_ker;
    public javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public erg2.k1 k11;
    public erg2.k2 k21;
    public erg2.k3 k31;
    private javax.swing.JRadioButton ker;
    private javax.swing.JSlider msk1;
    private javax.swing.JSlider msk2;
    private javax.swing.JSlider msk3;
    private javax.swing.JSlider mvk1;
    private javax.swing.JSlider mvk2;
    private javax.swing.JSlider mvk3;
    private javax.swing.JRadioButton mvms;
    // End of variables declaration//GEN-END:variables

    
    
}
