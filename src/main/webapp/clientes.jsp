
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
                        <a href="${pageContext.request.contextPath}/cliente-form.jsp">
                            <div class="menu-clientes">
                                <i class="fas fa-users"></i>
                                <span>Novo Cliente</span>
                            </div>
                        </a>
                    </div>
                    <div class ="box col s12 m6 l3">
                        <a href="${pageContext.request.contextPath}/busca-cliente">
                            <div class="busca-clientes">
                                <i class="fas fa-search"></i>
                                <span>Buscar Cliente</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <%@include  file="include/footer.jsp" %>       
    </body>
</html>