package com.vitech.studentmanagement.view.subject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.service.SubjectService;
import com.vitech.studentmanagement.service.Impl.SubjectServiceImpl;
import com.vitech.studentmanagement.table.SubjectTable;
import com.vitech.studentmanagement.utility.Constant;

public class SubjectView implements ActionListener{

	private JPanel jPanel;

	private JComboBox<String> cbSemester;
	private JComboBox<String> cbYear;

	private JButton btnRefresh;
	private JButton btnSearch;
	private JButton btnFirst;
	private JButton btnLast;
	private JButton btnPrivous;
	private JButton btnNext;

	private JTextField txtPage;

	private SubjectService subjectService = new SubjectServiceImpl();
	
	private SubjectTable subjectTable;
	
	public SubjectView() {
		initialize();
	}

	private void initialize() {
		createjPanel();
		createBtnSearch();
		createBtnFirst();
		createBtnLast();
		createBtnNext();
		createBtnPrivous();
		createBtnRefresh();
		createCbSemester();
		createCbYear();
		createTxtPage();		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getBtnSearch()){
			String strSemester = (String) getCbSemester().getSelectedItem();
			String strYear = (String) getCbYear().getSelectedItem();
			int semester = Integer.parseInt(strSemester);
			int year = Integer.parseInt(strYear);
			List<Subject> subjects = subjectService.find(Constant.ROLE, year, semester);
			subjectTable.createTableModel(subjects);
		}
		if(e.getSource() == getBtnRefresh()){
			List<Subject> subjects = subjectService.find(Constant.ROLE, 2015, 2);
			subjectTable.createTableModel(subjects);
		}

	}

	public JPanel createUI() {
		/**
		 * create component on top;
		 */
		JPanel pTop = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.weightx = 0;
		gbc.gridy = 0;
		gbc.gridx = 0;
		pTop.add(getCbYear(), gbc);

		gbc.gridy = 0;
		gbc.gridx = 1;
		pTop.add(getCbSemester(), gbc);

		gbc.gridy = 0;
		gbc.gridx = 2;
		pTop.add(getBtnSearch(), gbc);

		gbc.gridy = 0;
		gbc.gridx = 3;
		pTop.add(getBtnRefresh(), gbc);

		/**
		 * create table at center;
		 */
		subjectTable = new SubjectTable();
		JScrollPane scrollPane = new JScrollPane(subjectTable.getTable());

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
		this.jPanel.setBorder(BorderFactory
				.createTitledBorder("Subject management"));
	}

	public JComboBox<String> getCbSemester() {
		return cbSemester;
	}

	public void createCbSemester() {
		this.cbSemester = new JComboBox<String>();
		this.cbSemester.addItem("---Semester---");
		this.cbSemester.addItem("1");
		this.cbSemester.addItem("2");
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

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void createBtnSearch() {
		ImageIcon icon = new ImageIcon(getClass()
				.getResource(Constant.SEARCH_ICON));
		this.btnSearch = new JButton("Search", icon);
		this.btnSearch.addActionListener(this);
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

	public JComboBox<String> getCbYear() {
		return cbYear;
	}

	public void createCbYear() {
		this.cbYear = new JComboBox<String>();
		this.cbYear.addItem("---Year---");
		this.cbYear.addItem("2010");
		this.cbYear.addItem("2011");
		this.cbYear.addItem("2012");
		this.cbYear.addItem("2013");
		this.cbYear.addItem("2014");
		this.cbYear.addItem("2015");
		this.cbYear.addItem("2016");
	}
}
