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

			<tr align="center">
				<td>	ID				</td>
				<td>	Mdn				</td>
				<td>	CPF				</td>
				<td>	Client Type		</td>
				<td>	Imsi			</td>
				<td>	Last Update		</td>
				<td>	Request ID 		</td>
				<td>	Channel			</td>
				<td>	State			</td>
				<td>	SusState		</td>
			</tr>

			<tr align="center">
				<td>	${actor.id}					</td>
				<td>	${actor.msisdn}				</td>
				<td>	${actor.cpf}				</td>
				<td>	${actor.clientType}			</td>
				<td>	${actor.imsi}				</td>
				<td>	${actor.lastUpdateActor}	</td>
				<td>	${actor.rqstId}				</td>
				<td>	${actor.channelOriginId}	</td>
				<td>	${actor.state}				</td>
				<td>	${actor.susState}			</td>
			</tr>

			<tr> <td colspan="10"> </td> </tr>

			<tr>

				<td colspan="5" align="center">
					<BR> CARACTERÍSTICAS DO ATOR <BR>
					<table>
						<c:forEach var="characteristic" items="${actor.context.characteristics}">
							<tr>
								<td>
									<c:out value="${characteristic.key}" />
								</td>	
								<td>
									<c:out value="${characteristic.value.value}" />
								</td>							
								<c:if test="${characteristic.value.characteristics != null}">
									<c:if test="${characteristic.value.characteristics.size > 0 }">
										<td>
											<c:forEach var="subCharacteristic" items="${characteristic.value.characteristics}">
												<td>${subCharacteristic.key}</td>											
												<td>${subCharacteristic.value.value}</td>
											</c:forEach>
										</td>
									</c:if>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</td>

				<td colspan="5" align="center">
					<BR> SERVIÇOS DO ATOR <BR>
					<table border="0">
						<c:forEach var="service" items="${actor.context.services}">
							<tr>

								<td>
									${service.key}
								</td>
								
								<td>
									<c:if test="${service.value != null}">

										<c:if test="${service.value.characteristics['status'] == null}">
											${service.value.value}
										</c:if>
										
										<c:if test="${service.value.characteristics != null}">										
											<c:forEach var="subservice" items="${service.value.characteristics}">
												<td>${subservice.key}</td>											
												<td>
													${subservice.value.value}
												</td>
											</c:forEach>
										</c:if>

									</c:if>

								</td>

							</tr>
						</c:forEach>
					</table>
				</td>

			</tr>

		</table>

	</div>

	<%@ include file="../footer.jsp"%>

</body>

</html>