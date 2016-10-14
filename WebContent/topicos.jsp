<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Tela Tópicos</h1>
	<h1>Esses são os topicos feitos pelo usuario: ${usuario.nome}</h1>
	<form action="ServletControle">
		<table border="1" >
			<tr>
				<td>Titulo</td>
				<td>Autor</td>
			</tr>
			<c:forEach var="topico" items="${topicos}">
				<tr>
					<td>${topico.titulo}</td>
					<td>${topico.login}</td>
					<td><a href="ServletControle?logica=ExibeTopico&titulo=${topico.titulo}">Exibir Topico</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

	<h2>
		Para inserir um novo topico, clique <a href="insere-topico.html">
			aqui </a> ou para visualizar o rank de maiores pontuadores, clique <a
			href="rank.jsp"> aqui </a>
	</h2>



</body>
</html>
