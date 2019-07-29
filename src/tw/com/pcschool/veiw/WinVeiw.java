/* Copyright (c) 2019, Hsin Yu Huang */

package tw.com.pcschool.veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import tw.com.pcschool.domain.Student;
import tw.com.pcschool.factory.StudentDao;
import tw.com.pcschool.impl.StudentImpl;
import tw.com.pcschool.message.Message;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.sql.ResultSet;

import java.awt.event.ActionEvent;

/**
 * Author: Hsin Yu Huang<br>
 * Date: 2019年7月29日<br>
 * TODO<br>
 *
 *
 */

public class WinVeiw extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField stuId;
	private JTextField stuName;
	private JTextField stuAge;
	private JTextField stuPhone;
	private JTextField stuAddress;
	private JTextField selectOne;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinVeiw frame = new WinVeiw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinVeiw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblID.setBounds(27, 33, 116, 36);
		contentPane.add(lblID);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblName.setBounds(27, 138, 116, 36);
		contentPane.add(lblName);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblAge.setBounds(27, 243, 116, 36);
		contentPane.add(lblAge);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblPhone.setBounds(27, 348, 116, 36);
		contentPane.add(lblPhone);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblAddress.setBounds(27, 453, 116, 36);
		contentPane.add(lblAddress);

		JLabel label_4 = new JLabel("搜尋");
		label_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		label_4.setBounds(351, 33, 116, 36);
		contentPane.add(label_4);

		stuId = new JTextField();
		stuId.setEditable(false);
		stuId.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		stuId.setBounds(139, 29, 133, 44);
		contentPane.add(stuId);
		stuId.setColumns(10);

		stuName = new JTextField();
		stuName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		stuName.setColumns(10);
		stuName.setBounds(139, 134, 133, 44);
		contentPane.add(stuName);

		stuAge = new JTextField();
		stuAge.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		stuAge.setColumns(10);
		stuAge.setBounds(139, 239, 133, 44);
		contentPane.add(stuAge);

		stuPhone = new JTextField();
		stuPhone.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		stuPhone.setColumns(10);
		stuPhone.setBounds(139, 344, 133, 44);
		contentPane.add(stuPhone);

		stuAddress = new JTextField();
		stuAddress.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		stuAddress.setColumns(10);
		stuAddress.setBounds(139, 449, 133, 44);
		contentPane.add(stuAddress);

		selectOne = new JTextField();
		selectOne.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		selectOne.setColumns(10);
		selectOne.setBounds(438, 30, 151, 44);
		contentPane.add(selectOne);

		JButton btnAdd = new JButton("新增");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Student stu = new Student();
					StudentDao dao = new StudentImpl();// 多型

					String name = stuName.getText().toString();
					int age = Integer.parseInt(stuAge.getText());
					String phone = stuPhone.getText().toString();
					String address = stuAddress.getText().toString();

					stu.setStuName(name);
					stu.setStuAge(age);
					stu.setStuPhone(phone);
					stu.setStuAdress(address);
					try {
						dao.addStudent(stu);
						clearFilter();
						ResultSet rs;
						rs = dao.selectAllStudent();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {

						e1.printStackTrace();
					}

				} catch (NumberFormatException e) {
					// e.printStackTrace();
					Message.getMessage("新增資料錯誤");
				}

			}

		});
		btnAdd.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnAdd.setBounds(139, 539, 133, 36);
		contentPane.add(btnAdd);

		JButton btnAll = new JButton("完整搜尋");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StudentDao dao = new StudentImpl();// 多型
					ResultSet rs = dao.selectAllStudent();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					// e.printStackTrace();
					Message.getMessage("資料讀取錯誤");
				}

			}
		});
		btnAll.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnAll.setBounds(663, 90, 133, 36);
		contentPane.add(btnAll);

		JButton btnOne = new JButton("條件搜尋");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = selectOne.getText().toString();
				StudentDao dao = new StudentImpl();// 多型
				if (name.equals("")) {
					Message.getMessage("請輸入資料");
				} else {
					try {

						ResultSet rs = dao.oneSelect(name);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						selectOne.setText("");
					} catch (Exception ex) {
						// e.printStackTrace();
						Message.getMessage("資料讀取錯誤");
					}
				}

			}
		});
		btnOne.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnOne.setBounds(663, 33, 133, 36);
		contentPane.add(btnOne);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 137, 494, 451);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public void clearFilter() {
		stuName.setText("");
		stuAge.setText("");
		stuPhone.setText("");
		stuAddress.setText("");
	}

}
