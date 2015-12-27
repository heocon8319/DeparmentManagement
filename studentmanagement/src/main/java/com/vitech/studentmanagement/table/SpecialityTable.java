package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.Speciality;
import com.vitech.studentmanagement.service.SpecialityService;
import com.vitech.studentmanagement.service.Impl.SpecialityServiceImpl;
import com.vitech.studentmanagement.utility.Constant;

public class SpecialityTable implements ActionListener {

	private JTable table;

	private DefaultTableModel tableModel;
	public SpecialityService specialityService = new SpecialityServiceImpl();

	public SpecialityTable() {

		createTable();
	}

	public void createTableModel() {
		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.QLNS) && !roleType.equals(Constant.TBM)
				&& !roleType.equals(Constant.GVU)
				&& !roleType.equals(Constant.GVI)
				&& !roleType.equals(Constant.SV)) {
			tableModel.setRowCount(0);
			List<Speciality> specialities = specialityService
					.findAll(Constant.ROLE);
			for (Speciality sp : specialities) {
				String[] rowData = new String[3];
				rowData[0] = sp.getMaNganh();
				rowData[1] = sp.getTenNganh();
				rowData[2] = sp.getMaNQL();
				tableModel.addRow(rowData);
			}
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Code");
		tableModel.addColumn("Name");
		tableModel.addColumn("Manager");

		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
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
