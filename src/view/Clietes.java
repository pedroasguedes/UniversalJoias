package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clietes extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clietes dialog = new Clietes();
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
	public Clietes() {
		setTitle("Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clietes.class.getResource("/img/3709745_assistance_client_customer_employee_female_icon.png")));
		setModal(true);
		setBounds(0, 8, 487, 399);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 135, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(36, 132, 69, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(44, 8, 230, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fone");
		lblNewLabel_2.setBounds(309, 135, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(350, 132, 111, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(113, 135, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 132, 164, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(10, 171, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(44, 168, 150, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CEP");
		lblNewLabel_5.setBounds(228, 168, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(252, 165, 124, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Endereço");
		lblNewLabel_6.setBounds(10, 196, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Bairro");
		lblNewLabel_7.setBounds(204, 196, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Numero");
		lblNewLabel_8.setBounds(365, 196, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(62, 193, 130, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(234, 193, 121, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(409, 193, 38, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Complemento");
		lblNewLabel_9.setBounds(10, 236, 69, 14);
		getContentPane().add(lblNewLabel_9);
		
		textField_9 = new JTextField();
		textField_9.setBounds(80, 228, 124, 30);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("UF");
		lblNewLabel_10.setBounds(220, 236, 20, 14);
		getContentPane().add(lblNewLabel_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comboBox.setBounds(244, 232, 30, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("Receber email\r\n com ofertas?");
		lblNewLabel_11.setBounds(10, 277, 134, 33);
		getContentPane().add(lblNewLabel_11);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		comboBox_1.setBounds(154, 282, 38, 22);
		getContentPane().add(comboBox_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Clietes.class.getResource("/img/3844425_can_trash_icon.png")));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(254, 309, 58, 47);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon(Clietes.class.getResource("/img/8445624_left_return_arrow_icon.png")));
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBounds(318, 309, 58, 47);
		getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_2.setIcon(new ImageIcon(Clietes.class.getResource("/img/211872_person_add_icon.png")));
		btnNewButton_2_2.setContentAreaFilled(false);
		btnNewButton_2_2.setBorderPainted(false);
		btnNewButton_2_2.setBounds(386, 309, 58, 47);
		getContentPane().add(btnNewButton_2_2);
		
		JLabel lblNewLabel_12 = new JLabel("Cidade");
		lblNewLabel_12.setBounds(292, 236, 46, 14);
		getContentPane().add(lblNewLabel_12);
		
		textField_10 = new JTextField();
		textField_10.setBounds(327, 233, 97, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setBounds(378, 167, 69, 17);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Clietes.class.getResource("/img/magnifier_icon-icons.com_48267.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(284, 0, 32, 41);
		getContentPane().add(btnNewButton);

	}
}
