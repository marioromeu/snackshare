<%@page pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>

<html>

	<head>

		<%@ include file="head.jsp" %>
	
	</head>
	
	<body class="home sticky-menu sidebar-off" id="top">

		<div class="hero">	
		    <div class="hero-inner">
		        <div class="inner">
		            <h1><span class="border border-top border-bottom">Erro !!!</span></h1>
		            <div class="hero-line-one"></div>
		            
		            <div class="hero-line-two">
		            	<span class="border border-bottom">
		            		Houve um erro inesperado no sistema.<br/>
		            		Entre em contato com o Administrador
		            	</span>
		            </div>
		        </div>
		
		        <a class="more-arrow" href="#content"><i class="fa fa-chevron-down"></i><span>Scroll Down</span></a>
		
		    </div>
		</div>
	
		<%@ include file="footer.jsp" %>
	
	</body>

</html>