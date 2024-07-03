package controlador;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductolmp;
import model.TblProductocl3;




/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }//fin del controlador 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblProductocl3 producto = new TblProductocl3();
		ClassProductolmp crud = new ClassProductolmp();
		List<TblProductocl3>listadoproducto=crud.ListadoProducto();
		//invocamos el listado de productos para la vista
		request.setAttribute("listadoProductos",listadoproducto);
		//redireccionamos
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request,response);
	}// fin del metodo do get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombrecl3 =request.getParameter("nombrecl3");
		String estadocl3=request.getParameter("estadocl3");
		String descripcl3=request.getParameter("descripcl3");
		// Inicializar precios
        double precioventacl3 = 0.0;
        double preciocompcl3 = 0.0;

        try {
            // Obtener y convertir los precios a double
            String precioVentaStr = request.getParameter("precioventacl3");
            String precioCompraStr = request.getParameter("preciocompcl3");

            System.out.println("precioVentaStr: " + precioVentaStr); // Depuración
            System.out.println("precioCompraStr: " + precioCompraStr); // Depuración

            // Verificar y convertir los valores de los precios
            if (precioVentaStr != null && !precioVentaStr.isEmpty()) {
            	precioventacl3 = Double.parseDouble(precioVentaStr);
            }

            if (precioCompraStr != null && !precioCompraStr.isEmpty()) {
            	preciocompcl3 = Double.parseDouble(precioCompraStr);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Imprimir el stack trace para depuración
            request.setAttribute("error", "Los valores de los precios no son válidos: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
		
		
		//instanciar las respectivas entidades
		TblProductocl3 producto =new TblProductocl3();
		ClassProductolmp crud=new ClassProductolmp();
		//asignamos valores
		producto.setNombrecl3(nombrecl3);
		producto.setPrecioventacl3(precioventacl3);
		producto.setPreciocompcl3(preciocompcl3);
		producto.setEstadocl3(estadocl3);
		producto.setDescripcl3(descripcl3);
		//invocamos al metodo registrar
		crud.RegistrarProducto(producto);		
		//redirecionamos
		List<TblProductocl3>listadoproducto=crud.ListadoProducto();
		//invocamos el listado de productos para la vista
		request.setAttribute("listadoProductos",listadoproducto);
		//redireccionamos
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request,response);
	}//fin del metodo do post

}
