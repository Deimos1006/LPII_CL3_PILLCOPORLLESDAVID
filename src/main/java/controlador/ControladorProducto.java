package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import Dao.ClassProductolmp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ControladorProducto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
    	TblProductocl3 producto = new TblProductocl3();
        ClassProductolmp crud = new ClassProductolmp();
        String accion = request.getParameter("accion");
        
        if (accion != null) {
            switch (accion) {
                case "Modificar":
                    int codigo = Integer.parseInt(request.getParameter("cod"));
                    producto.setIdproductoscl3(codigo);
                    TblProductocl3 buscarcod = crud.BuscarProducto(producto);
                    request.setAttribute("codigo", buscarcod.getIdproductoscl3());
                    request.setAttribute("nombrecl3", buscarcod.getNombrecl3());
                    request.setAttribute("precioventacl3", buscarcod.getPrecioventacl3());
                    request.setAttribute("preciocompcl3", buscarcod.getPreciocompcl3());
                    request.setAttribute("estadocl3", buscarcod.getEstadocl3());
                    request.setAttribute("descripcl3", buscarcod.getDescripcl3());
                    request.getRequestDispatcher("/FormActualizarProducto.jsp").forward(request, response);
                    break;
                case "Eliminar":
                    int productoliminar = Integer.parseInt(request.getParameter("cod"));
                    producto.setIdproductoscl3(productoliminar);
                    crud.EliminarProducto(producto);
                    List<TblProductocl3> listado = crud.ListadoProducto();
                    request.setAttribute("listadoproductos", listado);
                    request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
                    break;
                case "Listar":
                    List<TblProductocl3> listadoproductos = crud.ListadoProducto();
                    request.setAttribute("listadoproductos", listadoproductos);
                    request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        String codigo = request.getParameter("idproductocl3");
        String nombre = request.getParameter("nombrecl3");
        String precioventa = request.getParameter("precioventacl3");
        String preciocompra = request.getParameter("preciocompcl3");
        String estado = request.getParameter("estadocl3");
        String descripcion = request.getParameter("descripcl3");
        
        TblProductocl3 producto = new TblProductocl3();
        ClassProductolmp crud = new ClassProductolmp();
        
        producto.setNombrecl3(nombre);
        producto.setPrecioventacl3(Double.parseDouble(precioventa));
        producto.setPreciocompcl3(Double.parseDouble(preciocompra));
        producto.setEstadocl3(estado);
        producto.setDescripcl3(descripcion);
        
        if (codigo != null && !codigo.isEmpty()) {
            int cod = Integer.parseInt(codigo);
            producto.setIdproductoscl3(cod);
            crud.ActualizarProducto(producto);
        } else {
            crud.RegistrarProducto(producto);
        }
        
        List<TblProductocl3> listadoproducto = crud.ListadoProducto();
        request.setAttribute("listadoproductos", listadoproducto);
        request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
    }
}
