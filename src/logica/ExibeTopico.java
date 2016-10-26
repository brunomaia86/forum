package logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComentarioDAO;
import dao.TopicoDAO;
import modelo.Comentario;
import modelo.Topico;

public class ExibeTopico implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String login = (String) request.getSession().getAttribute("loginsessao");
		String titulo = request.getParameter("titulo");
		
		Topico topico = TopicoDAO.topicoPorUsuario(login, titulo);
		request.getSession().setAttribute("idtopico", topico.getId());
		
		List<Comentario> comentarios = ComentarioDAO.buscarTodosComentario();
		
		request.setAttribute("titulo", topico.getTitulo());
		request.setAttribute("login", topico.getLogin());
		request.setAttribute("conteudo", topico.getConteudo());
		request.setAttribute("comentarios", comentarios);
		
		
		return "exibe-topico.jsp";
	}
	
	

}
