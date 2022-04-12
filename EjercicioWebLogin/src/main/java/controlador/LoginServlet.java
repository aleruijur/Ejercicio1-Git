package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.negocio.GestorUsuario;

@WebServlet("/usuarios/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GestorUsuario gestorUsuario;
	
    public LoginServlet() {
        super();
        gestorUsuario = new GestorUsuario();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		boolean estaRegistrado = gestorUsuario.estaRegistrado(nombre, password);
		
		String res = "{\"validado\": " + estaRegistrado + "}";
		
		PrintWriter out = response.getWriter();
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(res);
        out.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
