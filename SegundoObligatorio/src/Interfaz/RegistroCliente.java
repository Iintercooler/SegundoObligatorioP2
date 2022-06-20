/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Cliente;
import Dominio.Sistema;
import javax.swing.JOptionPane;

public class RegistroCliente extends javax.swing.JFrame {

    Sistema sistema;

    public RegistroCliente(Sistema s) {
        this.sistema = s;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CampoNombre = new javax.swing.JTextField();
        CampoCedula = new javax.swing.JTextField();
        CampoTelefono = new javax.swing.JTextField();
        CampoMail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonRegistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(CampoNombre);
        CampoNombre.setBounds(132, 70, 128, 26);
        getContentPane().add(CampoCedula);
        CampoCedula.setBounds(132, 108, 128, 26);
        getContentPane().add(CampoTelefono);
        CampoTelefono.setBounds(132, 140, 128, 26);
        getContentPane().add(CampoMail);
        CampoMail.setBounds(132, 172, 128, 26);

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(76, 75, 50, 16);

        jLabel2.setText("Cedula");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(83, 108, 43, 16);

        jLabel3.setText("Telefono");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(71, 145, 55, 16);

        jLabel4.setText("Mail");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 182, 26, 16);

        botonRegistrar.setText("Registrar Cliente");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrar);
        botonRegistrar.setBounds(128, 233, 148, 29);

        jLabel5.setText("Registro de Clientes");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(62, 0, 198, 46);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        try {
            String nombre, cedula, mail;
            mail = CampoMail.getText();
            nombre = CampoNombre.getText();
            cedula = CampoCedula.getText();
            String telefono = CampoTelefono.getText();

            Cliente c = new Cliente(mail, nombre, cedula, telefono);

            if (!sistema.existePersona(cedula)) {
                sistema.agragarCliente(c);
                CampoMail.setText(" ");
                CampoNombre.setText(" ");
                CampoCedula.setText(" ");
                CampoTelefono.setText(" ");

                JOptionPane.showMessageDialog(null, "Cliente registrado", "Exitoso", JOptionPane.OK_OPTION);

            } else {

                JOptionPane.showMessageDialog(null, "Esta persona ya esta en el sistema", "error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, "Los campos no son correctos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoCedula;
    private javax.swing.JTextField CampoMail;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoTelefono;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
