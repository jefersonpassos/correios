<%@page import="br.senac.tads.pi3b.correios.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <div class="container">
        <h1 class="logo"><a href="${pageContext.request.contextPath}/home.jsp">Astec</a></h1>
        <ul class="main">
            <li><i class="fas fa-user-circle"></i>
                ${sessionScope.usuario.getNome()}</li>
            <li><button id="showRightPush"><i class="fas fa-bars"></i></button></li>
        </ul>
        <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2">
            <h3>Menu</h3>
            <a href="${pageContext.request.contextPath}/clientes.jsp">Cliente</a>
            <a href="${pageContext.request.contextPath}/encomenda.jsp">Encomenda</a>
            <a href="${pageContext.request.contextPath}/rastreio.jsp">Rastreio</a>
            <%
                Usuario usuario = (Usuario)session.getAttribute("usuario");
                if (usuario.getPerfil().equals("admin")) {
            %>   
            <a href="${pageContext.request.contextPath}/relatorio.jsp">Relatório</a>
            <%
                }
            %>

        </nav>
    </div>
</header>