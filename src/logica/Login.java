package logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelo.Usuario;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");


		try {
			String nomeUsuario = UsuarioDAO.autenticar(login, senha);
			request.setAttribute("nome", nomeUsuario);
			
			Usuario usuario = UsuarioDAO.recuperar(login);
			String loginSessao = usuario.getLogin();
			request.getSession().setAttribute("login", loginSessao);
			
			return "topicos.jsp";

		} catch (Exception ex) {
			request.setAttribute("erro", ex.getMessage());
			return "falha.jsp";
		}

	}

}
