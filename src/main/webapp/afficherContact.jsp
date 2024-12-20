<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Contacts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h1 class="text-center mb-4">Liste des Contacts</h1>

        <!-- Vérification des données transmises -->
        <c:if test="${empty contacts}">
            <div class="alert alert-warning text-center" role="alert">
                Aucun contact disponible.
            </div>
        </c:if>

        <c:if test="${not empty contacts}">
            <!-- Tableau Bootstrap -->
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                        <th>Téléphone</th>
                        <th>Âge</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Boucle JSTL -->
                    <c:forEach var="contact" items="${contacts}">
                        <tr>
                            <td>${contact.id}</td>
                            <td>${contact.nom}</td>
                            <td>${contact.prenom}</td>
                            <td>${contact.email}</td>
                            <td>${contact.telephone}</td>
                            <td>${contact.age}</td>
                            <td>
                                <div class="d-flex gap-2">
                                    <!-- Bouton Supprimer -->
                                    <form action="supprimerContact" method="post">
                                        <input type="hidden" name="id" value="${contact.id}">
                                        <button type="submit" class="btn btn-danger btn-sm">Supprimer</button>
                                    </form>
                                    <!-- Bouton Modifier -->
                                    <form action="modifierContact" method="get">
                                        <input type="hidden" name="id" value="${contact.id}">
                                        <button type="submit" class="btn btn-warning btn-sm">Modifier</button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

    <!-- Scripts Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
