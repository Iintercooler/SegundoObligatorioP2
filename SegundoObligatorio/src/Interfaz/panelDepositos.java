
package Interfaz;

import Dominio.Sistema;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;












public class panelDepositos extends javax.swing.JFrame {
Sistema sistema;
   
    public panelDepositos(Sistema s) {
        this.sistema=s;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


//private void crearGrilla(){
//JButton nuevo = new JButton(" ");
// nuevo.setMargin(new Insets(-5, -5, -5, -5));
// nuevo.setBackground(Color.BLACK);
// nuevo.setForeground(Color.WHITE);
// nuevo.setText( "texto"); // texto ejemplo, a completar
// nuevo.addActionListener(new DepositoListener());
// panelDepositos.add(nuevo);


}







//}
