/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Cliente;
import Dominio.Contrato;
import Dominio.Deposito;
import Dominio.Empleado;
import Dominio.Sistema;
import java.awt.Color;
import java.awt.Component;
import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ButtonModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author fgavello
 */
public class RegistrarContrato extends javax.swing.JFrame {

    Sistema sistema;

    public RegistrarContrato(Sistema s) {
        this.sistema = s;

        initComponents();
        Stream<Deposito> depsitosDesocupados = sistema.getDepositos().stream().filter(Deposito -> !Deposito.isOcupado());
        ListaDepositos.setListData(depsitosDesocupados.toArray());
        ListaEmpleados.setListData(sistema.getEmpleados().toArray());
        ListaDepositos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ListaClientes.setListData(sistema.getClientes().toArray());
        pintarJlist();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Estantes = new javax.swing.ButtonGroup();
        Refrigeracion = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaEmpleados = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListaDepositos = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        ListaClientes = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        conEstantes = new javax.swing.JRadioButton();
        sinEstantes = new javax.swing.JRadioButton();
        conRefrigeracion = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        indiferenteEstantes = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        indiferenteRefrigeracion = new javax.swing.JRadioButton();
        sinRefrigeracion = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoMinimo = new javax.swing.JTextField();
        campoMaximo = new javax.swing.JTextField();
        buscarDeposito = new javax.swing.JButton();
        campoDetalles = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                formInputMethodTextChanged(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Lista de clientes ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(991, 6, 106, 16);

        jLabel2.setText("Lista de Empleados ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(554, 16, 125, 16);

        jLabel3.setText("Lista de depositos ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 270, 119, 26);

        jButton1.setText("Crear Contrato");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 610, 136, 29);

        jScrollPane4.setViewportView(ListaEmpleados);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(440, 40, 442, 200);

        ListaDepositos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ListaDepositosKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(ListaDepositos);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(430, 300, 384, 200);

        jScrollPane6.setViewportView(ListaClientes);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(900, 40, 300, 200);

        jLabel4.setText("Requisitos de depositos");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 20, 170, 16);

        jLabel5.setText("Estantes");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 50, 70, 16);

        Estantes.add(conEstantes);
        conEstantes.setText("Con estates");
        conEstantes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                conEstantesStateChanged(evt);
            }
        });
        conEstantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conEstantesActionPerformed(evt);
            }
        });
        getContentPane().add(conEstantes);
        conEstantes.setBounds(110, 50, 120, 20);

        Estantes.add(sinEstantes);
        sinEstantes.setText("Sin estanes");
        sinEstantes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sinEstantesStateChanged(evt);
            }
        });
        getContentPane().add(sinEstantes);
        sinEstantes.setBounds(110, 70, 103, 23);

        Refrigeracion.add(conRefrigeracion);
        conRefrigeracion.setText("Con refrigeracion");
        conRefrigeracion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                conRefrigeracionStateChanged(evt);
            }
        });
        getContentPane().add(conRefrigeracion);
        conRefrigeracion.setBounds(110, 160, 150, 30);

        jLabel6.setText("Refrigeracion");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 160, 83, 20);

        jRadioButton4.setText("Con estates");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(110, 50, 120, 20);

        jRadioButton5.setText("Sin estanes");
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(110, 70, 103, 23);

        Estantes.add(indiferenteEstantes);
        indiferenteEstantes.setSelected(true);
        indiferenteEstantes.setText("Indiferente");
        indiferenteEstantes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                indiferenteEstantesStateChanged(evt);
            }
        });
        getContentPane().add(indiferenteEstantes);
        indiferenteEstantes.setBounds(110, 90, 100, 23);

        jRadioButton7.setText("Indiferente");
        getContentPane().add(jRadioButton7);
        jRadioButton7.setBounds(110, 90, 100, 23);

        Refrigeracion.add(indiferenteRefrigeracion);
        indiferenteRefrigeracion.setSelected(true);
        indiferenteRefrigeracion.setText("Indiferente");
        indiferenteRefrigeracion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                indiferenteRefrigeracionStateChanged(evt);
            }
        });
        getContentPane().add(indiferenteRefrigeracion);
        indiferenteRefrigeracion.setBounds(110, 200, 100, 30);

        Refrigeracion.add(sinRefrigeracion);
        sinRefrigeracion.setText("Sin refrigeracion");
        sinRefrigeracion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sinRefrigeracionStateChanged(evt);
            }
        });
        getContentPane().add(sinRefrigeracion);
        sinRefrigeracion.setBounds(110, 180, 140, 30);

        jLabel7.setText("Tamaño minimo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 260, 120, 16);

        jLabel8.setText("Tamaño maximo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 290, 120, 30);
        getContentPane().add(campoMinimo);
        campoMinimo.setBounds(150, 260, 120, 26);
        getContentPane().add(campoMaximo);
        campoMaximo.setBounds(150, 300, 120, 26);

        buscarDeposito.setText("Buscar Deposito Libre");
        buscarDeposito.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                buscarDepositoStateChanged(evt);
            }
        });
        buscarDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDepositoActionPerformed(evt);
            }
        });
        getContentPane().add(buscarDeposito);
        buscarDeposito.setBounds(50, 370, 200, 80);
        getContentPane().add(campoDetalles);
        campoDetalles.setBounds(280, 600, 590, 50);

        jLabel10.setText("Detalles:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(290, 570, 70, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            if (ListaEmpleados.getSelectedValue() != null && ListaClientes.getSelectedValue() != null) {

                Object[] values = ListaDepositos.getSelectedValuesList().toArray();
                Deposito[] d = new Deposito[values.length];
                for (int i = 0; i < values.length; i++) {
                    if (values[i] instanceof Deposito) {
                        d[i] = ((Deposito) values[i]);
                    }
                }

                for (int i = 0; i < d.length; i++) {
                    Contrato c = new Contrato((Empleado) ListaEmpleados.getSelectedValue(), (Cliente) ListaClientes.getSelectedValue(), d[i], campoDetalles.getText(), sistema.getCantidadContratos());
                    c.getDeposito().setOcupado(true);
                    sistema.agregarContrato(c);
                }

                Stream<Deposito> depsitosDesocupados = sistema.getDepositos().stream().filter(Deposito -> !Deposito.isOcupado());
                ListaDepositos.setListData(depsitosDesocupados.toArray());
                JOptionPane.showConfirmDialog(null, "Contratos Creados", "Exito", JOptionPane.DEFAULT_OPTION);

            } else {
                JOptionPane.showConfirmDialog(null, "Deben seleccionar un Empleado y un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }


    }//GEN-LAST:event_jButton1ActionPerformed
  catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Deben seleccionar almenos un deposito", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    private void ListaDepositosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListaDepositosKeyReleased


    }//GEN-LAST:event_ListaDepositosKeyReleased

    private void conEstantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conEstantesActionPerformed

    }//GEN-LAST:event_conEstantesActionPerformed

    private void buscarDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDepositoActionPerformed

        int minimo;
        int maximo;

        try {
            minimo = Integer.parseInt(campoMinimo.getText());
            maximo = Integer.parseInt(campoMaximo.getText());
            recargarListaDepositosConCondiciones();

        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, "Deben ser campos numericos", "Error", JOptionPane.ERROR_MESSAGE);
        }

//        if (indiferenteRefrigeracion.isSelected() && !indiferenteEstantes.isSelected()) {
//            Stream<Deposito> depsitosRefrigerados = sistema.getDepositos().stream().filter(Deposito -> {
//
//                return (Deposito.isEstantes() == conEstantes.isSelected() && Deposito.getTamaño() >= Integer.parseInt(campoMinimo.getText()) && Deposito.getTamaño() <= Integer.parseInt(campoMaximo.getText()));
//
//            });
//            ;
//            ListaDepositos.setListData(depsitosRefrigerados.toArray());
//        }

    }//GEN-LAST:event_buscarDepositoActionPerformed

    private void buscarDepositoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_buscarDepositoStateChanged

    }//GEN-LAST:event_buscarDepositoStateChanged

    private void formInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formInputMethodTextChanged
    }//GEN-LAST:event_formInputMethodTextChanged

    private void conEstantesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_conEstantesStateChanged
    }//GEN-LAST:event_conEstantesStateChanged

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void conRefrigeracionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_conRefrigeracionStateChanged
    }//GEN-LAST:event_conRefrigeracionStateChanged

    private void indiferenteRefrigeracionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_indiferenteRefrigeracionStateChanged

    }//GEN-LAST:event_indiferenteRefrigeracionStateChanged

    private void sinRefrigeracionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sinRefrigeracionStateChanged
    }//GEN-LAST:event_sinRefrigeracionStateChanged

    private void sinEstantesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sinEstantesStateChanged

    }//GEN-LAST:event_sinEstantesStateChanged

    private void indiferenteEstantesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_indiferenteEstantesStateChanged

    }//GEN-LAST:event_indiferenteEstantesStateChanged

    private void recargarListaDepositosConCondiciones() {
// Funciones Lambda Epicas para filtrar By fundamentos de computacion!
        if (indiferenteEstantes.isSelected() && indiferenteRefrigeracion.isSelected()) {

            Stream<Deposito> depsitosDesocupados = sistema.getDepositos().stream().filter(Deposito -> !Deposito.isOcupado() && Deposito.getTamaño() >= Integer.parseInt(campoMinimo.getText()) && Deposito.getTamaño() <= Integer.parseInt(campoMaximo.getText()));

            ListaDepositos.setListData(depsitosDesocupados.toArray());
        }

        if (indiferenteRefrigeracion.isSelected() && !indiferenteEstantes.isSelected()) {
            Stream<Deposito> depsitosRefrigerados = sistema.getDepositos().stream().filter(Deposito -> {
                return (Deposito.isEstantes() == conEstantes.isSelected() && Deposito.getTamaño() >= Integer.parseInt(campoMinimo.getText()) && Deposito.getTamaño() <= Integer.parseInt(campoMaximo.getText()));
            });

            ListaDepositos.setListData(depsitosRefrigerados.toArray());

        }

        if (indiferenteEstantes.isSelected() && !indiferenteRefrigeracion.isSelected()) {
            Stream<Deposito> todosLosDepositos = sistema.getDepositos().stream().filter(Deposito -> {
                return (Deposito.isRefrigerado() == conRefrigeracion.isSelected() && Deposito.getTamaño() >= Integer.parseInt(campoMinimo.getText()) && Deposito.getTamaño() <= Integer.parseInt(campoMaximo.getText()));
            });

            ListaDepositos.setListData(todosLosDepositos.toArray());

        }

        if (!indiferenteEstantes.isSelected() && !indiferenteRefrigeracion.isSelected()) {

            Stream<Deposito> todosLosDepositos = sistema.getDepositos().stream().filter(Deposito -> {
                return (Deposito.isRefrigerado() == conRefrigeracion.isSelected() && (Deposito.isEstantes() == conEstantes.isSelected()) && Deposito.getTamaño() >= Integer.parseInt(campoMinimo.getText()) && Deposito.getTamaño() <= Integer.parseInt(campoMaximo.getText()));
            });
            ListaDepositos.setListData(todosLosDepositos.toArray());

        }
//     ListaDepositos.getSelectedIndices() //retrona array de int 
       pintarJlist();
    }

    
    
    private void pintarJlist(){
    
    
     ListaDepositos.setCellRenderer(new DefaultListCellRenderer() {

            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (value instanceof Deposito) {
                        Deposito d = (Deposito) value;
//                       
                        if (d.isEstantes() && d.isRefrigerado()) {
                            setBackground(Color.GREEN);
                        } 
                        if (d.isEstantes() && !d.isRefrigerado()) {
                            setBackground(Color.ORANGE);
                        } 
                        if (!d.isEstantes() && d.isRefrigerado()) {
                            setBackground(Color.YELLOW);
                        } 
                        if (!d.isEstantes() && !d.isRefrigerado()) {
                            setBackground(Color.blue);
                        } 
                        
                if (isSelected) {
                    setBackground(getBackground().darker());
                }
                            } 
                return c;
            }

        });

    
    
    
    
    
    
    
    
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Estantes;
    private javax.swing.JList ListaClientes;
    private javax.swing.JList ListaDepositos;
    private javax.swing.JList ListaEmpleados;
    private javax.swing.ButtonGroup Refrigeracion;
    private javax.swing.JButton buscarDeposito;
    private javax.swing.JTextField campoDetalles;
    private javax.swing.JTextField campoMaximo;
    private javax.swing.JTextField campoMinimo;
    private javax.swing.JRadioButton conEstantes;
    private javax.swing.JRadioButton conRefrigeracion;
    private javax.swing.JRadioButton indiferenteEstantes;
    private javax.swing.JRadioButton indiferenteRefrigeracion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JRadioButton sinEstantes;
    private javax.swing.JRadioButton sinRefrigeracion;
    // End of variables declaration//GEN-END:variables
}
