package attedenceLoggerID;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class AttendenceDisplayable {
	
	protected HashMap<String, String[]> AttendenceList;
	
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
	

	public void updateDisplayable() {
		
		
	}
}
