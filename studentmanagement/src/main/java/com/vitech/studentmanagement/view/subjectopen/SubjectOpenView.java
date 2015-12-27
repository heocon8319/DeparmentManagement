package com.vitech.studentmanagement.view.subjectopen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.vitech.studentmanagement.factory.CustomTextField;
import com.vitech.studentmanagement.table.SubjectOpenTable;
import com.vitech.studentmanagement.utility.Constant;

public class SubjectOpenView implements ActionListener{

	private JPanel jPanel;

	private CustomTextField txtSearch;
	private JComboBox<String> cbFilter;

	private JButton btnRefresh;
	private JButton btnAdd;
	private JButton btnFirst;
	private JButton btnLast;
	private JButton btnPrivous;
	private JButton btnNext;

	private JTextField txtPage;
	
	SubjectOpenTable subjectOpenTable;

	public SubjectOpenView() {
		initialize();
	}

	private void initialize() {
		createjPanel();
		createBtnAdd();
		createBtnFirst();
		createBtnLast();
		createBtnNext();
		createBtnPrivous();
		createBtnRefresh();
		createCbFilter();
		createTxtPage();
		createTxtSearch();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getBtnAdd()){
			AddSubjectOpenView addView = new AddSubjectOpenView(subjectOpenTable);
			addView.show();
		}
	}

	public JPanel createUI() {
		/**
		 * create component on top;
		 */
		JPanel pTop = new JPanel(new GridLayout(1,2));

		JPanel pLeft = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.weightx = 1;
		gbc.gridy = 0;
		gbc.gridx = 0;
		pLeft.add(getTxtSearch(), gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.weightx = 0;
		pLeft.add(getCbFilter(), gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 2;	
		pLeft.add(getBtnRefresh());
		
		JPanel pRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pRight.add(getBtnAdd());
		
		pTop.add(pLeft);
		pTop.add(pRight);
		
		/**
		 * create table at center;
		 */
		subjectOpenTable = new SubjectOpenTable();
		JScrollPane scrollPane = new JScrollPane(subjectOpenTable.getTable());
		
		/**
		 * create paging at bottom;
		 */
		JPanel pBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBottom.add(getBtnFirst());
		pBottom.add(getBtnPrivous());
		pBottom.add(getTxtPage());
		pBottom.add(getBtnNext());
		pBottom.add(getBtnLast());
		
		this.getjPanel().add(pTop, BorderLayout.NORTH);
		this.getjPanel().add(scrollPane, BorderLayout.CENTER);
		this.getjPanel().add(pBottom, BorderLayout.SOUTH);
		return this.getjPanel();
	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void createjPanel() {
		this.jPanel = new JPanel(new BorderLayout());
		this.jPanel.setBorder(BorderFactory.createTitledBorder("Score management"));
	}

	public CustomTextField getTxtSearch() {
		return txtSearch;
	}

	public void createTxtSearch() {
		this.txtSearch = new CustomTextField(10);
		this.txtSearch.setPlaceholder("Search");
	}

	public JComboBox<String> getCbFilter() {
		return cbFilter;
	}

	public void createCbFilter() {
		this.cbFilter = new JComboBox<String>();
		this.cbFilter.addItem("MSSV");
		this.cbFilter.addItem("Name");
		this.cbFilter.addItem("Phone");
	}

	public JButton getBtnRefresh() {
		return btnRefresh;
	}

	public void createBtnRefresh() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				Constant.REFRESH_ICON));
		this.btnRefresh = new JButton(icon);
		this.btnRefresh.addActionListener(this);
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void createBtnAdd() {
		ImageIcon icon = new ImageIcon(getClass()
				.getResource(Constant.ADD_ICON));
		this.btnAdd = new JButton("Add", icon);
		this.btnAdd.addActionListener(this);
	}

	public JButton getBtnFirst() {
		return btnFirst;
	}

	public void createBtnFirst() {
		this.btnFirst = new JButton("<<");
		this.btnFirst.addActionListener(this);
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public void createBtnLast() {
		this.btnLast = new JButton(">>");
		this.btnLast.addActionListener(this);
	}

	public JButton getBtnPrivous() {
		return btnPrivous;
	}

	public void createBtnPrivous() {
		this.btnPrivous = new JButton("<");
		this.btnPrivous.addActionListener(this);
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void createBtnNext() {
		this.btnNext = new JButton(">");
		this.btnNext.addActionListener(this);
	}

	public JTextField getTxtPage() {
		return txtPage;
	}

	public void createTxtPage() {
		this.txtPage = new JTextField("1/5");
	}
}
