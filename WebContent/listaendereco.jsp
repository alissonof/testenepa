<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt">
<head>

<title>Lista Endereço</title>
</head>
<body>

	<div align="center">
		<c:if test="${message != null}">
			<c:choose>
				<c:when test="${message.startsWith('Erro')}">
					<font color="red"><b>${message}</b> </font>
				</c:when>
				<c:otherwise>
					<font color="green"><b>${message}</b> </font>
				</c:otherwise>
			</c:choose>
		</c:if>
		<form id="excluirEndereco" name="excluirEndereco"  method="post" action="excluirendereco.do"
			method="post">
			<input type="hidden" name="id" id="id">
			<table width="80%" border="1">
				<tr>
					<th>Codigo</th>
					<th>CEP</th>
					<th>Rua</th>
					<th>Editar</th>
					<th>Excluir</th>
				</tr>
				<c:forEach var="end" items="${listaEndereco}">
					<tr>
						<td width="5%">${end.id}</td>
						<td width="10%">${end.cep}</td>
						<td width="55%">${end.rua}</td>
						<td width="5%"><a href="editarendereco.do?id=${end.id}">Editar</a></td>
						<td width="5%"><a href="#" onclick="excluir(${end.id})">Excluir</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<br>
		<br>
		<table>
			<tr><td><a href="index.jsp">Página Inicial</a></td></tr>
		</table>
	</div>
</body>

<script type="text/javascript">
	function excluir(id){
		if(confirm("Tem certeza que deseja excluir o endereço de "+id+"?")){
			 document.getElementById("id").value = id;
			 document.getElementById("excluirEndereco").submit();
		}
	}

</script>
</html>