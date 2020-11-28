package attedenceLoggerID;

import java.awt.Component;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

public abstract class AttendenceDisplayable  extends Component{
	
	protected String[][] dataTable;
	protected ArrayList<String> newNames;

	public void addAttendee(String[][] array) {
		dataTable = array;
	}
	
	public String[][] getInfo() {
		return dataTable;
	}
	
	public void updateDisplayable() {
	}
}
