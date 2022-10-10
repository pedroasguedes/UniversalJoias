package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuId;
	private JTextField txtUsuNome;
	private JPasswordField txtUsuSenha;
	private JTextField txtUsuLogin;

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

		txtUsuId = new JTextField();
		txtUsuId.setEditable(false);
		txtUsuId.setBounds(64, 8, 86, 20);
		getContentPane().add(txtUsuId);
		txtUsuId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Usuário\r\n");
		lblNewLabel_1.setBounds(21, 85, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtUsuNome = new JTextField();
		txtUsuNome.setBounds(75, 82, 297, 20);
		getContentPane().add(txtUsuNome);
		txtUsuNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Login\r\n");
		lblNewLabel_2.setBounds(32, 47, 35, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(21, 128, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtUsuSenha = new JPasswordField();
		txtUsuSenha.setBounds(64, 125, 130, 20);
		getContentPane().add(txtUsuSenha);

		txtUsuLogin = new JTextField();
		txtUsuLogin.setBounds(74, 44, 119, 20);
		getContentPane().add(txtUsuLogin);
		txtUsuLogin.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.setBounds(252, 47, 46, 14);
		getContentPane().add(lblNewLabel_4);

		cboUsuPerfil = new JComboBox();
		cboUsuPerfil.setModel(new DefaultComboBoxModel(new String[] { "", "admin", "user" }));
		cboUsuPerfil.setBounds(299, 43, 101, 22);
		getContentPane().add(cboUsuPerfil);

		btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/211872_person_add_icon.png")));
		btnAdicionar.setBounds(64, 186, 60, 52);
		getContentPane().add(btnAdicionar);

		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarUsuario();
				
			}
		});
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setIcon(new ImageIcon(
				Usuarios.class.getResource("/img/3162598_refresh_return_interface_reload_sync_icon.png")));
		btnAlterar.setBounds(176, 186, 60, 55);
		getContentPane().add(btnAlterar);

		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/img/3844425_can_trash_icon.png")));
		btnExcluir.setBounds(283, 175, 89, 75);
		getContentPane().add(btnExcluir);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/magnifier_icon-icons.com_48267.png")));
		btnPesquisar.setBounds(185, 33, 70, 41);
		getContentPane().add(btnPesquisar);

		// validação cpm o uso da biblioteca atxy2k
		// txtUsuId
		RestrictedTextField validarId = new RestrictedTextField(txtUsuId);
		validarId.setOnlyNums(true);
		validarId.setLimit(4);
		// txtUsuNome
		RestrictedTextField validarNome = new RestrictedTextField(txtUsuNome);
		validarNome.setLimit(255);
		// txtUsuLogin
		RestrictedTextField validarLogin = new RestrictedTextField(txtUsuLogin);
		validarLogin.setLimit(255);
		// txtUsuSenha
		RestrictedTextField validarSenha = new RestrictedTextField(txtUsuSenha);
		
		chkSenha = new JCheckBox("Alterar senha");
		chkSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsuSenha.setBackground(Color.ORANGE);
				txtUsuSenha.setText(null);
				txtUsuSenha.requestFocus();
				txtUsuSenha.setEditable(true);
			}
		});
		chkSenha.setVisible(false);
		chkSenha.setBounds(213, 124, 119, 23);
		getContentPane().add(chkSenha);
		validarSenha.setLimit(255);

	}// fim do construtor

	DAO dao = new DAO();
	private JComboBox cboUsuPerfil;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JCheckBox chkSenha;

	// validação da senha (captura segura)

	/**
	 * Método responsavel pela pesquisa de usuários pelo login
	 */

	private void pesquisarUsuario() {
		// validação
		if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o ID do usúario");
			txtUsuId.requestFocus();
		} else {
			// Lógica principal
			// Query (Instrução SQL)
			String read = "select * from usuarios where login = ?";
			// tratar exceções sempre que lidar com o banco
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Seta o arguemento (id)
				pst.setString(1, txtUsuLogin.getText());
				// Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				// validação(existencia de usuario)
				if (rs.next()) {
					// preencher (setar) os campos do formuralario
					txtUsuId.setText(rs.getString(1));
					txtUsuNome.setText(rs.getString(2));
					txtUsuLogin.setText(rs.getString(3));
					cboUsuPerfil.setSelectedItem(rs.getString(5));
					txtUsuSenha.setText(rs.getString(4));
					chkSenha.setVisible(true);
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usúario inexistente");
					
					txtUsuNome.setEditable(true);
					cboUsuPerfil.setEnabled(true);
					cboUsuPerfil.setEditable(true);
					txtUsuSenha.setEditable(true);
					txtUsuNome.requestFocus();
					btnAdicionar.setEnabled(true);
				}
				// Nunca esquecer de encerrar a conexão
				con.close();

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Método responsavel por adicionar um novo usuario no banco
	 */
	private void adicionarUsuario() {
		String capturaSenha = new String(txtUsuSenha.getPassword());
		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o usúario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// lógica principal
			String create = "insert into usuarios (usuario,login,senha,perfil) values (?,?,md5(?),?);";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responsavel por alterar um novo usuario no banco
	 */
	private void alterarUsuario() {
		
		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o usúario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		}
			// lógica principal
			String update = "update usuarios set usuario=?, login=?,perfil=? where iduser=?";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(4, txtUsuId.getText());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Dados do usu�rio, exceto senha, alterados com sucesso");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();
				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	/**
	 * Método reponsavel por alterar a senha
	 */
	private void alterarUsuarioSenha() {
		String capturaSenha = new String(txtUsuSenha.getPassword());
		// validação
		if (txtUsuNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o usúario");
			txtUsuNome.requestFocus();
		} else if (txtUsuLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o login");
			txtUsuLogin.requestFocus();
		} else if (cboUsuPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o perfil do usuário");
			cboUsuPerfil.requestFocus();
		} else if (txtUsuSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a senha");
			txtUsuSenha.requestFocus();
		} else {
			// lógica principal
			String update2 = "update usuarios set usuario=?,senha=md5(?),login=?,perfil=? where iduser=?";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(update2);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtUsuNome.getText());
				pst.setString(2, txtUsuLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
				pst.setString(5, txtUsuId.getText());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				con.close();
				JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtUsuLogin.setText(null);
				txtUsuLogin.requestFocus();

				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	/**
	 * Método responsavel por excluir um novo usuario no banco
	 */
	private void excluirUsuario () {
		//validação (confirmação de exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do usuário?", "Atenção!",JOptionPane.YES_NO_OPTION);
		if(confirma == JOptionPane.YES_OPTION) {
			//Lógica principal
			String delete = "delete from usuarios where iduser=?;";
			
			try {
				// Estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query (comando sql) substituindo a ? pelo iduser
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1,txtUsuId.getText());
				// Executar a query
				pst.executeUpdate();
				// confirmação
				limparCampos();
				JOptionPane.showMessageDialog(null, "Usuário excluído com extremo sucesso.");
				
			limparCampos();
			}catch (Exception e) {
			System.out.println(e);
		}
		}
	
	}

	private void limparCampos() {
		txtUsuId.setText(null);
		txtUsuNome.setText(null);
		txtUsuLogin.setText(null);
		txtUsuSenha.setText(null);
		txtUsuSenha.setBackground(Color.WHITE);
		cboUsuPerfil.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		chkSenha.setVisible(false);
		chkSenha.setSelected(false);
		txtUsuSenha.setEditable(true);
	}
}// fim do código
