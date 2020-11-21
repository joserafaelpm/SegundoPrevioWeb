package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Tienda;
import Modelo.TiendaDAO;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/TiendaServlet/*")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TiendaDAO tDAO;

	public TiendaServlet() {
		super();
		tDAO = new TiendaDAO();
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

	// metodos

	protected void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String clave= request.getParameter("clave") ;
		String descripcion = request.getParameter("descripcion");
		String email = request.getParameter("email");
		String facebook = request.getParameter("facebook");
		String imagen = request.getParameter("imagen");
		String lema = request.getParameter("lema");
		String nombre = request.getParameter("nombre");
		String propietario = request.getParameter("propietario");
		String web = request.getParameter("web");
		Tienda t = new Tienda();
		t.setClave(clave);
		t.setDescripcion(descripcion);
		t.setEmail(email);
		t.setFacebook(facebook);
		t.setImagen(imagen);
		t.setLema(lema);
		t.setNombre(nombre);
		t.setPropietario(propietario);
		t.setWeb(web);
		tDAO.insert(t);
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

	protected void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tienda t = new Tienda();
		t.setId(id);
		Tienda aux = tDAO.find(t.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("tienda", aux);
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado");
	}

	protected void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tienda t = new Tienda();
		Tienda aux = tDAO.find(id);
		t.setId(id);
		tDAO.delete(aux);
		request.getRequestDispatcher("servicios.jsp").forward(request, response);
	}

	protected void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String clave= request.getParameter("clave") ;
		String descripcion = request.getParameter("descripcion");
		String email = request.getParameter("email");
		String facebook = request.getParameter("facebook");
		String imagen = request.getParameter("imagen");
		String lema = request.getParameter("lema");
		String nombre = request.getParameter("nombre");
		String propietario = request.getParameter("propietario");
		String web = request.getParameter("web");
		Tienda t = new Tienda();
		t.setId(id);
		t.setClave(clave);
		t.setDescripcion(descripcion);
		t.setEmail(email);
		t.setFacebook(facebook);
		t.setImagen(imagen);
		t.setLema(lema);
		t.setNombre(nombre);
		t.setPropietario(propietario);
		t.setWeb(web);
		tDAO.update(t);
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

	protected void showForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tienda t = new Tienda();
		t.setId(id);
		Tienda aux = tDAO.find(t.getId());
		System.out.println(aux.getId());
		request.getSession().setAttribute("tienda", aux);
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		// response.sendRedirect("registroEmpleado.jsp");
	}

}
