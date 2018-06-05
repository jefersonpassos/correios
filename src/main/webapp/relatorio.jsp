
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="include/head.jsp" %>

    <body id="bg-home" class="cbp-spmenu-push">
        <%@include  file="include/header.jsp" %>
        <%
            if (!usuario.getPerfil().equals("admin")) {
                String erro = "Você não tem acesso a essa página";
                session.setAttribute("erro", erro);
                response.sendRedirect("home.jsp");
            }
        %>
        <div class="container">
            <div class="row menu">
                <div class ="col s12 m12 l12">
                    <div class="form-relatorio">
                        <form action="${pageContext.request.contextPath}/gerar-relatorio" method="post">
                            <input type="date" name="dataInicial" placeholder="Data Inicial">
                            <input type="date" name="dataFinal" placeholder="Data Final">
                            <input type="submit" value="gerar relatorio">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include  file="include/footer.jsp" %>       
    </body>
</html>