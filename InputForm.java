package database_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputForm extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField emailTxt;
	private JTextField addressTxt;
	private JTextField delNameTxt;
	private JTextField updateNameTxt;
	private JTextField updateEmailTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputForm frame = new InputForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputForm() {
		Display window = new Display();
		window.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 680);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addStuLb = new JLabel("ADD Student");
		addStuLb.setBackground(Color.LIGHT_GRAY);
		addStuLb.setForeground(Color.BLACK);
		addStuLb.setHorizontalAlignment(SwingConstants.CENTER);
		addStuLb.setFont(new Font("Calibri", Font.BOLD, 16));
		addStuLb.setBounds(141, 11, 111, 22);
		contentPane.add(addStuLb);
		
		JLabel addName = new JLabel("Name");
		addName.setFont(new Font("Verdana", Font.PLAIN, 12));
		addName.setHorizontalAlignment(SwingConstants.LEFT);
		addName.setBounds(37, 64, 86, 22);
		contentPane.add(addName);
		
		JLabel address = new JLabel("Address");
		address.setHorizontalAlignment(SwingConstants.LEFT);
		address.setFont(new Font("Verdana", Font.PLAIN, 12));
		address.setBounds(37, 193, 86, 22);
		contentPane.add(address);
		
		JLabel addEmail = new JLabel("Email");
		addEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		addEmail.setBounds(37, 94, 86, 22);
		contentPane.add(addEmail);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Verdana", Font.PLAIN, 12));
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setBounds(37, 127, 86, 22);
		contentPane.add(gender);
		
		JLabel course = new JLabel("Course");
		course.setHorizontalAlignment(SwingConstants.LEFT);
		course.setFont(new Font("Verdana", Font.PLAIN, 12));
		course.setBounds(37, 160, 86, 22);
		contentPane.add(course);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(197, 66, 139, 20);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(197, 96, 139, 20);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		JRadioButton male = new JRadioButton("Male");
		male.setForeground(Color.BLACK);
		male.setBackground(Color.GRAY);
		male.setBounds(197, 128, 55, 23);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBackground(Color.GRAY);
		female.setBounds(254, 128, 82, 23);
		contentPane.add(female);
		
		JComboBox courseBox = new JComboBox();
		courseBox.setModel(new DefaultComboBoxModel(new String[] {"select", "BIOTECH", "CIVIL", "CSE", "ECE", "EEE", "MECH", "MME"}));
		courseBox.setBounds(197, 161, 75, 22);
		contentPane.add(courseBox);
		
		addressTxt = new JTextField();
		addressTxt.setBounds(197, 195, 139, 20);
		contentPane.add(addressTxt);
		addressTxt.setColumns(10);
		
		JLabel delStuLb = new JLabel("Delete Student");
		delStuLb.setFont(new Font("Calibri", Font.BOLD, 18));
		delStuLb.setHorizontalAlignment(SwingConstants.CENTER);
		delStuLb.setBounds(141, 303, 131, 22);
		contentPane.add(delStuLb);
		
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender="";
				if(male.isSelected()) {
					gender="Male";
				}
				else if(female.isSelected()) {
					gender="Female";
				}
				window.addRow(nameTxt.getText(), emailTxt.getText(), gender,
						(String)courseBox.getItemAt(courseBox.getSelectedIndex()), addressTxt.getText());
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f,"Student details Added successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		addBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
		addBtn.setBounds(155, 245, 97, 23);
		contentPane.add(addBtn);
		
		JLabel delNamelb = new JLabel("Name");
		delNamelb.setHorizontalAlignment(SwingConstants.LEFT);
		delNamelb.setFont(new Font("Verdana", Font.PLAIN, 12));
		delNamelb.setBounds(37, 341, 86, 22);
		contentPane.add(delNamelb);
		
		delNameTxt = new JTextField();
		delNameTxt.setColumns(10);
		delNameTxt.setBounds(197, 343, 139, 20);
		contentPane.add(delNameTxt);
		
		JButton delBtn = new JButton("DELETE");
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = delNameTxt.getText();
				if(window.delRow(name)) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Student details deleted successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"No student present with given details","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		delBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
		delBtn.setBounds(155, 398, 86, 23);
		contentPane.add(delBtn);
		
		JLabel lblNewLabel = new JLabel("Update Email");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 449, 131, 22);
		contentPane.add(lblNewLabel);
		
		JLabel updateNameLb = new JLabel("Name");
		updateNameLb.setHorizontalAlignment(SwingConstants.LEFT);
		updateNameLb.setFont(new Font("Verdana", Font.PLAIN, 12));
		updateNameLb.setBounds(37, 489, 86, 22);
		contentPane.add(updateNameLb);
		
		updateNameTxt = new JTextField();
		updateNameTxt.setColumns(10);
		updateNameTxt.setBounds(197, 491, 139, 20);
		contentPane.add(updateNameTxt);
		
		JLabel updateEmail = new JLabel("New Email");
		updateEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		updateEmail.setBounds(37, 522, 86, 22);
		contentPane.add(updateEmail);
		
		updateEmailTxt = new JTextField();
		updateEmailTxt.setColumns(10);
		updateEmailTxt.setBounds(197, 524, 139, 20);
		contentPane.add(updateEmailTxt);
		
		JButton updateBtn = new JButton("UPDATE");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = updateNameTxt.getText();
				String nemail = updateEmailTxt.getText();
				if(window.updateEmail(name,nemail)) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Email updated successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"No student present with given details","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		updateBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
		updateBtn.setBounds(155, 572, 86, 23);
		contentPane.add(updateBtn);
	}
}
