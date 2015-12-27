package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.SubjectOpen;
import com.vitech.studentmanagement.service.SubjectService;
import com.vitech.studentmanagement.service.Impl.SubjectServiceImpl;
import com.vitech.studentmanagement.utility.Constant;

public class SubjectOpenTable implements ActionListener {

	private JTable table;

	private DefaultTableModel tableModel;
	public SubjectService subjectService = new SubjectServiceImpl();

	public SubjectOpenTable() {
		createTable();
	}

	public void createTableModel() {
		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.QLNS) && !roleType.equals(Constant.GVU)) {
			tableModel.setRowCount(0);
			List<SubjectOpen> subjectOpens = subjectService
					.getSubjectOpen(Constant.ROLE);
			for (SubjectOpen s : subjectOpens) {
				String[] rowData = new String[5];
				rowData[0] = s.getMaMH();
				rowData[1] = s.getMaHK();
				rowData[2] = s.getNgayBD();
				rowData[3] = s.getNgayKT();
				rowData[4] = String.valueOf(s.getSoLuongSV());
				tableModel.addRow(rowData);
			}
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Subject");
		tableModel.addColumn("Semester");
		tableModel.addColumn("Start Date");
		tableModel.addColumn("End Date");
		tableModel.addColumn("Amout of Student");

		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
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
