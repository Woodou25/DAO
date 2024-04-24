package controller;

import dao.MatiereDAO;
import model.Matiere;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListeMatiere")
public class ListeMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    MatiereDAO matiereDAO = new MatiereDAO();
	    List<Matiere> listeMatieres = matiereDAO.getAllMatieres();
	    request.setAttribute("listeMatieres", listeMatieres);
	    request.getRequestDispatcher("/WEB-INF/VueListeMatiere.jsp").forward(request, response);
	}

}
