package servlet;

import service.BookService;
import service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {

    private final IBookService bookService = BookService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.encodeRedirectURL("/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selected = request.getParameter("action")+"Servlet";

        request.setAttribute(
                "selectedBook",bookService.getBook(
                        Long.parseLong(
                                request.getParameter("bookId"))));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(selected);
        requestDispatcher.forward(request,response);

    }
}
