package Interfaz;

import Dominio.Deposito;
import Dominio.Sistema;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Stream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Graficas extends javax.swing.JFrame implements Observer {

    Sistema sistema;
    DefaultPieDataset datos;
     ChartPanel panel;
     JFreeChart grafica;
    
    public Graficas(Sistema s) {
        this.sistema = s;
        initComponents();
        sistema.addObserver(this);
        cargarGrafica();
    

    }

    private void recargar(DefaultPieDataset datoss, ChartPanel panelp){
         
        Stream<Deposito> depositosNoNo = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && !Deposito.isEstantes() && !Deposito.isRefrigerado());
        Stream<Deposito> depositosNoSi = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && !Deposito.isEstantes() && Deposito.isRefrigerado());
        Stream<Deposito> depositosSiNo = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && Deposito.isEstantes() && !Deposito.isRefrigerado());
        Stream<Deposito> depositosSiSi = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && Deposito.isEstantes() && Deposito.isRefrigerado());

        int NoNo = depositosNoNo.toArray().length;
        int NoSi = depositosNoSi.toArray().length;
        int SiNo = depositosSiNo.toArray().length;
        int SiSi = depositosSiSi.toArray().length;
        
        
        datoss.clear();
        datoss.setValue("No refrigerados Sin estantes: " + NoNo, NoNo);
        datoss.setValue("No refrigerados Con estantes: " + NoSi, NoSi);
        datoss.setValue("Refrigerados Sin estantes: " + SiNo, SiNo);
        datoss.setValue("Refrigerados Con estantes: " + SiSi, SiSi);

       
       grafica = ChartFactory.createPieChart(
                "Depositos Alquilados",
                datoss,
                true,
                true,
                false
        );
        panelp = new ChartPanel(grafica);
        
        panelp.setMouseWheelEnabled(true);
        panelp.setPreferredSize(new Dimension(800, 400));

        Jpanel.setLayout(new BorderLayout());
        Jpanel.add(panel, BorderLayout.NORTH);
        pack();
        repaint();
    
    
    }
   
    
    
    
    private void cargarGrafica() {
        
        Stream<Deposito> depositosNoNo = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && !Deposito.isEstantes() && !Deposito.isRefrigerado());
        Stream<Deposito> depositosNoSi = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && !Deposito.isEstantes() && Deposito.isRefrigerado());
        Stream<Deposito> depositosSiNo = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && Deposito.isEstantes() && !Deposito.isRefrigerado());
        Stream<Deposito> depositosSiSi = sistema.getDepositos().stream().filter(Deposito -> Deposito.isOcupado() && Deposito.isEstantes() && Deposito.isRefrigerado());

        int NoNo = depositosNoNo.toArray().length;
        int NoSi = depositosNoSi.toArray().length;
        int SiNo = depositosSiNo.toArray().length;
        int SiSi = depositosSiSi.toArray().length;
//        int suma = NoNo + NoSi + SiNo + SiSi;

        datos = new DefaultPieDataset();
        datos.clear();
        datos.setValue("No refrigerados Sin estantes: " + NoNo, NoNo);
        datos.setValue("No refrigerados Con estantes: " + NoSi, NoSi);
        datos.setValue("Refrigerados Sin estantes: " + SiNo, SiNo);
        datos.setValue("Refrigerados Con estantes: " + SiSi, SiSi);

        JFreeChart grafica = ChartFactory.createPieChart(
                "Depositos Alquilados",
                datos,
                true,
                true,
                false
        );
        panel = new ChartPanel(grafica);
        
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
        getContentPane().setLayout(null);

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

        getContentPane().add(Jpanel);
        Jpanel.setBounds(27, 120, 826, 436);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Estadisticas de alquiler");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(298, 24, 339, 78);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        recargar(datos,panel);
        System.out.println("recaragar grafica");
        
    }
}
