  package controllers;
  
  import java.io.IOException;
  
  import javax.servlet.ServletException; import
  javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse;
  
  import model.ContactDAO;
  
  @WebServlet("/AfficherContactServlet") 
  public class AfficherContactServlet extends
  HttpServlet { protected void doGet(HttpServletRequest request,
  HttpServletResponse response) throws ServletException, IOException {
	 
  ContactDAO model = new ContactDAO(); request.setAttribute("contacts",
  ContactDAO.afficherContact());
  request.getRequestDispatcher("afficherContact.jsp").forward(request,
  response); } }