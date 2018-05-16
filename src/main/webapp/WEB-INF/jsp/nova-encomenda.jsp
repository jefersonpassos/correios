
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="../../include/head.jsp" %>
    <body id="bg-home">
        <%@include  file="../../include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12 novo-cliente">
                    <h1>Codigo de Rastreio${rastreio}</h1>
                    <h2>Encomenda criado com sucesso destino ${encomenda.getDestinatario().getEndereco()}</h2>
                </div>
            </div>
        </div>
    </body>
</html>