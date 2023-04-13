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
		
		<div align="center">
		
				<c:if test="${not empty users}">
					<table border="1">
						<tr>
							<td>ID</td>
							<td>Nome</td>
							<td>Username</td>
							<td>Perfil</td>
							<td></td>
						</tr>
			
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.id}</td>
								<td>${user.name}</td>
								<td>${user.username}</td>
								<td>
									<c:forEach items="${user.profiles}" var="profile">
										${profile.name}<br/>
									</c:forEach>
								</td>
								<td>
									<a href="/editUser/${user.id}">EDITAR</a>
									<span>||</span>									
									<a href="/delUser/${user.id}">EXCLUIR</a>									
								</td>
							</tr>
						</c:forEach>
			
					</table>
				</c:if>
		
			<a href="/newUser">Cadastro</a>
			
		</div>
		
		<%@ include file="../footer.jsp"%>
	
	</body>

</html>