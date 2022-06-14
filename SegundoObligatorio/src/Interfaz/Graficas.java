package Interfaz;

import Dominio.Deposito;
import Dominio.Sistema;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.stream.Stream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Graficas extends javax.swing.JFrame {

    Sistema sistema;

    public Graficas(Sistema s) {
        this.sistema = s;
        initComponents();

        Stream<Deposito> depositosNoNo = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && !Deposito.isEstantes() && !Deposito.isRefrigerado());
        Stream<Deposito> depositosNoSi = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && !Deposito.isEstantes() && Deposito.isRefrigerado());
        Stream<Deposito> depositosSiNo = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && Deposito.isEstantes() && !Deposito.isRefrigerado());
        Stream<Deposito> depositosSiSi = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && Deposito.isEstantes() && Deposito.isRefrigerado());

        int NoNo = depositosNoNo.toArray().length;
        int NoSi = depositosNoSi.toArray().length;
        int SiNo = depositosSiNo.toArray().length;
        int SiSi = depositosSiSi.toArray().length;
        int suma = NoNo + NoSi + SiNo + SiSi;

        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("No refrigerados Sin estantes: " + NoNo, NoNo);
        datos.setValue("No refrigerados Con estantes: " + NoSi, NoSi);
        datos.setValue("Refrigerados Sin estantes: " + SiNo, SiNo);
        datos.setValue("Refrigerados Con estantes: " + SiSi, SiSi);

        JFreeChart grafica = ChartFactory.createPieChart(
                "Depositos Alquilados: " + suma,
                datos,
                true,
                true,
                false
        );
        ChartPanel panel = new ChartPanel(grafica);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(800, 400));

        Jpanel.setLayout(new BorderLayout());
        Jpanel.add(panel, BorderLayout.NORTH);
        pack();
        repaint();

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        jLabel1.setText("Estadisticas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
