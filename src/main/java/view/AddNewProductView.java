package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Product;
import viewmodel.ProductDAOService;
import viewmodel.ProductDAOServiceImplementation;

public class AddNewProductView extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField nameTextField;
	private JTextField descriptionTextField;
	private JTextField priceTextField;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel priceLabel;
	private JButton addProductButton;
	private JButton cancelButton;

	ProductDAOService productDAOService = new ProductDAOServiceImplementation();

	public AddNewProductView(Frame parentFrame) {
		super(parentFrame, "Product", true);

		JPanel userPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;

		nameLabel = new JLabel("Name: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		userPanel.add(nameLabel, constraints);

		nameTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		userPanel.add(nameTextField, constraints);

		descriptionLabel = new JLabel("Description: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		userPanel.add(descriptionLabel, constraints);

		descriptionTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		userPanel.add(descriptionTextField, constraints);

		priceLabel = new JLabel("Price: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		userPanel.add(priceLabel, constraints);

		priceTextField = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		userPanel.add(priceTextField, constraints);

		addProductButton = new JButton("Add Product");
		addProductButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (isUserFormValid()) {
					Product product = new Product();
					product.setName(getName());
					product.setDescription(getDescription());
					product.setPrice(Double.parseDouble(getPrice()));
					if (productDAOService.addProduct(product)) {

					} else {
						JOptionPane.showMessageDialog(AddNewProductView.this, "Could not add the new product",
								"Add Product", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(AddNewProductView.this, "Invalid product form", "Add Product",
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
		buttonsPanel.add(addProductButton);
		buttonsPanel.add(cancelButton);

		getContentPane().add(userPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setLocationRelativeTo(parentFrame);
	}

	public String getName() {
		return nameTextField.getText();
	}

	public String getDescription() {
		return descriptionTextField.getText();
	}

	public String getPrice() {
		return priceTextField.getText();
	}

	public boolean isUserFormValid() {
		boolean isValid = true;
		if (getName().isEmpty() || getDescription().isEmpty() || getPrice().isEmpty()) {
			isValid = false;
		}
		return isValid;
	}

}
