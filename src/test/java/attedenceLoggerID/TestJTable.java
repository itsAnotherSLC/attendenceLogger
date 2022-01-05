package attedenceLoggerID;

import static org.junit.Assert.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.junit.Test;

public class TestJTable {

	@Test
	public void test() {
		  JPanel tablePanel = new JPanel();
	        tablePanel.setLayout(new BorderLayout());
	        
	        String data1[][]={    {"101","Javier","Gonazlas","Computer Sci","Grad","javiergs","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min","0 min"},    
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
	        jt.getColumnModel().getColumn(4).setPreferredWidth(100);
	        jt.getColumnModel().getColumn(5).setPreferredWidth(100);
	        
	        JScrollPane sp=new JScrollPane(jt);
	        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        sp.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
	        sp.setVerticalScrollBar(new JScrollBar());
	        JFrame f;     
	        f=new JFrame();
	        f.setLayout(new BorderLayout());
	        f.setSize(2000,1900);
	        f.addComponentListener(l);
	        f.setVisible(true);  
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
