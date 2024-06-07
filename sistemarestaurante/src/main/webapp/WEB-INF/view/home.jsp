<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bom Burguer</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            color: #ff5733;
            text-align: center;
        }

        .button-container {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .button {
            display: inline-block;
            width: 200px;
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #ff5733;
            color: #fff;
            text-align: center;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: box-shadow 0.3s ease;
        }

        .button:hover {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Bem vindo ao Bom Burguer!</h1>
        </div>
        <div class="button-container">
            <a class="button"
                href="http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodosproduto">Cardápio</a>
            <br><br>
            <a class="button"
                href="http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodos">Funcionários</a>
            <br><br>
            <a class="button"
                href="http://localhost:4528/sistemarestaurante/chamadaservlet?acao=mostratodospedido">Pedido</a>
            <br><br>
            <a class="button" href="http://localhost:4528/sistemarestaurante/chamadaservlet?acao=lucro">Lucro</a>
            <br><br>
        </div>
    </div>
</body>
</html>
