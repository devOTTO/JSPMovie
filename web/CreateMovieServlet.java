​package web;

import domain.Movie;
import domain.MovieService;
import domain.User;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Status;

public class CreateMovieServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher view = null;
        Status status = new Status();
        request.setAttribute("status", status);

        String movName = request.getParameter("title");
        Date movDate = java.sql.Date.valueOf(request.getParameter("date"));
        int movRate = Integer.parseInt(request.getParameter("rating"));
        int dirId = request.getParameter("dirId");

        Movie movie = new Movie(movName, movDate, movRate, dirId);
       
        try {

            MovieService movieservice = new MovieService();
            int ID = movieservice.Insert(movie);

            if (!status.isSuccessful()) {
                view = request.getRequestDispatcher("NewMovie.jsp");
                view.forward(request, response);
                return;
            }

            movie = new Movie(movName, movDate, movRate, dirId);
            request.setAttribute("movie", movie);

            view = request.getRequestDispatcher("MovieList.jsp");
            view.forward(request, response);

        } catch (Exception e) {
            status.addException(e);
            view = request.getRequestDispatcher("NewMovie.jsp");
            view.forward(request, response);
        }
    }
}