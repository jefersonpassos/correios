
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="include/head.jsp" %>
    <body id="bg-home" class="cbp-spmenu-push">
        <%@include  file="include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12 menu">
                    <form action="${pageContext.request.contextPath}/encomenda-busca" method="get">
                        <div class ="col s12 m12 l6">
                            <input type="text" name="rastreio">
                        </div>
                        <div class ="col s12 m12 l6">
                            <button type="submit">Buscar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include  file="include/footer.jsp" %>       
    </body>
</html>