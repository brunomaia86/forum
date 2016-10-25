<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Topico</title>
</head>
<body>
	<h1>Tela Exibe Topico</h1>

	<div>
		<h3>Topico:</h3>
		<p>${conteudo}</p>
		<h3>Titulo:</h3>
		<p>${titulo}</p>
		<h3>Postado por:</h3>
		<p>${usuario.nome}</p>
	</div>

	<h2>Comentarios:</h2>

	<div>
		<table border="1">
			<tr>
				<td>Titulo</td>
				<td>Autor</td>
			</tr>
			<c:forEach var="comentario" items="${comentarios}">
				<tr>
					<td>${comentario.titulo}</td>
					<td>${comentario.login}</td>
				</tr>
			</c:forEach>
		</table>

		<h2>Insira seu Comentario:</h2>

		<form action="InserirComentarioServlet">
			<div>
				<textarea rows="4" cols="50" name="comentario">Entre com seu comentario...</textarea>
			</div>
			<div class="button">
				<input type="submit" value="Comentar" />
			</div>
		</form>
	</div>




</body>
</html>