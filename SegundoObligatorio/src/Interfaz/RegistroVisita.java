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
import Dominio.Visita;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class RegistroVisita extends javax.swing.JFrame implements Observer {

    Sistema sistema;

    public RegistroVisita(Sistema s) {
        this.sistema = s;

        initComponents();
        listaEmpleados.setListData(sistema.getEmpleados().toArray());
        listaClientes.setListData(sistema.getClientes().toArray());
        sistema.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaClientes = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaContratos = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        campoDia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoMes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Registro de visitas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(374, 6, 277, 57);

        listaClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaClientesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaClientes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(64, 81, 490, 159);

        jLabel2.setText("Lista de clientes");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(64, 47, 102, 16);

        jScrollPane2.setViewportView(listaContratos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(650, 70, 388, 159);

        jLabel3.setText("Lista de contratos del cliente seleccionado");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(690, 40, 268, 16);

        jScrollPane3.setViewportView(listaEmpleados);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(64, 293, 490, 210);

        jLabel4.setText("Lista de Empleados");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(64, 271, 121, 16);
        getContentPane().add(campoDia);
        campoDia.setBounds(718, 258, 86, 26);

        jLabel5.setText("Dia");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(687, 263, 21, 16);
        getContentPane().add(campoMes);
        campoMes.setBounds(718, 290, 86, 26);

        jLabel6.setText("Mes");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(687, 295, 25, 16);

        jButton1.setText("Registrar visita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(750, 380, 138, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClientesValueChanged
        listaContratos.setListData(sistema.getContratos().toArray());
        Cliente c;
        c = (Cliente) listaClientes.getSelectedValue();

        Stream<Contrato> contratosCliente = sistema.getContratos().stream().filter(Contrato -> Contrato.getCliente().getCedula() == c.getCedula());

        listaContratos.setListData(contratosCliente.toArray());


    }//GEN-LAST:event_listaClientesValueChanged

//    Deposito deposito, Cliente cliente, Empleado empleado, int dia, int mes
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (listaClientes.getSelectedIndex() == -1 || listaContratos.getSelectedIndex() == -1 || listaEmpleados.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento de cada lista", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                Contrato c = (Contrato) listaContratos.getSelectedValue();
                Deposito d = c.getDeposito();
                Cliente cl = c.getCliente();
                Empleado e = c.getEmpleado();
                int dia = Integer.parseInt(campoDia.getText());
                int mes = Integer.parseInt(campoMes.getText());
                Visita v = new Visita(d, cl, e, dia, mes, c);
                sistema.agregarVisita(v);
                 JOptionPane.showMessageDialog(null, "Visita registrada", "Registro Exitoso", -1);
                 campoDia.setText("");
                 campoMes.setText("");
                 
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Campos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoDia;
    private javax.swing.JTextField campoMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaClientes;
    private javax.swing.JList listaContratos;
    private javax.swing.JList listaEmpleados;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        listaEmpleados.setListData(sistema.getEmpleados().toArray());
        listaClientes.setListData(sistema.getClientes().toArray());
        System.out.println("se elimio un contrato de cliente");
    }
}
