package attedenceLoggerID;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class AttendenceScatterPlot extends AttendenceDisplayable {
	
	private ChartPanel plot; 
	private JFreeChart chart;
	
	public AttendenceScatterPlot() {
		 intializeChart();
		 plot = new ChartPanel(chart);
	}
	
	public void  updateDisplayable() {
		System.out.println("Update AttendenceScatterPlot");
	}
	
	public void intializeChart() {
		  // create a chart...
	      chart = ChartFactory.createScatterPlot(
	    		   "Scatter Plot", 	// chart title
	               "X", 			// x axis label
	               "Y",				// y axis label
	               createDataset(), // data  
	               PlotOrientation.VERTICAL,
	               true, // include legend
	               true, // tooltips
	               false // urls
	      );
	}
	
	public static XYDataset createDataset() {
		    Random r = new Random();
	        XYSeriesCollection result = new XYSeriesCollection();
	        XYSeries series = new XYSeries("Random");
	        for (int i = 0; i <= 100; i++) {
	            double x = r.nextDouble();
	            double y = r.nextDouble();
	            series.add(x, y);
	        }
	        result.addSeries(series);
	        return result;
	    }
}
