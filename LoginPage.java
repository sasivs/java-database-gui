import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class LoginPage {
	private static HashMap<String,String> passwdMap = new HashMap<String,String>();
	private static HashMap<String,String> nameMap = new HashMap<String,String>();
	public static void displaySignUpPage() {
		JFrame f1= new JFrame();
		f1.setVisible(true);
		f1.setSize(450,300);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		f1.setContentPane(contentPane);
		
		JLabel signUpLb = new JLabel("SIGN UP");
		signUpLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		signUpLb.setHorizontalAlignment(SwingConstants.CENTER);
		signUpLb.setBounds(126, 25, 135, 25);
		contentPane.add(signUpLb);
		
		JLabel nameLb = new JLabel("Name");
		nameLb.setFont(new Font("Calibri", Font.BOLD, 14));
		nameLb.setHorizontalAlignment(SwingConstants.LEFT);
		nameLb.setBounds(77, 73, 78, 25);
		contentPane.add(nameLb);
		
		JLabel passwordLb = new JLabel("Password");
		passwordLb.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLb.setFont(new Font("Calibri", Font.BOLD, 14));
		passwordLb.setBounds(77, 149, 78, 25);
		contentPane.add(passwordLb);
		
		JTextField nameTxt = new JTextField();
		nameTxt.setBounds(208, 73, 119, 20);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JTextField usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(208, 113, 119, 20);
		contentPane.add(usernameTxt);
		
		JPasswordField passwordTxt = new JPasswordField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(208, 149, 119, 20);
		contentPane.add(passwordTxt);
		
		JButton signUpBtn = new JButton("SIGN UP");
		signUpBtn.setBounds(147, 202, 89, 23);
		contentPane.add(signUpBtn);
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTxt.getText();
				String uname = usernameTxt.getText();
				String passwd = new String(passwordTxt.getPassword());
				JFrame msgf;
				String msg;
				if(nameMap.containsKey(uname)==true) {
					msgf=new JFrame();
					msg="Username already exists";
					JOptionPane.showMessageDialog(msgf,msg,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					nameMap.put(uname, name);
					passwdMap.put(uname, passwd);
					msgf=new JFrame();
					msg="Username registered successfully";
					JOptionPane.showMessageDialog(msgf,msg,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				}
				f1.dispose();
			}
		});
	}
	public static void displaySignInPage() {
		JFrame f1 = new JFrame();
		f1.setVisible(true);
		f1.setSize(450,300);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		f1.setContentPane(contentPane);
		
		JLabel signinLb = new JLabel("SIGN IN");
		signinLb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		signinLb.setHorizontalAlignment(SwingConstants.CENTER);
		signinLb.setBounds(139, 11, 127, 30);
		contentPane.add(signinLb);
		
		JLabel userNameLb = new JLabel("User Name");
		userNameLb.setFont(new Font("Calibri", Font.BOLD, 14));
		userNameLb.setBounds(82, 75, 84, 20);
		contentPane.add(userNameLb);
		
		JLabel PasswordLb = new JLabel("Password");
		PasswordLb.setFont(new Font("Calibri", Font.BOLD, 14));
		PasswordLb.setBounds(82, 118, 84, 20);
		contentPane.add(PasswordLb);
		
		JTextField usernameTxt = new JTextField();
		usernameTxt.setBounds(228, 73, 116, 20);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JPasswordField passwordTxt = new JPasswordField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(228, 116, 116, 20);
		contentPane.add(passwordTxt);
		
		JButton signInBtn = new JButton("SIGN IN");
		signInBtn.setBounds(153, 179, 89, 23);
		contentPane.add(signInBtn);
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = usernameTxt.getText();
				String passwd = new String(passwordTxt.getPassword());
				JFrame msgf;
				String msg;
				if(passwdMap.containsKey(uname)==true) {
					if(passwdMap.get(uname).equals(passwd)) {
						msgf = new JFrame();
						msg = "Welcome"+" "+nameMap.get(uname);
						JOptionPane.showMessageDialog(msgf,msg,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						msgf = new JFrame();
						msg = "Wrong UserName/Password";
						JOptionPane.showMessageDialog(msgf,msg,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					msgf = new JFrame();
					msg = "Wrong UserName/Password";
					JOptionPane.showMessageDialog(msgf,msg,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				}
				f1.dispose();
			}
		});
	}
	public static void main(String[] args) {
		JFrame f1 = new JFrame();
		f1.setVisible(true);
		f1.setSize(450,300);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		f1.setContentPane(contentPane);
		JButton signIn = new JButton("SIGN IN");
		signIn.setBounds(62, 116, 113, 23);
		contentPane.add(signIn);
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				signIn.setEnabled(false);
				displaySignInPage();
//				signIn.setEnabled(true);
			}
		});
		JButton signUp = new JButton("SIGN UP");
		signUp.setBounds(247, 116, 107, 23);
		contentPane.add(signUp);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				signUp.setEnabled(false);
				displaySignUpPage();
//				signUp.setEnabled(true);
			}
		});
	}
}
