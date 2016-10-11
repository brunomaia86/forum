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
	<h1>Esses são os topicos feitos pelo usuario: ${param.login}</h1>
	
	<table border="1">
			<tr>
				<td>Titulo</td>
				<td>Autor</td>
			</tr>
			<c:forEach var="topicos" items="${topicos}">
				<tr>
					<td>${topicos.titulo}</td>
					<td>${aluno.login}</td>
					<td><a href="mvc?logica=ExibeTopico&login=${topico.login}">Exibir Topico</a></td>
				</tr>
			</c:forEach>
	</table>
	<h2>Para inserir um novo topico, clique <a href="insere-topico.jsp"> aqui </a> ou
	para visualizar o rank de maiores pontuadores, clique <a href="rank.jsp"> aqui </a></h2>
	
	<h1><a href="insere-topico.html"> aqui </a></h1>

</body>
</html>
