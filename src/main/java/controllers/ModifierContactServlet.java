package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactDAO;

@WebServlet("/ModifierContactServlet")
public class ModifierContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idStr = request.getParameter("id");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String ageStr = request.getParameter("age");

            // Vérification de l'ID et de l'âge
            if (idStr == null || idStr.isEmpty() || nom == null || nom.isEmpty() ||
                prenom == null || prenom.isEmpty() || email == null || email.isEmpty() ||
                telephone == null || telephone.isEmpty() || ageStr == null || ageStr.isEmpty()) {
                // En cas de données manquantes
                request.setAttribute("error", "Tous les champs doivent être remplis.");
                request.getRequestDispatcher("/modifierContact.jsp").forward(request, response);
                return;
            }

            int id = Integer.parseInt(idStr);
            int age = Integer.parseInt(ageStr);

            ContactDAO model = new ContactDAO();
            boolean isUpdated = model.modifierContact(id, nom, prenom, email, telephone, age);

            if (isUpdated) {
                response.sendRedirect("afficherContact.jsp"); // Rediriger vers la liste des contacts
            } else {
                request.setAttribute("error", "Erreur lors de la modification du contact.");
                request.getRequestDispatcher("/modifierContact.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "L'ID ou l'âge doit être un nombre valide.");
            request.getRequestDispatcher("/modifierContact.jsp").forward(request, response);
        }
    }
}
