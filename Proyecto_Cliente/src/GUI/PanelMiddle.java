package GUI;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelMiddle extends JPanel{
	
	private DefaultTableModel dtm;
	private JTable table;
	
	public PanelMiddle() {
		super();
		setLayout(new GridLayout(1, 1));
		beginComponents();
		addComponents();
	}
	
	public void addRow(Object[] row) {
		dtm.addRow(row);
	}
	
	private void beginComponents() {
		String[] titles = { " Nombre "};
		dtm = new DefaultTableModel(titles, 0);
		table = new JTable(dtm);
		
	}
	private void addComponents() {
		this.add(new JScrollPane(table));
	}
	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
