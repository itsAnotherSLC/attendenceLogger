package attedenceLoggerID;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AttendenceDisplayable {
	
	protected HashMap<String, String[]> AttendenceList;
	protected AttendenceDisplayable displayable;
	
	public boolean addAttendee(String[] info) {
		String key = Arrays.toString(info);
		if(!AttendenceList.containsKey(key)) {
			AttendenceList.put(key, info);
			return true;
		}
		return false;
	}
	
	public void addDisplayable(AttendenceDisplayable displayable) {
		this.displayable = displayable;
	}
	
	public boolean isFound(String[] info) {
		String key = Arrays.toString(info);
		if(!AttendenceList.containsKey(key)) {
			return true;
		}
		return false;
	}
	

	public void updateDisplayable() {
		
		
	}
}
