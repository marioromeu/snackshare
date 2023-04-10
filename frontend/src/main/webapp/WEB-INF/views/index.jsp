<%@page pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE HTML>

<html>

	<head>	
		<%@ include file="head.jsp"%>	
	</head>

	<body class="home sticky-menu sidebar-off" id="top">
	
		<div class="wrap full-wrap">

			<div class="main-wrap">

				<section class="main main-archive">

					<div class="loop">

						<article class="post format-gallery post_format-post-format-gallery">
	
							<div class="inner" align="center">

								<img src="/resources/images/logo_smartsim.jpg" width="300" height="30"/>
									
								<div class="post-content" align="center">

									<form:form method="POST" action="/frontend/login" modelAttribute="user">
									
										<table>
											<tr>
												<td><form:label path="username">Login:</form:label></td>
												<td><form:input path="username" size="50"/></td>
											</tr>
											<tr>
												<td><form:label path="password">Senha:</form:label></td>
												<td><form:password path="password" size="50"/></td>
											</tr>
											<tr style="color: black;">
												<td colspan="2" align="center" style="color: black;">
													<input type="submit" value="Submit" style="color: black;"/>
												</td>
											</tr>
										</table>

									</form:form>

								</div>
	
							</div>
	
						</article>
	
					</div>
	
				</section>
	
			</div>
	
		</div>
	
		<%@ include file="footer.jsp"%>
	
	</body>

</html>