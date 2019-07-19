package servlet.control;

import service.AuthorService;
import service.IAuthorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/AddServlet")
public class AddServlet extends HttpServlet {

    private final IAuthorService authorService = AuthorService.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("authors",authorService.getAllAuthors());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addbook.jsp");
        requestDispatcher.forward(request,response);
    }
}
