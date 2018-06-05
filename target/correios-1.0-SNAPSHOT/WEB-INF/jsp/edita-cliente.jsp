<%@page import="br.senac.tads.pi3b.correios.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%


%>
<!DOCTYPE html>
<html>
    <%@include  file="../../include/head.jsp" %>
    <body id="bg-home" class="cbp-spmenu-push">
        <%@include  file="../../include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12">
                    <div class="form-cliente">
                        <form action="${pageContext.request.contextPath}/update-cliente" method="post">
                            <div class="col s12 m12 l6">
                                <input type="hidden" name="idCliente" value="${cliente.idCliente}">
                                Nome Completo: <input type="text" name="nome" value="${cliente.nome}">
                                CPF: <input type="text" name="cpf" value="${cliente.cpf}">
                            </div>
                            <div class="col s12 m12 l6">
                                Telefone: <input type="text" name="telefone" value="${cliente.telefone}">
                                Email: <input type="email" name="email" value="${cliente.email}">
                            </div>
                            <div class="col s12 m12 l6">
                                Endereço: <input type="text" name="endereco" value="${cliente.endereco}">
                                CEP: <input type="text" name="cep" value="${cliente.cep}">
                            </div>
                            <div class="col s12 m12 l6">
                                Estado: 
                                <select name="estado">
                                    <option value="${cliente.estado}">${cliente.estado}</option>
                                    
                                    <option value="PE">Pernambuco</option>
                                    
                                    <option value="RS">Rio Grande do Sul</option>
                                    
                                    <option value="SP">São Paulo</option>
                                    
                                </select>
                                Cidade: <input type="text" name="cidade" value="${cliente.cidade}">    
                            </div>

                            <div class="col s12 m12 l6">
                                <button type="submit">Editar</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include  file="../../include/footer.jsp" %>         
    </body>
</html>