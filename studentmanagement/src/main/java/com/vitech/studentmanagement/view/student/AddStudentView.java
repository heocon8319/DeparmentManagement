package com.vitech.studentmanagement.view.student;

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

import com.vitech.studentmanagement.model.Speciality;
import com.vitech.studentmanagement.model.Student;
import com.vitech.studentmanagement.service.SpecialityService;
import com.vitech.studentmanagement.service.Impl.SpecialityServiceImpl;
import com.vitech.studentmanagement.table.StudentTable;
import com.vitech.studentmanagement.utility.Constant;

public class AddStudentView implements ActionListener {

	private JFrame frame;

	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;

	private JComboBox<String> cbbSex;
	private JComboBox<Speciality> cbbSpciality;

	private JDatePickerImpl datePicker;

	private JButton btnSave;
	private JButton btnCancel;

	private StudentTable studentTable;
	private SpecialityService specialityService = new SpecialityServiceImpl();

	public void show() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridy = 0;
		gbc.gridx = 0;
		frame.add(new JLabel("Code"), gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		frame.add(new JLabel("User name"), gbc);

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
		frame.add(new JLabel("Speciality"), gbc);

		gbc.gridy = 6;
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
		frame.add(getCbbSpciality(), gbc);

		gbc.gridy = 6;
		gbc.gridx = 1;
		frame.add(getDatePicker(), gbc);

		gbc.gridwidth = 1;

		gbc.gridy = 7;
		gbc.gridx = 1;
		frame.add(getBtnSave(), gbc);

		gbc.gridy = 7;
		gbc.gridx = 2;
		frame.add(getBtnCancel(), gbc);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnSave()) {
			String strName = getTxtName().getText();
			String strCode = getTxtCode().getText();
			String strAddress = getTxtAddress().getText();
			String strPhone = getTxtPhone().getText();
			String strSex = (String) getCbbSex().getSelectedItem();
			Speciality speciality = (Speciality) getCbbSpciality().getSelectedItem();
			
			Student student = new Student();
			student.setTenSv(strName);
			student.setMaSv(strCode);
			student.setDiaChi(strAddress);
			student.setSoDienThoai(strPhone);
			student.setGioiTinh(strSex);
			student.setMaNganh(speciality.getMaNganh());
			
			Date dob = (Date) getDatePicker().getModel().getValue();
			SimpleDateFormat sdf = new SimpleDateFormat(Constant.PATTERN_DATE);	
			String strDob = sdf.format(dob);
			student.setNgaySinh(strDob);
			
			boolean rs = this.studentTable.studentService.add(Constant.ROLE, student);
			if(rs){
				this.studentTable.createTableModel();
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
	public AddStudentView(StudentTable studentTable) {
		initialize();
		this.studentTable = studentTable;
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
		createCbbSpciality();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Update student's information");
		frame.setBounds(100, 100, 350, 400);
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

	public JComboBox<Speciality> getCbbSpciality() {
		return cbbSpciality;
	}

	public void createCbbSpciality() {

		final DefaultComboBoxModel<Speciality> model = new DefaultComboBoxModel<Speciality>();
		List<Speciality> specialities = specialityService
				.findAll(Constant.ROLE);
		for (Speciality sp : specialities) {
			model.addElement(sp);
		}
		this.cbbSpciality = new JComboBox<Speciality>(model);
		this.cbbSpciality.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Speciality) {
					Speciality speciality = (Speciality) value;
					setText(speciality.getTenNganh());
				}
				return this;
			}
		});
		this.cbbSpciality.addActionListener(this);
	}
}
