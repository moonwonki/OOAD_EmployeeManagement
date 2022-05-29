package cm_machine;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;


public class MainScreen extends JFrame implements ListSelectionListener{
	private JLabel noticeBoardTitle = new JLabel(" 인수인계 게시판");
	private JLabel employeeBoardTitle = new JLabel(" 직원 출퇴근 기록부");
	private JList employee_list;				//직원리스트
	private JList noticeBoard_list;//게시판 리스트
	private JTextField noticeBoard_inputField; //게시판 입력 field
	private JButton addBtn;		//게시판 추가 버튼
	private JButton delBtn;		//게시판 삭제 버튼
	private JButton workingOnBtn;//출근 버튼
	private JButton workingOffBtn;//퇴근 버튼
	private JButton employeeManageBtn; //직원 근무시간 초기화 버튼
	private JScrollPane noticeBoard_scrolled;//리스트 스크롤이 가능하게 하기 위한 scroll pane
	private JScrollPane employee_scrolled;
	
	
	public MainScreen(String title, DefaultListModel emp_data, DefaultListModel not_data) {
		super(title);
		
		Font tmp = new Font("맑은 고딕", Font.PLAIN, 15);
		noticeBoard_list = new JList(not_data);
		noticeBoard_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		noticeBoard_list.setFont(tmp);
		
		employee_list = new JList(emp_data);
		employee_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	//하나만 선택 될 수 있도록\
		employee_list.setFont(tmp);
		
		this.setBounds(100, 100, 1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		noticeBoard_inputField = new JTextField();
		noticeBoard_inputField.setBounds(12, 65, 249, 35);
		this.getContentPane().add(noticeBoard_inputField);
		noticeBoard_inputField.setColumns(10);
		
		addBtn=new JButton("추가");
		addBtn.setBounds(273, 65, 78, 36);
		addBtn.setFont(tmp);
		this.getContentPane().add(addBtn);
		
		delBtn=new JButton("삭제");
		delBtn.setBounds(363, 64, 78, 36);
		delBtn.setFont(tmp);
		this.getContentPane().add(delBtn);
		
		workingOnBtn = new JButton("출근");
		workingOnBtn.setBounds(486, 65, 116, 36);
		workingOnBtn.setFont(tmp);
		this.getContentPane().add(workingOnBtn);
		
		workingOffBtn = new JButton("퇴근");
		workingOffBtn.setBounds(614, 65, 116, 36);
		workingOffBtn.setFont(tmp);
		this.getContentPane().add(workingOffBtn);
		
		employeeManageBtn = new JButton("직원 관리");
		employeeManageBtn.setBounds(799, 65, 116, 36);
		employeeManageBtn.setFont(tmp);
		this.getContentPane().add(employeeManageBtn);
		
		tmp = new Font("맑은 고딕", Font.BOLD, 30);
		noticeBoardTitle.setBounds(12, 25, 429, 30);
		noticeBoardTitle.setFont(tmp);
		this.getContentPane().add(noticeBoardTitle);
		
		employeeBoardTitle.setBounds(486, 25, 429, 30);
		employeeBoardTitle.setFont(tmp);
		this.getContentPane().add(employeeBoardTitle);
		
		noticeBoard_scrolled = new JScrollPane();
		noticeBoard_scrolled.setBounds(12, 111, 429, 314);
		noticeBoard_scrolled.setViewportView(noticeBoard_list);
		this.getContentPane().add(noticeBoard_scrolled);
		
		employee_scrolled = new JScrollPane();
		employee_scrolled.setBounds(486, 111, 429, 314);
		employee_scrolled.setViewportView(employee_list);
		this.getContentPane().add(employee_scrolled);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	public void addBtnListener(CommuteControl listenForButton){
		addBtn.addActionListener(listenForButton);
		delBtn.addActionListener(listenForButton);
		workingOnBtn.addActionListener(listenForButton);
		workingOffBtn.addActionListener(listenForButton);
		employeeManageBtn.addActionListener(listenForButton);
	}

	//ListSelectionListener
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()) {	//이거 없으면 mouse 눌릴때, 뗄때 각각 한번씩 호출되서 총 두번 호출
			System.out.println("selected :"+employee_list.getSelectedValue());
		}
	}
	
	//getter
	public String getNoticeInput() {
		return noticeBoard_inputField.getText();
	}
	
	public int getNoticeSelected() {
		return noticeBoard_list.getSelectedIndex();
	}
	
	public int getEmployeeSelected() {
		return employee_list.getSelectedIndex();
	}

}
