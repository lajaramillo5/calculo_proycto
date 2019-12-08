/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derivada_sistemas_informatico;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author THE_PUNISHER
 */
public class Grafica {
    
    JFreeChart grafica;
    XYSeriesCollection datos = new XYSeriesCollection();
    String titulo;
    String etiquetax;
    String etiquetay;
    
    public Grafica(String t, String x, String y) {
        titulo = t;
        etiquetax = x;
        etiquetay = y;
        grafica = ChartFactory.createXYLineChart(titulo, x, y, datos, PlotOrientation.VERTICAL, true, true, true);
    }
    
    public Grafica() {
        this("Grafico", "x", "y");
    }

   
    
    public void agregarGrafica(String id, double[] x, double[] y) {
        XYSeries s = new XYSeries(id);
        int n = x.length;
        for (int i = 0; i < n; i++) {
            s.add(x[i], y[i]);
        }
        datos.addSeries(s);
    }

    public void crearGrafica(String id, double[] x, double[] y) {
        datos.removeAllSeries();
        agregarGrafica(id, x, y);
    }

    public JPanel ObtineGrafica() {
        return new ChartPanel(grafica);
        
    }
}
