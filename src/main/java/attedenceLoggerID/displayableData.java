package attedenceLoggerID;

import java.awt.Component;

public class displayableData extends Component{
	protected String[][] dataTable;
	
	public void intializeDisplayable(String[][] dataTable) {
		this.dataTable = dataTable;
	}
	
	public String[][] getInfo() {
		return dataTable;
	}
	
	public void printDataTable() {
		for(int i = 0 ; i < dataTable.length ; i++) {
			for(int j = 0 ; j < dataTable[0].length ; j++) {
				System.out.print(dataTable[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
}
