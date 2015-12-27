package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.RegisterSubject;
import com.vitech.studentmanagement.service.RegisterSubjectService;
import com.vitech.studentmanagement.service.Impl.RegisterSubjectServiceImpl;
import com.vitech.studentmanagement.utility.Constant;

public class RegisterTable implements ActionListener {

	private JTable table;

	private DefaultTableModel tableModel;
	public RegisterSubjectService registerSubjectService = new RegisterSubjectServiceImpl();

	public RegisterTable() {
		createTable();
	}

	public void createTableModel() {
		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.QLNS)) {
			tableModel.setRowCount(0);
			List<RegisterSubject> rlist = registerSubjectService
					.findAll(Constant.ROLE);
			for (RegisterSubject r : rlist) {
				String[] rowData = new String[5];
				rowData[0] = r.getSubjectCode();
				rowData[1] = r.getStudentCode();
				rowData[2] = r.getSemester();
				rowData[3] = r.getPeriodDate();
				rowData[4] = String.valueOf(r.getScore());
				tableModel.addRow(rowData);
			}
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Subject Code");
		tableModel.addColumn("Employee Code");
		tableModel.addColumn("Semester");
		tableModel.addColumn("Period Date");
		tableModel.addColumn("Score");
		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(30);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		this.table.addMouseListener(new TableMouseListener(this.table));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public JTable getTable() {
		return table;
	}

}
