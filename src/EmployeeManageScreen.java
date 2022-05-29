package cm_machine;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class EmployeeManageScreen extends JFrame implements ListSelectionListener{
	
	private JLabel titleLabel = new JLabel("직원 관리 윈도우");
	private JTextField employee_inputField;	//직원 이름 입력 Field
	private JButton addEmpBtn;
	private JButton removeEmpBtn;
	private JButton checkBtn;
	
	private JLabel workTimeLabel = new JLabel("**시 **분");
	private JTextField hour_inputField;
	private JTextField min_inputField;
	private JButton resetTimeBtn;
	
	private JScrollPane manageEmp_scrolled;
	private JList manageEmp_List;
	
	private DefaultListModel employee_data;
	
	private JTextField password_inputField;
	private JLabel password_label = new JLabel("비밀번호: ");
	
	
	public EmployeeManageScreen(String title, DefaultListModel emp_data) {
		super(title);
		Font tmp = new Font("맑은 고딕", Font.PLAIN, 15);
		employee_data = emp_data;
		manageEmp_List = new JList(employee_data);
		manageEmp_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	//하나만 선택 될 수 있도록\
		manageEmp_List.setFont(tmp);
		
		this.setBounds(100, 100, 500, 500);
		this.getContentPane().setLayout(null);
		
		employee_inputField = new JTextField();
		employee_inputField.setBounds(12, 65, 249, 36);
		this.getContentPane().add(employee_inputField);
		employee_inputField.setColumns(10);
		
		titleLabel.setBounds(12, 25, 429, 30);
		titleLabel.setFont(tmp);
		this.getContentPane().add(titleLabel);
		
		addEmpBtn = new JButton("직원 추가");
		addEmpBtn.setBounds(273, 65, 78, 36);
		tmp = new Font("맑은 고딕", Font.PLAIN, 10);
		addEmpBtn.setFont(tmp);
		this.getContentPane().add(addEmpBtn);
		
		removeEmpBtn = new JButton("직원 삭제");
		removeEmpBtn.setBounds(363, 64, 78, 36);
		tmp = new Font("맑은 고딕", Font.PLAIN, 10);
		removeEmpBtn.setFont(tmp);
		this.getContentPane().add(removeEmpBtn);
		
		manageEmp_scrolled = new JScrollPane();
		manageEmp_scrolled.setBounds(12, 111, 439, 220);
		manageEmp_scrolled.setViewportView(manageEmp_List);
		this.getContentPane().add(manageEmp_scrolled);
		
		
		password_label.setBounds(12, 345, 178, 36);
		tmp = new Font("맑은 고딕", Font.PLAIN, 15);
		password_label.setFont(tmp);
		this.getContentPane().add(password_label);
		
		password_inputField = new JTextField();
		password_inputField.setColumns(10);
		password_inputField.setBounds(202, 345, 249, 36);
		this.getContentPane().add(password_inputField);
		
		workTimeLabel.setBounds(12, 391, 67, 36);
		workTimeLabel.setFont(tmp);
		this.getContentPane().add(workTimeLabel);
		
		checkBtn = new JButton("시간 확인");
		checkBtn.setBounds(124, 391, 78, 36);
		tmp = new Font("맑은 고딕", Font.PLAIN, 10);
		checkBtn.setFont(tmp);
		this.getContentPane().add(checkBtn);
		
		hour_inputField = new JTextField();
		hour_inputField.setColumns(10);
		hour_inputField.setBounds(250, 391, 36, 36);
		this.getContentPane().add(hour_inputField);
		
		min_inputField = new JTextField();
		min_inputField.setColumns(10);
		min_inputField.setBounds(298, 391, 36, 36);
		this.getContentPane().add(min_inputField);
		
		resetTimeBtn = new JButton("시간 변경");
		resetTimeBtn.setBounds(363, 391, 78, 36);
		resetTimeBtn.setFont(tmp);
		this.getContentPane().add(resetTimeBtn);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()) {	//이거 없으면 mouse 눌릴때, 뗄때 각각 한번씩 호출되서 총 두번 호출
			System.out.println("selected :"+manageEmp_List.getSelectedValue());
		}
	}
	
	public void addBtnListener(CommuteControl listenForButton){
		addEmpBtn.addActionListener(listenForButton);
		removeEmpBtn.addActionListener(listenForButton);
		checkBtn.addActionListener(listenForButton);
		resetTimeBtn.addActionListener(listenForButton);
	}
	
	//getter
	public String getEmployeeInput() {
		return employee_inputField.getText();
	}
	
	public int getEmployeeSelected() {
		return manageEmp_List.getSelectedIndex();
	}
	
	public String getHourInput() {
		return hour_inputField.getText();
	}
	public String getMinInput() {
		return min_inputField.getText();
	}
	
	public String getPasswordInput() {
		return password_inputField.getText();
	}
	
	//setter
	public void setWorkTime(String input) {
		workTimeLabel.setText(input);
	}

}
