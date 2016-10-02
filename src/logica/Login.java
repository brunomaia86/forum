package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");


		try {
			String nomeUsuario = UsuarioDAO.autenticar(login, senha);
			request.getSession().setAttribute("nome", nomeUsuario);
			//request.setAttribute("nome", nomeUsuario);
			
			return "topicos.jsp";

		} catch (Exception ex) {
			request.setAttribute("erro", ex.getMessage());
			return "falha.jsp";
		}

	}

}
