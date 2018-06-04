<%@page import="br.senac.tads.pi3b.correios.Encomenda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="../../include/head.jsp" %>
    <body id="bg-home">
        <%@include  file="../../include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12 resultado">
                    <h3>Codigo de Rastreio: ${rastreio}</h3>
                    <h4>Encomenda criado com sucesso destino: ${encomenda.getDestinatario().getEndereco()}</h4>
                </div>
            </div>
        </div>
        <%@include  file="../../include/footer.jsp" %>
    </body>
</html>