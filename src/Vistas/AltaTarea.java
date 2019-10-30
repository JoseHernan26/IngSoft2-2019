/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Main.Funciones;
import Modelos.Producto;
import Modelos.Tarea;
import Controllers.TareasController;
import Interfaces.TareasMvp;
import Modelos.Reparacion;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Note250
 */
public class AltaTarea extends javax.swing.JFrame implements TareasMvp.View{
    private Border rojo = BorderFactory.createLineBorder(Color.RED, 1);
    private Border negro = BorderFactory.createLineBorder(Color.BLACK, 1);
    private TareasMvp.Controller mController;
    private HashMap<String,Tarea> tareasPredef;
    private Tarea tarea;
    private Float subtotal= 0f;
    private Principal principal;
    private int idReparacion;
    /**
     * Creates new form AltaTarea
     */
    public AltaTarea(Principal principal, Reparacion reparacion) {
        initComponents();
        this.principal = principal;
        tarea = new Tarea();
        System.out.println("reparacion.getId() = " + reparacion.getId());
        idReparacion = reparacion.getId();
        mController = new TareasController(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        agregar_tarea = new javax.swing.JButton();
        isPredef = new javax.swing.JCheckBox();
        tareas_predef = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        repuestos_tarea = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre_tarea = new javax.swing.JTextField();
        precio_tarea = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcion_tarea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        garantia_tarea = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_repuestos = new javax.swing.JTable();
        buscador_tarea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        agregar_repuesto = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Detalles Tarea");

        agregar_tarea.setText("Agregar tarea");
        agregar_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_tareaActionPerformed(evt);
            }
        });

        isPredef.setText("Guardar como predefinida");
        isPredef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isPredefActionPerformed(evt);
            }
        });

        tareas_predef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tareas_predef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tareas_predefActionPerformed(evt);
            }
        });

        jLabel3.setText("Tareas predefinidas");

        repuestos_tarea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Garantia", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(repuestos_tarea);

        jLabel4.setText("Nombre: ");

        jLabel5.setText("Descripción:");

        jLabel6.setText("Valor del servicio");

        jLabel7.setText("Repuestos requeridos");

        nombre_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_tareaActionPerformed(evt);
            }
        });

        precio_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio_tareaActionPerformed(evt);
            }
        });

        descripcion_tarea.setColumns(20);
        descripcion_tarea.setRows(5);
        jScrollPane3.setViewportView(descripcion_tarea);

        jLabel8.setText("Garantia: (en meses)");

        garantia_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garantia_tareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(isPredef)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(agregar_tarea))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tareas_predef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jScrollPane3))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(garantia_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(precio_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(34, 34, 34)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(54, 54, 54)
                                .addComponent(nombre_tarea))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(46, 46, 46))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(tareas_predef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(garantia_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_tarea)
                    .addComponent(isPredef))
                .addContainerGap())
        );

        tabla_repuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Garantia", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_repuestos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla_repuestos);

        buscador_tarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscador_tareaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Buscador repuestos");

        agregar_repuesto.setText("Agregar repuesto");
        agregar_repuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_repuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(agregar_repuesto))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buscador_tarea))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(buscador_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(agregar_repuesto)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void agregar_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_tareaActionPerformed
        preEnvioDatos();
    }//GEN-LAST:event_agregar_tareaActionPerformed

    private void isPredefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isPredefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isPredefActionPerformed

    private void nombre_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_tareaActionPerformed
       nombre_tarea.setBorder(negro);
    }//GEN-LAST:event_nombre_tareaActionPerformed

    private void precio_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio_tareaActionPerformed
       precio_tarea.setBorder(negro);
    }//GEN-LAST:event_precio_tareaActionPerformed

    private void garantia_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garantia_tareaActionPerformed
       garantia_tarea.setBorder(negro);
    }//GEN-LAST:event_garantia_tareaActionPerformed

    private void buscador_tareaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscador_tareaKeyPressed
        mController.buscarProductos(buscador_tarea.getText());
    }//GEN-LAST:event_buscador_tareaKeyPressed

    private void agregar_repuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_repuestoActionPerformed
        DefaultTableModel temp = (DefaultTableModel) repuestos_tarea.getModel();
        int row = tabla_repuestos.getSelectedRow();
        Object nuevo[]= {tabla_repuestos.getValueAt(row, 0),tabla_repuestos.getValueAt(row, 1),1,tabla_repuestos.getValueAt(row, 3)};
        int repetido = -1;
        subtotal = Float.parseFloat(String.valueOf(tabla_repuestos.getValueAt(row, 3)));
        for(int i = 0 ; i <temp.getRowCount(); i++){
            if(temp.getValueAt(i, 0).equals(nuevo[0])){
                repetido = i;
                int x = Integer.parseInt(String.valueOf(temp.getValueAt(i, 2)))+1;
                temp.setValueAt(x, repetido, 2);
            }
        }
        if(repetido == -1){
            temp.addRow(nuevo);
        }
        mController.agregarRepuesto((String) tabla_repuestos.getValueAt(row, 0));
    }//GEN-LAST:event_agregar_repuestoActionPerformed

    private void tareas_predefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tareas_predefActionPerformed
        
        tarea = tareasPredef.get(String.valueOf(tareas_predef.getSelectedItem()));
        if(tarea == null){
            tarea = new Tarea();
            System.out.println("NO SE POR QUE LO LEE MAL");
            return;
        }
        isPredef.setSelected(true);
        nombre_tarea.setText(tarea.getNombre());
        descripcion_tarea.setText(tarea.getDescripcion());
        garantia_tarea.setText(String.valueOf(tarea.getGarantia()));
        precio_tarea.setText(Funciones.redondeo2String(tarea.getSubTotal()));
        try{
            DefaultTableModel temp = (DefaultTableModel) repuestos_tarea.getModel();
            temp.setRowCount(0);
            for(Producto p : tarea.getRepuestos()){
                Object nuevo[]= {p.getNombre(),p.getGarantia(),1,p.getPrecio()};
                temp.addRow(nuevo);
            }
        }catch(NullPointerException e){
            
        }
    }//GEN-LAST:event_tareas_predefActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaTarea(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_repuesto;
    private javax.swing.JButton agregar_tarea;
    private javax.swing.JTextField buscador_tarea;
    private javax.swing.JTextArea descripcion_tarea;
    private javax.swing.JTextField garantia_tarea;
    private javax.swing.JCheckBox isPredef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField nombre_tarea;
    private javax.swing.JTextField precio_tarea;
    private javax.swing.JTable repuestos_tarea;
    private javax.swing.JTable tabla_repuestos;
    private javax.swing.JComboBox<String> tareas_predef;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarPredefinidas(HashMap<String,Tarea> tareas) {
        tareasPredef = tareas;
        try{
            tareas_predef.removeAllItems();
            for(String t : tareasPredef.keySet()){
                tareas_predef.addItem(t);
            }
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("Me vino vacia la lista de tareas predef");
        }
        
    }

    @Override
    public void mostrarTablaRepuestos(List repuestos) {
        DefaultTableModel modelo = (DefaultTableModel) tabla_repuestos.getModel();
        try{
            modelo.setRowCount(0);
            for(int i = 0 ; i < repuestos.size(); i++){
                modelo.addRow((Object[]) repuestos.get(i));
            }
        }catch(NullPointerException e){
            System.out.println("Me vino vacia la lista de tareas predef");
        }
    }

    @Override
    public void mostrarExito() {
        int resp = JOptionPane.showConfirmDialog(null, "La tarea se agrego con exito.", "EXITO",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if(resp == 0){
            principal.setVisible(true);
            this.dispose();
        }
            
    }

    @Override
    public void mostrarError(String text) {
        JOptionPane.showMessageDialog(null, text, "ERROR",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void preEnvioDatos() {
        boolean haveError = false;
        if(Funciones.controlText(nombre_tarea.getText())){
            tarea = new Tarea();
            tarea.setNombre(nombre_tarea.getText());
        }else{
            haveError = true;
            nombre_tarea.setBorder(rojo);
        }
        try {
		tarea.setGarantia(Integer.parseInt(garantia_tarea.getText()));
	} catch (NumberFormatException nfe){
            haveError = true;
            garantia_tarea.setBorder(rojo);
	}
        
        tarea.setDescripcion(descripcion_tarea.getText());
        try{
            float valorServicio = Float.parseFloat(precio_tarea.getText());
            tarea.setValorServicio(valorServicio);
            subtotal +=valorServicio;
            tarea.setSubTotal(subtotal);
        }catch(Exception e){
            haveError = true;
            precio_tarea.setBorder(rojo);
            e.printStackTrace();
        }
        if(haveError){
            return;
        }
        tarea.setIdReparacion(idReparacion);
        if(isPredef.isSelected()){
            mController.agregarTarea(tarea, true);  
        }else{
            mController.agregarTarea(tarea, false);
        }
    }

    @Override
    public void preBusqueda() {
        
    }
}
