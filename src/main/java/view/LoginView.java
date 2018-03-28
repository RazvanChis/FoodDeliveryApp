package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import viewmodel.UserDAOService;
import viewmodel.UserDAOServiceImplementation;

import java.awt.event.*;

public class LoginView extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton loginButton;
	private JButton cancelButton;

	public LoginView(Frame parentFrame) {
		super(parentFrame, "Login", true);
		JPanel loginPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;

		usernameLabel = new JLabel("Username: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		loginPanel.add(usernameLabel, constraints);

		usernameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		loginPanel.add(usernameTextField, constraints);

		passwordLabel = new JLabel("Password: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		loginPanel.add(passwordLabel, constraints);

		passwordField = new JPasswordField(20);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		loginPanel.add(passwordField, constraints);
		loginPanel.setBorder(new LineBorder(Color.GRAY));

		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				UserDAOService userDAOService = new UserDAOServiceImplementation();
				if (userDAOService.getUser(getUsername(), getPassword()) != null) {
					MainView mainView = new MainView(parentFrame);
					mainView.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(LoginView.this, 
							"Invalid username or password", 
							"Login",
							JOptionPane.ERROR_MESSAGE);
					usernameTextField.setText("");
					passwordField.setText("");
				}

			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(loginButton);
		buttonsPanel.add(cancelButton);

		getContentPane().add(loginPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setLocationRelativeTo(parentFrame);
	}

	public String getUsername() {
		return usernameTextField.getText();
	}

	public String getPassword() {
		return new String(passwordField.getPassword());
	}
}
