package controller;
import java.io.IOException;
import dao.CompteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ControlleurConnecteur")
public class ControlleurConnecteur extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        if (CompteDAO.existe(login, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", login);
            request.getRequestDispatcher("/WEB-INF/VueListe.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Identifiants invalides");
            request.getRequestDispatcher("/WEB-INF/VueConnecteur.jsp").forward(request, response);
        }
    }
}