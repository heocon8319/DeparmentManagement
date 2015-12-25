package com.vitech.studentmanagement.view.teacher;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.vitech.studentmanagement.model.Teacher;
import com.vitech.studentmanagement.table.TeacherTable;
import com.vitech.studentmanagement.utility.Constant;

public class EditTeacherView implements ActionListener{

	private JFrame frame;

	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;

	private JComboBox<String> cbbSex;

	private JDatePickerImpl datePicker;

	private JButton btnSave;
	private JButton btnCancel;

	private TeacherTable teacherTable;
	
	public void show() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridy = 0;
		gbc.gridx = 0;
		frame.add(new JLabel("Name"), gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		frame.add(new JLabel("Address"), gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		frame.add(new JLabel("Phone"), gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		frame.add(new JLabel("Sex"), gbc);

		gbc.gridy = 4;
		gbc.gridx = 0;
		frame.add(new JLabel("DOB"), gbc);

		gbc.weightx = 1;
		gbc.gridwidth = 2;
		gbc.gridy = 0;
		gbc.gridx = 1;
		frame.add(getTxtName(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		frame.add(getTxtAddress(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		frame.add(getTxtPhone(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		frame.add(getCbbSex(), gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		frame.add(getDatePicker(), gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 5;
		gbc.gridx = 1;
		frame.add(getBtnSave(), gbc);

		gbc.gridy = 5;
		gbc.gridx = 2;
		frame.add(getBtnCancel(), gbc);

	}
	
	private void findById() {
		List<Teacher> teachers = this.teacherTable.teacherService.findAll(Constant.ROLE);
		Teacher teacher = teachers.get(0);
		
		getTxtName().setText(teacher.getTenNv());
		getTxtAddress().setText(teacher.getDiaChi());
		getTxtPhone().setText(teacher.getSoDienThoai());

		getCbbSex().setSelectedItem(teacher.getGioiTinh());

		try {
			String strBOD = teacher.getNamSinh().substring(0, teacher.getNamSinh().indexOf(" 00"));
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
		if(e.getSource() == getBtnSave()){
			String name = getTxtName().getText();
			String address = getTxtAddress().getText();
			String phone = getTxtPhone().getText();
			String sex = (String) getCbbSex().getSelectedItem();
			Date dob = (Date) getDatePicker().getModel().getValue();
			
			Teacher teacher = new Teacher();
			teacher.setTenNv(name);
			teacher.setDiaChi(address);
			teacher.setSoDienThoai(phone);
			teacher.setGioiTinh(sex);
			
			SimpleDateFormat sdf = new SimpleDateFormat(Constant.PATTERN_DATE);	
			String strDob = sdf.format(dob);
			teacher.setNamSinh(strDob);
			
			boolean rs = this.teacherTable.teacherService.seftUpdate(Constant.ROLE, teacher);
			if(rs){
				this.teacherTable.createTableModel();
				this.frame.dispose();
			}
		}
		if(e.getSource() == getBtnCancel()){
			this.frame.dispose();
		}
	}
	
	/**
	 * Create the application.
	 */
	public EditTeacherView(TeacherTable teacherTable) {
		initialize();
		this.teacherTable = teacherTable;
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
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Update teacher's information");
		frame.setBounds(100, 100, 350, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
