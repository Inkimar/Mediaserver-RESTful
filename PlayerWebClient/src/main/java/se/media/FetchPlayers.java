/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.media;

import com.playerentity.Player;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.mediaserver.tutorial.util.URI;

/**
 *
 * @author ingimar
 */
@WebServlet(name = "FetchPlayers", urlPatterns = {"/FetchPlayers"})
public class FetchPlayers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Player> players = getAllPlayers();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FetchPlayers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ABC Servlet FetchPlayers at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            int count = 0;
            for (Player player : players) {
                out.println("<h1>Player " + player.getFirstname() + "</h1>");
            }
        } finally {
            out.close();
        }
    }
    
    //private WebResource webResource;

    private List<Player> getAllPlayers() {
        ClientResponse response = findAll_XML(com.sun.jersey.api.client.ClientResponse.class);

        GenericType<List<Player>> genericType = new GenericType<List<Player>>() {
        };

        List<Player> players = new ArrayList<>();
        players = (response.getEntity(genericType));

        return players;
    }

    private <T> T findAll_XML(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = URI.getWebResource();
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
