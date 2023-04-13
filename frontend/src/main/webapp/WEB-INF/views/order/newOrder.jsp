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
	
		<h2>Formulário de Cadastro de Usuário</h2>
		
		<div align="center">
		
			<form:form method="POST" action="/saveOrUpdateUser" modelAttribute="user">		
			
				<table>
					<tr>
						<td><form:label path="id">ID:</form:label></td>
						<td><form:input readonly="true" path="id" size="50"/></td>
					</tr>
					<tr>
						<td><form:label path="name">Nome:</form:label></td>
						<td><form:input path="name" size="50"/></td>
					</tr>
					<tr>
						<td><form:label path="username">Login:</form:label></td>
						<td><form:input path="username" size="50"/></td>
					</tr>
					<tr>
						<td><form:label path="password">Senha:</form:label></td>
						<td><form:password path="password" size="50"/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /></td>
					</tr>
				</table>
				
			</form:form>

		</div>
		
		<a href="/listUser">Lista</a>
	
		<%@ include file="../footer.jsp"%>
	
	</body>

</html>