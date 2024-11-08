<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Investimentos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                CADASTRO DE INVESTIMENTOS
            </div>
            <div class="card-body">
                <form action="investimentos?acao=cadastrar" method="post">
                    <div class="form-group">
                        <label for="ds_investimentos">Descrição Investimento</label>
                        <input type="text" name="ds_investimentos" id="ds_investimentos" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label for="qt_valor_investimento">Valor Investimento</label>
                        <input type="text" name="qt_valor_investimento" id="qt_valor_investimento" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="dt_investimentos">Data do Investimento</label>
                        <input type="date" name="dt_investimentos" id="dt_investimentos" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="dt_retirada_investimentos">Data de Retirada do Investimento</label>
                        <input type="date" name="dt_retirada_investimentos" id="dt_retirada_investimentos" class="form-control">
                    </div>
                    <input type="submit" value="Salvar" class="btn btn-primary my-3">
                    <a href="investimentos?acao=listar" class="btn btn-secondary my-3">Visualizar lista de Investimentos</a>
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