<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de endereço</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                CADASTRO DE ENDEREÇOS
            </div>
            <div class="card-body">
                <form action="enderecos?acao=cadastrar" method="post">
                    <div class="form-group">
                        <label for="numeroCep">Numero do CEP</label>
                        <input type="text" name="numeroCep" id="numeroCep" class="form-control" maxlength="8" placeholder="Digite somente os numeros do CEP" required>
                    </div>
                    <div class="form-group">
                        <label for="numeroResidencia">Número da Residencia</label>
                        <input type="text" name="numeroResidencia" id="numeroResidencia" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="nomeRua">Nome da Rua</label>
                        <input type="text" name="nomeRua" id="nomeRua" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="complementoEndereco">Complemento do Endereço</label>
                        <input type="text" name="complementoEndereco" id="complementoEndereco" class="form-control">
                    </div>
                    <input type="submit" value="Salvar" class="btn btn-primary my-3">
                    <a href="enderecos?acao=listar" class="btn btn-secondary my-3">Visualizar lista de endereços</a>
                    <a href="index.jsp" class="btn btn-warning my-3">Voltar ao início</a>
                </form>
                <c:if test="${not empty message}">
                    <div class="alert alert-success" role="alert">
                            ${message}
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/bootstrap.bundle.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>

</body>
</html>