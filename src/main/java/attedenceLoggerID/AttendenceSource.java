package attedenceLoggerID;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Observable;

import com.opencsv.CSVReader;

public class AttendenceSource extends Observable{

	private String[] info = new String[6];
	
	public void createAttendence(String pathName) {
		
		try {
			CSVReader scanner = new CSVReader(new FileReader(pathName));
			String[] inputLine;
			
			while((inputLine = scanner.readNext()) != null) {
				if(inputLine != null) {
					if(scanner != null) {
						for(int i = 0 ; i < inputLine.length ; i++) {
							info[i] = inputLine[i];
							System.out.println("info["+ i + "]" + inputLine[i]);
						}
						System.out.println("Notifying Observers");
						setChanged();
						notifyObservers();
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public String[] getTableInfo() {
		return info;
	}
	
}
