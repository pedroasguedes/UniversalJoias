package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

public class Fornecedor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisarFornecedor;
	private JTextField txtForId;
	private JTextField txtForCnpj;
	private JTextField txtForRazao;
	private JTextField txtForFantasia;
	private JTextField txtForFone;
	private JTextField txtForCep;
	private JTextField txtForEndereco;
	private JTextField txtForNumero;
	private JTextField txtForBairro;
	private JTextField txtForCidade;
	private JTable tblFornecedores;
	private JComboBox cboForUF;

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
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedor.class.getResource("/img/9133518_deliveryman_delivery_logistic_shipping_icon.png")));
		setTitle("F O R N E C E D O R");
		setBounds(100, 100, 730, 479);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(10, 28, 84, 14);
		getContentPane().add(lblNewLabel);

		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// Evento Digitação
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.setBounds(82, 25, 130, 20);
		getContentPane().add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(20, 154, 25, 14);
		getContentPane().add(lblNewLabel_1);

		txtForId = new JTextField();
		txtForId.setBounds(46, 151, 58, 20);
		getContentPane().add(txtForId);
		txtForId.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("CNPJ:");
		lblNewLabel_1_1.setBounds(240, 213, 37, 14);
		getContentPane().add(lblNewLabel_1_1);

		txtForCnpj = new JTextField();
		txtForCnpj.setColumns(10);
		txtForCnpj.setBounds(278, 210, 127, 20);
		getContentPane().add(txtForCnpj);

		cboForUF = new JComboBox();
		cboForUF.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboForUF.setBounds(605, 327, 84, 22);
		getContentPane().add(cboForUF);

		JLabel lblNewLabel_1_2 = new JLabel("Raz\u00E3o Social:");
		lblNewLabel_1_2.setBounds(20, 241, 96, 14);
		getContentPane().add(lblNewLabel_1_2);

		txtForRazao = new JTextField();
		txtForRazao.setColumns(10);
		txtForRazao.setBounds(118, 238, 179, 20);
		getContentPane().add(txtForRazao);

		JLabel lblNewLabel_1_2_1 = new JLabel("Nome Fantasia:");
		lblNewLabel_1_2_1.setBounds(307, 241, 98, 14);
		getContentPane().add(lblNewLabel_1_2_1);

		txtForFantasia = new JTextField();
		txtForFantasia.setColumns(10);
		txtForFantasia.setBounds(399, 238, 253, 20);
		getContentPane().add(txtForFantasia);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("FONE:");
		lblNewLabel_1_2_1_1_1.setBounds(20, 269, 37, 14);
		getContentPane().add(lblNewLabel_1_2_1_1_1);

		txtForFone = new JTextField();
		txtForFone.setColumns(10);
		txtForFone.setBounds(96, 266, 181, 20);
		getContentPane().add(txtForFone);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("CEP:");
		lblNewLabel_1_2_2_1.setBounds(307, 269, 37, 14);
		getContentPane().add(lblNewLabel_1_2_2_1);

		txtForCep = new JTextField();
		txtForCep.setColumns(10);
		txtForCep.setBounds(354, 266, 142, 20);
		getContentPane().add(txtForCep);

		JLabel lblNewLabel_1_2_2_2 = new JLabel("Endere\u00E7o: ");
		lblNewLabel_1_2_2_2.setBounds(20, 300, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2_2);

		txtForEndereco = new JTextField();
		txtForEndereco.setColumns(10);
		txtForEndereco.setBounds(82, 297, 181, 20);
		getContentPane().add(txtForEndereco);

		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1_2_2_1_1.setBounds(349, 300, 51, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1);

		txtForNumero = new JTextField();
		txtForNumero.setColumns(10);
		txtForNumero.setBounds(399, 297, 62, 20);
		getContentPane().add(txtForNumero);

		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("Bairro: ");
		lblNewLabel_1_2_2_2_1.setBounds(20, 331, 62, 14);
		getContentPane().add(lblNewLabel_1_2_2_2_1);

		txtForBairro = new JTextField();
		txtForBairro.setColumns(10);
		txtForBairro.setBounds(93, 328, 170, 20);
		getContentPane().add(txtForBairro);

		JLabel lblNewLabel_1_2_2_1_1_2 = new JLabel("Cidade:");
		lblNewLabel_1_2_2_1_1_2.setBounds(273, 331, 51, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_2);

		txtForCidade = new JTextField();
		txtForCidade.setColumns(10);
		txtForCidade.setBounds(334, 328, 190, 20);
		getContentPane().add(txtForCidade);

		JLabel lblNewLabel_1_2_2_1_1_1_1 = new JLabel("UF:");
		lblNewLabel_1_2_2_1_1_1_1.setBounds(547, 331, 25, 14);
		getContentPane().add(lblNewLabel_1_2_2_1_1_1_1);

		btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnExcluir.setToolTipText("Remover");
		btnExcluir.setBorderPainted(false);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/3844425_can_trash_icon.png")));
		btnExcluir.setBounds(625, 365, 64, 64);
		getContentPane().add(btnExcluir);

		btnAlterar = new JButton("");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFornecedor();
			}
		});
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/modificar.png")));
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(551, 374, 64, 55);
		getContentPane().add(btnAlterar);

		btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarFornecedor();
			}
		});
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(Fornecedor.class.getResource("/img/211872_person_add_icon.png")));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBounds(477, 365, 64, 64);
		getContentPane().add(btnAdicionar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 27, 464, 109);
		getContentPane().add(scrollPane);

		tblFornecedores = new JTable();
		tblFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// evento clicar com o mouse na tabela
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedores);

		btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarFornecedores();
			}
		});
		btnPesquisar.setBounds(126, 148, 89, 23);
		getContentPane().add(btnPesquisar);

		JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtForCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP para realizar a busca do endereço");
					txtForCep.requestFocus();
				} else {
					buscarCep();
					txtForEndereco.setEditable(true);
					txtForNumero.setEditable(true);

					txtForBairro.setEditable(true);
					txtForCidade.setEditable(true);
					txtForNumero.setEditable(true);
				}
			}
		});
		btnBuscarCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarCep.setBounds(526, 265, 89, 51);
		getContentPane().add(btnBuscarCep);

		btnBuscarCep.setBounds(526, 265, 89, 23);
		getContentPane().add(btnBuscarCep);

		JButton btnPesquisarFor = new JButton("Buscar");
		btnPesquisarFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarnomeFor();
			}
		});
		btnPesquisarFor.setBounds(107, 46, 89, 23);
		getContentPane().add(btnPesquisarFor);

		// Validacao com o uso da biblioteca Atxy2k

				// txtBuscarFor
				RestrictedTextField validartxtBuscarFor = new RestrictedTextField(txtPesquisarFornecedor);

				// Limitar a somente 100 caracteres no campo txtBuscarFor
				validartxtBuscarFor.setLimit(40);

				// txtForCNPJ
				RestrictedTextField validarCNPJ = new RestrictedTextField(txtForCnpj);

				// Restringir a somente numeros no campo CNPJ
				validarCNPJ.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo CNPJ
				validarCNPJ.setLimit(14);
				// txtForRazao
				RestrictedTextField validarRazao = new RestrictedTextField(txtForRazao);

				// Restringir a somente letras no campo razao
				validarRazao.setOnlyText(true);
				// Aceitar espaco no campo razao
				validarRazao.setAcceptSpace(true);
				// Limitar a somente 100 caracteres no campo razao
				validarRazao.setLimit(100);

				// txtForFantasia
				RestrictedTextField validarFantasia = new RestrictedTextField(txtForFantasia);

				// Limitar a somente 100 caracteres no campo fantasia
				validarFantasia.setLimit(100);

				// txtForFone
				RestrictedTextField validarFone = new RestrictedTextField(txtForFone);

				// Restringir a somente numeros no campo Fone
				validarFone.setOnlyNums(true);
				// Limitar a somente 14 numeros no campo Fone
				validarFone.setLimit(14);

				// txtForCEP
				RestrictedTextField validarCEP = new RestrictedTextField(txtForCep);

				// Restringir a somente numeros no campo CEP
				validarCEP.setOnlyNums(true);
				// Limitar a somente 8 numeros no campo CEP
				validarCEP.setLimit(8);

				// txtForEndereco
				RestrictedTextField validarEndereco = new RestrictedTextField(txtForEndereco);

				// Restringir a somente letras no campo endereco
				validarEndereco.setOnlyText(true);
				// Aceitar espaco no campo endereco
				validarEndereco.setAcceptSpace(true);
				// Limitar a somente 60 caracteres no campo endereco
				validarEndereco.setLimit(60);

				// txtForNumero
				RestrictedTextField validarNumero = new RestrictedTextField(txtForNumero);

				// Restringir a somente digitos no campo numero
				validarNumero.setOnlyNums(true);
				// Limitar a somente 10 digitos no campo numero
				validarNumero.setLimit(10);

				// txtForBairro
				RestrictedTextField validarBairro = new RestrictedTextField(txtForBairro);

				// Limitar a somente 50 caracteres no campo bairro
				validarBairro.setLimit(50);

				// txtForCidade
				RestrictedTextField validarCidade = new RestrictedTextField(txtForCidade);

				// Restringir a somente letras no campo cidade
				validarCidade.setOnlyText(true);
				// Aceitar espaco no campo cidade
				validarCidade.setAcceptSpace(true);
				// Limitar a somente 50 caracteres no campo cidade
				validarCidade.setLimit(50);


		
		
	}// fim do construtor

	DAO dao = new DAO();
	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnPesquisar;

	/**
	 * Método responsavel pela pesquisa avançada do fornecedor usando o nome de
	 * fantasia e a biblioteca rs2xml
	 */

	private void pesquisarFornecedorTabela() {
		String readT = "select idfor as ID ,fantasia as fornecedor,fone from fornecedores where fantasia like ?";
		try {

			Connection con = dao.conectar();

			PreparedStatement pst = con.prepareStatement(readT);

			pst.setString(1, txtPesquisarFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();

			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Método responsavel por setar as caixas de texto de acordo com os campos da
	 * tabela (mouse click)
	 */

	private void setarCaixasTexto() {

		int setar = tblFornecedores.getSelectedRow();
		txtForId.setText(tblFornecedores.getModel().getValueAt(setar, 0).toString());
		limparCamposFornecedor();
	}

	private void limparCamposFornecedor() {
		// limpar a tabela
		((DefaultTableModel) tblFornecedores.getModel()).setRowCount(0);
	}

	private void pesquisarnomeFor() {
		if (txtPesquisarFornecedor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o nome do Fornecedor");
			txtPesquisarFornecedor.requestFocus();
		} else {
			String read = "select * from fornecedores where fantasia = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtPesquisarFornecedor.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtForCnpj.setText(rs.getString(2));
					txtForRazao.setText(rs.getString(3));
					txtForFantasia.setText(rs.getString(4));
					txtForFone.setText(rs.getString(5));
					txtForCep.setText(rs.getString(6));
					txtForEndereco.setText(rs.getString(7));
					txtForNumero.setText(rs.getString(8));
					txtForCidade.setText(rs.getString(9));
					txtForBairro.setText(rs.getString(10));
					cboForUF.setSelectedItem(rs.getString(11));
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					txtForId.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");
					limparCampos();
					btnPesquisar.setEnabled(false);
					btnAdicionar.setEnabled(true);
					txtForId.setEnabled(false);

				}

				con.close();

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtPesquisarFornecedor.setText(null);
				txtPesquisarFornecedor.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private void pesquisarFornecedores() {
		// validação
		if (txtForId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "digite o ID do fornecedor");
			txtForId.requestFocus();
		} else {
			String read = "select * from fornecedores where idfor = ?";

			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtForId.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtForCnpj.setText(rs.getString(2));
					txtForRazao.setText(rs.getString(3));
					txtForFantasia.setText(rs.getString(4));
					txtForFone.setText(rs.getString(5));
					txtForCep.setText(rs.getString(6));
					txtForEndereco.setText(rs.getString(7));
					txtForNumero.setText(rs.getString(8));
					txtForCidade.setText(rs.getString(9));
					txtForBairro.setText(rs.getString(10));
					cboForUF.setSelectedItem(rs.getString(11));
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");
					limparCampos();
					btnAdicionar.setEnabled(true);
				}
				// Nunca esquecer de encerrar a conexão
				con.close();

			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
				txtForId.setText(null);
				txtForId.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Método responsavel por adicionar um novo fornecedor no banco
	 */
	private void adicionarFornecedor() {
		// validação
		
		if (txtForCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtForCnpj.requestFocus();
			
		} else if (txtForRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Razão");
			txtForRazao.requestFocus();
			
		} else if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome Fantasia");
			txtForFantasia.requestFocus();
			
		} else if (txtForFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o telefone");
			txtForFone.requestFocus();
			
		} else if (txtForCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o CEP");
			txtForCep.requestFocus();
			
		} else if (txtForEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço");
			txtForEndereco.requestFocus();
			
		} else if (txtForNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Numero do endereço");
			txtForNumero.requestFocus();
			
		} else if (txtForCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade");
			txtForCidade.requestFocus();
			
		} else if (txtForBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro");
			txtForBairro.requestFocus();
			
		} else if (cboForUF.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione a UF");
			cboForUF.requestFocus();
		} else {
			// lógica principal
			String create = "insert into  fornecedores (cnpj,razao,fantasia,fone,cep,endereco,numero,bairro,cidade,uf) values(?,?,?,?,?,?,?,?,?,?)";
			try {
				// estabelecer conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(create);
				// Substituir os ???? pelo conteudo das caixas de texto
				pst.setString(1, txtForCnpj.getText());
				pst.setString(2, txtForRazao.getText());
				pst.setString(3, txtForFantasia.getText());
				pst.setString(4, txtForFone.getText());
				pst.setString(5, txtForCep.getText());
				pst.setString(6, txtForEndereco.getText());
				pst.setString(7, txtForNumero.getText());
				pst.setString(8, txtForCidade.getText());
				pst.setString(9, txtForBairro.getText());
				pst.setString(10, cboForUF.getSelectedItem().toString());
				// Executar a query e inserir o usuario no banco
				pst.executeUpdate();
				// Encerrar a conexão
				JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
				limparCampos(); 
				con.close();
			}
				catch (SQLIntegrityConstraintViolationException ex) {

					JOptionPane.showMessageDialog(null,
							"Ocorreu um erro. \nVerifique novamente o CNPJ");
					txtForCnpj.requestFocus();

				}
			 catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responsavel por alterar um novo fornecedor no banco
	 */
	private void alterarFornecedor() {

		// validação
		if (txtForCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtForCnpj.requestFocus();
		} else if (txtForRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Razão");
			txtForRazao.requestFocus();
		} else if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome Fantasia");
			txtForFantasia.requestFocus();
		} else if (txtForFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Indorme o telefone");
			txtForFone.requestFocus();
		} else if (txtForCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o CEP");
			txtForCep.requestFocus();
		} else if (txtForEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço");
			txtForEndereco.requestFocus();
		} else if (txtForNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Numero do endereço");
			txtForNumero.requestFocus();
		} else if (txtForCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade");
			txtForCidade.requestFocus();
		} else if (txtForBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro");
			txtForBairro.requestFocus();
		} else if (cboForUF.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione a UF");
			cboForUF.requestFocus();
		} else {
			String update = "update fornecedores set cnpj=?,razao=?,fantasia=?,fone=?,cep=?,endereco=?,numero=?,bairro=?,cidade=?,uf=? where idfor =?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtForCnpj.getText());
				pst.setString(2, txtForRazao.getText());
				pst.setString(3, txtForFantasia.getText());
				pst.setString(4, txtForFone.getText());
				pst.setString(5, txtForCep.getText());
				pst.setString(6, txtForEndereco.getText());
				pst.setString(7, txtForNumero.getText());
				pst.setString(8, txtForCidade.getText());
				pst.setString(9, txtForBairro.getText());
				pst.setString(10, cboForUF.getSelectedItem().toString());
				pst.setString(11, txtForId.getText());
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");
				con.close();
			}catch (SQLIntegrityConstraintViolationException ex) {

				JOptionPane.showMessageDialog(null,
						"Ocorreu um erro. \nVerifique novamente o CNPJ ");
				txtForCnpj.requestFocus();			

				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responsavel por excluir um fornecedor no banco
	 */
	private void excluirFornecedor() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do fornecedor?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from fornecedores where idfor=?;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtForId.getText());
				pst.executeUpdate();
				limparCampos();
				JOptionPane.showMessageDialog(null, "Fornecedor excluído com extremo sucesso.");
				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	private void buscarCep() {

		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String CEP = txtForCep.getText();

		try {

			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + CEP + "&formato=xml");

			SAXReader xml = new SAXReader();

			Document documento = xml.read(url);

			Element root = documento.getRootElement();

			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {

				Element element = it.next();

				if (element.getQualifiedName().equals("cidade")) {
					txtForCidade.setText(element.getText());
				}

				if (element.getQualifiedName().equals("bairro")) {
					txtForBairro.setText(element.getText());
				}

				if (element.getQualifiedName().equals("uf")) {
					cboForUF.setSelectedItem(element.getText());
				}

				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}

				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}

				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();

					if (resultado.equals("1")) {

					}

					else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}
			txtForEndereco.setText(tipoLogradouro + " " + logradouro);
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	private void limparCampos() {
		txtPesquisarFornecedor.setText(null);
		txtForId.setText(null);
		txtForCnpj.setText(null);
		txtForRazao.setText(null);
		txtForFantasia.setText(null);
		txtForFone.setText(null);
		txtForCep.setText(null);
		txtForEndereco.setText(null);
		txtForNumero.setText(null);
		txtForCidade.setText(null);
		txtForBairro.setText(null);
		cboForUF.setSelectedItem("");
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
}