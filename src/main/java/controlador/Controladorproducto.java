package controlador;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Classproductoimp;

import model.TblProductocl3;

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
		TblProductocl3 producto=new TblProductocl3();
		Classproductoimp crud=new Classproductoimp();
		List<TblProductocl3> listadoproducto=crud.ListadoProducto();
		//invocamos el listado  de productos para la vista
		request.setAttribute("listaditos",listadoproducto);
		//redireccionamos
		//request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
		//
		String accion=request.getParameter("accion");
		//aplica
		if(accion !=null){
			switch (accion) {
			case "Modificar":
				int codigo=Integer.parseInt(request.getParameter("cod"));
				producto.setIdproductocl3(codigo);
				TblProductocl3 buscarcod=crud.BuscarProducto(producto);
				request.setAttribute("codigo", buscarcod.getIdproductocl3());
				request.setAttribute("nombre", buscarcod.getNombrecl3());
				request.setAttribute("precioventa", buscarcod.getPrecioventacl3());
				request.setAttribute("preciocomp", buscarcod.getPreciocompcl3());
				request.setAttribute("estado", buscarcod.getEstadocl3());
				request.setAttribute("descripcion", buscarcod.getDescripcl3());
				request.getRequestDispatcher("/FormActualizarProductocl3.jsp").forward(request, response);
				
				break;
			case "Eliminar":
				int codeliminar = Integer.parseInt(request.getParameter("cod"));
				producto.setIdproductocl3(codeliminar);
				crud.EliminarProducto(producto);
				List<TblProductocl3> listado= crud.ListadoProducto();
				request.setAttribute("listaditos", listado);
				request.getRequestDispatcher("/ListadoProducto.jsp");

			
				break;
			}
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("codigo");
		String nombre=request.getParameter("nombre");
		String prev=request.getParameter("precioventa");
		String prec=request.getParameter("preciocomp");
		String est=request.getParameter("estado");
		String desc=request.getParameter("descripcion");
		
		List<TblProductocl3> listadoproducto=null;
		
		TblProductocl3 producto=new TblProductocl3();
		Classproductoimp crud=new Classproductoimp();
		
		producto.setNombrecl3(nombre);
		producto.setPrecioventacl3(prev);
		producto.setPreciocompcl3(prec);
		producto.setEstadocl3(est);
		producto.setDescripcl3(desc);
		
		if(codigo !=null){
			int cod=Integer.parseInt(codigo);
			producto.setIdproductocl3(cod);
			crud.ActualizarProducto(producto);
			listadoproducto=crud.ListadoProducto();
		}else
		{
			crud.RegistrarProducto(producto);
			listadoproducto=crud.ListadoProducto();
		}
		
		
		//invocamos el listado  de productos para la vista
		request.setAttribute("listaditos",listadoproducto);
		
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
		
		
	}

}
