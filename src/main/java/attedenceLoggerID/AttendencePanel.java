package attedenceLoggerID;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class AttendencePanel extends JPanel implements Observer {
	
	protected AttendenceDisplayable displayable;
	
	
	public AttendencePanel(AttendenceDisplayable displayable) {
		this.displayable = displayable;
		
		
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		displayable.updateDisplayable();
	}

}
