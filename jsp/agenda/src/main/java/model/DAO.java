package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "56571998";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar(){
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		}
		catch(Exception e){
			System.out.println(e);	
			return null;
		}
	}
	
	/**
	 * Teste conexao.
	 */
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "INSERT INTO contatos (nome, fone, email) VALUES (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(create);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getFone());
			ps.setString(3, contato.getEmail());
			ps.executeUpdate();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos(){
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "SELECT * FROM contatos ORDER BY nome";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(read);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String idcontato = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new JavaBeans(idcontato, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read2 = "SELECT * FROM contatos WHERE idcontato = ?";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(read2);
			ps.setString(1, contato.getIdcontato());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				contato.setIdcontato(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String update = "UPDATE contatos SET nome = ?, fone = ?, email = ? WHERE idcontato = ?";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getFone());
			ps.setString(3, contato.getEmail());
			ps.setString(4, contato.getIdcontato());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar contatp.
	 *
	 * @param contato the contato
	 */
	public void deletarContatp(JavaBeans contato) {
		String delete = "DELETE FROM contatos WHERE idcontato = ?";
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setString(1, contato.getIdcontato());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
