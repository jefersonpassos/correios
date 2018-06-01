
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include  file="include/head.jsp" %>
    <body id="bg-home">
        <%@include  file="include/header.jsp" %>
        <div class="container">
            <div class="row">
                <div class ="col s12 m12 l12">
                    <div class="form-cliente">
                        <form action="${pageContext.request.contextPath}/nova-encomenda" method="post">
                            <div class="col s12 m12 l12">
                                CPF Cliente: <input type="text" name="cpf">
                            </div>
                            <div class="col s12 m12 l6">
                                Nome destinatário: <input type="text" name="nomed">
                                Endereço destinatário: <input type="text" name="enderecod">
                            </div>
                            <div class="col s12 m12 l6">
                                CEP destinatário: <input type="text" name="cepd">
                                Estado destinatário: 
                                <select name="estadod">
                                    <option value="AC">Acre</option>
                                    <option value="AL">Alagoas</option>
                                    <option value="AP">Amapá</option>
                                    <option value="AM">Amazonas</option>
                                    <option value="BA">Bahia</option>
                                    <option value="CE">Ceará</option>
                                    <option value="DF">Distrito Federal</option>
                                    <option value="ES">Espírito Santo</option>
                                    <option value="GO">Goiás</option>
                                    <option value="MA">Maranhão</option>
                                    <option value="MT">Mato Grosso</option>
                                    <option value="MS">Mato Grosso do Sul</option>
                                    <option value="MG">Minas Gerais</option>
                                    <option value="PA">Pará</option>
                                    <option value="PB">Paraíba</option>
                                    <option value="PR">Paraná</option>
                                    <option value="PE">Pernambuco</option>
                                    <option value="PI">Piauí</option>
                                    <option value="RJ">Rio de Janeiro</option>
                                    <option value="RN">Rio Grande do Norte</option>
                                    <option value="RS">Rio Grande do Sul</option>
                                    <option value="RO">Rondônia</option>
                                    <option value="RR">Roraima</option>
                                    <option value="SC">Santa Catarina</option>
                                    <option value="SP">São Paulo</option>
                                    <option value="SE">Sergipe</option>
                                    <option value="TO">Tocantins</option>
                                </select>
                            </div>
                            <div class="col s12 m12 l12">
                                Cidade destinatário: <input type="text" name="cidaded">   

                            </div>
                            <div class="col s12 m12 l12">
                                <div class="col s12 m4 l4">
                                    Comprimento encomenda: <input type="number" name="comprimento">   
                                </div>
                                <div class="col s12 m4 l4">
                                    Altura encomenda: <input type="number" name="altura">
                                </div>
                                <div class="col s12 m4 l4">
                                    Largura encomenda: <input type="number" name="largura">
                                </div>
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