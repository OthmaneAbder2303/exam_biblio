package ma.ensa.biblio.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensa.biblio.dao.UserDAO;
import ma.ensa.biblio.model.User;

import java.io.IOException;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = gson.fromJson(request.getReader(), User.class);
        userDAO.addUser(user);

        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(user));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(userDAO.getAllUsers()));
    }
}
