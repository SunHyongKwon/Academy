package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {

	private JFrame frmButtonTest;
	private JLabel lblNation;
	private JButton btnOkay;
	private JButton btnDialogue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmButtonTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmButtonTest = new JFrame("first experience");
		frmButtonTest.getContentPane().setBackground(new Color(255, 248, 220));
		frmButtonTest.getContentPane().setLayout(null);
		frmButtonTest.getContentPane().add(getLabel_1());
		frmButtonTest.getContentPane().add(getBtnOkay());
		frmButtonTest.getContentPane().add(getBtnDialogue());
		frmButtonTest.setBounds(100, 100, 450, 300);
		frmButtonTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// 라벨
	private JLabel getLabel_1() {
		if (lblNation == null) {
			lblNation = new JLabel("대한민국");
			lblNation.setForeground(new Color(100, 107, 114));
			lblNation.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 31));
			lblNation.setBounds(168, 65, 126, 53);
		}
		return lblNation;
	}
	
	// 버튼
	private JButton getBtnOkay() {
		if (btnOkay == null) {
			btnOkay = new JButton("눌러봐");
			btnOkay.setBackground(new Color(49, 47, 76));
			btnOkay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeText();
				}
			});
			btnOkay.setBounds(168, 152, 117, 29);
		}
		return btnOkay;
	}
	private JButton getBtnDialogue() {
		if (btnDialogue == null) {
			btnDialogue = new JButton("Dialogue");
			btnDialogue.setForeground(new Color(44, 47, 47));
			btnDialogue.setBackground(new Color(224, 255, 255));
			btnDialogue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayDialog();
				}
			});
			btnDialogue.setBounds(168, 193, 117, 29);
		}
		return btnDialogue;
	}
	
	
	// 기능을 넣기 위해 내가 만든 메소드
	private void changeText() {
		if(lblNation.getText().equals("Korea")) {
			lblNation.setText("대한민국");
		}else {
			lblNation.setText("Korea");
		}
	}
	
	private String changeDialogue() {
		if(lblNation.getText().equals("Korea")) {
			return "대한민국";
		}else {
			return "Korea";
		}
	}
	
	private void displayDialog() {
		
		JOptionPane.showMessageDialog(null, changeDialogue()); // 메세지 창을 보여준다.
	}
	
}
