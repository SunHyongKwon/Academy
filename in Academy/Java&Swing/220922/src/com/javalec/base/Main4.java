package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main4 {

	private JFrame frame;
	private JPasswordField pwfPw;
	private JLabel lblPw;
	private JButton btnOK;
	private JTextField tfCheckPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main4 window = new Main4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPwfPw());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getTfCheckPW());
	}
	private JPasswordField getPwfPw() {
		if (pwfPw == null) {
			pwfPw = new JPasswordField();
			pwfPw.setBounds(48, 75, 309, 34);
		}
		return pwfPw;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("password :");
			lblPw.setBounds(48, 47, 225, 16);
		}
		return lblPw;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPassword();
					
				}
			});
			btnOK.setBounds(341, 135, 117, 29);
		}
		return btnOK;
	}
	private JTextField getTfCheckPW() {
		if (tfCheckPW == null) {
			tfCheckPW = new JTextField();
			tfCheckPW.setBounds(48, 197, 309, 34);
			tfCheckPW.setColumns(10);
		}
		return tfCheckPW;
	}
	
	private void checkPassword() {
		char[] pass = pwfPw.getPassword();
		String passString = new String(pass);
		tfCheckPW.setText(passString);
		
	}
}
