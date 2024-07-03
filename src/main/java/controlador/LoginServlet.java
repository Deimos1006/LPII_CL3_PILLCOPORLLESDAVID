package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.ClassUsuariolmp;
import model.TblUsuariocl3;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hola desde LoginServlet!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrase�a = request.getParameter("contrase�a");

        ClassUsuariolmp crud = new ClassUsuariolmp();
        TblUsuariocl3 usu = crud.ValidarUsuario(usuario, contrase�a);

        if (usu != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usu);
            response.sendRedirect("FormRegistrarProducto.jsp"); // Aseg�rate de que esta URL sea correcta
        } else {
            request.setAttribute("errorMessage", "Usuario o contrase�a incorrectos");
            request.getRequestDispatcher("Login.jsp").forward(request, response); // Aseg�rate de que esta URL sea correcta
        }
    }
}
