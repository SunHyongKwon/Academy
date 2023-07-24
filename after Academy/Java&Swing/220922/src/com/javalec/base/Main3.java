package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main3 {

	private JFrame frame;
	private JRadioButton rbKBS;
	private JCheckBox chckbxApple;
	private JCheckBox chckbxBanana;
	private JButton btnOK1;
	private JTextField tfFruit;
	private JRadioButton rbMBC;
	private JButton btnOK2;
	private JTextField tfBroad;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main3 window = new Main3();
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
	public Main3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 552, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getRbKBS());
		frame.getContentPane().add(getRbMBC());
		frame.getContentPane().add(getChckbxApple());
		frame.getContentPane().add(getChckbxBanana());
		frame.getContentPane().add(getBtnOK1());
		frame.getContentPane().add(getBtnOK2());
		frame.getContentPane().add(getTfFruit());
		frame.getContentPane().add(getTfBroad());
	}
	private JRadioButton getRbKBS() {
		if (rbKBS == null) {
			rbKBS = new JRadioButton("KBS");
			rbKBS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			buttonGroup.add(rbKBS);
			rbKBS.setBounds(286, 79, 141, 23);
		}
		return rbKBS;
	}
	private JCheckBox getChckbxApple() {
		if (chckbxApple == null) {
			chckbxApple = new JCheckBox("Apple");
			chckbxApple.setBounds(52, 79, 128, 23);
		}
		return chckbxApple;
	}
	private JCheckBox getChckbxBanana() {
		if (chckbxBanana == null) {
			chckbxBanana = new JCheckBox("Banana");
			chckbxBanana.setBounds(52, 118, 128, 23);
		}
		return chckbxBanana;
	}
	private JButton getBtnOK1() {
		if (btnOK1 == null) {
			btnOK1 = new JButton("OK");
			btnOK1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fruitCheck();
				}
			});
			btnOK1.setBounds(52, 165, 117, 29);
		}
		return btnOK1;
	}
	private JTextField getTfFruit() {
		if (tfFruit == null) {
			tfFruit = new JTextField();
			tfFruit.setBounds(52, 206, 187, 26);
			tfFruit.setColumns(10);
		}
		return tfFruit;
	}
	private JRadioButton getRbMBC() {
		if (rbMBC == null) {
			rbMBC = new JRadioButton("MBC");
			buttonGroup.add(rbMBC);
			rbMBC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			rbMBC.setBounds(286, 118, 141, 23);
		}
		return rbMBC;
	}
	private JButton getBtnOK2() {
		if (btnOK2 == null) {
			btnOK2 = new JButton("OK");
			btnOK2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					broadCheck();
				}
			});
			btnOK2.setBounds(286, 165, 117, 29);
		}
		return btnOK2;
	}
	private JTextField getTfBroad() {
		if (tfBroad == null) {
			tfBroad = new JTextField();
			tfBroad.setColumns(10);
			tfBroad.setBounds(286, 206, 187, 26);
		}
		return tfBroad;
	}
	
	private void broadCheck() {
		if(rbKBS.isSelected()) {
			tfBroad.setText("KBS is selected");
		}
		if(rbMBC.isSelected()){
			tfBroad.setText("MBC is selected");
		}
	}
	
	private void fruitCheck() {
		if(chckbxApple.isSelected() && chckbxBanana.isSelected()) {
			tfFruit.setText("Apple and banana is selected");
		}else if(chckbxApple.isSelected()) {
			tfFruit.setText("Apple is selected");
		}else if(chckbxBanana.isSelected()) {
			tfFruit.setText("Banana is selected");
		}
		
		
		
	}
}
