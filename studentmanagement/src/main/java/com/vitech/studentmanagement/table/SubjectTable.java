package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.service.SubjectService;
import com.vitech.studentmanagement.service.Impl.SubjectServiceImpl;
import com.vitech.studentmanagement.utility.Constant;

public class SubjectTable implements ActionListener {

	private JTable table;

	private DefaultTableModel tableModel;

	private SubjectService subjectService = new SubjectServiceImpl();

	public SubjectTable() {

		createTable();
	}

	public void createTableModel(List<Subject> subjects) {
		tableModel.setRowCount(0);
		for (Subject subject : subjects) {
			String[] rowData = new String[5];
			rowData[0] = subject.getMaMH();
			rowData[1] = subject.getTenMH();
			rowData[2] = String.valueOf(subject.getSoTinChi());
			rowData[3] = String.valueOf(subject.getHocKy());
			rowData[4] = String.valueOf(subject.getNam());
			tableModel.addRow(rowData);
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Code");
		tableModel.addColumn("Name");
		tableModel.addColumn("Training credits");
		tableModel.addColumn("Semester");
		tableModel.addColumn("Year");

		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.QLNS) && !roleType.equals(Constant.GVU)
				&& !roleType.equals(Constant.GVI)) {
			List<Subject> subjects = subjectService
					.find(Constant.ROLE, 2015, 2);
			createTableModel(subjects);
		}

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(30);
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
