package controllers;

import model.ContactDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AjouterContactServlet")
public class AjouterContactServlet extends HttpServlet {

    // Méthode doPost pour gérer la soumission du formulaire
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres envoyés par le formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        int age = Integer.parseInt(request.getParameter("age"));

        // Créer une instance de ContactModel
        ContactDAO contactModel = new ContactDAO();

        // Appeler la méthode ajouterContact pour ajouter le contact à la base de données
        boolean isAdded = contactModel.ajouterContact(nom, prenom, email, telephone, age);

        // Vérifier si l'ajout a réussi
        if (isAdded) {
            // Rediriger l'utilisateur vers une page de succès (par exemple, une page de liste des contacts)
            response.sendRedirect("afficherContact.jsp");  
            // Rediriger l'utilisateur vers une page d'erreur ou afficher un message d'erreur
            response.getWriter().write("Erreur lors de l'ajout du contact.");
        }
    }
}
