package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.Teacher;
import com.vitech.studentmanagement.service.TeacherService;
import com.vitech.studentmanagement.service.Impl.TeacherServiceImpl;
import com.vitech.studentmanagement.utility.Constant;
import com.vitech.studentmanagement.view.teacher.EditTeacherView;

public class TeacherTable implements ActionListener {

	private JTable table;

	private JPopupMenu popupMenu;

	private JMenuItem miDelete;
	private JMenuItem miEdit;
	private JMenuItem miDeleteAll;

	private DefaultTableModel tableModel;
	public TeacherService teacherService = new TeacherServiceImpl();

	public TeacherTable() {
		createMiDelete();
		createMiDeleteAll();
		createMiEdit();
		createPopupMenu();
		createTable();
	}

	public void createTableModel() {
		String roleType = Constant.ROLE.checkRole();
		if (!roleType.equals(Constant.QLNS) 
				&& !roleType.equals(Constant.GVU)) {
			tableModel.setRowCount(0);
			List<Teacher> teachers = teacherService.findAll(Constant.ROLE);
			for (Teacher teacher : teachers) {
				String[] rowData = new String[9];
				rowData[0] = teacher.getMaNv();
				rowData[1] = teacher.getTenNv();
				rowData[2] = teacher.getNamSinh();
				rowData[3] = teacher.getGioiTinh();
				rowData[4] = teacher.getDiaChi();
				rowData[5] = teacher.getSoDienThoai();
				rowData[6] = String.valueOf(teacher.getLuong());
				rowData[7] = String.valueOf(teacher.getPhuCap());
				tableModel.addRow(rowData);
			}
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Code");
		tableModel.addColumn("Name");
		tableModel.addColumn("DOB");
		tableModel.addColumn("Sex");
		tableModel.addColumn("Address");
		tableModel.addColumn("Phone");
		tableModel.addColumn("Salary");
		tableModel.addColumn("Bonus");

		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(40);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(20);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(30);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		this.table.setComponentPopupMenu(getPopupMenu());
		this.table.addMouseListener(new TableMouseListener(this.table));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getMiEdit()) {
			EditTeacherView editView = new EditTeacherView(this);
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
		getPopupMenu().add(getMiDelete());
		getPopupMenu().add(getMiDeleteAll());
	}

	public JMenuItem getMiDelete() {
		return miDelete;
	}

	public void createMiDelete() {
		this.miDelete = new JMenuItem("Delete");
		this.miDelete.addActionListener(this);
	}

	public JMenuItem getMiEdit() {
		return miEdit;
	}

	public void createMiEdit() {
		this.miEdit = new JMenuItem("Edit");
		this.miEdit.addActionListener(this);
	}

	public JMenuItem getMiDeleteAll() {
		return miDeleteAll;
	}

	public void createMiDeleteAll() {
		this.miDeleteAll = new JMenuItem("Delete All");
		this.miDeleteAll.addActionListener(this);
	}
}
