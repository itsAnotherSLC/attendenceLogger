package attedenceLoggerID;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class AttendencePanel extends JPanel implements Observer {
	
	protected AttendenceDisplayable displayable;
	
	public AttendenceDisplayable getDisplayable() {
		return displayable;
	}
	
	public AttendencePanel(AttendenceDisplayable displayable) {
		this.displayable = displayable;
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void update(Observable o, Object arg) {
		displayable.addAttendee((String[][])arg);
		displayable.updateDisplayable();
	}
	
}
