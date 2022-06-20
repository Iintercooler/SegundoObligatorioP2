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
        setTitle("INICIO");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(450, 250));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Ventana inicial");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 26, 130, 20);

        jButton1.setText("Cargar sistema Guardado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(84, 69, 231, 29);

        jButton2.setText("Crear sistema nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(84, 104, 231, 29);

        jButton3.setText("Cargar sistema con depositos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(84, 139, 231, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Sistema s = new Sistema();
        this.sistema = s;
        Menu v = new Menu(sistema);
        v.setExtendedState(MAXIMIZED_BOTH);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.sistema = sistema.cargarSistema();
        Menu v = new Menu(sistema);
        v.setExtendedState(MAXIMIZED_BOTH);
        v.setVisible(true);
        this.dispose();
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
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
