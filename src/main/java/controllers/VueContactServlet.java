package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactModel;

@WebServlet("/VueContactServlet")
public class VueContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactModel model = new ContactModel();
        request.setAttribute("contacts", ContactModel.afficherContact());
        request.getRequestDispatcher("afficherContact.jsp").forward(request, response);
    }
}
