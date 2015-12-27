package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.service.EmployeeService;
import com.vitech.studentmanagement.service.Impl.EmployeeServiceImpl;
import com.vitech.studentmanagement.utility.Constant;
import com.vitech.studentmanagement.view.employee.EditEmployeeView;

public class EmployeeTable implements ActionListener {

	private JTable table;

	private JPopupMenu popupMenu;

	private JMenuItem miDelete;
	private JMenuItem miEdit;
	private JMenuItem miDeleteAll;

	private DefaultTableModel tableModel;
	public EmployeeService employeeService = new EmployeeServiceImpl();

	public EmployeeTable() {
		createMiDelete();
		createMiDeleteAll();
		createMiEdit();
		createPopupMenu();
		createTable();
	}

	public void createTableModel() {
		if (!Constant.ROLE.checkRole().equals(Constant.SV)) {
			tableModel.setRowCount(0);
			List<Employee> employees = employeeService.findAll(Constant.ROLE);
			for (Employee employee : employees) {
				String[] rowData = new String[11];
				rowData[0] = employee.getCode();
				rowData[1] = employee.getName();
				rowData[2] = employee.getDob();
				rowData[3] = employee.getSex();
				rowData[4] = employee.getAddress();
				rowData[5] = employee.getPhone();
				rowData[6] = String.valueOf(employee.getSalary());
				rowData[7] = String.valueOf(employee.getBonus());
				rowData[8] = employee.getHomeTown();
				rowData[9] = employee.getManagerCode();
				rowData[10] = employee.getRoleCode();
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
		tableModel.addColumn("Home Town");
		tableModel.addColumn("Manager Code");
		tableModel.addColumn("Role Code");

		createTableModel();

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(50);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(8).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(9).setPreferredWidth(10);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		this.table.setComponentPopupMenu(getPopupMenu());
		this.table.addMouseListener(new TableMouseListener(this.table));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getMiEdit()) {
			int row = this.table.getSelectedRow();
			String maNv = (String) this.tableModel.getValueAt(row, 0);
			EditEmployeeView editView = new EditEmployeeView(this, maNv);
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
