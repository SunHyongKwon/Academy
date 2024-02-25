package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Main2 {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JLabel lblNewLabel_1;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 window = new Main2();
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
	public Main2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 151);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getBtnAdd());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("java GUI Example 01");
			lblNewLabel.setBounds(58, 21, 450, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setBounds(58, 58, 74, 26);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setColumns(10);
			tfNum2.setBounds(175, 58, 74, 26);
		}
		return tfNum2;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("+");
			lblNewLabel_1.setBounds(144, 63, 16, 16);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addSum();
				}
			});
			btnAdd.setBounds(275, 58, 117, 29);
		}
		return btnAdd;
	}
	
	// ----------------------------------------------------------
	
	
	private void addSum() {
		JOptionPane.showMessageDialog(null, Integer.toString(Integer.parseInt(tfNum1.getText()) + Integer.parseInt(tfNum2.getText())));
	}
	
}// ---------------------------end
