package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entidades.Servicio;
import Entidades.Tienda;
import Modelo.ServicioDAO;
import Modelo.TiendaDAO;


@WebServlet("/ServicioServlet/*")
public class ServicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServicioDAO sDAO;
    private TiendaDAO tDAO;
 
    public ServicioServlet() {
        super();
        sDAO = new ServicioDAO();
        tDAO = new TiendaDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	//metodos
		protected void registrar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
		    Integer tiendaBean = Integer.parseInt(request.getParameter("tiendaBean"));
			Servicio s = new Servicio();
			Tienda t = tDAO.find(tiendaBean);
			s.setNombre(nombre);
			s.setDescripcion(descripcion);;
			s.setTiendaBean(t);
			sDAO.insert(s);
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}

		protected void buscar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id"));
			Servicio s = new Servicio();
			s.setId(id);
			Servicio aux = sDAO.find(s.getId());
			System.out.println(aux.getId());
			request.getSession().setAttribute("servicio", aux);
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado");
		}

		protected void eliminar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Servicio s = new Servicio();
			Servicio aux = sDAO.find(id);
			s.setId(id);
			sDAO.delete(aux);
			request.getRequestDispatcher("servicios.jsp").forward(request, response);
		}

		protected void actualizar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			Integer tiendaBean = Integer.parseInt(request.getParameter("tiendaBean"));
			Servicio s = new Servicio();
			Tienda t = tDAO.find(tiendaBean);
			s.setId(id);
			s.setNombre(nombre);
			s.setDescripcion(descripcion);;
			s.setTiendaBean(t);
			sDAO.update(s);
			request.getRequestDispatcher("servicios.jsp").forward(request, response);
		}

		protected void showForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			Integer id = Integer.parseInt(request.getParameter("id"));
			Servicio s = new Servicio();
			s.setId(id);
			Servicio aux = sDAO.find(s.getId());
			System.out.println(aux.getId());
			request.getSession().setAttribute("servicio", aux);
			request.getRequestDispatcher("registro.jsp").forward(request, response);
			// response.sendRedirect("registroEmpleado.jsp");
		}
		
}
