package attedenceLoggerID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class DataTable extends displayableData {
	
	private JTable jt;
	private String column[] = {"ID","First Name", "Last Name", "Program", "ASURITE"};
	private DefaultTableModel model;
	
	public void intializeDisplayable(String[][] dataTable) {
		super.intializeDisplayable(dataTable);
		model = new DefaultTableModel(dataTable,column);
		jt = new JTable(model);
		jt.setRowHeight(20);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(3).setPreferredWidth(100);
		jt.setVisible(true);
	}
	
	public JTable getTable() {
		return jt;
	}
}
