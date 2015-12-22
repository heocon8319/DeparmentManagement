package com.vitech.studentmanagement.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.service.RoleService;
import com.vitech.studentmanagement.service.Impl.RoleServiceImpl;
import com.vitech.studentmanagement.utility.Constant;
import com.vitech.studentmanagement.utility.Utilities;

@SuppressWarnings("serial")
public class LoginView extends ParentUI implements ActionListener {

	private JFrame frame;

	private JLabel lbTitle;
	private JLabel lbUserName;
	private JLabel lbPassword;
	private JLabel lbIcon;

	private JTextField txtUserName;
	private JPasswordField txtPassword;

	private JButton btnLogin;
	private JButton btnCancel;

	private RoleService roleService = new RoleServiceImpl();

	public LoginView() {
		initialize();
	}

	public void show() {
		GridBagLayout parentLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		getFrame().setLayout(parentLayout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 10);

		gbc.gridy = 0;
		gbc.gridx = 2;
		getFrame().add(getLbTitle(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		getFrame().add(getLbUserName(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 1;
		getFrame().add(getLbPassword(), gbc);

		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		getFrame().add(getTxtUserName(), gbc);

		gbc.gridy = 2;
		gbc.gridx = 2;
		getFrame().add(getTxtPassword(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		getFrame().add(getBtnLogin(), gbc);

		gbc.gridy = 3;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		getFrame().add(getBtnCancel(), gbc);

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridheight = 4;
		getFrame().add(getLbIcon(), gbc);

	}

	private void initialize() {
		createFrame();
		createBtnCancel();
		createBtnLogin();
		createLbIcon();
		createLbPassword();
		createLbTitle();
		createLbUserName();
		createTxtPassword();
		createTxtUserName();
	}

	private void emptyFields(){
		getTxtPassword().setText("");
		getTxtUserName().setText("");
	}
	
	private void login(){
		String userName = getTxtUserName().getText();
		char[] passArr = getTxtPassword().getPassword();
		String password = String.valueOf(passArr);
		//remove all of space in text;
		userName = userName.replaceAll("\\s+","");
		//set lower for text;
		userName = userName.toLowerCase();
		Constant.ROLE = roleService.find(userName, password);
		if (Constant.ROLE.getId() != 0) {
			emptyFields();
			DashboardView dashboardView = new DashboardView(Constant.ROLE);
			dashboardView.show();
			closeWindow(getFrame());
		} else {
			JOptionPane.showMessageDialog(getFrame(),"Username or password is incorrect, Please try again");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBtnLogin()) {			
			login();
		}
		if (e.getSource() == getBtnCancel()) {
			emptyFields();
			closeWindow(getFrame());
		}
		if(e.getSource() == getTxtPassword()){
			login();
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void createFrame() {
		frame = new JFrame("User login");
		frame.setBounds(100, 100, 400, 175);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setIconImage(Utilities.WINDOW_ICON.getImage());
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.centerScreen(frame);
	}

	public JLabel getLbTitle() {
		return lbTitle;
	}

	public void createLbTitle() {
		this.lbTitle = new JLabel("USER LOGIN");
	}

	public JLabel getLbUserName() {
		return lbUserName;
	}

	public void createLbUserName() {
		this.lbUserName = new JLabel("User name: ");
	}

	public JLabel getLbIcon() {
		return lbIcon;
	}

	public void createLbIcon() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.LOCK_ICON));
		this.lbIcon = new JLabel(icon);
	}

	public JLabel getLbPassword() {
		return lbPassword;
	}

	public void createLbPassword() {
		this.lbPassword = new JLabel("Password");
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public void createTxtUserName() {
		this.txtUserName = new JTextField();
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void createTxtPassword() {
		this.txtPassword = new JPasswordField();
		this.txtPassword.addActionListener(this);
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void createBtnLogin() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.OK_ICON));
		this.btnLogin = new JButton("Login", icon);
		this.btnLogin.addActionListener(this);
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void createBtnCancel() {
		ImageIcon icon = new ImageIcon(getClass().getResource(Constant.CLOSE_ICON));
		this.btnCancel = new JButton("Cancel", icon);
		this.btnCancel.addActionListener(this);
	}
}
