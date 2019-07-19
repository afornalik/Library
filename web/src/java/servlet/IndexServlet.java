package servlet;

import dto.BookDto;
import model.Book;
import repository.BookRepository;
import service.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    private BookService bookService = BookService.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login.equals("xxx") && password.equals("yyy")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login",login);
        }else {
            HttpSession session =request.getSession();
            session.invalidate();
        }

        response.sendRedirect("/index");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index");
//        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<BookDto> bookDtos = bookService.getAllBooks();

      request.setAttribute("bookList",bookDtos);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
    }
}
