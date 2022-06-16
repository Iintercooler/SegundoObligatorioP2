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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class ConsultaDepositos extends javax.swing.JFrame {

    Sistema sistema;

    public ConsultaDepositos(Sistema s) {
        this.sistema = s;

        initComponents();

        iniciar();

    }

    private class DepositoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JButton cual = ((JButton) e.getSource());
            String[] linea = cual.getText().split(":");
            int numero = Integer.parseInt(linea[1]);
            Deposito d = traerDatos(numero);
            Contrato c=traerContrato(numero);
            System.out.println(d.isOcupado());
            System.out.println(d.getNumero());
            if(d.isOcupado()){
            JOptionPane.showMessageDialog(null, d.toString()+" "+"\n"
                    +c.toString() +"\n"
                    +c.getCliente().toString() +"\n"
                    +"Cantidad de visitas al deposito:" + cantidadVisitas(d.getNumero()), "Consulta", -1);
               
            }else{
                  JOptionPane.showMessageDialog(null, d.toString(), "Consulta", -1);
                
            }
            
            
            
            

        }
    }

    private Deposito traerDatos(int numero) {
        ArrayList<Deposito> depositos;
        depositos = this.sistema.getDepositos();
        Deposito d=null;
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
        Contrato c=null;
        for (int i = 0; i < contratos.size(); i++) {
            if (contratos.get(i).getDeposito().getNumero() == numeroDeposito) {
                c=contratos.get(i);

            }

        }
        return c;
    }

    private int cantidadVisitas(int numeroDeposito){
     ArrayList<Visita> visitas;
     int cantidad=0;
        visitas=sistema.getVisitas();
        
        for (int i = 0; i < visitas.size(); i++) {
            if(visitas.get(i).getDeposito().getNumero()==numeroDeposito){
            cantidad++;
            
            }
            
        }
        
        return cantidad;
        
    }

    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDepositos = new javax.swing.JPanel();
        scroll = new java.awt.ScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelDepositos.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                panelDepositosComponentAdded(evt);
            }
        });
        panelDepositos.setLayout(new java.awt.GridLayout());

        scroll.setPreferredSize(new java.awt.Dimension(5000, 5000));

        jLabel1.setText("Consulta de Depositos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelDepositos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(panelDepositos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelDepositosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_panelDepositosComponentAdded

    }//GEN-LAST:event_panelDepositosComponentAdded

    private void iniciar() {

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
            b.setText("Num:" + depositos.get(i).getNumero()); // texto ejemplo, a completar

            if (depositos.get(i).isOcupado()) {

                b.setBackground(Color.red);
                b.setOpaque(true);
            } else {

                b.setBackground(Color.GREEN);
                b.setOpaque(true);
            }
            panelDepositos.add(b);

        }
        scroll.add(panelDepositos);

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
