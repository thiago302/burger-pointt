<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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

table {
	width: 90%;
	margin: 20px auto;
	border-collapse: collapse;
}

thead {
	background-color: #ff5733;
	color: white;
}

th, td {
	padding: 8px;
}

th {
	text-align: left;
	background-color: #ff5733;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	color: #337ab7;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

h1 {
	text-align: center;
	margin-top: 20px;
	color: #ff5733;
}
</style>
<meta charset="ISO-8859-1">
<title>Mostra Funcionarios</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>Mostra Todos os Funcionarios</h1>
		</div>
		<div class="button-container">
			<a class="button"
				href="http://localhost:4528/sistemarestaurante/chamadaservlet?acao=cadastro">Cadastrar
				Funcionario</a>
		</div>
		<div class="employee-container">
			<c:if test="${not empty funcionarios}">
				<table border="1" style="width: 90%">
					<thead>
						<tr style="color: white; background-color: black">
							<th>ID</th>
							<th>Nome</th>
							<th>Cargo</th>
							<th>Salario</th>
							<th colspan="2">Ação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="funcionario" items="${funcionarios}">
							<tr>
								<td>${funcionario.id}</td>
								<td>${funcionario.nome}</td>
								<td>${funcionario.cargo}</td>
								<td>${funcionario.salario}</td>
								<td><a
									href="chamadaservlet?acao=altera&id=${funcionario.id}">ALTERAR</a></td>
								<td><a
									href="chamadaservlet?acao=exclui&id=${funcionario.id}">EXCLUIR</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty funcionarios}">
				<h1>Nenhum Funcionario Cadastrado!!!</h1>
			</c:if>
		</div>
	</div>
</body>
</html>








