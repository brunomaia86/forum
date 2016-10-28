package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.Usuario;

public class UsuarioDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static String autenticar(String login, String senha) throws Exception {

		try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum",
				"postgres", "postgres")) {

			String sql = "select nome from usuario where login = ? and senha = ?";
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString("nome");

			} else {
				throw new Exception("NÃ£o foi possivel autenticar..");
			}
		}

	}

	public static Usuario recuperar(String login) {

		Usuario u = new Usuario();

		try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum",
				"postgres", "postgres")) {

			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				u.setLogin(rs.getString("login"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setPontos(rs.getInt("pontos"));
			}
			rs.close();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException("NÃo foi possivel recuperar o usuario", e);
		}
		return u;
	}

	public static void inserirUsuario(Usuario u) {

		try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum",
				"postgres", "postgres")) {

			String sql = "INSERT INTO usuario(login, nome, email, senha, pontos) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);

			stm.setString(1, u.getLogin());
			stm.setString(2, u.getNome());
			stm.setString(3, u.getEmail());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());

			stm.executeUpdate();

			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException("NÃo foi possivel inserir o usuario", e);
		}

	}

	public static void adicionarPontos(String login, int pontos) {
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum",
				"postgres", "postgres")) {
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, pontos);
            stm.setString(2, login);

            stm.executeUpdate();
        } catch (SQLException e) {
            throw  new RuntimeException("Não foi possível executar o acesso ao banco de dados", e);
        }
}

}
