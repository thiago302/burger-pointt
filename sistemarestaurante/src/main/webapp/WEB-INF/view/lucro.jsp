<%@page import="modelo.Restaurante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Lucro</title>
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
</head>

<body>
	<div class="container">
		<div class="header">
			<h1>Lucro Restaurante</h1>
		</div>
		<div class="employee-container">
			<table border="1" style="width: 90%">
				<thead>
					<tr style="color: white; background-color: black">
						<th>Quantidade de Funcionarios</th>
						<th>Despesas</th>
						<th>Lucro Liquido</th>
						<th>Lucro Bruto</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="restaurante" items="${restaurante}">
						<tr>
							<td>${restaurante.quantidadeFuncionario}</td>
							<td>${restaurante.dispesas}</td>
							<td>${restaurante.lucroLiquido}</td>
							<td>${restaurante.lucroBruto}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>