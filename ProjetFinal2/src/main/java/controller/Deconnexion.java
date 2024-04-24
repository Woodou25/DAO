package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Deconnexion")
public class Deconnexion extends HttpServlet {
    private static final long serialVersionUID = 5735462025692535740L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate(); // Termine la session
        response.sendRedirect(request.getContextPath() + "/Accueil"); // Redirection vers la page d'accueil
    }
}
