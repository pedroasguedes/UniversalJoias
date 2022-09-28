package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;

public class Pdv extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pdv dialog = new Pdv();
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
	public Pdv() {
		setTitle("Produto de Venda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pdv.class.getResource("/img/7518038_ring_love_heart_diamond_valentine_icon.png")));
		setModal(true);
		setBounds(100, 100, 450, 300);

	}

}
