package com.vitech.studentmanagement.view.employee;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.service.EmployeeService;
import com.vitech.studentmanagement.service.RoleService;
import com.vitech.studentmanagement.service.Impl.EmployeeServiceImpl;
import com.vitech.studentmanagement.service.Impl.RoleServiceImpl;
import com.vitech.studentmanagement.table.EmployeeTable;
import com.vitech.studentmanagement.utility.Constant;

public class AddEmployeeView implements ActionListener {

	private JFrame frame;

	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtSalary;
	private JTextField txtBonus;
	private JTextField txtHomeTown;

	private JComboBox<Employee> cbbManager;
	private JComboBox<Role> cbbRole;

	private JComboBox<String> cbbSex;

	private JDatePickerImpl datePicker;

	private JButton btnSave;
	private JButton btnCancel;

	private EmployeeTable employeeTable;
	private EmployeeService employeeService = new EmployeeServiceImpl();
	private RoleService roleService = new RoleServiceImpl();

	public void show() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridy = 0;
		gbc.gridx = 0;
		frame.add(new JLabel("Code"), gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		frame.add(new JLabel("Name"), gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		frame.add(new JLabel("Address"), gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		frame.add(new JLabel("Phone"), gbc);

		gbc.gridy = 4;
		gbc.gridx = 0;
		frame.add(new JLabel("Sex"), gbc);

		gbc.gridy = 5;
		gbc.gridx = 0;
		frame.add(new JLabel("Salary"), gbc);

		gbc.gridy = 6;
		gbc.gridx = 0;
		frame.add(new JLabel("Bonus"), gbc);

		gbc.gridy = 7;
		gbc.gridx = 0;
		frame.add(new JLabel("Home Town"), gbc);

		gbc.gridy = 8;
		gbc.gridx = 0;
		frame.add(new JLabel("Manager"), gbc);

		gbc.gridy = 9;
		gbc.gridx = 0;
		frame.add(new JLabel("Role"), gbc);

		gbc.gridy = 10;
		gbc.gridx = 0;
		frame.add(new JLabel("DOB"), gbc);

		gbc.weightx = 1;
		gbc.gridwidth = 2;

		gbc.gridy = 0;
		gbc.gridx = 1;
		frame.add(getTxtCode(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		frame.add(getTxtName(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		frame.add(getTxtAddress(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		frame.add(getTxtPhone(), gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		frame.add(getCbbSex(), gbc);

		gbc.gridy = 5;
		gbc.gridx = 1;
		frame.add(getTxtSalary(), gbc);

		gbc.gridy = 6;
		gbc.gridx = 1;
		frame.add(getTxtBonus(), gbc);

		gbc.gridy = 7;
		gbc.gridx = 1;
		frame.add(getTxtHomeTown(), gbc);

		gbc.gridy = 8;
		gbc.gridx = 1;
		frame.add(getCbbManager(), gbc);

		gbc.gridy = 9;
		gbc.gridx = 1;
		frame.add(getCbbRole(), gbc);

		gbc.gridy = 10;
		gbc.gridx = 1;
		frame.add(getDatePicker(), gbc);

		gbc.gridwidth = 1;

		gbc.gridy = 11;
		gbc.gridx = 1;
		frame.add(getBtnSave(), gbc);

		gbc.gridy = 11;
		gbc.gridx = 2;
		frame.add(getBtnCancel(), gbc);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnSave()) {
			String strCode = getTxtCode().getText(); 
			String strName = getTxtName().getText();
			 
			 String strAddress = getTxtAddress().getText();
			 String strPhone = getTxtPhone().getText();
			 String strSex = (String) getCbbSex().getSelectedItem();
			 String salary = getTxtSalary().getText();
			 String bonus = getTxtBonus().getText();
			 String homeTown = getTxtHomeTown().getText();
			 Employee manager = (Employee) getCbbManager().getSelectedItem();
			 Role rl = (Role) getCbbRole().getSelectedItem();
			 
			 Date dob = (Date) getDatePicker().getModel().getValue();
			 SimpleDateFormat sdf = new SimpleDateFormat(Constant.PATTERN_DATE);
			 String strDob = sdf.format(dob);
			 
			 Employee emp = new Employee();
			 emp.setCode(strCode);
			 emp.setName(strName);
			 emp.setAddress(strAddress);
			 emp.setPhone(strPhone);
			 emp.setSex(strSex);
			 emp.setSalary(Integer.parseInt(salary));
			 emp.setBonus(Integer.parseInt(bonus));
			 emp.setHomeTown(homeTown);
			 emp.setManagerCode(manager.getCode());
			 emp.setRoleCode(rl.getCode());
			 emp.setDob(strDob);
			 
			 boolean rs = employeeService.add(Constant.ROLE, emp);
			 if(rs){
				 this.employeeTable.createTableModel();
				 this.frame.dispose();
			 }
		}
		if (e.getSource() == getBtnCancel()) {
			this.frame.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public AddEmployeeView(EmployeeTable employeeTable) {
		initialize();
		this.employeeTable = employeeTable;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		createFrame();
		createCbbSex();
		createDatePicker();
		createTxtAddress();
		createTxtName();
		createTxtPhone();
		createBtnSave();
		createBtnCancel();
		createTxtCode();
		createTxtSalary();
		createTxtSalary();
		createTxtBonus();
		createTxtHomeTown();
		createCbbManager();
		createCbbRole();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Add New Employee");
		frame.setBounds(100, 100, 350, 550);
		frame.setLayout(new GridBagLayout());
		frame.setVisible(true);
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void createTxtName() {
		this.txtName = new JTextField();
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public void createTxtAddress() {
		this.txtAddress = new JTextField();
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public void createTxtPhone() {
		this.txtPhone = new JTextField();
	}

	public JComboBox<String> getCbbSex() {
		return cbbSex;
	}

	public void createCbbSex() {
		this.cbbSex = new JComboBox<String>();
		this.cbbSex.addItem("Nam");
		this.cbbSex.addItem("Nu");
	}

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void createDatePicker() {
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		this.datePicker = new JDatePickerImpl(datePanel);
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void createBtnSave() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				Constant.SAVE_ICON));
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

	public JTextField getTxtCode() {
		return txtCode;
	}

	public void createTxtCode() {
		this.txtCode = new JTextField();
	}

	public JTextField getTxtSalary() {
		return txtSalary;
	}

	public void createTxtSalary() {
		this.txtSalary = new JTextField();
	}

	public JTextField getTxtBonus() {
		return txtBonus;
	}

	public void createTxtBonus() {
		this.txtBonus = new JTextField();
	}

	public JTextField getTxtHomeTown() {
		return txtHomeTown;
	}

	public void createTxtHomeTown() {
		this.txtHomeTown = new JTextField();
	}

	public JComboBox<Employee> getCbbManager() {
		return cbbManager;
	}

	public void createCbbManager() {
		final DefaultComboBoxModel<Employee> model = new DefaultComboBoxModel<Employee>();
		List<Employee> employees = employeeService.findAll(Constant.ROLE);
		for (Employee em : employees) {
			model.addElement(em);
		}
		this.cbbManager = new JComboBox<Employee>(model);
		this.cbbManager.setRenderer(new DefaultListCellRenderer() {
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
		this.cbbManager.addActionListener(this);

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
}
