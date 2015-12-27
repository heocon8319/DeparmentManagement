package com.vitech.studentmanagement.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.utility.Constant;
import com.vitech.studentmanagement.utility.Utilities;
import com.vitech.studentmanagement.view.employee.EmployeeView;
import com.vitech.studentmanagement.view.register.RegisterSubjectView;
import com.vitech.studentmanagement.view.schedule.ScheduleView;
import com.vitech.studentmanagement.view.score.ScoreView;
import com.vitech.studentmanagement.view.speciality.SpecialityView;
import com.vitech.studentmanagement.view.student.StudentView;
import com.vitech.studentmanagement.view.subject.SubjectView;
import com.vitech.studentmanagement.view.subjectspciality.SubjectSpeciallyView;
import com.vitech.studentmanagement.view.teacher.TeacherView;

@SuppressWarnings("serial")
public class DashboardView extends ParentUI implements ActionListener {	

	private JFrame frame;

	private JLabel lbTitle;
	private JLabel avatar;
	private JLabel lbEmployeeName;
	private JLabel lbEmployeeCode;

	private JButton btnScoreManagement;
	private JButton btnEmployeeManagement;
	private JButton btnStudentManagement;
	private JButton btnTeacherManagement;
	private JButton btnSpecialityManagement;
	private JButton btnScheduleManagement;
	private JButton btnSubjectSpeciality;
	private JButton btnSubjectManagement;
	private JButton btnRegisterSubjectManagement;
	
	private JMenuBar menubar;
	
	private JMenu mfile;
	private JMenu mConfiguration;
	private JMenu mHelp;
	
	private JMenuItem miExit;
	private JMenuItem miLogout;
	private JMenuItem miEnglish;
	private JMenuItem miVietnames;
	private JMenuItem miSupport;
	
	private Role employee;
	
	private JPanel Viewlist;

	public DashboardView(Role employee) {
		this.employee = employee;
		initialize();
	}

	private void initialize() {
		createFrame();
		createLbTitle();
		createBtnScoreManagement();
		createBtnSubjectManagement();
		createBtnEmployeeManagement();
		createBtnSpecialityManagement();
		createBtnScheduleManagement();
		createBtnTeacherManagement();
		createBtnStudentManagement();
		createBtnSubjectSpeciality();		
		createBtnRegisterSubjectManagement();
		createBarMenu();		
		createMiExit();
		createMiLogout();
		createMiEnglish();
		createMiVietnames();
		createMiSupport();
		createMfile();
		createmConfiguration();
		createmDocument();		
		createLbEmployeeCode();
		createLbEmployeeName();
		createAvatar();
		createViewlist();
	}

	public void show() {
		createMenuBar();
		
		FlowLayout flTitle = new FlowLayout();
		flTitle.setAlignment(FlowLayout.CENTER);
		JPanel pTitle = new JPanel(flTitle);
		pTitle.add(getLbTitle());
		getFrame().add(pTitle, BorderLayout.NORTH);
		
		GridBagLayout gblInfor = new GridBagLayout();
		JPanel pInfo = new JPanel(gblInfor);
		pInfo.setBorder(BorderFactory.createTitledBorder("Staff's information"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.gridwidth=3;
		pInfo.add(getAvatar(),gbc);
		gbc.gridy=1;
		gbc.gridx=2;
		pInfo.add(getLbEmployeeCode(),gbc);
		gbc.gridy=2;
		gbc.gridx=2;
		pInfo.add(getLbEmployeeName(),gbc);
		
		JPanel pButtons = new JPanel();
		pButtons.setBorder(BorderFactory.createTitledBorder("Navigation"));
		GridLayout flButtons = new GridLayout(9, 1, 5, 20);
		pButtons.setLayout(flButtons);
		pButtons.add(getBtnEmployeeManagement());
		pButtons.add(getBtnSubjectManagement());
		pButtons.add(getBtnSpecialityManagement());
		pButtons.add(getBtnStudentManagement());
		pButtons.add(getBtnScheduleManagement());
		pButtons.add(getBtnTeacherManagement());
		pButtons.add(getBtnSubjectSpeciality());
		pButtons.add(getBtnScoreManagement());
		pButtons.add(getBtnRegisterSubjectManagement());

		JPanel pLeft = new JPanel(new BorderLayout());
		pLeft.add(pInfo,BorderLayout.NORTH);
		pLeft.add(pButtons,BorderLayout.CENTER);
		getFrame().add(pLeft, BorderLayout.WEST);
        
        EmployeeView employeeView = new EmployeeView();
        getViewlist().add(employeeView.createUI(), Constant.EMPLOYEE_VIEW);
        
        RegisterSubjectView registerSubjectView = new RegisterSubjectView();
        getViewlist().add(registerSubjectView.createUI(), Constant.REGISTER_SUBJECT_VIEW);
        
        ScheduleView scheduleView = new ScheduleView();
        getViewlist().add(scheduleView.createUI(), Constant.SCHEDULE_VIEW);
        
        ScoreView scoreView = new ScoreView();
        getViewlist().add(scoreView.createUI(), Constant.SCORE_VIEW);
        
        SpecialityView specialityView = new SpecialityView();
        getViewlist().add(specialityView.createUI(), Constant.SPECIALITY_VIEW);
        
        StudentView studentView = new StudentView();
        getViewlist().add(studentView.createUI(), Constant.STUDENT_VIEW);
        
        SubjectView subjectView = new SubjectView();
        getViewlist().add(subjectView.createUI(), Constant.SUBJECT_VIEW);
        
        TeacherView teacherView = new TeacherView();
        getViewlist().add(teacherView.createUI(), Constant.TEACHER_VIEW);
        
        SubjectSpeciallyView divisionView = new SubjectSpeciallyView();
        getViewlist().add(divisionView.createUI(), Constant.SUBJECT_SPECIALITY_VIEW);
        
        getFrame().add(getViewlist(), BorderLayout.CENTER);
        
        CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
        cardLayout.show(getViewlist(), Constant.SCHEDULE_VIEW);
	}

	private void createMenuBar() {

		getMenubar().add(getMfile());
		getMenubar().add(getmConfiguration());
		getMenubar().add(getmDocument());
		getFrame().setJMenuBar(getMenubar());
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getBtnEmployeeManagement()){
			 CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		     cardLayout.show(getViewlist(), Constant.EMPLOYEE_VIEW);
		}
		if(e.getSource() == getBtnSubjectManagement()){
			CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		    cardLayout.show(getViewlist(), Constant.SUBJECT_VIEW);
		}
		if(e.getSource() == getBtnSpecialityManagement()){
			 CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		     cardLayout.show(getViewlist(), Constant.SPECIALITY_VIEW);
		}
		if(e.getSource() == getBtnStudentManagement()){
			CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		    cardLayout.show(getViewlist(), Constant.STUDENT_VIEW);
		}
		if(e.getSource() == getBtnScheduleManagement()){
			 CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		     cardLayout.show(getViewlist(), Constant.SCHEDULE_VIEW);
		}
		if(e.getSource() == getBtnTeacherManagement()){
			CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		    cardLayout.show(getViewlist(), Constant.TEACHER_VIEW);
		}
		if(e.getSource() == getBtnSubjectSpeciality()){
			 CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		     cardLayout.show(getViewlist(), Constant.SUBJECT_SPECIALITY_VIEW);
		}
		if(e.getSource() == getBtnScoreManagement()){
			CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		    cardLayout.show(getViewlist(), Constant.SCORE_VIEW);
		}
		if(e.getSource() == getBtnRegisterSubjectManagement()){
			 CardLayout cardLayout = (CardLayout) getViewlist().getLayout();
		     cardLayout.show(getViewlist(), Constant.REGISTER_SUBJECT_VIEW);
		}
		if(e.getSource() == getMiLogout()){
			this.frame.dispose();
			LoginView loginView = new LoginView();
			loginView.show();
		}
		if(e.getSource() == getMiExit()){
			System.exit(0);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Dashboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fullScreen(frame);
		frame.setVisible(true);		
		frame.setIconImage(Utilities.WINDOW_ICON.getImage());
		frame.setLayout(new BorderLayout());
	}

	public JLabel getLbTitle() {
		return lbTitle;
	}

	public void createLbTitle() {
		this.lbTitle = new JLabel("DEPARMENT MANAGEMENT");
	}

	public JButton getBtnScoreManagement() {
		return btnScoreManagement;
	}

	public void createBtnScoreManagement() {
		this.btnScoreManagement = new JButton("SCORE MANAGEMENT");
		this.btnScoreManagement.addActionListener(this);
	}

	public JButton getBtnEmployeeManagement() {
		return btnEmployeeManagement;
	}

	public void createBtnEmployeeManagement() {
		this.btnEmployeeManagement = new JButton("EMPLOYEE MANAGEMENT");
		this.btnEmployeeManagement.addActionListener(this);
	}

	public JButton getBtnStudentManagement() {
		return btnStudentManagement;
	}

	public void createBtnStudentManagement() {
		this.btnStudentManagement = new JButton("STUDENT MANAGEMENT");
		this.btnStudentManagement.addActionListener(this);
	}

	public JButton getBtnTeacherManagement() {
		return btnTeacherManagement;
	}

	public void createBtnTeacherManagement() {
		this.btnTeacherManagement = new JButton("TEACHER MANAGEMENT");
		this.btnTeacherManagement.addActionListener(this);
	}

	public JButton getBtnSpecialityManagement() {
		return btnSpecialityManagement;
	}

	public void createBtnSpecialityManagement() {
		this.btnSpecialityManagement = new JButton("SPECIALITY MANAGEMENT");
		this.btnSpecialityManagement.addActionListener(this);
	}

	public JButton getBtnScheduleManagement() {
		return btnScheduleManagement;
	}

	public void createBtnScheduleManagement() {
		this.btnScheduleManagement = new JButton("SCHEDULE MANAGEMENT");
		this.btnScheduleManagement.addActionListener(this);
	}

	public JButton getBtnSubjectSpeciality() {
		return btnSubjectSpeciality;
	}

	public void createBtnSubjectSpeciality() {
		this.btnSubjectSpeciality = new JButton("SUBJECT SPECIALITY");
		this.btnSubjectSpeciality.addActionListener(this);
	}

	public JButton getBtnSubjectManagement() {
		return btnSubjectManagement;
	}

	public void createBtnSubjectManagement() {
		this.btnSubjectManagement = new JButton("SUBJECT MANAGEMENT");
		this.btnSubjectManagement.addActionListener(this);
	}

	public JMenuBar getMenubar() {
		return menubar;
	}

	public void createBarMenu() {
		this.menubar = new JMenuBar();
	}

	public JMenu getMfile() {
		return mfile;
	}

	public void createMfile() {
		this.mfile = new JMenu("File");
		this.mfile.setMnemonic(KeyEvent.VK_F);
		this.mfile.add(getMiExit());
		this.mfile.add(getMiLogout());
	}

	public JMenu getmConfiguration() {
		return mConfiguration;
	}

	public void createmConfiguration() {
		this.mConfiguration = new JMenu("Configuration");
		this.mConfiguration.setMnemonic(KeyEvent.VK_C);
		this.mConfiguration.add(getMiEnglish());
		this.mConfiguration.add(getMiVietnames());
	}

	public JMenu getmDocument() {
		return mHelp;
	}

	public void createmDocument() {
		this.mHelp = new JMenu("Help");
		this.mHelp.setMnemonic(KeyEvent.VK_H);
		this.mHelp.add(getMiSupport());
	}

	public JMenuItem getMiExit() {
		return miExit;
	}

	public void createMiExit() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.CLOSE_ICON));
		this.miExit = new JMenuItem("Exit", icon);
		this.miExit.setMnemonic(KeyEvent.VK_E);
		this.miExit.addActionListener(this);
	}

	public JMenuItem getMiEnglish() {
		return miEnglish;
	}

	public void createMiEnglish() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.BRISTISH_ICON));
		this.miEnglish = new JMenuItem("English",icon);
		this.miEnglish.setMnemonic(KeyEvent.VK_E);
	}

	public JMenuItem getMiVietnames() {
		return miVietnames;
	}

	public void createMiVietnames() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.VIETNAM_ICON));
		this.miVietnames = new JMenuItem("Vietnames",icon);
		this.miVietnames.setMnemonic(KeyEvent.VK_V);
	}

	public JMenuItem getMiSupport() {
		return miSupport;
	}

	public void createMiSupport() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.HELP_ICON));
		this.miSupport = new JMenuItem("Suport", icon);
		this.miSupport.setMnemonic(KeyEvent.VK_S);
	}

	public JMenuItem getMiLogout() {
		return miLogout;
	}

	public void createMiLogout(){
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.EXIST_ICON));
		this.miLogout = new JMenuItem("Logout", icon);
		this.miLogout.setMnemonic(KeyEvent.VK_L);
		this.miLogout.addActionListener(this);
	}

	public JLabel getLbEmployeeName() {
		return lbEmployeeName;
	}

	public void createLbEmployeeName() {
		this.lbEmployeeName = new JLabel("Name: "+getEmployee().getName());
	}

	public JLabel getLbEmployeeCode() {
		return lbEmployeeCode;
	}

	public void createLbEmployeeCode() {
		this.lbEmployeeCode = new JLabel("Code: "+getEmployee().getCode());
	}

	public JLabel getAvatar() {
		return avatar;
	}

	public void createAvatar() {
		ImageIcon icon = new ImageIcon(getClass().getResource(getEmployee().getImage()));
		this.avatar = new JLabel(icon);
	}

	public Role getEmployee() {
		return employee;
	}

	public JButton getBtnRegisterSubjectManagement() {
		return btnRegisterSubjectManagement;
	}

	public void createBtnRegisterSubjectManagement() {
		this.btnRegisterSubjectManagement = new JButton("REGISTER SUBJECT");
		this.btnRegisterSubjectManagement.addActionListener(this);
	}

	private JPanel getViewlist() {
		return Viewlist;
	}

	private void createViewlist() {
		Viewlist = new JPanel(new CardLayout());
	}
}
