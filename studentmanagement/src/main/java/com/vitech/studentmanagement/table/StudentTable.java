package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.Student;
import com.vitech.studentmanagement.service.StudentService;
import com.vitech.studentmanagement.service.Impl.StudentServiceImpl;
import com.vitech.studentmanagement.utility.Constant;
import com.vitech.studentmanagement.view.student.EditStudentView;

public class StudentTable implements ActionListener {

	private JTable table;
	private DefaultTableModel tableModel;

	private JPopupMenu popupMenu;

	private JMenuItem miDelete;
	private JMenuItem miEdit;
	private JMenuItem miDeleteAll;

	public StudentService studentService = new StudentServiceImpl();
	
	public StudentTable(){
		createMiDelete();
		createMiDeleteAll();
		createMiEdit();
		createPopupMenu();
		createTable();
	}
	
	public void createTableModel() {
		String roleType = Constant.ROLE.checkRole();
		if(!roleType.equals(Constant.QLNS) 
				&& !roleType.equals(Constant.HDKH) 
				&& !roleType.equals(Constant.TBM)){
			tableModel.setRowCount(0);
			List<Student> students = studentService.find(Constant.ROLE);
			for (Student student: students) {
				String[] rowData = new String[9];
				rowData[0] = student.getMaSv();
				rowData[1] = student.getTenSv();
				rowData[2] = student.getGioiTinh();
				rowData[3] = student.getNgaySinh().toString();
				rowData[4] = student.getDiaChi();
				rowData[5] = student.getSoDienThoai();
				rowData[6] = student.getMaNganh();
				tableModel.addRow(rowData);
			}
		}
	}

	public void createTable() {
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Code");
		tableModel.addColumn("Name");
		tableModel.addColumn("Sex");
		tableModel.addColumn("DOB");		
		tableModel.addColumn("Address");
		tableModel.addColumn("Phone");
		tableModel.addColumn("Spciality");

		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(70);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(20);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(20);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		this.table.setComponentPopupMenu(getPopupMenu());
		this.table.addMouseListener(new TableMouseListener(this.table));
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getMiEdit()){
			int row = this.table.getSelectedRow();
			String maSv = (String) this.tableModel.getValueAt(row, 0);
			EditStudentView editView = new EditStudentView(this, maSv);
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
