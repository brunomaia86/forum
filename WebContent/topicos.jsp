<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Tela Tópicos</h1>
	<h1>Esses são os topicos feitos pelo usuario: ${param.login}</h1>

	<table>
		<c:forEach var="topico" items="${topicos}">
			<tr>
				<td><a href="exibe-topico.jsp"> ${topico.titulo} </a></td>
				<td>${topico.nome}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>
