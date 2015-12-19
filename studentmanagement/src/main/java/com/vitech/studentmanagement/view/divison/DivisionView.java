package com.vitech.studentmanagement.view.divison;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DivisionView {

	private JPanel jPanel;

	private JLabel lbTitle;

	public DivisionView() {
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
		this.lbTitle = new JLabel("DIVISION MANAGEMENT");
	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void createjPanel() {
		this.jPanel = new JPanel(new BorderLayout());
	}
}
