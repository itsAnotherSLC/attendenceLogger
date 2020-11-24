package attedenceLoggerID;

import java.util.Arrays;
import java.util.Map;

import javax.swing.JTable;

public class AttendenceScatterPlot extends AttendenceDisplayable {
	
	private JTable jt;
	private String [][] data;
	private String column[];
	
	public AttendenceScatterPlot() {
		
		jt=new JTable(data,column);         
	    jt.setRowHeight(20);
	    jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    jt.getColumnModel().getColumn(0).setPreferredWidth(100);
	    jt.getColumnModel().getColumn(3).setPreferredWidth(100);
	}
	
	
	public void updateDisplayable() {
		int entries = 0;
		for(Map.Entry mapElement : AttendenceList.entrySet()) {	//For each entry in the hashmap
			 String[] nextInfo =(String[]) AttendenceList.get(mapElement.getKey());
			 
			 if(AttendenceList.containsKey(mapElement.getKey())) {
				 System.out.println("Duplicate Item!");
			 }
			 else {	//Insert item into next avalible row
				System.out.println("nextInfo:" + nextInfo);
				if(column.length == 0) {
					column = nextInfo;
				}
				else {
				 	data[entries] = nextInfo; 
				 }
			 }
			 entries++;
		}
	}
}
