package attedenceLoggerID;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DataTable extends DataDecorative {
	private JTable jt;
	private DefaultTableModel model;
	private String[] newAttendence;
	
	public JTable getTable() {
		return jt;
	}
	
	public void intializeDisplayable(String[][] dataTable) {
		super.intializeDisplayable(dataTable);
		model = new DefaultTableModel(dataTable,header);
		jt = new JTable(model);
		jt.setRowHeight(20);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(3).setPreferredWidth(100);
		jt.setVisible(true);
		model.fireTableDataChanged();
	}
	
	public void addNewAttendence(String[][] attendence) {
		findNewAttendenceDate();
		ArrayList<String> unusedIDs = new ArrayList<String>();
		newAttendence = new String[dataTable.length];
		
		Stack newIDs = new Stack();
		int count = 0;
		
		for(int i = 0 ; i < attendence.length ; i++) {
			newIDs.push(attendence[i][0]);
		}
		
		while(!newIDs.empty())
		{
			String nextID = (String) newIDs.pop();
			int sum = 0;
			if(isFound(nextID) != -1) {
				
			for(int i = 0 ; i < attendence.length ; i++) {
				if(nextID.compareTo(attendence[i][0]) == 0){
					sum += Integer.parseInt(attendence[i][1]); 
				}
			}
			if(sum >= 0 && isFound(nextID) != -1) {
					newAttendence[isFound(nextID)] = sum + " ";
				}
			}
			else {
				unusedIDs.add(attendence[count][0] + "," + attendence[count][1]);
			}
			count++;
		}
		String message = "Data Loaded for " + newAttendence.length + " users in the roster. ";
		ImageIcon icon = new ImageIcon("/Users/austinwright/eclipse-workspace-2020/AttendenceLoggerRebuild/src/main/resources/Tick.png");
		message += "\n"+ unusedIDs.size() + " additional attendee(s) located: \n";
		for(int i = 0 ; i < unusedIDs.size() ; i++) {
		message += unusedIDs.get(i).substring(0,unusedIDs.get(i).indexOf(",")) 
				+ "," + " connected for " + unusedIDs.get(i).substring(unusedIDs.get(i).indexOf(",") + 1,unusedIDs.get(i).length()) 
				+ " minute(s) ";
		}
		JOptionPane.showMessageDialog(null, message, "", 0, icon);
	}
	
	public int isFound(String id) {
		Long newID = Long.parseLong(id);
		for(int i = 0 ; i < dataTable.length ; i++) {
			Long nextID = Long.parseLong(dataTable[i][5]);
			if(newID.compareTo(nextID) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public void fillAttendence(String date) {
		model.addColumn(date, newAttendence);
		
		String[] newColumn = new String[header.length + 1];
		for(int i = 0 ; i < header.length ; i++) {
			newColumn[i] = header[i];
		}
		newColumn[newColumn.length - 1] = date;
		header = newColumn;
	}
	
	public String[][] getTableContents() {
		String[][] updatedTable = new String[model.getRowCount() + 1][model.getColumnCount()];
		
		for(int i = 0 ; i < updatedTable[0].length ; i++) {
			updatedTable[0] = header;
		}
		
		for(int i = 1 ; i < dataTable.length ; i++) {
			for(int j = 0 ; j < dataTable[0].length ; j++) {
				updatedTable[i][j] = (String) model.getValueAt(i, j);
			}
		}
		return updatedTable;
	}
	
	public void updateTable() {
		String[][] updatedTable = new String[model.getRowCount()][model.getColumnCount()];
		for(int i = 0 ; i < dataTable.length ; i++) {
			for(int j = 0 ; j < dataTable[0].length ; j++) {
				updatedTable[i][j] = (String) model.getValueAt(i, j);
			}
		}
		
		for(int i = 0 ; i < updatedTable.length ; i++) {
			updatedTable[i][model.getColumnCount() - 1] = newAttendence[i];
		}
		dataTable = updatedTable;
	}
	
	public void findNewAttendenceDate() {
		CalenderSelector datePane = new CalenderSelector();
	}
	
	public class CalenderSelector extends JFrame {
		
        public CalenderSelector() {
            UtilDateModel dateModel = new UtilDateModel();
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
            JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
            DateLabelFormatter dlf = new DateLabelFormatter();
            JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, dlf);
            JButton submitDate = new JButton("Submit");
       
            submitDate.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                	if(dlf.getDate() != null) {
                    	fillAttendence(dlf.getDate());
                    	dispose();
                    	model.fireTableDataChanged();
                    	updateTable();
                	}
                }
            });
            setLayout(new GridBagLayout());
            add(datePicker);
            add(submitDate);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
            
      }

        public class DateLabelFormatter extends AbstractFormatter {
		
		    private String datePattern = "MMM-dd";
		    private String date;
		    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
		    
		    public String getDate() {
		    	return date;
		    }
		
		    @Override
		    public Object stringToValue(String text) throws ParseException {
		        return dateFormatter.parseObject(text);
		    }
		
		    @Override
		    public String valueToString(Object value) throws ParseException {
		        if (value != null) {
		            Calendar cal = (Calendar) value;
		            date = dateFormatter.format(cal.getTime());
		            return dateFormatter.format(cal.getTime());
		        }
		        return "";
		    }
		}
	}
	
	
	
}
