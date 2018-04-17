
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.tads.pi3b.correios.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

%>

<!DOCTYPE html>
<html>
    <%@include  file="../../include/head.jsp" %>
    <body id="bg-home">
        <%@include  file="../../include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12 resultado-cliente">
                    <table>   
                        <c:forEach var="c" items="${lista}">
                            <tr>
                                <td>ID: ${c.getIdCliente()}</td>
                                <td>Nome: ${c.nome}</td>
                                <td><a href="${pageContext.request.contextPath}/edita-cliente?idCliente=">Editar</a> | <a href="${pageContext.request.contextPath}/deleta-cliente?idCliente=${c.getIdCliente()}">Excluir</a></td>
                            </tr>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>