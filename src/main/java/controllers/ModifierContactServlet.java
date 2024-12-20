package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactModel;

@WebServlet("/ModifierContactServlet")
public class ModifierContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactModel model = new ContactModel();
        model.modifierContact(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("email"),
                request.getParameter("telephone"),
                Integer.parseInt(request.getParameter("age"))
        );
        response.sendRedirect("modifierContact.jsp");
    }
}
