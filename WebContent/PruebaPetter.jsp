<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action='usuario' method="POST">
	<label for='name'>Nombre</label>
	<input id='name' type='text' name='nombreUsuario'><br>
	<label for='password'>Clave</label>
	<input id='password' type='text' name='password'><br>
	<input id=submit type='submit'>
	<input type="hidden" name="metodo" value="validar">
</form>

</body>
</html>