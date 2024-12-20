package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactModel;

@WebServlet("/SupprimerContactServlet")
public class SupprimerContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactModel model = new ContactModel();
        model.supprimerContact(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("afficherContact.jsp");
    }
}
