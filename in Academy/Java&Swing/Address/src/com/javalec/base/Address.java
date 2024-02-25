package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.DBConnect;

public class Address {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JTextField tfSeqno;
	private JLabel lblSequenceNo;
	private JTextField tfName;
	private JLabel lblName;
	private JTextField tfTelno;
	private JLabel lblTelno;
	private JTextField tfAddress;
	private JLabel lblAddress;
	private JTextField tfEmail;
	private JLabel lblEmail;
	private JTextField tfRelation;
	private JLabel lblRelation;

	// -- Table Definition
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); // ***********중요***********
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnInsert;
	private JRadioButton rbtInsert;
	private JRadioButton rbtUpdate;
	private JRadioButton rbtDelete;
	private JRadioButton rbtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Address window = new Address();
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
	public Address() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/kwonsoonhyong/Downloads/03.png"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit(); // 테이블을 만든다.이것 부터 작업을 해야 된다.
				searchAction(); // 검색을 한다.
			}
		});
		frame.setTitle("주소록");
		frame.setBounds(100, 100, 450, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnQuery());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTfSeqno());
		frame.getContentPane().add(getLblSequenceNo());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblName());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getLblTelno());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblAddress());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblEmail());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getLblRelation());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtnInsert());
		frame.getContentPane().add(getRbtInsert());
		frame.getContentPane().add(getRbtUpdate());
		frame.getContentPane().add(getRbtDelete());
		frame.getContentPane().add(getRbtSearch());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		btnInsert.setVisible(false);
		btnUpdate.setVisible(false);
		btnDelete.setVisible(false);
	}

	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] { "이름", "주소", "관계" }));
			cbSelection.setBounds(31, 61, 93, 23);
		}
		return cbSelection;
	}

	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(136, 58, 167, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}

	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnQuery.setBounds(315, 58, 117, 29);
		}
		return btnQuery;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(21, 117, 411, 176);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) { // 1은 마우스 왼쪽 버튼 누른거임
						tableClick();
					}
				}
			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table); // *************** 중요 자주 잊어먹음 *********************

		}
		return Inner_Table;
	}

	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setEditable(false);
			tfSeqno.setBounds(112, 332, 71, 26);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}

	private JLabel getLblSequenceNo() {
		if (lblSequenceNo == null) {
			lblSequenceNo = new JLabel("Sequence No");
			lblSequenceNo.setBounds(21, 337, 105, 16);
		}
		return lblSequenceNo;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(112, 370, 130, 26);
		}
		return tfName;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름");
			lblName.setBounds(21, 375, 105, 16);
		}
		return lblName;
	}

	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(112, 408, 195, 26);
		}
		return tfTelno;
	}

	private JLabel getLblTelno() {
		if (lblTelno == null) {
			lblTelno = new JLabel("전화번호");
			lblTelno.setBounds(21, 413, 105, 16);
		}
		return lblTelno;
	}

	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(112, 446, 320, 26);
		}
		return tfAddress;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("주소");
			lblAddress.setBounds(21, 451, 105, 16);
		}
		return lblAddress;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(112, 484, 320, 26);
		}
		return tfEmail;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("전자우편");
			lblEmail.setBounds(21, 489, 105, 16);
		}
		return lblEmail;
	}

	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(112, 522, 320, 26);
		}
		return tfRelation;
	}

	private JLabel getLblRelation() {
		if (lblRelation == null) {
			lblRelation = new JLabel("관계");
			lblRelation.setBounds(21, 527, 105, 16);
		}
		return lblRelation;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = deleteAction();
					if (i_chk == 1) {
						JOptionPane.showMessageDialog(null, tfSeqno.getText() + "님의 정보가 삭제 되었습니다.");
					}
					tableInit();
					searchAction();
					clearColumn();
				}
			});
			btnDelete.setBounds(315, 575, 117, 29);
		}
		return btnDelete;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = updateAction();
					if (i_chk == 1) {
						JOptionPane.showMessageDialog(null, tfSeqno.getText() + "님의 정보가 수정 되었습니다.");
					}
					tableInit();
					searchAction();
					clearColumn();
				}
			});
			btnUpdate.setBounds(315, 575, 117, 29);
		}
		return btnUpdate;
	}

	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("입력");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					
					if (i_chk == 0) {
						i_chk = insertAction();
						if (i_chk == 1) {
							JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력 되었습니다.");
							tableInit();
							searchAction();
							clearColumn();
						}
					}
					
				}
			});
			btnInsert.setBounds(315, 575, 117, 29);
		}
		return btnInsert;
	}

	private JRadioButton getRbtInsert() {
		if (rbtInsert == null) {
			rbtInsert = new JRadioButton("입력");
			rbtInsert.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (rbtInsert.isSelected()) {
						btnInsert.setVisible(true);
						clearColumn();
					} else {
						btnInsert.setVisible(false);
					}
				}
			});
			buttonGroup.add(rbtInsert);
			rbtInsert.setBounds(21, 26, 61, 23);
		}
		return rbtInsert;
	}

	private JRadioButton getRbtUpdate() {
		if (rbtUpdate == null) {
			rbtUpdate = new JRadioButton("수정");
			rbtUpdate.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (rbtUpdate.isSelected()) {
						btnUpdate.setVisible(true);
					} else {
						btnUpdate.setVisible(false);
					}
				}
			});
			buttonGroup.add(rbtUpdate);
			rbtUpdate.setBounds(140, 26, 61, 23);
		}
		return rbtUpdate;
	}

	private JRadioButton getRbtDelete() {
		if (rbtDelete == null) {
			rbtDelete = new JRadioButton("삭제");
			rbtDelete.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (rbtDelete.isSelected()) {
						btnDelete.setVisible(true);
					} else {
						btnDelete.setVisible(false);
					}
				}
			});
			buttonGroup.add(rbtDelete);
			rbtDelete.setBounds(251, 26, 61, 23);
		}
		return rbtDelete;
	}

	private JRadioButton getRbtSearch() {
		if (rbtSearch == null) {
			rbtSearch = new JRadioButton("검색");
			buttonGroup.add(rbtSearch);
			rbtSearch.setBounds(371, 26, 61, 23);
		}
		return rbtSearch;
	}

	// Method
	// Init the table
	private void tableInit() {
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");

		Outer_Table.setColumnCount(4);

		// table에 있는 데이터 지우기
		int a = Outer_Table.getRowCount();
		for (int i = 0; i < a; i++) {
			Outer_Table.removeRow(0); // 열이 하나씩 당겨지기 때문에
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		// 순서 column
		int vColIndex = 0;
		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);
		// 이름 column
		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		// 전화번호 column
		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);
		// 관계 column
		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);
	}

	// DB to Table
	private void searchAction() {

		String whereStatement = "select seqno, name, telno, relation from userinfo";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // package 이름과 class 이름을 정해준 것이다.
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // 연결을 시켜주는데 이거의 url은 따로 class를 만들어서 관리해준다.
			Statement stmt_mysql = conn_mysql.createStatement(); // 검색 시에 필요한 부분

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String[] qTxt = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) };
				Outer_Table.addRow(qTxt);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
	}

	// 텍스트 필드 값들 없애기
	private void clearColumn() {
		tfSeqno.setText("");
		tfName.setText("");
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
	}

	// Table Click
	private void tableClick() {
		if (!rbtInsert.isSelected()) {
			// ------- sql 문장 만들기 위해서 하는 거
			int selectRow = Inner_Table.getSelectedRow();
			String wkSequence = (String) Inner_Table.getValueAt(selectRow, 0);
		}
	}

	// 주소 , 번호 , 관계 콤보박스 고르면 string 나누기
	private void conditionQuery() {
		int i = cbSelection.getSelectedIndex();

		String conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "name";
			break;
		case 1:
			conditionQueryColumn = "address";
			break;
		case 2:
			conditionQueryColumn = "relation";
			break;
		default:
			break;
		}

		tableInit();
		clearColumn();
		conditionQueryAction(conditionQueryColumn);

	}

	// conditionQuery메소드 받아서 검색 메소드 만들기
	private void conditionQueryAction(String str) {
		String whereStatement = "select seqno, name, telno, relation from userinfo where " + str;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // package 이름과 class 이름을 정해준 것이다.
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // 연결을 시켜주는데 이거의 url은 따로 class를 만들어서 관리해준다.
			Statement stmt_mysql = conn_mysql.createStatement(); // 검색 시에 필요한 부분

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + " like '%" + tfSelection.getText() + "%'");

			while (rs.next()) {
				String[] qTxt = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) };
				Outer_Table.addRow(qTxt);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
	}

	// tableClick() 실행 된 row 삭제
	private int deleteAction() {
		PreparedStatement ps = null;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // package 이름과 class 이름을 정해준 것이다.
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); // 연결을 시켜주는데 이거의 url은 따로 class를 만들어서 관리해준다.
//			Statement stmt_mysql = conn_mysql.createStatement(); // 검색 시에 필요한 부분

			// insert, update, delete 는 모두 database에 data를 넣는 것이기 때문에 query 만 update,
			// insert, delete 이런 식으로 바꾸기만 하면 된다.
			String query = "delete from userinfo where seqno = ?";

			ps = conn_mysql.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(tfSeqno.getText())); // insert, update , delete모두 이 method를 통해서 데이터베이스에 넣을 수
																// 있다.
			i = ps.executeUpdate(); // update, select , insert 된 열의 수를 리턴해 준다.

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return i;
	}

	// 값 tf로 가져와서 거기서 수정 하기
	private int updateAction() {
		PreparedStatement ps = null;
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);

			// 문제 발견 모가 수정되는지를 어떻게 알지 그거 모르니까 그냥 다 바꿔주면 된다.
			String query = "update userinfo set name = ? , telno = ? , address = ? , email = ? , relation = ? ";
			String query2 = "where seqno = ?";

			ps = conn_mysql.prepareStatement(query + query2);
			ps.setString(1, tfName.getText().trim());
			ps.setString(2, tfTelno.getText().trim());
			ps.setString(3, tfAddress.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());
			ps.setString(6, tfSeqno.getText().trim());

			i = ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	// insert 시에 field 값 다 들어갔는지 체크
	private int insertFieldCheck() {
		int i = 0;
		String message = "";

		if (tfName.getText().trim().length() == 0) {
			i++;
			message = "이름을 ";
			tfName.requestFocus(); // tfName에 가서 커서가 깜빡인다.
		}

		if (tfTelno.getText().trim().length() == 0) {
			i++;
			message = "번호를 ";
			tfTelno.requestFocus();
		}

		if (tfAddress.getText().trim().length() == 0) {
			i++;
			message = "주소를 ";
			tfAddress.requestFocus();
		}

		if (tfEmail.getText().trim().length() == 0) {
			i++;
			message = "이메일을 ";
			tfEmail.requestFocus();
		}

		if (tfRelation.getText().trim().length() == 0) {
			i++;
			message = "관계를 ";
			tfRelation.requestFocus();
		}

		if (i > 0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요!");
		}

		return i;
	}

	// tf에 입력한 값을 입력
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
			ps.setString(2, tfTelno.getText().trim());
			ps.setString(3, tfAddress.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());
			// insert, update , delete모두 이 method를 통해서 데이터베이스에 넣을 수 있다.
			i = ps.executeUpdate(); // update, select , insert 된 열의 수를 리턴해 준다.

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		return i;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("/Volumes/Data/Academy/Java&Swing/Address/background/—Pngtree—spring dividing line_5413644.png"));
			lblNewLabel.setBounds(-74, 110, 581, 543);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("/Volumes/Data/Academy/Java&Swing/Address/background/05.png"));
			lblNewLabel_1.setBounds(0, 0, 450, 623);
		}
		return lblNewLabel_1;
	}
}
