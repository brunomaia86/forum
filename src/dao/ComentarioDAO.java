package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Comentario> buscarTodosComentarios(int idTopico) {
		List<Comentario> comentarios = new ArrayList<>();

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum", "postgres", "postgres")) {
            String sql = "select * from comentario where id_topico = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, idTopico);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setId(rs.getInt("id_comentario"));
                comentario.setComentario(rs.getString("comentario"));
                comentario.setLogin(rs.getString("login"));
                comentario.setIdTopico(rs.getInt("id_topico"));
                comentarios.add(comentario);
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel executar o acesso!!", e);
        }

        return comentarios;
	}

}
