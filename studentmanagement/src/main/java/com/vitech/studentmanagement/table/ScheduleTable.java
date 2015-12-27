package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.Schedule;
import com.vitech.studentmanagement.service.ScheduleService;
import com.vitech.studentmanagement.service.Impl.ScheduleServiceImpl;
import com.vitech.studentmanagement.utility.Constant;
import com.vitech.studentmanagement.view.schedule.EditScheduleView;

public class ScheduleTable implements ActionListener {

	private JTable table;

	private JPopupMenu popupMenu;

	private JMenuItem miEdit;

	public ScheduleService scheduleService = new ScheduleServiceImpl();
	private DefaultTableModel tableModel;

	public ScheduleTable() {
		createMiEdit();
		createPopupMenu();
		createTable();
	}

	public void createTableModel() {
		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.QLNS) && !roleType.equals(Constant.SV)) {
			tableModel.setRowCount(0);
			List<Schedule> schedules = scheduleService.findAll(Constant.ROLE);
			for (Schedule sc : schedules) {
				String[] rowData = new String[4];
				rowData[0] = sc.getMaMH();
				rowData[1] = sc.getMaNV();
				rowData[2] = sc.getMaHK();
				rowData[3] = sc.getVaiTro();
				tableModel.addRow(rowData);
			}
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Subject Code");
		tableModel.addColumn("Student Code");
		tableModel.addColumn("Semester Code");
		tableModel.addColumn("Role");

		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(30);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.TPK) 
				&& !roleType.equals(Constant.HDKH)
				&& !roleType.equals(Constant.TBM)
				&& !roleType.equals(Constant.GVI)) {
			this.table.setComponentPopupMenu(getPopupMenu());
		}
		this.table.addMouseListener(new TableMouseListener(this.table));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getMiEdit()) {
			int row = this.table.getSelectedRow();
			String employeeCode = (String) this.table.getValueAt(row, 1);
			String subjectCode = (String) this.table.getValueAt(row, 0);
			EditScheduleView editView = new EditScheduleView(this, subjectCode,
					employeeCode);
			editView.show();
		}
	}

	public JTable getTable() {
		return table;
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public void createPopupMenu() {
		this.popupMenu = new JPopupMenu();
		getPopupMenu().add(getMiEdit());
	}

	public JMenuItem getMiEdit() {
		return miEdit;
	}

	public void createMiEdit() {
		this.miEdit = new JMenuItem("Edit");
		this.miEdit.addActionListener(this);
	}

}
