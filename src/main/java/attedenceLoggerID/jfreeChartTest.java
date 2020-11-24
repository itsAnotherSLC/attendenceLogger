package attedenceLoggerID;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * A simple introduction to using JFreeChart. This demo is described in the
 * JFreeChart Developer Guide.
 */
public class jfreeChartTest{
    

	
	private static final Random r = new Random();
	
    public static void main(String[] args) {
       
       
        // Create a JTable 
        JFrame f;     
        f=new JFrame();
        f.setLayout(new BorderLayout());
        
      //Table Panel on top portion of "f"'s grid layout
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        
        String data1[][]={    {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
        					  {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},  
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}, 
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
                              {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"}};    
        String column[]=	  {"ID","First Name","LastName","Program","Level","ASURITE","Nov 3rd","Nov 6rd","Nov 9rd","Nov 11rd","Nov 3rd","Nov 6rd","Nov 9rd","Nov 11rd","Nov 3rd","Nov 6rd","Nov 9rd"};         
        JTable jt=new JTable(data1,column);         
        jt.setRowHeight(20);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jt.getColumnModel().getColumn(0).setPreferredWidth(100);
        jt.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        
        JScrollPane sp=new JScrollPane(jt);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
        sp.setVerticalScrollBar(new JScrollBar());          
        
        
     // create a menubar 
       JMenuBar mb = new JMenuBar(); 
  
     // create a menu 
       JMenu x = new JMenu("Menu"); 
       JMenu y = new JMenu("About"); 
       JMenu x1 = new JMenu("submenu"); 
   // create menuitems 
       JMenuItem  m1 = new JMenuItem("MenuItem1"); 
       JMenuItem  m2 = new JMenuItem("MenuItem2"); 
       JMenuItem  m3 = new JMenuItem("MenuItem3"); 
       JMenuItem  s1 = new JMenuItem("SubMenuItem1"); 
       JMenuItem  s2 = new JMenuItem("SubMenuItem2"); 
       
       
                 
       
  // create a chart...
       JFreeChart chart = ChartFactory.createScatterPlot(
    		   "Scatter Plot", // chart title
               "X", // x axis label
               "Y", // y axis label
               jfreeChartTest.createDataset(), // data  ***-----PROBLEM------***
               PlotOrientation.VERTICAL,
               true, // include legend
               true, // tooltips
               false // urls
               );
       // create and display a frame...
       ChartPanel plot = new ChartPanel(chart);
       //JPanel plot = new JPanel(); //empty plot panel test 
       
        // add menu items to menu 
        x.add(m1); 
        x.add(m2); 
        x.add(m3); 
        x1.add(s1); 
        x1.add(s2); 
  
        // add submenu 
        x.add(x1); 
  
        // add menu to menu bar 
        mb.add(x); 
        mb.add(y);
        
        // add menubar to frame 
        f.setJMenuBar(mb); 
        
        
        //add scroll pane with a Jtable
        tablePanel.add(sp,BorderLayout.CENTER);
  
        JSplitPane split = new JSplitPane(SwingConstants.VERTICAL, tablePanel, plot);
        split.setResizeWeight(0.5d); //switch to 1d for when no graph is present
        f.add(split);
        /*//add on left of border layout
        f.add(tablePanel,BorderLayout.WEST);
        
        // Frame with scatter plot on bottom
        f.add(plot,BorderLayout.EAST);*/
        
        f.setSize(2000,1900);    
        f.setVisible(true);    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
        
        
        
        // creating a hash table 
        Hashtable<Integer, String> h = new Hashtable<Integer, String>(); 
  
        Hashtable<Integer, String> h1 =  new Hashtable<Integer, String>(); 
  
        h.put(3, "Geeks"); 
        h.put(2, "forGeeks"); 
        h.put(1, "isBest"); 
  
        // create a clone or shallow copy of hash table h 
        h1 = (Hashtable<Integer, String>)h.clone(); 
  
        // checking clone h1 
        System.out.println("values in clone: " + h1); 
  
        // clear hash table h 
        h.clear(); 
  
        // checking hash table h 
        System.out.println("after clearing: " + h);
        
        
        

    }
    
    private static XYDataset createDataset() {
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
