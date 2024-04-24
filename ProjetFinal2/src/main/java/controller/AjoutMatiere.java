package controller;

import dao.MatiereDAO;
import model.Matiere;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AjoutMatiere")
public class AjoutMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/AjoutMatiere.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        Matiere matiere = new Matiere(nom);
        new MatiereDAO().ajouterMatiere(matiere);
        response.sendRedirect(request.getContextPath() + "/ListeMatiere");
    }
}