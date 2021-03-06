package servlet.control;

import dto.BookDto;
import service.BookService;
import service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    private final IBookService bookService = BookService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookDto bookDto = (BookDto) request.getAttribute("selectedBook");

        request.setAttribute("bookDescription",bookDto);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("deletebook.jsp");
        requestDispatcher.forward(request,response);

    }
}
