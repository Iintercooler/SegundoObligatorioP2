package Interfaz;

import Dominio.Contrato;
import Dominio.Deposito;
import Dominio.Sistema;
import Dominio.Visita;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class ConsultaDepositos extends javax.swing.JFrame implements Observer {

    Sistema sistema;

    public ConsultaDepositos(Sistema s) {
        this.sistema = s;

        initComponents();

        iniciar();
        sistema.addObserver(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        iniciar();
    }

    private class DepositoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton cual = ((JButton) e.getSource());
            String[] linea = cual.getText().split(":");
            int numero = Integer.parseInt(linea[1]);
            Deposito d = traerDatos(numero);
            Contrato c = traerContrato(numero);
            if (d.isOcupado()) {
                JOptionPane.showMessageDialog(null, d.toString() + " " + "\n"
                        + c.toString() + "\n"
                        + c.getCliente().toString() + "\n"
                        + "Cantidad de visitas al deposito:" + cantidadVisitas(d.getNumero()), "Consulta", -1);

            } else {
                JOptionPane.showMessageDialog(null, d.toString(), "Consulta", -1);

            }

        }
    }

    private Deposito traerDatos(int numero) {
        ArrayList<Deposito> depositos;
        depositos = this.sistema.getDepositos();
        Deposito d = null;
        for (int i = 0; i < depositos.size(); i++) {
            if (depositos.get(i).getNumero() == numero) {
                d = depositos.get(i);

            }

        }

        return d;

    }

    private Contrato traerContrato(int numeroDeposito) {
        ArrayList<Contrato> contratos;
        contratos = this.sistema.getContratos();
        Contrato c = null;
        for (int i = 0; i < contratos.size(); i++) {
            if (contratos.get(i).getDeposito().getNumero() == numeroDeposito) {
                c = contratos.get(i);

            }

        }
        return c;
    }

    private int cantidadVisitas(int numeroDeposito) {
        ArrayList<Visita> visitas;
        int cantidad = 0;
        visitas = sistema.getVisitas();

        for (int i = 0; i < visitas.size(); i++) {
            if (visitas.get(i).getDeposito().getNumero() == numeroDeposito) {
                cantidad++;

            }

        }

        return cantidad;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new java.awt.ScrollPane();
        panelDepositos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        scroll.setPreferredSize(new java.awt.Dimension(5000, 5000));

        panelDepositos.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                panelDepositosComponentAdded(evt);
            }
        });
        panelDepositos.setLayout(new java.awt.GridLayout());
        scroll.add(panelDepositos);

        getContentPane().add(scroll);
        scroll.setBounds(0, 90, 510, 180);

        jLabel1.setText("Consulta de Depositos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 190, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelDepositosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_panelDepositosComponentAdded

    }//GEN-LAST:event_panelDepositosComponentAdded

    private void iniciar() {
        panelDepositos.removeAll();
        ArrayList<Deposito> depositos = sistema.getDepositos();
        String numero;
        panelDepositos.setLayout(new GridLayout(0, 5));
       
        for (int i = 0; i < depositos.size(); i++) {
            numero = String.valueOf(depositos.get(i).getNumero());
            JButton b = new JButton(numero);
            b.addActionListener(new DepositoListener());
            b.setMargin(new Insets(-5, -5, -5, -5));
            b.setBackground(Color.BLACK);
            b.setForeground(Color.BLACK);
            b.setText("Num:" + depositos.get(i).getNumero());

            if (depositos.get(i).isOcupado()) {

                b.setBackground(Color.red);
                b.setOpaque(true);
            } else {

                b.setBackground(Color.GREEN);
                b.setOpaque(true);
            }
            panelDepositos.add(b); // se agrega el boton al panel

        }
        scroll.add(panelDepositos); // se agrega el scroll al panel
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelDepositos;
    private java.awt.ScrollPane scroll;
    // End of variables declaration//GEN-END:variables

}









//}
