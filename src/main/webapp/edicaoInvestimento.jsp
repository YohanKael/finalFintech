<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edição de Investimentos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                EDIÇÃO DE INVESTIMENTOS
            </div>

            <c:if test="${not empty mensagem}">
                <div
                        class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}
                </div>
            </c:if>

            <c:if test="${not empty erro}">
                <div
                        class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}
                </div>
            </c:if>

            <div class="card-body">
                <form
                        action="investimentos"
                        method="post">

                    <input
                            type="hidden"
                            value="editar"
                            name="acao"
                    >
                    <input
                            type="hidden"
                            name="cd_investimentos"
                            id="cd_investimentos"
                            value="${param.cd_investimentos}"

                    >
                    <div class="form-group">
                        <label
                                for="ds_investimentos">Descrição do investimento
                        </label>
                        <input
                                type="text"
                                name="ds_investimentos"
                                id="ds_investimentos"
                                class="form-control"
                                value="${param.ds_investimentos}"
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="qt_valor_investimento">Valor Investido
                        </label>
                            <input
                                    type="text"
                                    name="qt_valor_investimento"
                                    id="qt_valor_investimento"
                                    class="form-control"
                                    value="${param.qt_valor_investimento}"
                            >
                    </div>
                    <div class="form-group">
                        <label
                                for="dt_investimentos">Data do investimento
                        </label>
                        <input
                                type="date"
                                name="dt_investimentos"
                                id="dt_investimentos"
                                class="form-control"
                                value="${param.dt_investimentos}"
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="dt_retirada_investimentos">Data de retirada do investimento
                        </label>
                        <input
                                type="date"
                                name="dt_retirada_investimentos"
                                id="dt_retirada_investimentos"
                                class="form-control"
                                value="${param.dt_retirada_investimentos}"
                        >
                    </div>
                    <input
                            type="submit"
                            value="Salvar"
                            class="btn btn-primary mt-3">
                    <a
                            href="investimentos?acao=listar"
                            class="btn btn-warning mt-3">Cancelar
                    </a>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/bootstrap.bundle.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>