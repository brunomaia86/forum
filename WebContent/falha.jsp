<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Entre com as informações abaixo</h1>
	<form method="POST" action="login">
		Login: <input type="text" name="login" /> Senha: <input
			type="password" name="senha" /> <input type="submit" value="Logar" />
	</form>
	<h2>
		${erro} Verifique suas credenciais ou faça seu cadastro clicando <a
			href="cadastro.html"> aqui </a>.
	</h2>
</body>
</html>
