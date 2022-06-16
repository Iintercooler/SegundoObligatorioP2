
package Interfaz;

import Dominio.ArchivoLectura;
import Dominio.Deposito;
import Dominio.Sistema;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Inicial extends javax.swing.JFrame {
    Sistema sistema;
    public Inicial() {
        initComponents();
        this.sistema = new Sistema();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ventana inicial");

        jButton1.setText("Cargar sistema Guardado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Crear sistema nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar sistema con depositos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton3))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Sistema s = new Sistema();
        this.sistema = s;
        Menu v = new Menu(sistema);
          v.setExtendedState(MAXIMIZED_BOTH);
        v.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.sistema = sistema.cargarSistema();
        Menu v = new Menu(sistema);
          v.setExtendedState(MAXIMIZED_BOTH);
        v.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Sistema s = new Sistema();
        this.sistema = s;
        
        JFileChooser selectorArchivos = new JFileChooser();
        
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int resultado = selectorArchivos.showOpenDialog(this);
        
        File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado
       
        if ((archivo == null) || (archivo.getName().equals(""))) {
            
            JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        }
        
//        System.out.println(archivo.getName());
        ArchivoLectura arch = new ArchivoLectura(archivo.getAbsolutePath());
       
        while (arch.hayMasLineas()) {
            String[] linea = arch.linea().split("#");
            int numero = Integer.parseInt(linea[0]);
            int metros = Integer.parseInt(linea[1]);
            String estantesS = linea[2];
            boolean estantes;
            if (estantesS.equalsIgnoreCase("S")) {
                estantes = true;
            } else {
                estantes = false;
            }
            String refriS = linea[3];
            boolean refri;
            if (refriS.equalsIgnoreCase("S")) {
                refri = true;
            } else {
                refri = false;
            }
            Deposito d = new Deposito(numero, metros, estantes, refri);
            sistema.agregarDeposito(d);
        }
        arch.cerrar();
        Menu v = new Menu(sistema);
        v.setExtendedState(MAXIMIZED_BOTH);
        v.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
