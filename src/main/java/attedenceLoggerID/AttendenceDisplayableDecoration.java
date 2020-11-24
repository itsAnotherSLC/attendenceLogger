package attedenceLoggerID;

public abstract class AttendenceDisplayableDecoration extends AttendenceDisplayable{
	protected AttendenceDisplayable displayable;
	
	public void addDrawable(AttendenceDisplayable displayable) {
		this.displayable = displayable;
	}
	
	public void updateDisplayable() {
	}
}
