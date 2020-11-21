package Controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Cliente;
import Modelo.ClienteDAO;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO cDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteServlet() {
		super();
		cDAO = new ClienteDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "eliminar":
			this.eliminar(request, response);
			break;
		case "mostrar":
			this.showForm(request, response);
			break;
		/*
		 * case "/buscar": this.buscar(request, response); break;
		 */
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "login":
			this.login(request, response);
		case "buscar":
			this.buscar(request, response);
			break;
		case "registrar":
			this.registrar(request, response);
			break;
		case "actualizar":
			this.actualizar(request, response);
			break;
		default:
			break;
		}
	}

//metodos

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("heroe");
		String clave = request.getParameter("fechaNacimiento");
		Cliente c = new Cliente();
		c.setNombre(nombre);
		c.setEmail(email);
		c.setClave(clave);
		cDAO.insert(c);
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cliente c = new Cliente();
		c.setId(id);
		Cliente aux = cDAO.find(c.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("cliente", aux);
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cliente c = new Cliente();
		Cliente aux = cDAO.find(id);
		c.setId(id);
		cDAO.delete(aux);
		request.getRequestDispatcher("servicios.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("heroe");
		String clave = request.getParameter("fechaNacimiento");
		Cliente c = new Cliente();
		c.setId(id);
		c.setNombre(nombre);
		c.setEmail(email);
		c.setClave(clave);
		cDAO.update(c);
		request.getRequestDispatcher("servicios.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cliente c = new Cliente();
		c.setId(id);
		Cliente aux = cDAO.find(c.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("cliente", aux);
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
