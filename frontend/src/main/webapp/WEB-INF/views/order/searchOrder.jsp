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

		<form:form action="/frontend/getActor" modelAttribute="actor">

				External ID : <form:input path="externalId"/>

			<br>

			<form:select path="externalIdDescription">
				<form:option value="crmSubscribedId"></form:option>
				<form:option value="mdn"></form:option>
				<form:option value="imsi"></form:option>
			</form:select>

			<input type="submit" value="PESQUISAR" />

		</form:form>

	</div>

	<%@ include file="../footer.jsp"%>

</body>

</html>