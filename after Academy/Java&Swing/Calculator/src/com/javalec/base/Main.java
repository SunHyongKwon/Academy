package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JTextField tfResult;
	private JButton btnClear;
	private JButton btnClear2;
	private JButton btnNull3;
	private JButton btnAdd;
	private JButton btnSeven;
	private JButton btnEight;
	private JButton btnNine;
	private JButton btnSub;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnMul;
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnDiv;
	private JButton btnZero;
	private JButton btnNull;
	private JButton btnNull2;
	private JButton btnEqual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getBtnClear());
		frame.getContentPane().add(getBtnClear2());
		frame.getContentPane().add(getBtnNull3());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getBtnSeven());
		frame.getContentPane().add(getBtnEight());
		frame.getContentPane().add(getBtnNine());
		frame.getContentPane().add(getBtnSub());
		frame.getContentPane().add(getBtnFour());
		frame.getContentPane().add(getBtnFive());
		frame.getContentPane().add(getBtnSix());
		frame.getContentPane().add(getBtnMul());
		frame.getContentPane().add(getBtnOne());
		frame.getContentPane().add(getBtnTwo());
		frame.getContentPane().add(getBtnThree());
		frame.getContentPane().add(getBtnDiv());
		frame.getContentPane().add(getBtnZero());
		frame.getContentPane().add(getBtnNull());
		frame.getContentPane().add(getBtnNull2());
		frame.getContentPane().add(getBtnEqual());
	}
	
	// 결과값 나오는 텍스트 필드
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			tfResult.setBounds(6, 6, 438, 91);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	
	// 초기화 할 수 있는 버튼
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("C");
			btnClear.setBounds(6, 109, 99, 78);
		}
		return btnClear;
	}
	private JButton getBtnClear2() {
		if (btnClear2 == null) {
			btnClear2 = new JButton("CE");
			btnClear2.setBounds(117, 109, 99, 78);
		}
		return btnClear2;
	}
	
	// 사칙연산 버튼
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.setBounds(345, 109, 99, 78);
		}
		return btnAdd;
	}
	private JButton getBtnSub() {
		if (btnSub == null) {
			btnSub = new JButton("-");
			btnSub.setBounds(345, 199, 99, 78);
		}
		return btnSub;
	}
	private JButton getBtnMul() {
		if (btnMul == null) {
			btnMul = new JButton("X");
			btnMul.setBounds(345, 289, 99, 78);
		}
		return btnMul;
	}
	private JButton getBtnDiv() {
		if (btnDiv == null) {
			btnDiv = new JButton("/");
			btnDiv.setBounds(345, 379, 99, 78);
		}
		return btnDiv;
	}
	
	// 등호 버튼
	private JButton getBtnEqual() {
		if (btnEqual == null) {
			btnEqual = new JButton("=");
			btnEqual.setBounds(345, 469, 99, 78);
		}
		return btnEqual;
	}
	
	
	// 숫자 버튼
	private JButton getBtnZero() {
		if (btnZero == null) {
			btnZero = new JButton("0");
			btnZero.setBounds(6, 469, 99, 78);
		}
		return btnZero;
	}
	private JButton getBtnOne() {
		if (btnOne == null) {
			btnOne = new JButton("1");
			btnOne.setBounds(6, 379, 99, 78);
		}
		return btnOne;
	}
	private JButton getBtnTwo() {
		if (btnTwo == null) {
			btnTwo = new JButton("2");
			btnTwo.setBounds(117, 379, 99, 78);
		}
		return btnTwo;
	}
	private JButton getBtnThree() {
		if (btnThree == null) {
			btnThree = new JButton("3");
			btnThree.setBounds(228, 379, 99, 78);
		}
		return btnThree;
	}
	private JButton getBtnFour() {
		if (btnFour == null) {
			btnFour = new JButton("4");
			btnFour.setBounds(6, 289, 99, 78);
		}
		return btnFour;
	}
	private JButton getBtnFive() {
		if (btnFive == null) {
			btnFive = new JButton("5");
			btnFive.setBounds(117, 289, 99, 78);
		}
		return btnFive;
	}
	private JButton getBtnSix() {
		if (btnSix == null) {
			btnSix = new JButton("6");
			btnSix.setBounds(228, 289, 99, 78);
		}
		return btnSix;
	}
	private JButton getBtnSeven() {
		if (btnSeven == null) {
			btnSeven = new JButton("7");
			btnSeven.setBounds(6, 199, 99, 78);
		}
		return btnSeven;
	}
	private JButton getBtnEight() {
		if (btnEight == null) {
			btnEight = new JButton("8");
			btnEight.setBounds(117, 199, 99, 78);
		}
		return btnEight;
	}
	private JButton getBtnNine() {
		if (btnNine == null) {
			btnNine = new JButton("9");
			btnNine.setBounds(228, 199, 99, 78);
		}
		return btnNine;
	}
	
	// 빈 버튼
	private JButton getBtnNull() {
		if (btnNull == null) {
			btnNull = new JButton("");
			btnNull.setBounds(117, 469, 99, 78);
		}
		return btnNull;
	}
	private JButton getBtnNull2() {
		if (btnNull2 == null) {
			btnNull2 = new JButton("");
			btnNull2.setBounds(228, 469, 99, 78);
		}
		return btnNull2;
	}
	private JButton getBtnNull3() {
		if (btnNull3 == null) {
			btnNull3 = new JButton("");
			btnNull3.setBounds(228, 109, 99, 78);
		}
		return btnNull3;
	}
	
	// 개인 필드
	ActionEvent e = new ActionEvent(frame, 0, null);
	
	// 개인 메소드
	
	
}
