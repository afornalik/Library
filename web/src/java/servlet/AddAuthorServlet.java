package servlet;

import dto.AuthorDto;
import repository.AuthorRepository;
import repository.IAuthorRepository;
import service.AuthorService;
import service.IAuthorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addAuthor")
public class AddAuthorServlet extends HttpServlet {

    private IAuthorService authorService;
    private IAuthorRepository authorRepository = AuthorRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AuthorDto authorDto = new AuthorDto();

        authorDto.setFirstName(request.getParameter("firstName"));
        authorDto.setLastName(request.getParameter("lastName"));

        authorService.saveAuthor(authorDto);

        response.sendRedirect("/addAuthor");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        authorService = AuthorService.getInstance(authorRepository);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addAuthorForm.jsp");
        requestDispatcher.forward(request,response);
    }
}
