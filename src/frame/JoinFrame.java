package frame;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

// 1. extends JDialog 상속
public class JoinFrame extends JDialog{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JoinFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("회원가입");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(155, 23, 78, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(91, 77, 57, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(147, 74, 138, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(91, 108, 57, 15);
		getContentPane().add(lblPw);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 105, 138, 21);
		getContentPane().add(textField_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(91, 139, 57, 15);
		getContentPane().add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 136, 138, 21);
		getContentPane().add(textField_2);
		
		JLabel lblPw_1_1 = new JLabel("Phone");
		lblPw_1_1.setBounds(91, 170, 57, 15);
		getContentPane().add(lblPw_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 167, 138, 21);
		getContentPane().add(textField_3);
		
		JLabel lblPw_1_1_1 = new JLabel("Role");
		lblPw_1_1_1.setBounds(91, 201, 57, 15);
		getContentPane().add(lblPw_1_1_1);
			
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(147, 198, 138, 21);
		getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("등록하기");
		btnNewButton.setBounds(147, 265, 90, 23);
		getContentPane().add(btnNewButton);
		
		
		// 3줄 추가
		this.setModal(true);
		this.setSize(402,362);
		this.setVisible(true);
	}
}
