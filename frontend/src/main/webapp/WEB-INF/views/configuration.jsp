<%@page pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" language="java"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>

<html>

	<head>	
		<%@ include file="head.jsp"%>	
	</head>	
	
	<body class="home sticky-menu sidebar-off" id="top">	
	
		<%@ include file="menu.jsp"%>
	
		<%@ include file="blank-space.jsp"%>
		
		<div align="center">
		
		<form:form method="POST" action="/saveOrUpdateConfiguration" modelAttribute="configuration">		
		
			<table>
				<tr>
					<td><form:label readonly="true" path="catalog">IP do Catalogo:</form:label></td>
					<td><form:input readonly="true" path="catalog" size="15"/></td>
				</tr>

				<tr>
					<td><form:label readonly="true" path="eventProcessor1">IP do Event Processor 1:</form:label></td>
					<td><form:input readonly="true" path="eventProcessor1" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="eventProcessor2">IP do Event Processor 2:</form:label></td>
					<td><form:input readonly="true" path="eventProcessor2" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="eventProcessor3">IP do Event Processor 3:</form:label></td>
					<td><form:input readonly="true" path="eventProcessor3" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="eventProcessor4">IP do Event Processor 4:</form:label></td>
					<td><form:input readonly="true" path="eventProcessor4" size="15"/></td>
				</tr>
				



				<tr>
					<td><form:label readonly="true" path="actor1">IP do Actor Context 1:</form:label></td>
					<td><form:input readonly="true" path="actor1" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="actor2">IP do Actor Context 2:</form:label></td>
					<td><form:input readonly="true" path="actor2" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="reactor1">IP do Provisioning Reactor 1:</form:label></td>
					<td><form:input readonly="true" path="reactor1" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="reactor2">IP do Provisioning Reactor 2:</form:label></td>
					<td><form:input readonly="true" path="reactor2" size="15"/></td>
				</tr>

				
				
				
				<tr>
					<td><form:label readonly="true" path="provisioner1">IP do Online Provisioner 1:</form:label></td>
					<td><form:input readonly="true" path="provisioner1" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="provisioner2">IP do Online Provisioner 2:</form:label></td>
					<td><form:input readonly="true" path="provisioner2" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="provisioner3">IP do Online Provisioner 3:</form:label></td>
					<td><form:input readonly="true" path="provisioner3" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="provisioner4">IP do Online Provisioner 4:</form:label></td>
					<td><form:input readonly="true" path="provisioner4" size="15"/></td>
				</tr>	
				
				
				
				
				<tr>
					<td><form:label readonly="true" path="jobs1">IP do Snack Share Jobs 1:</form:label></td>
					<td><form:input readonly="true" path="jobs1" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="jobs2">IP do Snack Share Jobs 2:</form:label></td>
					<td><form:input readonly="true" path="jobs2" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="jobs3">IP do Snack Share Jobs 3:</form:label></td>
					<td><form:input readonly="true" path="jobs3" size="15"/></td>
				</tr>
				<tr>
					<td><form:label readonly="true" path="jobs4">IP do Snack Share Jobs 4:</form:label></td>
					<td><form:input readonly="true" path="jobs4" size="15"/></td>
				</tr>
				
				
				
				<!--tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr-->



			</table>
			
		</form:form>
		
			
		</div>
		
		<%@ include file="footer.jsp"%>
	
	</body>

</html>