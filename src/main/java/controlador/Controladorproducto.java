package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Classproductoimp;

import model.TblProductocl2;

/**
 * Servlet implementation class Controladorproducto
 */
public class Controladorproducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controladorproducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblProductocl2 producto=new TblProductocl2();
		Classproductoimp crud=new Classproductoimp();
		List<TblProductocl2> listadoproducto=crud.ListadoProducto();
		//invocamos el listado  de productos para la vista
		request.setAttribute("listaditos",listadoproducto);
		//redireccionamos
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String prev=request.getParameter("precioventa");
		String prec=request.getParameter("preciocomp");
		String est=request.getParameter("estado");
		String desc=request.getParameter("descripcion");
		
		TblProductocl2 producto=new TblProductocl2();
		Classproductoimp crud=new Classproductoimp();
		
		producto.setNombrecl2(nombre);
		producto.setPrecioventacl2(prev);
		producto.setPreciocompcl2(prec);
		producto.setEstadocl2(est);
		producto.setDescripcl2(desc);
		
		crud.RegistrarProducto(producto);
		
		
		List<TblProductocl2> listadoproducto=crud.ListadoProducto();
		//invocamos el listado  de productos para la vista
		request.setAttribute("listaditos",listadoproducto);
		
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
		
		
	}

}
