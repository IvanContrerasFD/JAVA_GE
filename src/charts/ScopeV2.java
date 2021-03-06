package charts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author J. M. Colmenar
 */
public class ScopeV2 extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    protected XYSeries serieAct;
    protected XYSeries seriePrd;
  //  protected XYSeries serieMA1;


    /**
     * Creates new form ScopeV2
     */
    public ScopeV2(String windowsTitle, String title, String xTitle, String yTitle, int size, int idx) {
        super(windowsTitle);

        initComponents();

        createInputDataChart(title, xTitle, yTitle);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        super.pack();
        int largoMax=6;
        		
        
        int i=idx%largoMax;
        int j=idx/largoMax;
        
        RefineryUtilities.positionFrameOnScreen(this, 0.2*i, 0.35*j);
        this.setVisible(true);
    }

    private void createInputDataChart(String title, String xTitle, String yTitle) {
        // Panel for plotting data
        this.panelPlotInput.setLayout(new java.awt.BorderLayout());

        XYSeriesCollection dataSet = new XYSeriesCollection();

   
      //  serieMA1 = new XYSeries(yTitle + " - MA1");
        serieAct = new XYSeries(yTitle + " - Actual");
        seriePrd = new XYSeries(yTitle + " - Predicted");
        
        dataSet.addSeries(serieAct);
        dataSet.addSeries(seriePrd); 
     //   dataSet.addSeries(serieMA1);
        
        JFreeChart chart = ChartFactory.createXYLineChart(title, xTitle, yTitle, dataSet, PlotOrientation.VERTICAL, true, false, false);
        chart.getXYPlot().setDomainAxis(new NumberAxis());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(panelPlotInput.getWidth(), panelPlotInput.getHeight()));
        chartPanel.setMouseZoomable(true, false);

        XYPlot plot = (XYPlot) chart.getPlot(); 
        plot.setBackgroundPaint(Color.white); 
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY); 
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY); 
        DeviationRenderer renderer = new DeviationRenderer(true, false); 
        renderer.setSeriesPaint(0, new Color(0,0,0)); 
        renderer.setSeriesPaint(1, new Color(250,100,0)); 
        renderer.setSeriesPaint(2, new Color(195,25,0)); 
        renderer.setSeriesPaint(3, new Color(150,250,250)); 
        plot.setRenderer(renderer); 
        plot.setDomainCrosshairVisible(true); 
        plot.setRangeCrosshairVisible(true); 
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis(); 
        yAxis.setAutoRangeIncludesZero(false); 
     
        panelPlotInput.add(chartPanel, java.awt.BorderLayout.CENTER);
        panelPlotInput.validate();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPlotInput = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStats = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();

        panelPlotInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelPlotInputLayout = new javax.swing.GroupLayout(panelPlotInput);
        panelPlotInput.setLayout(panelPlotInputLayout);
        panelPlotInputLayout.setHorizontalGroup(
            panelPlotInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPlotInputLayout.setVerticalGroup(
            panelPlotInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        txtStats.setColumns(20);
        txtStats.setRows(5);
        jScrollPane1.setViewportView(txtStats);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()               
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPlotInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPlotInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPlotInput;
    private javax.swing.JTextArea txtStats;
    // End of variables declaration//GEN-END:variables

    public void addComment(String str) {
        this.txtStats.setText(this.txtStats.getText().concat(str));
    }

    public void addPointAct(double x, double y) {
        serieAct.add(x, y);
    }

    public void addPointPrd(double x, double y) {
        seriePrd.add(x, y);
    }
    
    
  /*  public void addPointMA1(double x, double y) {
        serieMA1.add(x, y);
    }
*/

    public void clear() {
        List items = serieAct.getItems();
        for (Object item : items) {
            ((XYDataItem) item).setY(0);
        }
        items = seriePrd.getItems();
        for (Object item : items) {
            ((XYDataItem) item).setY(0);
        }
    }

}
