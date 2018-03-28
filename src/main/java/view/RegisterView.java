package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import model.User;
import viewmodel.UserDAOService;
import viewmodel.UserDAOServiceImplementation;

public class RegisterView extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField cnpTextField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel emailLabel;
	private JLabel cnpLabel;
	private JButton registerButton;
	private JButton cancelButton;

	UserDAOService userDAOService = new UserDAOServiceImplementation();
	private static final int CUSTOMER_TYPE = 0;

	public RegisterView(Frame parentFrame) {
		super(parentFrame, "Login", true);
		JPanel registerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;

		usernameLabel = new JLabel("Username: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		registerPanel.add(usernameLabel, constraints);

		usernameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		registerPanel.add(usernameTextField, constraints);

		passwordLabel = new JLabel("Password: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		registerPanel.add(passwordLabel, constraints);

		passwordField = new JPasswordField(20);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		registerPanel.add(passwordField, constraints);
		registerPanel.setBorder(new LineBorder(Color.GRAY));

		firstNameLabel = new JLabel("FirstName: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		registerPanel.add(firstNameLabel, constraints);

		firstNameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		registerPanel.add(firstNameTextField, constraints);

		lastNameLabel = new JLabel("LastName: ");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		registerPanel.add(lastNameLabel, constraints);

		lastNameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		registerPanel.add(lastNameTextField, constraints);

		emailLabel = new JLabel("Email: ");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		registerPanel.add(emailLabel, constraints);

		emailTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		registerPanel.add(emailTextField, constraints);

		cnpLabel = new JLabel("CNP: ");
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		registerPanel.add(cnpLabel, constraints);

		cnpTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		registerPanel.add(cnpTextField, constraints);

		registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (isRegistrationFormValid()) {
					User user = new User();
					user.setCnp(getCNP());
					user.setEmail(getEmail());
					user.setFirstName(getFirstName());
					user.setLastName(getLastName());
					user.setPassword(getPassword());
					user.setUsername(getUsername());
					user.setType(CUSTOMER_TYPE);
					if (userDAOService.addUser(user)) {
						MainView mainView = new MainView(parentFrame);
						mainView.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(RegisterView.this, "Could not register", "Register",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(RegisterView.this, "Invalid registration form", "Register",
							JOptionPane.ERROR_MESSAGE);
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
		buttonsPanel.add(registerButton);
		buttonsPanel.add(cancelButton);

		getContentPane().add(registerPanel, BorderLayout.CENTER);
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

	public String getFirstName() {
		return firstNameTextField.getText();
	}

	public String getLastName() {
		return lastNameTextField.getText();
	}

	public String getEmail() {
		return emailTextField.getText();
	}

	public String getCNP() {
		return cnpTextField.getText();
	}

	public boolean isRegistrationFormValid() {
		boolean isValid = true;
		if (getUsername().isEmpty() || userDAOService.getUserByUsername(getUsername()) != null) {
			isValid = false;
		}
		if (getEmail().isEmpty() || userDAOService.getUserByEmail(getEmail()) != null) {
			isValid = false;
		}
		if (getPassword().length() < 4) {
			isValid = false;
		}
		if (getFirstName().isEmpty() || getLastName().isEmpty()) {
			isValid = false;
		}
		if (getCNP().length() != 13) {
			isValid = false;
		}
		return isValid;
	}
}
