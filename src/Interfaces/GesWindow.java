/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Applications.FilesReader;
import DataClass.Registro;
import Exceptions.NoFilesException;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class GesWindow extends javax.swing.JFrame {

    //VARIABLES DE FILTRO
    private TableRowSorter trs;
    private List<RowFilter<Object, Object>> filterList;
    private RowFilter<Object, Object> rowFilter;
    private final int standard_wide = 50;
    
    //VARIABLES USO DE DATOS
    private ArrayList<Registro> registros;
    
    //VARIABLES DE DISEÑO
    DefaultTableModel modelo_fincas = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/fincas.png"));
        return retValue;
    }
   
    public GesWindow() {
        try {
            //UIManager.setLookAndFeel(new AeroLookAndFeel());
            initComponents();
            setResizable(false);
            this.drawTableFincas();

            this.registros = new ArrayList<>();
            this.registros = FilesReader.readCSVData("Files/Batch_Informe_Fincas.csv");
            
            this.drawDataRegistros(this.registros);
            this.defaultConfigTable();
            this.setTitle("ZONIFICACIÓN INFORME FINCAS - NAIRN TELECOM S.L");
        } catch (NoFilesException ex) {
            System.out.println("Ha ocurrido un error: " + ex.getMessage());
        }
    }

    private void drawTableFincas() {
        jtb_fincas.setModel(modelo_fincas);
        String[] columnasTabla = {"Ftth_fx", "Cobertura", "CTOMIN", "PLCProyecto", "IA2_Proyecto", "Proyecto", "IA2_Central"};
        modelo_fincas.setColumnIdentifiers(columnasTabla);

        // Para no permitir el redimensionamiento de las columnas con el ratón
        jtb_fincas.getTableHeader().setResizingAllowed(false);

        // Así se fija el ancho de las columnas
        for (int i = 0; i < 7; i++) {
            jtb_fincas.getColumnModel().getColumn(i).setPreferredWidth(standard_wide);
            jtb_fincas.getTableHeader().setFont(new Font("SEGOE UI SYMBOL", 1, 14));
        }     
        //AQUI DIBUJAREMOS AUTOMÁTICAMENTE TODOS LOS TÉCNICOS
    }    
    
    private void drawDataRegistros(ArrayList<Registro> registros) {    
        Object[] columna = new Object[7];  
        int numRegistros = registros.size();
        System.out.println(numRegistros);
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = registros.get(i).getFtth_fx();
            columna[1] = registros.get(i).getCobertura();
            columna[2] = registros.get(i).getCtomin();
            columna[3] = registros.get(i).getPlcProyecto();
            columna[4] = registros.get(i).getIa2_proyecto();
            columna[5] = registros.get(i).getProyecto();
            columna[6] = registros.get(i).getIa2_central();
            modelo_fincas.addRow(columna);
        }        
    }

    public void activateFilter(javax.swing.JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                filterList = new ArrayList<>(3);
                filterList.add(RowFilter.regexFilter(filter_ftthfx.getText().toUpperCase(), 0));           
                filterList.add(RowFilter.regexFilter(filter_cobertura.getText().toUpperCase(), 1));             
                filterList.add(RowFilter.regexFilter(filter_ctomin.getText().toUpperCase(), 2));             
                filterList.add(RowFilter.regexFilter(filter_plc.getText().toUpperCase(), 3));             
                filterList.add(RowFilter.regexFilter(filter_ia2_pro.getText().toUpperCase(), 4));             
                filterList.add(RowFilter.regexFilter(filter_proyecto.getText().toUpperCase(), 5));             
                filterList.add(RowFilter.regexFilter(filter_ia2_central.getText().toUpperCase(), 6)); 
                rowFilter = RowFilter.andFilter(filterList);
                trs.setRowFilter(rowFilter);
            }
        }
        );
        trs = new TableRowSorter(modelo_fincas);
        jtb_fincas.setRowSorter(trs);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_fincas = new javax.swing.JTable();
        filter_ctomin = new javax.swing.JTextField();
        resetFilterButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        filter_ftthfx = new javax.swing.JTextField();
        filter_cobertura = new javax.swing.JTextField();
        filter_plc = new javax.swing.JTextField();
        filter_ia2_pro = new javax.swing.JTextField();
        filter_proyecto = new javax.swing.JTextField();
        filter_ia2_central = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(224, 255, 255));
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jtb_fincas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jtb_fincas.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jtb_fincas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtb_fincas.setToolTipText("");
        jtb_fincas.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jScrollPane1.setViewportView(jtb_fincas);
        jtb_fincas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jtb_fincas.getColumnModel().getColumnCount() > 0) {
            jtb_fincas.getColumnModel().getColumn(0).setResizable(false);
            jtb_fincas.getColumnModel().getColumn(0).setPreferredWidth(110);
            jtb_fincas.getColumnModel().getColumn(1).setResizable(false);
            jtb_fincas.getColumnModel().getColumn(1).setPreferredWidth(110);
            jtb_fincas.getColumnModel().getColumn(2).setResizable(false);
            jtb_fincas.getColumnModel().getColumn(2).setPreferredWidth(110);
            jtb_fincas.getColumnModel().getColumn(3).setResizable(false);
            jtb_fincas.getColumnModel().getColumn(3).setPreferredWidth(110);
            jtb_fincas.getColumnModel().getColumn(4).setResizable(false);
            jtb_fincas.getColumnModel().getColumn(4).setPreferredWidth(110);
            jtb_fincas.getColumnModel().getColumn(5).setResizable(false);
            jtb_fincas.getColumnModel().getColumn(5).setPreferredWidth(110);
            jtb_fincas.getColumnModel().getColumn(6).setResizable(false);
            jtb_fincas.getColumnModel().getColumn(6).setPreferredWidth(110);
        }

        filter_ctomin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filter_ctomin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_ctominActionPerformed(evt);
            }
        });

        resetFilterButton1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        resetFilterButton1.setText("Eliminar filtros");
        resetFilterButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFilterButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 2, 10)); // NOI18N
        jLabel1.setText("Nairn Telecom S.L (T.I)");

        filter_ftthfx.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filter_ftthfx.setToolTipText("");
        filter_ftthfx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_ftthfxActionPerformed(evt);
            }
        });

        filter_cobertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filter_cobertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_coberturaActionPerformed(evt);
            }
        });

        filter_plc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filter_plc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_plcActionPerformed(evt);
            }
        });

        filter_ia2_pro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filter_ia2_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_ia2_proActionPerformed(evt);
            }
        });

        filter_proyecto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filter_proyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_proyectoActionPerformed(evt);
            }
        });

        filter_ia2_central.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filter_ia2_central.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_ia2_centralActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filter_ftthfx, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(filter_cobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filter_ctomin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(resetFilterButton1)
                            .addComponent(filter_plc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(filter_ia2_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter_proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filter_ia2_central, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filter_ftthfx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_ctomin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_cobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_plc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_ia2_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_ia2_central, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetFilterButton1)
                        .addGap(0, 31, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void filter_ctominActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_ctominActionPerformed
        this.activateFilter(filter_ctomin);
    }//GEN-LAST:event_filter_ctominActionPerformed

    private void resetFilterButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilterButton1ActionPerformed
        this.resetFilter();
    }//GEN-LAST:event_resetFilterButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void filter_ftthfxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_ftthfxActionPerformed
        this.activateFilter(filter_ftthfx);
    }//GEN-LAST:event_filter_ftthfxActionPerformed

    private void filter_coberturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_coberturaActionPerformed
        this.activateFilter(filter_cobertura);
    }//GEN-LAST:event_filter_coberturaActionPerformed

    private void filter_plcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_plcActionPerformed
        this.activateFilter(filter_plc);
    }//GEN-LAST:event_filter_plcActionPerformed

    private void filter_ia2_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_ia2_proActionPerformed
        this.activateFilter(filter_ia2_pro);
    }//GEN-LAST:event_filter_ia2_proActionPerformed

    private void filter_proyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_proyectoActionPerformed
        this.activateFilter(filter_proyecto);
    }//GEN-LAST:event_filter_proyectoActionPerformed

    private void filter_ia2_centralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_ia2_centralActionPerformed
        this.activateFilter(filter_ia2_central);
    }//GEN-LAST:event_filter_ia2_centralActionPerformed
    
    private void defaultConfigTable(){
        jtb_fincas.getTableHeader().setReorderingAllowed(false) ;
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < 7; i++) {
            jtb_fincas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        jtb_fincas.setRowSelectionAllowed(true);
        jtb_fincas.setColumnSelectionAllowed(true);
        jtb_fincas.setCellSelectionEnabled(true);
    }
    
    private void resetFilter(){
        filter_cobertura.setText(null);
        filter_ctomin.setText(null);
        filter_ftthfx.setText(null);
        filter_ia2_central.setText(null);
        filter_ia2_pro.setText(null);
        filter_proyecto.setText(null);
        filter_plc.setText(null);
        
        filterList = null;
        rowFilter = null;
    }
    
    private void establecerVista(int n){
        try
        {
            switch(n)
            {
                case 1:
                    UIManager.setLookAndFeel(new AluminiumLookAndFeel()); // ALUMINIO
                    break;
                case 2:
                    UIManager.setLookAndFeel(new AeroLookAndFeel()); // BLANQUIAZUL
                    break;
                case 3:
                    UIManager.setLookAndFeel(new BernsteinLookAndFeel()); // AMARILLO
                    break;                
                case 4:
                    UIManager.setLookAndFeel(new HiFiLookAndFeel()); //BLACK
                    break;        
                case 5:
                    UIManager.setLookAndFeel(new LunaLookAndFeel()); //CLASSIC WINDOWS VISTA
                    break;   
                case 6:
                    UIManager.setLookAndFeel(new McWinLookAndFeel()); //PONER COMO VISTA PRINCIPAL
                    break;      
                case 7:
                    UIManager.setLookAndFeel(new TextureLookAndFeel()); // TEXTURIZADO
                    break;
            }
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        } finally {
            dispose();
            new GesWindow().setVisible(true);
        }
    }
     
        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GesWindow().setVisible(true);
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filter_cobertura;
    private javax.swing.JTextField filter_ctomin;
    private javax.swing.JTextField filter_ftthfx;
    private javax.swing.JTextField filter_ia2_central;
    private javax.swing.JTextField filter_ia2_pro;
    private javax.swing.JTextField filter_plc;
    private javax.swing.JTextField filter_proyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_fincas;
    private javax.swing.JButton resetFilterButton1;
    // End of variables declaration//GEN-END:variables
}
