package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Exam01 {

	private JFrame frame;
	private JComboBox cbNum1;
	private JComboBox cbNum2;
	private JComboBox cbOperator;
	private JLabel lblCalc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam01 window = new Exam01();
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
	public Exam01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbNum1());
		frame.getContentPane().add(getCbNum2());
		frame.getContentPane().add(getCbOperator());
		frame.getContentPane().add(getLblCalc());
	}

	private JComboBox getCbNum1() {
		if (cbNum1 == null) {
			cbNum1 = new JComboBox();
			cbNum1.setModel(
					new DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
			cbNum1.setBounds(20, 25, 126, 27);
		}
		return cbNum1;
	}

	private JComboBox getCbNum2() {
		if (cbNum2 == null) {
			cbNum2 = new JComboBox();
			cbNum2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblCalc.setText(cbNum1.getSelectedItem().toString() + " " + cbOperator.getSelectedItem().toString()
							+ " " + cbNum2.getSelectedItem().toString() + " = "
							+ result(cbNum1.getSelectedItem().toString(), cbNum2.getSelectedItem().toString()));
				}
			});
			cbNum2.setModel(
					new DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
			cbNum2.setBounds(283, 25, 142, 27);
		}
		return cbNum2;
	}

	private JComboBox getCbOperator() {
		if (cbOperator == null) {
			cbOperator = new JComboBox();
			cbOperator.setModel(new DefaultComboBoxModel(new String[] { "+", "-", "X", "÷" }));
			cbOperator.setBounds(158, 25, 113, 27);
		}
		return cbOperator;
	}

	private JLabel getLblCalc() {
		if (lblCalc == null) {
			lblCalc = new JLabel("New label");
			lblCalc.setBounds(20, 149, 405, 35);
		}
		return lblCalc;
	} // -------------------------------------------

	private String result(String str1, String str2) {

		if (cbOperator.getSelectedItem().toString().equals("+")) {
			return Integer.toString(Integer.parseInt(str1) + Integer.parseInt(str2));

		} else if (cbOperator.getSelectedItem().toString().equals("-")) {
			return Integer.toString(Integer.parseInt(str1) - Integer.parseInt(str2));

		} else if (cbOperator.getSelectedItem().toString().equals("*")) {
			return Integer.toString(Integer.parseInt(str1) * Integer.parseInt(str2));

		} else {
			if (Integer.parseInt(str2) != 0) {

				return String.format("%.2f", Double.parseDouble(str1) / Integer.parseInt(str2));
			}else {
				return "error";
			}

		}
	}
}
