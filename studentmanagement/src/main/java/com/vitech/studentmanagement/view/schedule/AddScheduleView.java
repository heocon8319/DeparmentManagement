package com.vitech.studentmanagement.view.schedule;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Schedule;
import com.vitech.studentmanagement.model.Semester;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.service.EmployeeService;
import com.vitech.studentmanagement.service.RoleService;
import com.vitech.studentmanagement.service.ScheduleService;
import com.vitech.studentmanagement.service.SemesterService;
import com.vitech.studentmanagement.service.SubjectService;
import com.vitech.studentmanagement.service.Impl.EmployeeServiceImpl;
import com.vitech.studentmanagement.service.Impl.RoleServiceImpl;
import com.vitech.studentmanagement.service.Impl.ScheduleServiceImpl;
import com.vitech.studentmanagement.service.Impl.SemesterServiceImpl;
import com.vitech.studentmanagement.service.Impl.SubjectServiceImpl;
import com.vitech.studentmanagement.table.ScheduleTable;
import com.vitech.studentmanagement.utility.Constant;

public class AddScheduleView implements ActionListener {

	private JFrame frame;

	private JComboBox<Employee> cbbEmployee;
	private JComboBox<Role> cbbRole;
	private JComboBox<Subject> cbbSubject;
	private JComboBox<Semester> cbbSemester;

	private JButton btnSave;
	private JButton btnCancel;

	private EmployeeService employeeService = new EmployeeServiceImpl();
	private RoleService roleService = new RoleServiceImpl();
	private SubjectService subjectService = new SubjectServiceImpl();
	private ScheduleService scheduleService = new ScheduleServiceImpl();
	private SemesterService semesterService = new SemesterServiceImpl();
	
	private ScheduleTable scheduleTable;

	public void show() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridy = 0;
		gbc.gridx = 0;
		frame.add(new JLabel("Employee"), gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		frame.add(new JLabel("Subject"), gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		frame.add(new JLabel("Semester"), gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		frame.add(new JLabel("Role"), gbc);

		gbc.weightx = 1;
		gbc.gridwidth = 2;

		gbc.gridy = 0;
		gbc.gridx = 1;
		frame.add(getCbbEmployee(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		frame.add(getCbbSubject(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		frame.add(getCbbSemester(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		frame.add(getCbbRole(), gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 4;
		gbc.gridx = 1;
		frame.add(getBtnSave(), gbc);

		gbc.gridy = 4;
		gbc.gridx = 2;
		frame.add(getBtnCancel(), gbc);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnSave()) {
			Employee emp = (Employee) getCbbEmployee().getSelectedItem();
			Subject subj = (Subject) getCbbSubject().getSelectedItem();
			Role rl = (Role) getCbbRole().getSelectedItem();
			Semester sm = (Semester) getCbbSemester().getSelectedItem();
			
			Schedule sch = new Schedule();
			sch.setMaHK(sm.getMaHK());
			sch.setMaMH(subj.getMaMH());
			sch.setMaNV(emp.getCode());
			sch.setVaiTro(rl.getCode());
			
			boolean rs = scheduleService.add(Constant.ROLE, sch);
			if(rs){
				this.scheduleTable.createTableModel();
				this.frame.dispose();
			}else{
				JOptionPane.showMessageDialog(this.frame, "Data is overlap", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == getBtnCancel()) {
			this.frame.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public AddScheduleView(ScheduleTable scheduleTable) {
		initialize();
		this.scheduleTable = scheduleTable;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		createFrame();
		createBtnSave();
		createBtnCancel();
		
		createCbbEmployee();
		createCbbRole();
		createCbbSemester();
		createCbbSubject();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Add New Schedule");
		frame.setBounds(100, 100, 350, 300);
		frame.setLayout(new GridBagLayout());
		frame.setVisible(true);
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void createBtnSave() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.SAVE_ICON));
		this.btnSave = new JButton("Save", icon);
		this.btnSave.addActionListener(this);
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void createBtnCancel() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				Constant.CLOSE_ICON));
		this.btnCancel = new JButton("Cancle", icon);
		this.btnCancel.addActionListener(this);
	}

	public JComboBox<Employee> getCbbEmployee() {
		return cbbEmployee;
	}

	public void createCbbEmployee() {
		final DefaultComboBoxModel<Employee> model = new DefaultComboBoxModel<Employee>();
		List<Employee> employees = employeeService.findAll(Constant.ROLE);
		for (Employee em : employees) {
			model.addElement(em);
		}
		this.cbbEmployee = new JComboBox<Employee>(model);
		this.cbbEmployee.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Employee) {
					Employee employee = (Employee) value;
					setText(employee.getName());
				}
				return this;
			}
		});
		this.cbbEmployee.addActionListener(this);

	}

	public JComboBox<Role> getCbbRole() {
		return cbbRole;
	}

	public void createCbbRole() {
		final DefaultComboBoxModel<Role> model = new DefaultComboBoxModel<Role>();
		List<Role> roles = roleService.findAll(Constant.ROLE);
		for (Role rl : roles) {
			model.addElement(rl);
		}
		this.cbbRole = new JComboBox<Role>(model);
		this.cbbRole.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Role) {
					Role r = (Role) value;
					setText(r.getName());
				}
				return this;
			}
		});
		this.cbbRole.addActionListener(this);
	}

	public JComboBox<Subject> getCbbSubject() {
		return cbbSubject;
	}

	public void createCbbSubject() {
		final DefaultComboBoxModel<Subject> model = new DefaultComboBoxModel<Subject>();
		List<Subject> subjects = subjectService.findAll(Constant.ROLE);
		for (Subject s : subjects) {
			model.addElement(s);
		}
		this.cbbSubject = new JComboBox<Subject>(model);
		this.cbbSubject.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Subject) {
					Subject sb = (Subject) value;
					setText(sb.getTenMH());
				}
				return this;
			}
		});
		this.cbbSubject.addActionListener(this);
	}

	public JComboBox<Semester> getCbbSemester() {
		return cbbSemester;
	}

	public void createCbbSemester() {
		final DefaultComboBoxModel<Semester> model = new DefaultComboBoxModel<Semester>();
		List<Semester> semesters = semesterService.findAll(Constant.ROLE);
		for (Semester s : semesters) {
			model.addElement(s);
		}
		this.cbbSemester = new JComboBox<Semester>(model);
		this.cbbSemester.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Semester) {
					Semester sb = (Semester) value;
					setText(sb.getMaHK());
				}
				return this;
			}
		});
		this.cbbSemester.addActionListener(this);
	}
}
