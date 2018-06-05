<%-- 
    Document   : index
    Created on : Apr 3, 2018, 7:39:54 PM
    Author     : rdg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="include/head.jsp" %>
    <body id="login">

        <div class="container">
            <div class="row">		
                <h1>Astec <span>Aqui sua encomenda chega</span>	</h1>

                <%
                    Object err = session.getAttribute("erro");
                    if (!(err == null)) {
                        out.println("<p class='erro'>"+err+"</p>");
                        session.removeAttribute("erro");
                    }
                %>
                
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <input type="email" name="email">
                    <input type="password" name="senha">
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>