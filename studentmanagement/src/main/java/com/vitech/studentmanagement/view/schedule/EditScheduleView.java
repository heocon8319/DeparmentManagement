package com.vitech.studentmanagement.view.schedule;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.vitech.studentmanagement.model.Schedule;
import com.vitech.studentmanagement.service.ScheduleService;
import com.vitech.studentmanagement.service.Impl.ScheduleServiceImpl;
import com.vitech.studentmanagement.table.ScheduleTable;
import com.vitech.studentmanagement.utility.Constant;

public class EditScheduleView implements ActionListener {

	private JFrame frame;
	
	private JTextField txtSubjectCode;
	private JTextField txtEmployeeCode;
	private JTextField txtSemesterCode;
	private JTextField txtVaiTroCode;

	private JButton btnSave;
	private JButton btnCancel;

	private ScheduleService scheduleService = new ScheduleServiceImpl();
	
	private ScheduleTable scheduleTable;

	private String subjectCode;
	private String employeeCode;
	
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
		frame.add(getTxtEmployeeCode(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		frame.add(getTxtSubjectCode(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		frame.add(getTxtSemesterCode(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		frame.add(getTxtVaiTroCode(), gbc);

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
			Schedule sch = new Schedule();
			sch.setMaHK(getTxtSemesterCode().getText());
			sch.setMaMH(getTxtSubjectCode().getText());
			sch.setMaNV(getTxtEmployeeCode().getText());
			sch.setVaiTro(getTxtVaiTroCode().getText());
			boolean rs = scheduleService.update(Constant.ROLE, sch);
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

	private void findById(){
		Schedule sc = scheduleService.findById(Constant.ROLE, subjectCode, employeeCode);
		getTxtEmployeeCode().setText(sc.getMaNV());
		getTxtSubjectCode().setText(sc.getMaMH());
		getTxtSemesterCode().setText(sc.getMaHK());
		getTxtVaiTroCode().setText(sc.getVaiTro());
		
	}
	/**
	 * Create the application.
	 */
	public EditScheduleView(ScheduleTable scheduleTable, String subjectCode, String employeeCode) {
		initialize();
		this.scheduleTable = scheduleTable;
		this.subjectCode = subjectCode;
		this.employeeCode = employeeCode;		
		findById();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		createFrame();
		createBtnSave();
		createBtnCancel();
		
		createTxtSemesterCode();
		createTxtEmployeeCode();
		createTxtSubjectCode();
		createTxtVaiTroCode();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Edit Schedule");
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

	public JTextField getTxtSubjectCode() {
		return txtSubjectCode;
	}

	public void createTxtSubjectCode() {
		this.txtSubjectCode = new JTextField();
		this.txtSubjectCode.setEnabled(false);
	}

	public JTextField getTxtEmployeeCode() {
		return txtEmployeeCode;
	}

	public void createTxtEmployeeCode() {
		this.txtEmployeeCode = new JTextField();
		this.txtEmployeeCode.setEnabled(false);
	}

	public JTextField getTxtSemesterCode() {
		return txtSemesterCode;
	}

	public void createTxtSemesterCode() {
		this.txtSemesterCode = new JTextField();
		this.txtSemesterCode.setEnabled(false);
	}

	public JTextField getTxtVaiTroCode() {
		return txtVaiTroCode;
	}

	public void createTxtVaiTroCode() {
		this.txtVaiTroCode = new JTextField();
	}
}
