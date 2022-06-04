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
        Salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonRegistratDeposito.setText("Registrar");
        botonRegistratDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistratDepositoActionPerformed(evt);
            }
        });

        NumeroDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroDepositoActionPerformed(evt);
            }
        });

        CheckEstantes.setText("Estantes");
        CheckEstantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckEstantesActionPerformed(evt);
            }
        });

        CheckRefrigerado.setText("Refrigerado");

        jLabel1.setText("Numero");

        jLabel2.setText("Metros");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Registro de depositos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CheckRefrigerado)
                            .addComponent(MetrosDeposito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumeroDeposito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CheckEstantes, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(botonRegistratDeposito)
                        .addGap(18, 18, 18)
                        .addComponent(Salir)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumeroDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MetrosDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addComponent(CheckRefrigerado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckEstantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistratDeposito)
                    .addComponent(Salir))
                .addGap(30, 30, 30))
        );

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

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
       
        try {
            sistema.guardarSistema(sistema);
        } catch (IOException ex) {
            Logger.getLogger(RegistrarDeposito.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_SalirActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckEstantes;
    private javax.swing.JCheckBox CheckRefrigerado;
    private javax.swing.JTextField MetrosDeposito;
    private javax.swing.JTextField NumeroDeposito;
    private javax.swing.JButton Salir;
    private javax.swing.JButton botonRegistratDeposito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}