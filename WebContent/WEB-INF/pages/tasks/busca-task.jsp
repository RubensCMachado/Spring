<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<link type="text/css" href="resources/css/tasks.css" rel="stylesheet"></link>
<meta charset="ISO-8859-1">
<title>Editar Task</title>
</head>
<body>
	<h2>FEditar Task - ${task.id}</h2>
	<form action="editatask" method="post">
		<input type="hidden" name="id" value="${task.id}" />
		<h3>Descrição</h3><br />
		<textarea rows="5" cols="100" name="descricao">${task.descricao}</textarea>
		<br />Finalizada? <input type="checkbox" name="finalizada" value="true" ${task.finalizada ? 'checked' : '' } />
		<br /> Data de Finalização <br /> 
		<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${task.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>" /> 
		<input type="submit" value="Editar">	
	</form>
</body>
</html>