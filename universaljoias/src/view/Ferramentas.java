package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;

public class Ferramentas extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ferramentas dialog = new Ferramentas();
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
	public Ferramentas() {
		setTitle("Ferramentas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ferramentas.class.getResource("/img/3592847_general_office_repair_repair tool_screwdriver_icon.png")));
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}

}
