package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			// evento ativar janela
			@Override
			public void windowActivated(WindowEvent e) {
				  Date data = new Date();
				  DateFormat formatador = DateFormat.getDateInstance  (DateFormat.FULL);
				  lblData.setText(formatador.format(data));
				}
		});
		setResizable(false);
		setTitle("principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setBounds(333, 376, 228, 29);
		contentPane.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/9035891_star_half_sharp_icon.png")));
		lblNewLabel.setBounds(10, 311, 117, 94);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			// evento clicar no botão
			public void actionPerformed(ActionEvent e) {
				// Link para o JDialog
				Usuarios usuarios= new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnNewButton.setToolTipText("Usuários");
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/img/Users.png")));
		btnNewButton.setBounds(10, 11, 128, 128);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque estoques = new Estoque();
				estoques.setVisible(true);
			}
		});
		btnNewButton_1.setToolTipText("estoque");
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/img/49590_boxes_customers_inventory_products_icon.png")));
		btnNewButton_1.setBounds(170, 11, 128, 128);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedor fonecedores = new Fornecedor();
				fonecedores.setVisible(true);
				
			}
		});
		btnNewButton_2.setToolTipText("fornecedores");
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/img/9133518_deliveryman_delivery_logistic_shipping_icon.png")));
		btnNewButton_2.setBounds(333, 11, 128, 128);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pdv pdvs = new Pdv();
				pdvs.setVisible(true);
			}
		});
		btnNewButton_3.setToolTipText("PDV");
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/img/7518038_ring_love_heart_diamond_valentine_icon.png")));
		btnNewButton_3.setBounds(10, 150, 128, 128);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorios = new Relatorio();
				relatorios.setVisible(true);
			}
		});
		btnNewButton_4.setToolTipText("relatório");
		btnNewButton_4.setIcon(new ImageIcon(Principal.class.getResource("/img/1622837_analytics_docs_documents_graph_pdf_icon.png")));
		btnNewButton_4.setBounds(170, 150, 128, 128);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ferramentas ferramenta = new Ferramentas();
				ferramenta.setVisible(true);
			}
		});
		btnNewButton_5.setToolTipText("ferramentas");
		btnNewButton_5.setIcon(new ImageIcon(Principal.class.getResource("/img/3592847_general_office_repair_repair tool_screwdriver_icon.png")));
		btnNewButton_5.setBounds(333, 150, 128, 128);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clietes cliente = new Clietes();
				cliente.setVisible(true);
			}
		});
		btnNewButton_2_1.setToolTipText("clientes");
		btnNewButton_2_1.setIcon(new ImageIcon(Principal.class.getResource("/img/3709745_assistance_client_customer_employee_female_icon.png")));
		btnNewButton_2_1.setBounds(486, 11, 128, 128);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobres = new Sobre();
				sobres.setVisible(true);
			}
		});
		btnNewButton_2_2.setToolTipText("sobre");
		btnNewButton_2_2.setIcon(new ImageIcon(Principal.class.getResource("/img/2639759_about_icon.png")));
		btnNewButton_2_2.setBounds(486, 150, 128, 128);
		contentPane.add(btnNewButton_2_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.activeCaption);
		panel.setBounds(10, 371, 604, 45);
		contentPane.add(panel);
	}
}
