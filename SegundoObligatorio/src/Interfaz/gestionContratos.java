/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Contrato;
import Dominio.Deposito;
import Dominio.Sistema;
import Dominio.Visita;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class gestionContratos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Sistema sistema;

    public void cargaAutomatica() {

        Contrato c = (Contrato) ListaContratos.getSelectedValue();
        informacioCliente.setText(c.getCliente().toString());
        informacionDeposito.setText(c.getDeposito().toString());
        informacionEmpleado.setText(c.getEmpleado().toString());

        Stream<Visita> visitasDelContrato = sistema.getVisitas().stream().filter(Visita -> Visita.getContrato().equals(c));
//
        listaVisitas.setListData(visitasDelContrato.toArray());
//        
//        

        ArrayList<Visita> v = new ArrayList<Visita>();
//        
        for (int i = 0; i < visitasDelContrato.toArray().length; i++) {
            v.add(visitasDelContrato.toList().get(i));

        }
        System.out.println(visitasDelContrato.toString());
//        


    }

    public gestionContratos(Sistema s) {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listaVisitas = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        informacioCliente = new javax.swing.JLabel();
        informacionEmpleado = new javax.swing.JLabel();
        informacionDeposito = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaInformacion = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Gestion de contrator");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(128, 17, 129, 16);

        ListaContratos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
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

        listaVisitas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaVisitas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(490, 80, 319, 150);

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
        jScrollPane3.setBounds(520, 280, 320, 110);

        jButton2.setText("CArgar la maldita tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 460, 188, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sistema.actualizarEstadoDeposito((Contrato) ListaContratos.getSelectedValue());
        sistema.eliminarContrato((Contrato) ListaContratos.getSelectedValue());

        recargarListaContratos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ListaContratosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaContratosValueChanged

        try {
            Contrato c = (Contrato) ListaContratos.getSelectedValue();
            informacioCliente.setText(c.getCliente().toString());
            informacionDeposito.setText(c.getDeposito().toString());
            informacionEmpleado.setText(c.getEmpleado().toString());

            Stream<Visita> visitasDelContrato = sistema.getVisitas().stream().filter(Visita -> Visita.getContrato().equals(c));

            listaVisitas.setListData(visitasDelContrato.toArray());

        } catch (Exception e) {
            
        }


    }//GEN-LAST:event_ListaContratosValueChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         Contrato c = (Contrato) ListaContratos.getSelectedValue();
            informacioCliente.setText(c.getCliente().toString());
            informacionDeposito.setText(c.getDeposito().toString());
            informacionEmpleado.setText(c.getEmpleado().toString());

            Stream<Visita> visitasDelContrato = sistema.getVisitas().stream().filter(Visita -> Visita.getContrato().equals(c));

            listaVisitas.setListData(visitasDelContrato.toArray());
        
        
        
         Object[] v= visitasDelContrato.toArray().clone();
        
//        for (int i = 0; i < visitasDelContrato.toArray().length; i++) {
//            v.add(visitasDelContrato.toList().get(i));
//            
//        }
        
        
        
//        DefaultTableModel modeloDefault = new DefaultTableModel(new String[]{"Dia", "Mes", "Empleado"}, v.length);
//        TablaInformacion.setModel(modeloDefault);
//
//    
//        
//        
//        
//        TableModel modeloDatos = TablaInformacion.getModel();
//        for (int i = 0; i < v.size(); i++) {
//            Visita visita = v.get(i);
//            modeloDatos.setValueAt(visita.getDia(), i, 0);
//            modeloDatos.setValueAt(visita.getMes(), i, 1);
//            modeloDatos.setValueAt(visita.getEmpleado().toString(), i, 2);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaContratos;
    private javax.swing.JTable TablaInformacion;
    private javax.swing.JLabel informacioCliente;
    private javax.swing.JLabel informacionDeposito;
    private javax.swing.JLabel informacionEmpleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaVisitas;
    // End of variables declaration//GEN-END:variables
}
