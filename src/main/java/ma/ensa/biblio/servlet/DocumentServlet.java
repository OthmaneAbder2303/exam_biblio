package ma.ensa.biblio.servlet;

import com.google.gson.Gson;
import ma.ensa.biblio.dao.DocumentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensa.biblio.model.Document;

import java.io.IOException;

@WebServlet("/documents")
public class DocumentServlet extends HttpServlet {
    private DocumentDAO documentDAO = new DocumentDAO();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Document doc = gson.fromJson(request.getReader(), Document.class);
        documentDAO.addDocument(doc);

        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(doc));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(documentDAO.getAllDocuments()));
    }
}
