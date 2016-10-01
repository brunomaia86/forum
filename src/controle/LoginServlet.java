
package controle;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicoDAO;
import dao.UsuarioDAO;
import modelo.Topico;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        //List<Topico> topicos = TopicoDAO.todosUsuarios();
        
        
    
        try {
            String nomeUsuario = UsuarioDAO.autenticar(login, senha);
            request.setAttribute("nome", nomeUsuario);
            
            //List<Topico> topicos = TopicoDAO.todosUsuarios();
            //request.setAttribute("topicos", topicos);
            
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
             
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        }
    }

}
