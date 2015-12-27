package com.vitech.studentmanagement.view.subjectspciality;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import com.vitech.studentmanagement.model.Speciality;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.model.SubjectSpeciality;
import com.vitech.studentmanagement.service.SpecialityService;
import com.vitech.studentmanagement.service.SubjectService;
import com.vitech.studentmanagement.service.Impl.SpecialityServiceImpl;
import com.vitech.studentmanagement.service.Impl.SubjectServiceImpl;
import com.vitech.studentmanagement.table.EmployeeTable;
import com.vitech.studentmanagement.table.SpecialityTable;
import com.vitech.studentmanagement.table.SubjectSpecialityTable;
import com.vitech.studentmanagement.utility.Constant;

public class AddSubjectSpecialityView implements ActionListener {

	private JFrame frame;

	private JComboBox<Subject> cbbSubject;
	private JComboBox<Speciality> cbbSpeciality;
	private JComboBox<String> cbbMandatory;

	private JButton btnSave;
	private JButton btnCancel;

	private SubjectService subjectService = new SubjectServiceImpl();
	private SpecialityService specialityService = new SpecialityServiceImpl();

	private SubjectSpecialityTable subjectSpecialityTable;

	public void show() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridy = 0;
		gbc.gridx = 0;
		frame.add(new JLabel("Subject"), gbc);

		gbc.gridy = 1;
		gbc.gridx = 0;
		frame.add(new JLabel("Speciality"), gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		frame.add(new JLabel("Mandatory"), gbc);

		gbc.weightx = 1;
		gbc.gridwidth = 2;

		gbc.gridy = 0;
		gbc.gridx = 1;
		frame.add(getCbbSubject(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		frame.add(getCbbSpeciality(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		frame.add(getCbbMandatory(), gbc);

		gbc.gridwidth = 1;

		gbc.gridy = 3;
		gbc.gridx = 1;
		frame.add(getBtnSave(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 2;
		frame.add(getBtnCancel(), gbc);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnSave()) {
			Subject subj = (Subject) getCbbSubject().getSelectedItem();
			Speciality spe = (Speciality) getCbbSpeciality().getSelectedItem();
			String mad = (String) getCbbMandatory().getSelectedItem();
			
			SubjectSpeciality subjectSpeciality = new SubjectSpeciality();
			subjectSpeciality.setMaMH(subj.getMaMH());
			subjectSpeciality.setMaNganh(spe.getMaNganh());
			subjectSpeciality.setBatBuoc(mad);
			
			boolean rs = subjectService.addSubjectSpeciality(Constant.ROLE, subjectSpeciality);
			if(rs){
				this.subjectSpecialityTable.createTableModel();
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
	public AddSubjectSpecialityView(
			SubjectSpecialityTable subjectSpecialityTable) {
		initialize();
		this.subjectSpecialityTable = subjectSpecialityTable;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		createFrame();
		createCbbSubject();
		setCbbSpeciality();
		setCbbMandatory();
		createBtnSave();
		createBtnCancel();
	}

	public JFrame getFrame() {
		return frame;
	} 

	public void createFrame() {
		frame = new JFrame("Add Subject Speciality");
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

	public JComboBox<Speciality> getCbbSpeciality() {
		return cbbSpeciality;
	}

	public void setCbbSpeciality() {
		final DefaultComboBoxModel<Speciality> model = new DefaultComboBoxModel<Speciality>();
		List<Speciality> specialities = specialityService
				.findAll(Constant.ROLE);
		for (Speciality s : specialities) {
			model.addElement(s);
		}
		this.cbbSpeciality = new JComboBox<Speciality>(model);
		this.cbbSpeciality.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index,
						isSelected, cellHasFocus);
				if (value instanceof Speciality) {
					Speciality sb = (Speciality) value;
					setText(sb.getTenNganh());
				}
				return this;
			}
		});
		this.cbbSpeciality.addActionListener(this);
	}

	public JComboBox<String> getCbbMandatory() {
		return cbbMandatory;
	}

	public void setCbbMandatory() {
		this.cbbMandatory = new JComboBox<String>();
		this.cbbMandatory.addItem("Y");
		this.cbbMandatory.addItem("N");

	}
}
