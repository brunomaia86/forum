package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Comentario;
import modelo.Topico;
import modelo.Usuario;

public class ComentarioDAO {
	
	public static void inserirComentario(Comentario comentario) {

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum", "postgres",
                "postgres")) {

            String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?)";
            PreparedStatement stm = c.prepareStatement(sql);

            stm.setString(1, comentario.getComentario());
            stm.setString(2, comentario.getLogin());
            stm.setInt(3, comentario.getIdTopico());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel executar o acesso", e);
        }

    }

}
