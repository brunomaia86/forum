package logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import modelo.Topico;

public class ListarTopicosPorUsuario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String loginUsuario = (String) request.getAttribute("login");

		List<Topico> topicos = TopicoDAO.topicosPorUsuario((String) request.getAttribute("login"));

		
		//request.setAttribute("login", loginUsuario);
		request.setAttribute("topicos", topicos);

		return "topicos.jsp";
	}

}
