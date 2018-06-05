
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="include/head.jsp" %>
    <body id="bg-home" class="cbp-spmenu-push">
        <%@include  file="include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12">
                    <div class="form-cliente">
                        <form action="${pageContext.request.contextPath}/novo-cliente" method="post">
                            <div class="col s12 m12 l6">
                                Nome Completo: <input type="text" name="nome">
                                CPF: <input type="text" name="cpf">
                            </div>
                            <div class="col s12 m12 l6">
                                Telefone: <input type="text" name="telefone">
                                Email: <input type="email" name="email">
                            </div>
                            <div class="col s12 m12 l6">
                                Endereço: <input type="text" name="endereco">
                                CEP: <input type="text" name="cep">
                            </div>
                            <div class="col s12 m12 l6">
                                Estado: 
                                <select name="estado">
                                    
                                    <option value="PE">Pernambuco</option>
                                    
                                    <option value="RS">Rio Grande do Sul</option>
                                    
                                    <option value="SP">São Paulo</option>
                                    
                                </select>
                                Cidade: <input type="text" name="cidade">    
                            </div>
                            <div class="col s12 m12 l6">
                                <button type="submit">Cadastrar</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include  file="include/footer.jsp" %>       
    </body>
</html>