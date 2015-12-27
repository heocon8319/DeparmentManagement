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

public class EditEmployeeView implements ActionListener {

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
	
	private JLabel lbSalary;
	private JLabel lbBonus;
	private JLabel lbManager;
	private JLabel lbRole;

	private JButton btnSave;
	private JButton btnCancel;

	private EmployeeTable employeeTable;
	private EmployeeService employeeService = new EmployeeServiceImpl();
	private RoleService roleService = new RoleServiceImpl();

	private String maNv;
	
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
		frame.add(getLbSalary(), gbc);

		gbc.gridy = 6;
		gbc.gridx = 0;
		frame.add(getLbBonus(), gbc);

		gbc.gridy = 7;
		gbc.gridx = 0;
		frame.add(new JLabel("Home Town"), gbc);

		gbc.gridy = 8;
		gbc.gridx = 0;
		frame.add(getLbManager(), gbc);

		gbc.gridy = 9;
		gbc.gridx = 0;
		frame.add(getLbRole(), gbc);

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

	private void findById() {
		Employee employee = this.employeeTable.employeeService.find(
				Constant.ROLE, this.maNv);
		getTxtCode().setText(employee.getCode());
		getTxtName().setText(employee.getName());
		getTxtAddress().setText(employee.getAddress());
		getTxtPhone().setText(employee.getPhone());
		getTxtBonus().setText(String.valueOf(employee.getBonus()));
		getTxtSalary().setText(String.valueOf(employee.getSalary()));
		getTxtHomeTown().setText(employee.getHomeTown());
		getCbbSex().setSelectedItem(employee.getSex());

		int cbbSize = getCbbManager().getModel().getSize();
		for (int i = 0; i < cbbSize; i++) {
			if (getCbbManager().getModel().getElementAt(i).getCode()
					.equals(employee.getManagerCode())) {
				getCbbManager().setSelectedIndex(i);
			}
		}

		cbbSize = getCbbRole().getModel().getSize();
		for (int i = 0; i < cbbSize; i++) {
			if (cbbRole.getModel().getElementAt(i).getCode()
					.equals(employee.getRoleCode())) {
				cbbRole.setSelectedIndex(i);
			}
		}

		try {
			String strBOD = employee.getDob().substring(0,
					employee.getDob().indexOf(" 00"));
			String[] strDate = strBOD.split("-");
			getDatePicker().getModel().setDate(Integer.parseInt(strDate[0]),
					Integer.parseInt(strDate[1]) - 1,
					Integer.parseInt(strDate[2]));
			getDatePicker().getModel().setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			emp.setHomeTown(homeTown);
			emp.setDob(strDob);
			emp.setSalary(Integer.parseInt(salary));
			emp.setBonus(Integer.parseInt(bonus));
			emp.setManagerCode(manager.getCode());
			emp.setRoleCode(rl.getCode());
			

			boolean rs = employeeService.update(Constant.ROLE, emp);
			if (rs) {
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
	public EditEmployeeView(EmployeeTable employeeTable, String maNv) {
		initialize();
		this.employeeTable = employeeTable;
		this.maNv = maNv;
		findById();
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
		createLbSalary();
		createLbBonus();
		createLbManager();
		createLbRole();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Edit Employee's Information");
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
		this.txtCode.setEnabled(false);
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

	public JLabel getLbSalary() {
		return lbSalary;
	}

	public void createLbSalary() {
		this.lbSalary = new JLabel("Salary");
	}

	public JLabel getLbBonus() {
		return lbBonus;
	}

	public void createLbBonus() {
		this.lbBonus = new JLabel("Bonus");
	}

	public JLabel getLbManager() {
		return lbManager;
	}

	public void createLbManager() {
		this.lbManager = new JLabel("Manager");
	}

	public JLabel getLbRole() {
		return lbRole;
	}

	public void createLbRole() {
		this.lbRole = new JLabel("Role");
	}
}
