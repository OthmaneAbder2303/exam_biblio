package ma.ensa.biblio.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensa.biblio.dao.BorrowDAO;
import ma.ensa.biblio.model.Borrow;

import java.io.IOException;

@WebServlet("/borrows")
public class BorrowServlet extends HttpServlet {
    private BorrowDAO borrowDAO = new BorrowDAO();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Borrow borrow = gson.fromJson(request.getReader(), Borrow.class);
        borrowDAO.borrowDocument(borrow);

        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(borrow));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(borrowDAO.getAllBorrows()));
    }
}

