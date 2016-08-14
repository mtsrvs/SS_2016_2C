package tp1.plot;

import java.awt.RenderingHints;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.ApplicationFrame;

import tp1.model.Particle;

@SuppressWarnings("serial")
public class Graphic2D extends ApplicationFrame {

    private float[][] data;

    public Graphic2D(final String title, List<Particle> listParticle) {

        super(title);
        
        data = new float[2][listParticle.size()];
        
        populateData(listParticle);

        final NumberAxis domainAxis = new NumberAxis("X");
        domainAxis.setAutoRangeIncludesZero(false);
        final NumberAxis rangeAxis = new NumberAxis("Y");
        rangeAxis.setAutoRangeIncludesZero(false);
        final FastScatterPlot plot = new FastScatterPlot(this.data, domainAxis, rangeAxis);
        final JFreeChart chart = new JFreeChart("Fast Scatter Plot", plot);
        
//        XYPlot xyPlot = (XYPlot) chart.getPlot();
//        chart.setLegend(null);
        
//        xyPlot.setRangeCrosshairVisible(false);

        // force aliasing of the rendered content..
        chart.getRenderingHints().put
            (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final ChartPanel panel = new ChartPanel(chart, true);
        panel.setPreferredSize(new java.awt.Dimension(500, 270));
//      panel.setHorizontalZoom(true);
//      panel.setVerticalZoom(true);
        panel.setMinimumDrawHeight(10);
        panel.setMaximumDrawHeight(2000);
        panel.setMinimumDrawWidth(20);
        panel.setMaximumDrawWidth(2000);
        
        setContentPane(panel);

    }

    private void populateData(List<Particle> listParticle) {

        for (int i = 0; i < this.data[0].length; i++) {
            this.data[0][i] = listParticle.get(i).getPosition().getX();
            this.data[1][i] = listParticle.get(i).getPosition().getY();
        }

    }

//    public static void main(final String[] args) {
//
//        final TwoDGraphic demo = new TwoDGraphic("Fast Scatter Plot Demo");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//
//    }
}
