package controle;

import dao.TopicoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Topico;


@WebServlet(name = "TopicoServlet", urlPatterns = {"/TopicoServlet"})
public class TopicoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Topico> topicos = TopicoDAO.todosTopicos();

        String paravraTeste = "teste";

        System.out.println(paravraTeste);

        request.setAttribute("teste", paravraTeste);
        

        request.setAttribute("topicos", topicos);
        request.getRequestDispatcher("topicos.jsp").forward(request, response);

    }

}
