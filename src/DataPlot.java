package attedenceLoggerID;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DataPlot extends DataDecorative{

	private ChartPanel chartPanel; 
	private JFreeChart chart;
	
	public DataPlot() {
	}
	
	public void updateDisplayable() {
		System.out.println("Update AttendenceScatterPlot");
	}
	
	public ChartPanel getChart(){
		return chartPanel;
	}
	
	public void intializeDisplayable(String[][] dataTable) {
		super.intializeDisplayable(dataTable); 
		
		  // create a chart...
	      chart = ChartFactory.createScatterPlot(
	    		   "Scatter Plot", 	// chart title
	               "Attendence %", 			// x axis label
	               "# of Students",				// y axis label
	               createDataset(), // data  
	               PlotOrientation.VERTICAL,
	               true, // include legend
	               true, // tooltips
	               false // urls
	      );
	      chartPanel = new ChartPanel(chart);
	}
	
	
	public XYSeriesCollection createDataset() {
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		double x;
		double y;
		for(int j = 6 ; j < dataTable[0].length ; j++) {
			XYSeries series = getSeries(j);		//new  XYSeries(months[j+1] + " " + getDay(header[j]));
			dataset.addSeries(series);
			System.out.println(" ");
		}
		return dataset;
	}
	
	public XYSeries getSeries(int column) {
		String[] months = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		XYSeries series = new XYSeries(header[column]);
		
		for(int i = 0 ; i < dataTable.length ; i++) {
			System.out.println("next Series: (" + dataTable[i][column] + ")");
			Double x = (Double.parseDouble(dataTable[i][column])/ 75 ) * 100; 
			Double y = Double.parseDouble(dataTable[i][column]);
            System.out.print(" (" + x + "," + y + ")");
            series.add(x,y);
		}
		return series;
	}
	
	private static int getDay(String nextMonth) {
		return Integer.parseInt(nextMonth.substring(4,nextMonth.length()));
	}
	
	private static int getMonth(String nextMonth) {
		
		String[] months = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		for(int i = 0 ; i < months.length ; i++) {
			 nextMonth = nextMonth.substring(0,3);
			if(nextMonth.compareTo(months[i]) == 0) {
				return (int) i + 1;
			}
		}
		return -1;
    }
}
