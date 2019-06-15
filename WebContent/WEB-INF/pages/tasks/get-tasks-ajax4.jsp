<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<link type="text/css" href="resources/css/tasks.css" rel="stylesheet"></link>
	<script type="text/javascript" src="resources/js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<script type="text/javascript">
		
		function finalizar(id) {			
			$.post("finalizatask", {'id' : id}, function(response){
				$("#task_"+id).html(response);
				<!-- alert(response); -->
			});			
		}
	
	</script>

<a href="novatask">Inserir Nova Task</a>
<br /><br />
<table border="1">
	<tr>
		<th>Id</th>
		<th>Descrição</th>
		<th>Finalizada</th>
		<th>Data de Finalização</th>
		<th>Editar</th>
		<th>Excluir</th>
	</tr>
	<c:forEach items="${tasks}" var="task">
	<tr id="task_${task.id}">
		<td>${task.id}</td>
		<td>${task.descricao}</td>
		<c:if test="${task.finalizada eq false}">
			<td><a href="#" onclick="finalizar(${task.id})">Finalizar</a></td>
		</c:if>
		<c:if test="${task.finalizada eq true}">
			<td>Finalizada</td>
		</c:if>
		<td>
			<fmt:formatDate value="${task.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
		</td>
		<td><a href="buscartask?id=${task.id}">Editar</a></td>
		<td><a href="excluitask?id=${task.id}">Excluir</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>