package attedenceLoggerID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.opencsv.CSVReader;

public class AttendenceSource extends Observable{

	List<List<String>> list = new ArrayList<List<String>>();

	
	public void createAttendence(String pathName) {
		//https://stackoverflow.com/questions/18055889/extract-data-from-csv-file-and-put-to-2d-array-refactoring
		String[][] array2D = new String[10][10];
		try (CSVReader reader = new CSVReader(new BufferedReader(new FileReader(pathName)));) {
		    List<String[]> lines = reader.readAll();
		    array2D = lines.toArray(new String[lines.size()][]);
		    
		}catch(Exception e) {
			System.out.println(e);
		}
		setChanged();
		notifyObservers(array2D);
	}
}
