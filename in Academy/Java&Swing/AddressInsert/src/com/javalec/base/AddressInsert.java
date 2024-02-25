package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.function.DBConnect;

public class AddressInsert {
	
	// Field (전역변수)
	private JFrame frame;
	private JLabel lblName;
	private JTextField tfName;
	private JTextField tfPhone;
	private JLabel lblPhone;
	private JTextField tfAddress;
	private JLabel lblAddress;
	private JTextField tfEmail;
	private JLabel lblEmail;
	private JTextField tfRelation;
	private JLabel lblRelation;
	private JButton btnInput;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInsert window = new AddressInsert();
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
	public AddressInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("주소록 등록");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblName());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfPhone());
		frame.getContentPane().add(getLblPhone());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblAddress());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblEmail());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getLblRelation());
		frame.getContentPane().add(getBtnInput());
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("성명 : ");
			lblName.setBounds(17, 25, 61, 16);
		}
		return lblName;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(83, 20, 210, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(83, 53, 210, 21);
		}
		return tfPhone;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("전화번호  : ");
			lblPhone.setBounds(17, 58, 61, 16);
		}
		return lblPhone;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(83, 86, 210, 21);
		}
		return tfAddress;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("주소 : ");
			lblAddress.setBounds(17, 91, 61, 16);
		}
		return lblAddress;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(83, 119, 210, 21);
		}
		return tfEmail;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("전자우편 : ");
			lblEmail.setBounds(17, 124, 61, 16);
		}
		return lblEmail;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(83, 152, 210, 21);
		}
		return tfRelation;
	}
	private JLabel getLblRelation() {
		if (lblRelation == null) {
			lblRelation = new JLabel("관계 : ");
			lblRelation.setBounds(17, 157, 61, 16);
		}
		return lblRelation;
	}
	private JButton getBtnInput() {
		if (btnInput == null) {
			btnInput = new JButton("입력");
			btnInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// database 에서는 PK를 제외하고 나머지 column들은 null 값을 허용했지만, 자바에서 이걸 막아서 쓰는게 좋다. 
					// 입력항목 check method만들어서 사용한다.
					int i_chk = insertFieldCheck();
					if(i_chk == 0) {
						i_chk = insertAction();
						if(i_chk == 1) {
							JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력 되었습니다."); 
						}
						deleteAll();
					}
					// 입력항목에 이상이 없을 경우에만 DB에 입력한다. 
					
				}
			});
			btnInput.setBounds(304, 208, 117, 29);
		}
		return btnInput;
	}
	
	// Functions
	
	// 입력항목 check
	private int insertFieldCheck() {
		int i = 0;
		String message = "";
		
		if(tfName.getText().trim().length() == 0) {
			i++;
			message = "이름을 ";
			tfName.requestFocus(); // tfName에 가서 커서가 깜빡인다.
		}
		
		if(tfPhone.getText().trim().length() == 0) {
			i++;
			message = "번호를 ";
			tfPhone.requestFocus();
		}
		
		if(tfAddress.getText().trim().length() == 0 ) {
			i++;
			message = "주소를 ";
			tfAddress.requestFocus();
		}
		
		if(tfEmail.getText().trim().length() == 0) {
			i++;
			message = "이메일을 ";
			tfEmail.requestFocus();
		}
		
		if(tfRelation.getText().trim().length() == 0) {
			i++;
			message = "관계를 ";
			tfRelation.requestFocus();
		}
		
		if(i > 0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요!");
		}
		
		return i;
	}
	
	private int insertAction() {
		PreparedStatement ps = null;
		int i = 0;
		// 데이터베이스 서버가 이상이 있는지 없는지 확인하는 것
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // package 이름과 class 이름을 정해준 것이다.
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // 연결을 시켜주는데 이거의 url은 따로 class를 만들어서 관리해준다.
//			Statement stmt_mysql = conn_mysql.createStatement(); // 검색 시에 필요한 부분

			// insert, update, delete 는 모두 database에 data를 넣는 것이기 때문에 query 만 update,
			// insert, delete 이런 식으로 바꾸기만 하면 된다.
			String query = "insert into userinfo (name,telno,address,email,relation) ";
			String query1 = "values (?,?,?,?,?)";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, tfName.getText().trim());
			ps.setString(2, tfPhone.getText().trim());
			ps.setString(3, tfAddress.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());
			// insert, update , delete모두 이 method를 통해서 데이터베이스에 넣을 수 있다. 
			i = ps.executeUpdate(); // update, select , insert 된 열의 수를 리턴해 준다. 
			
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return i;
	}
	
	private void deleteAll() {
		
		tfName.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfPhone.setText("");
		tfRelation.setText("");
	}
	
	
}
