package attedenceLoggerID;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.util.Arrays;

import org.jfree.data.io.CSV;
import org.junit.Test;

import com.opencsv.CSVReader;

public class EarlyDebugging {

	@Test
	public void test() {
		try {
			CSVReader reader = new CSVReader(new FileReader("/Users/austinwright/eclipse-workspace-2020/attedenceLoggerID/src/test/resources/JUnitEarlyDebugTest.csv"));
			String[]nextLine;
			String[] labels;
			
			labels = reader.readNext();
			System.out.println("LABELS: "+ Arrays.toString(labels));
			
			while((nextLine=reader.readNext()) != null) {
				if(nextLine != null) {
					if(nextLine != null) {
						for(int i = 0 ;i < nextLine.length ;i++) {
							System.out.println(i + ")" + nextLine[i]);
						}
					}
					System.out.println(" ");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Done");
	}

}
