/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelo.Usuario;


@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();

        usuario.setLogin(request.getParameter("login"));
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));

        UsuarioDAO.inserirUsuario(usuario);

        request.getRequestDispatcher("index.html").forward(request, response);

    }

}
