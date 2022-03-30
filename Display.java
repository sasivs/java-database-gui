package database_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Display extends JFrame {

	JPanel contentPane;
	JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Display frame = new Display();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public void addRow(String name, String email, String gender, String course, String address) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(new Object[] {name,email,gender,course,address});
	}
	
	public boolean delRow(String name) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int reqRow = -1;
		for (int i=0; i<model.getRowCount(); i++) {
			if(model.getValueAt(i, 0).equals(name)) {
				reqRow=i;
				break;
			}
		}
		if(reqRow!=-1) {
			model.removeRow(reqRow);
			return true;
		}
		return false;
	}
	
	public boolean updateEmail(String name, String nemail) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int reqRow = -1;
		for (int i=0; i<model.getRowCount(); i++) {
			if(model.getValueAt(i, 0).equals(name)) {
				reqRow=i;
				break;
			}
		}
		if(reqRow!=-1) {
			model.setValueAt(nemail, reqRow, 1);
			return true;
		}
		return false;
		
	}
	/**
	 * Create the frame.
	 */
	public Display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Email", "Gender", "Course", "Address"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("Verdana", Font.BOLD, 12));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i=0; i<table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		scrollPane.setViewportView(table);
	}

}
