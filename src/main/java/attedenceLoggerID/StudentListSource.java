package attedenceLoggerID;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Observable;

import com.opencsv.CSVReader;

public class StudentListSource extends Observable {
	
	private String[][] dataArray;
	
	
	public String[][] getData(){
		return dataArray;
	}

	public void createStudentList(String pathName) {
		dataArray = new String[10][10];
		boolean newData = true;
		
		
		try (CSVReader reader = new CSVReader(new BufferedReader(new FileReader(pathName)));) {
		    List<String[]> lines = reader.readAll();
		    dataArray = lines.toArray(new String[lines.size()][]);
		    
		}catch(Exception e) {
			System.out.println(e);
		}
		setChanged();
		notifyObservers(newData);
	}
	
	
	public void addAttendence(String pathName) {
		dataArray = new String[10][10];
		boolean newData = false;
		
		
		try (CSVReader reader = new CSVReader(new BufferedReader(new FileReader(pathName)));) {
		    List<String[]> lines = reader.readAll();
		    dataArray = lines.toArray(new String[lines.size()][]);
		    
		}catch(Exception e) {
			System.out.println(e);
		}
		setChanged();
		notifyObservers(newData);
	}
	
}
