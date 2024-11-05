<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edicao de contas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                EDIÇÃO DE CONTA
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
                        action="contas"
                        method="post">

                    <input
                            type="hidden"
                            value="editar"
                            name="acao"
                    >
                    <input
                            type="hidden"
                            value="${conta.id_conta}"
                            name="id_conta"
                    >

                    <div class="form-group">
                        <label
                                for="saldo">saldo
                        </label>
                        <input
                                type="text"
                                name="saldo"
                                id="saldo"
                                class="form-control"
                                value="${conta.saldo}"
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="dt_criacao_conta">dt_criacao_conta
                        </label>
                        <input
                                type="date"
                                name="dt_criacao_conta"
                                id="dt_criacao_conta"
                                class="form-control"
                                value="${dt_criacao_conta}"
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="dt_encerramento_conta">dt_encerramento_conta
                        </label>
                        <input
                                type="date"
                                name="dt_encerramento_conta"
                                id="dt_encerramento_conta"
                                class="form-control"
                                value="${dt_encerramento_conta}"
                        >
                    </div>
                    <input
                            type="submit"
                            value="Salvar"
                            class="btn btn-primary mt-3">
                    <a
                            href="contas?acao=listar"
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