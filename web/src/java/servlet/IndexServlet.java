package servlet;

import repository.AuthorRepository;
import repository.IAuthorRepository;
import service.AuthorService;
import service.IAuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Index")
public class IndexServlet extends HttpServlet {

    private IAuthorService authorService;
    private IAuthorRepository authorRepository = AuthorRepository.getInstance();;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        authorService = AuthorService.getInstance(authorRepository);

        authorService.getAllAuthors()
                .stream()
                .map(x -> x.getId()+" "+x.getFirstName()+" "+x.getLastName())
                .forEach(System.out::println);
    }
}
