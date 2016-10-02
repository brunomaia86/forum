package logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import dao.UsuarioDAO;
import modelo.Topico;
import modelo.Usuario;

public class Topicos implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String nomeUsuario = (String) request.getAttribute("nome");
		Usuario usuario = UsuarioDAO.recuperar(nomeUsuario);
		
		List<Topico> topicos = TopicoDAO.topicosPorUsuario(usuario);
		
		request.setAttribute("topicos", topicos);
		
		
		return "topicos.jsp";
	}

}
