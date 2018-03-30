package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import model.User;
import viewmodel.UserDAOService;
import viewmodel.UserDAOServiceImplementation;

public class UsersView extends JDialog {

	private static final long serialVersionUID = 1L;

	public UsersView(Frame parentFrame) {
		super(parentFrame, "UsersView", true);

		UserDAOService userDAOService = new UserDAOServiceImplementation();

		ArrayList<User> users = userDAOService.getAllUsers();
		TableModel model = new UsersTableModel(users);
		JTable table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("Delete").setCellRenderer(buttonRenderer);
		table.getColumn("Update").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));

		final JButton addNewUserButton = new JButton("Add New User");
		addNewUserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddNewUserView addNewUserView = new AddNewUserView(parentFrame);
				addNewUserView.setVisible(true);
			}

		});

		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(addNewUserButton, BorderLayout.PAGE_END);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
		setVisible(true);

	}

	private static class JTableButtonRenderer implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JButton button = (JButton) value;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(UIManager.getColor("Button.background"));
			}
			return button;
		}
	}

	private static class JTableButtonMouseListener extends MouseAdapter {
		private final JTable table;

		public JTableButtonMouseListener(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX());
			int row = e.getY() / table.getRowHeight();

			if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
				Object value = table.getValueAt(row, column);
				if (value instanceof JButton) {
					((JButton) value).doClick();
				}
			}
		}
	}

}
