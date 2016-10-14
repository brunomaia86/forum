package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComentarioDAO;
import modelo.Comentario;

@WebServlet("/InserirComentarioServlet")
public class InserirComentarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InserirComentarioServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Comentario comentario = new Comentario();

		comentario.setComentario(request.getParameter("comentario"));
		comentario.setLogin((String) request.getSession().getAttribute("loginsessao"));
		comentario.setIdTopico((int) request.getSession().getAttribute("idtopico"));

		ComentarioDAO.inserirComentario(comentario);

		request.getRequestDispatcher("exibe-topico.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
