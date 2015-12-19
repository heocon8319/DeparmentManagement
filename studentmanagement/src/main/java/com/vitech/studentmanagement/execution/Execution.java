package com.vitech.studentmanagement.execution;

import java.awt.EventQueue;

import com.vitech.studentmanagement.view.LoginView;

public class Execution {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
