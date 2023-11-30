<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="images/telefone.png">
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>Editar contato</h1>
	<form name="formulario" action="update" id="formulario">
		<table>
			<tr>
				<td><input type="text" name="idcontato" class="caixa3"
					id="idcontato" readonly
					value="<%out.print(request.getAttribute("idcontato"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa2" id="nome"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="caixa2" id="fone"
					value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="caixa1"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="button" value="salvar" class="botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>

</html>