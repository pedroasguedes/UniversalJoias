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
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblData;
	public JButton btnUsuarios;
	public JButton btnRelatorios;
	public JPanel panelUsuario;
	public JLabel lblUsuario;
// atribuir o modificador publico
	
	
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
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(192, 400, 228, 29);
		contentPane.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/9035891_star_half_sharp_icon.png")));
		lblNewLabel.setBounds(0, 335, 117, 94);
		contentPane.add(lblNewLabel);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setEnabled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			// evento clicar no botão
			public void actionPerformed(ActionEvent e) {
				// Link para o JDialog
				Usuarios usuarios= new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/Users.png")));
		btnUsuarios.setBounds(10, 11, 128, 128);
		contentPane.add(btnUsuarios);
		
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
		
		btnRelatorios = new JButton("");
		btnRelatorios.setEnabled(false);
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorios = new Relatorio();
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setToolTipText("relatório");
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/1622837_analytics_docs_documents_graph_pdf_icon.png")));
		btnRelatorios.setBounds(170, 150, 128, 128);
		contentPane.add(btnRelatorios);
		
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
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.activeCaption);
		panelUsuario.setForeground(Color.CYAN);
		panelUsuario.setBounds(0, 395, 624, 45);
		contentPane.add(panelUsuario);
		
		lblUsuario = new JLabel("New label");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(506, 373, 108, 15);
		contentPane.add(lblUsuario);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
	}
}
