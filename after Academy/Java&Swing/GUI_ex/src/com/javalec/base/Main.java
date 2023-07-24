package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.function.Calc;

public class Main {
	// window frame 관련 필
	private JFrame frame;
	private JLabel lblOne;
	private JLabel lblTwo;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JTextField tfGetNum1;
	private JTextField tfGetNum2;
	private JTextField tfResult;
	private JLabel lblChange;
	private JLabel lblEquals;

	// 가감승제 위한 필드
	private Calc calc;
	ClickListener a = new ClickListener();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					JOptionPane.showConfirmDialog(null, "입력은 꼭 숫자로");
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
		
		frame = new JFrame();
		frame.setTitle("두 개의 숫자 가감승제");
		frame.setBounds(100, 100, 450, 217);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblOne());
		frame.getContentPane().add(getLblTwo());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getBtnSub());
		frame.getContentPane().add(getBtnMul());
		frame.getContentPane().add(getBtnDiv());
		frame.getContentPane().add(getTfGetNum1());
		frame.getContentPane().add(getTfGetNum2());
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getLblChange());
		frame.getContentPane().add(getLblEquals());
		
	}

	private JLabel getLblOne() {
		if (lblOne == null) {
			lblOne = new JLabel("숫자 1 :");
			lblOne.setBounds(37, 32, 61, 16);
		}
		return lblOne;
	}

	private JLabel getLblTwo() {
		if (lblTwo == null) {
			lblTwo = new JLabel("숫자 2 :");
			lblTwo.setBounds(37, 71, 61, 16);
		}
		return lblTwo;
	}

	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setBounds(89, 27, 87, 26);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}

	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setBounds(89, 66, 87, 26);
			tfNum2.setColumns(10);
		}
		return tfNum2;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// add
					ClickListener a = new ClickListener();
					a.actionPerformed(e);
				}
			});
			btnAdd.setBounds(289, 27, 61, 29);
		}
		return btnAdd;
	}

	private JButton getBtnSub() {
		if (btnSub == null) {
			btnSub = new JButton("-");
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// sub
					ClickListener a = new ClickListener();
					a.actionPerformed(e);
				}
			});
			btnSub.setBounds(362, 27, 61, 29);
		}
		return btnSub;
	}

	private JButton getBtnMul() {
		if (btnMul == null) {
			btnMul = new JButton("X");
			btnMul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// mul
					ClickListener a = new ClickListener();
					a.actionPerformed(e);
				}
			});
			btnMul.setBounds(289, 66, 61, 29);
		}
		return btnMul;
	}

	private JButton getBtnDiv() {
		if (btnDiv == null) {
			btnDiv = new JButton("/");
			btnDiv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// div
					
					a.actionPerformed(e);

				}
			});
			btnDiv.setBounds(362, 66, 61, 29);
		}
		return btnDiv;
	}

	private JTextField getTfGetNum1() {
		if (tfGetNum1 == null) {
			tfGetNum1 = new JTextField();
			tfGetNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfGetNum1.setBounds(37, 134, 87, 26);
			tfGetNum1.setColumns(10);
		}
		return tfGetNum1;
	}

	private JTextField getTfGetNum2() {
		if (tfGetNum2 == null) {
			tfGetNum2 = new JTextField();
			tfGetNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfGetNum2.setColumns(10);
			tfGetNum2.setBounds(183, 134, 87, 26);
		}
		return tfGetNum2;
	}

	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setEditable(false);
			tfResult.setColumns(10);
			tfResult.setBounds(336, 134, 87, 26);
		}
		return tfResult;
	}

	private JLabel getLblChange() {
		if (lblChange == null) {
			lblChange = new JLabel("+");
			lblChange.setBounds(148, 139, 61, 16);
		}
		return lblChange;
	}

	private JLabel getLblEquals() {

		if (lblEquals == null) {
			lblEquals = new JLabel("=");
			lblEquals.setBounds(300, 139, 61, 16);
		}
		return lblEquals;
	}

	// ------------------------------------------------------------------------------

	private class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			calc = new Calc(Integer.parseInt(tfNum1.getText()), Integer.parseInt(tfNum2.getText()));

			tfGetNum1.setText(tfNum1.getText());
			tfGetNum2.setText(tfNum2.getText());

			if (e.getSource() == btnAdd) {
				lblChange.setText("+");
				tfResult.setText(Integer.toString(calc.add()));
			}

			else if (e.getSource() == btnSub) {
				lblChange.setText("-");
				tfResult.setText(Integer.toString(calc.sub()));
			}

			else if (e.getSource() == btnMul) {
				lblChange.setText("X");
				tfResult.setText(Integer.toString(calc.mul()));
			}

			else {
				if (Integer.parseInt(tfNum2.getText()) == 0) {
					JOptionPane.showConfirmDialog(null, "입력은 꼭 숫자로");
				} else {
					lblChange.setText("/");
					tfResult.setText(Double.toString(calc.div()));
				}
			}
		}
	}

}// end
	// ------------------------------------------------------------------------------
