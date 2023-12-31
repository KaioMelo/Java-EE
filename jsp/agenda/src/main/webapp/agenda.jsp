<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ page import="model.JavaBeans"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		@ SuppressWarnings ("uncheck") 
		ArrayList<JavaBeans> lista = (ArrayList) 
		request.getAttribute("contatos");
	
	%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="images/telefone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="botao1">Novo contato</a>
	<a href="report" class="botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getIdcontato()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td>
						<a href="select?idcontato=<%=lista.get(i).getIdcontato()%>" class="botao1">Editar</a>
						<a href="javascript: confirmar(<%=lista.get(i).getIdcontato()%>)" class="botao2">Excluir</a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>