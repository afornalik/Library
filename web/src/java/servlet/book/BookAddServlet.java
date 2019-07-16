package servlet.book;

import dto.BookDto;
import service.AuthorService;
import service.BookService;
import service.IAuthorService;
import service.IBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {

    private final IBookService bookService = BookService.getInstance();
    ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("książka dodana");

        String select = request.getParameter("addAction");

        if(select.equals("addbook")) {
            BookDto bookDto = new BookDto();
            bookDto.setBorrower("0");
            bookDto.setCategory(request.getParameter("category"));
            bookDto.setIsbn(request.getParameter("isbn"));
            bookDto.setPages(request.getParameter("pages"));
            bookDto.setSummary(request.getParameter("summary"));
            bookDto.setTitle(request.getParameter("title"));
            bookDto.setAuthor(request.getParameter("author"));
            bookService.saveBook(bookDto);
        }
        response.sendRedirect("/index");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
