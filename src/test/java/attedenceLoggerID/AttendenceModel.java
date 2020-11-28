package attedenceLoggerID;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.junit.Test;


//Represents the attendence data functionality such as updating 
//it's displayPanel child which has a connected child of decoration
public class AttendenceModel implements Observer {
	protected HashMap<String, String[]> AttendenceList;
	protected AttendenceDisplayable displayable;
	
	public AttendenceModel() {
		displayable = new AttendenceScatterPlot();
		displayable.addDrawable(displayable);
	}
	
	
	public boolean addAttendee(String[] info) {
		String key = Arrays.toString(info);
		if(!AttendenceList.containsKey(key)) {
			AttendenceList.put(key, info);
			return true;
		}
		return false;
	}
	
	public boolean isFound(String[] info) {
		String key = Arrays.toString(info);
		if(!AttendenceList.containsKey(key)) {
			return true;
		}
		return false;
	}

	@Override
	public void update(Observable o, Object arg) {
		displayable.updateDisplayable();
		
	}
	
	
	
	

}
