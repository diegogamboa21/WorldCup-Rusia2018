/**
 * @author Diego Gamboa
 * @author Camilo Calderon
 * @author Alejandro Mayorga
 * @author Juan Pablo Linares
 */

package GUI;

import Controllers.EquipoJpaController;
import Controllers.EstadioJpaController;
import Controllers.GolesJpaController;
import Controllers.JugadorJpaController;
import Controllers.PartidoJpaController;
import Ordenar.OrdenarGrupo;
import Ordenar.OrdenarPuntos;
import Controllers.CategoriaJpaController;
import Controllers.ClienteJpaController;
import Controllers.SillaJpaController;
import Controllers.TiqueteJpaController;
import Controllers.exceptions.NonexistentEntityException;
import Controllers.exceptions.PreexistingEntityException;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rusia2018.*;
import rusia2018.Equipo;
import rusia2018.Estadio;
import rusia2018.Goles;
import rusia2018.Jugador;
import rusia2018.Partido;
import sun.awt.image.ByteArrayImageSource;
import sun.awt.image.ToolkitImage;

public class GUI_Mundial extends javax.swing.JFrame {

    
    public GUI_Mundial() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTmundial = new javax.swing.JTabbedPane();
        jPinicio = new javax.swing.JPanel();
        jBregistrarEncuentro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JPregistrarEncuentro = new javax.swing.JPanel();
        JCBpartidos = new javax.swing.JComboBox<>();
        JBatras = new javax.swing.JButton();
        JBseleccionar = new javax.swing.JButton();
        jPanelPartido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextPartidosNumero = new javax.swing.JTextField();
        jTextEstadio = new javax.swing.JTextField();
        jTextFecha = new javax.swing.JTextField();
        jTextHora = new javax.swing.JTextField();
        jTextEquipoLocal = new javax.swing.JTextField();
        jTextVisitante = new javax.swing.JTextField();
        jTextLocalGol = new javax.swing.JTextField();
        jTextVisitanteGol = new javax.swing.JTextField();
        jTextGolLocal = new javax.swing.JTextField();
        jTextGolVisitante = new javax.swing.JTextField();
        jSPMarcador = new javax.swing.JScrollPane();
        jTMarcador = new javax.swing.JTable();
        jBAgregarAnotacion = new javax.swing.JButton();
        jBRegresar1 = new javax.swing.JButton();
        jLfoto = new javax.swing.JLabel();
        jPMarcador = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextMarcadorNumeroPartido = new javax.swing.JTextField();
        jComboBoxMarEquipo = new javax.swing.JComboBox<>();
        jComboBoxMarJugador = new javax.swing.JComboBox<>();
        jTextMinuto = new javax.swing.JTextField();
        jButtonAgregarGol = new javax.swing.JButton();
        jButtonMarRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jCmenuFase = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jsPosiciones = new javax.swing.JScrollPane();
        jTPosiciones = new javax.swing.JTable();
        jBgenerarFase = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jToctavos = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTboleteria = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTFfecha = new javax.swing.JTextField();
        jTFhora = new javax.swing.JTextField();
        jBsolicitarEntrada = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTFEstadio = new javax.swing.JTextField();
        jTFpartido = new javax.swing.JTextField();
        jTFed = new javax.swing.JTextField();
        JsolicitarEntrada = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTSSEstadio = new javax.swing.JTextField();
        jTSSpartido = new javax.swing.JTextField();
        jTSScategoria = new javax.swing.JTextField();
        jTSSDisponibles = new javax.swing.JTextField();
        jBSScomprar = new javax.swing.JButton();
        jBSSRegresar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTIPestadio = new javax.swing.JTextField();
        jTIPpartido = new javax.swing.JTextField();
        jTIPcategoria = new javax.swing.JTextField();
        jTIPdisponibles = new javax.swing.JTextField();
        jTIPsolicitadas = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTIPtable = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jTIPtotalAPagar = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jRadioButtonEfectivo = new javax.swing.JRadioButton();
        jRadioButtonTarjetaDeCredito = new javax.swing.JRadioButton();
        jTIPefectivo = new javax.swing.JTextField();
        jTIPtarjetaCredito = new javax.swing.JTextField();
        jBIPpagar = new javax.swing.JButton();
        jBIPregresar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTICnombre = new javax.swing.JTextField();
        jTICapellido = new javax.swing.JTextField();
        jTICpasaporte = new javax.swing.JTextField();
        jBICterminarC = new javax.swing.JButton();
        jBICregresar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        JTCCnombreC = new javax.swing.JTextField();
        jTFapellidoC = new javax.swing.JTextField();
        jTFCCdocumento = new javax.swing.JTextField();
        JTCCnumeroS = new javax.swing.JTextField();
        jTCCcategoria = new javax.swing.JTextField();
        jTCCsllas = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jTCCestadio = new javax.swing.JTextField();
        jTCCpartido = new javax.swing.JTextField();
        jTCCfecha = new javax.swing.JTextField();
        jTCCequipos = new javax.swing.JTextField();
        jTCCtotalPagar = new javax.swing.JTextField();
        jTCCformadePago = new javax.swing.JTextField();
        jTCCrecibido = new javax.swing.JTextField();
        jTCCnumeroFactura = new javax.swing.JTextField();
        jTCCfechaCompra = new javax.swing.JTextField();
        jBregresarMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPinicio.setLayout(null);

        jBregistrarEncuentro.setText("Registrar Encuentro");
        jBregistrarEncuentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBregistrarEncuentroActionPerformed(evt);
            }
        });
        jPinicio.add(jBregistrarEncuentro);
        jBregistrarEncuentro.setBounds(90, 130, 150, 23);

        jButton2.setText("Generar Partidos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPinicio.add(jButton2);
        jButton2.setBounds(90, 190, 150, 23);

        jButton3.setText("Venta Boleteria");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPinicio.add(jButton3);
        jButton3.setBounds(90, 240, 150, 23);

        jTmundial.addTab("Inicio", jPinicio);

        JPregistrarEncuentro.setLayout(null);

        JCBpartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBpartidosActionPerformed(evt);
            }
        });
        JPregistrarEncuentro.add(JCBpartidos);
        JCBpartidos.setBounds(170, 80, 170, 20);

        JBatras.setText("ATRAS");
        JBatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBatrasActionPerformed(evt);
            }
        });
        JPregistrarEncuentro.add(JBatras);
        JBatras.setBounds(270, 280, 140, 40);

        JBseleccionar.setText("SELECCIONAR");
        JBseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBseleccionarActionPerformed(evt);
            }
        });
        JPregistrarEncuentro.add(JBseleccionar);
        JBseleccionar.setBounds(110, 280, 140, 40);

        jTmundial.addTab("Registrar encuentro ", JPregistrarEncuentro);

        jPanelPartido.setLayout(null);

        jLabel1.setText("Numero Partido");
        jPanelPartido.add(jLabel1);
        jLabel1.setBounds(67, 11, 82, 22);

        jLabel2.setText("Estadio");
        jPanelPartido.add(jLabel2);
        jLabel2.setBounds(67, 35, 82, 22);

        jLabel3.setText("Fecha");
        jPanelPartido.add(jLabel3);
        jLabel3.setBounds(67, 63, 82, 22);

        jLabel4.setText("Hora");
        jPanelPartido.add(jLabel4);
        jLabel4.setBounds(67, 91, 82, 22);

        jLabel5.setText("Equipo Local");
        jPanelPartido.add(jLabel5);
        jLabel5.setBounds(67, 116, 82, 22);

        jLabel6.setText("Equipo Visitante");
        jPanelPartido.add(jLabel6);
        jLabel6.setBounds(67, 144, 82, 22);

        jLabel7.setText("Mrcador");
        jPanelPartido.add(jLabel7);
        jLabel7.setBounds(67, 175, 82, 14);

        jTextPartidosNumero.setToolTipText("");
        jTextPartidosNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPartidosNumeroActionPerformed(evt);
            }
        });
        jPanelPartido.add(jTextPartidosNumero);
        jTextPartidosNumero.setBounds(159, 12, 93, 20);
        jPanelPartido.add(jTextEstadio);
        jTextEstadio.setBounds(159, 36, 93, 20);
        jPanelPartido.add(jTextFecha);
        jTextFecha.setBounds(159, 64, 93, 20);
        jPanelPartido.add(jTextHora);
        jTextHora.setBounds(159, 91, 93, 22);
        jPanelPartido.add(jTextEquipoLocal);
        jTextEquipoLocal.setBounds(159, 116, 93, 22);
        jPanelPartido.add(jTextVisitante);
        jTextVisitante.setBounds(159, 144, 93, 22);
        jPanelPartido.add(jTextLocalGol);
        jTextLocalGol.setBounds(159, 172, 93, 20);
        jPanelPartido.add(jTextVisitanteGol);
        jTextVisitanteGol.setBounds(159, 198, 93, 20);
        jPanelPartido.add(jTextGolLocal);
        jTextGolLocal.setBounds(262, 172, 93, 20);
        jPanelPartido.add(jTextGolVisitante);
        jTextGolVisitante.setBounds(262, 198, 93, 20);

        jTMarcador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTMarcador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMarcadorMouseClicked(evt);
            }
        });
        jSPMarcador.setViewportView(jTMarcador);

        jPanelPartido.add(jSPMarcador);
        jSPMarcador.setBounds(15, 286, 340, 118);

        jBAgregarAnotacion.setText("Agregar Anotación");
        jBAgregarAnotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarAnotacionActionPerformed(evt);
            }
        });
        jPanelPartido.add(jBAgregarAnotacion);
        jBAgregarAnotacion.setBounds(70, 410, 123, 23);

        jBRegresar1.setText("Regresar");
        jBRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresar1ActionPerformed(evt);
            }
        });
        jPanelPartido.add(jBRegresar1);
        jBRegresar1.setBounds(210, 410, 123, 23);
        jPanelPartido.add(jLfoto);
        jLfoto.setBounds(380, 60, 230, 300);

        jTmundial.addTab("Partidos", jPanelPartido);

        jLabel8.setText("Agregar Anotaciones");

        jLabel9.setText("Numero de Partido");

        jLabel10.setText("Equipo");

        jLabel11.setText("Jugador");

        jLabel12.setText("Minuto");

        jComboBoxMarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarEquipoActionPerformed(evt);
            }
        });

        jButtonAgregarGol.setText("Agregar");
        jButtonAgregarGol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarGolActionPerformed(evt);
            }
        });

        jButtonMarRegresar.setText("Regresar");
        jButtonMarRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMarcadorLayout = new javax.swing.GroupLayout(jPMarcador);
        jPMarcador.setLayout(jPMarcadorLayout);
        jPMarcadorLayout.setHorizontalGroup(
            jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMarcadorLayout.createSequentialGroup()
                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMarcadorLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8))
                    .addGroup(jPMarcadorLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPMarcadorLayout.createSequentialGroup()
                                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextMarcadorNumeroPartido)
                                    .addComponent(jComboBoxMarEquipo, 0, 131, Short.MAX_VALUE)
                                    .addComponent(jComboBoxMarJugador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextMinuto)))
                            .addGroup(jPMarcadorLayout.createSequentialGroup()
                                .addComponent(jButtonAgregarGol, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jButtonMarRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPMarcadorLayout.setVerticalGroup(
            jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMarcadorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMarcadorLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMarcadorLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jTextMarcadorNumeroPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxMarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxMarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPMarcadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarGol)
                    .addComponent(jButtonMarRegresar))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jTmundial.addTab("Marcador", jPMarcador);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCmenuFase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Octavos de final", "Cuartos de final" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCmenuFase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jCmenuFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(95, 95, 95))
        );

        jTmundial.addTab("menuFase", jPanel1);

        jTPosiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jsPosiciones.setViewportView(jTPosiciones);

        jBgenerarFase.setText("Generar Fase");
        jBgenerarFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgenerarFaseActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar Fase");

        jButton5.setText("Regresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jsPosiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBgenerarFase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(116, 116, 116)
                        .addComponent(jButton5)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jsPosiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBgenerarFase)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jTmundial.addTab("posiciones", jPanel2);

        jToctavos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jToctavos);

        jButton6.setText("Regresar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jButton6)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        jTmundial.addTab("Octavos de final", jPanel3);

        jPanel4.setLayout(null);

        jTboleteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTboleteria.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTboleteria);
        jTboleteria.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(20, 140, 580, 232);

        jLabel13.setText("Fecha Actual");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(152, 59, 62, 14);

        jLabel14.setText("Hora actual");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(152, 97, 55, 14);

        jTFfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFfechaActionPerformed(evt);
            }
        });
        jPanel4.add(jTFfecha);
        jTFfecha.setBounds(245, 56, 110, 20);
        jPanel4.add(jTFhora);
        jTFhora.setBounds(246, 94, 110, 20);

        jBsolicitarEntrada.setText("Solicitar Entrada");
        jBsolicitarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsolicitarEntradaActionPerformed(evt);
            }
        });
        jPanel4.add(jBsolicitarEntrada);
        jBsolicitarEntrada.setBounds(220, 400, 150, 23);

        jTmundial.addTab("Boleteria", jPanel4);

        jPanel5.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(80, 200, 452, 160);

        jLabel15.setText("Estadio");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(105, 70, 100, 14);

        jLabel16.setText("Partido");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(110, 100, 100, 14);

        jLabel17.setText("Entradas disponibles");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(110, 130, 100, 14);
        jPanel5.add(jTFEstadio);
        jTFEstadio.setBounds(240, 70, 110, 20);
        jPanel5.add(jTFpartido);
        jTFpartido.setBounds(240, 100, 110, 20);
        jPanel5.add(jTFed);
        jTFed.setBounds(240, 130, 110, 20);

        JsolicitarEntrada.setText("Solicitar Entrada");
        JsolicitarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JsolicitarEntradaActionPerformed(evt);
            }
        });
        jPanel5.add(JsolicitarEntrada);
        JsolicitarEntrada.setBounds(141, 380, 130, 23);

        jButton7.setText("Regresar");
        jPanel5.add(jButton7);
        jButton7.setBounds(320, 380, 120, 23);

        jTmundial.addTab("Entradas por Categoria", jPanel5);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jLabel18.setText("Estadio");

        jLabel19.setText("Partido");

        jLabel20.setText("Categoria");

        jLabel21.setText("Disponibles");

        jBSScomprar.setText("Comprar");
        jBSScomprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSScomprarActionPerformed(evt);
            }
        });

        jBSSRegresar.setText("Regresar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTSSpartido, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTSScategoria)
                                .addComponent(jTSSDisponibles))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jBSScomprar)
                        .addGap(106, 106, 106)
                        .addComponent(jBSSRegresar))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTSSEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTSSEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTSSpartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTSScategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTSSDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSScomprar)
                    .addComponent(jBSSRegresar))
                .addGap(56, 56, 56))
        );

        jTmundial.addTab("Solicitud de Silla", jPanel6);

        jLabel22.setText("Estadio");

        jLabel23.setText("Partido");

        jLabel24.setText("Categoria");

        jLabel25.setText("Disponibles");

        jLabel26.setText("Solicitadas");

        jTIPcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIPcategoriaActionPerformed(evt);
            }
        });

        jTIPtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTIPtable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane5.setViewportView(jTIPtable);

        jLabel27.setText("Total a Pagar");

        jLabel28.setText("Seleccione Forma de Pago");
        jLabel28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jRadioButtonEfectivo.setText("Efectivo Recibido");
        jRadioButtonEfectivo.setToolTipText("");
        jRadioButtonEfectivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jRadioButtonTarjetaDeCredito.setText("Tarjeta de Credito");
        jRadioButtonTarjetaDeCredito.setActionCommand("Tarjeta de Credito");
        jRadioButtonTarjetaDeCredito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBIPpagar.setText("Pagar");
        jBIPpagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIPpagarActionPerformed(evt);
            }
        });

        jBIPregresar.setText("Regresar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTIPestadio)
                            .addComponent(jTIPpartido)
                            .addComponent(jTIPcategoria)
                            .addComponent(jTIPdisponibles)
                            .addComponent(jTIPsolicitadas, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)
                        .addGap(65, 65, 65)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jRadioButtonTarjetaDeCredito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTIPtarjetaCredito))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jRadioButtonEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTIPefectivo))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTIPtotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jBIPpagar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jBIPregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 42, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTIPestadio)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTIPpartido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTIPcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTIPdisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTIPsolicitadas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButtonEfectivo)
                                .addComponent(jTIPefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButtonTarjetaDeCredito)
                                .addComponent(jTIPtarjetaCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTIPtotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBIPpagar)
                    .addComponent(jBIPregresar))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTmundial.addTab("Informacion de Pago", jPanel7);

        jLabel29.setText("Nombre");

        jLabel30.setText("Apellido");

        jLabel31.setText("Pasaporte");

        jBICterminarC.setText("Terminar Compra");
        jBICterminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBICterminarCActionPerformed(evt);
            }
        });

        jBICregresar.setText("Regresar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBICterminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jBICregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTICnombre)
                            .addComponent(jTICapellido)
                            .addComponent(jTICpasaporte, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTICnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTICapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel31))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTICpasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBICterminarC)
                    .addComponent(jBICregresar))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jTmundial.addTab("Informacion de Cliente", jPanel8);

        jLabel32.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Confirmación de Compra");

        jLabel33.setFont(new java.awt.Font("Dubai", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 204));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Cliente");
        jLabel33.setToolTipText("");

        jLabel34.setText("Nombre");

        jLabel35.setText("Apellido");

        jLabel36.setText("Documento");

        jLabel37.setFont(new java.awt.Font("Dubai", 0, 11)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 204));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Entradas");

        jLabel38.setText("Numero de Sillas");

        jLabel39.setText("Categoria");

        jLabel40.setText("Sillas");

        jLabel41.setFont(new java.awt.Font("Dubai", 0, 11)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 51, 204));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Partido");

        jLabel42.setText("Esatdio");

        jLabel43.setText("Partido");

        jLabel44.setText("Fecha Y Hora");

        jLabel45.setText("Equipos");

        jLabel46.setFont(new java.awt.Font("Dubai", 0, 11)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 204));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Pago");

        jLabel47.setText("Total a Pagar");

        jLabel48.setText("Forma de Pago");

        jLabel49.setText("Recibido");

        jLabel50.setText("Numero de Factura");

        jLabel51.setText("Fecha de Compra");

        jBregresarMenuPrincipal.setText("Menu Principal");
        jBregresarMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBregresarMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTCCnumeroS)
                                    .addComponent(jTCCcategoria)
                                    .addComponent(jTCCsllas)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTCCnombreC)
                                    .addComponent(jTFapellidoC)
                                    .addComponent(jTFCCdocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(131, 131, 131))
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jBregresarMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel47)
                                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTCCestadio)
                            .addComponent(jTCCpartido)
                            .addComponent(jTCCfecha)
                            .addComponent(jTCCequipos)
                            .addComponent(jTCCtotalPagar)
                            .addComponent(jTCCformadePago)
                            .addComponent(jTCCrecibido)
                            .addComponent(jTCCnumeroFactura)
                            .addComponent(jTCCfechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTCCnombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jTCCestadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTFapellidoC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jTCCpartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCCdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jTCCfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTCCequipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTCCnumeroS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jTCCtotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCCcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jTCCformadePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTCCsllas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jTCCrecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jTCCnumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jTCCfechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBregresarMenuPrincipal)
                        .addGap(22, 22, 22))))
        );

        jTmundial.addTab("Confirmaciion de Compra", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTmundial)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTmundial))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBseleccionarActionPerformed
        
        jTmundial.setSelectedIndex(2);
           
        int golesL=0;
        int golesV=0;
        int index = JCBpartidos.getSelectedIndex();
        this.jTextPartidosNumero.setText(String.valueOf(index+1));
        
        PartidoJpaController CONTROLPARTIDOS = new PartidoJpaController();
        EquipoJpaController CONTROLEQUIPO = new EquipoJpaController();
        EstadioJpaController CONTROESTADIO  = new EstadioJpaController();
        
        BigInteger indexf = BigInteger.valueOf(index+1);
        
        Partido partido = CONTROLPARTIDOS.findPartido(indexf);
        
        Estadio estadio = CONTROESTADIO.findEstadio(partido.getIdEstadio().getIdEstadio());
        
        this.jTextEstadio.setText(estadio.getNombreEstadio());
   
        LocalDate f = LocalDate.of(partido.getFechayhora().getYear()+1900,partido.getFechayhora().getMonth()+1,partido.getFechayhora().getDate());
        
        this.jTextFecha.setText(f.toString());
        
        LocalTime hora = LocalTime.of(partido.getFechayhora().getHours(),partido.getFechayhora().getMinutes());
        this.jTextHora.setText(hora.toString());
        
        System.out.println(hora.toString());
        
       Equipo local = CONTROLEQUIPO.findEquipo(partido.getIdLocal().getIdEquipo());
       Equipo visitante = CONTROLEQUIPO.findEquipo(partido.getIdVisitante().getIdEquipo());
       String l = local.getGrupo().getGrupoPK().getNombreEquipo();
       String v = visitante.getGrupo().getGrupoPK().getNombreEquipo();
       this.jTextEquipoLocal.setText(l);
       this.jTextVisitante.setText(v);
       this.jTextLocalGol.setText(l);
       this.jTextVisitanteGol.setText(v);
       
       String matris1[][] = new String[partido.getGolesList().size()][7];
       this.jTMarcador.setModel(new javax.swing.table.DefaultTableModel(
                    matris1,
                    new String[]{"Equipo","Nombre Jugador", "Minuto"}));
       
       if(partido.getGolesList().size()==0)
       {
           this.jTextGolLocal.setText(String.valueOf(0));
           this.jTextGolVisitante.setText(String.valueOf(0));
       }
       else
       {
           List<Goles> goles = partido.getGolesList();
           for(Goles g:goles)
           {
               if(g.getIdJugador().getIdEquipo().getIdEquipo()==partido.getIdLocal().getIdEquipo())
               {
                   golesL++;
               }
               else
               {
                   golesV++;
               }
           }
           partido.setGolesLocal(golesL);
           partido.setGolesVisitante(golesV);
           
           this.jTextGolLocal.setText(String.valueOf(golesL));
           this.jTextGolVisitante.setText(String.valueOf(golesV));
           
           String matris[][] = new String[goles.size()][7];
           int i =0;
           
           for(Goles g:goles)
           {
               if(i<goles.size())
               {
                    matris[i][0] = g.getIdJugador().getIdEquipo().getGrupo().getGrupoPK().getNombreEquipo();
                    matris[i][1] = g.getIdJugador().getPersona().getNombre() +" "+ g.getIdJugador().getPersona().getApellido();
                    matris[i][2] = String.valueOf(g.getMinuto());
                    i++;
               }
           }
           this.jTMarcador.setModel(new javax.swing.table.DefaultTableModel(
                    matris,
                    new String[]{"Equipo","Nombre Jugador", "Minuto"}
            ));
           
           
       }
           
       
    }//GEN-LAST:event_JBseleccionarActionPerformed

    private void JCBpartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBpartidosActionPerformed
        
    }//GEN-LAST:event_JCBpartidosActionPerformed

    private void jBregistrarEncuentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBregistrarEncuentroActionPerformed
        jTmundial.setSelectedIndex(1);
        
        PartidoJpaController CONTROLPARTIDOS = new PartidoJpaController();
        EquipoJpaController CONTROLEQUIPO = new EquipoJpaController();
        
        Equipo local;
        Equipo visitante;

        List<Partido> partido = CONTROLPARTIDOS.findPartidoEntities();
        for(Partido p:partido){
            if(p.getFase().equalsIgnoreCase("grupo")){
                local = CONTROLEQUIPO.findEquipo(p.getIdLocal().getIdEquipo());
                visitante = CONTROLEQUIPO.findEquipo(p.getIdVisitante().getIdEquipo());

                String l = local.getGrupo().getGrupoPK().getNombreEquipo();
                String v = visitante.getGrupo().getGrupoPK().getNombreEquipo();
                JCBpartidos.addItem(l+"-"+v);
            }
        }
        
    }//GEN-LAST:event_jBregistrarEncuentroActionPerformed

    private void JBatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBatrasActionPerformed
        jTmundial.setSelectedIndex(0);    
    }//GEN-LAST:event_JBatrasActionPerformed

    private void jTextPartidosNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPartidosNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPartidosNumeroActionPerformed

    private void jBRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresar1ActionPerformed
            
        this.jTmundial.setSelectedIndex(1);
        
          String borrar = new String("");
        
        this.jTextPartidosNumero.setText(borrar);
        this.jTextEstadio.setText(borrar);
        this.jTextFecha.setText(borrar);
        this.jTextHora.setText(borrar);
        this.jTextEquipoLocal.setText(borrar);
        this.jTextVisitante.setText(borrar);
        this.jTextLocalGol.setText(borrar);
        this.jTextVisitanteGol.setText(borrar);
        this.jTextGolLocal.setText(borrar);
        this.jTextGolVisitante.setText(borrar);  
        
       
    }//GEN-LAST:event_jBRegresar1ActionPerformed

    private void jBAgregarAnotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarAnotacionActionPerformed
        this.jTmundial.setSelectedIndex(3);
        
        PartidoJpaController CONTROLPARTIDOS = new PartidoJpaController();
        EquipoJpaController CONTROLEQUIPO = new EquipoJpaController();
        
        String nPartido = this.jTextPartidosNumero.getText();
        int numeroPartido = Integer.parseInt(nPartido);
        
        this.jTextMarcadorNumeroPartido.setText(nPartido);
        
        BigInteger indexf = BigInteger.valueOf(numeroPartido);
        Partido partido = CONTROLPARTIDOS.findPartido(indexf);
        
        Equipo local = CONTROLEQUIPO.findEquipo(partido.getIdLocal().getIdEquipo());
        Equipo visitante = CONTROLEQUIPO.findEquipo(partido.getIdVisitante().getIdEquipo());
        String l = local.getGrupo().getGrupoPK().getNombreEquipo();
        String v = visitante.getGrupo().getGrupoPK().getNombreEquipo();
        
        this.jComboBoxMarEquipo.addItem(l);
        this.jComboBoxMarEquipo.addItem(v);       
    }//GEN-LAST:event_jBAgregarAnotacionActionPerformed

    private void jComboBoxMarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarEquipoActionPerformed
        this.jComboBoxMarJugador.removeAllItems();
        PartidoJpaController CONTROLPARTIDOS = new PartidoJpaController();
        EquipoJpaController CONTROLEQUIPO = new EquipoJpaController();
        JugadorJpaController CONTROLJUGADOR = new JugadorJpaController();
        String nPartido = this.jTextPartidosNumero.getText();
        int numeroPartido = Integer.parseInt(nPartido);
        
        BigInteger indexf = BigInteger.valueOf(numeroPartido);
        Partido partido = CONTROLPARTIDOS.findPartido(indexf);
        
        
        Equipo local = CONTROLEQUIPO.findEquipo(partido.getIdLocal().getIdEquipo());
        Equipo visitante = CONTROLEQUIPO.findEquipo(partido.getIdVisitante().getIdEquipo());
        
        
        if(jComboBoxMarEquipo.getSelectedItem()==null)
        {
            
        }
        else
        {
            String teamName = (String) jComboBoxMarEquipo.getSelectedItem();
            if(teamName.equalsIgnoreCase(local.getGrupo().getGrupoPK().getNombreEquipo()))
            {
                List<Jugador> jugador = CONTROLJUGADOR.findJugadorEntities();
                for(Jugador j:jugador)
                {
                    if(j.getIdEquipo().getIdEquipo()==local.getIdEquipo())
                    {
                        jComboBoxMarJugador.addItem(j.getPersona().getNombre());
                    }
                }
            }
            else
            {
                List<Jugador> jugador = CONTROLJUGADOR.findJugadorEntities();
                for(Jugador j:jugador)
                {
                    if(j.getIdEquipo().getIdEquipo()==visitante.getIdEquipo())
                    {
                        jComboBoxMarJugador.addItem(j.getPersona().getNombre());
                    }
                }
            }
        }    
        
    }//GEN-LAST:event_jComboBoxMarEquipoActionPerformed

    private void jButtonMarRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarRegresarActionPerformed
        this.jTmundial.setSelectedIndex(0);
        
        this.jTextMarcadorNumeroPartido.setText("");
        this.jComboBoxMarEquipo.removeAllItems();
        this.jComboBoxMarJugador.removeAllItems();
        this.jTextMinuto.setText("");
        
    }//GEN-LAST:event_jButtonMarRegresarActionPerformed

    private void jButtonAgregarGolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarGolActionPerformed
        GolesJpaController CONTROLGOLES = new GolesJpaController();
        PartidoJpaController CONTROLPARTIDOS = new PartidoJpaController();
        EquipoJpaController CONTROLEQUIPO = new EquipoJpaController();
        JugadorJpaController CONTROLJUGADOR = new JugadorJpaController();
        
        String nPartido = this.jTextMarcadorNumeroPartido.getText();
        int numeroPartido = Integer.parseInt(nPartido);
        
        BigInteger indexf = BigInteger.valueOf(numeroPartido);
        Partido partido = CONTROLPARTIDOS.findPartido(indexf);
        
        if(jComboBoxMarEquipo.getSelectedItem() == null && jComboBoxMarJugador == null)
        {
            
        }
        if(jTextMinuto.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null,"Inserte el minuto de la anotacion");
        }
        else
        {
            Equipo equipo = null;
            Jugador jugadorG = null;
            String equipoN = (String) jComboBoxMarEquipo.getSelectedItem();
            String jugadorN = (String) jComboBoxMarJugador.getSelectedItem();
            
            if(partido.getIdLocal().getGrupo().getGrupoPK().getNombreEquipo().equalsIgnoreCase(equipoN))
            {
                equipo = partido.getIdLocal();
            }
            else
            {
                equipo = partido.getIdVisitante();
            }
            List<Jugador> jugador = CONTROLJUGADOR.findJugadorEntities();
                for(Jugador j:jugador)
                {
                    if(j.getIdEquipo().getIdEquipo()==equipo.getIdEquipo() && j.getPersona().getNombre().equalsIgnoreCase(jugadorN))
                    {
                        jugadorG = j;
                    }
                }
            
            BigInteger idGol = BigInteger.valueOf(CONTROLGOLES.findGolesEntities().size()+1);
            int m = Integer.parseInt(jTextMinuto.getText());
            BigInteger minuto = BigInteger.valueOf(m);
            Goles gol = new Goles(idGol,minuto, jugadorG, partido);
                       
            try {
                CONTROLGOLES.create(gol);
            } catch (Exception ex) {
                Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
            
        }
        
    }//GEN-LAST:event_jButtonAgregarGolActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jTmundial.setSelectedIndex(5);
        
        
        PartidoJpaController CONTROLPARTIDOS = new PartidoJpaController();
        EquipoJpaController CONTROLEQUIPOS = new EquipoJpaController();
        
        List<Partido> partido = CONTROLPARTIDOS.findPartidoEntities();
        List<Octavos> octavos = new ArrayList<Octavos>();
        List<Equipo> equipos = CONTROLEQUIPOS.findEquipoEntities();
        
        for(Partido p:partido)
        {
            List<Goles> goles = p.getGolesList();
            int golesL = 0, golesV = 0;
                for(Goles g:goles)
                {
                   if(g.getIdJugador().getIdEquipo().getIdEquipo() == p.getIdLocal().getIdEquipo()) 
                       golesL++;
                   else golesV++;
               }
               p.setGolesLocal(golesL);
               p.setGolesVisitante(golesV);
        }
        for(Equipo e: equipos )
        {
            Octavos octavo = new Octavos(e);
            octavos.add(octavo);
        }
        for(Partido p:partido)
        {
            if(p.getFase().equalsIgnoreCase("Grupo"))
            {
                for(Octavos o:octavos)
                {
                    if(p.getIdLocal().getIdEquipo() == o.getEquipo().getIdEquipo())
                    {
                        if(p.getGolesLocal() > p.getGolesVisitante() )
                        {
                            o.setPg(o.getPg()+1);
                            o.setPuntos(o.getPuntos()+3);
                        }
                        else if(p.getGolesVisitante()> p.getGolesLocal())
                        {
                            o.setPp(o.getPp()+1);
                        }else
                        {
                            o.setPe(o.getPe()+1);
                            o.setPuntos(o.getPuntos()+1);
                        }    
                    }
                    if(p.getIdVisitante().getIdEquipo() == o.getEquipo().getIdEquipo())
                    {
                        if(p.getGolesLocal() < p.getGolesVisitante() )
                        {
                            o.setPg(o.getPg()+1);
                            o.setPuntos(o.getPuntos()+3);
                        }
                        else if(p.getGolesVisitante() < p.getGolesLocal())
                        {
                            o.setPp(o.getPp()+1);
                        }
                        else 
                        {
                            o.setPe(o.getPe()+1);
                            o.setPuntos(o.getPuntos()+1);
                        }    
                    }
                }
            }
        }
        Collections.sort(octavos, new OrdenarPuntos());
        Collections.sort(octavos, new OrdenarGrupo());
        int i=1;
        for(Octavos o:octavos)
        {
            if(i==5)i=1;
            o.setPos(i);
            i++;
        }
        if(fase.size()>0)fase.clear();
        for(Octavos o:octavos)
        {
            if(o.getPos()==1||o.getPos()==2)
            {
                fase.add(o);
            }
        }
        if(jCmenuFase.getSelectedItem().equals("Octavos de final"))
        {
            String matriz[][] = new String[octavos.size()][7];
               int j =0;

               for(Octavos o:octavos)
               {
                   if(j<octavos.size())
                   {
                        matriz[j][0] = o.getEquipo().getGrupo().getGrupoPK().getIdGrupo();
                        matriz[j][1] = String.valueOf(o.getPos());
                        matriz[j][2] = o.getEquipo().getGrupo().getGrupoPK().getNombreEquipo();
                        matriz[j][3] = String.valueOf(o.getPg());
                        matriz[j][4] = String.valueOf(o.getPe());
                        matriz[j][5] = String.valueOf(o.getPp());
                        matriz[j][6] = String.valueOf(o.getPuntos());
                        j++;
                   }
               }
               this.jTPosiciones.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String[]{"Grupo","Posicion", "Equipo", "PG", "PE", "PP", "Puntos"}
                ));
        }      
        else if(jCmenuFase.getSelectedItem().equals("Cuartos de final"))
        {
            
            if(fase.size()>0)
            {
                String matriz[][] = new String[fase.size()][5];
                int j=0;
                for(Octavos f:fase)
                {
                    if(j<fase.size())
                    {
                        matriz[j][0] = f.getEquipo().getGrupo().getGrupoPK().getNombreEquipo();
                        matriz[j][1] = String.valueOf(f.getPg());
                        matriz[j][2] = String.valueOf(f.getPe());
                        matriz[j][3] = String.valueOf(f.getPp());
                        matriz[j][4] = String.valueOf(f.getPuntos());
                        j++;
                    }
                }
                this.jTPosiciones.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String[]{"Equipo", "PG", "PE", "PP", "Puntos"}
                ));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Aun no se han generado los octavos" );
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBgenerarFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgenerarFaseActionPerformed
        this.jTmundial.setSelectedIndex(6);
        PartidoJpaController CONTROLPARTIDOS = new PartidoJpaController();
        EquipoJpaController CONTROLEQUIPOS = new EquipoJpaController();
        
        List<Partido> partido = CONTROLPARTIDOS.findPartidoEntities();
        System.out.println("Entre al boton");
        
        for(Partido p:partido)
        {
            if(p.getFase().equalsIgnoreCase("octavos"))
            {
                long a=49;
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(49));
                    nuevo.setIdLocal(fase.get(0).getEquipo());
                    nuevo.setIdVisitante(fase.get(3).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(50));
                    nuevo.setIdLocal(fase.get(4).getEquipo());
                    nuevo.setIdVisitante(fase.get(7).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(51));
                    nuevo.setIdLocal(fase.get(2).getEquipo());
                    nuevo.setIdVisitante(fase.get(1).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(52));
                    nuevo.setIdLocal(fase.get(6).getEquipo());
                    nuevo.setIdVisitante(fase.get(5).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(53));
                    nuevo.setIdLocal(fase.get(8).getEquipo());
                    nuevo.setIdVisitante(fase.get(11).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(54));
                    nuevo.setIdLocal(fase.get(12).getEquipo());
                    nuevo.setIdVisitante(fase.get(15).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(55));
                    nuevo.setIdLocal(fase.get(10).getEquipo());
                    nuevo.setIdVisitante(fase.get(9).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(p.getIdPartido()==BigInteger.valueOf(a));
                {
                    Partido nuevo = CONTROLPARTIDOS.findPartido(BigInteger.valueOf(56));
                    nuevo.setIdLocal(fase.get(14).getEquipo());
                    nuevo.setIdVisitante(fase.get(13).getEquipo());
                    a++;
                    try {
                        CONTROLPARTIDOS.edit(nuevo);
                    } catch (Exception ex) {
                        Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
            
                
        int j =0;
        String matriz[][] = new String[8][7];
            for(Partido p:partido)
               {
                   if(j<8)
                   {
                        matriz[j][0] = String.valueOf(p.getIdPartido());
                        matriz[j][1] = String.valueOf(LocalDate.of(p.getFechayhora().getYear()+1900,p.getFechayhora().getMonth()+1,p.getFechayhora().getDate()));
                        matriz[j][2] = p.getIdEstadio().getNombreEstadio();
                        matriz[j][3] = p.getIdEstadio().getIdCiudad().getNombreCiudad();
                        matriz[j][4] = p.getIdLocal().getGrupo().getGrupoPK().getNombreEquipo()+" - "+p.getIdVisitante().getGrupo().getGrupoPK().getNombreEquipo();
                        matriz[j][5] = String.valueOf(LocalTime.of(p.getFechayhora().getHours(),p.getFechayhora().getMinutes()));
                        j++;
                   }
               }
               this.jToctavos.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String[]{"Partido","Fecha", "Estadio", "Ciudad", "Equipos", "Horario"}
                ));
    }//GEN-LAST:event_jBgenerarFaseActionPerformed

    private void jTMarcadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMarcadorMouseClicked
        
        JugadorJpaController CONTROLJUGADOR = new JugadorJpaController();
        int col = jTMarcador.getSelectedColumn();
        int fil = jTMarcador.getSelectedRow();
       
        List<Jugador> jugadores = CONTROLJUGADOR.findJugadorEntities();
        if(col==1)
        {
            String nombreJ = (String) this.jTMarcador.getValueAt(fil, col);
            for(Jugador j:jugadores)
            {
                String nom = j.getPersona().getNombre()+" "+j.getPersona().getApellido();
                if(nombreJ.equalsIgnoreCase(nom))
                {
                    if(j.getFoto() != null)
                    {  
                    Image ima = new ToolkitImage(new ByteArrayImageSource(j.getFoto()));
                    ImageIcon ic = new ImageIcon (ima);
                    jLfoto.setIcon(ic);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No hay foto del jugador en la base de datos");
                    }
                }
            }     
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado jugador");
        }
        
    }//GEN-LAST:event_jTMarcadorMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jTmundial.setSelectedIndex(7);
        
        this.jTFfecha.setText(LocalDate.now().toString());
        this.jTFhora.setText(String.valueOf(LocalTime.now().getHour()+":"+String.valueOf(LocalTime.now().getMinute())));
        PartidoJpaController CONTROLPARTIDO = new PartidoJpaController();
        
        List<Partido> partido = CONTROLPARTIDO.findPartidoEntities();
        String matriz[][] = new String[partido.size()][6];
        int j =0;
        
         for(Partido p:partido)
           {   
                if(j<partido.size()){
                     matriz[j][0] = String.valueOf(p.getIdPartido());
                     matriz[j][1] = String.valueOf(LocalDate.of(p.getFechayhora().getYear()+1900,p.getFechayhora().getMonth()+1,p.getFechayhora().getDate()));
                     matriz[j][2] = p.getIdEstadio().getNombreEstadio();
                     matriz[j][3] = p.getIdEstadio().getIdCiudad().getNombreCiudad();
                     if(p.getIdLocal() != null)
                        matriz[j][4] = p.getIdLocal().getGrupo().getGrupoPK().getNombreEquipo()+" - "+p.getIdVisitante().getGrupo().getGrupoPK().getNombreEquipo();
                     else
                         matriz[j][4] = "Por definir";
                     matriz[j][5] = String.valueOf(LocalTime.of(p.getFechayhora().getHours(),p.getFechayhora().getMinutes()));
                     j++;
                }
             }
               this.jTboleteria.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String[]{"Partido","Fecha", "Estadio", "Ciudad", "Equipos", "Horario"}
                ));        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTFfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFfechaActionPerformed

    private void jBsolicitarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsolicitarEntradaActionPerformed
        
        EstadioJpaController CONTROLESTADIO = new EstadioJpaController();
        PartidoJpaController CONTROLPARTIDO = new PartidoJpaController();
        SillaJpaController CONTROSILLA = new SillaJpaController();
        CategoriaJpaController CONTROLCATEGORIA = new CategoriaJpaController();
                
        int col = jTboleteria.getSelectedColumn();
        int row = jTboleteria.getSelectedRow();
        int cat1 = 0;
        int cat2 = 0;
        int cat3 = 0;
        int cat4 = 0;
        int sillasNd=0; 
        BigInteger valor1=BigInteger.valueOf(0);
        BigInteger valor2=BigInteger.valueOf(0);
        BigInteger valor3=BigInteger.valueOf(0);
        BigInteger valor4=BigInteger.valueOf(0);
        String c1 = null;
        String c2 = null;
        String c3 = null;
        String c4 = null;
        if(col==0)
        {
            this.jTmundial.setSelectedIndex(8);
            Partido partido = CONTROLPARTIDO.findPartido(BigInteger.valueOf(Long.parseLong((String) jTboleteria.getValueAt(row, col)))); 
            Estadio estadio = partido.getIdEstadio();
            List<Categoria> categorias = CONTROLCATEGORIA.findCategoriaEntities();
            this.jTFEstadio.setText(estadio.getNombreEstadio());
            this.jTFpartido.setText(String.valueOf(partido.getIdPartido()));
            
            
            for(Categoria c:categorias)
            {
                if(c.getCategoriaPK().getIdEstadio()==estadio.getIdEstadio() )
                {
                    if(c.getCategoriaPK().getIdCategoria()==BigInteger.valueOf(1)) {cat1++; valor1 = c.getValor();c1=c.getTipo();}
                    if(c.getCategoriaPK().getIdCategoria()==BigInteger.valueOf(2)) {cat2++; valor2 = c.getValor();c2=c.getTipo();}
                    if(c.getCategoriaPK().getIdCategoria()==BigInteger.valueOf(3)) {cat3++; valor3 = c.getValor();c3=c.getTipo();}
                    if(c.getCategoriaPK().getIdCategoria()==BigInteger.valueOf(4)) {cat4++; valor4 = c.getValor();c4=c.getTipo();}
                  
                }
            }
            
            
            sillasNd = sillasNd + cat1 + cat2 + cat3 + cat4;
            this.jTFed.setText(String.valueOf(sillasNd));
            String matriz[][] = new String[4][3];
            matriz[0][0] = c1; matriz[0][1] = String.valueOf(valor1); matriz[0][2] = String.valueOf(cat1); 
            matriz[1][0] = c2; matriz[1][1] = String.valueOf(valor2); matriz[1][2] = String.valueOf(cat2);
            matriz[2][0] = c3; matriz[2][1] = String.valueOf(valor3); matriz[2][2] = String.valueOf(cat3);
            matriz[3][0] = c4; matriz[3][1] = String.valueOf(valor4); matriz[3][2] = String.valueOf(cat4);
          
               this.jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String[]{"Categoria", "Precio", "Disponibles"}
                ));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione un Partido");
        }
    }//GEN-LAST:event_jBsolicitarEntradaActionPerformed

    private void JsolicitarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JsolicitarEntradaActionPerformed
        
        
        
        EstadioJpaController CONTROLESTADIO = new EstadioJpaController();
        PartidoJpaController CONTROLPARTIDO = new PartidoJpaController();
        SillaJpaController CONTROSILLA = new SillaJpaController();
        CategoriaJpaController CONTROLCATEGORIA = new CategoriaJpaController();
        int col = jTable1.getSelectedColumn();
        int fil = jTable1.getSelectedRow();
        int i=0;
        int j=0;
      
        if(col == 0)
        {    
            this.jTmundial.setSelectedIndex(9);
            Partido partido = CONTROLPARTIDO.findPartido(BigInteger.valueOf(Long.parseLong((String) jTFpartido.getText()))); 
            String categoria = (String) jTable1.getValueAt(fil, 0);
            Estadio estadio = CONTROLESTADIO.findEstadio(partido.getIdEstadio().getIdEstadio());
            List<Categoria> categorias = CONTROLCATEGORIA.findCategoriaEntities();
            List<Silla> sillas = CONTROSILLA.findSillaEntities();
            List<Silla> sillasEstadio = estadio.getSillaList();

            this.jTSSEstadio.setText(estadio.getNombreEstadio());
            this.jTSSpartido.setText(String.valueOf(partido.getIdPartido()));
            this.jTSScategoria.setText(categoria);

            for(Categoria c:categorias)
            {
                for(Silla s:sillasEstadio)
                {
                    if(c.getSilla().getSillaPK().getIdSilla() == s.getSillaPK().getIdSilla() && c.getCategoriaPK().getIdEstadio() == s.getEstadio().getIdEstadio() )
                    {
                        s.setCategoria(c.getTipo());
                        i++;
                    }
                }
            }

            //System.out.println("Sillas Estadio "+estadio.getNombreEstadio() + " "+ i);
            int cantiCategoria =0;
            for(Silla s:sillasEstadio)
            {
                //System.out.println("Categoria Silla "+s.getSillaPK().getIdSilla()+": "+s.getCategoria());
                 if(s.getCategoria().equalsIgnoreCase(categoria)&& s.getEstado() == null )
                 {
                   cantiCategoria++;  
                 }
            }

            this.jTSSDisponibles.setText(String.valueOf(cantiCategoria));
            String matriz[][] = new String[cantiCategoria][1];
            j=0;
            for(Silla s:sillasEstadio)
            {
                if(s.getCategoria().equalsIgnoreCase(categoria)&& s.getEstado() == null )
                {
                    matriz[j][0] = String.valueOf(s.getNumSilla());
                    j++;
                }
            }
            this.jTable2.setModel(new javax.swing.table.DefaultTableModel(
                            matriz,
                            new String[]{"Fila / Silla"}
                    ));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Categoria");
        }
    }//GEN-LAST:event_JsolicitarEntradaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTmundial.setSelectedIndex(4);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTmundial.setSelectedIndex(4);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTmundial.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jBSScomprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSScomprarActionPerformed
       this.jTmundial.setSelectedIndex(10);
       this.sillasPagar.clear();
      
           
            EstadioJpaController CONTROLESTADIO = new EstadioJpaController();
            PartidoJpaController CONTROLPARTIDO = new PartidoJpaController();
            SillaJpaController CONTROSILLA = new SillaJpaController();
            CategoriaJpaController CONTROLCATEGORIA = new CategoriaJpaController();


           int i=0,j=0;
           int selec[] = this.jTable2.getSelectedRows();
           this.jTIPpartido.setText(this.jTSSpartido.getText());
           this.jTIPcategoria.setText(this.jTSScategoria.getText());
           this.jTIPestadio.setText(this.jTSSEstadio.getText());
           this.jTIPdisponibles.setText(this.jTSSDisponibles.getText());
           this.jTIPsolicitadas.setText(String.valueOf(selec.length));

           Partido partido = CONTROLPARTIDO.findPartido(BigInteger.valueOf(Long.parseLong((String) jTSSpartido.getText())));
           String categoria = this.jTSScategoria.getText();
           Estadio estadio = CONTROLESTADIO.findEstadio(partido.getIdEstadio().getIdEstadio());
           List<Categoria> categorias = CONTROLCATEGORIA.findCategoriaEntities();
           List<Silla> sillasEstadio = estadio.getSillaList();
           List<Silla> sillasP = new ArrayList<Silla>();

           for(Categoria c:categorias)
            {
                for(Silla s:sillasEstadio)
                {
                    if(c.getSilla().getSillaPK().getIdSilla() == s.getSillaPK().getIdSilla() && c.getCategoriaPK().getIdEstadio() == s.getEstadio().getIdEstadio() )
                    {
                        s.setCategoria(c.getTipo());
                        s.setValor(Integer.parseInt(String.valueOf(c.getValor())));
                        i++;
                    }
                }
            }


           for(i=0;i<selec.length;i++)
           {    
                for(Silla s:sillasEstadio)
                {

                    if(s.getNumSilla()==BigInteger.valueOf(Long.parseLong(String.valueOf(jTable2.getValueAt(selec[i],0)))))
                    {

                        sillasP.add(s);
                    }
                }

           }

            String matriz[][] = new String[selec.length][1];
            j=0;
            for(Silla s:sillasP)
            {
                if(s.getCategoria().equalsIgnoreCase(categoria)&& s.getEstado() == null )
                {
                    matriz[j][0] = String.valueOf(s.getNumSilla());
                    j++;
                }
            }
            this.jTIPtable.setModel(new javax.swing.table.DefaultTableModel(
                            matriz,
                            new String[]{"Fila / Silla"}
                    ));

           int pagar =0;
           for(Silla s:sillasP)
           {
               pagar = pagar + s.getValor();
               s.setEstado(BigInteger.valueOf(Long.parseLong("1")));
           }
           this.jTIPtotalAPagar.setText(String.valueOf(pagar));
           this.sillasPagar = sillasP;
           
       
          
       
    }//GEN-LAST:event_jBSScomprarActionPerformed

    private void jTIPcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIPcategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIPcategoriaActionPerformed

    private void jBIPpagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIPpagarActionPerformed
        
      
       
        if(this.jTIPefectivo.getText().equalsIgnoreCase("")==false || this.jTIPtarjetaCredito.getText().equalsIgnoreCase("")==false)
        {
            this.jTmundial.setSelectedIndex(11);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione una forma de pago");
        }
        
        
    }//GEN-LAST:event_jBIPpagarActionPerformed

    private void jBICterminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBICterminarCActionPerformed

        
        if(this.jTICnombre.getText().equals("")==false && this.jTICapellido.getText().equals("")==false && this.jTICpasaporte.getText().equals("")==false)
        {
            SillaJpaController CONTROLSILLA = new SillaJpaController();
            EstadioJpaController CONTROLESTADIO = new EstadioJpaController();
            PartidoJpaController CONTROLPARTIDO = new PartidoJpaController();
            ClienteJpaController CONTROLCLIENTE = new ClienteJpaController();
            EquipoJpaController CONTROLEQUIPO = new EquipoJpaController();
            TiqueteJpaController CONTROLTIQUETE = new TiqueteJpaController();
            
            String sillas = null;
            
            this.jTmundial.setSelectedIndex(12);
            
            this.JTCCnombreC.setText(this.jTICnombre.getText());
            this.jTFapellidoC.setText(this.jTICapellido.getText());
            this.jTFCCdocumento.setText(this.jTICpasaporte.getText());
            
            
            this.jTCCcategoria.setText(this.jTIPcategoria.getText());
            this.JTCCnumeroS.setText(this.jTIPsolicitadas.getText());
            for(Silla s:this.sillasPagar)
            {
                sillas = s.getNumSilla() + " ";
            }
            this.jTCCsllas.setText(sillas);
            
            Partido partido = CONTROLPARTIDO.findPartido(BigInteger.valueOf(Long.parseLong((String) jTIPpartido.getText())));
            Estadio estadio = CONTROLESTADIO.findEstadio(partido.getIdEstadio().getIdEstadio());
            Equipo local = CONTROLEQUIPO.findEquipo(partido.getIdLocal().getIdEquipo());
            Equipo visitante = CONTROLEQUIPO.findEquipo(partido.getIdVisitante().getIdEquipo());
            String l = local.getGrupo().getGrupoPK().getNombreEquipo();
            String v = visitante.getGrupo().getGrupoPK().getNombreEquipo();
            
            this.jTCCestadio.setText(estadio.getNombreEstadio());
            this.jTCCpartido.setText(String.valueOf(partido.getIdPartido()));
            
            LocalDate f = LocalDate.of(partido.getFechayhora().getYear()+1900,partido.getFechayhora().getMonth()+1,partido.getFechayhora().getDate());
            LocalTime hora = LocalTime.of(partido.getFechayhora().getHours(),partido.getFechayhora().getMinutes()); 
            this.jTCCfecha.setText(f.toString() + " " + hora.toString());
            this.jTCCequipos.setText(l + " - " + v);
            
            
            this.jTCCtotalPagar.setText(jTIPtotalAPagar.getText());
            if(this.jRadioButtonEfectivo.isSelected()==true)
            {
                this.jTCCformadePago.setText("Efectivo");
            }
            if(this.jRadioButtonTarjetaDeCredito.isSelected()==true)
            {
                this.jTCCformadePago.setText("Tarjeta de Credito");
            }
            if(this.jTCCformadePago.getText().equalsIgnoreCase("Efectivo"))
            {
                this.jTCCrecibido.setText(jTIPefectivo.getText());
            }
            this.jTCCfechaCompra.setText(LocalDate.now().toString());
            this.jTCCnumeroFactura.setText(String.valueOf(CONTROLTIQUETE.findTiqueteEntities().size()+100));
            
            BigInteger idCl = BigInteger.valueOf(Long.parseLong(jTFCCdocumento.getText()));
            BigInteger idT = BigInteger.valueOf(Long.parseLong(jTCCnumeroFactura.getText()));
            
            Cliente c = new Cliente(idCl);
            
            try {
                CONTROLCLIENTE.create(c);
            } catch (Exception ex) {
                Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Cliente Creado");
            
            for(Silla s:this.sillasPagar)
            {
                Tiquete t = new Tiquete(idT, idCl, c, partido, s);
                BigInteger idT2 = t.getIdTiquete().add(BigInteger.valueOf(Long.parseLong("1"))); 
                t.setIdTiquete(idT2);
                try {
                    CONTROLTIQUETE.create(t);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                }
                s.getTiqueteList().add(t);
            }
            
            
            for(Silla s:this.sillasPagar)
            {
                try {
                    CONTROLSILLA.edit(s);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GUI_Mundial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Silla Comprada");
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Falta un dato por ingresar");
        }
    }//GEN-LAST:event_jBICterminarCActionPerformed

    private void jBregresarMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBregresarMenuPrincipalActionPerformed
        this.jTmundial.setSelectedIndex(0);
    }//GEN-LAST:event_jBregresarMenuPrincipalActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new GUI_Mundial().setVisible(true);  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBatras;
    private javax.swing.JButton JBseleccionar;
    private javax.swing.JComboBox<String> JCBpartidos;
    private javax.swing.JPanel JPregistrarEncuentro;
    private javax.swing.JTextField JTCCnombreC;
    private javax.swing.JTextField JTCCnumeroS;
    private javax.swing.JButton JsolicitarEntrada;
    private javax.swing.JButton jBAgregarAnotacion;
    private javax.swing.JButton jBICregresar;
    private javax.swing.JButton jBICterminarC;
    private javax.swing.JButton jBIPpagar;
    private javax.swing.JButton jBIPregresar;
    private javax.swing.JButton jBRegresar1;
    private javax.swing.JButton jBSSRegresar;
    private javax.swing.JButton jBSScomprar;
    private javax.swing.JButton jBgenerarFase;
    private javax.swing.JButton jBregistrarEncuentro;
    private javax.swing.JButton jBregresarMenuPrincipal;
    private javax.swing.JButton jBsolicitarEntrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonAgregarGol;
    private javax.swing.JButton jButtonMarRegresar;
    private javax.swing.JComboBox<String> jCmenuFase;
    private javax.swing.JComboBox<String> jComboBoxMarEquipo;
    private javax.swing.JComboBox<String> jComboBoxMarJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLfoto;
    private javax.swing.JPanel jPMarcador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelPartido;
    private javax.swing.JPanel jPinicio;
    private javax.swing.JRadioButton jRadioButtonEfectivo;
    private javax.swing.JRadioButton jRadioButtonTarjetaDeCredito;
    private javax.swing.JScrollPane jSPMarcador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTCCcategoria;
    private javax.swing.JTextField jTCCequipos;
    private javax.swing.JTextField jTCCestadio;
    private javax.swing.JTextField jTCCfecha;
    private javax.swing.JTextField jTCCfechaCompra;
    private javax.swing.JTextField jTCCformadePago;
    private javax.swing.JTextField jTCCnumeroFactura;
    private javax.swing.JTextField jTCCpartido;
    private javax.swing.JTextField jTCCrecibido;
    private javax.swing.JTextField jTCCsllas;
    private javax.swing.JTextField jTCCtotalPagar;
    private javax.swing.JTextField jTFCCdocumento;
    private javax.swing.JTextField jTFEstadio;
    private javax.swing.JTextField jTFapellidoC;
    private javax.swing.JTextField jTFed;
    private javax.swing.JTextField jTFfecha;
    private javax.swing.JTextField jTFhora;
    private javax.swing.JTextField jTFpartido;
    private javax.swing.JTextField jTICapellido;
    private javax.swing.JTextField jTICnombre;
    private javax.swing.JTextField jTICpasaporte;
    private javax.swing.JTextField jTIPcategoria;
    private javax.swing.JTextField jTIPdisponibles;
    private javax.swing.JTextField jTIPefectivo;
    private javax.swing.JTextField jTIPestadio;
    private javax.swing.JTextField jTIPpartido;
    private javax.swing.JTextField jTIPsolicitadas;
    private javax.swing.JTable jTIPtable;
    private javax.swing.JTextField jTIPtarjetaCredito;
    private javax.swing.JTextField jTIPtotalAPagar;
    private javax.swing.JTable jTMarcador;
    private javax.swing.JTable jTPosiciones;
    private javax.swing.JTextField jTSSDisponibles;
    private javax.swing.JTextField jTSSEstadio;
    private javax.swing.JTextField jTSScategoria;
    private javax.swing.JTextField jTSSpartido;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTboleteria;
    private javax.swing.JTextField jTextEquipoLocal;
    private javax.swing.JTextField jTextEstadio;
    private javax.swing.JTextField jTextFecha;
    private javax.swing.JTextField jTextGolLocal;
    private javax.swing.JTextField jTextGolVisitante;
    private javax.swing.JTextField jTextHora;
    private javax.swing.JTextField jTextLocalGol;
    private javax.swing.JTextField jTextMarcadorNumeroPartido;
    private javax.swing.JTextField jTextMinuto;
    private javax.swing.JTextField jTextPartidosNumero;
    private javax.swing.JTextField jTextVisitante;
    private javax.swing.JTextField jTextVisitanteGol;
    private javax.swing.JTabbedPane jTmundial;
    private javax.swing.JTable jToctavos;
    private javax.swing.JScrollPane jsPosiciones;
    // End of variables declaration//GEN-END:variables
    private List<Octavos>fase = new ArrayList<Octavos>();
    private List<Silla> sillasPagar = new ArrayList<Silla>();
    
}