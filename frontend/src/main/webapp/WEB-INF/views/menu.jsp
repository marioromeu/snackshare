<%@page pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<header class="header">
	
	    <div class="header-wrap">
	
	        <div class="logo plain logo-left">
	            <div class="site-title">
	                <a href="/frontend/home" title="Go to Home">Snack Share</a>
	            </div>
	        </div><!-- /logo -->


        <nav id="nav" role="navigation">
        
            <div class="table">
            
                <div class="table-cell">
                
                    <ul id="menu-menu-1">
                    
                        <li class="menu-item">
                            <a href="/frontend/home">Inicio</a>
                        </li>
                        
                        <li class="menu-item">
                            <a href="#">Pedido</a>
                            <ul class="sub-menu">
								<li class="menu-item">
                                    <a href="/frontend/newOrder">Realizar</a>
                                </li>
								<li class="menu-item">
                                    <a href="/frontend/findOrder">Consultar</a>
                                </li>                                
                            </ul>
                        </li>
                            
                        <li class="menu-item">
                            <a href="#">Ajuda</a>
                            <ul class="sub-menu">
                                <li class="menu-item">
                                    <a href="/frontend/contact">Entre em Contato</a>
                                </li>
                            </ul>                        
                        </li>

                    </ul>
                    
                </div>
                
            </div>
            
        </nav>
        
        <a href="#nav" class="menu-trigger"><i class="fa fa-bars"></i></a>

        <a href="#topsearch" class="search-trigger"><i class="fa fa-search"></i></a>

    </div>

</header>