package logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import modelo.Topico;
import modelo.Usuario;

public class ListarTopicosPorUsuario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String loginUsuario = (String) request.getSession().getAttribute("loginsessao");
		
		List<Topico> topicos = TopicoDAO.topicosPorUsuario(loginUsuario);
		
		request.setAttribute("topicos", topicos);
		
		
		return "topicos.jsp";
	}

}
