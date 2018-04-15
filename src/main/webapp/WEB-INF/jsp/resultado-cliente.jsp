
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="../../include/head.jsp" %>
    <body id="bg-home">
        <%@include  file="../../include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12 resultado-cliente">
                    <ul>
                        <c:forEach var="p" items="${lista}"
                            <li>
                                <h2>${p.nome}</h2>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>