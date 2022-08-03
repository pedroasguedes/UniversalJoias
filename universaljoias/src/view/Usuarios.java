package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
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
	public Usuarios() {
		setModal(true);
		setTitle("Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/Users.png")));
		setBounds(100, 100, 426, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID\r\n");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(21, 11, 29, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(64, 8, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário\r\n");
		lblNewLabel_1.setBounds(10, 50, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 47, 297, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Login\r\n");
		lblNewLabel_2.setBounds(21, 92, 35, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(21, 128, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(64, 125, 130, 20);
		getContentPane().add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 89, 119, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.setBounds(209, 92, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "User"}));
		comboBox.setBounds(244, 88, 60, 22);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Usuarios.class.getResource("/img/211872_person_add_icon.png")));
		btnNewButton.setBounds(64, 186, 60, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Usuarios.class.getResource("/img/3162598_refresh_return_interface_reload_sync_icon.png")));
		btnNewButton_1.setBounds(176, 186, 60, 55);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(Usuarios.class.getResource("/img/3844425_can_trash_icon.png")));
		btnNewButton_2.setBounds(283, 175, 89, 75);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Usuarios.class.getResource("/img/magnifier_icon-icons.com_48267.png")));
		btnNewButton_3.setBounds(154, 0, 70, 41);
		getContentPane().add(btnNewButton_3);

	}// fim do construtor
}
