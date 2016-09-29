package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Topico;

public class TopicoDAO {

    public static List<Topico> todosUsuarios() {
        List<Topico> todos = new ArrayList<>();

        try (Connection c = DriverManager.getConnection("jdbc:atrativa.dlinkddns.com://localhost:5432/forum", "postgres", "postgres")) {

            String sql = "select * from topico";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Topico t = new Topico();
                t.setTitulo(rs.getString("titulo"));
                t.setConteudo(rs.getString("comentario"));
                todos.add(t);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel executar o acesso!!", e);
        }

        return todos;

    }
}
