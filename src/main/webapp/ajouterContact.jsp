<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Contact</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input, button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Ajouter un Contact</h2>
    <form action="AjouterContactServlet" method="post">
        <label for="nom">Nom :</label> 
        <input type="text" name="nom" id="nom" placeholder="Entrez votre nom" required><br>

        <label for="prenom">Prénom :</label> 
        <input type="text" name="prenom" id="prenom" placeholder="Entrez votre prénom" required><br>

        <label for="email">Email :</label> 
        <input type="email" name="email" id="email" placeholder="Entrez votre email" required><br>

        <label for="telephone">Téléphone :</label> 
        <input type="text" name="telephone" id="telephone" placeholder="Entrez votre téléphone" required><br>

        <label for="age">Âge :</label> 
        <input type="number" name="age" id="age" placeholder="Entrez votre âge" required><br>

        <button type="submit">Ajouter</button>
    </form>

    <br>
    <a href="index.jsp">Retour à la page principale</a>

    <script>
        document.querySelector("form").addEventListener("submit", function(event) {
            const email = document.querySelector("input[name=email]").value;
            const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!regex.test(email)) {
                alert("L'email n'est pas valide.");
                event.preventDefault();  // Empêche l'envoi du formulaire
            }
        });
    </script>
</body>
</html>