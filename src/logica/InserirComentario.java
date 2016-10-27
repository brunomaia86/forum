package logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComentarioDAO;
import modelo.Comentario;

public class InserirComentario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Comentario comentario = new Comentario();

		comentario.setComentario(request.getParameter("comentario"));
		comentario.setLogin((String) request.getSession().getAttribute("loginsessao"));
		comentario.setIdTopico((int) request.getSession().getAttribute("idtopico"));

		ComentarioDAO.inserirComentario(comentario);
		
		List<Comentario> comentarios = ComentarioDAO.buscarTodosComentario();
		request.setAttribute("comentarios", comentarios);
		
		return "exibe-topico.jsp";
		
	}

}
