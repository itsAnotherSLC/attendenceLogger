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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class mainApplication {

	private static JFrame mainFrame;
	private static DataPanel dataPanel;
	private static StudentListSource rosterSource;
	private static DataTable table;
	
	public static void main(String[] args) {
		buildMainFrame();
		buildMenuBar();
		configureSource();
		
		
		JSplitPane split = new JSplitPane(SwingConstants.VERTICAL, dataPanel, new JPanel());
		split.setResizeWeight(0.5d); //switch to 1d for when no graph is present
		mainFrame.add(split, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}
	
	public static void configureSource() {
		table = new DataTable();
		dataPanel = new DataPanel(table);
		rosterSource = new StudentListSource();
		rosterSource.addObserver(dataPanel);
	}
	
	public static void buildMainFrame() {
		mainFrame = new JFrame();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(500,600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void buildTable(){
		JScrollPane sp=new JScrollPane(table.getTable());
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
        sp.setVerticalScrollBar(new JScrollBar());       
        dataPanel.add(sp,BorderLayout.CENTER);
        mainFrame.setSize(500,601);
	}
	
	public static void buildMenuBar() {
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
	       JMenuItem  y  = new JMenuItem("About"); 
	       
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
	       
	       m1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser(new File("/Users/austinwright/eclipse-workspace-2020/attedenceLoggerID/src/main/resources/CSVs"));
					fc.setDialogTitle("Please select a .csv file");
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
						File newFile = fc.getSelectedFile();
						String newPath = newFile.getAbsolutePath();
						rosterSource.createStudentList(newPath);
						buildTable();
					}
				}
	       });
	       mainFrame.setJMenuBar(mb); 
	}

}
