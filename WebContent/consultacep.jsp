<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="/testeNetShoes/js/jquery-1.11.2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">

$(document).ready(function(){
	$('#loading').hide();
	$('#btnCep').click(function(){
		var cepV = $('#cep').val();
		if($.trim(cepV) == ""){
			$("#erroCep").html("<font color='red'><b>CEP não preenchido.</b> </font>");
		}else{
			$('#loading').show();
	   		$.getJSON("/servicocep/consulta/"+cepV, function (data) {
	    		$('#loading').hide();
	    		if(data.status == 0){
	    			$('#cep').val(data.cep);
	    			$("#rua").val(data.rua);
					$("#bairro").val(data.bairro);
					$("#cidade").val(data.cidade);
					$("#estado").val(data.estado);
					$("#erroCep").html("");
		    	}else{
		    		$("#erroCep").html("");
		    		$("#erroCep").html("<font color='red'><b>"+data.mensagem+"</b> </font>");
			  	}
					
			});
		}
	});
});


function submitForm(){
	document.getElementById("formSalvar").submit();
}
</script>
<title>Consulta CEP</title>
</head>
<body>
	
	<br>
	<br>
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
		<div id="erroCep"></div>
		<c:if test="${errors != null }">
			<c:forEach var="error" items="${errors}">
				<div>
					<font color="red"><b><li>${error.value}</li> </b> </font>
				</div>
			</c:forEach>
		</c:if>

		<form name="formSalvar" id="formSalvar" method="post" action="salvarendereco.do">
					<br>
			<table>
				<tr>
					<td><label class="texto">CEP:</label></td>
					<td><input type="text" id="cep" name="cep" maxlength="8"
						value="${cep}" size="7"> &nbsp;&nbsp; <input type="button" id="btnCep" 
								  value="Buscar" onclick="buscarCep();">
								  &nbsp;&nbsp;<img id="loading" src="/testeNetShoes/images/ajax-loader.gif"></td>
				</tr>

				<tr>
					<td><label class="texto">Rua:</label></td>
					<td><input type="text" id="rua" name="rua" size="40"
						maxlength="50" value="${rua}"></td>
				</tr>
				
				<tr>
					<td><label class="texto">Número:</label></td>
					<td><input type="text" id="numero" name="numero" size="4"
						maxlength="4" value="${numero}"></td>
				</tr>
				
				<tr>
					<td><label class="texto">Complemento:</label></td>
					<td><input type="text" id="complemento" name="complemento" size="40"
						maxlength="30" value="${complemento}"></td>
				</tr>

				<tr>
					<td><label class="texto">Bairro:</label></td>
					<td><input type="text" id="bairro" name="bairro"
						maxlength="50" value="${bairro}"></td>
				</tr>
				<tr>
					<td><label class="texto">Cidade:</label></td>
					<td><input type="text" id="cidade" name="cidade"
						maxlength="30" value="${cidade}"></td>
				</tr>
				<tr>
					<td><label class="texto">Estado:</label></td>
					<td><input type="text" id="estado" name="estado"
						maxlength="2" value="${estado}"></td>
				</tr>

				<tr>
					<td><button type="submit" id="salvar">Salvar</button></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>