/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.ArchivoGrabacion;
import Dominio.Contrato;
import Dominio.Sistema;
import Dominio.Visita;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GestionContrato extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Sistema sistema;

//    public void cargaAutomatica() {
//
//        Contrato c = (Contrato) ListaContratos.getSelectedValue();
//        informacioCliente.setText(c.getCliente().toString());
//        informacionDeposito.setText(c.getDeposito().toString());
//        informacionEmpleado.setText(c.getEmpleado().toString());
//
//        Stream<Visita> visitasDelContrato = sistema.getVisitas().stream().filter(Visita -> Visita.getContrato().equals(c));
////
//        listaVisitas.setListData(visitasDelContrato.toArray());
////        
////        
//
//        ArrayList<Visita> v = new ArrayList<Visita>();
////        
//        for (int i = 0; i < visitasDelContrato.toArray().length; i++) {
//            v.add(visitasDelContrato.toList().get(i));
//
//        }
//        System.out.println(visitasDelContrato.toString());
////        
//
//    }
    public GestionContrato(Sistema s) {
        this.sistema = s;

        initComponents();
        recargarListaContratos();
    }

    private void recargarListaContratos() {

        ListaContratos.setListData(sistema.getContratos().toArray());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaContratos = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        informacioCliente = new javax.swing.JLabel();
        informacionEmpleado = new javax.swing.JLabel();
        informacionDeposito = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaInformacion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Gestion de contrator");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(128, 17, 129, 16);

        ListaContratos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaContratosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaContratos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(39, 80, 419, 152);

        jButton1.setText("Eliminar contrato");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(118, 250, 152, 29);

        jLabel2.setText("Visitas de el contrato seleccionado");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(510, 34, 219, 16);

        informacioCliente.setText("informacionCliente");
        getContentPane().add(informacioCliente);
        informacioCliente.setBounds(170, 290, 670, 30);

        informacionEmpleado.setText("InformacionEmpleado");
        getContentPane().add(informacionEmpleado);
        informacionEmpleado.setBounds(170, 360, 680, 16);

        informacionDeposito.setText("informacionDeposito");
        getContentPane().add(informacionDeposito);
        informacionDeposito.setBounds(170, 330, 680, 16);

        TablaInformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dia", "Mes", "Empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaInformacion);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(500, 80, 540, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Contrato c = (Contrato) ListaContratos.getSelectedValue();
        String nombre = c.getCliente().getNombre();
        String numero = String.valueOf(c.getNumero());
        String nombreArch = nombre + " " + numero;
        ArchivoGrabacion arch2 = new ArchivoGrabacion(nombreArch, false);
        Stream<Visita> visitasDelContrato = sistema.getVisitas().stream().filter(Visita -> Visita.getContrato().equals(c));
        ArrayList<Visita> v = visitasDelContrato.collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < v.size(); i++) {
            arch2.grabarLinea(v.get(i).toString());
        }

        arch2.cerrar();

        sistema.actualizarEstadoDeposito((Contrato) ListaContratos.getSelectedValue());
        eliminarVisitas();
        sistema.eliminarContrato((Contrato) ListaContratos.getSelectedValue());

        recargarListaContratos();
        DefaultTableModel modeloDefault = new DefaultTableModel(new String[]{"Dia", "Mes", "Empleado"}, 1);
        TablaInformacion.setModel(modeloDefault);

        informacioCliente.setText("Datos del Cliente:");
        informacionDeposito.setText("Datos del Deposito:");
        informacionEmpleado.setText("Datos del Empleado:");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ListaContratosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaContratosValueChanged

        try {
            cargarTabla();

        } catch (Exception e) {

        }


    }//GEN-LAST:event_ListaContratosValueChanged

    private void eliminarVisitas() {
        Contrato c = (Contrato) ListaContratos.getSelectedValue();
        Stream<Visita> visitasDelContrato = sistema.getVisitas().stream().filter(Visita -> Visita.getContrato().equals(c));
        ArrayList<Visita> v = visitasDelContrato.collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < v.size(); i++) {
            sistema.eliminarVisita(v.get(i));
        }

    }

    private void cargarTabla() {
        Contrato c = (Contrato) ListaContratos.getSelectedValue();

        informacioCliente.setText(c.getCliente().toString());
        informacionDeposito.setText(c.getDeposito().toString());
        informacionEmpleado.setText(c.getEmpleado().toString());

        Stream<Visita> visitasDelContrato = sistema.getVisitas().stream().filter(Visita -> Visita.getContrato().equals(c));

        ArrayList<Visita> v = visitasDelContrato.collect(Collectors.toCollection(ArrayList::new));

        DefaultTableModel modeloDefault = new DefaultTableModel(new String[]{"Dia", "Mes", "Empleado"}, v.size());
        TablaInformacion.setModel(modeloDefault);
        TableModel modeloDatos = TablaInformacion.getModel();

        for (int i = 0; i < v.size(); i++) {
            modeloDatos.setValueAt(v.get(i).getDia(), i, 0);
            modeloDatos.setValueAt(v.get(i).getMes(), i, 1);
            modeloDatos.setValueAt(v.get(i).getEmpleado().getNombre(), i, 2);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaContratos;
    private javax.swing.JTable TablaInformacion;
    private javax.swing.JLabel informacioCliente;
    private javax.swing.JLabel informacionDeposito;
    private javax.swing.JLabel informacionEmpleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
