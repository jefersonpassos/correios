
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
                    <form action="" method="post">
                        Nome: <input type="text" name="nome">
                        Sobrenome: <input type="text" name="sobrenome">
                        CPF: <input type="text" name="cpf">
                        RG: <input type="text" name="rg">
                        Endereço: <input type="text" name="endereco">
                        CEP: <input type="text" name="cep">
                        <select name="estados-brasil">
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
                        Cidade: <input type="text" name="cidade">
                        Email: <input type="text" name="email">
                        Telefone: <input type="text" name="telefone">
                        Celular: <input type="number" name="celular">
                        <button type="submit">Cadastrar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>