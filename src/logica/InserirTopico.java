package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import dao.UsuarioDAO;
import modelo.Topico;

public class InserirTopico implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Topico topico = new Topico();
		
		
		topico.setTitulo(request.getParameter("titulo"));
		topico.setConteudo(request.getParameter("conteudo"));
		topico.setLogin((String) request.getSession().getAttribute("loginsessao"));

		TopicoDAO.inserirTopico(topico);
		
		UsuarioDAO.adicionarPontos(topico.getLogin(), 10);
		
		System.out.println("Topico Inserido");
		
		return "topicos.jsp";
	}

}
