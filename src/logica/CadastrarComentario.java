package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComentarioDAO;
import modelo.Comentario;

public class CadastrarComentario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Comentario comentario = new Comentario();
		Comentario comentario2 = new Comentario();

		comentario.setComentario(request.getParameter("comentario"));
		comentario.setLogin((String) request.getSession().getAttribute("loginsessao"));
		comentario.setIdTopico((int) request.getSession().getAttribute("idtopico"));

		comentario2.setComentario(request.getParameter("comentario"));
		comentario2.setLogin((String) request.getAttribute("loginsessao"));
		comentario2.setIdTopico((int) request.getAttribute("idtopico"));

		ComentarioDAO.inserirComentario(comentario);

		return "exibe-topico.jsp";
	}

}
