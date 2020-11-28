package attedenceLoggerID;

import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AttendenceTable extends AttendenceDisplayable {
	
	private JTable jt;
	private String [][] data;
	private String column[];
	
	public AttendenceTable() {
		jt=new JTable();    
	}
	
	public JTable getTable() {
		return jt;
	}
	
	public void intializeTable() {
		jt=new JTable(new DefaultTableModel(data,column));    
	    jt.setRowHeight(20);
	    jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    jt.getColumnModel().getColumn(0).setPreferredWidth(100);
	    jt.getColumnModel().getColumn(3).setPreferredWidth(100);
	    jt.setVisible(true);
	}

	public boolean isFound(String[] info) {
		int count = 0;
		while(count < data.length){
			if(Arrays.equals(data[count],info)){
				return true;
			}
			count++;
		}
		return false;
	}
	
	public void updateDisplayable() {
		column =dataTable[0];
		data = new String[dataTable.length][column.length];
		data = Arrays.copyOfRange(dataTable, 1, dataTable.length);
	}
	
	
	
	
	
}
	
