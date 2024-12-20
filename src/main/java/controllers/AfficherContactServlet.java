package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap; // Import LinkedHashMap
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContactModel;

@WebServlet("/AfficherContactServlet")
public class AfficherContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<String[]> rawContacts = ContactModel.afficherContact();
            List<Map<String, String>> contacts = new ArrayList<>();

            for (String[] contact : rawContacts) {
                Map<String, String> contactMap = new LinkedHashMap<>(); 
                contactMap.put("id", contact[0]);
                contactMap.put("nom", contact[1]);
                contactMap.put("prenom", contact[2]);
                contactMap.put("email", contact[3]);
                contactMap.put("telephone", contact[4]);
                contactMap.put("age", contact[5]);
                contacts.add(contactMap);
            }
            System.out.println("contacts " + contacts); 

            request.setAttribute("contacts", contacts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("afficherContact.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Erreur lors de la récupération des contacts : " + e.getMessage());
        }
    }
}