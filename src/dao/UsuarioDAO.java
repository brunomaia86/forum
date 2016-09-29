package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum", "postgres",
                "postgres")) {

            String sql = "select nome from usuario where login = ? and senha = ?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("nome");

            } else {
                throw new Exception("Não foi possivel autenticar..");
            }
        }

    }

    public static void inserirUsuario(Usuario u) {

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum", "postgres",
                "postgres")) {

            String sql = "INSERT INTO usuario(login, nome, email, senha) VALUES (?, ?, ?, ?)";
            PreparedStatement stm = c.prepareStatement(sql);

            stm.setString(1, u.getLogin());
            stm.setString(2, u.getNome());
            stm.setString(3, u.getEmail());
            stm.setString(4, u.getSenha());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel executar o acesso", e);
        }

    }

}
