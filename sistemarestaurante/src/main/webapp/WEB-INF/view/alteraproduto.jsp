<%@page import="modelo.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera��o Dados Produto</title>
</head>
<body>

	<h1>Altera��o Dados Produto</h1>
	
	<form action="chamadaservlet" method="post">
		Id: <input type="text" name="txtid" value="${produto.id }" readonly><br><br>
		Nome: <input type="text" name="txtnome" value="${produto.nome }" ><br><br>
		Descri��o: <input type="text" name="txtdescricao" value="${produto.descricao }" ><br><br>
		Pre�o: <input type="text" name="txtpreco" value="${produto.preco }" ><br><br>
		<input type="hidden" name="acao" value="alteraproduto">
		<input type="submit" value="Alterar">
	</form>
	
	
	

</body>
</html>