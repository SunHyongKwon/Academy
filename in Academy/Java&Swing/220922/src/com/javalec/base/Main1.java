package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.function.TwoNumberCalc;

public class Main1 {

	private JFrame frame;
	private JLabel lblNum1;
	private JLabel lblNum2;
	private JButton btnAdd;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JTextField tfResultNum1;
	private JTextField tfResultNum2;
	private JTextField tfResult;
	private JLabel lblOperator;
	private JLabel lblEqual;
	
	// 내가 만든 필드
	private List<Character> list = new ArrayList<>();
	private int btnCheck = 0;

	/*
	 * **********************************************************
	 * 
	 * 2개의 숫자를 이용하여 가감승제 해보기
	 * 
	 * to do list - textfield 잠금 - 가감승제 계산 - 기능 class로 분리
	 * 
	 * history 2022.09.22 : 시작 2022.09.22 : 디자인 틀 완성
	 * 
	 * 
	 * **********************************************************
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 window = new Main1();
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
	public Main1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("두 개의 숫자 가감승제");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNum1());
		frame.getContentPane().add(getLblNum2());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getBtnSub());
		frame.getContentPane().add(getBtnMul());
		frame.getContentPane().add(getBtnDiv());
		frame.getContentPane().add(getTfResultNum1());
		frame.getContentPane().add(getTfResultNum2());
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getLblOperator());
		frame.getContentPane().add(getLblEqual());

		// 화면 중앙에 배치

		// 메인 화면이 시작되기전 사용법 보여주기
		JOptionPane.showConfirmDialog(null, "입력은 꼭 숫자로", "사용법", JOptionPane.WARNING_MESSAGE);
	}

	// component method start
	// ---------------------------------------------------------

	// Label
	private JLabel getLblNum1() {
		if (lblNum1 == null) {
			lblNum1 = new JLabel(" 숫자1 :");
			lblNum1.setBounds(34, 45, 61, 16);
		}
		return lblNum1;
	}

	private JLabel getLblNum2() {
		if (lblNum2 == null) {
			lblNum2 = new JLabel(" 숫자2 :");
			lblNum2.setBounds(34, 83, 61, 16);
		}
		return lblNum2;
	}

	private JLabel getLblOperator() {
		if (lblOperator == null) {
			lblOperator = new JLabel("+");
			lblOperator.setBounds(120, 149, 61, 16);
		}
		return lblOperator;
	}

	private JLabel getLblEqual() {
		if (lblEqual == null) {
			lblEqual = new JLabel("=");
			lblEqual.setBounds(285, 149, 61, 16);
		}
		return lblEqual;
	}

	// button
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCheck = 1;
					action();
				}
			});
			btnAdd.setBounds(272, 40, 61, 29);
		}
		return btnAdd;
	}

	private JButton getBtnSub() {
		if (btnSub == null) {
			btnSub = new JButton("-");
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCheck = 2;
					action();

				}
			});
			btnSub.setBounds(351, 40, 61, 29);
		}
		return btnSub;
	}

	private JButton getBtnMul() {
		if (btnMul == null) {
			btnMul = new JButton("X");
			btnMul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCheck = 3;
					action();
				}
			});
			btnMul.setBounds(272, 78, 61, 29);
		}
		return btnMul;
	}

	private JButton getBtnDiv() {
		if (btnDiv == null) {
			btnDiv = new JButton("/");
			btnDiv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCheck = 4;
					action();
				}
			});
			btnDiv.setBounds(351, 78, 61, 29);
		}
		return btnDiv;
	}

	// text field
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setToolTipText("숫자입력");
			tfNum1.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					
					// 지금은 숫자가 아닌게 들어온다면 dialog 가 들어오고, 그게 꺼지면 replace 된 string이 전체 선택 되어서 나와서 바로 이어칠수가 없다. 
					// 이 부분을 해결 해야 된다. 
					String b = null;
					if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
						list.add(e.getKeyChar());
					}else {
						JOptionPane.showConfirmDialog(null, "error");
						tfNum1.setText(tfNum1.getText().replace(tfNum1.getText(),""));
						for(char a : list) {
							 b += Character.toString(a);
						}
						tfNum1.setText(b.replace("null", ""));
					}
				}
			});
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setBounds(87, 40, 130, 26);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}

	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					String b = null;
					if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
						list.add(e.getKeyChar());
					}else {
						tfNum1.setText(tfNum1.getText().replace(tfNum1.getText(),""));
						for(char a : list) {
							 b += Character.toString(a);
						}
						tfNum1.setText(b.replace("null", ""));
					}
				}
			});
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setColumns(10);
			tfNum2.setBounds(87, 78, 130, 26);
		}
		return tfNum2;
	}

	private JTextField getTfResultNum1() {
		if (tfResultNum1 == null) {
			tfResultNum1 = new JTextField();
			tfResultNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResultNum1.setBounds(6, 144, 92, 26);
			tfResultNum1.setColumns(10);
		}
		return tfResultNum1;
	}

	private JTextField getTfResultNum2() {
		if (tfResultNum2 == null) {
			tfResultNum2 = new JTextField();
			tfResultNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResultNum2.setColumns(10);
			tfResultNum2.setBounds(159, 144, 92, 26);
		}
		return tfResultNum2;
	}

	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setColumns(10);
			tfResult.setBounds(320, 144, 92, 26);
		}
		return tfResult;
	} // component method end
		// ---------------------------------------------------------

	// ---------------------------- functions
	// -----------------------------------------

	public void action() {
		TwoNumberCalc calc = new TwoNumberCalc();
		tfResultNum1.setText(tfNum1.getText());
		tfResultNum2.setText(tfNum2.getText());

		if (btnCheck == 1) {
			lblOperator.setText("+");
			tfResult.setText(calc.add(tfResultNum1.getText(), tfResultNum2.getText()));
		}
		else if (btnCheck == 2) {
			lblOperator.setText("-");
			tfResult.setText(calc.sub(tfResultNum1.getText(), tfResultNum2.getText()));
		}
		else if (btnCheck == 3) {
			lblOperator.setText("*");
			tfResult.setText(calc.mul(tfResultNum1.getText(), tfResultNum2.getText()));
		}
		else {
			if (checkZero()) {
				JOptionPane.showConfirmDialog(null, "입력은 꼭 숫자로", "사용법", JOptionPane.WARNING_MESSAGE);
			} else {
				lblOperator.setText("/");
				tfResult.setText(calc.div(tfResultNum1.getText(), tfResultNum2.getText()));
			}
		}
	}

	private boolean checkZero() {
		if (tfResultNum2.getText().equals("0")) {
			return false;
		} else {
			return true;
		}
	}

} // system end
	// -----------------------------------------------------------------------
