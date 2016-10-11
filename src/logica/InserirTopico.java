package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import modelo.Topico;

public class InserirTopico implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Topico topico = new Topico();
		
		
		topico.setTitulo(request.getParameter("titulo"));
		topico.setConteudo(request.getParameter("conteudo"));
		topico.setLogin((String) request.getSession().getAttribute("loginsessao"));

		TopicoDAO.inserirTopico(topico);
		
		System.out.println("Topico Inserido");
		
		return "topicos.jsp";
	}

}
