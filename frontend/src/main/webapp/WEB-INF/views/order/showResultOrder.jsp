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

				<table>

					<tr>
						<th>Dono</th>
						<th>Itens</th>
						<th>Total</th>
						<th>QRCODE</th>
					</tr>

					<c:forEach items="${frontendDTO.snackResponse.sharedValue.entrySet()}" var="entry">

						<tr>
							<td>${entry.key}</td>

							<td>
								<c:forEach items="${entry.value.itensList}" var="item">							
										${item.name} &nbsp; | &nbsp; ${item.value}							
								</c:forEach>								
							</td>

							<td>${entry.value.sharedValueByOwner}</td>

							<td>
								${frontendDTO.refundsResponse.qrCodeMap.get(entry.key)}								
								<img src="<c:out value="${frontendDTO.refundsResponse.qrCodeMap.get(entry.key)}" />" width="180" height="180"/>								
							</td>

						</tr>

					</c:forEach>

				</table>

			</div>

		<%@ include file="../footer.jsp"%>

	</body>

</html>
