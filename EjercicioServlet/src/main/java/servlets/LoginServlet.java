package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    Usuario u1 = new Usuario("aleruijur","aleruijur");
    Usuario u2 = new Usuario("user","user");
    Usuario u3 = new Usuario("otrouser","otrouser");
    
    List<Usuario> registrados = new ArrayList<>(Arrays.asList(u1,u2,u3)) ;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Usuario u = new Usuario(username,password);
		
		if(registrados.contains(u)) {
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			
			request.getSession().setAttribute("user", u);
			
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}
	}

}
