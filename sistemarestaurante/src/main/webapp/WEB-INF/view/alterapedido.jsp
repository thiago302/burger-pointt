<%@page import="modelo.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera��o Dados Pedido</title>
</head>
<body>

    <h1>Altera��o Dados Pedido</h1>
    
    <form action="chamadaservlet" method="post">
        IdPedido: <input type="text" name="txtidPedido" value="${pedido.idPedido }" readonly><br><br>
        IdProduto: <input type="text" name="txtidProduto" value="${pedido.idProduto }" ><br><br>
        Quantidade: <input type="text" name="txtquantidade" value="${pedido.quantidade }" ><br><br>
        <input type="hidden" name="acao" value="alterapedido">
        <input type="submit" value="Alterar">
    </form>
    
</body>
</html>
