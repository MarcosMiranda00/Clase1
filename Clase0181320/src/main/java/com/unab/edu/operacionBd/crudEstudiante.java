/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.operacionBd;

import com.unab.edu.DAO.CLsPersona;
import com.unab.edu.DAO.ClsEstudiante;
import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.Entidades.Persona;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author PC
 */
public class crudEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form crudEstudiante
     */
    String valueMember[];
    int contador = 1;

    public void displayMenber() {

        DefaultComboBoxModel cbdefault = new DefaultComboBoxModel();
        CLsPersona ClasePersona = new CLsPersona();
        ArrayList<Persona> Personas = ClasePersona.MostrarPersona();
        valueMember = new String[Personas.size() + 1];
        String filas[] = new String[4];

        cbdefault.addElement("");
        for (var IterarDatosPersona : Personas) {
            filas[0] = String.valueOf(IterarDatosPersona.getIdPersona());
            filas[1] = IterarDatosPersona.getNombre();
            valueMember[contador] = filas[0];
            cbdefault.addElement(filas[1]);
            contador++;
        }
        cbPersona.setModel(cbdefault);
    }

    public crudEstudiante() {
        initComponents();
        MostrarTablaEstudiante();
        displayMenber();
//        MostrardatosTabla();
        this.setLocationRelativeTo(null);
    }

    void MostrarTablaEstudiante() {
        String TITULOS[] = {"ID_ESTUDIANTE", "MATRICULA", "ID_PERSONA", "NOMBRE_PERSONA", "USUARIO", "CONTRASEÑA", "NIE"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        ClsEstudiante ClaseEstudiante = new ClsEstudiante();
        var Estudiante = ClaseEstudiante.MostrarEstudiante();
        String filas[] = new String[7];
        for (var IterarDatosEstudiante : Estudiante) {
            filas[0] = String.valueOf(IterarDatosEstudiante.getID());
            filas[1] = String.valueOf(IterarDatosEstudiante.getMatricula());
            filas[2] = String.valueOf(IterarDatosEstudiante.getIdPersona());
            filas[3] = IterarDatosEstudiante.getNombre();
            filas[4] = IterarDatosEstudiante.getUsu();
            filas[5] = IterarDatosEstudiante.getPass();
            filas[6] = String.valueOf(IterarDatosEstudiante.getNIE());
            ModeloTabla.addRow(filas);
        }
        tb_MostrarEst.setModel(ModeloTabla);

    }
//    void MostrardatosTabla() {
//        String TITULOS[] = {"ID PERSONA", "NOMBRE PERSONA"};
//        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
//        CLsPersona ClasePersona = new CLsPersona();
//        var Personas = ClasePersona.MostrarPersona();
//        String filas[] = new String[2];
//        for (var IterarDatosPersona : Personas) {
//            filas[0] = String.valueOf(IterarDatosPersona.getIdPersona());
//            filas[1] = IterarDatosPersona.getNombre();
//            ModeloTabla.addRow(filas);
//        }
//
//        tb_SeleccionarId.setModel(ModeloTabla);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtIdEstu = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtNie = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNuevoEst = new javax.swing.JButton();
        btnActualizarEst = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cbPersona = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_MostrarEst = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtIdEstu.setEnabled(false);

        jLabel1.setText("ID Estudiante");

        jLabel2.setText("Matricula");

        jLabel3.setText("ID Persona");

        jLabel4.setText("Contraseña");

        jLabel5.setText("NIE");

        jLabel6.setText("Usuario");

        btnNuevoEst.setText("NUEVO ESTUDIANTE");
        btnNuevoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEstActionPerformed(evt);
            }
        });

        btnActualizarEst.setText("ACTUALIZAR ESTUDIANTE");
        btnActualizarEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEstActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR ESTUDIANTE");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cbPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Oprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuario)
                    .addComponent(cbPersona, javax.swing.GroupLayout.Alignment.TRAILING, 0, 487, Short.MAX_VALUE)
                    .addComponent(txtContra)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(txtIdEstu)
                    .addComponent(txtNie))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevoEst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarEst, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdEstu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoEst))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarEst))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        mPanel.addTab("VISTA", jPanel1);

        tb_MostrarEst.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_MostrarEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_MostrarEstMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_MostrarEst);

        mPanel.addTab("VISTA DE DATOS", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEstActionPerformed
        try {
            ClsEstudiante Estudiante = new ClsEstudiante();
            Estudiante est = new Estudiante();
            est.setMatricula(Integer.parseInt(txtMatricula.getText()));
//        est.setIdPersona(Integer.parseInt(txtIdPerson.getText()));
            est.setIdPersona(Integer.parseInt(valueMember[cbPersona.getSelectedIndex()]));
            est.setUsu(txtUsuario.getText());
            est.setPass(txtContra.getText());
            est.setNIE(Integer.parseInt(txtNie.getText()));
            Estudiante.AgregarEst(est);

            MostrarTablaEstudiante();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }


    }//GEN-LAST:event_btnNuevoEstActionPerformed

    private void btnActualizarEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEstActionPerformed
        try {
            ClsEstudiante Estudiante = new ClsEstudiante();
            Estudiante estud = new Estudiante();
            estud.setID(Integer.parseInt(txtIdEstu.getText()));
            estud.setMatricula(Integer.parseInt(txtMatricula.getText()));
//        estud.setIdPersona(Integer.parseInt(txtIdPerson.getText()));
            estud.setUsu(txtUsuario.getText());
            estud.setPass(txtContra.getText());
            estud.setNIE(Integer.parseInt(txtNie.getText()));
            Estudiante.ActualizarEstudiante(estud);

            MostrarTablaEstudiante();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }


    }//GEN-LAST:event_btnActualizarEstActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            ClsEstudiante Estudiantes = new ClsEstudiante();
            Estudiante estu = new Estudiante();
            estu.setID(Integer.parseInt(txtIdEstu.getText()));
            Estudiantes.BorrarEstudiante(estu);

            MostrarTablaEstudiante();
        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tb_MostrarEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_MostrarEstMouseClicked
        mPanel.setSelectedIndex(mPanel.indexOfComponent(jPanel1));

        int fila = tb_MostrarEst.getSelectedRow();

        String IdEstudiante = String.valueOf(tb_MostrarEst.getValueAt(fila, 0));
        String Matricula = String.valueOf(tb_MostrarEst.getValueAt(fila, 1));
        String IdPersona = String.valueOf(tb_MostrarEst.getValueAt(fila, 2));
        String Usuario = String.valueOf(tb_MostrarEst.getValueAt(fila, 4));
        String Password = String.valueOf(tb_MostrarEst.getValueAt(fila, 5));
        String Nie = String.valueOf(tb_MostrarEst.getValueAt(fila, 6));

        txtIdEstu.setText(IdEstudiante);
        txtMatricula.setText(Matricula);
//        txtIdPerson.setText(IdPersona);
        txtUsuario.setText(Usuario);
        txtContra.setText(Password);
        txtNie.setText(Nie);
        
        int seleccionadordevista = 0;
        for (var iterar : valueMember){
        if(IdPersona.equals(iterar)){
        cbPersona.setSelectedIndex(seleccionadordevista);
        }
        seleccionadordevista+=1;        
        }
    }//GEN-LAST:event_tb_MostrarEstMouseClicked

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
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEst;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevoEst;
    private javax.swing.JComboBox<String> cbPersona;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane mPanel;
    private javax.swing.JTable tb_MostrarEst;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtIdEstu;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNie;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
