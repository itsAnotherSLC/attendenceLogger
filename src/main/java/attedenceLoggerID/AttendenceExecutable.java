package attedenceLoggerID;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class AttendenceExecutable {

	private static JFrame mainFrame;
	
	public static void main(String[] args) {
		
		AttendenceExecutable application = new AttendenceExecutable();
		application.drawInterface();
		
	}

	
	public static void drawInterface() {
	    	AttendenceSource source = new AttendenceSource();
	    	AttendenceTable table = new AttendenceTable();
	    	AttendenceScatterPlot scatterPlot = new AttendenceScatterPlot();
		
		
			mainFrame = new JFrame();
			mainFrame.setLayout(new BorderLayout());
			 
			JPanel tablePanel = new JPanel();
			JPanel plotPanel = new JPanel();
			AttendencePanel attendencePanel = new AttendencePanel(table);
			table.addDrawable(scatterPlot);
			
			
			
			JSplitPane split = new JSplitPane(SwingConstants.VERTICAL, tablePanel, plotPanel);
			 
			Menu menu = new Menu();
			 
		    split.setResizeWeight(0.5d); //switch to 1d for when no graph is present
		    mainFrame.add(split);
			 
			 
			mainFrame.setSize(2000,1900);    
			mainFrame.setVisible(true);    
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 private static class Menu implements ActionListener{
		 
		private boolean includeRoster;
		private boolean attemptedSave;
			
		public Menu() {
			includeRoster = false;
			attemptedSave = false;
		
		   // create a menu 
		   JMenuBar mb = new JMenuBar();
	       JMenu x = new JMenu("File"); 
	       JMenu x1 = new JMenu("Sort by"); 
	       // create menuitems 
	       JMenuItem  m1 = new JMenuItem("Load a Roster"); 
	       JMenuItem  m2 = new JMenuItem("Add Attendence"); 
	       JMenuItem  m3 = new JMenuItem("Save");
	       JMenuItem  m4 = new JMenuItem("Plot Data"); 
	       JMenuItem  s1 = new JMenuItem("First Name"); 
	       JMenuItem  s2 = new JMenuItem("Level"); 
	       JMenuItem y = new JMenuItem("About"); 
	       
	      // add menu items to menu 
	       x.add(m1); 
	       x.add(m2); 
	       x.add(m3); 
	       x.add(m4);
	       x1.add(s1); 
	       x1.add(s2); 
	  
	       // add submenu 
	       x.add(x1); 
	  
	       // add menu to menu bar 
	       mb.add(x); 
	       mb.add(y);
	       
	       x.addActionListener(this);
	       y.addActionListener(this);
	       m1.addActionListener(this);
	       m2.addActionListener(this);
	       m3.addActionListener(this);
	       m4.addActionListener(this);
	       s1.addActionListener(this);
	       s2.addActionListener(this);
	        
	        // add menubar to frame 
	        mainFrame.setJMenuBar(mb); 
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			switch(e.getActionCommand()) {
			
			case "Load a Roster": 
				/*if(!attemptedSave) {
					int saveMessage = JOptionPane.showConfirmDialog(mainFrame,"Would you like to save the current Roster?", "Swing Tester",
				               JOptionPane.YES_NO_CANCEL_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					if(saveMessage == JOptionPane.YES_OPTION){
			              
			        }
					else if (saveMessage == JOptionPane.NO_OPTION){
			               
			            	
			        }
					else if (saveMessage == JOptionPane.CANCEL_OPTION){
			            	
			        }*/
				JFileChooser fc = new JFileChooser(new File("/Users/austinwright/eclipse-workspace-2020/attedenceLoggerID/src/main/resources/CSVs"));
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				break;
				
			case "Add Attendence":
			
			break;
			
			
			case "Save":
			
			break;
			
			case "Plot Data":
				
			break;
			
			case "First Name":
			
			break;
			
			case "Level":
			
			break;
			
			case "About":
				
			break;
			
			default : 
				System.out.println(e.getActionCommand());
			}
		}
		
	}
}
