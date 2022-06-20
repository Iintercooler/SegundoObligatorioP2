/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Deposito;
import Dominio.Sistema;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistrarDeposito extends javax.swing.JFrame {

    Sistema sistema;

    public RegistrarDeposito() {
        initComponents();
    }

    public RegistrarDeposito(Sistema s) {
        this.sistema = s;
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonRegistratDeposito = new javax.swing.JButton();
        MetrosDeposito = new javax.swing.JTextField();
        NumeroDeposito = new javax.swing.JTextField();
        CheckEstantes = new javax.swing.JCheckBox();
        CheckRefrigerado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        botonRegistratDeposito.setText("Registrar");
        botonRegistratDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistratDepositoActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistratDeposito);
        botonRegistratDeposito.setBounds(167, 241, 100, 29);
        getContentPane().add(MetrosDeposito);
        MetrosDeposito.setBounds(116, 80, 92, 26);

        NumeroDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroDepositoActionPerformed(evt);
            }
        });
        getContentPane().add(NumeroDeposito);
        NumeroDeposito.setBounds(116, 48, 92, 26);

        CheckEstantes.setText("Estantes");
        CheckEstantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckEstantesActionPerformed(evt);
            }
        });
        getContentPane().add(CheckEstantes);
        CheckEstantes.setBounds(116, 158, 85, 23);

        CheckRefrigerado.setText("Refrigerado");
        getContentPane().add(CheckRefrigerado);
        CheckRefrigerado.setBounds(116, 129, 104, 23);

        jLabel1.setText("Numero");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(23, 53, 50, 16);

        jLabel2.setText("Metros");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 85, 43, 16);

        jLabel3.setText("Registro de depositos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(104, 6, 199, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistratDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistratDepositoActionPerformed
        int numero;
        int metros;
        

        try {
            numero = Integer.parseInt(NumeroDeposito.getText());
            metros = Integer.parseInt(MetrosDeposito.getText());
            Deposito d = new Deposito(numero, metros, CheckEstantes.isSelected(),CheckRefrigerado.isSelected());
            if (!sistema.existeDeposito(d)) {
                sistema.agregarDeposito(d);
                 JOptionPane.showMessageDialog(null, "Deposito agregado", "Registro Exitoso", -1);
                 NumeroDeposito.setText(" ");
                 MetrosDeposito.setText(" ");
                 CheckEstantes.setSelected(false);
                 CheckRefrigerado.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(null, "el deposito ya existe", "error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, "Deben ser campos numericos", "Error", JOptionPane.CANCEL_OPTION);
        }


    }//GEN-LAST:event_botonRegistratDepositoActionPerformed

    private void CheckEstantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckEstantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckEstantesActionPerformed

    private void NumeroDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroDepositoActionPerformed

    }//GEN-LAST:event_NumeroDepositoActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckEstantes;
    private javax.swing.JCheckBox CheckRefrigerado;
    private javax.swing.JTextField MetrosDeposito;
    private javax.swing.JTextField NumeroDeposito;
    private javax.swing.JButton botonRegistratDeposito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
