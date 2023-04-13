<%@page pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>

<html>

	<head>	
		<%@ include file="../head.jsp"%>	
	</head>	
	
	<body class="home sticky-menu sidebar-off" id="top">	
	
		<%@ include file="../menu.jsp"%>
	
		<%@ include file="../blank-space.jsp"%>
	
			<form:form method="POST" action="/frontend/processOrder" modelAttribute="order">
				<input type="submit" value="Processar Pedido" />
			</form:form>	
	
			<div align="center">
		
				<h1>Cadastro de Pedidos</h1>
		
				<form:form method="POST" action="/frontend/saveOrUpdateItemOnOrder" modelAttribute="item">	
					<label for="nome">Item:</label>
					<form:input path="name" size="50"/>
		
					<label for="valor">Valor:</label>
					<form:input path="value" size="20"/>
		
					<label for="nome">Dono:</label>
					<form:input path="ownerEmail" size="50"/>
		
					<label for="nome">Tipo:</label>
					<form:select path="signal">
					    <form:option value="-1"> Item </form:option>
					    <form:option value="-1"> Frete </form:option>
					    <form:option value="1">  Cupom </form:option>
					</form:select>
		
					<input type="submit" value="Adicionar">
		
				</form:form>
		
				<h2>Itens cadastrados</h2>
				<table>
					<tr>
						<th>Nome</th>
						<th>Valor</th>
						<th>Dono</th>				
						<th>Tipo</th>
						<th></th>
					</tr>
		
					<c:forEach items="${order.itemMap.entrySet()}" var="entry">
						<tr>
							<td>${entry.value.name}</td>
							<td>${entry.value.value}</td>
							<td>${entry.value.ownerEmail}</td>
							
					        <c:if test = "${entry.value.signal > 0}">
					       	  <td>
					         	<p> + <p>
					          </td>
					        </c:if>
		
					        <c:if test = "${entry.value.signal < 0}">
					          <td>
					          	<p> - <p>
					          </td>
					        </c:if>					
							
							<td>
								<form:form method="POST" action="/frontend/saveOrUpdateItemOnOrder" modelAttribute="item">
									<input type="hidden" name="id" value="${entry.value.id}" />
									<input type="submit" value="Editar" />
								</form:form>
								<form:form method="POST" action="/frontend/removeItemOnOrder" modelAttribute="item">
									<input type="hidden" name="id" value="${entry.value.id}" />
									<input type="submit" value="Remover" />
								</form:form>
							</td>
						</tr>
					</c:forEach>
		
				</table>
				
			</div>

		<%@ include file="../footer.jsp"%>

	</body>

</html>
