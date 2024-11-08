<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de telefone</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                CADASTRO DE TELEFONES
            </div>
            <div class="card-body">
                <form action="telefones?acao=cadastrar" method="post">
                    <div class="form-group">
                        <label for="nrCodigoPais">Código do País</label>
                        <input type="text" name="nrCodigoPais" id="nrCodigoPais" class="form-control" maxlength="8" placeholder="Digite o número do código do país" required>
                    </div>
                    <div class="form-group">
                        <label for="nrDdd">Número do DDD</label>
                        <input type="text" name="nrDdd" id="nrDdd" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="nrTelefone">Número do Telefone</label>
                        <input type="text" name="nrTelefone" id="nrTelefone" class="form-control" required>
                    </div>
                    <input type="submit" value="Salvar" class="btn btn-primary my-3">
                    <a href="telefones?acao=listar" class="btn btn-secondary my-3">Visualizar lista de telefones</a>
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