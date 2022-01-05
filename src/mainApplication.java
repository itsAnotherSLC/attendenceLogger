package attedenceLoggerID;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartPanel;

import com.opencsv.CSVWriter;

public class mainApplication {

	private static JFrame mainFrame;
	private static DataPanel dataPanel;
	private static StudentListSource rosterSource;
	private static DataTable table;
	private static DataPlot plot;
	private static JPanel plotPanel;
	private static JSplitPane split;
	
	public static void main(String[] args) {
		buildMainFrame();
		buildMenuBar();
		configureSource();
		
		plotPanel = new JPanel();
		split = new JSplitPane(SwingConstants.VERTICAL, dataPanel, plotPanel);
		split.setResizeWeight(0.5d); //switch to 1d for when no graph is present
		mainFrame.add(split, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}
	
	public static void configureSource() {
		table = new DataTable();
		plot = new DataPlot();
		table.addDisplayableDataType(plot);
		dataPanel = new DataPanel(table);
		dataPanel.setLayout(new BorderLayout());
		rosterSource = new StudentListSource();
		rosterSource.addObserver(dataPanel);
	}
	
	public static void buildMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(900,900);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void buildTable(){
		JScrollPane sp=new JScrollPane(table.getTable());
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
        sp.setVerticalScrollBar(new JScrollBar());
       
        dataPanel.add(sp,BorderLayout.CENTER);
        mainFrame.setSize(2000,900);
	}
	
	public static void buildPlot(){
		System.out.println("------------------------------------------------------");
		plot = new DataPlot();
		plot.intializeDisplayable(table.getInfo());
		plotPanel.add(plot.getChart());
		mainFrame.setSize(2000,901);
		split.setResizeWeight(0.2d);
	}
	
	public static void saveData(String[][] data, String fileName) throws IOException{
		if(!fileName.contains(".csv")) {
			fileName = fileName + ".csv";
		}
		FileWriter outputfile = new FileWriter(fileName); 
		CSVWriter writer = new CSVWriter(outputfile);
		for(int i = 0 ; i < data.length ; i ++) {
			writer.writeNext(data[i]);
		}
		writer.close();
	}
	
	public static void buildMenuBar() {
		// create a menu 
		   JMenuBar mb = new JMenuBar();
	       JMenu x = new JMenu("File"); 
	       
	       // create menuitems 
	       JMenuItem  m1 = new JMenuItem("Load a Roster"); 
	       JMenuItem  m2 = new JMenuItem("Add Attendence"); 
	       JMenuItem  m3 = new JMenuItem("Save");
	       JMenuItem  m4 = new JMenuItem("Plot Data"); 
	       JMenuItem  y  = new JMenuItem("About"); 
	       
	       m2.setEnabled(false);
	       m3.setEnabled(false);
	       m4.setEnabled(false);
	       
	       // add menu items to menu 
	       x.add(m1); 
	       x.add(m2); 
	       x.add(m3); 
	       x.add(m4);

	  
	       // add menu to menu bar 
	       mb.add(x); 
	       mb.add(y);
	       
	       m1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser(new File("/Users/austinwright/eclipse-workspace-2020/AttendenceLoggerRebuild/src/main/resources/CSVs"));
					fc.setDialogTitle("Please select a .csv file");
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
						File newFile = fc.getSelectedFile();
						String newPath = newFile.getAbsolutePath();
						rosterSource.createStudentList(newPath);
						buildTable();
						m2.setEnabled(true);
						m3.setEnabled(true);
					}
				}
	       });
	       
	       m2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser(new File("/Users/austinwright/eclipse-workspace-2020/AttendenceLoggerRebuild/src/main/resources/CSVs"));
					fc.setDialogTitle("Please select an AttendenceFile");
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
						File newFile = fc.getSelectedFile();
						String newPath = newFile.getAbsolutePath();
						rosterSource.addAttendence(newPath);
						m4.setEnabled(true);
					}
				}
	       });
	       
	       m3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc;
				int saveMessage = JOptionPane.showConfirmDialog(mainFrame,"Would you like to save the current Roster?", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if(saveMessage == JOptionPane.YES_OPTION){
					fc = new JFileChooser(new File("/Users/austinwright/eclipse-workspace-2020/AttendenceLoggerRebuild/src/main/resources/CSVs"));
					fc.showSaveDialog(new JFrame());
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					 String[][] date = table.getTableContents();
		               try {
						saveData(date,fc.getSelectedFile().getName());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
	       });
	       
	       
	       m4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buildPlot(); 
			}
	    	   
	       });
	       mainFrame.setJMenuBar(mb); 
	}
}
