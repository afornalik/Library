package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selected = request.getParameter("action");
        System.out.println(selected);
        RequestDispatcher requestDispatcher;

        switch (selected) {
            case "Add" : {
                requestDispatcher = request.getRequestDispatcher("AddServlet");
                requestDispatcher.forward(request,response);
                break;
            }
            case "Edit" : {
                requestDispatcher = request.getRequestDispatcher("EditServlet");
                break;
            }

            case "Show" : {
                requestDispatcher = request.getRequestDispatcher("ShowServlet");
                break;
            }

            case "Delete" : {
                requestDispatcher = request.getRequestDispatcher("servlet/control/DeleteServlet.java");
                break;
            }
            default: {
               // requestDispatcher = request.getRequestDispatcher("BooksServlet");
            }


        }
    }
}
