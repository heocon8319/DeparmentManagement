package com.vitech.studentmanagement.table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vitech.studentmanagement.factory.ButtonEditor;
import com.vitech.studentmanagement.factory.CustomTextField;
import com.vitech.studentmanagement.factory.IconRenderer;

public class BookLendingTable {

	private JPanel panel;

	private CustomTextField txtAmount;

	private JButton btnOk;
	private JButton btnCancel;

	private JTable tbBookLending;

	public BookLendingTable() {
		initialize();
	}

	private void initialize() {
		createPanel();
		createBtnCancel();
		createBtnOk();
		createTbBook();
		createTxtAmount();
	}

	public JPanel createUI() {

		getPanel().setBorder(BorderFactory.createTitledBorder("Detail"));
		JScrollPane scrollPane = new JScrollPane(getTbBook());
		getPanel().add(scrollPane, BorderLayout.CENTER);

		FlowLayout flButton = new FlowLayout();
		flButton.setAlignment(FlowLayout.RIGHT);
		JPanel pButton = new JPanel(flButton);

		pButton.add(getTxtAmount());
		pButton.add(getBtnOk());
		pButton.add(getBtnCancel());

		getPanel().add(pButton, BorderLayout.SOUTH);
		return getPanel();
	}

	public void createTbBook() {
		ImageIcon iconDelete = new ImageIcon(getClass().getResource(
				"/app/btn_delete_icon.png"));
		String columnNames[] = { "No", "Code", "Name", "Amount", "Lended Date",
				"Returned Date", "Action" };

		Object rowDatas[][] = {
				{ "1", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "2", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "3", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "4", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "5", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "6", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "7", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "8", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "9", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "10", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "11", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "12", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "13", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "14", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "15", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "16", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "17", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "18", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" },
				{ "19", "123654789", "Iron Man", "1", "14-04-2015",
						"20-04-2015", "Delete" } };

		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(rowDatas, columnNames);
		this.tbBookLending = new JTable(model);
		this.tbBookLending.setRowHeight(30);
		this.tbBookLending.getColumn("Action").setCellRenderer(
				new IconRenderer(iconDelete));
		this.tbBookLending.getColumn("Action").setCellEditor(
				new ButtonEditor(new JCheckBox()));

		this.tbBookLending.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.tbBookLending.getColumnModel().getColumn(1).setPreferredWidth(30);
		this.tbBookLending.getColumnModel().getColumn(2).setPreferredWidth(400);
		this.tbBookLending.getColumnModel().getColumn(3).setPreferredWidth(30);
		this.tbBookLending.getColumnModel().getColumn(4).setPreferredWidth(90);
		this.tbBookLending.getColumnModel().getColumn(6).setPreferredWidth(50);
		this.tbBookLending.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void createPanel() {
		this.panel = new JPanel(new BorderLayout());
	}

	public CustomTextField getTxtAmount() {
		return txtAmount;
	}

	public void createTxtAmount() {
		this.txtAmount = new CustomTextField(20);
		this.txtAmount.setPlaceholder("Total of book");
		this.txtAmount.setEnabled(false);
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void createBtnOk() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				"/app/btn_ok_icon.png"));
		this.btnOk = new JButton("OK", icon);
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void createBtnCancel() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				"/app/menu_close_icon.png"));
		this.btnCancel = new JButton("Cancel", icon);
	}

	public JTable getTbBook() {
		return tbBookLending;
	}

	public void setTbBook() {
		this.tbBookLending = new JTable();
	}
}
