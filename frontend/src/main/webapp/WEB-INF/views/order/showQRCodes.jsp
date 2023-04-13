<%@page pageEncoding="ISO-8859-1"
	contentType="text/html; charset=ISO-8859-1" language="java"%>
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

		<table border="1">

			<tr>
				<td colspan="2">
					<BR> CHAVES MÚLTIPLAS CO-RELACIONADAS <BR> 
				</td> 
			</tr>

			<tr>

				<td colspan="2" align="center">					
					<table>
						<c:forEach var="actor" items="${actors}">
							<tr>
								<td>
									<c:out value="${actor.externalId}" />
								</td>	
								<td>
									<c:out value="${actor.externalIdDescription}" />
								</td>							
							</tr>
						</c:forEach>
					</table>
				</td>

			</tr>

		</table>

		<div>
        	<a href="/frontend/searchActorKeys">PESQUISAR OUTRA CHAVE</a>
        </div>


	</div>

	<%@ include file="../footer.jsp"%>

</body>

</html>