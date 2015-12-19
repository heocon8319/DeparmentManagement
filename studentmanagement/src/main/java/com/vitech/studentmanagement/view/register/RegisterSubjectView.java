package com.vitech.studentmanagement.view.register;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegisterSubjectView {

	private JPanel jPanel;

	private JLabel lbTitle;

	public RegisterSubjectView() {
		initialize();
	}

	private void initialize() {
		createjPanel();
		createLbTitle();
	}

	public JPanel createUI() {
		this.getjPanel().add(this.getLbTitle(), BorderLayout.NORTH);
		return this.getjPanel();
	}

	public JLabel getLbTitle() {
		return lbTitle;
	}

	public void createLbTitle() {
		this.lbTitle = new JLabel("REGISTER SUBJECT MANAGEMENT");
	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void createjPanel() {
		this.jPanel = new JPanel(new BorderLayout());
	}
}
