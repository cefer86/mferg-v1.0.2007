package erg3;

import erg2.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

/**
 *Autor: Cesar Peña
 */

public class mferg extends javax.swing.JFrame implements Runnable{
    
    int ancho_cam2,largo_cam2,ancho_cam3,largo_cam3,ancho_cam4,largo_cam4;
    int ancho_cam5,largo_cam5,ancho_cam6,largo_cam6;
    double sv1,st1,sv2,st2,sv3,st3,sv4,st4,maximo,minimo,media;
    boolean mover;
    private GrafWave_DWT ww;
    public DWT_Form1 r1;
    String ojo="Derecho",cuadrante="SN";
    private double DWT0[][]=null;
    public double D1[] = null, D2[] = null, D3[]=null, D4[]=null;
    public double Z1[] = null, Z2[] = null, Z3[]=null, Z4[]=null;
    public double eee[] ={-2.7210,-3.6739,-4.0364,-3.7389,-2.8703,-1.6527,-0.3843,0.6347,1.1755,1.1336,0.5503,-0.4036,-1.4755,-2.3970,-2.9526,-3.0309,-2.6485,-1.9392,-1.1131,-0.3980,0.0223,0.0554,-0.2787,-0.8574,-1.4939,-1.9914};
    public Test0 Main;
    Font  f2 = new Font("Fuente1",Font.BOLD,10);
    ButtonGroup grupo1 = new ButtonGroup();
    
    public mferg(){}
    public mferg(Test0 fr) {
        this.setTitle("Campo Visual - mfERG - V. 1.0 Cesar Peña");
        this.setLocation(50,50);
        this.Main = fr;
        if(!fr.importD){
        this.D1 = fr.ddkk.RetCuad_C1D();
        this.D2 = fr.ddkk.RetCuad_C2D();
        this.D3 = fr.ddkk.RetCuad_C3D();
        this.D4 = fr.ddkk.RetCuad_C4D();
        this.Z1 = fr.ddkk2.RetCuad_C1Z();
        this.Z2 = fr.ddkk2.RetCuad_C2Z();
        this.Z3 = fr.ddkk2.RetCuad_C3Z();
        this.Z4 = fr.ddkk2.RetCuad_C4Z();
        }else{
        this.D1 = fr.ddkk1.RetCuad_C1D();
        this.D2 = fr.ddkk1.RetCuad_C2D();
        this.D3 = fr.ddkk1.RetCuad_C3D();
        this.D4 = fr.ddkk1.RetCuad_C4D();
        this.Z1 = fr.ddkk21.RetCuad_C1Z();
        this.Z2 = fr.ddkk21.RetCuad_C2Z();
        this.Z3 = fr.ddkk21.RetCuad_C3Z();
        this.Z4 = fr.ddkk21.RetCuad_C4Z();   
        }
        initComponents();
        snV.setMajorTickSpacing(10);
        snV.setMinorTickSpacing(5);
        snV.setPaintTicks(true);
        snV.setValue(50);
        snV.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        snT.setMajorTickSpacing(10);
        snT.setMinorTickSpacing(5);
        snT.setPaintTicks(true);
        snT.setValue(50);
        snT.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        inV.setMajorTickSpacing(10);
        inV.setMinorTickSpacing(5);
        inV.setPaintTicks(true);
        inV.setValue(50);
        inV.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        stV.setMajorTickSpacing(10);
        stV.setMinorTickSpacing(5);
        stV.setPaintTicks(true);
        stV.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        stV.setValue(50);
        inT.setMajorTickSpacing(10);
        inT.setMinorTickSpacing(5);
        inT.setPaintTicks(true);
        inT.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        inT.setValue(50);
        stT.setMajorTickSpacing(10);
        stT.setMinorTickSpacing(5);
        stT.setPaintTicks(true);
        stT.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        stT.setValue(50);
        itT.setMajorTickSpacing(10);
        itT.setMinorTickSpacing(5);
        itT.setPaintTicks(true);
        itT.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        itT.setValue(50);
        itV.setMajorTickSpacing(10);
        itV.setMinorTickSpacing(5);
        itV.setPaintTicks(true);
        itV.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        itV.setValue(50);
        SelOjo.setSelectedIndex(0);
        SelOjo.setFont(f2);
        sn.setActionCommand("SN");
        in.setActionCommand("IN");
        st.setActionCommand("ST");
        it.setActionCommand("IT");
        sn.setSelected(true);
        grupo1.add(sn);
        grupo1.add(in);
        grupo1.add(st);
        grupo1.add(it);
                
    }
      
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        campos11 = new campos1(this);
        campos21 = new campos2(this);
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        snV = new javax.swing.JSlider();
        jPanel6 = new javax.swing.JPanel();
        snT = new javax.swing.JSlider();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        inV = new javax.swing.JSlider();
        jPanel10 = new javax.swing.JPanel();
        inT = new javax.swing.JSlider();
        jPanel13 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        stV = new javax.swing.JSlider();
        jPanel12 = new javax.swing.JPanel();
        stT = new javax.swing.JSlider();
        jPanel16 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        itV = new javax.swing.JSlider();
        jPanel15 = new javax.swing.JPanel();
        itT = new javax.swing.JSlider();
        grafComp1 = new GrafComp(this,D1,Z1);

        grafComp11 = new GrafComp1(this,D4,Z4);
        grafComp21 = new GrafComp2(this,D2,Z2);
        grafComp31 = new GrafComp3(this,D3,Z3);
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        SelOjo = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        Aprox = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        Analisis = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        sn = new javax.swing.JRadioButton();
        in = new javax.swing.JRadioButton();
        st = new javax.swing.JRadioButton();
        it = new javax.swing.JRadioButton();

        jMenu2.setText("Menu");
        jMenuBar2.add(jMenu2);

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(java.awt.Color.darkGray);
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
        });

        campos11.setPreferredSize(new java.awt.Dimension(0, 0));
        org.jdesktop.layout.GroupLayout campos11Layout = new org.jdesktop.layout.GroupLayout(campos11);
        campos11.setLayout(campos11Layout);
        campos11Layout.setHorizontalGroup(
            campos11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 360, Short.MAX_VALUE)
        );
        campos11Layout.setVerticalGroup(
            campos11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 290, Short.MAX_VALUE)
        );

        campos21.setPreferredSize(new java.awt.Dimension(0, 0));
        org.jdesktop.layout.GroupLayout campos21Layout = new org.jdesktop.layout.GroupLayout(campos21);
        campos21.setLayout(campos21Layout);
        campos21Layout.setHorizontalGroup(
            campos21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 360, Short.MAX_VALUE)
        );
        campos21Layout.setVerticalGroup(
            campos21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 290, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escalamiento (mV-ms)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 11)));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cuadrante SN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-     mV/Div     +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        snV.setFont(new java.awt.Font("Arial", 0, 11));
        snV.setForeground(new java.awt.Color(204, 0, 0));
        snV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                snVStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(snV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(snV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-    ms/Div    +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        snT.setFont(new java.awt.Font("Arial", 0, 11));
        snT.setForeground(new java.awt.Color(204, 0, 0));
        snT.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                snTStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .add(snT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(snT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cuadrante IN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-     mV/Div    +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        inV.setForeground(new java.awt.Color(204, 0, 0));
        inV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inVStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(inV, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(inV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-     ms/Div    +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        inT.setForeground(new java.awt.Color(204, 0, 0));
        inT.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inTStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(inT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(inT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cuadrante ST", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-    mv/Div    +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        stV.setForeground(new java.awt.Color(204, 0, 0));
        stV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stVStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-   ms/Div   +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        stT.setForeground(new java.awt.Color(204, 0, 0));
        stT.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                stTStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(stT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .add(jPanel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cuadrante IT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-    mV/Div   +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        itV.setForeground(new java.awt.Color(204, 0, 0));
        itV.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                itVStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel14Layout = new org.jdesktop.layout.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(itV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(itV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "-    ms/Div    +", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        itT.setForeground(new java.awt.Color(204, 0, 0));
        itT.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                itTStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel15Layout = new org.jdesktop.layout.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(itT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(itT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        org.jdesktop.layout.GroupLayout jPanel16Layout = new org.jdesktop.layout.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .add(jPanel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel16, 0, 147, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grafComp1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout grafComp1Layout = new org.jdesktop.layout.GroupLayout(grafComp1);
        grafComp1.setLayout(grafComp1Layout);
        grafComp1Layout.setHorizontalGroup(
            grafComp1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 345, Short.MAX_VALUE)
        );
        grafComp1Layout.setVerticalGroup(
            grafComp1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 286, Short.MAX_VALUE)
        );

        grafComp11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout grafComp11Layout = new org.jdesktop.layout.GroupLayout(grafComp11);
        grafComp11.setLayout(grafComp11Layout);
        grafComp11Layout.setHorizontalGroup(
            grafComp11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 345, Short.MAX_VALUE)
        );
        grafComp11Layout.setVerticalGroup(
            grafComp11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 286, Short.MAX_VALUE)
        );

        grafComp21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout grafComp21Layout = new org.jdesktop.layout.GroupLayout(grafComp21);
        grafComp21.setLayout(grafComp21Layout);
        grafComp21Layout.setHorizontalGroup(
            grafComp21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 331, Short.MAX_VALUE)
        );
        grafComp21Layout.setVerticalGroup(
            grafComp21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 286, Short.MAX_VALUE)
        );

        grafComp31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        org.jdesktop.layout.GroupLayout grafComp31Layout = new org.jdesktop.layout.GroupLayout(grafComp31);
        grafComp31.setLayout(grafComp31Layout);
        grafComp31Layout.setHorizontalGroup(
            grafComp31Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 331, Short.MAX_VALUE)
        );
        grafComp31Layout.setVerticalGroup(
            grafComp31Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 286, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "An\u00e1lisis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ojo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 11)));
        SelOjo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Derecho", "Izquierdo" }));
        SelOjo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelOjoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(SelOjo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(SelOjo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Descomposici\u00f3n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        Aprox.setFont(new java.awt.Font("Arial", 0, 11));
        Aprox.setText("Descomponer");
        Aprox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AproxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(Aprox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(Aprox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Transformar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        Analisis.setFont(new java.awt.Font("Lucida Console", 0, 12));
        Analisis.setText("D.W.T");
        Analisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalisisActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel17Layout = new org.jdesktop.layout.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .add(Analisis, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .add(Analisis)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cuadrantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        sn.setFont(new java.awt.Font("Arial", 0, 11));
        sn.setText("SN");
        sn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        sn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        sn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snActionPerformed(evt);
            }
        });

        in.setFont(new java.awt.Font("Arial", 0, 11));
        in.setText("IN");
        in.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        in.setMargin(new java.awt.Insets(0, 0, 0, 0));
        in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inActionPerformed(evt);
            }
        });

        st.setFont(new java.awt.Font("Arial", 0, 11));
        st.setText("ST");
        st.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        st.setMargin(new java.awt.Insets(0, 0, 0, 0));
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });

        it.setFont(new java.awt.Font("Arial", 0, 11));
        it.setText("IT");
        it.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        it.setMargin(new java.awt.Insets(0, 0, 0, 0));
        it.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel18Layout = new org.jdesktop.layout.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .add(sn)
                .add(18, 18, 18)
                .add(in)
                .add(18, 18, 18)
                .add(st)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(it)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .add(jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(sn)
                    .add(in)
                    .add(st)
                    .add(it))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel17, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(campos11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(grafComp1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(campos21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(grafComp11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(grafComp31, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(grafComp21, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(14, 14, 14)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(grafComp1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(campos11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(grafComp21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(campos21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(grafComp11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(grafComp31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itActionPerformed
    cuadrante = it.getActionCommand();
    }//GEN-LAST:event_itActionPerformed

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed
    cuadrante = st.getActionCommand();
    }//GEN-LAST:event_stActionPerformed

    private void inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inActionPerformed
    cuadrante = in.getActionCommand();
    }//GEN-LAST:event_inActionPerformed

    private void snActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snActionPerformed
    cuadrante = sn.getActionCommand();
    }//GEN-LAST:event_snActionPerformed

    private void AproxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AproxActionPerformed
        try{
        if(Ret_Cuadrante()=="SN" && RetOjo()=="Derecho")this.r1= new DWT_Form1(Main,grafComp1.Ret_SN_D(),"SN","Derecho");
        if(Ret_Cuadrante()=="SN" && RetOjo()=="Izquierdo")this.r1= new DWT_Form1(Main,grafComp1.Ret_SN_I(),"SN","Izquierdo");
        if(Ret_Cuadrante()=="IN" && RetOjo()=="Derecho")this.r1= new DWT_Form1(Main,grafComp11.Ret_IN_D(),"IN","Derecho");
        if(Ret_Cuadrante()=="IN" && RetOjo()=="Izquierdo")this.r1= new DWT_Form1(Main,grafComp11.Ret_IN_I(),"IN","Izquierdo");
        if(Ret_Cuadrante()=="ST" && RetOjo()=="Derecho")this.r1= new DWT_Form1(Main,grafComp21.Ret_ST_D(),"ST","Derecho");
        if(Ret_Cuadrante()=="ST" && RetOjo()=="Izquierdo")this.r1= new DWT_Form1(Main,grafComp21.Ret_ST_I(),"ST","Izquierdo");
        if(Ret_Cuadrante()=="IT" && RetOjo()=="Derecho")this.r1= new DWT_Form1(Main,grafComp31.Ret_IT_D(),"IT","Derecho");
        if(Ret_Cuadrante()=="IT" && RetOjo()=="Izquierdo")this.r1= new DWT_Form1(Main,grafComp31.Ret_IT_I(),"IT","Izquierdo");
        r1.setVisible(true);
        }catch(java.lang.NullPointerException e){
        JOptionPane.showMessageDialog(null,"Seleccione un Cuadrante ","Error!",2);
        }
    }//GEN-LAST:event_AproxActionPerformed

    private void AnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalisisActionPerformed
        try{
        if(Ret_Cuadrante()=="SN" && RetOjo()=="Derecho"){this.r1= new DWT_Form1(Main,grafComp1.Ret_SN_D(),"SN","Derecho");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"SN","Derecho");}
        if(Ret_Cuadrante()=="SN" && RetOjo()=="Izquierdo"){this.r1= new DWT_Form1(Main,grafComp1.Ret_SN_I(),"SN","Izquierdo");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"SN","Izquierdo");}
        if(Ret_Cuadrante()=="IN" && RetOjo()=="Derecho"){this.r1= new DWT_Form1(Main,grafComp11.Ret_IN_D(),"IN","Derecho");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"IN","Derecho");}
        if(Ret_Cuadrante()=="IN" && RetOjo()=="Izquierdo"){this.r1= new DWT_Form1(Main,grafComp11.Ret_IN_I(),"IN","Izquierdo");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"IN","Izquierdo");}
        if(Ret_Cuadrante()=="ST" && RetOjo()=="Derecho"){this.r1= new DWT_Form1(Main,grafComp21.Ret_ST_D(),"ST","Derecho");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"ST","Derecho");}
        if(Ret_Cuadrante()=="ST" && RetOjo()=="Izquierdo"){this.r1= new DWT_Form1(Main,grafComp21.Ret_ST_I(),"ST","Izquierdo");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"ST","Izquierdo");}
        if(Ret_Cuadrante()=="IT" && RetOjo()=="Derecho"){this.r1= new DWT_Form1(Main,grafComp31.Ret_IT_D(),"IT","Derecho");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"IT","Derecho");}
        if(Ret_Cuadrante()=="IT" && RetOjo()=="Izquierdo"){this.r1= new DWT_Form1(Main,grafComp31.Ret_IT_I(),"IT","Izquierdo");
        ww =  new GrafWave_DWT(this.r1.cc1.Ret_Cof(), this.r1.cc1.RetNMAX(),this.r1.cc1.RetLsignal(),this,"IT","Izquierdo");}
        ww.setVisible(true);
        }catch(java.lang.NullPointerException e){
        JOptionPane.showMessageDialog(null,"Seleccione un Cuadrante ","Error!",2);
        }
    }//GEN-LAST:event_AnalisisActionPerformed

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
    // Cuando se minimiza la ventana
        campos11.repaint();
        campos21.repaint();
    }//GEN-LAST:event_formWindowDeiconified

    private void SelOjoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelOjoActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        ojo = (String)cb.getSelectedItem();
        grafComp1.repaint();
        grafComp11.repaint();
        grafComp21.repaint();
        grafComp31.repaint();
    }//GEN-LAST:event_SelOjoActionPerformed

    private void itTStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_itTStateChanged
    JSlider ST4 = (JSlider)evt.getSource();
        if (!ST4.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   st4 = fps;
            }
    grafComp31.repaint(); 
    }//GEN-LAST:event_itTStateChanged

    private void itVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_itVStateChanged
    JSlider SV4 = (JSlider)evt.getSource();
        if (!SV4.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                    sv4 = fps;
           }
    grafComp31.repaint();  
    }//GEN-LAST:event_itVStateChanged

    private void stTStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_stTStateChanged
    JSlider ST3 = (JSlider)evt.getSource();
        if (!ST3.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   st3 = fps;
            }
   grafComp21.repaint(); 
    }//GEN-LAST:event_stTStateChanged

    private void stVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_stVStateChanged
    JSlider SV3 = (JSlider)evt.getSource();
        if (!SV3.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                    sv3 = fps;
           }
    grafComp21.repaint();  
    }//GEN-LAST:event_stVStateChanged

    private void inTStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inTStateChanged
     JSlider ST2 = (JSlider)evt.getSource();
        if (!ST2.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   st2 = fps;
            }
   grafComp11.repaint();
    }//GEN-LAST:event_inTStateChanged

    private void inVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inVStateChanged
      JSlider SV2 = (JSlider)evt.getSource();
        if (!SV2.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                    sv2 = fps;
           }
    grafComp11.repaint();  
    }//GEN-LAST:event_inVStateChanged

    private void snTStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_snTStateChanged
        JSlider ST1 = (JSlider)evt.getSource();
        if (!ST1.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   st1 = fps;
            }
   grafComp1.repaint();
    }//GEN-LAST:event_snTStateChanged

    private void snVStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_snVStateChanged
        JSlider SV1 = (JSlider)evt.getSource();
        if (!SV1.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                    sv1 = fps;
           }
    grafComp1.repaint();  
    }//GEN-LAST:event_snVStateChanged
    
    public void run(){
        
    }    
     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mferg().setVisible(true);
            }
        });
    }
    public double RetScaVolt1(){
        return sv1;
    }
    public double RetScaTiem1(){
        return st1;
    }
    public double RetScaVolt2(){
        return sv2;
    }
    public double RetScaTiem2(){
        return st2;
    }
    public double RetScaVolt3(){
        return sv3;
    }
    public double RetScaTiem3(){
        return st3;
    }
    public double RetScaVolt4(){
        return sv4;
    }
    public double RetScaTiem4(){
        return st4;
    }
    public String RetOjo(){
        return ojo;
    }
    public boolean RetMover(){
        return mover;
    }
    public double[][] ReturnDWT(){
        return DWT0;
    }
    public double ReturMIN(){
        return minimo;
    }
    public double ReturnMAX(){
        return maximo;
    }
    public double ReturMedia(){
        return media;
    }
    public String Ret_Cuadrante(){
        return cuadrante;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Analisis;
    private javax.swing.JButton Aprox;
    private javax.swing.JComboBox SelOjo;
    private erg3.campos1 campos11;
    private erg3.campos2 campos21;
    private erg3.GrafComp grafComp1;
    private erg3.GrafComp1 grafComp11;
    private erg3.GrafComp2 grafComp21;
    private erg3.GrafComp3 grafComp31;
    private javax.swing.JRadioButton in;
    private javax.swing.JSlider inT;
    private javax.swing.JSlider inV;
    private javax.swing.JRadioButton it;
    private javax.swing.JSlider itT;
    private javax.swing.JSlider itV;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton sn;
    private javax.swing.JSlider snT;
    private javax.swing.JSlider snV;
    private javax.swing.JRadioButton st;
    private javax.swing.JSlider stT;
    private javax.swing.JSlider stV;
    // End of variables declaration//GEN-END:variables
    
}
