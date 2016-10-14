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

    public static List<Topico> topicosPorUsuario(String login) {
        List<Topico> topicos = new ArrayList<>();

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum", "postgres", "postgres")) {
            String sql = "select * from topico where login = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Topico t = new Topico();
                t.setId(rs.getInt("id_topico"));
                t.setTitulo(rs.getString("titulo"));
                t.setConteudo(rs.getString("conteudo"));
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
    
    public static Topico topicoPorUsuario(String login, String titulo) {
        Topico t = new Topico();

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum", "postgres", "postgres")) {

            String sql = "select * from topico where login = ? and titulo = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
            stm.setString(2, titulo);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                t.setId(rs.getInt("id_topico"));
                t.setTitulo(rs.getString("titulo"));
                t.setConteudo(rs.getString("conteudo"));
                t.setLogin(rs.getString("login"));
            }
            rs.close();
            stm.close();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel executar o acesso!!", e);
        }

        return t;

    }
    
    public static void inserirTopico(Topico t) {

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://atrativa.dlinkddns.com:5432/forum", "postgres",
                "postgres")) {

            String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?)";
            PreparedStatement stm = c.prepareStatement(sql);

            stm.setString(1, t.getTitulo());
            stm.setString(2, t.getConteudo());
            stm.setString(3, t.getLogin());

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel executar o acesso", e);
        }

    }
}
