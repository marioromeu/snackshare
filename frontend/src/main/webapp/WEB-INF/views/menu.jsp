<%@page pageEncoding="ISO-8859-1" contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<header class="header">
	
	    <div class="header-wrap">
	
	        <div class="logo plain logo-left">
	            <div class="site-title">
	                <a href="/frontend/home" title="Go to Home">Smart SIM</a>
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
                            <a href="#">Monitoria</a>
                            <ul class="sub-menu">
								<li class="menu-item">
                                    <a href="/frontend/dashboardOnlineServices">Dashboard</a>
                                </li>
                                <li class="menu-item">
                                    <a href="/frontend/goCatalog">Catalogo</a>
                                </li>                                
                                <li class="menu-item">
                                    <a href="/frontend/goConfig">Configuracoes</a>
                                </li>
                            </ul>
                        </li>
                        
                        <li class="menu-item">
                            <a href="#">Requests</a>
                            <ul class="sub-menu">
								<li class="menu-item">
                                    <a href="/frontend/dashboardRequests">Dashboard</a>
                                </li>                            
                             	<li class="menu-item">
                                    <a href="/frontend/listOriginRequestsReadOnly">Requests Pendentes</a>
                                </li>
								<li class="menu-item">
                                    <a href="/frontend/listOriginRequestsWithFail">Requets com Falhas</a>
                                </li>
								<li class="menu-item">
                                    <a href="/frontend/listOriginRequestsLocked">Requests Bloqueadas</a>
                                </li>
                            </ul>
                        </li>
                        
						<li class="menu-item">
                            <a href="#">Reactor</a>
                            <ul class="sub-menu">
								<li class="menu-item">
                                    <a href="/frontend/dashboardReactors">Dashboard</a>
                                </li>                                   
                                <li class="menu-item">
                                    <a href="/frontend/listReactors">Reactors nao Processados</a>
                                </li>
                                <li class="menu-item">
                                    <a href="/frontend/listBlockReactors">Bloqueios no Reactors</a>
                                </li>
                            </ul>
                        </li>  
                        
                        <li class="menu-item">
                            <a href="#">Atores</a>
                            <ul class="sub-menu">
                                <li class="menu-item">
                                    <a href="/frontend/searchActorKeys">Consulta das multiplas chaves</a>
                                </li>
								<li class="menu-item">
                                    <a href="/frontend/searchActor">Consulta de inventario</a>
                                </li>                                
                                <!--li class="menu-item">
                                    <a href="/frontend/listActor">Atualizar Caracteristicas</a>
                                </li-->                          
                            </ul>
                        </li>
                            
                        <li class="menu-item">
                            <a href="#">Impactos</a>
                            <ul class="sub-menu">
								<li class="menu-item">
                                    <a href="/frontend/dashboardDelivery">Dashboard</a>
                                </li>                                   
                                <li class="menu-item">
                                    <a href="/frontend/searchRequest">Listar Impactos por Request</a>
                                </li>                            
                                <li class="menu-item">
                                    <a href="/frontend/listDelivery">Listar ultimos Impactos</a>
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