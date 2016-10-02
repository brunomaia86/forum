package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Topico;
import modelo.Usuario;

public class TopicoDAO {

    public static List<Topico> topicosPorUsuario(Usuario usuario) {
        List<Topico> topicos = new ArrayList<>();

        try (Connection c = DriverManager.getConnection("jdbc:atrativa.dlinkddns.com://localhost:5432/forum", "postgres", "postgres")) {

            String sql = "select * from topico where login = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, usuario.getLogin());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Topico t = new Topico();
                t.setId(rs.getInt("id"));
                t.setTitulo(rs.getString("titulo"));
                t.setConteudo(rs.getString("comentario"));
                t.setLogin(rs.getString("login"));
                topicos.add(t);
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel executar o acesso!!", e);
        }

        return topicos;

    }
}
