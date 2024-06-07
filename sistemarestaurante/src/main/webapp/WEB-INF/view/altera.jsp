<%@page import="modelo.Funcionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração Dados Funcionario</title>
</head>
<body>

	<h1>Alteração Dados Funcionario</h1>
	
	<form action="chamadaservlet" method="post">
		Id: <input type="text" name="txtid" value="${funcionario.id }" readonly><br><br>
		Nome: <input type="text" name="txtnome" value="${funcionario.nome }" ><br><br>
		Cargo: <input type="text" name="txtcargo" value="${funcionario.cargo }" ><br><br>
		Salario: <input type="text" name="txtsalario" value="${funcionario.salario }" ><br><br>
		<input type="hidden" name="acao" value="altera">
		<input type="submit" value="Alterar">
	</form>
	
	
	

</body>
</html>






