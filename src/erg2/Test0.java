package erg2;


import Datos.AbrirGuardar;
import erg2.Preprosc;
import erg2.Kernels;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.math.BigDecimal;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import erg3.mferg;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import erg3.*;
/**
 *
 * Autor: Cesar Peña
 *
 */

public class Test0 extends JFrame {

        // Declaracion de Variables

        private Font f2 = new Font("Fuente1",Font.BOLD,10);   
        public String uni_tiempo,x1,x2,x3,ojoEst;
        public boolean line_onoff=true,enum_onoff=true,importD=false,estimulado,Import_estim=false,play_time;
        private double bl1,mVScal=0.0,msScal=0.0,msStr=0.0,factor_Scal1,factor_Scal2;
        public double base_tiempo = 0.0,tiempo_muest=0.0;
        private mferg cv;
        private Jed Graf3D;
        public Kernels kernels;
        public ProsOjo prosojo;
        public double Kern1[]=null, Kern11[]=null;
        public double Kern2[]=null, Kern21[]=null;
        public double Kern3[]=null, Kern31[]=null;
        public double k1Graf[]=null;
        public double s_entrada[]=null;
        public double v_k1[]=null, v_k2[]=null, v_k3[]=null;
        public double k1[]=null, k2[]=null, k3[]=null;
        private long ms_ini,ms_final;
        private double totaltime,totalEsttime;
        boolean fs,Running = true,click, listo_prosc_d=false,listo_prosc_i=false,listo_prosc_dCONF=false, listo_prosc_iCONF=false;
        public Preprosc p_pros1;
        int ScreenWidth;
        int ScreenHeight;
        int Nm=0,sizq=0,sder=0;
        public int k,M; // Contador de Patrones y Totalidad de Patrones
        Random r= new Random(); 
        int valor=r.nextInt(2);
        ButtonGroup grupo1 = new ButtonGroup();
        ButtonGroup grupo2 = new ButtonGroup();
        ButtonGroup grupo3 = new ButtonGroup();
        BarraProgress b = new BarraProgress(100);
        String Op_ana, fyh_actual,fyh_ult,dia,mes,año,dianum,horas,patrones="",on_offwvf,on_offdr,ResDisplay;
        public String tipo_est="alt";
        Frame prinFrame;
        BufferStrategy bufferStrategy;
        MouseEvent evt;
        Date fyh, fyhs;
        public int indice_timeImD;
        public DensK ddkk,ddkk2,ddkk1,ddkk21;
        public Integer pat[][]= new Integer[21][5];
        public Integer pat2[][][] = new Integer[999][21][5];
        private double z = 57.0235;
        private double z0 =0.5, z1 =0.8, z2 = 1.1,z3 = 2.0, z4= 2.55652, z5= 12.8546;
        int ResX = 1280, ResY = 1024;
        int xi=ResX/2-40,yi=ResY/2-52;
        private static DisplayMode[] ModosPreferidos = null;
//        timepostop tstop;
        RelojModeloSwing modelo = null;
        GraphicsEnvironment ge;
        GraphicsDevice gd;
        GraphicsConfiguration gc;
        DisplayMode dm;
        public AbrirGuardar ag;
        BigDecimal bd;
   
    // Construccion del Estimulador:    
    public Test0() {
     ModosPreferidos = new DisplayMode[]   {
         new DisplayMode( ResX, ResY, 32, DisplayMode.REFRESH_RATE_UNKNOWN ), 
         new DisplayMode( ResX, ResY, 16, DisplayMode.REFRESH_RATE_UNKNOWN ), 
         new DisplayMode( ResX, ResY, 8, DisplayMode.REFRESH_RATE_UNKNOWN ) };
     this.setTitle( "mfERG - V. 1.0 Cesar Peña" );
     this.setSize( 640,500 );
     this.setLocation(200,100);
     this.setVisible( true );
     initComponents();
     fyh = new Date();
     modelo = new RelojModeloSwing();
     modelo.addObserver(new Observer()
         {
             public void update (Observable unObservable, Object dato)
             {   String hora="";
                 for(int i=11;i<=18;i++) hora = hora + dato.toString().charAt(i);
                 Hor.setText("Hora Actual: "+ hora);
             }
         });
         
     scalTiempo.setSelectedIndex(0);
     scalTiempo.setFont(f2);
     ResDis.setFont(f2);
     
        Ch1.setMajorTickSpacing(10);
        Ch1.setMinorTickSpacing(5);
        Ch1.setPaintTicks(true);
        Ch1.setValue(50);
        Ch1.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        ScalX.setMajorTickSpacing(10);
        ScalX.setMinorTickSpacing(5);
        ScalX.setPaintTicks(true);
        ScalX.setValue(50);
        ScalX.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        ScalY.setMajorTickSpacing(10);
        ScalY.setMinorTickSpacing(5);
        ScalY.setPaintTicks(true);
        ScalY.setValue(50);
        ScalY.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        Estir.setMajorTickSpacing(10);
        Estir.setMinorTickSpacing(2);
        Estir.setPaintTicks(true);
        Estir.setValue(0);
        Estir.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        
        TzWaveform.setActionCommand("wvform");
        Resp3D.setActionCommand("Resp_3D");
        DatosResp.setActionCommand("Datos_resp");
        MapRegiones.setActionCommand("Mapa_Reg");
        CampVis.setActionCommand("Campo_Visual");
        Alt.setActionCommand("alt");
        fijo.setActionCommand("fijo");
        grupo1.add(CampVis);
        grupo1.add(TzWaveform);
        grupo1.add(Resp3D);
        grupo1.add(DatosResp);
        grupo1.add(MapRegiones);
        grupo2.add(Manual);
        grupo2.add(Autom);
        grupo3.add(Alt);
        grupo3.add(fijo);
        Alt.setSelected(true);
        Act.setSelected(false);
        tiempo.setText("27");
        tiempo.setEnabled(false);
        scalTiempo.setSelectedIndex(1);
        scalTiempo.setEnabled(false);
        examinar.setEnabled(false);
        procesar.setEnabled(false);
        baseline.setEnabled(false);
        refresco.setEnabled(false);
        Resp3D.setEnabled(false);
        
        // Por defecto aparecece el mapa de Ondas
        TzWaveform.setSelected(true);
        this.Op_ana ="wvform";
        Autom.setSelected(true);
        Zmax.setEnabled(false);
        Zmin.setEnabled(false);
        Zscal.setEnabled(false);
        grafAnillo1.setVisible(false);
        Aplicar.setEnabled(false);
        ScalX.setEnabled(false);
        ScalY.setEnabled(false);
        Scalador.setValue(100);
        Scalador.setEnabled(false);
        anaDatos1.repaint();
        
        fyh_actual=fyh.toString();
        
        if (fyh_actual.charAt(0)=='S' && fyh_actual.charAt(1) =='u' && fyh_actual.charAt(2)=='n'){
            dia = "Domingo";
        }else if(fyh_actual.charAt(0)=='M' && fyh_actual.charAt(1) =='o' && fyh_actual.charAt(2)=='n'){
            dia = "Lunes";
        }else if(fyh_actual.charAt(0)=='T' && fyh_actual.charAt(1) =='u' && fyh_actual.charAt(2)=='e'){
            dia = "Martes";
        }else if(fyh_actual.charAt(0)=='W' && fyh_actual.charAt(1) =='e' && fyh_actual.charAt(2)=='d'){
            dia = "Miercoles";
        }else if(fyh_actual.charAt(0)=='T' && fyh_actual.charAt(1) =='h' && fyh_actual.charAt(2)=='u'){
            dia = "Jueves";
        }else if(fyh_actual.charAt(0)=='F' && fyh_actual.charAt(1) =='r' && fyh_actual.charAt(2)=='i'){
            dia = "Viernes";
        }else if(fyh_actual.charAt(0)=='S' && fyh_actual.charAt(1) =='a' && fyh_actual.charAt(2)=='t'){
            dia = "Sábado";
        }
        
      
        if(fyh_actual.charAt(4)=='J' && fyh_actual.charAt(5) =='a' && fyh_actual.charAt(6)=='n'){
            mes = "Enero";
        }else if(fyh_actual.charAt(4)=='F' && fyh_actual.charAt(5) =='e' && fyh_actual.charAt(6)=='b'){
            mes = "Febrero";
        }else if(fyh_actual.charAt(4)=='M' && fyh_actual.charAt(5) =='a' && fyh_actual.charAt(6)=='r'){
            mes="Marzo";
        }else if(fyh_actual.charAt(4)=='A' && fyh_actual.charAt(5) =='p' && fyh_actual.charAt(6)=='r'){
            mes= "Abril";
        }else if(fyh_actual.charAt(4)=='M' && fyh_actual.charAt(5) =='a' && fyh_actual.charAt(6)=='y'){
            mes= "Mayo";
        }else if(fyh_actual.charAt(4)=='J' && fyh_actual.charAt(5) =='u' && fyh_actual.charAt(6)=='n'){
            mes = "Junio";
        }else if(fyh_actual.charAt(4)=='J' && fyh_actual.charAt(5) =='u' && fyh_actual.charAt(6)=='l'){
            mes = "Julio";
        }else if(fyh_actual.charAt(4)=='A' && fyh_actual.charAt(5) =='u' && fyh_actual.charAt(6)=='g'){
            mes = "Agosto";
        }else if(fyh_actual.charAt(4)=='S' && fyh_actual.charAt(5) =='e' && fyh_actual.charAt(6)=='p'){
            mes = "Septiembre";
        }else if(fyh_actual.charAt(4)=='O' && fyh_actual.charAt(5) =='c' && fyh_actual.charAt(6)=='t'){
            mes = "Octubre";
        }else if(fyh_actual.charAt(4)=='N' && fyh_actual.charAt(5) =='o' && fyh_actual.charAt(6)=='v'){
            mes = "Noviembre";
        }else if(fyh_actual.charAt(4)=='D' && fyh_actual.charAt(5) =='i' && fyh_actual.charAt(6)=='c'){
            mes = "Diciembre";
        }
        
        dianum = fyh_actual.substring(8,10);
        año = fyh_actual.substring(24,fyh_actual.length());
        horas = fyh_actual.substring(11,18);
        fecha.setText("Fecha de Hoy:  "+dia+", "+mes+" "+dianum+" de "+año);
        hora.setText("Hora de Inicio:  "+horas);
        p_pros1 = new Preprosc(this);
        
      for(int k=0;k<999;k++){
           for(int i=0;i<21;i++){
                for(int j=0;j<5;j++){
                    pat2[k][i][j]=valor;
                    valor=r.nextInt(2);
                 }
            }
       }
  } // Fin del Constructor
     
    private DisplayMode mejorModo(GraphicsDevice gd ){

    DisplayMode[] modes = gd.getDisplayModes();

    for( int j = 0; j < ModosPreferidos.length; j++ ){
    for( int i = 0; i < modes.length; i++ ){
        if( modes[i].getWidth() == ModosPreferidos[j].getWidth()
            && modes[i].getHeight() == ModosPreferidos[j].getHeight()
            && modes[i].getBitDepth() == ModosPreferidos[j].getBitDepth() )
        return ModosPreferidos[j];
        }
    }
     return null;
    }
     
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        adqDatos1 = new adqDatos(this);
        jPanel8 = new javax.swing.JPanel();
        Ch1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        baseline = new javax.swing.JButton();
        refresco = new javax.swing.JButton();
        Manual = new javax.swing.JRadioButton();
        Autom = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        ResDis = new javax.swing.JComboBox();
        jPanel23 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tiemm = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        importar = new javax.swing.JCheckBox();
        examinar = new javax.swing.JButton();
        procesar = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        nom_p = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        edad_p = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel28 = new javax.swing.JPanel();
        doc_p = new javax.swing.JTextField();
        frec_est = new javax.swing.JLabel();
        o_est = new javax.swing.JLabel();
        fc_muest = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        apl_p = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tiempo = new javax.swing.JTextField();
        scalTiempo = new javax.swing.JComboBox();
        Fc = new javax.swing.JButton();
        Act = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        TotalPat = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        Calcular = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SerieB1 = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SerieB2 = new javax.swing.JTextArea();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SerieB3 = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        tablero1 = new Tablero(this);
        jPanel18 = new javax.swing.JPanel();
        Estir = new javax.swing.JSlider();
        jPanel20 = new javax.swing.JPanel();
        Alt = new javax.swing.JRadioButton();
        fijo = new javax.swing.JRadioButton();
        fcorte = new javax.swing.JLabel();
        pbreal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        anaDatos1 = new anaDatos(this);
        grafAnillo1 = new GrafAnillo(this);
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Zmax = new javax.swing.JTextField();
        Zmin = new javax.swing.JTextField();
        Zscal = new javax.swing.JTextField();
        linea = new javax.swing.JCheckBox();
        numerado = new javax.swing.JCheckBox();
        TzWaveform = new javax.swing.JRadioButton();
        Resp3D = new javax.swing.JRadioButton();
        DatosResp = new javax.swing.JRadioButton();
        MapRegiones = new javax.swing.JRadioButton();
        CampVis = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        ScalY = new javax.swing.JSlider();
        ScalaY = new javax.swing.JLabel();
        ScalX = new javax.swing.JSlider();
        ScalaX = new javax.swing.JLabel();
        Scalador = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        Aplicar = new javax.swing.JButton();
        Iniciar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        UltimoTest = new javax.swing.JLabel();
        time1 = new Time(this);
        Hor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 11));
        jPanel5.setFont(new java.awt.Font("Lucida Console", 0, 10));
        adqDatos1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout adqDatos1Layout = new org.jdesktop.layout.GroupLayout(adqDatos1);
        adqDatos1.setLayout(adqDatos1Layout);
        adqDatos1Layout.setHorizontalGroup(
            adqDatos1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 627, Short.MAX_VALUE)
        );
        adqDatos1Layout.setVerticalGroup(
            adqDatos1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 490, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Linea Base", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel8.setFont(new java.awt.Font("Arial", 0, 11));
        Ch1.setOrientation(javax.swing.JSlider.VERTICAL);
        Ch1.setSnapToTicks(true);
        Ch1.setToolTipText("Desplazamiento de la Linea Base");
        Ch1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Ch1StateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel1.setText("Ch 1");

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Ch1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(Ch1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Adquisici\u00f3n de Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        baseline.setFont(new java.awt.Font("Lucida Console", 0, 11));
        baseline.setMnemonic('L');
        baseline.setToolTipText("Centra la Linea de Base");
        baseline.setLabel("Linea base");
        baseline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baselineActionPerformed(evt);
            }
        });

        refresco.setFont(new java.awt.Font("Lucida Console", 0, 11));
        refresco.setMnemonic('R');
        refresco.setToolTipText("Refrescar datos");
        refresco.setLabel("Refrescar");

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, refresco, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, baseline))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(baseline)
                .add(27, 27, 27)
                .add(refresco)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        Manual.setFont(new java.awt.Font("Arial", 0, 11));
        Manual.setToolTipText("Modo Manual");
        Manual.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Manual.setLabel("Manual");
        Manual.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualActionPerformed(evt);
            }
        });

        Autom.setFont(new java.awt.Font("Arial", 0, 11));
        Autom.setToolTipText("Modo Autom\u00e1tico");
        Autom.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Autom.setLabel("Autom\u00e1tico");
        Autom.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Autom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutomActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(adqDatos1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel5Layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(Manual)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(Autom)))))
                .add(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(adqDatos1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(19, 19, 19)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(Manual)
                            .add(Autom))
                        .add(55, 55, 55)
                        .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(33, 33, 33))
        );
        jTabbedPane1.addTab("Adquisici\u00f3n de Datos", jPanel5);

        jPanel6.setFont(new java.awt.Font("Lucida Console", 0, 10));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Configuraci\u00f3n de Pantalla", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resoluci\u00f3n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        ResDis.setFont(new java.awt.Font("Arial", 0, 11));
        ResDis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "800 x 600 p\u00edxeles", "1024 x 768  p\u00edxeles", "1152 x 864 p\u00edxeles", "1280 x 1024  p\u00edxeles" }));
        ResDis.setSelectedIndex(3);
        ResDis.setToolTipText("Seleccione La Resolucion \nque posee su Monitor.\n(Default: 1280 x 1024)\n");
        ResDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResDisActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel22Layout = new org.jdesktop.layout.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .add(ResDis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .add(ResDis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tiempo Muerto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel2.setText("Tiempo (en segundos) antes");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel8.setText("y despu\u00e9s  del  Estimulo del");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel3.setText("Test Multifocal.");

        tiemm.setFont(new java.awt.Font("Arial", 0, 11));
        tiemm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tiemm.setText("2");
        tiemm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel9.setText("s");

        org.jdesktop.layout.GroupLayout jPanel23Layout = new org.jdesktop.layout.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8)
                    .add(jLabel2)
                    .add(jPanel23Layout.createSequentialGroup()
                        .add(tiemm, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel9))
                    .add(jLabel3))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .add(15, 15, 15)
                .add(jPanel23Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tiemm, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel21Layout = new org.jdesktop.layout.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel23, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel21Layout.createSequentialGroup()
                .add(jPanel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16)
                .add(jPanel23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        importar.setFont(new java.awt.Font("Arial", 0, 11));
        importar.setText("Importar datos (. xls)");
        importar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        importar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarActionPerformed(evt);
            }
        });

        examinar.setFont(new java.awt.Font("Arial", 0, 11));
        examinar.setText("Examinar..");
        examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarActionPerformed(evt);
            }
        });

        procesar.setFont(new java.awt.Font("Arial", 0, 11));
        procesar.setText("Procesar");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel24Layout = new org.jdesktop.layout.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(importar)
                    .add(jPanel24Layout.createSequentialGroup()
                        .add(examinar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(procesar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .add(importar)
                .add(14, 14, 14)
                .add(jPanel24Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(examinar)
                    .add(procesar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nombres:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        nom_p.setFont(new java.awt.Font("Arial", 0, 11));
        nom_p.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        org.jdesktop.layout.GroupLayout jPanel26Layout = new org.jdesktop.layout.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .add(nom_p, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel26Layout.createSequentialGroup()
                .add(nom_p, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Edad:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        edad_p.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        org.jdesktop.layout.GroupLayout jPanel27Layout = new org.jdesktop.layout.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .add(edad_p, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel27Layout.createSequentialGroup()
                .add(edad_p, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Doc. Identidad:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        doc_p.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        org.jdesktop.layout.GroupLayout jPanel28Layout = new org.jdesktop.layout.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(doc_p, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel28Layout.createSequentialGroup()
                .add(doc_p, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frec_est.setFont(new java.awt.Font("Arial", 0, 11));
        frec_est.setText("Frecuecnia de Est\u00edmulo:");

        o_est.setFont(new java.awt.Font("Arial", 0, 11));
        o_est.setText("Ojo estimulado:");

        fc_muest.setFont(new java.awt.Font("Arial", 0, 11));
        fc_muest.setText("Frecuencia de muestreo:");

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        apl_p.setFont(new java.awt.Font("Arial", 0, 11));
        apl_p.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        org.jdesktop.layout.GroupLayout jPanel29Layout = new org.jdesktop.layout.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .add(apl_p, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel29Layout.createSequentialGroup()
                .add(apl_p, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel25Layout = new org.jdesktop.layout.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel25Layout.createSequentialGroup()
                        .add(jPanel26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(frec_est, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .add(o_est, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .add(fc_muest, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .add(jPanel25Layout.createSequentialGroup()
                        .add(jPanel28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel29, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel25Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel27, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(20, 20, 20)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16)
                .add(frec_est)
                .add(14, 14, 14)
                .add(o_est)
                .add(16, 16, 16)
                .add(fc_muest)
                .add(105, 105, 105))
        );

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel24, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(233, 233, 233))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel25, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel6Layout.createSequentialGroup()
                        .add(jPanel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(145, 145, 145))
        );
        jTabbedPane1.addTab("Configuraci\u00f3n", jPanel6);

        jPanel2.setFont(new java.awt.Font("Lucida Console", 0, 10));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Estimulo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Base de Tiempo (pb)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        tiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tiempo.setToolTipText("Periodo Base");
        tiempo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        scalTiempo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "mS" }));
        scalTiempo.setToolTipText("Unidad de Tiempo para el Periodo Base");
        scalTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scalTiempoActionPerformed(evt);
            }
        });

        Fc.setFont(new java.awt.Font("Arial", 0, 11));
        Fc.setText("Fc");
        Fc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FcActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(tiempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(16, 16, 16)
                        .add(scalTiempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(Fc, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .add(105, 105, 105))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tiempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(scalTiempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Fc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Act.setFont(new java.awt.Font("Arial", 0, 11));
        Act.setText("Configurar Base de Tiempo");
        Act.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Act.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Act)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(Act)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Total de Patrones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        TotalPat.setFont(new java.awt.Font("Arial", 0, 11));
        TotalPat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalPat.setText("15");
        TotalPat.setToolTipText("Numero de Patrones");
        TotalPat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .add(TotalPat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .add(TotalPat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ojo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        Calcular.setFont(new java.awt.Font("Arial", 0, 11));
        Calcular.setText("Procesar");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel19Layout = new org.jdesktop.layout.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .add(Calcular)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel19Layout.createSequentialGroup()
                .add(Calcular)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel19, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel13Layout.createSequentialGroup()
                        .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setFont(new java.awt.Font("Arial", 0, 11));
        SerieB1.setBackground(new java.awt.Color(51, 51, 51));
        SerieB1.setColumns(20);
        SerieB1.setEditable(false);
        SerieB1.setFont(new java.awt.Font("Courier New", 0, 11));
        SerieB1.setForeground(new java.awt.Color(0, 255, 0));
        SerieB1.setRows(5);
        jScrollPane1.setViewportView(SerieB1);

        org.jdesktop.layout.GroupLayout jPanel14Layout = new org.jdesktop.layout.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane2.addTab("Serie K1", jPanel14);

        SerieB2.setBackground(new java.awt.Color(51, 51, 51));
        SerieB2.setColumns(20);
        SerieB2.setEditable(false);
        SerieB2.setFont(new java.awt.Font("Courier New", 0, 11));
        SerieB2.setForeground(new java.awt.Color(0, 255, 0));
        SerieB2.setRows(5);
        jScrollPane2.setViewportView(SerieB2);

        org.jdesktop.layout.GroupLayout jPanel15Layout = new org.jdesktop.layout.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane2.addTab("Serie K2 - cs1", jPanel15);

        SerieB3.setBackground(new java.awt.Color(51, 51, 51));
        SerieB3.setColumns(20);
        SerieB3.setEditable(false);
        SerieB3.setFont(new java.awt.Font("Courier New", 0, 11));
        SerieB3.setForeground(new java.awt.Color(0, 255, 0));
        SerieB3.setRows(5);
        jScrollPane3.setViewportView(SerieB3);

        org.jdesktop.layout.GroupLayout jPanel16Layout = new org.jdesktop.layout.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTabbedPane2.addTab("Serie K2 - cs2", jPanel16);

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablero1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout tablero1Layout = new org.jdesktop.layout.GroupLayout(tablero1);
        tablero1.setLayout(tablero1Layout);
        tablero1Layout.setHorizontalGroup(
            tablero1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 334, Short.MAX_VALUE)
        );
        tablero1Layout.setVerticalGroup(
            tablero1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 285, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel17Layout = new org.jdesktop.layout.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .add(tablero1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .add(tablero1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escalado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        Estir.setForeground(new java.awt.Color(204, 0, 0));
        Estir.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EstirStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel18Layout = new org.jdesktop.layout.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .add(Estir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel18Layout.createSequentialGroup()
                .add(Estir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tipo de Estimulo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        Alt.setFont(new java.awt.Font("Arial", 0, 11));
        Alt.setText("Alternado");
        Alt.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Alt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Alt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltActionPerformed(evt);
            }
        });

        fijo.setFont(new java.awt.Font("Arial", 0, 11));
        fijo.setText("Fijo");
        fijo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        fijo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        fijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fijoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel20Layout = new org.jdesktop.layout.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel20Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fijo)
                    .add(Alt))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel20Layout.createSequentialGroup()
                .add(Alt)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(fijo))
        );

        fcorte.setFont(new java.awt.Font("Arial", 0, 11));
        fcorte.setText("Frecuencia de Corte: 37.037 Hz");

        pbreal.setFont(new java.awt.Font("Arial", 0, 11));
        pbreal.setText("P.B Calculado: ");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(32, 32, 32)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(41, 41, 41)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(pbreal)
                        .addContainerGap())
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jPanel2Layout.createSequentialGroup()
                                    .add(jPanel18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(17, 17, 17)
                                    .add(jPanel20, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(jPanel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(94, 94, 94))
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(fcorte)
                            .addContainerGap()))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jPanel17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel20, 0, 65, Short.MAX_VALUE)
                    .add(jPanel18, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(22, 22, 22)
                .add(fcorte)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pbreal)
                .addContainerGap(54, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .add(jTabbedPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 307, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(jPanel2Layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        jTabbedPane1.addTab("Configuraci\u00f3n del Estimulo", new javax.swing.ImageIcon(""), jPanel2);

        jPanel3.setFont(new java.awt.Font("Lucida Console", 0, 10));
        anaDatos1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout grafAnillo1Layout = new org.jdesktop.layout.GroupLayout(grafAnillo1);
        grafAnillo1.setLayout(grafAnillo1Layout);
        grafAnillo1Layout.setHorizontalGroup(
            grafAnillo1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 246, Short.MAX_VALUE)
        );
        grafAnillo1Layout.setVerticalGroup(
            grafAnillo1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 472, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout anaDatos1Layout = new org.jdesktop.layout.GroupLayout(anaDatos1);
        anaDatos1.setLayout(anaDatos1Layout);
        anaDatos1Layout.setHorizontalGroup(
            anaDatos1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, anaDatos1Layout.createSequentialGroup()
                .add(332, 332, 332)
                .add(grafAnillo1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        anaDatos1Layout.setVerticalGroup(
            anaDatos1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(anaDatos1Layout.createSequentialGroup()
                .addContainerGap()
                .add(grafAnillo1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Despliegue 3D", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel4.setText("Z-M\u00e1ximo (3D) :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel5.setText("Z-Minimo (3D) :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel6.setText("Z- Escala (3D) :");

        Zmax.setText("1.0");
        Zmax.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        Zmin.setText("0.3");
        Zmin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        Zscal.setText("0.8");
        Zscal.setToolTipText(" Valor de Esala en la Gr\u00e1fica");
        Zscal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        linea.setFont(new java.awt.Font("Arial", 0, 11));
        linea.setSelected(true);
        linea.setToolTipText("Muestra Escala de Colores Numerica");
        linea.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        linea.setLabel("Linea (3D)");
        linea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineaActionPerformed(evt);
            }
        });

        numerado.setFont(new java.awt.Font("Arial", 0, 11));
        numerado.setSelected(true);
        numerado.setText("Enumerado (3D)");
        numerado.setToolTipText("Mostrar adjunto a la grafica 3D los valores");
        numerado.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        numerado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        numerado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeradoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel10Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, linea, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, numerado, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(63, 63, 63))
            .add(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel6))
                .add(6, 6, 6)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(Zmin)
                    .add(Zmax)
                    .add(Zscal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel10Layout.createSequentialGroup()
                        .add(Zmax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(Zmin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(Zscal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(linea)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(numerado)
                .addContainerGap())
        );

        TzWaveform.setFont(new java.awt.Font("Arial", 0, 11));
        TzWaveform.setToolTipText("Mostrar datos en forma de Onda");
        TzWaveform.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        TzWaveform.setLabel("Trazado Waveform");
        TzWaveform.setMargin(new java.awt.Insets(0, 0, 0, 0));
        TzWaveform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TzWaveformActionPerformed(evt);
            }
        });

        Resp3D.setFont(new java.awt.Font("Arial", 0, 11));
        Resp3D.setToolTipText("Mostrar Respuesta Tridimensinal de la Onda P1");
        Resp3D.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Resp3D.setLabel("Respuesta 3D");
        Resp3D.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Resp3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Resp3DActionPerformed(evt);
            }
        });

        DatosResp.setFont(new java.awt.Font("Arial", 0, 11));
        DatosResp.setToolTipText("Mostrar Respuesta en mV/ms");
        DatosResp.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        DatosResp.setLabel("Datos de Respuesta");
        DatosResp.setMargin(new java.awt.Insets(0, 0, 0, 0));
        DatosResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatosRespActionPerformed(evt);
            }
        });

        MapRegiones.setFont(new java.awt.Font("Arial", 0, 11));
        MapRegiones.setToolTipText("Mostrar Mapa de Regiones y sus Se\u00f1ales");
        MapRegiones.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        MapRegiones.setLabel("Mapa de Regiones");
        MapRegiones.setMargin(new java.awt.Insets(0, 0, 0, 0));
        MapRegiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapRegionesActionPerformed(evt);
            }
        });

        CampVis.setFont(new java.awt.Font("Arial", 0, 11));
        CampVis.setText("Campo Visual");
        CampVis.setToolTipText("Mostrar Campo Visual");
        CampVis.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        CampVis.setMargin(new java.awt.Insets(0, 0, 0, 0));
        CampVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampVisActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Escalado (2D)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        ScalY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ScalYStateChanged(evt);
            }
        });

        ScalaY.setFont(new java.awt.Font("Arial", 0, 11));
        ScalaY.setText("mV- Escala: 0");

        ScalX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ScalXStateChanged(evt);
            }
        });

        ScalaX.setFont(new java.awt.Font("Arial", 0, 11));
        ScalaX.setText("ms - Escala: 0");

        Scalador.setFont(new java.awt.Font("Arial", 0, 11));
        Scalador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel7.setText("Paso (1/100):");

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel11Layout.createSequentialGroup()
                        .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(ScalX, 0, 0, Short.MAX_VALUE)
                            .add(ScalY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(ScalaX, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .add(ScalaY, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
                    .add(jPanel11Layout.createSequentialGroup()
                        .add(jLabel7)
                        .add(16, 16, 16)
                        .add(Scalador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ScalY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ScalaY))
                .add(14, 14, 14)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ScalX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ScalaX))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Scalador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Aplicar.setFont(new java.awt.Font("Lucida Console", 0, 11));
        Aplicar.setMnemonic('A');
        Aplicar.setText("Aplicar");
        Aplicar.setToolTipText("Aplica todos los cambios");
        Aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(anaDatos1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 594, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(TzWaveform)
                        .add(Resp3D)
                        .add(DatosResp)
                        .add(jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(MapRegiones)
                        .add(CampVis)
                        .add(jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Aplicar)
                        .add(41, 41, 41)))
                .add(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(TzWaveform)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Resp3D)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(DatosResp)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(MapRegiones)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(CampVis)
                        .add(16, 16, 16)
                        .add(jPanel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(Aplicar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, anaDatos1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 503, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jTabbedPane1.addTab("An\u00e1lisis de Datos", jPanel3);

        Iniciar.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11));
        Iniciar.setForeground(new java.awt.Color(153, 0, 0));
        Iniciar.setMnemonic('I');
        Iniciar.setText("Iniciar");
        Iniciar.setToolTipText("Inicia el Test");
        Iniciar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        Iniciar.setContentAreaFilled(false);
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Lucida Console", 0, 11));
        Salir.setMnemonic('S');
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informaci\u00f3n General", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11)));
        jPanel7.setFont(new java.awt.Font("Arial", 0, 11));
        fecha.setFont(new java.awt.Font("Arial", 1, 11));
        fecha.setText("Fecha de Hoy: ");

        hora.setFont(new java.awt.Font("Arial", 1, 11));
        hora.setText("Hora de Inicio:");

        UltimoTest.setFont(new java.awt.Font("Arial", 1, 11));
        UltimoTest.setText("Ultimo Test: ");

        time1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        org.jdesktop.layout.GroupLayout time1Layout = new org.jdesktop.layout.GroupLayout(time1);
        time1.setLayout(time1Layout);
        time1Layout.setHorizontalGroup(
            time1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 130, Short.MAX_VALUE)
        );
        time1Layout.setVerticalGroup(
            time1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 66, Short.MAX_VALUE)
        );

        Hor.setFont(new java.awt.Font("Arial", 1, 11));
        Hor.setText("Hora Actual:");

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, hora, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, fecha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .add(41, 41, 41)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(UltimoTest, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 294, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(Hor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(time1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(fecha)
                            .add(UltimoTest))
                        .add(16, 16, 16)
                        .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(hora)
                            .add(Hor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, time1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 862, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(25, 25, 25)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(Iniciar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(Salir))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(33, 33, 33)
                        .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(46, 46, 46)
                        .add(Salir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                        .add(Iniciar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(25, 25, 25)))
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 564, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void baselineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baselineActionPerformed
        
    }//GEN-LAST:event_baselineActionPerformed

    private void FcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FcActionPerformed
        if(uni_tiempo=="mS"){
        bd= new BigDecimal(1000/Double.parseDouble(tiempo.getText())).setScale(5, BigDecimal.ROUND_UP);
        fcorte.setText("Frecuencia de Corte: "+ bd +" Hz");
        }else if(uni_tiempo=="S"){
        bd= new BigDecimal(1/Double.parseDouble(tiempo.getText())).setScale(5, BigDecimal.ROUND_UP);
        fcorte.setText("Frecuencia de Corte: "+ bd +" Hz");
        }
    }//GEN-LAST:event_FcActionPerformed

    private void ManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualActionPerformed
       baseline.setEnabled(true);
       refresco.setEnabled(true);
    }//GEN-LAST:event_ManualActionPerformed

    private void AutomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutomActionPerformed
        baseline.setEnabled(false);
        refresco.setEnabled(false);
    }//GEN-LAST:event_AutomActionPerformed

    private void procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarActionPerformed
        importD = true;
        Iniciar.setEnabled(false);
        procesar.setEnabled(false);
        
        if(this.RetProsc_listo_iCONF() && this.RetProsc_listo_dCONF()){
        this.listo_prosc_iCONF = false;
        this.listo_prosc_dCONF = false;
        this.ddkk1 = null;
        this.ddkk21 = null;
        }
         this.M = this.ag.tp;
         this.base_tiempo = this.ag.pb;
         this.uni_tiempo = this.ag.uni;
         this.kernels = new Kernels(this,this.RetOjo_conf());
         this.kernels.guardar.setEnabled(false);
         this.kernels.setVisible(true);
         this.k1Graf = this.kernels.RetK1graf();
         if(this.ag.oe==1){
           this.ddkk1 = new DensK(this);  
           this.listo_prosc_iCONF = true;}
        else if(this.ag.oe==2){ 
           this.ddkk21 = new DensK(this);  
           this.listo_prosc_dCONF = true;}
        if(this.listo_prosc_iCONF && this.listo_prosc_dCONF) {
           this.Iniciar.setEnabled(true);
        }
        if(!this.listo_prosc_iCONF || !this.listo_prosc_dCONF) this.importar.setEnabled(false);
        else this.importar.setEnabled(true); 
        on_offwvf = "on_wvf";
        on_offdr = "on_dr";
        this.anaDatos1.repaint();
        
    }//GEN-LAST:event_procesarActionPerformed
    boolean at0 = true; 
    private void importarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarActionPerformed
        JCheckBox act = (JCheckBox)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && !at0){
            at0 = true;
            examinar.setEnabled(false);
            procesar.setEnabled(false);
            Calcular.setEnabled(true);
            tiemm.setEnabled(true);
            ResDis.setEnabled(true);
            Iniciar.setEnabled(true);
            Resp3D.setEnabled(false);
            Fc.setEnabled(true);
        }else if(act.getVerifyInputWhenFocusTarget() && at0){
            at0 = false;
            examinar.setEnabled(true);
            procesar.setEnabled(false);
            Calcular.setEnabled(false);
            tiemm.setEnabled(false);
            ResDis.setEnabled(false);
            Iniciar.setEnabled(false);
            Resp3D.setEnabled(true);
            Fc.setEnabled(false);
        }
    }//GEN-LAST:event_importarActionPerformed

    private void examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarActionPerformed
        Import_estim=true;
        this.ag = new AbrirGuardar(this,true);
        this.ag.setVisible(true);
        this.v_k1 = ag.RetSignal_K1();
        this.v_k2 = ag.RetSignal_K2();
        this.v_k3 = ag.RetSignal_K3();
        this.k1 = ag.RetS_K1();
        this.k2 = ag.RetS_K2();
        this.k3 = ag.RetS_K3();     
        this.indice_timeImD = ag.RetIndice_timeImD();
        if(this.ag.RetEstado())procesar.setEnabled(false);
        else procesar.setEnabled(true);
        this.ag.setVisible(false);
        if(!this.RetProsc_listo_iCONF() && !this.RetProsc_listo_dCONF()&& ag.RetEstado()){importar.setEnabled(true);importD=false;}
        else importar.setEnabled(false);
        
    }//GEN-LAST:event_examinarActionPerformed

    private void ResDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResDisActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        ResDisplay = (String)cb.getSelectedItem();
        if(ResDisplay=="800 x 600 píxeles") {ResX = 800;ResY=600;}
        else if(ResDisplay=="1280 x 1024 píxeles"){ResX = 1280;ResY=1024;}
        else if(ResDisplay=="1024 x 768  píxeles"){ResX = 1024;ResY=768;}
        else if(ResDisplay=="1152 x 864 píxeles"){ResX = 1152;ResY=864;}
        
        ModosPreferidos = new DisplayMode[]   {
        new DisplayMode( ResX, ResY, 32, DisplayMode.REFRESH_RATE_UNKNOWN ), 
        new DisplayMode( ResX, ResY, 16, DisplayMode.REFRESH_RATE_UNKNOWN ), 
        new DisplayMode( ResX, ResY, 8, DisplayMode.REFRESH_RATE_UNKNOWN ) };
        
        this.xi = ResX/2-40;
        this.yi = ResY/2-52;
    }//GEN-LAST:event_ResDisActionPerformed

    private void fijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fijoActionPerformed
        tipo_est = fijo.getActionCommand();
    }//GEN-LAST:event_fijoActionPerformed

    private void AltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltActionPerformed
        tipo_est = Alt.getActionCommand();
    }//GEN-LAST:event_AltActionPerformed

    private void EstirStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EstirStateChanged
        JSlider estr = (JSlider)evt.getSource();
        if (!estr.getValueIsAdjusting()) {
            double fpsts = (double)((JSlider)evt.getSource()).getValue()*0.1;
            msStr = fpsts;
        }
        tablero1.repaint();
    }//GEN-LAST:event_EstirStateChanged

    boolean as0 = true;
    private void numeradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeradoActionPerformed
       JCheckBox act = (JCheckBox)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && as0==false){
            as0 = true;    
            enum_onoff = as0;
        }else if(act.getVerifyInputWhenFocusTarget() && as0==true){
            as0 = false;
            enum_onoff = as0;
        }
    }//GEN-LAST:event_numeradoActionPerformed
    boolean as = true;
    private void lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineaActionPerformed
        JCheckBox act = (JCheckBox)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && as==false){
            as = true;    
            line_onoff = as;
        }else if(act.getVerifyInputWhenFocusTarget() && as==true){
            as = false;
            line_onoff = as;
            
        }
    }//GEN-LAST:event_lineaActionPerformed
   
    boolean at = true;    
    private void ActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActActionPerformed
       JCheckBox act = (JCheckBox)evt.getSource();
        if(act.getVerifyInputWhenFocusTarget() && at==false){
            at = true;
            scalTiempo.setEnabled(false);
            tiempo.setText("27");
            tiempo.setEnabled(false);
        }else if(act.getVerifyInputWhenFocusTarget() && at==true){
            at = false;
            scalTiempo.setEnabled(true);
            tiempo.setEnabled(true);
        }
    }//GEN-LAST:event_ActActionPerformed
      
    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        importD = false;
        estimulado = false;
        prosojo = new ProsOjo(this);
        prosojo.setVisible(true);
    }//GEN-LAST:event_CalcularActionPerformed

    private void ScalXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ScalXStateChanged
        factor_Scal1 = (double)Scalador.getValue().hashCode()/100;
        if(factor_Scal1>=0 && factor_Scal1<=1){
        JSlider ms = (JSlider)evt.getSource();
        if (!ms.getValueIsAdjusting()) {
            double fps1 = (double)((JSlider)evt.getSource()).getValue()-50;
            msScal = factor_Scal1*fps1;
        }
        BigDecimal bg1 = new BigDecimal(msScal).setScale(2,BigDecimal.ROUND_UP);
        ScalaX.setText("ms - Escala: "+ bg1);
        grafAnillo1.repaint();
        }else{
       JOptionPane.showMessageDialog(null,"Este no es un valor de Escalado ADECUADO","Error!",2);    
        }
    }//GEN-LAST:event_ScalXStateChanged

    private void ScalYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ScalYStateChanged
        factor_Scal2 = (double)Scalador.getValue().hashCode()/100;
        if(factor_Scal2>=0 && factor_Scal2<=1){
        JSlider mv = (JSlider)evt.getSource();
        if (!mv.getValueIsAdjusting()) {
            double fps2 = (double)((JSlider)evt.getSource()).getValue()-50;
            mVScal = factor_Scal2*fps2;
        }
        BigDecimal bg2 = new BigDecimal(mVScal).setScale(2,BigDecimal.ROUND_UP);
        ScalaY.setText("mV - Escala: "+ bg2);
        grafAnillo1.repaint();
        }else{
       JOptionPane.showMessageDialog(null,"Este no es un valor de Escalado ADECUADO","Error!",2);    
        }
    }//GEN-LAST:event_ScalYStateChanged

    
    private void AplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicarActionPerformed
       try{    
            if(RetOpcion()=="Campo_Visual"){
                grafAnillo1.setVisible(false);
                cv = new mferg(this);
                cv.setVisible(true);    
              }else if(RetOpcion()=="Resp_3D"){
                grafAnillo1.setVisible(false);
                if((Double.parseDouble(Zmax.getText()) >= 0.0 && Double.parseDouble(Zmax.getText()) <= 1.0) && 
                   (Double.parseDouble(Zmin.getText()) >= 0.0 && Double.parseDouble(Zmin.getText()) <= 1.0) &&
                   (Double.parseDouble(Zscal.getText())>= 0.0 && Double.parseDouble(Zscal.getText())<= 1.0)){
                        if(importD){
                            if(this.RetOjo_conf()=="Derecho")Graf3D = new Jed(this,"Derecho");
                            else if(this.RetOjo_conf()=="Izquierdo")Graf3D = new Jed(this,"Izquierdo");
                        }
                        else Graf3D = new Jed(this,this.Ret_ojoEst());
                        Graf3D.setVisible(true);
                }else JOptionPane.showMessageDialog(null,"Parámetros Fuera del Rango [0,1]","Error!",2);
              }
           }catch(java.lang.NumberFormatException r){
                JOptionPane.showMessageDialog(null,"Formato de Parámetro (3D) Erróneo ","Error!",2);
           }catch(java.lang.NullPointerException r){
               if(importD){
                   if(this.RetOjo_conf()=="Derecho" && this.RetProsc_listo_dCONF())
                       JOptionPane.showMessageDialog(null,"Faltan datos del Ojo Izquierdo","Error!",2);
                   else if(this.RetOjo_conf()=="Izquierdo" && this.RetProsc_listo_iCONF())
                       JOptionPane.showMessageDialog(null,"Faltan datos del Ojo Derecho","Error!",2); 
                   else JOptionPane.showMessageDialog(null,"Faltan datos para los DOS Ojos","Error!",2); 
               }else{
                if(this.Ret_ojoEst()=="Derecho" && this.RetProsc_listo_d())
                JOptionPane.showMessageDialog(null,"Test INCOMPLETO - Falta el Ojo Izquierdo","Error!",2);
                else if(this.Ret_ojoEst()=="Izquierdo" && this.RetProsc_listo_i())
                JOptionPane.showMessageDialog(null,"Test INCOMPLETO - Falta el Ojo Derecho","Error!",2);
                else JOptionPane.showMessageDialog(null,"Test INCOMPLETO - Realizelo para los Ojos Derecho e Izquierdo","Error!",2);
               }
           }
        anaDatos1.repaint();
    }//GEN-LAST:event_AplicarActionPerformed

    private void CampVisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampVisActionPerformed
            
            Op_ana = CampVis.getActionCommand();
            Zmax.setEnabled(false);
            Zmin.setEnabled(false);
            Zscal.setEnabled(false);
            grafAnillo1.setVisible(false);
            Aplicar.setText("Analizar");
            ScalX.setEnabled(false);
            ScalY.setEnabled(false);
            Scalador.setEnabled(false);
            linea.setEnabled(false);
            numerado.setEnabled(false);
            anaDatos1.repaint();
            if(!importD){
            if((!listo_prosc_d && !listo_prosc_i)){
            Aplicar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test","Error!",2);}
            else if(estimulado){Aplicar.setEnabled(true);
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test","Error!",2);}    
            else Aplicar.setEnabled(true);
            }else if(importD){
            if((!listo_prosc_dCONF && !listo_prosc_iCONF)){ 
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración","Error!",2);
            Aplicar.setEnabled(true);
            }else Aplicar.setEnabled(true);
            }
    }//GEN-LAST:event_CampVisActionPerformed

    private void MapRegionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapRegionesActionPerformed
            Op_ana = MapRegiones.getActionCommand();
            Zmax.setEnabled(false);
            Zmin.setEnabled(false);
            Zscal.setEnabled(false);
            Aplicar.setEnabled(false);
            Aplicar.setText("Aplicar");
            ScalX.setEnabled(true);
            ScalY.setEnabled(true);
            Scalador.setEnabled(true);
            linea.setEnabled(false);
            numerado.setEnabled(false);
            anaDatos1.repaint();
            grafAnillo1.setVisible(true);
            if(!importD){
            if((!listo_prosc_d && !listo_prosc_i)) 
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test ","Error!",2);
            else if(estimulado){
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test","Error!",2);}
            }else if(importD){
            if((!listo_prosc_dCONF && !listo_prosc_iCONF)) 
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración","Error!",2);
            }
    }//GEN-LAST:event_MapRegionesActionPerformed

    private void DatosRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatosRespActionPerformed
            Op_ana = DatosResp.getActionCommand();
            Zmax.setEnabled(false);
            Zmin.setEnabled(false);
            Zscal.setEnabled(false);
            grafAnillo1.setVisible(false);
            Aplicar.setEnabled(false);
            Aplicar.setText("Aplicar");
            ScalX.setEnabled(false);
            ScalY.setEnabled(false);
            Scalador.setEnabled(false);
            linea.setEnabled(false);
            numerado.setEnabled(false);
            anaDatos1.repaint();
            if(!importD){
            if((!listo_prosc_d && !listo_prosc_i)) 
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test ","Error!",2);
            else if(estimulado){
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test","Error!",2);}
            }else if(importD){
            if((!listo_prosc_dCONF && !listo_prosc_iCONF)) 
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración","Error!",2);
            }
    }//GEN-LAST:event_DatosRespActionPerformed

    private void Resp3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Resp3DActionPerformed
        Op_ana = Resp3D.getActionCommand();
        Zmax.setEnabled(true);
        Zmin.setEnabled(true);
        Zscal.setEnabled(true);
        grafAnillo1.setVisible(false);
        Aplicar.setEnabled(true);
        Aplicar.setText("Aplicar");
        ScalX.setEnabled(false);
        ScalY.setEnabled(false);
        Scalador.setEnabled(false);
        linea.setEnabled(true);
        numerado.setEnabled(true);
        anaDatos1.repaint();
        if(!importD){
        if((!listo_prosc_d && !listo_prosc_i)) 
        JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test ","Error!",2);
        else if(estimulado){
        JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test","Error!",2);}
        }else if(importD){
        if((!listo_prosc_dCONF && !listo_prosc_iCONF)) 
        JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración","Error!",2);
        }
    }//GEN-LAST:event_Resp3DActionPerformed

    private void TzWaveformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TzWaveformActionPerformed
        Op_ana = TzWaveform.getActionCommand();
            Zmax.setEnabled(false);
            Zmin.setEnabled(false);
            Zscal.setEnabled(false);
            grafAnillo1.setVisible(false);
            Aplicar.setEnabled(false);
            Aplicar.setText("Aplicar");
            ScalX.setEnabled(false);
            ScalY.setEnabled(false);
            Scalador.setEnabled(false);
            linea.setEnabled(false);
            numerado.setEnabled(false);
            anaDatos1.repaint();
            if(!importD){
            if((!listo_prosc_d && !listo_prosc_i)) 
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test ","Error!",2);
            else if(estimulado){
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración de Estímulo después del Test","Error!",2);}
            }else if(importD){
            if((!listo_prosc_dCONF && !listo_prosc_iCONF)) 
            JOptionPane.showMessageDialog(null,"No ha PROCESADO los datos, Presione PROCESAR en Configuración","Error!",2);
            }
    }//GEN-LAST:event_TzWaveformActionPerformed

    private void Ch1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Ch1StateChanged
        JSlider bl = (JSlider)evt.getSource();
        if (!bl.getValueIsAdjusting()) {
                double fps = (double)((JSlider)evt.getSource()).getValue()-50;
                   bl1 = fps;
            }
    adqDatos1.repaint();
    }//GEN-LAST:event_Ch1StateChanged

    private void scalTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scalTiempoActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        uni_tiempo = (String)cb.getSelectedItem();
    }//GEN-LAST:event_scalTiempoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        importar.setEnabled(false);
        Resp3D.setEnabled(false);
        estimulado = true;
        importD = false;
        play_time=true;
//        tstop=new timepostop(this);
        if(this.RetProsc_listo_d() && this.RetProsc_listo_i()){
        this.listo_prosc_d = false;
        this.listo_prosc_i = false;
        this.ddkk = null;
        this.ddkk2 = null;
        }
        z = (this.RetEstir()*1.70235+40);    
        try{
            M = Integer.parseInt(TotalPat.getText());
            if(M>=15){
            Nm++;
            Calcular.setEnabled(true);
            base_tiempo = Double.parseDouble(tiempo.getText());
            
            ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            gd = ge.getDefaultScreenDevice();
            gc = gd.getDefaultConfiguration();
            dm = mejorModo( gd );   
                
        fs=true;
        if( dm == null || gd.isFullScreenSupported() == false ) fs = false;
        prinFrame = new Frame( gc );
        prinFrame.setLayout( null );
        prinFrame.setIgnoreRepaint( true );
        
        if( fs ) {
            prinFrame.setUndecorated( true );       // Sin decoraciones de Windows
            gd.setFullScreenWindow( prinFrame );    // Crear Pantalla FullScreen
            gd.setDisplayMode( dm );                // Cambia a nuestro modo preferido
            ScreenWidth = dm.getWidth();            // Devuelve las dimensiones de nuestra pantalla
            ScreenHeight = dm.getHeight();
        } else {
            ScreenWidth = ResX;
            ScreenHeight = ResY;
            prinFrame.setSize( new Dimension( ScreenWidth, ScreenHeight ) );
            prinFrame.show();
        }
        prinFrame.createBufferStrategy( 2 );
        bufferStrategy = prinFrame.getBufferStrategy();
        ms_ini = fyh.getTime();
        k=0;
while(Running && k<=M+1){   //Actualizacion de la Pantalla
    if( !bufferStrategy.contentsLost()) {
        Graphics g = bufferStrategy.getDrawGraphics(); 
//        tstop.run();
        if(k==0 || k==M+1 ){
            g.setColor( Color.BLACK );
            g.fillRect( 0, 0, ScreenWidth, ScreenHeight );
            g.translate(this.getInsets().right,this.getInsets().top );
            Cruz(g);
        }else{   
        g.setColor( Color.cyan);
        g.fillRect( 0, 0, ScreenWidth, ScreenHeight );
        g.translate(this.getInsets().right,this.getInsets().top );
        
        if(tipo_est=="alt"){
            for(int i=0;i<21;i++){
                for(int j=0;j<5;j++){
                    pat[i][j]=valor;
                    valor=r.nextInt(2);
                    patrones=patrones+String.valueOf(pat[i][j]);
                }
            }
        }else if(tipo_est=="fijo"){
            for(int i=0;i<21;i++){
                for(int j=0;j<5;j++){
                    pat[i][j]=pat2[k][i][j];
                    patrones=patrones+String.valueOf(pat[i][j]);
                }
            }
        }
// Hexagono 0
int x0[] = {xi,xi,xi+(int)(0.86*z),xi+(int)(z*0.86*2),xi+(int)(z*0.86*2),xi+(int)(0.86*z)};
int y0[] = {yi,yi+(int)(z),yi+(int)(z+z*0.5),yi+(int)(z),yi,yi-(int)(z*0.5)};

int bx[]={x0[5],x0[4],x0[3],x0[2],x0[1],x0[0]};
int by[]={y0[5],y0[4],y0[3],y0[2],y0[1],y0[0]};
if (pat[0][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x0,y0,6 );
    g.setColor(Color.black);
    g.drawPolygon(x0,y0,6);
}else{g.setColor( Color.black );
g.fillPolygon( x0,y0,6 );}

// Hexagono 1
int x1[] ={(int)(bx[5]-0.86*(z+z0)),(int)(bx[5]-0.86*(z+z0)),bx[5],(int)(bx[5]+0.86*(z+z0)),bx[0],bx[5]};
int y1[]={(int)(by[5]-0.5*(z+z0)),(int)(by[5]-0.5*(z+z0)-(z+z0)),(int)(by[5]-2*(z+z0)),(int)(by[5]-0.5*(z+z0)-(z+z0)),by[0],by[5]};
//Cambios
int tx15=x1[0],tx16=x1[1],tx17=x1[2],tx0=x1[3];
int ty15=y1[0],ty16=y1[1],ty17=y1[2],ty0=y1[3];
if (pat[0][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x1,y1,6 );
    g.setColor(Color.black);
    g.drawPolygon(x1,y1,6);
}else{g.setColor( Color.black );
g.fillPolygon( x1,y1,6 );}

// Hexagono 2
int x2[] ={(int)(bx[5]-0.86*(z+z0)*2),(int)(bx[5]-0.86*(z+z0)*2),tx15,bx[5],bx[4],(int)(bx[5]-0.86*(z+z0))};
int y2[]={(int)(by[5]+(z+z0)),y0[0],ty15,by[5],by[4],(int)(by[5]+0.5*(z+z0)+(z+z0))};
//Cambios
int tx13=x2[0],tx14=x2[1],tx12=x2[5];
int ty13=y2[0],ty14=y2[1],ty12=y2[5];
if (pat[0][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x2,y2,6 );
    g.setColor(Color.black);
    g.drawPolygon(x2,y2,6);
}else{g.setColor( Color.black );
g.fillPolygon( x2,y2,6 );}

// Hexagono 3
int x3[] ={(int)(bx[4]-0.86*(z+z0)),tx12,bx[4],bx[3],(int)(bx[4]+0.86*(z+z0)),x0[1]};
int y3[]={(int)(by[4]+0.5*(z+z0)+(z+z0)),ty12,by[4],by[3],(int)(by[4]+0.5*(z+z0)+(z+z0)),(int)(by[4]+2*(z+z0))};

//Cambios
int tx11=x3[0],tx9=x3[4],tx10=x3[5];
int ty11=y3[0],ty9=y3[4],ty10=y3[5];
if (pat[0][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x3,y3,6 );
    g.setColor(Color.black);
    g.drawPolygon(x3,y3,6);
}else{g.setColor( Color.black );
g.fillPolygon( x3,y3,6 );}

// Hexagono 4
int x4[] ={tx9,bx[3],bx[2],(int)(x0[2]+0.86*(z+z0)*2),(int)(x0[2]+0.86*(z+z0)*2),(int)(x0[2]+0.86*(z+z0))};
int y4[]={ty9,by[3],by[2],y0[2],(int)(y0[2]+(z+z0)),(int)(y0[2]+0.5*(z+z0)+(z+z0))};
//Cambios
int tx6=x4[3],tx7=x4[4],tx8=x4[5];
int ty6=y4[3],ty7=y4[4],ty8=y4[5];

if (pat[0][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x4,y4,6 );
    g.setColor(Color.black);
    g.drawPolygon(x4,y4,6);
}else{g.fillPolygon( x4,y4,6 );}

// Hexagono 5
int x5[] ={bx[2],bx[1],(int)(bx[2]+0.86*(z+z0)),(int)(bx[2]+0.86*(z+z0)*2),(int)(bx[2]+0.86*(z+z0)*2),tx6};
int y5[]={by[2],by[1],(int)(by[2]-(z+z0)-0.5*(z+z0)),(int)(by[2]-(z+z0)),y0[3],ty6};

//Cambios
int tx3=x5[2],tx4=x5[3],tx5=x5[4];
int ty3=y5[2],ty4=y5[3],ty5=y5[4];
if (pat[1][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x5,y5,6 );
    g.setColor(Color.black);
    g.drawPolygon(x5,y5,6);
}else{g.fillPolygon( x5,y5,6 );}

// Hexagono 6
int x6[] ={bx[0],tx0,x0[4],(int)(bx[1]+0.86*(z+z0)),tx3,bx[1]};
int y6[]={by[0],ty0,(int)(by[1]-(z+z0)*2),(int)(by[1]-0.5*(z+z0)-(z+z0)),ty3,by[1]};

//Cambios
int tx1=x6[2],tx2=x6[3];
int ty1=y6[2],ty2=y6[3];
if (pat[1][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x6,y6,6 );
    g.setColor(Color.black);
    g.drawPolygon(x6,y6,6);
}else{g.fillPolygon( x6,y6,6 );}

//----------------Final del Anillo ?(j) -----------------------------------------------------

// Hexagono 7
int x7[] ={(int)(tx14-0.86*(z+z0+z1)),(int)(tx14-0.86*(z+z0+z1)),tx14,tx16,tx15,tx14};
int y7[]={(int)(ty14-0.5*(z+z0+z1)),(int)(ty14-0.5*(z+z0+z1)-(z+z0+z1)),(int)(ty14-(z+z0+z1)*2),ty16,ty15,ty14};

//Cambios
int ax25=x7[0],ax26=x7[1],ax27=x7[2];
int ay25=y7[0],ay26=y7[1],ay27=y7[2];
if (pat[1][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x7,y7,6 );
    g.setColor(Color.black);
    g.drawPolygon(x7,y7,6);
}else{g.fillPolygon( x7,y7,6 );}

// Hexagono 8
int x8[] ={(int)(ax25-0.86*(z+z0+z1)),(int)(ax25-0.86*(z+z0+z1)),ax25,tx14,tx13,ax25};
int y8[]={(int)(ay25+0.5*(z+z0)+(z+z0+z1)),(int)(ay25+0.5*(z+z0+z1)),ay25,ty14,ty13,(int)(ay25+(z+z0+z1)*2)};

//Cambios
int ax23=x8[0],ax24=x8[1],ax22=x8[5];
int ay23=y8[0],ay24=y8[1],ay22=y8[5];
if (pat[1][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x8,y8,6 );
    g.setColor(Color.black);
    g.drawPolygon(x8,y8,6);
}else{g.fillPolygon( x8,y8,6 );}

// Hexagono 9
int x9[] ={(int)(tx13-0.86*(z+z0+z1)),ax22,tx13,tx12,tx11,tx13};
int y9[]={(int)(ty13+0.5*(z+z0+z1)+(z+z0+z1)),ay22,ty13,ty12,ty11,(int)(ty13+(z+z0+z1)*2)};

//Cambios
int ax21=x9[0],ax20=x9[5];
int ay21=y9[0],ay20=y9[5];
if (pat[1][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x9,y9,6 );
    g.setColor(Color.black);
    g.drawPolygon(x9,y9,6);
}else{g.fillPolygon( x9,y9,6 );}

// Hexagono 10
int x10[] ={(int)(tx11-0.86*(z+z0+z1)),ax20,tx11,tx10,(int)(tx11+0.86*(z+z0+z1)),tx11};
int y10[]={(int)(ty11+0.5*(z+z0+z1)+(z+z0+z1)),ay20,ty11,ty10,(int)(ty11+0.5*(z+z0+z1)+(z+z0+z1)),(int)(ty11+(z+z0+z1)*2)};

//Cambios
int ax19=x10[0],ax17=x10[4],ax18=x10[5];
int ay19=y10[0],ay17=y10[4],ay18=y10[5];
if (pat[2][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x10,y10,6 );
    g.setColor(Color.black);
    g.drawPolygon(x10,y10,6);
}else{g.fillPolygon( x10,y10,6 );}

// Hexagono 11
int x11[] ={ax17,tx10,tx9,tx8,(int)(tx10+0.86*2*(z+z0+z1)),(int)(tx10+0.86*(z+z0+z1))};
int y11[]={ay17,ty10,ty9,ty8,(int)(ty10+(z+z0+z1)),(int)(ty10+0.5*(z+z0+z1)+(z+z0+z1))};

//Cambios
int ax15=x11[4],ax16=x11[5];
int ay15=y11[4],ay16=y11[5];
if (pat[2][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x11,y11,6 );
    g.setColor(Color.black);
    g.drawPolygon(x11,y11,6);
}else{g.fillPolygon( x11,y11,6 );}

// Hexagono 12
int x12[] ={ax15,tx8,tx7,(int)(tx8+0.86*2*(z+z0+z1)),(int)(tx8+0.86*2*(z+z0+z1)),(int)(tx8+0.86*(z+z0+z1))};
int y12[]={ay15,ty8,ty7,ty8,(int)(ty8+(z+z0+z1)),(int)(ty8+0.5*(z+z0+z1)+(z+z0+z1))};

//Cambios
int ax12=x12[3],ax13=x12[4],ax14=x12[5];
int ay12=y12[3],ay13=y12[4],ay14=y12[5];
if (pat[2][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x12,y12,6 );
    g.setColor(Color.black);
    g.drawPolygon(x12,y12,6);
}else{g.fillPolygon( x12,y12,6 );}

// Hexagono 13
int x13[] ={tx7,tx6,tx5,(int)(tx7+0.86*2*(z+z0+z1)),(int)(tx7+0.86*(z+z0+z1)*2),ax12};
int y13[]={ty7,ty6,ty5,(int)(ty7-(z+z0+z1)),ty7,ay12};
g.setColor( Color.black );
//Cambios
int ax10=x13[3],ax11=x13[4];
int ay10=y13[3],ay11=y13[4];
if (pat[2][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x13,y13,6 );
    g.setColor(Color.black);
    g.drawPolygon(x13,y13,6);
}else{g.fillPolygon( x13,y13,6 );}

// Hexagono 14
int x14[] ={tx5,tx4,(int)(tx4+0.86*(z+z0+z1)),(int)(tx4+0.86*2*(z+z0+z1)),(int)(tx4+0.86*2*(z+z0+z1)),ax10};
int y14[]={ty5,ty4,(int)(ty4-0.5*(z+z0+z1)),ty4,(int)(ty4+(z+z0+z1)),ay10};

//Cambios
int ax7=x14[2],ax8=x14[3],ax9=x14[4];
int ay7=y14[2],ay8=y14[3],ay9=y14[4];
if (pat[2][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x14,y14,6 );
    g.setColor(Color.black);
    g.drawPolygon(x14,y14,6);
}else{g.fillPolygon( x14,y14,6 );}

// Hexagono 15
int x15[] ={tx3,tx2,x14[1],(int)(x14[1]+0.86*(z+z0+z1)),ax7,tx4};
int y15[]={ty3,ty2,y14[1]-2*(int)(z+z0+z1),(int)(y14[1]-0.5*(z+z0+z1)-(z+z0+z1)),ay7,ty4};

//Cambios
int ax5=x15[2],ax6=x15[3];
int ay5=y15[2],ay6=y15[3];
if (pat[3][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x15,y15,6 );
    g.setColor(Color.black);
    g.drawPolygon(x15,y15,6);
}else{g.fillPolygon( x15,y15,6 );}

// Hexagono 16
int x16[] ={tx1,tx1,(int)(tx1+0.86*(z+z0+z1)),(int)(tx1+2*(z+z0+z1)*0.86),ax5,tx2};
int y16[]={ty1,ty1-(int)(z+z0+z1),(int)(ty1-0.5*(z+z0+z1)-(z+z0+z1)),ty1-(int)(z+z0+z1),ay5,ty2};

//Cambios
int ax2=x16[1],ax3=x16[2],ax4=x16[3];
int ay2=y16[1],ay3=y16[2],ay4=y16[3];
if (pat[3][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x16,y16,6 );
    g.setColor(Color.black);
    g.drawPolygon(x16,y16,6);
}else{g.fillPolygon( x16,y16,6 );}

// Hexagono 17
int x17[] ={tx17,(int)(ax2-0.86*(z+z0+z1)*2),(int)(ax2-0.86*(z+z0+z1)),ax2,tx1,tx0};
int y17[]={ty17,ay2,(int)(ay2-0.5*(z+z0+z1)),ay2,ty1,ty0};

//Cambios
int ax0=x17[1],ax1=x17[2];
int ay0=y17[1],ay1=y17[2];
if (pat[3][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x17,y17,6 );
    g.setColor(Color.black);
    g.drawPolygon(x17,y17,6);
}else{g.fillPolygon( x17,y17,6 );}

// Hexagono 18
int x18[] ={ax27,(int)(ax0-0.86*(z+z0+z1)*2),(int)(ax0-0.86*(z+z0+z1)),ax0,tx17,tx16};
int y18[]={ay27,ay0,(int)(ay0-0.5*(z+z0+z1)),ay0,ty17,ty16};

//Cambios
int ax28=x18[1],ax29=x18[2];
int ay28=y18[1],ay29=y18[2];
if (pat[3][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x18,y18,6 );
    g.setColor(Color.black);
    g.drawPolygon(x18,y18,6);
}else{g.fillPolygon( x18,y18,6 );}

//-------------------- Fin del Anillo ?(k) ---------------------------

// Hexagono 19
int x19[] ={(int)(ax24-0.86*(z+z0+z1+z2)),(int)(ax24-0.86*(z+z0+z1+z2)),ax24,ax26,ax25,ax24};
int y19[]={(int)(ay24-0.5*(z+z0+z1+z2)),(int)(ay24-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),(int)(ay24-2*(z+z0+z1+z2)),ay26,ay25,ay24};

//Cambios
int lx32=x19[0],lx33=x19[1],lx34=x19[2];
int ly32=y19[0],ly33=y19[1],ly34=y19[2];
if (pat[3][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x19,y19,6 );
    g.setColor(Color.black);
    g.drawPolygon(x19,y19,6);
}else{g.fillPolygon( x19,y19,6 );}

// Hexagono 20
int x20[] ={(int)(ax24-2*0.86*(z+z0+z1+z2)),(int)(ax24-2*0.86*(z+z0+z1+z2)),lx32,ax24,ax23,(int)(ax24-0.86*(z+z0+z1+z2))};
int y20[]={(int)(ay24+(z+z0+z1+z2)),ay24,ly32,ay24,ay23,(int)(ay24+0.5*(z+z0+z1+z2)+(z+z0+z1+z2))};

//Cambios
int lx30=x20[0],lx31=x20[1],lx29=x20[5];
int ly30=y20[0],ly31=y20[1],ly29=y20[5];
if (pat[4][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x20,y20,6 );
    g.setColor(Color.black);
    g.drawPolygon(x20,y20,6);
}else{g.fillPolygon( x20,y20,6 );}

// Hexagono 21
int x21[] ={(int)(ax23-0.86*(z+z0+z1+z2)),lx29,ax23,ax22,ax21,ax23};
int y21[]={(int)(ay23+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly29,ay23,ay22,ay21,ay23+2*(int)(z+z0+z1+z2)};

//Cambios
int lx28=x21[0],lx27=x21[5];
int ly28=y21[0],ly27=y21[5];
if (pat[4][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x21,y21,6 );
    g.setColor(Color.black);
    g.drawPolygon(x21,y21,6);
}else{g.fillPolygon( x21,y21,6 );}

// Hexagono 22
int x22[] ={(int)(ax21-0.86*(z+z0+z1+z2)),lx27,ax21,ax20,ax19,ax21};
int y22[]={(int)(ay21+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly27,ay21,ay20,ay19,ay21+2*(int)(z+z0+z1+z2)};

//Cambios
int lx26=x22[0],lx25=x22[5];
int ly26=y22[0],ly25=y22[5];
if (pat[4][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x22,y22,6 );
    g.setColor(Color.black);
    g.drawPolygon(x22,y22,6);
}else{g.fillPolygon( x22,y22,6 );}

// Hexagono 23
int x23[] ={(int)(ax19-0.86*(z+z0+z1+z2)),lx25,ax19,ax18,(int)(ax19+0.86*(z+z0+z1+z2)),ax19};
int y23[]={(int)(ay19+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly25,ay19,ay18,(int)(ay19+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay19+2*(int)(z+z0+z1+z2)};

//Cambios
int lx24=x23[0],lx23=x23[5],lx22=x23[4];
int ly24=y23[0],ly23=y23[5],ly22=y23[4];
if (pat[4][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x23,y23,6 );
    g.setColor(Color.black);
    g.drawPolygon(x23,y23,6);
}else{g.fillPolygon( x23,y23,6 );}

// Hexagono 24
int x24[] ={lx22,ax18,ax17,ax16,(int)(ax17+0.86*(z+z0+z1+z2)),ax17};
int y24[]={ly22,ay18,ay17,ay16,(int)(ay17+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay17+2*(int)(z+z0+z1+z2)};

//Cambios
int lx20=x24[4],lx21=x24[5];
int ly20=y24[4],ly21=y24[5];
if (pat[4][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x24,y24,6 );
    g.setColor(Color.black);
    g.drawPolygon(x24,y24,6);
}else{g.fillPolygon( x24,y24,6 );}

// Hexagono 25
int x25[] ={lx20,ax16,ax15,ax14,(int)(ax15+0.86*(z+z0+z1+z2)),ax15};
int y25[]={ly20,ay16,ay15,ay14,(int)(ay15+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay15+2*(int)(z+z0+z1+z2)};

//Cambios
int lx18=x25[4],lx19=x25[5];
int ly18=y25[4],ly19=y25[5];
if (pat[5][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x25,y25,6 );
    g.setColor(Color.black);
    g.drawPolygon(x25,y25,6);
}else{g.fillPolygon( x25,y25,6 );}

// Hexagono 26
int x26[] ={lx18,ax14,ax13,(int)(ax13+0.86*(z+z0+z1+z2)),(int)(ax13+0.86*(z+z0+z1+z2)),ax13};
int y26[]={ly18,ay14,ay13,(int)(ay13+0.5*(z+z0+z1+z2)),(int)(ay13+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ay13+2*(int)(z+z0+z1+z2)};

//Cambios
int lx15=x26[3],lx16=x26[4],lx17=x26[5];
int ly15=y26[3],ly16=y26[4],ly17=y26[5];
if (pat[5][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x26,y26,6 );
    g.setColor(Color.black);
    g.drawPolygon(x26,y26,6);
}else{g.fillPolygon( x26,y26,6 );}

// Hexagono 27
int x27[] ={ax13,ax12,ax11,(int)(ax11+0.86*(z+z0+z1+z2)),(int)(ax11+0.86*(z+z0+z1+z2)),lx15};
int y27[]={ay13,ay12,ay11,(int)(ay11+0.5*(z+z0+z1+z2)),(int)(ay11+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly15};

//Cambios
int lx13=x27[3],lx14=x27[4];
int ly13=y27[3],ly14=y27[4];
if (pat[5][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x27,y27,6 );
    g.setColor(Color.black);
    g.drawPolygon(x27,y27,6);
}else{g.fillPolygon( x27,y27,6 );}

// Hexagono 28
int x28[] ={ax11,ax10,ax9,(int)(ax9+0.86*(z+z0+z1+z2)),(int)(ax9+0.86*(z+z0+z1+z2)),lx13};
int y28[]={ay11,ay10,ay9,(int)(ay9+0.5*(z+z0+z1+z2)),(int)(ay9+0.5*(z+z0+z1+z2)+(z+z0+z1+z2)),ly13};

//Cambios
int lx11=x28[3],lx12=x28[4];
int ly11=y28[3],ly12=y28[4];
if (pat[5][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x28,y28,6 );
    g.setColor(Color.black);
    g.drawPolygon(x28,y28,6);
}else{g.fillPolygon( x28,y28,6 );}

// Hexagono 29
int x29[] ={ax9,ax8,(int)(ax8+0.86*(z+z0+z1+z2)),(int)(ax8+2*0.86*(z+z0+z1+z2)),(int)(ax8+2*0.86*(z+z0+z1+z2)),lx11};
int y29[]={ay9,ay8,(int)(ay8-0.5*(z+z0+z1+z2)),ay8,(int)(ay8+(z+z0+z1+z2)),ly11};

//Cambios
int lx9=x29[3],lx10=x29[4],lx8=x29[2];
int ly9=y29[3],ly10=y29[4],ly8=y29[2];
if (pat[5][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x29,y29,6 );
    g.setColor(Color.black);
    g.drawPolygon(x29,y29,6);
}else{g.fillPolygon( x29,y29,6 );}

// Hexagono 30
int x30[] ={ax7,ax6,(int)(ax6+0.86*(z+z0+z1+z2)),(int)(ax6+2*0.86*(z+z0+z1+z2)),lx8,ax8};
int y30[]={ay7,ay6,(int)(ay6-0.5*(z+z0+z1+z2)),ay6,ly8,ay8};

//Cambios
int lx6=x30[2],lx7=x30[3];
int ly6=y30[2],ly7=y30[3];
if (pat[6][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x30,y30,6 );
    g.setColor(Color.black);
    g.drawPolygon(x30,y30,6);
}else{g.fillPolygon( x30,y30,6 );}

// Hexagono 31
int x31[] ={ax5,ax4,(int)(ax4+0.86*(z+z0+z1+z2)),(int)(ax4+2*0.86*(z+z0+z1+z2)),lx6,ax6};
int y31[]={ay5,ay4,(int)(ay4-0.5*(z+z0+z1+z2)),ay4,ly6,ay6};

//Cambios
int lx4=x31[2],lx5=x31[3];
int ly4=y31[2],ly5=y31[3];
if (pat[6][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x31,y31,6 );
    g.setColor(Color.black);
    g.drawPolygon(x31,y31,6);
}else{g.fillPolygon( x31,y31,6 );}

// Hexagono 32
int x32[] ={ax3,ax3,(int)(ax3+0.86*(z+z0+z1+z2)),(int)(ax3+2*0.86*(z+z0+z1+z2)),lx4,ax4};
int y32[]={ay3,ay3-(int)(z+z0+z1+z2),(int)(ay3-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ay3-(int)(z+z0+z1+z2),ly4,ay4};

//Cambios
int lx1=x32[1],lx2=x32[2],lx3=x32[3];
int ly1=y32[1],ly2=y32[2],ly3=y32[3];
if (pat[6][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x32,y32,6 );
    g.setColor(Color.black);
    g.drawPolygon(x32,y32,6);
}else{g.fillPolygon( x32,y32,6 );}

// Hexagono 33
int x33[] ={ax1,ax1,(int)(ax1+0.86*(z+z0+z1+z2)),lx1,ax3,ax2};
int y33[]={ay1,ay1-(int)(z+z0+z1+z2),(int)(ay1-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ly1,ay3,ay2};

//Cambios
int lx41=x33[1],lx0=x33[2];
int ly41=y33[1],ly0=y33[2];
if (pat[6][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x33,y33,6 );
    g.setColor(Color.black);
    g.drawPolygon(x33,y33,6);
}else{g.fillPolygon( x33,y33,6 );}

// Hexagono 34
int x34[] ={ax29,ax29,(int)(ax29+0.86*(z+z0+z1+z2)),lx41,ax1,ax0};
int y34[]={ay29,ay29-(int)(z+z0+z1+z2),(int)(ay29-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ly41,ay1,ay0};

//Cambios
int lx39=x34[1],lx40=x34[2];
int ly39=y34[1],ly40=y34[2];
if (pat[6][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x34,y34,6 );
    g.setColor(Color.black);
    g.drawPolygon(x34,y34,6);
}else{g.fillPolygon( x34,y34,6 );}

// Hexagono 35
int x35[] ={(int)(ax28-0.86*(z+z0+z1+z2)),(int)(ax28-0.86*(z+z0+z1+z2)),ax28,lx39,ax29,ax28};
int y35[]={(int)(ay28-0.5*(z+z0+z1+z2)),(int)(ay28-0.5*(z+z0+z1+z2)-(z+z0+z1+z2)),ay28-2*(int)(z+z0+z1+z2),ly39,ay29,ay28};

//Cambios
int lx36=x35[0],lx37=x35[1],lx38=x35[2];
int ly36=y35[0],ly37=y35[1],ly38=y35[2];
if (pat[7][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x35,y35,6 );
    g.setColor(Color.black);
    g.drawPolygon(x35,y35,6);
}else{g.fillPolygon( x35,y35,6 );}

// Hexagono 36
int x36[] ={lx34,lx34,lx36,ax28,ax27,ax26};
int y36[]={ly34,ly34-(int)(z+z0+z1+z2),ly36,ay28,ay27,ay26};

//Cambios
int lx35=x36[1];
int ly35=y36[1];
if (pat[7][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x36,y36,6 );
    g.setColor(Color.black);
    g.drawPolygon(x36,y36,6);
}else{g.fillPolygon( x36,y36,6 );}

//---------------------Final del Anillo ?(n) ------------------------------------------

// Hexagono 37
int x37[] ={(int)(lx31-0.86*(z+z0+z1+z2+z3)),(int)(lx31-0.86*(z+z0+z1+z2+z3)),lx31,lx33,lx32,lx31};
int y37[]={(int)(ly31-0.5*(z+z0+z1+z2+z3)),(int)(ly31-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),ly31-2*(int)(z+z0+z1+z2+z3),ly33,ly32,ly31};

//Cambios
int px42=x37[0],px43=x37[1],px44=x37[2];
int py42=y37[0],py43=y37[1],py44=y37[2];
if (pat[7][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x37,y37,6 );
    g.setColor(Color.black);
    g.drawPolygon(x37,y37,6);
}else{g.fillPolygon( x37,y37,6 );}

// Hexagono 38
int x38[] ={(int)(px42-0.86*(z+z0+z1+z2+z3)),(int)(px42-0.86*(z+z0+z1+z2+z3)),px42,lx31,lx30,px42};
int y38[]={(int)(py42+0.5*(z+z0)+(z+z0+z1+z2+z3)),(int)(py42+0.5*(z+z0+z1+z2+z3)),py42,ly31,ly30,py42+2*(int)(z+z0+z1+z2+z3)};

//Cambios
int px40=x38[0],px41=x38[1],px39=x38[5];
int py40=y38[0],py41=y38[1],py39=y38[5];
if (pat[7][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x38,y38,6 );
    g.setColor(Color.black);
    g.drawPolygon(x38,y38,6);
}else{g.fillPolygon( x38,y38,6 );}

// Hexagono 39
int x39[] ={(int)(lx30-0.86*(z+z0+z1+z2+z3)),px39,lx30,lx29,lx28,lx30};
int y39[]={(int)(ly30+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py39,ly30,ly29,ly28,ly30+2*(int)(z+z0)};

//Cambios
int px38=x39[0],px37=x39[5];
int py38=y39[0],py37=y39[5];
if (pat[7][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x39,y39,6 );
    g.setColor(Color.black);
    g.drawPolygon(x39,y39,6);
}else{g.fillPolygon( x39,y39,6 );}

// Hexagono 40
int x40[] ={(int)(lx28-0.86*(z+z0+z1+z2+z3)),px37,lx28,lx27,lx26,lx28};
int y40[]={(int)(ly28+0.5*(z+z0)+(z+z0+z1+z2+z3)),py37,ly28,ly27,ly26,ly28+2*(int)(z+z0+z1+z2+z3)};

//Cambios
int px36=x40[0],px35=x40[5];
int py36=y40[0],py35=y40[5];
if (pat[8][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x40,y40,6 );
    g.setColor(Color.black);
    g.drawPolygon(x40,y40,6);
}else{g.fillPolygon( x40,y40,6 );}


// Hexagono 41
int x41[] ={(int)(lx26-0.86*(z+z0+z1+z2+z3)),px35,lx26,lx25,lx24,lx26};
int y41[]={(int)(ly26+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py35,ly26,ly25,ly24,ly26+2*(int)(z+z0+z1+z2+z3)};

//Cambios
int px34=x41[0],px33=x41[5];
int py34=y41[0],py33=y41[5];
if (pat[8][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x41,y41,6 );
    g.setColor(Color.black);
    g.drawPolygon(x41,y41,6);
}else{g.fillPolygon( x41,y41,6 );}

// Hexagono 42
int x42[] ={(int)(lx24-0.86*(z+z0+z1+z2+z3)),px33,lx24,lx23,(int)(lx24+0.86*(z+z0+z1+z2+z3)),lx24};
int y42[]={(int)(ly24+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py33,ly24,ly23,(int)(ly24+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),ly24+2*(int)(z+z0+z1+z2+z3)};

//Cambios
int px32=x42[0],px31=x42[5],px30=x42[4];
int py32=y42[0],py31=y42[5],py30=y42[4];
if (pat[8][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x42,y42,6 );
    g.setColor(Color.black);
    g.drawPolygon(x42,y42,6);
}else{g.fillPolygon( x42,y42,6 );}

// Hexagono 43
int x43[] ={px30,lx23,lx22,lx21,(int)(lx22+0.86*(z+z0+z1+z2+z3)),lx22};
int y43[]={py30,ly23,ly22,ly21,(int)(ly22+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),(int)(ly22+2*(z+z0+z1+z2+z3))};

//Cambios
int px29=x43[5],px28=x43[4];
int py29=y43[5],py28=y43[4];
if (pat[8][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x43,y43,6 );
    g.setColor(Color.black);
    g.drawPolygon(x43,y43,6);
}else{g.fillPolygon( x43,y43,6 );}

// Hexagono 44
int x44[] ={px28,lx21,lx20,lx19,(int)(lx20+0.86*(z+z0+z1+z2+z3)),lx20};
int y44[]={py28,ly21,ly20,ly19,(int)(ly20+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),(int)(ly20+2*(z+z0+z1+z2+z3))};

//Cambios
int px27=x44[5],px26=x44[4];
int py27=y44[5],py26=y44[4];
if (pat[8][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x44,y44,6 );
    g.setColor(Color.black);
    g.drawPolygon(x44,y44,6);
}else{g.fillPolygon( x44,y44,6 );}

// Hexagono 45
int x45[] ={px26,lx19,lx18,lx17,(int)(lx18+0.86*(z+z0+z1+z2+z3)),lx18};
int y45[]={py26,ly19,ly18,ly17,(int)(ly18+0.5*(z+z0)+(z+z0+z1+z2+z3)),(int)(ly18+2*(z+z0+z1+z2+z3))};

//Cambios
int px25=x45[5],px24=x45[4];
int py25=y45[5],py24=y45[4];
if (pat[9][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x45,y45,6 );
    g.setColor(Color.black);
    g.drawPolygon(x45,y45,6);
}else{g.fillPolygon( x45,y45,6 );}

// Hexagono 46
int x46[] ={px24,lx17,lx16,(int)(lx16+0.86*(z+z0+z1+z2+z3)),(int)(lx16+0.86*(z+z0+z1+z2+z3)),lx16};
int y46[]={py24,ly17,ly16,(int)(ly16+0.5*(z+z0+z1+z2+z3)),(int)(ly16+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),ly16+2*(int)(z+z0+z1+z2+z3)};

//Cambios
int px23=x46[5],px22=x46[4],px21=x46[3];
int py23=y46[5],py22=y46[4],py21=y46[3];
if (pat[9][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x46,y46,6 );
    g.setColor(Color.black);
    g.drawPolygon(x46,y46,6);
}else{g.fillPolygon( x46,y46,6 );}

// Hexagono 47
int x47[] ={lx16,lx15,lx14,(int)(lx14+0.86*(z+z0+z1+z2+z3)),(int)(lx14+0.86*(z+z0+z1+z2+z3)),px21};
int y47[]={ly16,ly15,ly14,(int)(ly14+0.5*(z+z0+z1+z2+z3)),(int)(ly14+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py21};

//Cambios
int px20=x47[4],px19=x47[3];
int py20=y47[4],py19=y47[3];
if (pat[9][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x47,y47,6 );
    g.setColor(Color.black);
    g.drawPolygon(x47,y47,6);
}else{g.fillPolygon( x47,y47,6 );}

// Hexagono 48
int x48[] ={lx14,lx13,lx12,(int)(lx12+0.86*(z+z0+z1+z2+z3)),(int)(lx12+0.86*(z+z0+z1+z2+z3)),px19};
int y48[]={ly14,ly13,ly12,(int)(ly12+0.5*(z+z0+z1+z2+z3)),(int)(ly12+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py19};

//Cambios
int px18=x48[4],px17=x48[3];
int py18=y48[4],py17=y48[3];
if (pat[9][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x48,y48,6 );
    g.setColor(Color.black);
    g.drawPolygon(x48,y48,6);
}else{g.fillPolygon( x48,y48,6 );}

// Hexagono 49
int x49[] ={lx12,lx11,lx10,(int)(lx10+0.86*(z+z0+z1+z2+z3)),(int)(lx10+0.86*(z+z0+z1+z2+z3)),px17};
int y49[]={ly12,ly11,ly10,(int)(ly10+0.5*(z+z0+z1+z2+z3)),(int)(ly10+0.5*(z+z0+z1+z2+z3)+(z+z0+z1+z2+z3)),py17};

//Cambios
int px16=x49[4],px15=x49[3];
int py16=y49[4],py15=y49[3];
if (pat[9][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x49,y49,6 );
    g.setColor(Color.black);
    g.drawPolygon(x49,y49,6);
}else{g.fillPolygon( x49,y49,6 );}

// Hexagono 50
int x50[] ={lx10,lx9,(int)(lx9+0.86*(z+z0+z1+z2+z3)),(int)(lx9+2*0.86*(z+z0+z1+z2+z3)),(int)(lx9+2*0.86*(z+z0+z1+z2+z3)),px15};
int y50[]={ly10,ly9,(int)(ly9-0.5*(z+z0+z1+z2+z3)),ly9,ly9+(int)(z+z0+z1+z2+z3),py15};

//Cambios
int px14=x50[4],px13=x50[3],px12=x50[2];
int py14=y50[4],py13=y50[3],py12=y50[2];
if (pat[10][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x50,y50,6 );
    g.setColor(Color.black);
    g.drawPolygon(x50,y50,6);
}else{g.fillPolygon( x50,y50,6 );}

// Hexagono 51
int x51[] ={lx8,lx7,(int)(lx7+0.86*(z+z0+z1+z2+z3)),(int)(lx7+2*0.86*(z+z0+z1+z2+z3)),px12,lx9};
int y51[]={ly8,ly7,(int)(ly7-0.5*(z+z0+z1+z2+z3)),ly7,py12,ly9};

//Cambios
int px11=x51[3],px10=x51[2];
int py11=y51[3],py10=y51[2];
if (pat[10][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x51,y51,6 );
    g.setColor(Color.black);
    g.drawPolygon(x51,y51,6);
}else{g.fillPolygon( x51,y51,6 );}

// Hexagono 52
int x52[] ={lx6,lx5,(int)(lx5+0.86*(z+z0+z1+z2+z3)),(int)(lx5+2*0.86*(z+z0+z1+z2+z3)),px10,lx7};
int y52[]={ly6,ly5,(int)(ly5-0.5*(z+z0+z1+z2+z3)),ly5,py10,ly7};

//Cambios
int px9=x52[3],px8=x52[2];
int py9=y52[3],py8=y52[2];
if (pat[10][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x52,y52,6 );
    g.setColor(Color.black);
    g.drawPolygon(x52,y52,6);
}else{g.fillPolygon( x52,y52,6 );}

// Hexagono 53
int x53[] ={lx4,lx3,(int)(lx3+0.86*(z+z0+z1+z2+z3)),(int)(lx3+2*0.86*(z+z0+z1+z2+z3)),px8,lx5};
int y53[]={ly4,ly3,(int)(ly3-0.5*(z+z0+z1+z2+z3)),ly3,py8,ly5};

//Cambios
int px7=x53[3],px6=x53[2];
int py7=y53[3],py6=y53[2];
if (pat[10][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x53,y53,6 );
    g.setColor(Color.black);
    g.drawPolygon(x53,y53,6);
}else{g.fillPolygon( x53,y53,6 );}

// Hexagono 54
int x54[] ={lx2,lx2,(int)(lx2+0.86*(z+z0+z1+z2+z3)),(int)(lx2+2*0.86*(z+z0+z1+z2+z3)),px6,lx3};
int y54[]={ly2,ly2-(int)(z+z0+z1+z2+z3),(int)(ly2-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),ly2-(int)(z+z0+z1+z2+z3),py6,ly3};

//Cambios
int px5=x54[3],px4=x54[2],px3=x54[1];
int py5=y54[3],py4=y54[2],py3=y54[1];
if (pat[10][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x54,y54,6 );
    g.setColor(Color.black);
    g.drawPolygon(x54,y54,6);
}else{g.fillPolygon( x54,y54,6 );}

// Hexagono 55
int x55[] ={lx0,lx0,(int)(lx0+0.86*(z+z0+z1+z2+z3)),px3,lx2,lx1};
int y55[]={ly0,ly0-(int)(z+z0+z1+z2+z3),(int)(ly0-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py3,ly2,ly1};

//Cambios
int px2=x55[2],px1=x55[1];
int py2=y55[2],py1=y55[1];
if (pat[11][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x55,y55,6 );
    g.setColor(Color.black);
    g.drawPolygon(x55,y55,6);
}else{g.fillPolygon( x55,y55,6 );}

// Hexagono 56
int x56[] ={lx40,lx40,(int)(lx40+0.86*(z+z0+z1+z2+z3)),px1,lx0,lx41};
int y56[]={ly40,ly40-(int)(z+z0+z1+z2+z3),(int)(ly40-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py1,ly0,ly41};

//Cambios
int px53=x56[1],px0=x56[2];
int py53=y56[1],py0=y56[2];
if (pat[11][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x56,y56,6 );
    g.setColor(Color.black);
    g.drawPolygon(x56,y56,6);
}else{g.fillPolygon( x56,y56,6 );}

// Hexagono 57
int x57[] ={lx38,lx38,(int)(lx38+0.86*(z+z0+z1+z2+z3)),px53,lx40,lx39};
int y57[]={ly38,ly38-(int)(z+z0+z1+z2+z3),(int)(ly38-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py53,ly40,ly39};

//Cambios
int px51=x57[1],px52=x57[2];
int py51=y57[1],py52=y57[2];
if (pat[11][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x57,y57,6 );
    g.setColor(Color.black);
    g.drawPolygon(x57,y57,6);
}else{g.fillPolygon( x57,y57,6 );}

// Hexagono 58
int x58[] ={(int)(lx37-0.86*(z+z0+z1+z2+z3)),(int)(lx37-0.86*(z+z0+z1+z2+z3)),lx37,px51,lx38,lx37};
int y58[]={(int)(ly37-0.5*(z+z0+z1+z2+z3)),(int)(ly37-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),ly37-2*(int)(z+z0+z1+z2+z3),py51,ly38,ly37};

//Cambios
int px48=x58[0],px49=x58[1],px50=x58[2];
int py48=y58[0],py49=y58[1],py50=y58[2];
if (pat[11][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x58,y58,6 );
    g.setColor(Color.black);
    g.drawPolygon(x58,y58,6);
}else{g.fillPolygon( x58,y58,6 );}

// Hexagono 59
int x59[] ={(int)(lx35-0.86*(z+z0+z1+z2+z3)),(int)(lx35-0.86*(z+z0+z1+z2+z3)),px48,lx37,lx36,lx35};
int y59[]={(int)(ly35-0.5*(z+z0+z1+z2+z3)),(int)(ly35-0.5*(z+z0+z1+z2+z3)-(z+z0+z1+z2+z3)),py48,ly37,ly36,ly35};

//Cambios
int px46=x59[0],px47=x59[1];
int py46=y59[0],py47=y59[1];
if (pat[11][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x59,y59,6 );
    g.setColor(Color.black);
    g.drawPolygon(x59,y59,6);
}else{g.fillPolygon( x59,y59,6 );}

// Hexagono 60
int x60[] ={px44,px44,px46,lx35,lx34,lx33};
int y60[]={py44,py44-(int)(z+z0+z1+z2+z3),py46,ly35,ly34,ly33};

//Cambios
int px45=x60[1];
int py45=y60[1];
if (pat[12][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x60,y60,6 );
    g.setColor(Color.black);
    g.drawPolygon(x60,y60,6);
}else{g.fillPolygon( x60,y60,6 );}

//------------- Final del Anillo ?(m) ------------------------------------------

// Hexagono 61
int x61[] ={px42-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px42-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px42-(int)(0.86*(z+z0+z1+z2+z3+z4)),px43,px42,px41};
int y61[]={py42,py42-(int)(z+z0+z1+z2+z3+z4),py42-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py43,py42,py41};

//Cambios
int rx52=x61[0],rx53=x61[1],rx54=x61[2];
int ry52=y61[0],ry53=y61[1],ry54=y61[2];
if (pat[12][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x61,y61,6 );
    g.setColor(Color.black);
    g.drawPolygon(x61,y61,6);
}else{g.fillPolygon( x61,y61,6 );}

// Hexagono 62
int x62[] ={px40-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px40-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx52,px41,px40,px40-(int)(0.86*(z+z0+z1+z2+z3+z4))};
int y62[]={py40,py40-(int)(z+z0+z1+z2+z3+z4),ry52,py41,py40,py40+(int)(0.5*(z+z0+z1+z2+z3+z4))};

//Cambios
int rx50=x62[0],rx51=x62[1],rx49=x62[5];
int ry50=y62[0],ry51=y62[1],ry49=y62[5];
if (pat[12][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x62,y62,6 );
    g.setColor(Color.black);
    g.drawPolygon(x62,y62,6);
}else{g.fillPolygon( x62,y62,6 );}

// Hexagono 63
int x63[] ={px38-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx49,px40,px39,px38,px38-(int)(0.86*(z+z0+z1+z2+z3+z4))};
int y63[]={py38,ry49,py40,py39,py38,py38+(int)(0.5*(z+z0+z1+z2+z3+z4))};

//Cambios
int rx48=x63[0],rx47=x63[5];
int ry48=y63[0],ry47=y63[5];
if (pat[12][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x63,y63,6 );
    g.setColor(Color.black);
    g.drawPolygon(x63,y63,6);
}else{g.fillPolygon( x63,y63,6 );}

// Hexagono 64
int x64[] ={px36-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx47,px38,px37,px36,px36-(int)(0.86*(z+z0+z1+z2+z3+z4))};
int y64[]={py36,ry47,py38,py37,py36,py36+(int)(0.5*(z+z0+z1+z2+z3+z4))};

//Cambios
int rx46=x64[0],rx45=x64[5];
int ry46=y64[0],ry45=y64[5];
if (pat[12][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x64,y64,6 );
    g.setColor(Color.black);
    g.drawPolygon(x64,y64,6);
}else{g.fillPolygon( x64,y64,6 );}


// Hexagono 65
int x65[] ={px34-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx45,px36,px35,px34,px34-(int)(0.86*(z+z0+z1+z2+z3+z4))};
int y65[]={py34,ry45,py36,py35,py34,py34+(int)(0.5*(z+z0+z1+z2+z3+z4))};

//Cambios
int rx44=x65[0],rx43=x65[5];
int ry44=y65[0],ry43=y65[5];
if (pat[13][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x65,y65,6 );
    g.setColor(Color.black);
    g.drawPolygon(x65,y65,6);
}else{g.fillPolygon( x65,y65,6 );}

// Hexagono 66
int x66[] ={px32-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx43,px34,px33,px32,px32-(int)(0.86*(z+z0+z1+z2+z3+z4))};
int y66[]={py32,ry43,py34,py33,py32,py32+(int)(0.5*(z+z0+z1+z2+z3+z4))};

//Cambios
int rx42=x66[0],rx41=x66[5];
int ry42=y66[0],ry41=y66[5];
if (pat[13][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x66,y66,6 );
    g.setColor(Color.black);
    g.drawPolygon(x66,y66,6);
}else{g.fillPolygon( x66,y66,6 );}

// Hexagono 67
int x67[] ={px32-(int)(0.86*(z+z0+z1+z2+z3+z4)),px32-(int)(0.86*(z+z0+z1+z2+z3+z4)),px32,px31,px31,px32};
int y67[]={py32+(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py32+(int)(0.5*(z+z0+z1+z2+z3+z4)),py32,py31,py31+(int)(z+z0+z1+z2+z3+z4),py32+2*(int)(z+z0+z1+z2+z3+z4)};

//Cambios
int rx40=x67[0],rx39=x67[5],rx38=x67[4];
int ry40=y67[0],ry39=y67[5],ry38=y67[4];
if (pat[13][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x67,y67,6 );
    g.setColor(Color.black);
    g.drawPolygon(x67,y67,6);
}else{g.fillPolygon( x67,y67,6 );}

// Hexagono 68
int x68[] ={rx38,px31,px30,px29,px29,px30};
int y68[]={ry38,py31,py30,py29,py29+(int)(z+z0+z1+z2+z3+z4),py30+2*(int)(z+z0+z1+z2+z3+z4)};

//Cambios
int rx36=x68[4],rx37=x68[5];
int ry36=y68[4],ry37=y68[5];
if (pat[13][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x68,y68,6 );
    g.setColor(Color.black);
    g.drawPolygon(x68,y68,6);
}else{g.fillPolygon( x68,y68,6 );}

// Hexagono 69
int x69[] ={rx36,px29,px28,px27,px27,px28};
int y69[]={ry36,py29,py28,py27,py27+(int)(z+z0+z1+z2+z3+z4),py28+2*(int)(z+z0+z1+z2+z3+z4)};

//Cambios
int rx34=x69[4],rx35=x69[5];
int ry34=y69[4],ry35=y69[5];
if (pat[13][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x69,y69,6 );
    g.setColor(Color.black);
    g.drawPolygon(x69,y69,6);
}else{g.fillPolygon( x69,y69,6 );}

// Hexagono 70
int x70[] ={rx34,px27,px26,px25,px25,px26};
int y70[]={ry34,py27,py26,py25,py25+(int)(z+z0+z1+z2+z3+z4),py26+2*(int)(z+z0+z1+z2+z3+z4)};

//Cambios
int rx32=x70[4],rx33=x70[5];
int ry32=y70[4],ry33=y70[5];
if (pat[14][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x70,y70,6 );
    g.setColor(Color.black);
    g.drawPolygon(x70,y70,6);
}else{g.fillPolygon( x70,y70,6 );}

// Hexagono 71
int x71[] ={rx32,px25,px24,px23,px23,px24};
int y71[]={ry32,py25,py24,py23,py23+(int)(z+z0+z1+z2+z3+z4),py24+2*(int)(z+z0+z1+z2+z3+z4)};

//Cambios
int rx30=x71[4],rx31=x71[5];
int ry30=y71[4],ry31=y71[5];
if (pat[14][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x71,y71,6 );
    g.setColor(Color.black);
    g.drawPolygon(x71,y71,6);
}else{g.fillPolygon( x71,y71,6 );}


// Hexagono 72
int x72[] ={rx30,px23,px22,px22+(int)(0.86*(z+z0+z1+z2+z3+z4)),px22+(int)(0.86*(z+z0+z1+z2+z3+z4)),px22};
int y72[]={ry30,py23,py22,py22+(int)(0.5*(z+z0+z1+z2+z3+z4)),py22+(int)((z+z0+z1+z2+z3+z4)+0.5*(z+z0+z1+z2+z3+z4)),py22+2*(int)(z+z0+z1+z2+z3+z4)};

//Cambios
int rx28=x72[4],rx29=x72[5],rx27=x72[3];
int ry28=y72[4],ry29=y72[5],ry27=y72[3];
if (pat[14][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x72,y72,6 );
    g.setColor(Color.black);
    g.drawPolygon(x72,y72,6);
}else{g.fillPolygon( x72,y72,6 );}

// Hexagono 73
int x73[] ={px22,px21,px20,px20+(int)(0.86*(z+z0+z1+z2+z3+z4)),px20+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx27};
int y73[]={py22,py21,py20,py20+(int)(0.5*(z+z0+z1+z2+z3+z4)),py20+(int)((z+z0+z1+z2+z3+z4)+0.5*(z+z0+z1+z2+z3+z4)),ry27};

//Cambios
int rx25=x73[3],rx26=x73[4];
int ry25=y73[3],ry26=y73[4];
if (pat[14][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x73,y73,6 );
    g.setColor(Color.black);
    g.drawPolygon(x73,y73,6);
}else{g.fillPolygon( x73,y73,6 );}

// Hexagono 74
int x74[] ={px20,px19,px18,px20+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px20+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx25};
int y74[]={py20,py19,py18,py20-(int)((z+z0+z1+z2+z3+z4)),py20,ry25};

//Cambios
int rx23=x74[3],rx24=x74[4];
int ry23=y74[3],ry24=y74[4];
if (pat[14][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x74,y74,6 );
    g.setColor(Color.black);
    g.drawPolygon(x74,y74,6);
}else{g.fillPolygon( x74,y74,6 );}

// Hexagono 75
int x75[] ={px18,px17,px16,px18+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px18+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx23};
int y75[]={py18,py17,py16,py18-(int)((z+z0+z1+z2+z3+z4)),py18,ry23};

//Cambios
int rx21=x75[3],rx22=x75[4];
int ry21=y75[3],ry22=y75[4];
if (pat[15][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x75,y75,6 );
    g.setColor(Color.black);
    g.drawPolygon(x75,y75,6);
}else{g.fillPolygon( x75,y75,6 );}

// Hexagono 76
int x76[] ={px16,px15,px14,px16+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px16+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx21};
int y76[]={py16,py15,py14,py16-(int)((z+z0+z1+z2+z3+z4)),py16,ry21};

//Cambios
int rx19=x76[3],rx20=x76[4];
int ry19=y76[3],ry20=y76[4];
if (pat[15][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x76,y76,6 );
    g.setColor(Color.black);
    g.drawPolygon(x76,y76,6);
}else{g.fillPolygon( x76,y76,6 );}

// Hexagono 77
int x77[] ={px14,px13,px14+(int)(0.86*(z+z0+z1+z2+z3+z4)),px14+(int)(2*0.86*(z+z0+z1+z2+z3)),px14+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx19};
int y77[]={py14,py13,py14-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py14-(int)(z+z0+z1+z2+z3+z4),py14,ry19};

//Cambios
int rx17=x77[3],rx18=x77[4],rx16=x77[2];
int ry17=y77[3],ry18=y77[4],ry16=y77[2];
if (pat[15][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x77,y77,6 );
    g.setColor(Color.black);
    g.drawPolygon(x77,y77,6);
}else{g.fillPolygon( x77,y77,6 );}

// Hexagono 78
int x78[] ={px12,px11,px12+(int)(0.86*(z+z0+z1+z2+z3+z4)),px12+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx16,px13};
int y78[]={py12,py11,py12-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py12-(int)(z+z0+z1+z2+z3+z4),ry16,py13};

//Cambios
int rx14=x78[2],rx15=x78[3];
int ry14=y78[2],ry15=y78[3];
if (pat[15][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x78,y78,6 );
    g.setColor(Color.black);
    g.drawPolygon(x78,y78,6);
}else{g.fillPolygon( x78,y78,6 );}

// Hexagono 79
int x79[] ={px10,px9,px10+(int)(0.86*(z+z0+z1+z2+z3+z4)),px10+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx14,px11};
int y79[]={py10,py9,py10-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py10-(int)(z+z0+z1+z2+z3+z4),ry14,py11};

//Cambios
int rx12=x79[2],rx13=x79[3];
int ry12=y79[2],ry13=y79[3];
if (pat[15][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x79,y79,6 );
    g.setColor(Color.black);
    g.drawPolygon(x79,y79,6);
}else{g.fillPolygon( x79,y79,6 );}

// Hexagono 80
int x80[] ={px8,px7,px8+(int)(0.86*(z+z0+z1+z2+z3+z4)),px8+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx12,px9};
int y80[]={py8,py7,py8-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py8-(int)(z+z0+z1+z2+z3+z4),ry12,py9};

//Cambios
int rx10=x80[2],rx11=x80[3];
int ry10=y80[2],ry11=y80[3];
if (pat[16][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x80,y80,6 );
    g.setColor(Color.black);
    g.drawPolygon(x80,y80,6);
}else{g.fillPolygon( x80,y80,6 );}

// Hexagono 81
int x81[] ={px6,px5,px6+(int)(0.86*(z+z0+z1+z2+z3+z4)),px6+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx10,px7};
int y81[]={py6,py5,py6-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py6-(int)(z+z0+z1+z2+z3+z4),ry10,py7};

//Cambios
int rx8=x81[2],rx9=x81[3];
int ry8=y81[2],ry9=y81[3];
if (pat[16][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x81,y81,6 );
    g.setColor(Color.black);
    g.drawPolygon(x81,y81,6);
}else{g.fillPolygon( x81,y81,6 );}

// Hexagono 82
int x82[] ={px4,px4,px4+(int)(0.86*(z+z0+z1+z2+z3+z4)),px4+(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx8,px5};
int y82[]={py4,py4-(int)(z+z0+z1+z2+z3+z4),py4-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),py4-(int)(z+z0+z1+z2+z3+z4),ry8,py5};

//Cambios
int rx5=x82[1],rx6=x82[2],rx7=x82[3];
int ry5=y82[1],ry6=y82[2],ry7=y82[3];
if (pat[16][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x82,y82,6 );
    g.setColor(Color.black);
    g.drawPolygon(x82,y82,6);
}else{g.fillPolygon( x82,y82,6 );}

// Hexagono 83
int x83[] ={px2,px2,px2+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx5,px4,px3};
int y83[]={py2,py2-(int)(z+z0+z1+z2+z3+z4),py2-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry5,py4,py3};

//Cambios
int rx3=x83[1],rx4=x83[2];
int ry3=y83[1],ry4=y83[2];
if (pat[16][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x83,y83,6 );
    g.setColor(Color.black);
    g.drawPolygon(x83,y83,6);
}else{g.fillPolygon( x83,y83,6 );}

// Hexagono 84
int x84[] ={px0,px0,px0+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx3,px2,px1};
int y84[]={py0,py0-(int)(z+z0+z1+z2+z3+z4),py0-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry3,py2,py1};

//Cambios
int rx1=x84[1],rx2=x84[2];
int ry1=y84[1],ry2=y84[2];
if (pat[16][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x84,y84,6 );
    g.setColor(Color.black);
    g.drawPolygon(x84,y84,6);
}else{g.fillPolygon( x84,y84,6 );}

// Hexagono 85
int x85[] ={px52,px52,px52+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx1,px0,px53};
int y85[]={py52,py52-(int)(z+z0+z1+z2+z3+z4),py52-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry1,py0,py53};

//Cambios
int rx65=x85[1],rx0=x85[2];
int ry65=y85[1],ry0=y85[2];
if (pat[17][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x85,y85,6 );
    g.setColor(Color.black);
    g.drawPolygon(x85,y85,6);
}else{g.fillPolygon( x85,y85,6 );}

// Hexagono 86
int x86[] ={px50,px50,px50+(int)(0.86*(z+z0+z1+z2+z3+z4)),rx65,px52,px51};
int y86[]={py50,py50-(int)(z+z0+z1+z2+z3+z4),py50-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry65,py52,py51};

//Cambios
int rx63=x86[1],rx64=x86[2];
int ry63=y86[1],ry64=y86[2];
if (pat[17][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x86,y86,6 );
    g.setColor(Color.black);
    g.drawPolygon(x86,y86,6);
}else{g.fillPolygon( x86,y86,6 );}

// Hexagono 87
int x87[] ={px50-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px50-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px50-(int)(0.86*(z+z0+z1+z2+z3+z4)),rx63,px50,px49};
int y87[]={py50,py50-(int)(z+z0+z1+z2+z3+z4),py50-(int)(0.5*(z+z0+z1+z2+z3+z4)+(z+z0+z1+z2+z3+z4)),ry63,py50,py49};

//Cambios
int rx60=x87[0],rx61=x87[1],rx62=x87[2];
int ry60=y87[0],ry61=y87[1],ry62=y87[2];
if (pat[17][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x87,y87,6 );
    g.setColor(Color.black);
    g.drawPolygon(x87,y87,6);
}else{g.fillPolygon( x87,y87,6 );}

// Hexagono 88
int x88[] ={px48-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px48-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx60,px49,px48,px47};
int y88[]={py48,py48-(int)(z+z0+z1+z2+z3+z4),ry60,py49,py48,py47};

//Cambios
int rx58=x88[0],rx59=x88[1];
int ry58=y88[0],ry59=y88[1];
if (pat[17][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x88,y88,6 );
    g.setColor(Color.black);
    g.drawPolygon(x88,y88,6);
}else{g.fillPolygon( x88,y88,6 );}

// Hexagono 89
int x89[] ={px46-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),px46-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx58,px47,px46,px45};
int y89[]={py46,py46-(int)(z+z0+z1+z2+z3+z4),ry58,py47,py46,py45};

//Cambios
int rx56=x89[0],rx57=x89[1];
int ry56=y89[0],ry57=y89[1];
if (pat[17][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x89,y89,6 );
    g.setColor(Color.black);
    g.drawPolygon(x89,y89,6);
}else{g.fillPolygon( x89,y89,6 );}

// Hexagono 90
int x90[] ={rx54,px44-(int)(2*0.86*(z+z0+z1+z2+z3+z4)),rx56,px45,px44,px43};
int y90[]={ry54,py44-(int)(z+z0+z1+z2+z3+z4),ry56,py45,py44,py43};

//Cambios
int rx55=x90[1];
int ry55=y90[1];
if (pat[18][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x90,y90,6 );
    g.setColor(Color.black);
    g.drawPolygon(x90,y90,6);
}else{g.fillPolygon( x90,y90,6 );}

// ------------------- Fin del Anillo ?(m) -------------------------------------

// Hexagono 91
int x91[] ={rx54-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx54-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx54-(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx55,rx54,rx53};
int y91[]={ry54,ry54-(int)(z+z0+z1+z2+z3+z4+z5),ry54-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry55,ry54,ry53};

//Cambios
int sx0=x91[0],sx1=x91[1],sx2=x91[2];
int sy0=y91[0],sy1=y91[1],sy2=y91[2];
if (pat[18][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x91,y91,6 );
    g.setColor(Color.black);
    g.drawPolygon(x91,y91,6);
}else{g.fillPolygon( x91,y91,6 );}

// Hexagono 92
int x92[] ={sx2,rx56-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx56-(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx57,rx56,rx55};
int y92[]={sy2,ry56-(int)(z+z0+z1+z2+z3+z4+z5),ry56-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry57,ry56,ry55};

//Cambios
int sx3=x92[1],sx4=x92[2];
int sy3=y92[1],sy4=y92[2];
if (pat[18][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x92,y92,6 );
    g.setColor(Color.black);
    g.drawPolygon(x92,y92,6);
}else{g.fillPolygon( x92,y92,6 );}

// Hexagono 93
int x93[] ={sx4,rx58-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx58-(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx59,rx58,rx57};
int y93[]={sy4,ry58-(int)(z+z0+z1+z2+z3+z4+z5),ry58-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry59,ry58,ry57};

//Cambios
int sx5=x93[1],sx6=x93[2];
int sy5=y93[1],sy6=y93[2];
if (pat[18][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x93,y93,6 );
    g.setColor(Color.black);
    g.drawPolygon(x93,y93,6);
}else{g.fillPolygon( x93,y93,6 );}

// Hexagono 94
int x94[] ={rx46-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx46-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx48,rx47,rx46,rx46-(int)(0.86*(z+z0+z1+z2+z3+z4+z5))};
int y94[]={ry46,ry46-(int)(z+z0+z1+z2+z3+z4+z5),ry48,ry47,ry46,ry46+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};

//Cambios
int sx7=x94[0],sx8=x94[1],sx9=x94[5];
int sy7=y94[0],sy8=y94[1],sy9=y94[5];
if (pat[18][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x94,y94,6 );
    g.setColor(Color.black);
    g.drawPolygon(x94,y94,6);
}else{g.fillPolygon( x94,y94,6 );}

// Hexagono 95
int x95[] ={rx44-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx9,rx46,rx45,rx44,rx44-(int)(0.86*(z+z0+z1+z2+z3))};
int y95[]={ry44,sy9,ry46,ry45,ry44,ry44+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};

//Cambios
int sx10=x95[0],sx11=x95[5];
int sy10=y95[0],sy11=y95[5];
if (pat[19][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x95,y95,6 );
    g.setColor(Color.black);
    g.drawPolygon(x95,y95,6);
}else{g.fillPolygon( x95,y95,6 );}

// Hexagono 96
int x96[] ={rx42-(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx11,rx44,rx43,rx42,rx42-(int)(0.86*(z+z0+z1+z2+z3+z4+z5))};
int y96[]={ry42,sy11,ry44,ry43,ry42,ry42+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};

//Cambios
int sx12=x96[0],sx13=x96[5];
int sy12=y96[0],sy13=y96[5];
if (pat[19][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x96,y96,6 );
    g.setColor(Color.black);
    g.drawPolygon(x96,y96,6);
}else{g.fillPolygon( x96,y96,6 );}

// Hexagono 97
int x97[] ={rx26,rx25,rx24,rx26+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx26+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx26+(int)(0.86*(z+z0+z1+z2+z3+z4+z5))};
int y97[]={ry26,ry25,ry24,ry26-(int)(z+z0+z1+z2+z3+z4+z5),ry26,ry26+(int)(0.5*(z+z0+z1+z2+z3+z4+z5))};

//Cambios
int sx25=x97[3],sx26=x97[4],sx27=x97[5];
int sy25=y97[3],sy26=y97[4],sy27=y97[5];
if (pat[19][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x97,y97,6 );
    g.setColor(Color.black);
    g.drawPolygon(x97,y97,6);
}else{g.fillPolygon( x97,y97,6 );}

// Hexagono 98
int x98[] ={rx24,rx23,rx22,rx24+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx24+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx25};
int y98[]={ry24,ry23,ry22,ry24-(int)(z+z0+z1+z2+z3+z4+z5),ry24,sy25};

//Cambios
int sx23=x98[3],sx24=x98[4];
int sy23=y98[3],sy24=y98[4];
if (pat[19][3]==0){
    g.setColor( Color.white );
    g.fillPolygon( x98,y98,6 );
    g.setColor(Color.black);
    g.drawPolygon(x98,y98,6);
}else{g.fillPolygon( x98,y98,6 );}

// Hexagono 99
int x99[] ={rx22,rx21,rx20,rx22+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx22+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx23};
int y99[]={ry22,ry21,ry20,ry22-(int)(z+z0+z1+z2+z3+z4+z5),ry22,sy23};

//Cambios
int sx21=x99[3],sx22=x99[4];
int sy21=y99[3],sy22=y99[4];
if (pat[19][4]==0){
    g.setColor( Color.white );
    g.fillPolygon( x99,y99,6 );
    g.setColor(Color.black);
    g.drawPolygon(x99,y99,6);
}else{g.fillPolygon( x99,y99,6 );}

// Hexagono 100
int x100[] ={rx14,rx13,rx14+(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx14+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx14+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),rx15};
int y100[]={ry14,ry13,ry14-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry14-(int)((z+z0+z1+z2+z3+z4+z5)),ry14,ry15};

//Cambios
int sx18=x100[2],sx19=x100[3],sx20=x100[4];
int sy18=y100[2],sy19=y100[3],sy20=y100[4];
if (pat[20][0]==0){
    g.setColor( Color.white );
    g.fillPolygon( x100,y100,6 );
    g.setColor(Color.black);
    g.drawPolygon(x100,y100,6);
}else{g.fillPolygon( x100,y100,6 );}

// Hexagono 101
int x101[] ={rx12,rx11,rx12+(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx12+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx18,rx13};
int y101[]={ry12,ry11,ry12-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry12-(int)((z+z0+z1+z2+z3+z4+z5)),sy18,ry13};

//Cambios
int sx16=x101[2],sx17=x101[3];
int sy16=y101[2],sy17=y101[3];
if (pat[20][1]==0){
    g.setColor( Color.white );
    g.fillPolygon( x101,y101,6 );
    g.setColor(Color.black);
    g.drawPolygon(x101,y101,6);
}else{g.fillPolygon( x101,y101,6 );}

// Hexagono 102
int x102[] ={rx10,rx9,rx10+(int)(0.86*(z+z0+z1+z2+z3+z4+z5)),rx10+(int)(2*0.86*(z+z0+z1+z2+z3+z4+z5)),sx16,rx11};
int y102[]={ry10,ry9,ry10-(int)(0.5*(z+z0+z1+z2+z3+z4+z5)+(z+z0+z1+z2+z3+z4+z5)),ry10-(int)((z+z0+z1+z2+z3+z4+z5)),sy16,ry11};

//Cambios
int sx14=x102[2],sx15=x102[3];
int sy14=y102[2],sy15=y102[3];
if (pat[20][2]==0){
    g.setColor( Color.white );
    g.fillPolygon( x102,y102,6 );
    g.setColor(Color.black);
    g.drawPolygon(x102,y102,6);
}else{g.fillPolygon( x102,y102,6 );}
Cruz(g);
bufferStrategy.show();

 if(uni_tiempo=="S"){
    try{
        Thread.sleep((int)(base_tiempo*0.25*1000));  // Se usa el 7.40 % del pb
    }catch(InterruptedException e ){}
}else if(uni_tiempo=="mS"){
    try{
        Thread.sleep((int)(base_tiempo*0.25));
    }catch(InterruptedException e ){}
}

g = bufferStrategy.getDrawGraphics();
g.setColor( Color.CYAN );
g.fillRect( 0, 0, ScreenWidth, ScreenHeight );
g.translate(this.getInsets().right,this.getInsets().top );
g.setColor(Color.BLACK);
g.fillPolygon(x0,y0,6);
g.fillPolygon(x1,y1,6);
g.fillPolygon(x2,y2,6);
g.fillPolygon(x3,y3,6);
g.fillPolygon(x4,y4,6);
g.fillPolygon(x5,y5,6);
g.fillPolygon(x6,y6,6);
g.fillPolygon(x7,y7,6);
g.fillPolygon(x8,y8,6);
g.fillPolygon(x9,y9,6);
g.fillPolygon(x10,y10,6);
g.fillPolygon(x11,y11,6);
g.fillPolygon(x12,y12,6);
g.fillPolygon(x13,y13,6);
g.fillPolygon(x14,y14,6);
g.fillPolygon(x15,y15,6);
g.fillPolygon(x16,y16,6);
g.fillPolygon(x17,y17,6);
g.fillPolygon(x18,y18,6);
g.fillPolygon(x19,y19,6);
g.fillPolygon(x20,y20,6);
g.fillPolygon(x21,y21,6);
g.fillPolygon(x22,y22,6);
g.fillPolygon(x23,y23,6);
g.fillPolygon(x24,y24,6);
g.fillPolygon(x25,y25,6);
g.fillPolygon(x26,y26,6);
g.fillPolygon(x27,y27,6);
g.fillPolygon(x28,y28,6);
g.fillPolygon(x29,y29,6);
g.fillPolygon(x30,y30,6);
g.fillPolygon(x31,y31,6);
g.fillPolygon(x32,y32,6);
g.fillPolygon(x33,y33,6);
g.fillPolygon(x34,y34,6);
g.fillPolygon(x35,y35,6);
g.fillPolygon(x36,y36,6);
g.fillPolygon(x37,y37,6);
g.fillPolygon(x38,y38,6);
g.fillPolygon(x39,y39,6);
g.fillPolygon(x40,y40,6);
g.fillPolygon(x41,y41,6);
g.fillPolygon(x42,y42,6);
g.fillPolygon(x43,y43,6);
g.fillPolygon(x44,y44,6);
g.fillPolygon(x45,y45,6);
g.fillPolygon(x46,y46,6);
g.fillPolygon(x47,y47,6);
g.fillPolygon(x48,y48,6);
g.fillPolygon(x49,y49,6);
g.fillPolygon(x50,y50,6);
g.fillPolygon(x51,y51,6);
g.fillPolygon(x52,y52,6);
g.fillPolygon(x53,y53,6);
g.fillPolygon(x54,y54,6);
g.fillPolygon(x55,y55,6);
g.fillPolygon(x56,y56,6);
g.fillPolygon(x57,y57,6);
g.fillPolygon(x58,y58,6);
g.fillPolygon(x59,y59,6);
g.fillPolygon(x60,y60,6);
g.fillPolygon(x61,y61,6);
g.fillPolygon(x62,y62,6);
g.fillPolygon(x63,y63,6);
g.fillPolygon(x64,y64,6);
g.fillPolygon(x65,y65,6);
g.fillPolygon(x66,y66,6);
g.fillPolygon(x67,y67,6);
g.fillPolygon(x68,y68,6);
g.fillPolygon(x69,y69,6);
g.fillPolygon(x70,y70,6);
g.fillPolygon(x71,y71,6);
g.fillPolygon(x72,y72,6);
g.fillPolygon(x73,y73,6);
g.fillPolygon(x74,y74,6);
g.fillPolygon(x75,y75,6);
g.fillPolygon(x76,y76,6);
g.fillPolygon(x77,y77,6);
g.fillPolygon(x78,y78,6);
g.fillPolygon(x79,y79,6);
g.fillPolygon(x80,y80,6);
g.fillPolygon(x81,y81,6);
g.fillPolygon(x82,y82,6);
g.fillPolygon(x83,y83,6);
g.fillPolygon(x84,y84,6);
g.fillPolygon(x85,y85,6);
g.fillPolygon(x86,y86,6);
g.fillPolygon(x87,y87,6);
g.fillPolygon(x88,y88,6);
g.fillPolygon(x89,y89,6);
g.fillPolygon(x90,y90,6);
g.fillPolygon(x91,y91,6);
g.fillPolygon(x92,y92,6);
g.fillPolygon(x93,y93,6);
g.fillPolygon(x94,y94,6);
g.fillPolygon(x95,y95,6);
g.fillPolygon(x96,y96,6);
g.fillPolygon(x97,y97,6);
g.fillPolygon(x98,y98,6);
g.fillPolygon(x99,y99,6);
g.fillPolygon(x100,y100,6);
g.fillPolygon(x101,y101,6);
g.fillPolygon(x102,y102,6);
Cruz(g);
        }
        bufferStrategy.show();
        if(k==0 || k==M+1){
                try {Thread.sleep(Integer.parseInt(tiemm.getText())*1000);
                } catch (InterruptedException ex){}
          }
        g.dispose();
}  // Fin del IF
          if(uni_tiempo=="S"){
                try{
                    Thread.sleep((int)(base_tiempo*0.75*1000));
                }catch(InterruptedException e ){}
         }else if(uni_tiempo=="mS"){
                try{
                    Thread.sleep((int)(base_tiempo*0.75));
                }catch(InterruptedException e ){}
            }
            if(k>=1 && k<M+1)patrones = patrones + "\n";
            k++; 
        } // Fin del WHILE 
        play_time=false;
        fyhs = new Date();
        ms_final=fyhs.getTime();
        p_pros1.EnvioPat(patrones,M,Nm);
        patrones="";
        Kern1 = p_pros1.RetKernel_01();
        Kern2 = p_pros1.RetKernel_02();
        Kern3 = p_pros1.RetKernel_03();
        
        try{
            
            Thread.sleep(2000);
            prinFrame.setVisible(false);
            prinFrame.hide();
            fyh_ult = fyhs.toString();
            totaltime = ms_final-ms_ini;
            totalEsttime=totaltime-(totaltime-base_tiempo*M);
            
        if (fyh_ult.charAt(0)=='S' && fyh_ult.charAt(1) =='u' && fyh_ult.charAt(2)=='n'){
            dia = "Domingo";
        }else if(fyh_ult.charAt(0)=='M' && fyh_ult.charAt(1) =='o' && fyh_ult.charAt(2)=='n'){
            dia = "Lunes";
        }else if(fyh_ult.charAt(0)=='T' && fyh_ult.charAt(1) =='u' && fyh_ult.charAt(2)=='e'){
            dia = "Martes";
        }else if(fyh_ult.charAt(0)=='W' && fyh_ult.charAt(1) =='e' && fyh_ult.charAt(2)=='d'){
            dia = "Miercoles";
        }else if(fyh_ult.charAt(0)=='T' && fyh_ult.charAt(1) =='h' && fyh_ult.charAt(2)=='u'){
            dia = "Jueves";
        }else if(fyh_ult.charAt(0)=='F' && fyh_ult.charAt(1) =='r' && fyh_ult.charAt(2)=='i'){
            dia = "Viernes";
        }
        
      
        if(fyh_ult.charAt(4)=='J' && fyh_ult.charAt(5) =='a' && fyh_ult.charAt(6)=='n'){
            mes = "Enero";
        }else if(fyh_ult.charAt(4)=='F' && fyh_ult.charAt(5) =='e' && fyh_ult.charAt(6)=='b'){
            mes = "Febrero";
        }else if(fyh_ult.charAt(4)=='M' && fyh_ult.charAt(5) =='a' && fyh_ult.charAt(6)=='r'){
            mes="Marzo";
        }else if(fyh_ult.charAt(4)=='A' && fyh_ult.charAt(5) =='p' && fyh_ult.charAt(6)=='r'){
            mes= "Abril";
        }else if(fyh_ult.charAt(4)=='M' && fyh_ult.charAt(5) =='a' && fyh_ult.charAt(6)=='y'){
            mes= "Mayo";
        }else if(fyh_ult.charAt(4)=='J' && fyh_ult.charAt(5) =='u' && fyh_ult.charAt(6)=='n'){
            mes = "Junio";
        }else if(fyh_ult.charAt(4)=='J' && fyh_ult.charAt(5) =='u' && fyh_ult.charAt(6)=='l'){
            mes = "Julio";
        }else if(fyh_ult.charAt(4)=='A' && fyh_ult.charAt(5) =='u' && fyh_ult.charAt(6)=='g'){
            mes = "Agosto";
        }else if(fyh_ult.charAt(4)=='S' && fyh_ult.charAt(5) =='e' && fyh_ult.charAt(6)=='p'){
            mes = "Septiembre";
        }else if(fyh_ult.charAt(4)=='O' && fyh_ult.charAt(5) =='c' && fyh_ult.charAt(6)=='t'){
            mes = "Octubre";
        }else if(fyh_ult.charAt(4)=='N' && fyh_ult.charAt(5) =='o' && fyh_ult.charAt(6)=='v'){
            mes = "Noviembre";
        }else if(fyh_ult.charAt(4)=='D' && fyh_ult.charAt(5) =='i' && fyh_ult.charAt(6)=='c'){
            mes = "Diciembre";
        }
        
        dianum = fyh_ult.substring(8,10);
        año = fyh_ult.substring(24,fyh_ult.length());
        UltimoTest.setText("Ultimo Test: "+dia+", "+mes+" "+dianum+" de "+año+" , "+ fyh_ult.substring(11,18));
        
        // Impresion de la Derivación Kernel de Orden 1º 
        SerieB1.append("\n");
        SerieB1.append("----------------- Estimulo "+Nm+" -------------------\n\n");
        SerieB1.append("KERNEL 1º Orden");
        for(int j=0;j<103;j++){
            x1 = "\n\nHexagono "+j+"\n";
            for(int n=0;n<M;n++){
                x1=x1+Kern1[4*M*j+4*n]+","+Kern1[4*M*j+1+4*n]+","+Kern1[4*M*j+2+4*n]+","+Kern1[4*M*j+3+4*n]+"\n";
              }
            SerieB1.append(x1);
        }
        // Impresion de la Derivación Kernel de Orden 2º con 1er Slice
        SerieB2.append("\n");
        SerieB2.append("----------------- Estimulo "+Nm+" -------------------\n\n");
        SerieB2.append("KERNEL 2º Orden - 1er Slice");
        for(int j=0;j<103;j++){
            x2 = "\n\nHexagono "+j+"\n";
            for(int n=0;n<M;n++){
                x2=x2+Kern2[4*M*j+4*n]+","+Kern2[4*M*j+1+4*n]+","+Kern2[4*M*j+2+4*n]+","+Kern2[4*M*j+3+4*n]+"\n";
              }
            SerieB2.append(x2);
        }
        // Impresion de la Derivación Kernel de Orden 2º con 2do Slice
        SerieB3.append("\n");
        SerieB3.append("----------------- Estimulo "+Nm+" -------------------\n\n");
        SerieB3.append("KERNEL 2º Orden - 2do Slice");
        for(int j=0;j<103;j++){
            x3 = " \n\nHexagono "+j+ "\n";
            for(int n=0;n<M;n++){
                x3=x3+Kern3[4*M*j+4*n]+","+Kern3[4*M*j+1+4*n]+","+Kern3[4*M*j+2+4*n]+","+Kern3[4*M*j+3+4*n]+"\n";
              }
            SerieB3.append(x3);
         }
//         JOptionPane.showMessageDialog(null,"Puedes repetir este Estimulo de nuevo con el botón Inciar ","Información",1);
        } catch(InterruptedException e ) {Nm--;}
        }else JOptionPane.showMessageDialog(null,"Ninimo número de Patrones: 15 ","Error!",2); 
        } catch(java.lang.NumberFormatException r){Nm--;JOptionPane.showMessageDialog(null,"Formato de Parámetro Erroneo ","Error!",2);}
    }//GEN-LAST:event_IniciarActionPerformed

public Graphics Cruz(Graphics x){
    x.setColor(Color.BLUE);
    x.drawLine((int)(xi+z*0.86),(int)(yi+z*0.25),(int)(xi+z*0.86),(int)(yi+z*0.75));
    x.drawLine((int)(xi+z*0.86*0.75),(int)(yi+z*0.5),(int)(xi+z*0.86+z*0.86*0.25),(int)(yi+z*0.5));
    return x;
}
    
    
public double RetBl(){
    return bl1;
}
public String RetOpcion(){
    return Op_ana;
}
public double RetScalmV(){
    return mVScal;
}
public double RetScalms(){
    return msScal;
}
public double RetEstir(){
    return msStr;
}
public double RetTimeTest(){
    return totaltime;
}
public double RetTimeEst(){
    if(this.uni_tiempo == "S")
    return totalEsttime*1000;
    else
    return totalEsttime;
}
public double[] RetK1(){
    return Kern1;
}
public double[] RetK1CONF(){
    return Kern11;
}
public double[] RetK2(){
    return Kern2;
}
public double[] RetK2CONF(){
    return Kern21;
}
public double[] RetK3(){
    return Kern3;
}
public double[] RetK3CONF(){
    return Kern31;
}
public double[] Retk1WVF(){
    return k1Graf;
}
public String RetON_OFF_wvf(){
    return on_offwvf;
}
public String RetON_OFF_dr(){
    return on_offdr;
}
public boolean RetlineON_OFF(){
    return line_onoff;
}
public boolean RetEnumON_OFF(){
    return enum_onoff;
}
public String Ret_ojoEst(){
    return ojoEst;
}
public String RetOjo_conf(){
    if(this.ag.oe==1) return "Izquierdo"; 
    else return "Derecho"; 
}
public String RetEst_conf(){
   return this.ag.te;
}
public double RetScalZ(){
    return Double.parseDouble(Zscal.getText());
}
public double RetMinZ(){
    return Double.parseDouble(Zmin.getText());
}
public double RetMaxZ(){
    return Double.parseDouble(Zmax.getText());
}
public double RetBaseTiempo_delta_r(){
    return base_tiempo/27;
}
public double RetBaseTiempo(){
    return base_tiempo;
}
public double RetDensidad_Ker1er_I(int h){
    return ddkk.RetDens(h);
}
public double RetDensidad_Ker1er_D(int h){
    return ddkk2.RetDens(h);
}
public double RetDensidad_Ker1er_Iconf(int h){
    return ddkk1.RetDens(h);
}
public double RetDensidad_Ker1er_Dconf(int h){
    return ddkk21.RetDens(h);
}
public boolean RetProsc_listo_d(){
    return listo_prosc_d;
}
public boolean RetProsc_listo_i(){
    return listo_prosc_i;
}
public boolean RetProsc_listo_dCONF(){
    return listo_prosc_dCONF;
}
public boolean RetProsc_listo_iCONF(){
    return listo_prosc_iCONF;
}
//public boolean RetPlayTime(){
//    return play_time;
//}

      
        public static void main(String args[]) {
        Test0 test = new Test0();
      }


        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Act;
    private javax.swing.JRadioButton Alt;
    private javax.swing.JButton Aplicar;
    private javax.swing.JRadioButton Autom;
    private javax.swing.JButton Calcular;
    private javax.swing.JRadioButton CampVis;
    private javax.swing.JSlider Ch1;
    private javax.swing.JRadioButton DatosResp;
    private javax.swing.JSlider Estir;
    private javax.swing.JButton Fc;
    private javax.swing.JLabel Hor;
    public javax.swing.JButton Iniciar;
    private javax.swing.JRadioButton Manual;
    private javax.swing.JRadioButton MapRegiones;
    private javax.swing.JComboBox ResDis;
    private javax.swing.JRadioButton Resp3D;
    private javax.swing.JButton Salir;
    private javax.swing.JSlider ScalX;
    private javax.swing.JSlider ScalY;
    private javax.swing.JLabel ScalaX;
    private javax.swing.JLabel ScalaY;
    private javax.swing.JSpinner Scalador;
    private javax.swing.JTextArea SerieB1;
    private javax.swing.JTextArea SerieB2;
    private javax.swing.JTextArea SerieB3;
    private javax.swing.JTextField TotalPat;
    private javax.swing.JRadioButton TzWaveform;
    private javax.swing.JLabel UltimoTest;
    private javax.swing.JTextField Zmax;
    private javax.swing.JTextField Zmin;
    private javax.swing.JTextField Zscal;
    public erg2.adqDatos adqDatos1;
    public erg2.anaDatos anaDatos1;
    public javax.swing.JTextField apl_p;
    public javax.swing.JButton baseline;
    public javax.swing.JTextField doc_p;
    public javax.swing.JTextField edad_p;
    private javax.swing.JButton examinar;
    public javax.swing.JLabel fc_muest;
    private javax.swing.JLabel fcorte;
    private javax.swing.JLabel fecha;
    private javax.swing.JRadioButton fijo;
    public javax.swing.JLabel frec_est;
    private erg2.GrafAnillo grafAnillo1;
    private javax.swing.JLabel hora;
    public javax.swing.JCheckBox importar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JCheckBox linea;
    public javax.swing.JTextField nom_p;
    private javax.swing.JCheckBox numerado;
    public javax.swing.JLabel o_est;
    public javax.swing.JLabel pbreal;
    public javax.swing.JButton procesar;
    public javax.swing.JButton refresco;
    private javax.swing.JComboBox scalTiempo;
    private erg2.Tablero tablero1;
    private javax.swing.JTextField tiemm;
    private javax.swing.JTextField tiempo;
    private erg2.Time time1;
    // End of variables declaration//GEN-END:variables
    
}
