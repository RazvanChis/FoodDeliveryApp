package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.User;
import viewmodel.UserDAOService;
import viewmodel.UserDAOServiceImplementation;

public class UsersTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<User> users;
	private String[] columns;

	public UsersTableModel(List<User> users) {
		super();
		this.users = users;
		columns = new String[] { "CNP", "Firstname", "Lastname", "Username", "Card number", "Email", "Country",
				"County", "City", "Street", "Street Number", "Type", "Delete", "Update" };
	}

	public int getColumnCount() {
		return columns.length;
	}

	public Object getValueAt(int row, int col) {
		User user = users.get(row);
		switch (col) {
		case 0:
			return user.getCnp();
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName();
		case 3:
			return user.getUsername();
		case 4:
			return user.getCardNumber();
		case 5:
			return user.getEmail();
		case 6:
			return user.getCountry();
		case 7:
			return user.getCounty();
		case 8:
			return user.getCity();
		case 9:
			return user.getStreet();
		case 10:
			return user.getStreetNumber();
		case 11:
			return user.getType();
		case 12:
			final JButton deleteButton = new JButton("Delete");
			deleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UserDAOService userDAOService = new UserDAOServiceImplementation();
					userDAOService.deleteUser(user.getCnp());
				}
			});
			return deleteButton;
		case 13:
			final JButton updateButton = new JButton("Update");
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UserDAOService userDAOService = new UserDAOServiceImplementation();
					User user = new User();
					user.setFirstName(getValueAt(row, 1).toString());
					user.setLastName(getValueAt(row, 2).toString());
					user.setUsername(getValueAt(row, 3).toString());
					user.setEmail(getValueAt(row, 5).toString());
					user.setCountry(getValueAt(row, 6).toString());
					user.setCounty(getValueAt(row, 7).toString());
					user.setCity(getValueAt(row, 8).toString());
					user.setStreet(getValueAt(row, 9).toString());
					user.setStreetNumber(getValueAt(row, 10).toString());
					userDAOService.updateUser(user);
				}
			});
			return updateButton;
		default:
			return null;
		}
	}

	public boolean isCellEditable(int row, int col) {
		if (col != 11 && col != 0) {
			return true;
		} else {
			return false;
		}
	}

	public String getColumnName(int col) {
		return columns[col];
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

}
