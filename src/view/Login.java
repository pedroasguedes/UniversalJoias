package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(61, 70, 46, 14);
		contentPane.add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setBounds(112, 67, 241, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(61, 113, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(112, 110, 241, 20);
		contentPane.add(txtSenha);

		JButton btnLogar = new JButton("acessar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnLogar.setBounds(178, 141, 89, 23);
		contentPane.add(btnLogar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbofff.png")));
		lblStatus.setBounds(10, 191, 46, 59);
		contentPane.add(lblStatus);
		
		//usar o Enter ao invés de "clicar" no botão para logar
		getRootPane().setDefaultButton(btnLogar);
		
	}// fim do contrutor

	// Criação de um objeto para acessar a camada model
	DAO dao = new DAO();
	private JLabel lblStatus;

	/**
	 * Método usado para verificar o status do servidor
	 */
	private void status() {
		try {
			// Abrir para conexão
			Connection con = dao.conectar();
			if (con == null) {
				// Escolher imagem dboff
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbofff.png")));
			} else {
				// Escolher imagem dbon
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
			}
			// Não esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Método usado para autenticar um usúario
	 */
	private void logar() {
		String capturaSenha = new String(txtSenha.getPassword());
		// validação
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtLogin.requestFocus();
		} else if (txtSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtSenha.requestFocus();
		} else {
			// lógica principal
			String read = "select * from usuarios where login=? and senha=md5(?);";
			try {
				// abrir a conexão
				Connection con = dao.conectar();
				//Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
			// Executar a query e de acordo com o resultado liberar os recursos da tela principal
				ResultSet rs = pst.executeQuery();
				// validação (autenticação de usuário)
				// rs.next() -> existência de login e senha correspondente
				if (rs.next()) {
					//Verificar o perfil do usuário
					String perfil = rs.getString(5);
					//System.out.println(perfil);
					if(perfil.equals("admin")){
						Principal principal = new Principal();
						// abrir a tela principal
						principal.setVisible(true);
						//Habilitar recursos
						principal.btnRelatorios.setEnabled(true);
						principal.btnUsuarios.setEnabled(true);
						principal.panelUsuario.setBackground(Color.RED);
						//setar o nome do usuário na tela principal	
						principal.lblUsuario.setText(rs.getString(2));
						
						
					}else {
						Principal principal = new Principal();
						// abrir a tela principal
						principal.setVisible(true);
						con.close();
						//fechar a tela de login
						this.dispose();
					}
					
					//encerrar a conexão
					con.close();
					//fechar a tela de login
					this.dispose();
					
				}else {
					JOptionPane.showMessageDialog(null,"Login e/ou senha inválido(s)");
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

}// fim do código
