
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.tads.pi3b.correios.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include  file="../../include/head.jsp" %>
    <body id="bg-home">
        <%@include  file="../../include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12 resultado-cliente">
                    <table>   
                        <c:forEach var="e" items="${lista}">
                            <tr>
                                <td>Destinatario nome: ${e.getDestinatario().getNome()}</td>
                                <td>Endereço: ${e.getDestinatario().getEndereco()}</td>
                                <td>Cidade: ${e.getDestinatario().getCidade()}</td>
                                <td>CEP: ${e.getDestinatario().getCep()}</td>
                                <td>Peso Encomenda: ${e.getPeso3()}</td>
                                <td>Data Postagem: ${e.getDataPostagem()}</td>
                                <td>Data Entrega: ${e.getDataEntrega()}</td>
                                <td>Posiçao: ${e.getPosicao()}</td>
                                <td><a href="${pageContext.request.contextPath}/editar-encomenda?idEncomenda=${e.getId()}">Comfirmar entrega</a> | <a href="${pageContext.request.contextPath}/deleta-encomenda?idEncomenda=${e.getId()}">Excluir</a></td>
                            </tr>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <%@include  file="../../include/footer.jsp" %>       
    </body>
</html>