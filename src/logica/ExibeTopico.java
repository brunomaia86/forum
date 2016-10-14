package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import modelo.Topico;

public class ExibeTopico implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String login = (String) request.getSession().getAttribute("loginsessao");
		String titulo = request.getParameter("titulo");
		
		Topico topico = TopicoDAO.topicoPorUsuario(login, titulo);
		request.getSession().setAttribute("idtopico", topico.getId());
		
		request.setAttribute("titulo", topico.getTitulo());
		request.setAttribute("login", topico.getLogin());
		request.setAttribute("conteudo", topico.getConteudo());
		
		
		return "exibe-topico.jsp";
	}
	
	

}
