
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.tads.pi3b.correios.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    double valorT = 0;
    int quantidade = 0;
%>
<!DOCTYPE html>
<html>
    <%@include  file="../../include/head.jsp" %>
    <body id="bg-home" class="cbp-spmenu-push">
        <%@include  file="../../include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12 resultado-cliente">
                    <h3>Relatório</h3>  
                    
                    <c:forEach var="e" items="${lista}">

                        ${valorT = valorT + e.getValor()}

                    </c:forEach>
                    
                    <table> 
                        <tr>
                            <td>Valor Total: R$ ${valorT}</td>
                            <td>Quantidade de Encomendas: ${lista.size()}</td>
                            <td>Entregues: </td>>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <%@include  file="../../include/footer.jsp" %>       
    </body>
</html>