package com.vitech.studentmanagement.view.schedule;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScheduleView {
	
	private JPanel jPanel;

	private JLabel lbTitle;

	public ScheduleView() {
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
		this.lbTitle = new JLabel("SCHEDULE MANAGEMENT");
	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void createjPanel() {
		this.jPanel = new JPanel(new BorderLayout());
	}
}
