<%@page import="br.senac.tads.pi3b.correios.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        String erro = "Por favor entre com um usuário";
        session.setAttribute("erro", erro);
        response.sendRedirect("index.jsp");
    }

    /*
    HttpSession sessao = request.getSession();
    sessao.setAttribute("usuario", usuario);
     */
%>

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
            <p class="p-white">Bem-vindo</p>
            <p class="p-white">${sessionScope.usuario.getNome()}</p>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
            <!--
                novo usuario (caso for admin)
                < %
                if (usuario.getPerfil().equals("admin")) {
                %>
                    <a href="${pageContext.request.contextPath}/novo-usuario.jsp">Novo usuário</a>
                < %
                }
                %>
            -->
            <a href="${pageContext.request.contextPath}/clientes.jsp">Cliente</a>
            <a href="${pageContext.request.contextPath}/encomenda.jsp">Encomenda</a>
            <a href="${pageContext.request.contextPath}/encomenda-busca.jsp">Rastreio</a>
            <%                if (usuario.getPerfil().equals("admin")) {
            %>   
            <a href="${pageContext.request.contextPath}/relatorio.jsp">Relatório</a>
            <%
                }
            %>

        </nav>
    </div>
</header>
<%
     Object err = session.getAttribute("erro");
    if (!(err==null)) {
        out.println("<p class='erro'>"+err+"</p>");
        session.removeAttribute("err");
        session.setAttribute("erro", null);
    }
%>