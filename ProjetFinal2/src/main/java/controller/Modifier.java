package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.CompteDAO;
import model.Compte;

@WebServlet("/Modifier")
public class Modifier extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Compte compte = CompteDAO.getById(id);
        if (compte != null) {
            request.setAttribute("compte", compte);
            request.getRequestDispatcher("/WEB-INF/Modifier.jsp").forward(request, response);
        } else {
            response.sendRedirect("VueListe");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            Compte compte = new Compte(id, login, password);
            CompteDAO.modifier(compte);
            response.sendRedirect(request.getContextPath() + "/VueListe");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Erreur lors de la modification du compte.");
            request.getRequestDispatcher("/WEB-INF/Modifier.jsp").forward(request, response);
        }
    }
}
