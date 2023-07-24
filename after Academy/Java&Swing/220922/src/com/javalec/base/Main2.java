package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main2 {

	private JFrame frame;
	private JComboBox<Object> cbFruits;
	private JTextField tfFruits;
	private JTextField tfAdd;
	private JButton btnAdd;
	private JComboBox<String> cbAdd;

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
		frame.setBounds(100, 100, 529, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbFruits());
		frame.getContentPane().add(getTfFruits());
		frame.getContentPane().add(getTfAdd());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getCbAdd());
	}
	@SuppressWarnings("unchecked")
	private JComboBox<Object> getCbFruits() {
		if (cbFruits == null) {
			cbFruits = new JComboBox();
			cbFruits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfFruits.setText(cbFruits.getSelectedItem().toString());
				}
			});
			cbFruits.setModel(new DefaultComboBoxModel<Object>(new String[] {"Apple", "Banana", "Grape", "Melon", "Mango"}));
			cbFruits.setBounds(59, 31, 205, 42);
		}
		return cbFruits;
	}
	private JTextField getTfFruits() {
		if (tfFruits == null) {
			tfFruits = new JTextField();
			tfFruits.setBounds(276, 38, 223, 26);
			tfFruits.setColumns(10);
		}
		return tfFruits;
	}
	private JTextField getTfAdd() {
		if (tfAdd == null) {
			tfAdd = new JTextField();
			tfAdd.setText(" ");
			tfAdd.setBounds(59, 105, 205, 26);
			tfAdd.setColumns(10);
		}
		return tfAdd;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("New button");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addCombo();
				}
			});
			btnAdd.setBounds(59, 157, 205, 26);
		}
		return btnAdd;
	}
	private JComboBox<String> getCbAdd() {
		if (cbAdd == null) {
			cbAdd = new JComboBox<String>();
			cbAdd.setBounds(276, 106, 223, 25);
		}
		return cbAdd;
	} //-----------------------------------------------------------------------------------------------------------------------
	
	private void addCombo() {
		String stTemp = tfAdd.getText();
		cbAdd.addItem(stTemp);
	}
	
	
}
