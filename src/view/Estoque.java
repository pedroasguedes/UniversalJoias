package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;

public class Estoque extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque dialog = new Estoque();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Estoque() {
		setTitle("Estoque");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Estoque.class.getResource("/img/49590_boxes_customers_inventory_products_icon.png")));
		setModal(true);
		setBounds(100, 100, 450, 300);

	}

}
