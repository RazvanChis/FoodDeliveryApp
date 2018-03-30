package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.User;
import viewmodel.UserDAOService;
import viewmodel.UserDAOServiceImplementation;

public class AddNewUserView extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField cnpTextField;
	private JTextField countryTextField;
	private JTextField countyTextField;
	private JTextField cityTextField;
	private JTextField streetTextField;
	private JTextField streetNumberTextField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel emailLabel;
	private JLabel cnpLabel;
	private JLabel userTypeLabel;
	private JLabel countryLabel;
	private JLabel countyLabel;
	private JLabel cityLabel;
	private JLabel streetLabel;
	private JLabel streetNumberLabel;
	private JButton addUserButton;
	private JButton cancelButton;

	UserDAOService userDAOService = new UserDAOServiceImplementation();

	public AddNewUserView(Frame parentFrame) {
		super(parentFrame, "User", true);

		JPanel userPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;

		usernameLabel = new JLabel("Username: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		userPanel.add(usernameLabel, constraints);

		usernameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		userPanel.add(usernameTextField, constraints);

		passwordLabel = new JLabel("Password: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		userPanel.add(passwordLabel, constraints);

		passwordField = new JPasswordField(20);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		userPanel.add(passwordField, constraints);
		userPanel.setBorder(new LineBorder(Color.GRAY));

		firstNameLabel = new JLabel("FirstName: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		userPanel.add(firstNameLabel, constraints);

		firstNameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		userPanel.add(firstNameTextField, constraints);

		lastNameLabel = new JLabel("LastName: ");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		userPanel.add(lastNameLabel, constraints);

		lastNameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		userPanel.add(lastNameTextField, constraints);

		emailLabel = new JLabel("Email: ");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		userPanel.add(emailLabel, constraints);

		emailTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		userPanel.add(emailTextField, constraints);

		cnpLabel = new JLabel("CNP: ");
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		userPanel.add(cnpLabel, constraints);

		cnpTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		userPanel.add(cnpTextField, constraints);

		userTypeLabel = new JLabel("User Type: ");
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		userPanel.add(userTypeLabel, constraints);

		String[] userTypes = new String[] { "Admin", "Customer" };
		JComboBox<String> userTypeComboBox = new JComboBox<>(userTypes);
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		userPanel.add(userTypeComboBox, constraints);
		userPanel.setBorder(new LineBorder(Color.GRAY));
		String selectedUserType = (String) userTypeComboBox.getSelectedItem();

		countryLabel = new JLabel("Country: ");
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		userPanel.add(countryLabel, constraints);

		countryTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 7;
		constraints.gridwidth = 2;
		userPanel.add(countryTextField, constraints);

		countyLabel = new JLabel("County: ");
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 1;
		userPanel.add(countyLabel, constraints);

		countyTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		userPanel.add(countyTextField, constraints);

		cityLabel = new JLabel("City: ");
		constraints.gridx = 0;
		constraints.gridy = 9;
		constraints.gridwidth = 1;
		userPanel.add(cityLabel, constraints);

		cityTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 9;
		constraints.gridwidth = 2;
		userPanel.add(cityTextField, constraints);

		streetLabel = new JLabel("Street: ");
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridwidth = 1;
		userPanel.add(streetLabel, constraints);

		streetTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		userPanel.add(streetTextField, constraints);

		streetNumberLabel = new JLabel("Street Number: ");
		constraints.gridx = 0;
		constraints.gridy = 11;
		constraints.gridwidth = 1;
		userPanel.add(streetNumberLabel, constraints);

		streetNumberTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 11;
		constraints.gridwidth = 2;
		userPanel.add(streetNumberTextField, constraints);

		addUserButton = new JButton("Add User");
		addUserButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (isUserFormValid()) {

					User user = new User();
					user.setCnp(getCNP());
					user.setEmail(getEmail());
					user.setFirstName(getFirstName());
					user.setLastName(getLastName());
					user.setPassword(getPassword());
					user.setUsername(getUsername());
					user.setType(selectedUserType);
					user.setCountry(getCountry());
					user.setCounty(getCounty());
					user.setCity(getCity());
					user.setStreet(getStreet());
					user.setStreetNumber(getStreetNumber());

					if (userDAOService.addUser(user)) {
						UsersView usersView = new UsersView(parentFrame);
						usersView.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(AddNewUserView.this, "Could not add the new user", "Add User",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(AddNewUserView.this, "Invalid user form", "Add User",
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
		buttonsPanel.add(addUserButton);
		buttonsPanel.add(cancelButton);

		getContentPane().add(userPanel, BorderLayout.CENTER);
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

	public String getCountry() {
		return countryTextField.getText();
	}

	public String getCounty() {
		return countyTextField.getText();
	}

	public String getCity() {
		return cityTextField.getText();
	}

	public String getStreet() {
		return streetTextField.getText();
	}

	public String getStreetNumber() {
		return streetNumberTextField.getText();
	}

	public boolean isUserFormValid() {
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
		if (getFirstName().isEmpty() || getLastName().isEmpty() || getCountry().isEmpty() || getCounty().isEmpty()
				|| getCity().isEmpty() || getStreet().isEmpty() || getStreetNumber().isEmpty()) {
			isValid = false;
		}
		if (getCNP().length() != 13) {
			isValid = false;
		}
		return isValid;
	}

}
