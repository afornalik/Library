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

@WebServlet( "/ShowServlet")
public class ShowServlet extends HttpServlet {
    private final IBookService  bookService = BookService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String status = request.getParameter("borrow");
        String bookId = request.getParameter("book");

        BookDto bookDto = bookService.getBook(Long.parseLong(bookId));

        System.out.println(bookDto.toString());

        if(status.equals("Borrow")) {
            bookDto.setBorrower("1");
            bookDto.setAuthor("1");
            bookService.updateBook(bookDto);
        }else {
            bookDto.setBorrower("0");
            bookDto.setAuthor("1");

            bookService.updateBook(bookDto);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SelectServlet");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show.jsp");
        requestDispatcher.forward(request,response);
    }
}
