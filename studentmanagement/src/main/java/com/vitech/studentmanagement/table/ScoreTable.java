package com.vitech.studentmanagement.table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.ButtonEditor;
import com.vitech.studentmanagement.factory.IconRenderer;
import com.vitech.studentmanagement.factory.TableMouseListener;
import com.vitech.studentmanagement.utility.Constant;

public class ScoreTable implements ActionListener {

	private JTable table;

	private JPopupMenu popupMenu;

	private JMenuItem miDelete;
	private JMenuItem miEdit;
	private JMenuItem miDeleteAll;

	public ScoreTable(){
		createMiDelete();
		createMiDeleteAll();
		createMiEdit();
		createPopupMenu();
		createTable();
	}
	
	public void createTableModel(DefaultTableModel tableModel) {
		tableModel.setRowCount(0);
		for (int i = 1; i < 10; i++) {
			String[] rowData = new String[9];
			rowData[0] = String.valueOf(i);
			rowData[1] = "SV00" + i;
			rowData[2] = "Student "+i;
			rowData[3] = "14/04/1990";
			rowData[4] = "Nam";
			rowData[5] = "So 1 Hai Ba Trung";
			rowData[6] = "0987654321";
			rowData[7] = "Computer Science";
			rowData[8] = "Delete";
			tableModel.addRow(rowData);
		}
	}

	public void createTable() {
		ImageIcon iconDelete = new ImageIcon(getClass().getResource(Constant.DELETE_ICON));
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("No");
		tableModel.addColumn("Code");
		tableModel.addColumn("Name");
		tableModel.addColumn("DOB");
		tableModel.addColumn("Sex");
		tableModel.addColumn("Address");
		tableModel.addColumn("Phone");
		tableModel.addColumn("Spciality");
		tableModel.addColumn("Delete");

		createTableModel(tableModel);

		this.table = new JTable(tableModel);
		this.table.setRowHeight(30);
		this.table.getColumn("Delete").setCellRenderer(new IconRenderer(iconDelete));
		this.table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));

		this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(8).setPreferredWidth(10);
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		this.table.setComponentPopupMenu(getPopupMenu());
		this.table.addMouseListener(new TableMouseListener(this.table));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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
