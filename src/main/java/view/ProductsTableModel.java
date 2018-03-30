package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.Product;
import viewmodel.ProductDAOService;
import viewmodel.ProductDAOServiceImplementation;

public class ProductsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Product> products;
	private String[] columns;

	public ProductsTableModel(List<Product> products) {
		super();
		this.products = products;
		columns = new String[] { "ID", "Name", "Description", "Price", "Delete", "Update" };
	}

	public int getColumnCount() {
		return columns.length;
	}

	public Object getValueAt(int row, int col) {
		Product product = products.get(row);
		switch (col) {
		case 0:
			return product.getProductId();
		case 1:
			return product.getName();
		case 2:
			return product.getDescription();
		case 3:
			return product.getPrice();
		case 4:
			final JButton deleteButton = new JButton("Delete");
			deleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ProductDAOService productDAOService = new ProductDAOServiceImplementation();
					productDAOService.deleteProduct(product.getProductId());
				}
			});
			return deleteButton;
		case 5:
			final JButton updateButton = new JButton("Update");
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ProductDAOService productDAOService = new ProductDAOServiceImplementation();
					Product product = new Product();
					product.setName(getValueAt(row, 1).toString());
					product.setDescription(getValueAt(row, 2).toString());
					product.setPrice((double) getValueAt(row, 3));
					productDAOService.updateProduct(product);
				}
			});
			return updateButton;
		default:
			return null;
		}
	}

	public boolean isCellEditable(int row, int col) {
		if (col != 0) {
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
		return products.size();
	}

}