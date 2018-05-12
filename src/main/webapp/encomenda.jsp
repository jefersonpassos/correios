
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include  file="include/head.jsp" %>
<body id="bg-home">
    <%@include  file="include/header.jsp" %>
    <div class="container">
        <div class="row">
            <div class ="col s12 m12 l12 menu">
                <div class ="box col s12 m6 l3">
                    <a href="${pageContext.request.contextPath}/encomenda-form.jsp">
                        <div class="menu-clientes">
                            <i class="fas fa-box"></i>
                            <span>Novo Encomenda</span>
                        </div>
                    </a>
                </div>
                <div class ="box col s12 m6 l3">
                    <a href="${pageContext.request.contextPath}/busca-encomenda">
                        <div class="menu-encomenda">
                            <i class="fas fa-box-open"></i>
                            <span>Buscar Encomenda</span>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>