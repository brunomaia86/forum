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
		Topico:
		<p>${conteudo}</p>
		Postado por:
		<p>${usuario.nome}</p>
	</div>

	<div>
		<table border="0">
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
		<form action="InserirComentarioServlet">
			<div>
                Comentario: <input type="text" name="comentario" />
            </div>
			<div class="button">
                <input type="submit" value="Comentar" />
            </div>
		</form>
	</div>




</body>
</html>