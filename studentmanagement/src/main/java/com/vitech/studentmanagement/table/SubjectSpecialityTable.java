package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.SubjectSpeciality;
import com.vitech.studentmanagement.service.SubjectService;
import com.vitech.studentmanagement.service.Impl.SubjectServiceImpl;
import com.vitech.studentmanagement.utility.Constant;

public class SubjectSpecialityTable implements ActionListener {

	private JTable table;

	public SubjectService subjectService = new SubjectServiceImpl();
	private DefaultTableModel tableModel;

	public SubjectSpecialityTable() {
		createTable();
	}

	public void createTableModel() {
		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.QLNS) && !roleType.equals(Constant.GVU)) {
			tableModel.setRowCount(0);
			List<SubjectSpeciality> subjects = subjectService
					.getAll(Constant.ROLE);
			for (SubjectSpeciality s : subjects) {
				String[] rowData = new String[3];
				rowData[0] = s.getMaMH();
				rowData[1] = s.getMaNganh();
				rowData[2] = s.getBatBuoc();
				tableModel.addRow(rowData);
			}
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Code");
		tableModel.addColumn("Speciality");
		tableModel.addColumn("Mandantory");

		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(50);
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
