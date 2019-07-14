package servlet;

import dto.AuthorDto;
import model.Author;
import repository.AuthorRepository;
import repository.IAuthorRepository;
import service.AuthorService;
import service.BookService;
import service.IAuthorService;
import service.IBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

    private BookService bookService;
    private AuthorService authorService;
    private AuthorRepository authorRepository = AuthorRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
