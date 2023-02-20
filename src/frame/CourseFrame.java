package frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CourseFrame extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public CourseFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("과목코드");
		lblNewLabel.setBounds(143, 127, 57, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(204, 124, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("과목명");
		lblNewLabel_1.setBounds(143, 152, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 149, 116, 21);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("학점");
		lblNewLabel_1_1.setBounds(143, 177, 57, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(204, 174, 116, 21);
		getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("등록하기");
		btnNewButton.setBounds(133, 263, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소하기");
		btnNewButton_1.setBounds(242, 263, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		// 2줄 추가하기
		this.setSize(500, 400);
		this.setVisible(true);
		
		
	}
	

}
