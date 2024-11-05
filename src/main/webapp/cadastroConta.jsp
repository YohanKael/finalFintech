<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de contas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                CADASTRO DE CONTAS
            </div>
            <div class="card-body">
                <form action="contas?acao=cadastrar" method="post">
                    <div class="form-group">
                        <label for="id-saldo">Saldo</label>
                        <input type="text" name="saldo" id="id-saldo" class="form-control">
                    </div>
                    <div class="form-group">
                    <label for="dt_criacao_conta">Data de criacao da conta</label>
                    <input type="date" name="dt_criacao_conta" id="dt_criacao_conta" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="dt_encerramento_conta">Data de encerramento da conta</label>
                        <input type="date" name="dt_encerramento_conta" id="dt_encerramento_conta" class="form-control">
                    </div>
                    <input type="submit" value="Salvar" class="btn btn-primary my-3">
                    <a href="listaDeContas.jsp" class="btn btn-secondary my-3">Visualizar lista de contas</a>
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