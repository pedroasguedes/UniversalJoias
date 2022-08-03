package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fornecedor extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedor dialog = new Fornecedor();
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
	public Fornecedor() {
		setTitle("Fornecedor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedor.class.getResource("/img/9133518_deliveryman_delivery_logistic_shipping_icon.png")));
		setModal(true);
		setBounds(100, 100, 558, 394);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedores");
		lblNewLabel.setBounds(10, 23, 97, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(83, 20, 128, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/magnifier_icon-icons.com_48267.png")));
		btnNewButton.setBounds(221, 11, 32, 41);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 110, 23, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNPJ");
		lblNewLabel_2.setBounds(84, 110, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 107, 52, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 107, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("IE");
		lblNewLabel_3.setBounds(203, 110, 23, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("IM");
		lblNewLabel_4.setBounds(301, 110, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(323, 107, 128, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setBounds(225, 106, 66, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Rede Social");
		lblNewLabel_5.setBounds(10, 153, 66, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 150, 138, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nome Fantasia");
		lblNewLabel_6.setBounds(245, 153, 74, 14);
		getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(323, 150, 147, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("SITE");
		lblNewLabel_7.setBounds(10, 188, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(40, 185, 180, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fone");
		lblNewLabel_8.setBounds(245, 188, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(280, 185, 117, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Contato");
		lblNewLabel_9.setBounds(10, 235, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(55, 232, 123, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("E-mail");
		lblNewLabel_10.setBounds(188, 235, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(221, 232, 152, 20);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("CEP");
		lblNewLabel_11.setBounds(383, 235, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		textField_10 = new JTextField();
		textField_10.setBounds(404, 232, 97, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setBounds(458, 252, 74, 14);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_12 = new JLabel("Observação");
		lblNewLabel_12.setBounds(10, 300, 72, 14);
		getContentPane().add(lblNewLabel_12);
		
		textField_11 = new JTextField();
		textField_11.setBounds(74, 300, 170, 47);
		getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/3844425_can_trash_icon.png")));
		btnNewButton_2.setBounds(289, 300, 58, 47);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/211872_person_add_icon.png")));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBounds(453, 300, 58, 47);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/8445624_left_return_arrow_icon.png")));
		btnNewButton_3.setBounds(357, 300, 72, 55);
		getContentPane().add(btnNewButton_3);

	}

}
