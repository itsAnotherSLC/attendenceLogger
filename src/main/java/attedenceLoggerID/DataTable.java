package attedenceLoggerID;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DataTable extends displayableData {
	
	private JTable jt;
	private String column[] = {"ID","First Name", "Last Name", "Program", " Academic Level", "ASURITE"};
	private DefaultTableModel model;
	private String[] newAttendence;
	
	public JTable getTable() {
		return jt;
	}
	
	public void intializeDisplayable(String[][] dataTable) {
		super.intializeDisplayable(dataTable);
		model = new DefaultTableModel(dataTable,column);
		jt = new JTable(model);
		jt.setRowHeight(20);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jt.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt.getColumnModel().getColumn(3).setPreferredWidth(100);
		jt.setVisible(true);
	}
	
	public void addNewAttendence(String[][] attendence) {
		findNewAttendenceDate();
		
		newAttendence = new String[attendence.length];
		for(int i = 0 ; i < attendence.length ; i++) {
			newAttendence[i] = attendence[i][1];
		}
	}
	
	public void fillAttendence(String date) {
		model.addColumn(date, newAttendence);
		
		String[][] updatedTable = new String[model.getRowCount()][model.getColumnCount()];
		for(int i = 0 ; i < dataTable.length ; i++) {
			for(int j = 0 ; j < dataTable[0].length ; j++) {
				updatedTable[i][j] = (String) model.getValueAt(i, j);
			}
		}
		
		for(int i = 0 ; i < updatedTable.length ; i++) {
			updatedTable[i][model.getColumnCount() - 1] = newAttendence[i];
		}
		this.intializeDisplayable(updatedTable);
	}
	
	public void findNewAttendenceDate() {
		CalenderSelector datePane = new CalenderSelector();
        System.out.println("Select a date");
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
