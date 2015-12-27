package com.vitech.studentmanagement.view.subjectopen;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.vitech.studentmanagement.model.Semester;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.model.SubjectOpen;
import com.vitech.studentmanagement.service.SemesterService;
import com.vitech.studentmanagement.service.SubjectService;
import com.vitech.studentmanagement.service.Impl.SemesterServiceImpl;
import com.vitech.studentmanagement.service.Impl.SubjectServiceImpl;
import com.vitech.studentmanagement.table.SubjectOpenTable;
import com.vitech.studentmanagement.utility.Constant;

public class AddSubjectOpenView implements ActionListener {

	private JFrame frame;

	private JComboBox<Subject> cbbSubject;
	private JComboBox<Semester> cbbSemester;

	private JDatePickerImpl dStartDate;
	private JDatePickerImpl dEndDate;

	private JTextField txtAmout;

	private JButton btnSave;
	private JButton btnCancel;

	private SubjectService subjectService = new SubjectServiceImpl();
	private SemesterService semesterService = new SemesterServiceImpl();

	private SubjectOpenTable subjectOpenTable;

	public void show() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridy = 0;
		gbc.gridx = 0;
		frame.add(new JLabel("Subject"), gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		frame.add(new JLabel("Semester"), gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		frame.add(new JLabel("Start Date"), gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		frame.add(new JLabel("End Date"), gbc);

		gbc.gridy = 4;
		gbc.gridx = 0;
		frame.add(new JLabel("Amount"), gbc);

		gbc.weightx = 1;
		gbc.gridwidth = 2;

		gbc.gridy = 0;
		gbc.gridx = 1;
		frame.add(getCbbSubject(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		frame.add(getCbbSemester(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		frame.add(getdStartDate(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		frame.add(getdEndDate(), gbc);

		gbc.gridy = 4;
		gbc.gridx = 1;
		frame.add(getTxtAmout(), gbc);

		gbc.gridwidth = 1;

		gbc.gridy = 5;
		gbc.gridx = 1;
		frame.add(getBtnSave(), gbc);

		gbc.gridy = 5;
		gbc.gridx = 2;
		frame.add(getBtnCancel(), gbc);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnSave()) {
			Subject subj = (Subject) getCbbSubject().getSelectedItem();
			Semester sem = (Semester) getCbbSemester().getSelectedItem();
			
			SimpleDateFormat sdf = new SimpleDateFormat(Constant.PATTERN_DATE);
			
			Date st = (Date) getdStartDate().getModel().getValue();
			String strStartDate = sdf.format(st);
			
			Date ed = (Date) getdEndDate().getModel().getValue();
			String strEndDate = sdf.format(ed);
			
			String strAmount = getTxtAmout().getText();
			
			SubjectOpen subjectOpen = new SubjectOpen();
			subjectOpen.setMaMH(subj.getMaMH());
			subjectOpen.setMaHK(sem.getMaHK());
			subjectOpen.setNgayBD(strStartDate);
			subjectOpen.setNgayKT(strEndDate);
			subjectOpen.setSoLuongSV(Integer.parseInt(strAmount));
						
			boolean rs = subjectService.addSubjectOpen(Constant.ROLE, subjectOpen);
			if (rs) {
				this.subjectOpenTable.createTableModel();
				this.frame.dispose();
			}
		}
		if (e.getSource() == getBtnCancel()) {
			this.frame.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public AddSubjectOpenView(SubjectOpenTable subjectOpenTable) {
		initialize();
		this.subjectOpenTable = subjectOpenTable;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		createFrame();
		createCbbSubject();
		createCbbSemester();
		createdEndDate();
		createdStartDate();
		createTxtAmout();
		createBtnSave();
		createBtnCancel();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("Add Subject Open");
		frame.setBounds(100, 100, 350, 350);
		frame.setLayout(new GridBagLayout());
		frame.setVisible(true);
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void createBtnSave() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				Constant.SAVE_ICON));
		this.btnSave = new JButton("Save", icon);
		this.btnSave.addActionListener(this);
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void createBtnCancel() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				Constant.CLOSE_ICON));
		this.btnCancel = new JButton("Cancle", icon);
		this.btnCancel.addActionListener(this);
	}

	public JComboBox<Subject> getCbbSubject() {
		return cbbSubject;
	}

	public void createCbbSubject() {
		final DefaultComboBoxModel<Subject> model = new DefaultComboBoxModel<Subject>();
		List<Subject> subjects = subjectService.findAll(Constant.ROLE);
		for (Subject s : subjects) {
			model.addElement(s);
		}
		this.cbbSubject = new JComboBox<Subject>(model);
		this.cbbSubject.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Subject) {
					Subject sb = (Subject) value;
					setText(sb.getTenMH());
				}
				return this;
			}
		});
		this.cbbSubject.addActionListener(this);
	}

	public JComboBox<Semester> getCbbSemester() {
		return cbbSemester;
	}

	public void createCbbSemester() {
		final DefaultComboBoxModel<Semester> model = new DefaultComboBoxModel<Semester>();
		List<Semester> semesters = semesterService.findAll(Constant.ROLE);
		for (Semester s : semesters) {
			model.addElement(s);
		}
		this.cbbSemester = new JComboBox<Semester>(model);
		this.cbbSemester.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Semester) {
					Semester sb = (Semester) value;
					setText(sb.getMaHK());
				}
				return this;
			}
		});
		this.cbbSemester.addActionListener(this);
	}

	public JDatePickerImpl getdStartDate() {
		return dStartDate;
	}

	public void createdStartDate() {
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		this.dStartDate = new JDatePickerImpl(datePanel);
		;
	}

	public JDatePickerImpl getdEndDate() {
		return dEndDate;
	}

	public void createdEndDate() {
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		this.dEndDate = new JDatePickerImpl(datePanel);
		;
	}

	public JTextField getTxtAmout() {
		return txtAmout;
	}

	public void createTxtAmout() {
		this.txtAmout = new JTextField();
	}
}
