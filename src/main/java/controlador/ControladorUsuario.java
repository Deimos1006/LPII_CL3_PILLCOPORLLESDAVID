package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassUsuariolmp;
import model.TblUsuariocl3;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }//fin del controlador

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblUsuariocl3 usuario = new TblUsuariocl3();
        ClassUsuariolmp crud = new ClassUsuariolmp();
        List<TblUsuariocl3> listadousuario = crud.ListadoUsuario();
        // recuperamos la accion y codigo
        String accion = request.getParameter("accion");
        // aplicamos una condicion
        if (accion != null) {
            switch (accion) {
                case "Modificar":
                    int codigo = Integer.parseInt(request.getParameter("cod"));
                    // asignar el codigo
                    usuario.setIdusuariocl3(codigo);
                    TblUsuariocl3 buscarcod = crud.BuscarUsuario(usuario);
                    // enviar los valores buscados por codigo de la BD al formulario Actualizar
                    request.setAttribute("codigo", buscarcod.getIdusuariocl3());
                    request.setAttribute("nombre", buscarcod.getUsuariocl3());
                    request.setAttribute("password", buscarcod.getPasswordcl3());
                    // redirecciono
                    request.getRequestDispatcher("/FormActualizarUsuario.jsp").forward(request, response);
                    // salimos
                    break;

                case "Eliminar":
                    int usuarioeliminar = Integer.parseInt(request.getParameter("cod"));
                    // asignamos el codigo a eliminar
                    usuario.setIdusuariocl3(usuarioeliminar);
                    // invocamos al metodo eliminar
                    crud.EliminarUsuario(usuario);
                    // refrescar el listado
                    List<TblUsuariocl3> listado = crud.ListadoUsuario();
                    request.setAttribute("listadousuarios", listado);
                    // redireccionar
                    request.getRequestDispatcher("/ListadoUsuario.jsp").forward(request, response);
                    // salimos
                    break;

                case "Listar":
                    List<TblUsuariocl3> listadousuarios = crud.ListadoUsuario();
                    // invocamos el listado de productos para la vista
                    request.setAttribute("listadousuarios", listadousuario);
                    // redirecionamos
                    request.getRequestDispatcher("/ListadoUsuario.jsp").forward(request, response);
                    // salimos
                    break;
            }// fin del switch
        }// fin del if
    }//Fin del metodo doGet


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // doGet(request, response);
        String codigo = request.getParameter("idusuariocl3");
        String usuariocl3 = request.getParameter("usuariocl3");
        String passwordcl3 = request.getParameter("passwordcl3");

        List<TblUsuariocl3> listadousuario = null;
        // instanciar las respectivas entidades
        TblUsuariocl3 usuario = new TblUsuariocl3();
        ClassUsuariolmp crud = new ClassUsuariolmp();
        // asignamos valores
        usuario.setUsuariocl3(usuariocl3);
        usuario.setPasswordcl3(passwordcl3);
        if (codigo != null) {
            // recupero el codigo a actualizar
            int cod = Integer.parseInt(codigo);
            // asigno el codigo a actualizar
            usuario.setIdusuariocl3(cod);
            // invoco al metodo actualizar
            crud.ActualizarUsuario(usuario);
            // actualizar listado clientes
            listadousuario = crud.ListadoUsuario();
        } else {
            // invocamos al metodo registrar
            crud.RegistrarUsuario(usuario);
            // actualizar listado clientes
            listadousuario = crud.ListadoUsuario();
        }// fin del else

        // invocamos el listado de productos para la vista
        request.setAttribute("listadousuarios", listadousuario);
        // redirecionamos
        request.getRequestDispatcher("/ListadoUsuario.jsp").forward(request, response);
    }//Fin del metodo doPost

}
