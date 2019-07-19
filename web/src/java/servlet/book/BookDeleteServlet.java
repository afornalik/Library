package servlet.book;

import service.BookService;
import service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {

    private final IBookService bookService = BookService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selection = request.getParameter("addAction");



        if (selection.equals("delete")) {
            bookService.deleteBook(Long.parseLong(request.getParameter("bookId")));
        }

        response.sendRedirect("/index");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
